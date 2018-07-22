package com.starwar.utils

import com.starwar.StarwarDemo.{people, planets}

object PrintUtil {

  def printPlanetList(): Unit = {
    println(s"total planets: ${planets.size}")
    println(s"planets in this response:")
    planets.sortBy(_.name) foreach println
    println()
    println()
  }

  def printPeopleList(): Unit = {
    println(s"total people: ${people.size}")
    println(s"people in this response:")
    people.sortBy(_.name) foreach println
    println()
  }

}
