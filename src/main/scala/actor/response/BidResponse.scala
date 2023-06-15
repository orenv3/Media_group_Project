package actor.response

import actor.receive.BidRequest.BidRequest
import akka.actor.ActorRef

object BidResponse {



  trait Response
  case class BidResponse(id:String, json:String) extends Response
  case class BidResponse2Request(request:BidRequest, reqActor:ActorRef) extends Response
//  case class SeatBid(bid:Array[Bid],seatBid:Array[SeatBid])
//  case class Bid(id:String, impid:String, price:Float)
}
