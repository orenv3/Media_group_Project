package actor.Behaviors

import actor.Main.Main.logger
import actor.conf.ReceiveBehaviorsConf.receiveAct
import actor.receive.BidRequest.JustEndingMsg
import actor.response.BidResponse.{BidResponse, BidResponse2Request, Response}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import net.liftweb.json.Serialization.write
import net.liftweb.json.DefaultFormats


object ResponseBehaviorsConf {
  val system = ActorSystem
  implicit val formats = DefaultFormats
  logger.info("execute ResponseActor")


  val responseAct = system(Behaviors.receiveMessage[Response] { msg: Response =>
    msg match {
      case BidResponse2Request(reqId,responseActor) => {
        logger.debug(s"The current response -> request id is: $reqId")
        val responseObj = BidResponse(reqId
          , "seatbid: String"
          , "bidid: String"
          , "cur: String"
          , " customdata: String"
          , "nbr: String"
          , "ext: String")
        val writeBidResponse = write(responseObj)
        receiveAct  ! JustEndingMsg("The Response object in json: \n" + writeBidResponse)
        logger.info("Message type JustEndingMsg sent")

      }

    }

    Behaviors.same

  },"ResponseActor")

}
