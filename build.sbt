name := "scala-ddd-sample"

ThisBuild / version := "0.1"

ThisBuild / scalaVersion := "3.3.8"

lazy val core = (project in file("core"))
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.1.1"
    )
  )
