package poc.resources

import com.sun.jersey.api.view.ImplicitProduces
import javax.ws.rs.Produces

@ImplicitProduces(Array("text/html;qs=5"))
@Produces(Array("text/xml", "application/json"))
abstract class DefaultRepresentations {

}
