package com.starwar.http.impl

import akka.http.scaladsl.HttpExt
import akka.http.scaladsl.model.HttpEntity
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import com.starwar.http.StarwarHttpClient
import com.starwar.model.{JsonSupport, Planet, PlanetsResponse}

import scala.concurrent.{ExecutionContext, Future}

object PlanetsHttpClient {
  val URL = "https://swapi.co/api/planets/?page=1"
}

class PlanetsHttpClient(implicit materializer: ActorMaterializer, ec: ExecutionContext, http: HttpExt) extends StarwarHttpClient[Planet] with JsonSupport {

  def toDomainResponse(strictEntity: Future[HttpEntity.Strict]): Future[PlanetsResponse] =
    strictEntity flatMap { e => Unmarshal(e).to[PlanetsResponse]}

}
