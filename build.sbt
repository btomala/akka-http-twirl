name := "akka-http-twirl"

scalaVersion := "2.12.1"
crossScalaVersions := Seq("2.11.8", "2.12.1")

organization := "btomala"

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

val akkaHttpV  = "10.0.1"
val playTwirlV = "1.3.0"
val scalaTestV = "3.0.1"

lazy val `akka-http-twirl` = (project in file(".")).enablePlugins(SbtTwirl, GitVersioning)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"  % akkaHttpV,
  "com.typesafe.play" %% "twirl-api"  % playTwirlV,
  "org.scalatest"     %% "scalatest"  % scalaTestV  % "test"
)
