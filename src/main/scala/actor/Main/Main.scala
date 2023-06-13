package actor.Main

import actor.receive.BidRequest.{Banner, BidRequest, Imp}
import actor.receive.ReceiveActor
import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.Logger

object Main extends App {
  val logger = Logger("MainLogger")
  logger.info("Main executed")
  val receiveActorSys = ActorSystem("Mars-ReceiveActor-general")

  receiveActorSys.actorOf(Props[ReceiveActor], "ReceiveActor") ! BidRequest("re111", Array(Imp("ipm222", Banner(6, 7, 8))))

}
