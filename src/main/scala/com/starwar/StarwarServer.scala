package com.starwar

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.starwar.http.StarwarHttpClient

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration

object StarwarServer extends App {
  implicit val system: ActorSystem = ActorSystem("StarWarServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = system.dispatcher
  implicit val http = Http()

  val httpClient = new StarwarHttpClient

  val planets = Await.result(httpClient.getPlanets, Duration.Inf)
  val people = Await.result(httpClient.getPeople, Duration.Inf)

  println(s"total planets: ${planets.size}")
  println(s"planets in this response:")
  planets.sortBy(_.name) foreach println
  println()
  println()
  println(s"total people: ${people.size}")
  println(s"people in this response:")
  people.sortBy(_.name) foreach println
  println()

  //Await.result(system.whenTerminated, Duration.Inf)
}
