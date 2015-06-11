name := "akka-http-twirl"

scalaVersion := "2.11.6"

val akkaHttpV  = "1.0-RC3"
val scalaTestV = "2.2.5"
val playTwirlV = "1.1.1"

lazy val `akka-http-twirl` = (project in file(".")).enablePlugins(SbtTwirl, GitVersioning)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental"          % akkaHttpV,
  "com.typesafe.play" %%  "twirl-api"                      % playTwirlV
) ++ Seq(
  "org.scalatest"     %% "scalatest"                       % scalaTestV % "test"
)