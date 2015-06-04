package akkahttptwirl

import akka.http.scaladsl.marshalling.{PredefinedToEntityMarshallers, ToEntityMarshaller}
import akka.http.scaladsl.model.MediaTypes._
import akka.http.scaladsl.model.MediaType
import play.twirl.api.{ Xml, Txt, Html }

object TwirlMarshalling extends TwirlMarshalling

trait TwirlMarshalling {

  /** Serialize Twirl `Html` to `text/html`. */
  implicit val twirlHtmlMarshaller = twirlMarshaller[Html](`text/html`)

  /** Serialize Twirl `Txt` to `text/plain`. */
  implicit val twirlTxtMarshaller = twirlMarshaller[Txt](`text/plain`)

  /** Serialize Twirl `Xml` to `text/xml`. */
  implicit val twirlXmlMarshaller = twirlMarshaller[Xml](`text/xml`)

  /** Serialize Twirl formats to `String`. */
  private def twirlMarshaller[A <: AnyRef: Manifest](mediaTypes: MediaType  ): ToEntityMarshaller[A] =
    PredefinedToEntityMarshallers.stringMarshaller(mediaTypes)
      .compose(_.toString)
}
