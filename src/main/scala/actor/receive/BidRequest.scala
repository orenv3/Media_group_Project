package actor.receive

import actor.response.BidResponse.{BidResponse, Response}
import akka.actor.ActorRef
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import net.liftweb.json.Serialization.read

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
  case class BidRequest4Response (bidReqStringj:String,responseActor: ActorRef) extends Request
//  case class Imp(id:String,banner:Banner)
  case class Device(au:String,ip:String,pos:Int)

}


