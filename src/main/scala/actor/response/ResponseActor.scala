package actor.response


import actor.Main.Main.logger
import actor.response.BidResponse.{BidResponse, BidResponse2Request, JustEndingMsg}
import akka.actor.Actor
import net.liftweb.json.Serialization.write
import net.liftweb.json.DefaultFormats


case class ResponseActor() extends Actor {
  implicit val formats = DefaultFormats
  logger.info("execute ResponseActor ")
  def receive   = {
      case  BidResponse2Request(reqId,reqActor) => {
        logger.debug(s"The current response -> request id is: $reqId")
  val responseObj = BidResponse(reqId
    ,"seatbid: String"
    , "bidid: String"
    , "cur: String"
    ," customdata: String"
    , "nbr: String"
    , "ext: String")
        val writeBidResponse = write(responseObj)
        sender() ! JustEndingMsg("The Response object in json: \n"+writeBidResponse)
        logger.info("Message type JustEndingMsg sent")
      }

   }
  override def unhandled(message: Any): Unit = {
    logger.info("override def unhandled in response ####")
  }
}
