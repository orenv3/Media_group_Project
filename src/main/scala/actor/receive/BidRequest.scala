package actor.receive

import actor.response.BidResponse.Response
import akka.actor.typed.ActorSystem

object BidRequest{

  trait Request
  case class BidRequest (id:String,
                         imp:String,
                         site:String,
                         app:String,
                         device:String,
                         user:String,
                         test:String,
                         at:String,
                         tmax:String,
                         wseat:String,
                         bseat:String,
                         allimps:String,
                         cur:String,
                         wlang:String,
                         bcat:String,
                         badv:String,
                         bapp:String,
                         source:String,
                         regs:String,
                         ext:String) extends Request
  case class BidRequest4Response (bidReqStringj:String,responseActor: ActorSystem[Response]) extends Request
  case class JustEndingMsg(message:String) extends Request

}


