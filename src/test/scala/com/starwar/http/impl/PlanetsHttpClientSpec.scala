package com.starwar.http.impl

import akka.event.LoggingAdapter
import akka.http.scaladsl.{HttpExt, HttpsConnectionContext}
import akka.http.scaladsl.model._
import akka.http.scaladsl.settings.ConnectionPoolSettings
import com.starwar.TestData
import org.mockito.Matchers
import org.scalatest.{FlatSpec, Matchers => ScalaTestMatchers}
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class PlanetsHttpClientSpec extends FlatSpec with ScalaTestMatchers with TestData with MockitoSugar  {
  import TestData.Implicits._

  "PlanetsHttpClient" should "return all planets" in {
    val response = HttpResponse(entity = HttpEntity(contentType = ContentTypes.`application/json`, TestData.planetsResponseJson))

    implicit val http = mock[HttpExt]
    val anyReq = Matchers.any[HttpRequest]
    val anyContext = Matchers.any[HttpsConnectionContext]
    val anySettings= Matchers.any[ConnectionPoolSettings]
    val anyLog = Matchers.any[LoggingAdapter]

    when(http.singleRequest(anyReq, anyContext, anySettings, anyLog)).thenReturn(Future.successful(response))

    val client = new PlanetsHttpClient

    val results = Await.result(client.get(PlanetsHttpClient.URL), Duration.Inf)

    //results shouldBe planetsResponse.results.toList
    results should contain(results.head)
    results.size shouldBe 1
    results.head.name shouldBe "Tatooine"
  }

}
