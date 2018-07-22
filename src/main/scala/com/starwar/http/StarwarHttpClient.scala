package com.starwar.http

import akka.http.scaladsl.HttpExt
import akka.http.scaladsl.model.{HttpEntity, HttpRequest, HttpResponse}
import akka.stream.ActorMaterializer

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._
import com.starwar.model._

abstract class StarwarHttpClient[T](implicit materializer: ActorMaterializer, ec: ExecutionContext, http: HttpExt) {

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

  def get(url: URL): Future[List[T]] = recursiveGet(url, getPerPage)

  def getPerPage(pageUrl: String): Future[Response[T]] =
    for {
      response <- http.singleRequest(HttpRequest(uri = pageUrl))
      entity <- toDomainResponse(response.entity.toStrict(5 seconds))
    } yield entity


  def toDomainResponse(strictEntity: Future[HttpEntity.Strict]): Future[Response[T]]

}
