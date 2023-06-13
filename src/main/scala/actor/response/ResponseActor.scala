package actor.response


import actor.receive.BidRequest.{BidRequest, BidRequest4Response, Request}
import actor.response.BidResponse.Response
import akka.actor.{Actor, ActorSystem, Props}


case class ResponseActor() extends Actor {
  val responseActorSys = ActorSystem("Mars-ResponseActor")

   def receive   = {
      case  BidRequest4Response(res) => {
        val bidRes4Req = BidRequest4Response(res)
         println("-------------------------")
         println("ResponseActor is executed")
        responseActorSys.actorOf(Props(ResponseActor()), "ResponseActor") ! bidRes4Req
      }
      case BidRequest(id,imp) => {
        val bidRes4Req = BidRequest4Response(BidResponse.BidResponse(id,null))
        println("-------------------------")
        println("ResponseActor is executed ==> case BidRequest(id,imp) =>")
        responseActorSys.actorOf(Props(ResponseActor()), "ResponseActor") ! bidRes4Req
      }

   }
  override def unhandled(message: Any): Unit = {
    println("override def unhandled in response ####")
  }
}
