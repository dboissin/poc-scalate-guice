package poc.resources

import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.GET
import javax.ws.rs.Produces
import com.sun.jersey.api.view.Viewable
import poc.service.TimetableService
import com.google.inject.Inject

@Path("/timetable")
class TimetableResource extends DefaultRepresentations {
  
  @Inject
  var service: TimetableService = _
  
  @GET
  def get() = new Viewable("index", this)

  @Path("{year}/{week}/{name}")
  def timetable(
	@PathParam("year") year: String,
	@PathParam("week") week: String,
	@PathParam("name") name: String
  ) = {
    service.cashierTimetable(year, week, name)
  }


  @Path("{year}")
  def cashierTimetable(
      @PathParam("year") year:String
  ) = {
    println("cashier timetable")
   // new TimetableDTO("2011", "34", "Blip")
	Item(year, "Name of Item: " + year)
  }
  
}
