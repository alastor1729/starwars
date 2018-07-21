package com.starwar.model

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val personJsonFormat: RootJsonFormat[Person] = jsonFormat16(Person)
  implicit val planetJsonFormat: RootJsonFormat[Planet] = jsonFormat14(Planet)
  implicit val planetsRespJsonFormat: RootJsonFormat[PlanetsResponse] = jsonFormat4(PlanetsResponse)
  implicit val peopleRespJsonFormat: RootJsonFormat[PeopleResponse] = jsonFormat4(PeopleResponse)

}
