package actor.response


import actor.receive.BidRequest.{BidRequest, BidRequest4Response, Request}
import actor.response.BidResponse.{BidResponse, BidResponse2Request, Response}
import akka.actor.{Actor, ActorSystem, Props}
import net.liftweb.json.{Serialization, ShortTypeHints}
import net.liftweb.json.Serialization.write


case class ResponseActor() extends Actor {
//  val responseActorSys = ActorSystem("Mars-ResponseActor")
  implicit val format = Serialization.formats(ShortTypeHints(List( classOf[BidResponse])))

   def receive   = {
      case  BidResponse2Request(req,reqActor) => {
        val writeBidReq = Serialization.write(BidRequest(Some(""),Some("")))
        val bidRes4Req = BidResponse("response","From response")
         println("-------------------------")
         println("ResponseActor is executed")
        sender() ! bidRes4Req
      }
   /*   case BidRequest(id,imp) => {
        val bidRes4Req = BidRequest4Response(BidResponse.BidResponse(id,null))
        println("-------------------------")
        println("ResponseActor is executed ==> case BidRequest(id,imp) =>")
       // responseActorSys.actorOf(Props(ResponseActor()), "ResponseActor") ! bidRes4Req
      }*/

   }
  override def unhandled(message: Any): Unit = {
    println("override def unhandled in response ####")
  }
}
