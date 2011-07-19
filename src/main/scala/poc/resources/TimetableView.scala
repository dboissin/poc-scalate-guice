package poc.resources

import java.util.Date
import scala.reflect.BeanProperty

@BeanProperty
case class TimetableView (
	@BeanProperty name: String,
	@BeanProperty workingTime: List[(Date, Date)],
	@BeanProperty weekStartDateIdx: Option[String]
) extends DefaultRepresentations {
}

