package com.starwar

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.starwar.http.impl.{PeopleHttpClient, PlanetsHttpClient}
import com.starwar.services.StarwarServices
import com.starwar.utils.PrintUtil

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration

object StarwarDemo extends App {
  import PrintUtil._

  if (args.size != 1) {
    printUsage()
    sys.exit(1)
  }
  val planetName = args(0)

  implicit val system: ActorSystem = ActorSystem("StarWarServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = system.dispatcher
  implicit val http = Http()

  val futurePeople = (new PeopleHttpClient).get(PeopleHttpClient.URL)
  val futurePlanets = (new PlanetsHttpClient).get(PlanetsHttpClient.URL)

  val planets = Await.result(futurePlanets, Duration.Inf)
  printToConsole("Planets", planets)

  val people = Await.result(futurePeople, Duration.Inf)
  printToConsole("People", people)

  // Merge the list of planet objects with the list of people objects into a new data structure
  val starwarServices = new StarwarServices(planets, people)
  val ps = starwarServices.getPeople(planetName)
  println(s"People on $planetName")
  ps foreach println

  //shut down app
  http.shutdownAllConnectionPools() andThen { case _ => system.terminate() }
}
