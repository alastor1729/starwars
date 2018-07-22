package com.starwar.services

import com.starwar.TestData
import org.scalatest.{FlatSpec, Matchers}

class StarwarServicesSpec extends FlatSpec with Matchers with TestData {

  "getPeople" should "return a proper list of People names" in {
    val service = new StarwarServices(planets, people)

    val planetName = "Corellia"
    val peopleNames: List[String] = service.getPeople(planetName)
    peopleNames.sorted shouldBe List("Han Solo", "Wedge Antilles")

    val planetName2 = "Rodia"
    val peopleNames2: List[String] = service.getPeople(planetName2)
    peopleNames2.sorted shouldBe List("Greedo")
  }

  it should "return Nil for not-existing Planet names" in {
    val service = new StarwarServices(planets, people)

    val planetName = "Corellia_2"
    val peopleNames: List[String] = service.getPeople(planetName)
    peopleNames shouldBe Nil

    val planetName2 = "Rodia_2"
    val peopleNames2: List[String] = service.getPeople(planetName2)
    peopleNames2 shouldBe Nil
  }

  "toPlanetName" should "return a Planet Name given a proper homeUrl" in {
    val service = new StarwarServices(planets, people)

    val homeUrl = "https://swapi.co/api/planets/22/"
    val planetName = service.toPlanetName(homeUrl)
    planetName shouldBe "Corellia"

    val homeUrl2 = "https://swapi.co/api/planets/23/"
    val planetName2 = service.toPlanetName(homeUrl2)
    planetName2 shouldBe "Rodia"
  }

  it should "return a 'No Planet Found' message given an improper homeUrl" in {
    val service = new StarwarServices(planets, people)

    val homeUrl = "https://swapi.co/api/planets/777/"
    val planetName = service.toPlanetName(homeUrl)
    planetName shouldBe "No Planet Found"
  }

}
