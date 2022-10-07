name := """freelancer-play-soen-6441-project"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies ++= Seq("org.simple4j" % "WSClient" % "1.1.2", guice)

libraryDependencies += ws

libraryDependencies += ehcache
libraryDependencies += "org.mockito" % "mockito-core" % "4.1.0" % "test"

jacocoExcludes := Seq(
  "controllers.Reverse*",
  "controllers.javascript.*",
  "Module",
  "router.Routes*",
  "*.routes*"
)
