package actor.receive

import actor.Main.Main.logger
import actor.receive.BidRequest.{BidRequest, BidRequest4Response}
import actor.response.BidResponse.{BidResponse, BidResponse4Request, SeatBid}
import actor.response.ResponseActor
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import net.liftweb.json.Serialization.read
import akka.actor.{Actor, ActorRef, ActorSystem, Props}


case class ReceiveActor() extends Actor  {//extends Actor
  implicit val formats = DefaultFormats
  val receiveActorSys = ActorSystem("Mars-ReceiveActor")
  val ref = receiveActorSys.actorOf(Props[ReceiveActor], "ReceiveActor")
  logger.info("Logger from Receive")
  def receive  = {
    case BidRequest(id,imp) => {
      val bidReq = BidRequest(id,imp)
val bidReq4Response = BidRequest4Response(BidResponse(bidReq.id,null))
     println("---------------")

      val writeBidReq = write(bidReq)
      println(s"BidRequest - receive - write(bidReq) writeBidReq: $writeBidReq")
      // val r = Serialization.read(bidReq,DefaultFormats.->(BidRequest) )
     // val sys = ActorSystem("fire-and-forget-sample")
      ref ! (bidReq4Response)//tell(BidRequest4Response,sender())

    }
    case BidResponse4Request(bidRes) => {
      val response = BidResponse(bidRes.id,bidRes.seatBid)
      val writeBidResponse = write(response)
      println(s"The response is: $response")
      println("end of circle")

    }
  }
  override def unhandled(message: Any): Unit = {
    println(s"override def unhandled in ReqUest **** $message")
  }
//  override def toJson(obj: ConvertRead2JsonTrait)


}
