package poc.model
import org.squeryl.KeyedEntity
import java.sql.Timestamp
import poc.schema.TimetableDb

class WorkingTimeRange (
  val begin: Timestamp,
  val end: Timestamp,
  val id:Long = 0
)  extends KeyedEntity[Long] {
  lazy val timetables = TimetableDb.schedule.right(this)
}