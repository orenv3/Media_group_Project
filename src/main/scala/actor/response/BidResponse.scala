package actor.response

import actor.receive.BidRequest.BidRequest
import akka.actor.ActorRef

object BidResponse {



  trait Response
  case class BidResponse(id:Any,
                         seatbid:String,
                         bidid:String,
                         cur:String,
                         customdata:String,
                         nbr:String,
                         ext:String) extends Response
  case class BidResponse2Request(request:Any, reqActor:ActorRef) extends Response
  case class JustEndingMsg(message:String)
}
