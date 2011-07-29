package poc.model
import org.squeryl.KeyedEntity
import java.sql.Timestamp
import poc.schema.TimetableDb

class WorkingTimeRange (
  val begin: Timestamp,
  val end: Timestamp,
  val timetableId: Long,
  val id:Long = 0
)  extends KeyedEntity[Long] {
  lazy val timetables = TimetableDb.timetableToWorkingTimeRanges.right(this)
}
