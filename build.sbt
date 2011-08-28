
name := "Basic Game Engine"

version := "1.0"

organization := "org.blackpanther"

scalaVersion := "2.9.1.RC4"

defaultExcludes ~= (filter => filter || "*~" )

scalacOptions ++= Seq("-deprecation","-explaintypes")

javacOptions ++= Seq("-source","1.7","-target","1.7")

shellPrompt := { state => System.getProperty("user.name") + "> " }

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.9.1.RC4"
