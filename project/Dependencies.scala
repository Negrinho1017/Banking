import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val slick = "com.typesafe.slick" %% "slick" % "3.2.3"
  lazy val postgres = "org.postgresql" % "postgresql" % "9.3-1100-jdbc4"
  lazy val sl4j = "org.slf4j" % "slf4j-nop" % "1.6.4"
}
