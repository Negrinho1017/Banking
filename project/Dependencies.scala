import sbt._

object Dependencies {

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val slick = "com.typesafe.slick" %% "slick" % "3.2.3"
  lazy val playSlick =  "com.typesafe.play" %% "play-slick" % "3.0.0"
  lazy val playSlickEvolution = "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"
  lazy val postgres = "org.postgresql" % "postgresql" % "42.2.1"

}

