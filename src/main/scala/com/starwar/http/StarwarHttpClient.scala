package com.starwar.http

import akka.actor.ActorSystem
import akka.http.scaladsl.{Http, HttpExt}
import akka.http.scaladsl.model.{HttpEntity, HttpRequest}
import akka.http.scaladsl.unmarshalling._
import akka.stream.ActorMaterializer

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._
import com.starwar.model._

import scala.annotation.tailrec


object StarwarHttpClient {
  val planetsUrlPage1 = "https://swapi.co/api/planets/?page=1"
  val peopleUrlPage1 = "https://swapi.co/api/people/?page=1"
}

class StarwarHttpClient(implicit materializer: ActorMaterializer, ec: ExecutionContext, http: HttpExt) extends JsonSupport {
  import StarwarHttpClient._

  def recursiveGet[T](initialUrl: URL, getFn: String => Future[Response[T]]): Future[List[T]] = {
    def loop(url: URL, accum: List[T]): Future[List[T]] =
      getFn(url) flatMap {
        resp =>
          val newAccum = accum ++ resp.results
          if (resp.next.isEmpty) {
            Future.successful(newAccum)
          } else {
            loop(resp.next.get, newAccum)
          }
      }

    loop(initialUrl, List.empty[T])
  }

  def getPlanets: Future[List[Planet]] = recursiveGet(planetsUrlPage1, getPlanetsPerPage)

  def getPeople: Future[List[Person]] = recursiveGet(peopleUrlPage1, getPeoplePerPage)

  def getPlanetsPerPage(pageUrl: String): Future[PlanetsResponse] =
    for {
      response <- http.singleRequest(HttpRequest(uri = pageUrl))
      entity <- toPlanetsResponse(response.entity.toStrict(5 seconds))
    } yield entity

  def getPeoplePerPage(pageUrl: String): Future[PeopleResponse] =
    for {
      response <- http.singleRequest(HttpRequest(uri = pageUrl))
      entity <- toPeopleResponse(response.entity.toStrict(5 seconds))
    } yield entity

  def toPlanetsResponse(strictEntity: Future[HttpEntity.Strict]): Future[PlanetsResponse] =
    strictEntity flatMap { e => Unmarshal(e).to[PlanetsResponse]}

  def toPeopleResponse(strictEntity: Future[HttpEntity.Strict]): Future[PeopleResponse] =
    strictEntity flatMap { e => Unmarshal(e).to[PeopleResponse] }

}
