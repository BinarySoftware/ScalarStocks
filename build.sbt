lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.BinarySoftware"
    )),
    name := "ScalarStocks"
  )

val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "io.circe"  %% "circe-core"     % circeVersion,
  "io.circe"  %% "circe-generic"  % circeVersion,
  "io.circe"  %% "circe-parser"   % circeVersion,
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)