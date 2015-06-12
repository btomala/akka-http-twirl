[![Build Status](https://travis-ci.org/btomala/akka-http-twirl.svg?branch=master)](https://travis-ci.org/btomala/akka-http-twirl)
[![Download](https://api.bintray.com/packages/btomala/maven/akka-http-twirl/images/download.svg) ](https://bintray.com/btomala/maven/akka-http-twirl/_latestVersion)

# akka-http-json #

Base on [spray/spray](https://github.com/spray/spray/blob/master/spray-httpx/src/main/scala/spray/httpx/TwirlSupport.scala) `TwirlSupport`

akka-http-twirl provides Twirl `Xml`, `Html` and `Txt` file marshalling support for [Akka](akka.io) HTTP.

## Installation

depend on akka-http version 1.0-RC3

Don't forget add twirl plugin.

```scala plugins.sbt 
addSbtPlugin("com.typesafe.sbt"  % "sbt-twirl"            % "1.1.1")
```

```scala build.sbt
resolvers += "Bartek's repo at Bintray" at "https://dl.bintray.com/btomala/maven"
lazy val myProject = (project in file(".")).enablePlugins(SbtTwirl)
libraryDependencies += "btomala" %% "akka-http-twirl" % "lastVersion"
```

## Usage

Mix `TwirlSupport` into your Akka HTTP code which is supposed to marshal Twirl `Html`, `Xml` or `Txt`.

For more details look in to `ExampleApp`.

## License ##

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
