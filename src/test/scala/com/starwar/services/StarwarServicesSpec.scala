package com.starwar.services

import com.starwar.TestData
import org.scalatest.{FlatSpec, Matchers}

class StarwarServicesSpec extends FlatSpec with Matchers with TestData {

  "getPeople" should "return a proper list of People names" in {
    val service = new StarwarServices(planets, people)

    val planetName = "Corellia"
    val peopleNames: List[String] = service.getPeople(planetName)
    peopleNames.sorted shouldBe List("Han Solo", "Wedge Antilles")


  }

}
