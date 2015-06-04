package akkahttptwirl

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorFlowMaterializer, FlowMaterializer}
import stub.Foo

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object ExampleApp {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    implicit val mat = ActorFlowMaterializer()
    import system.dispatcher

    Http().bindAndHandle(route, "127.0.0.1", 8080)

    StdIn.readLine("Hit ENTER to exit")
    system.shutdown()
    system.awaitTermination()
  }

  def route(implicit ec: ExecutionContext, mat: FlowMaterializer) = {
    import TwirlMarshalling._

    path("html") {
      get {
        complete {
          html.twirl.render(Foo("html"))
        }
      }
    } ~ path("txt") {
      get {
        complete {
          txt.twirl.render(Foo("txt"))
        }
      }
    } ~ path("xml") {
      get {
        complete {
          xml.twirl.render(Foo("xml"))
        }
      }
    }
  }
}
