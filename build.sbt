name := "akka-http-twirl"

scalaVersion := "2.11.7"

organization := "btomala"

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

val akkaHttpV  = "2.0.3"
val scalaTestV = "2.2.6"
val playTwirlV = "1.1.1"

lazy val `akka-http-twirl` = (project in file(".")).enablePlugins(SbtTwirl, GitVersioning)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental"          % akkaHttpV,
  "com.typesafe.play" %% "twirl-api"                       % playTwirlV
) ++ Seq(
  "org.scalatest"     %% "scalatest"                       % scalaTestV % "test"
)