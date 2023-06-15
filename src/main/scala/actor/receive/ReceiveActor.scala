package actor.receive

import actor.Main.Main.logger
import actor.receive.BidRequest.BidRequest4Response
import actor.response.BidResponse.{BidResponse2Request, JustEndingMsg}
import org.json4s.DefaultFormats
import akka.actor.Actor
import org.json4s.jackson.JsonMethods._


case class ReceiveActor() extends Actor  {//extends Actor
  implicit val formats = DefaultFormats

  logger.info("execute ReceiveActor")

  def receive  = {
    case BidRequest4Response(reqBidString,responseActor) => {
      val requestBid_jValue = parse(reqBidString)
      val reqBidStringMap = requestBid_jValue.extract[Map[String, Any]]
      val deviceField2Map : Map[String,Any] = reqBidStringMap("device").asInstanceOf[Map[String, Any]]

      logger.info("User agent via field 'au' is:  "+deviceField2Map("ua"))

      val bidRequestId = reqBidStringMap("id")
      logger.info("Request id is: " + bidRequestId)
      responseActor ! BidResponse2Request(bidRequestId,sender())
    }
    case JustEndingMsg(endMsg) => {
      logger.info(endMsg)
      logger.info("end of circle")

    }
  }
  override def unhandled(message: Any): Unit = {
    logger.info(s"override def unhandled in Request **** $message")
  }

}
