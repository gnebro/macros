name := "macros"

version := "1.0"

val commonSettings = Seq(
  scalaVersion := "2.12.1"
)
lazy val root = (project in file(".")).aggregate(definitions, usage)

lazy val definitions = (project.in(file("macrosDef")))
  .settings(commonSettings: _*)
  .settings(
    name := "macrosDef",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % "2.12.1"
    )
  )

lazy val usage = (project.in(file("macrosUsage")))
  .dependsOn(definitions)
  .settings(commonSettings: _*)
  .settings(
    name := "macrosUsage",
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.0.1"
    ) ++ Seq(
      "org.scalacheck" %% "scalacheck" % "1.13.4",
      "org.scalatest" %% "scalatest" % "3.0.1"
    ).map(_ % Test)
  )



    