package actor.response

object BidResponse {



  trait Response
  case class BidResponse(id:String, seatBid:Array[SeatBid]) extends Response
  case class BidResponse4Request(res:BidResponse) extends Response
  case class SeatBid(bid:Array[Bid],seatBid:Array[SeatBid])
  case class Bid(id:String, impid:String, price:Float)
}
