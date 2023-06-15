ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"


lazy val root = (project in file("."))
  .settings(
    name := "actorTmpProject"
  )

mainClass := Some("actor.Main")


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.8.0",
  "com.typesafe.akka" %% "akka-actor-typed" % "2.8.0",
  "net.liftweb" %% "lift-json" % "3.5.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback" % "logback-classic" % "1.4.7",
  "org.json4s" %% "json4s-jackson" % "4.0.6"

  //"com.typesafe.play" %% "play-json" % "2.9.4"
  //
  //"net.liftweb" %% "lift-json" % "2.5+"
)

