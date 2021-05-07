package models

import java.util.UUID
import slick.lifted.Tag
import slick.jdbc.SQLiteProfile.api._
case class Movie (
    id: Option[String] = Option(UUID.randomUUID.toString),
    title: String,
    year: Int,
    cover: String,
    description: String,
    duration: Int,
    contentRating: String,
    source: String,
    tags: Option[String]
)

class MovieTable(tag: Tag) extends Table[Movie](tag, "movie"){
    def id: Rep[String] = column[String]("id", O.PrimaryKey)
    def title: Rep[String] = column[String]("title")
    def year: Rep[Int] = column[Int]("year")
    def cover: Rep[String] = column[String]("cover")
    def description: Rep[String] = column[String]("description")
    def duration: Rep[Int] = column[Int]("duration")
    def contentRating: Rep[String] = column[String]("contentRating")
    def source: Rep[String] = column[String]("source")
    def tags: Rep[Option[String]] = column[Option[String]]("tags",O.Length(2000, varying = true))

    def * =
        (id.?, title, year, cover, description, duration, contentRating, source, tags) <> (Movie.tupled, Movie.unapply)
}