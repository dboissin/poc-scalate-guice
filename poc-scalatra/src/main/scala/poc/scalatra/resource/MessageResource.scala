package poc.scalatra.resource

import org.atmosphere.annotation.Broadcast
import org.atmosphere.annotation.Suspend
import org.atmosphere.cpr.Broadcaster
import org.atmosphere.cpr.BroadcasterFactory
import org.atmosphere.jersey.JerseyBroadcaster
import org.atmosphere.jersey.Broadcastable
import org.codehaus.jettison.json.JSONException
import org.codehaus.jettison.json.JSONObject

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.FormParam
import javax.ws.rs.Produces
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