lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.BinarySoftware",
      scalaVersion := "2.13.0"
    )),
    name := "ScalarStocks"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
