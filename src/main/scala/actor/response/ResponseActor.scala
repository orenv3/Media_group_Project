package actor.response


import actor.response.BidResponse.{JustEndingMsg,BidResponse, BidResponse2Request}
import akka.actor.Actor
import net.liftweb.json.Serialization.write
import net.liftweb.json.DefaultFormats


case class ResponseActor() extends Actor {
  implicit val formats = DefaultFormats
   def receive   = {
      case  BidResponse2Request(reqId,reqActor) => {
  val responseObj = BidResponse(reqId
    ,"seatbid: String"
    , "bidid: String"
    , "cur: String"
    ," customdata: String"
    , "nbr: String"
    , "ext: String")
        val writeBidResponse = write(responseObj)
         println("ResponseActor is executed")
        sender() ! JustEndingMsg("The Response object in json: \n"+writeBidResponse)
      }

   }
  override def unhandled(message: Any): Unit = {
    println("override def unhandled in response ####")
  }
}
