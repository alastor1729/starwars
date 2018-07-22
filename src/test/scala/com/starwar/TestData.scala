package com.starwar
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.starwar.model._

import scala.concurrent.ExecutionContext


trait TestData extends JsonSupport {
  import spray.json._
  import TestData._

  val people = peopleJson.parseJson.convertTo[List[Person]]
  val planets = planetsJson.parseJson.convertTo[List[Planet]]

  val peopleResponse = peopleResponseJson.parseJson.convertTo[PeopleResponse]
  val planetsResponse = planetsResponseJson.parseJson.convertTo[PlanetsResponse]
}

object TestData {

  object Implicits {
    implicit val system: ActorSystem = ActorSystem("StarWarServerTests")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val ec: ExecutionContext = system.dispatcher
  }

  val peopleJson =
    """
      |[
      |        {
      |            "name": "Han Solo",
      |            "height": "180",
      |            "mass": "80",
      |            "hair_color": "brown",
      |            "skin_color": "fair",
      |            "eye_color": "brown",
      |            "birth_year": "29BBY",
      |            "gender": "male",
      |            "homeworld": "https://swapi.co/api/planets/22/",
      |            "films": [
      |                "https://swapi.co/api/films/2/",
      |                "https://swapi.co/api/films/3/",
      |                "https://swapi.co/api/films/1/",
      |                "https://swapi.co/api/films/7/"
      |            ],
      |            "species": [
      |                "https://swapi.co/api/species/1/"
      |            ],
      |            "vehicles": [],
      |            "starships": [
      |                "https://swapi.co/api/starships/10/",
      |                "https://swapi.co/api/starships/22/"
      |            ],
      |            "created": "2014-12-10T16:49:14.582000Z",
      |            "edited": "2014-12-20T21:17:50.334000Z",
      |            "url": "https://swapi.co/api/people/14/"
      |        },
      |        {
      |            "name": "Greedo",
      |            "height": "173",
      |            "mass": "74",
      |            "hair_color": "n/a",
      |            "skin_color": "green",
      |            "eye_color": "black",
      |            "birth_year": "44BBY",
      |            "gender": "male",
      |            "homeworld": "https://swapi.co/api/planets/23/",
      |            "films": [
      |                "https://swapi.co/api/films/1/"
      |            ],
      |            "species": [
      |                "https://swapi.co/api/species/4/"
      |            ],
      |            "vehicles": [],
      |            "starships": [],
      |            "created": "2014-12-10T17:03:30.334000Z",
      |            "edited": "2014-12-20T21:17:50.336000Z",
      |            "url": "https://swapi.co/api/people/15/"
      |        },
      |        {
      |            "name": "Wedge Antilles",
      |            "height": "170",
      |            "mass": "77",
      |            "hair_color": "brown",
      |            "skin_color": "fair",
      |            "eye_color": "hazel",
      |            "birth_year": "21BBY",
      |            "gender": "male",
      |            "homeworld": "https://swapi.co/api/planets/22/",
      |            "films": [
      |                "https://swapi.co/api/films/2/",
      |                "https://swapi.co/api/films/3/",
      |                "https://swapi.co/api/films/1/"
      |            ],
      |            "species": [
      |                "https://swapi.co/api/species/1/"
      |            ],
      |            "vehicles": [
      |                "https://swapi.co/api/vehicles/14/"
      |            ],
      |            "starships": [
      |                "https://swapi.co/api/starships/12/"
      |            ],
      |            "created": "2014-12-12T11:08:06.469000Z",
      |            "edited": "2014-12-20T21:17:50.341000Z",
      |            "url": "https://swapi.co/api/people/18/"
      |        }
      |]
    """.stripMargin

  val planetsJson =
    """
      |[
      |{
      |    "name": "Corellia",
      |    "rotation_period": "25",
      |    "orbital_period": "329",
      |    "diameter": "11000",
      |    "climate": "temperate",
      |    "gravity": "1 standard",
      |    "terrain": "plains, urban, hills, forests",
      |    "surface_water": "70",
      |    "population": "3000000000",
      |    "residents": [
      |        "https://swapi.co/api/people/14/",
      |        "https://swapi.co/api/people/18/"
      |    ],
      |    "films": [],
      |    "created": "2014-12-10T16:49:12.453000Z",
      |    "edited": "2014-12-20T20:58:18.456000Z",
      |    "url": "https://swapi.co/api/planets/22/"
      |},
      |{
      |    "name": "Rodia",
      |    "rotation_period": "29",
      |    "orbital_period": "305",
      |    "diameter": "7549",
      |    "climate": "hot",
      |    "gravity": "1 standard",
      |    "terrain": "jungles, oceans, urban, swamps",
      |    "surface_water": "60",
      |    "population": "1300000000",
      |    "residents": [
      |        "https://swapi.co/api/people/15/"
      |    ],
      |    "films": [],
      |    "created": "2014-12-10T17:03:28.110000Z",
      |    "edited": "2014-12-20T20:58:18.458000Z",
      |    "url": "https://swapi.co/api/planets/23/"
      |}
      |]
    """.stripMargin

