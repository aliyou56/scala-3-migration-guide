import Version._

lazy val `sbt-migration-tutorial` = project
  .in(file("sbt-migration-tutorial"))
  .settings(
    scalaVersion := dotty,
    crossScalaVersions := Seq(scala213, dotty),
    libraryDependencies ++= Seq(
      "org.typelevel" % "cats-core_2.13" % "2.1.1",
      "com.lihaoyi" % "os-lib_0.27" % "0.7.1",
      "com.lihaoyi" %% "sourcecode" % "0.2.1"
    ),
    scalacOptions ++= {
      if (isDotty.value) Seq(
        "-encoding",
        "UTF-8",
        "-feature",
        "-unchecked",
        "-language:implicitConversions",
        // "-Xfatal-warnings",
      ) else Seq(
        "-encoding",
        "UTF-8",
        "-feature",
        "-deprecation",
        "-language:implicitConversions",
        "-Xfatal-warnings",
        "-Wunused:imports,privates,locals",
        "-Wvalue-discard"
      )
    },
    scalacOptions ++= { 
      if (isDotty.value) Seq("-source:3.0-migration")
      else Seq.empty
    }
  )