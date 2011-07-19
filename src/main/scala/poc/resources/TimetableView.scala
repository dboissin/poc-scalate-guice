package poc.resources

import java.util.Date

case class TimetableView (
	name: String,
	workingTime: List[(Date, Date)],
	weekStartDateIdx: Option[String]
) extends DefaultRepresentations {
}

