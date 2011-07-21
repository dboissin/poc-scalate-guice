package poc.resources

import java.util.Date
import scala.reflect.BeanProperty

case class TimetableView (
	@BeanProperty name: String,
	@BeanProperty workingTime: Array[(Date, Date)],
	@BeanProperty weekStartDate: Date,
	@BeanProperty workTime: Long
) extends DefaultRepresentations {
}

