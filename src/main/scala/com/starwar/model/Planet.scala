package com.starwar.model

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
                  url: URL) {

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
