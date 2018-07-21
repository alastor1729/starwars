package com.starwar.model

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
  url: URL) {

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
