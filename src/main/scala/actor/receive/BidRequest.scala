package actor.receive

import actor.response.BidResponse.{BidResponse, Response}
import akka.actor.ActorRef
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import net.liftweb.json.Serialization.read

object BidRequest{

  trait Request
  case class BidRequest (id:Option[String],json:Option[String]) extends Request
  case class BidRequest4Response (bidReqObj:BidRequest,responseActor: ActorRef) extends Request
  case class Imp(id:String,banner:Banner)
  case class Banner(w:Int,h:Int,pos:Int)

}


