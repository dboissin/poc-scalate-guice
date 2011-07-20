package poc.resources

import java.util.Date
import scala.reflect.BeanProperty

case class TimetableView (
	@BeanProperty name: String,
	@BeanProperty workingTime: Array[(Date, Date)],
	@BeanProperty weekStartDate: Date
//	@BeanProperty workingTime: Array[(String, String)],
//	@BeanProperty weekStartDateIdx: String
//	@BeanProperty workingTime: List[(Date, Date)],
//	@BeanProperty weekStartDateIdx: Option[String]
) extends DefaultRepresentations {
}

