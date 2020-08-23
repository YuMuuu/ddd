name := "scala-ddd-sample"

version := "0.1"

scalaVersion := "2.13.3"


lazy val core = (project in file("core"))

lazy val domain = (project in file("domain"))
  .dependsOn(core)