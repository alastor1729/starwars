package com.starwar

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer
import com.starwar.actor.PlanetPeopleActor
import com.starwar.actor.PlanetPeopleActor.Population
import com.starwar.http.impl.{PeopleHttpClient, PlanetsHttpClient}

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object StarwarDemo extends App {
  import akka.pattern.ask
  import akka.util.Timeout
  import scala.concurrent.duration._
  import Directives._

  implicit val timeout = Timeout(30 seconds)
  implicit val system: ActorSystem = ActorSystem("StarWarServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = system.dispatcher
  implicit val http = Http()

  val timeOut = Duration(2, MINUTES)

  val props = Props(classOf[PlanetPeopleActor], new PeopleHttpClient, new PlanetsHttpClient)
  val stateActor = system.actorOf(props)
  stateActor ! PlanetPeopleActor.Initialization

  val route =
    get {
      path("starwars") {
        parameter("planetName".as[String]) { name =>
          onSuccess((stateActor ? Population(name)).mapTo[List[String]]) { results =>
            complete(results.mkString("\n"))
          }
        }
      }
    }

  val bindingFuture = http.bindAndHandle(route, "localhost", 8080)

  println("Server online at http://localhost:8080/starwars\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap { _.unbind() }
    .onComplete {
      _ => http.shutdownAllConnectionPools() andThen { case _ => system.terminate() }
    }

}
