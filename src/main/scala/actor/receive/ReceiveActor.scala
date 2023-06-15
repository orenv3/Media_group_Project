package actor.receive

import actor.Main.Main.logger
import actor.receive.BidRequest.{BidRequest, BidRequest4Response}
import actor.response.BidResponse.{BidResponse, BidResponse2Request}
import net.liftweb.json._
import net.liftweb.json.Serialization.{formats, read, write}
import akka.actor.{Actor, ActorSystem, Props}


case class ReceiveActor() extends Actor  {//extends Actor
  //implicit val formats = DefaultFormats
  val receiveActorSys = ActorSystem("Mars-ReceiveActor")
  val ref = receiveActorSys.actorOf(Props[ReceiveActor], "ReceiveActor")
  logger.info("Logger from Receive")
  implicit val format = Serialization.formats(ShortTypeHints(List(classOf[BidRequest], classOf[BidResponse])))

  def receive  = {
    case BidRequest4Response(reqBid,responseActor) => {

      val bidReq = BidRequest(reqBid.id,reqBid.json)
//val bidReq4Response = BidRequest4Response(BidResponse(id,"{json object in response}"))
     println("---------------")
      val writeBidReq = write(bidReq)
      println(s"BidRequest - receive - write(bidReq) writeBidReq: $bidReq")
     /* println("---------------")

      val tst : BidRequest = read(
        """{
          |"id":"bidid123",
          |"json":"1"
          |}""".stripMargin)
      println(s"read string: $tst "  )*/
      responseActor ! BidResponse2Request(bidReq,sender())
      // val r = Serialization.read(bidReq,DefaultFormats.->(BidRequest) )
     // val sys = ActorSystem("fire-and-forget-sample")
      //ref ! (bidReq4Response)//tell(BidRequest4Response,sender())

    }
    case BidResponse(id,other) => {
      val response = BidResponse(id,other)
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
