package poc.resources

import com.sun.jersey.api.view.ImplicitProduces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.GET
import com.sun.jersey.api.view.Viewable
import poc.dto.TimetableDTO

@Path("/timetable")
@ImplicitProduces(Array("text/html;qs=5"))
class TimetableResource {
  
  def blip() = {
    new TimetableDTO("year", "week", "name")
  }
  
    @GET
  /*@Path("/")
  def cashierTimetable() = {
  */
  @Path("/{year}/{week}/{name}")
  def cashierTimetable(
      @PathParam("year") year:String,
      @PathParam("week") week:String,
      @PathParam("name") name:String) = {
    println("cashier timetable")
   new Viewable("index", blip)
   // new TimetableDTO("2011", "34", "Blip")
  }
  
}