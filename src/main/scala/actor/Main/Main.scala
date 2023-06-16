package actor.Main

import actor.Behaviors.ResponseBehaviorsConf.responseAct
import actor.conf.ReceiveBehaviorsConf.receiveAct
import actor.receive.BidRequest.{BidRequest4Response, JustEndingMsg}
import com.typesafe.scalalogging.Logger
import org.json4s.DefaultFormats

object Main extends App {
  val logger = Logger("MainLogger")
  logger.info("execute Main")
  implicit val formats = DefaultFormats

  private val jsonStringRequest =
    """{
      |"id": "requestId228888",
      |"at": 1,
      |"cur": [ "USD" ],
      |"imp": [
      |{
      |"id": "1",
      |"bidfloor": 0.03,
      |"banner": {
      |"h": 250,
      | "w": 300,
      |  "pos": 0
      |}
      |}
      |],
      |"site": {
      |"id": "102855",
      |"cat": [ "IAB3-1" ],
      |"domain": "www.foobar.com",
      |"page": "http://www.foobar.com/1234.html ",
      |"publisher": {
      |"id": "8953",
      |"name": "foobar.com",
      |"cat": [ "IAB3-1" ],
      |"domain": "foobar.com"
      |}
      |},
      |"device": {
      |"ua": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/537.13 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
      |"ip": "123.145.167.10"
      |},
      |"user": {
      |"id": "55816b39711f9b5acf3b90e313ed29e51665623f"
      |}
      |}""".stripMargin

  receiveAct ! BidRequest4Response(jsonStringRequest,responseAct)


}
