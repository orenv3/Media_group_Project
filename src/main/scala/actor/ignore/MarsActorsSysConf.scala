/*
package actor.conf


import actor.receive.BidRequest.{BidRequest, Request}
import actor.response.BidResponse.BidResponse
import akka.actor.Props
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors

import scala.concurrent.Future

object MarsActorsSysConf {
  val system = ActorSystem(
    Behaviors.receiveMessage[Request] {
      msg : Request =>
        msg match {
          case BidRequest(id, imp, replyTo) => {
           // println(BidRequest.BidRequest(id,imp))
           val req = BidRequest(id,imp)
            context.actorOf(Props(Actor2), "ChildActor")
          //req ! BidResponse(req.id,null)
            Behaviors.same
           }

        }
    }
  )
 // val request = system.actorOf(Props[Greeter],"greeter")

}
*/
