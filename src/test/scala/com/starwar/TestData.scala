package com.starwar
import com.starwar.model.{JsonSupport, Person, Planet}


trait TestData extends JsonSupport {
  import spray.json._
  import com.starwar.TestData.{peopleJson, planetsJson}

  val people = peopleJson.parseJson.convertTo[List[Person]]
  val planets = planetsJson.parseJson.convertTo[List[Planet]]
}

object TestData {
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
}
