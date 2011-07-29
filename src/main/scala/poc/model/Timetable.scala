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
  lazy val workingTimeRanges = TimetableDb.timetableToWorkingTimeRanges.left(this)
}

object Timetable {
  import poc.schema.TimetableDb._
  import org.squeryl.PrimitiveTypeMode._

  def findByWeekAndCashier(cashierName: String, startWeek: Timestamp) = {
    from(cashiers, timetables)((c, t) =>
      where(c.name === cashierName and c.id === t.cashierId and t.startWeek === startWeek)
      select(t)
    ).headOption
  }

}
