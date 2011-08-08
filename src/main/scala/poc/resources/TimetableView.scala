package poc.resources

import java.util.Date
import scala.reflect.BeanProperty
import org.codehaus.jackson.map.ObjectMapper

case class TimetableView (
	@BeanProperty name: String,
	@BeanProperty workingTime: Option[Array[(Date, Date)]],
	@BeanProperty weekStartDate: Date,
	@BeanProperty workTime: Long
) extends DefaultRepresentations {

  def getJsonWorkingTime = {
    new ObjectMapper().writeValueAsString(workingTime)
  }

}

