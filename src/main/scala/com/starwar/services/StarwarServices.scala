package com.starwar.services

import com.starwar.model.{Person, Planet, URL}

class StarwarServices(planets: List[Planet], people: List[Person]) {

  private val planet_name_people: Map[String, List[String]] =
    people.groupBy(_.homeworld).map {
      case (homeUrl, ps) => (toPlanetName(homeUrl), ps.map(_.name))
    }

  private def toPlanetName(homeUrl: URL): String =
    planets.find(_.url == homeUrl).map(_.name).getOrElse("No Planet Found")

  def getPeople(planetName: String): List[String] =
    planet_name_people.get(planetName).getOrElse(Nil)

}
