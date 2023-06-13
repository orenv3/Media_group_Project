/*
import actor.receive.BidRequest.{Banner, BidRequest, Imp}
import actor.receive.ReceiveActor
import akka.actor.{ActorSystem, Props}

object Main extends App{
  val receiveActorSys = ActorSystem("Mars-ReceiveActor")

  receiveActorSys.actorOf(Props[ReceiveActor],"ReceiveActor") ! BidRequest("re111",Array(Imp("ipm222",Banner(6,7,8))))

}
/*  def main(args: Array[String]): Unit = {
    println("Hello world!")
  }*/
*/
