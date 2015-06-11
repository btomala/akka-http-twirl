package akkahttptwirl

import akka.actor.ActorSystem
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model.{HttpCharsets, MediaTypes, ResponseEntity}
import akka.stream.ActorFlowMaterializer
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt



class TwirlSupportSpec extends WordSpec with TwirlSupport with Matchers with BeforeAndAfterAll {
  import stub.Foo

  val foo = Foo("Bar")
  val timeout = 100 millis

  implicit val system = ActorSystem()
  implicit val materializer = ActorFlowMaterializer()

  "TwirlMarshalling" should {
    "be enable to marshal twirl.scala.html to String" in {
      val entity = Await.result(Marshal(html.twirl.render(foo)).to[ResponseEntity].flatMap(_.toStrict(timeout)), timeout)
      entity.contentType.mediaType shouldBe MediaTypes.`text/html`
      entity.contentType.charset shouldBe HttpCharsets.`UTF-8`
      entity.data.decodeString("UTF-8") should include ("<h1>Welcome Bar!</h1>")
      }
    "be enable to marshal twirl.scala.txt to String" in {
      val entity = Await.result(Marshal(txt.twirl.render(foo)).to[ResponseEntity].flatMap(_.toStrict(timeout)), timeout)
      entity.contentType.mediaType shouldBe MediaTypes.`text/plain`
      entity.contentType.charset shouldBe HttpCharsets.`UTF-8`
      entity.data.decodeString("UTF-8") should include ("Welcome Bar!")
      }
    "be enable to marshal twirl.scala.xml to String" in {
      val entity = Await.result(Marshal(xml.twirl.render(foo)).to[ResponseEntity].flatMap(_.toStrict(timeout)), timeout)
      entity.contentType.mediaType shouldBe MediaTypes.`text/xml`
      entity.contentType.charset shouldBe HttpCharsets.`UTF-8`
      entity.data.decodeString("UTF-8") should include ("<welcome>Bar</welcome>")
      }
    }

  override def afterAll(){
    system.shutdown()
    system.awaitTermination()
    super.afterAll()
  }
}
