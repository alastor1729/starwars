package com.starwar.model


sealed trait Response[T] {
  def count: Int
  def next: Option[URL]
  def previous: Option[URL]
  def results: Array[T]
}
case class PeopleResponse(count: Int, next: Option[URL], previous: Option[URL], results: Array[Person]) extends Response[Person]
case class PlanetsResponse(count: Int, next: Option[URL], previous: Option[URL], results: Array[Planet]) extends Response[Planet]
