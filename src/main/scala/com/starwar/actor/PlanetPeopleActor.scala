package com.starwar.actor

import akka.actor.Actor
import akka.pattern.pipe
import com.starwar.http.impl.{PeopleHttpClient, PlanetsHttpClient}
import com.starwar.model._
import com.starwar.services.StarwarServices

object PlanetPeopleActor {
  sealed trait Command
  object Initialization extends Command
  object TryAgain extends Command
  case class Population(planetName: String)
}

class PlanetPeopleActor(peopleClient: PeopleHttpClient, planetsClient: PlanetsHttpClient) extends Actor {
  import PlanetPeopleActor._
  import context.dispatcher

  var people = List.empty[Person]
  var planets = List.empty[Planet]
  var starwarServices: StarwarServices = _

  override def receive = {
    case Initialization =>
      peopleClient.get(PeopleHttpClient.URL).map(People(_)) pipeTo self
      planetsClient.get(PlanetsHttpClient.URL).map(Planets(_)) pipeTo self

    case People(ps) =>
      people = ps
      if (initializationDone) starwarServices = new StarwarServices(planets, people)

    case Planets(ps) =>
      planets = ps
      if (initializationDone) starwarServices = new StarwarServices(planets, people)

    case Population(planetName) =>
      if (initializationDone) sender ! starwarServices.getPeople(planetName)
      else TryAgain
  }

  def initializationDone: Boolean = ! people.isEmpty && ! planets.isEmpty

  def initializedState: Map[String, List[String]] =
    people.groupBy(_.homeworld).map {
      case (homeUrl, ps) => (toPlanetName(homeUrl), ps.map(_.name))
    }

  def toPlanetName(homeUrl: URL): String =
    planets.find(_.url == homeUrl).map(_.name).getOrElse("No Planet Found")

}
