package actor.Main

import actor.Main.Main.receiveActorSys
import actor.receive.BidRequest.{BidRequest, BidRequest4Response}
import actor.receive.ReceiveActor
import actor.response.ResponseActor
import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.Logger

object Main extends App {
  val logger = Logger("MainLogger")
  logger.info("Main executed")
  val receiveActorSys = ActorSystem("Mars-ReceiveActor").actorOf(Props[ReceiveActor], "ReceiveActor")
  val responseActorSys = ActorSystem("Mars-ResponseActor").actorOf(Props[ResponseActor], "responseActor")

    receiveActorSys ! BidRequest4Response(BidRequest(Some("id111Main"),Some("{mainTst:ttt,jsnObj:jsnObj}")),responseActorSys)

}
