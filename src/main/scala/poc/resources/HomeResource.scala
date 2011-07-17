package poc.resources

import com.sun.jersey.api.view.ImplicitProduces
import javax.ws.rs.Path
import javax.ws.rs.GET
import com.sun.jersey.api.view.Viewable
import javax.ws.rs.core.Response
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.FormParam

/**
 * The root resource bean
 */
@Path("/home")
@ImplicitProduces(Array("text/html;qs=5"))
class HomeResource {

  @GET
  def get = new Viewable("index", this)

  @POST
  def send(@FormParam("msg") name: String):Response = {
    println("In send method.")
    Response.ok(">>>" + name + " Data posted. Test refresh jrebel !!!\n" + test("bli") + "\n" + test("blip") + "\n").build()
  }
  
  @PUT
  def test(@FormParam("test") test: String): String = test match {
    case "blip" => "blop\n"
    case _ => "NOP\n"  
  }
  
  def someText = "SOME TEXT"
  
}