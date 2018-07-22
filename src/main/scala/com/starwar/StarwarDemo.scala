package com.starwar

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.starwar.http.impl.{PeopleHttpClient, PlanetsHttpClient}
import com.starwar.services.StarwarServices

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration

object StarwarDemo extends App {
  val usage =
    """
       Usage: >run planetName

       Examples:
       >run Tatooine
       >run "Polis Massa"
    """.stripMargin

  if (args.size != 1) {
    println(usage)
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
  val people = Await.result(futurePeople, Duration.Inf)

  println(s"total planets: ${planets.size}")
  println(s"planets in this response:")
  planets.sortBy(_.name) foreach println
  println()
  println()
  println(s"total people: ${people.size}")
  println(s"people in this response:")
  people.sortBy(_.name) foreach println
  println()

  val starwarServices = new StarwarServices(planets, people)

  val ps = starwarServices.getPeople(planetName)
  println(s"People on $planetName")
  ps foreach println

  //shut down app
  http.shutdownAllConnectionPools() andThen { case _ => system.terminate() }
}