  val peopleResponseJson =
    """
      |{
      |    "count": 87,
      |    "next": null,
      |    "previous": "https://swapi.co/api/people/?page=1",
      |    "results": [
      |        {
      |           "name": "Luke Skywalker",
      |           "height": "172",
      |           "mass": "77",
      |           "hair_color": "blond",
      |           "skin_color": "fair",
      |           "eye_color": "blue",
      |           "birth_year": "19BBY",
      |           "gender": "male",
      |           "homeworld": "https://swapi.co/api/planets/1/",
      |           "films": [
      |             "https://swapi.co/api/films/2/",
      |             "https://swapi.co/api/films/6/",
      |             "https://swapi.co/api/films/3/",
      |             "https://swapi.co/api/films/1/",
      |             "https://swapi.co/api/films/7/"
      |           ],
      |           "species": [
      |             "https://swapi.co/api/species/1/"
      |           ],
      |           "vehicles": [
      |             "https://swapi.co/api/vehicles/14/",
      |             "https://swapi.co/api/vehicles/30/"
      |           ],
      |           "starships": [
      |             "https://swapi.co/api/starships/12/",
      |             "https://swapi.co/api/starships/22/"
      |           ],
      |           "created": "2014-12-09T13:50:51.644000Z",
      |           "edited": "2014-12-20T21:17:56.891000Z",
      |           "url": "https://swapi.co/api/people/1/"
      |        },
      |        {
      |            "name": "Wilhuff Tarkin",
      |            "height": "180",
      |            "mass": "unknown",
      |            "hair_color": "auburn, grey",
      |            "skin_color": "fair",
      |            "eye_color": "blue",
      |            "birth_year": "64BBY",
      |            "gender": "male",
      |            "homeworld": "https://swapi.co/api/planets/21/",
      |            "films": [
      |                "https://swapi.co/api/films/6/",
      |                "https://swapi.co/api/films/1/"
      |            ],
      |            "species": [
      |                "https://swapi.co/api/species/1/"
      |            ],
      |            "vehicles": [],
      |            "starships": [],
      |            "created": "2014-12-10T16:26:56.138000Z",
      |            "edited": "2014-12-20T21:17:50.330000Z",
      |            "url": "https://swapi.co/api/people/12/"
      |        }
      |    ]
      |}
    """.stripMargin

  val planetsResponseJson =
    """
      |{
      |    "count": 61,
      |    "next": null,
      |    "previous": null,
      |    "results": [
      |        {
      |            "name": "Tatooine",
      |             "rotation_period": "23",
      |             "orbital_period": "304",
      |             "diameter": "10465",
      |             "climate": "arid",
      |             "gravity": "1 standard",
      |             "terrain": "desert",
      |             "surface_water": "1",
      |             "population": "200000",
      |             "residents": [
      |               "https://swapi.co/api/people/1/",
      |               "https://swapi.co/api/people/2/",
      |               "https://swapi.co/api/people/4/",
      |               "https://swapi.co/api/people/6/",
      |               "https://swapi.co/api/people/7/",
      |               "https://swapi.co/api/people/8/",
      |               "https://swapi.co/api/people/9/",
      |               "https://swapi.co/api/people/11/",
      |               "https://swapi.co/api/people/43/",
      |               "https://swapi.co/api/people/62/"
      |             ],
      |             "films": [
      |               "https://swapi.co/api/films/5/",
      |               "https://swapi.co/api/films/4/",
      |               "https://swapi.co/api/films/6/",
      |               "https://swapi.co/api/films/3/",
      |               "https://swapi.co/api/films/1/"
      |             ],
      |             "created": "2014-12-09T13:50:49.641000Z",
      |             "edited": "2014-12-21T20:48:04.175778Z",
      |             "url": "https://swapi.co/api/planets/1/"
      |        }
      |    ]
      |}
    """.stripMargin

}
