package com.starwar.http.impl

import akka.http.scaladsl.HttpExt
import akka.http.scaladsl.model.HttpEntity
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import com.starwar.http.StarwarHttpClient
import com.starwar.model.{JsonSupport, PeopleResponse, Person}

import scala.concurrent.{ExecutionContext, Future}

object PeopleHttpClient {
  val URL = "https://swapi.co/api/people/?page=1"
}

class PeopleHttpClient(implicit materializer: ActorMaterializer, ec: ExecutionContext, http: HttpExt) extends StarwarHttpClient[Person] with JsonSupport {

  def toDomainResponse(strictEntity: Future[HttpEntity.Strict]): Future[PeopleResponse] =
    strictEntity flatMap { e => Unmarshal(e).to[PeopleResponse]}

}
