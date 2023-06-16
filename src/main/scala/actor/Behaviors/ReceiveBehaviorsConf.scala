package actor.conf


import actor.Main.Main.logger
import actor.receive.BidRequest.{BidRequest4Response, Request,JustEndingMsg}
import actor.response.BidResponse.BidResponse2Request
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods._


object ReceiveBehaviorsConf {
  val system = ActorSystem
  implicit val formats = DefaultFormats
  logger.info("execute ReceiveActor")


  val receiveAct = system(Behaviors.receiveMessage[Request] { msg: Request =>
    msg match {
      case BidRequest4Response(reqBidString, responseActor) => {
        val requestBid_jValue = parse(reqBidString)
        val reqBidStringMap = requestBid_jValue.extract[Map[String, Any]]
        val deviceField2Map: Map[String, Any] = reqBidStringMap("device").asInstanceOf[Map[String, Any]]

        logger.info("User agent via field 'au' is:  " + deviceField2Map("ua"))

        val bidRequestId = reqBidStringMap("id")
        logger.info("Request id is: " + bidRequestId)
        responseActor ! BidResponse2Request(bidRequestId,responseActor)
      }
      case JustEndingMsg(endMsg) => {
        logger.info(endMsg)
        logger.info("end of circle")

      }
    }

    Behaviors.same

  },"ReceiveActor")

}
