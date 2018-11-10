package com.starwar.model

sealed trait Entity {
  val name: String
}
case class Person(
                   name: String,
                   height: String,
                   mass: String,
                   hair_color: String,
                   skin_color: String,
                   eye_color: String,
                   birth_year: String,
                   gender: String,
                   homeworld: URL,
                   films: Array[URL],
                   species: Array[URL],
                   vehicles: Array[URL],
                   starships: Array[URL],
                   created: String,
                   edited: String,
                   url: URL) extends Entity {

  override def toString: String =
    s"""
       |name: $name
       |height: $height
       |mass: $mass
       |hair_color: $hair_color
       |skin_color: $skin_color
       |eye_color: $eye_color
       |birth_year: $birth_year
       |gender: $gender
       |homeworld: $homeworld
       |films: ${films.mkString(", ")}
       |species: ${species.mkString(", ")}
       |vehicles: ${vehicles.mkString(", ")}
       |starships: ${starships.mkString(", ")}
       |created: $created
       |edited: $edited
       |url: $url
     """.stripMargin
}
case class Planet(name: String,
                  rotation_period: String,
                  orbital_period: String,
                  diameter: String,
                  climate: String,
                  gravity: String,
                  terrain: String,
                  surface_water: String,
                  population: String,
                  residents: Array[URL],
                  films: Array[URL],
                  created: String,
                  edited: String,
                  url: URL) extends Entity {

  override def toString: String =
    s"""
       |name: $name
       |rotation_period: $rotation_period
       |orbital_period: $orbital_period
       |diameter: $diameter
       |climate: $climate
       |gravity: $gravity
       |terrain: $terrain
       |surface_water: $surface_water
       |population: $population
       |residents: ${residents.mkString(", ")}
       |films: ${films.mkString(", ")}
       |created: $created
       |edited: $edited
       |url: $url
     """.stripMargin
}

case class People(people: List[Person])
case class Planets(planets: List[Planet])
