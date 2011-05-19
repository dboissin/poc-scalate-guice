package poc.scalatra.resource

import javax.ws.rs.{Produces, FormParam, Path, POST, GET}
import org.atmosphere.annotation.{Suspend, Broadcast}
import org.atmosphere.cpr.{BroadcasterFactory, Broadcaster}
import org.atmosphere.jersey.{Broadcastable, JerseyBroadcaster}
import poc.scalatra.dto.SimpleDTO

@Path("/topic")
@com.google.inject.Singleton
@Produces(Array("application/json"))
class MessageResource {


  @GET
  @Suspend(outputComments = false, resumeOnBroadcast = false)
  def listen():Broadcastable = {
    val broadcaster = BroadcasterFactory.getDefault().lookup(classOf[JerseyBroadcaster], "topic", true)
    new Broadcastable(new SimpleDTO("Connected !"), broadcaster)
  }

  @POST
  @Broadcast
  def publish(@FormParam("msg") message: String):Broadcastable = {
    val broadcaster = BroadcasterFactory.getDefault().lookup(classOf[JerseyBroadcaster], "topic", true)
    new Broadcastable(new SimpleDTO("Message : " + message), broadcaster)
  }
}