package poc.scalatra.resource

import org.atmosphere.annotation.Broadcast
import org.atmosphere.annotation.Suspend
import org.atmosphere.cpr.Broadcaster
import org.atmosphere.cpr.BroadcasterFactory
import org.atmosphere.cpr.DefaultBroadcaster
import org.atmosphere.jersey.Broadcastable
import org.codehaus.jettison.json.JSONException
import org.codehaus.jettison.json.JSONObject

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces

@Path("/topic")
@com.google.inject.Singleton
@Produces(Array("application/json"))
class MessageResource {


    @GET
   def titi(): String = {
    "{blalfksl: 'felf'}"
  }
//    @Suspend(outputComments = true, resumeOnBroadcast = false)
//    def listen():Broadcastable = {
//      val broadcaster = BroadcasterFactory.getDefault().lookup(classOf[DefaultBroadcaster], "titi", true)
//      new Broadcastable(new JSONObject().put("from", "system").put("msg", "Connected !"), broadcaster)
//    }
}