package poc.model
import org.squeryl.KeyedEntity
import java.sql.Timestamp
import org.squeryl.dsl.ManyToOne
import poc.schema.TimetableDb

class Timetable (
  val startWeek: Timestamp,
  val cashierId: Long,
  val id: Long = 0
) extends KeyedEntity[Long] {
  lazy val cashier: ManyToOne[Cashier] = TimetableDb.cashierToTimetables.right(this)
  lazy val workingTimeRanges = TimetableDb.schedule.left(this)
}
