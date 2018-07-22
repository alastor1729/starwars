package com.starwar.http.impl

import akka.event.LoggingAdapter
import akka.http.scaladsl.{HttpExt, HttpsConnectionContext}
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpRequest, HttpResponse}
import akka.http.scaladsl.settings.ConnectionPoolSettings
import com.starwar.TestData
import org.mockito.Matchers
import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers => ScalaTestMatchers}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class PeopleHttpClientSpec extends FlatSpec with ScalaTestMatchers with TestData with MockitoSugar {

  import TestData.Implicits._

  "PeopleHttpClient" should "return all people" in {
    val response = HttpResponse(entity = HttpEntity(contentType = ContentTypes.`application/json`, TestData.peopleResponseJson))

    implicit val http = mock[HttpExt]
    val anyReq = Matchers.any[HttpRequest]
    val anyContext = Matchers.any[HttpsConnectionContext]
    val anySettings= Matchers.any[ConnectionPoolSettings]
    val anyLog = Matchers.any[LoggingAdapter]

    when(http.singleRequest(anyReq, anyContext, anySettings, anyLog)).thenReturn(Future.successful(response))

    val client = new PeopleHttpClient

    val results = Await.result(client.get(PeopleHttpClient.URL), Duration.Inf)

    //results shouldBe peopleResponse.results.toList
    results should contain(results.head)
    results.size shouldBe 2
    results.head.name shouldBe "Luke Skywalker"
  }

}
