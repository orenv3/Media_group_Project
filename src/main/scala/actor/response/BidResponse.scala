package actor.response

import akka.actor.typed.ActorSystem

object BidResponse {

  trait Response
  case class BidResponse(id:Any,
                         seatbid:String,
                         bidid:String,
                         cur:String,
                         customdata:String,
                         nbr:String,
                         ext:String) extends Response
  case class BidResponse2Request(request:Any,responseActor:ActorSystem[Response]) extends Response

}
