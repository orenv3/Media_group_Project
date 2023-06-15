package actor.receive

import actor.Main.Main.logger
import actor.receive.BidRequest.BidRequest4Response
import actor.response.BidResponse.{BidResponse2Request, JustEndingMsg}
import org.json4s.DefaultFormats
import akka.actor.Actor
import org.json4s.jackson.JsonMethods._


case class ReceiveActor() extends Actor  {//extends Actor
  implicit val formats = DefaultFormats

  logger.info("Logger from Receive")

  def receive  = {
    case BidRequest4Response(reqBidString,responseActor) => {
      val requestBid_jValue = parse(reqBidString)
      val reqBidStringMap = requestBid_jValue.extract[Map[String, Any]]
      val deviceField2Map : Map[String,Any] = reqBidStringMap("device").asInstanceOf[Map[String, Any]]

      logger.info("User agent via field 'au' is:  "+deviceField2Map("ua"))
      println("---------------")

      val bidRequestId = reqBidStringMap("id")
      logger.info("Request id is: " + bidRequestId)
      println("---------------")
      responseActor ! BidResponse2Request(bidRequestId,sender())
    }
    case JustEndingMsg(endMsg) => {
      println(s"The response from Response Actor is: $endMsg")
      println("end of circle")

    }
  }
  override def unhandled(message: Any): Unit = {
    println(s"override def unhandled in ReqUest **** $message")
  }
  //      println(s"BidRequest - receive - write(bidReq) writeBidReq: $bidReq")
  //val id  = reqBid_jValue(1)
  //val id  = reqBid_jValue \ "id"
  //      val agent = reqBid_jValue \ "au"
  // val id =  ff.take(0)
  //     val device =  ff("site")

  // val bidReq = BidRequest(reqBid.id,reqBid.json)
  //      val devString = ff("device").toString
  //      val parseDevice = parse(devString).extract[Map[String, Any]]

  //      val caseClassBidRequest = reqBid_jValue.extract[BidRequest]
  // write(caseClassBidRequest)
  //val au =  mapBidRequest.apply(0)
  //      logger.info(s"The full request is: $caseClassBidRequest ")
  //request id and user agent
  //      logger.info(s"The request id: $caseClassBidRequest. " + "id: "+ objBidRequest.id )

}
//      val writeBidReq = write(bidReq)


/*   val jVal  = parse(
     """{
       |"id":"bidid123",
       |"json":"1"
       |}""".stripMargin)*/
//val mapBidRequest = reqBid_jValue.extract[Seq[Map[String, Any]]]
