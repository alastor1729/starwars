package com.starwar.utils

import com.starwar.model.Entity

object PrintUtil {
  val usage =
    """
       Usage: >run planetName

       Examples:
       >run Tatooine
       >run "Polis Massa"
    """.stripMargin

  def printToConsole[T <: Entity](title: String, es: List[T]=Nil): Unit = {
    println(s"$title: ${es.size}")
    es.sortBy(_.name) foreach println
    println()
  }

  def printUsage(): Unit = println(usage)
}
