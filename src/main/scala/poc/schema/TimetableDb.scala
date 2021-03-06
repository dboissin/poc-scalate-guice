package poc.schema

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import poc.model.Cashier
import poc.model.Timetable
import poc.model.WorkingTimeRange

object TimetableDb extends Schema {

  val cashiers = table[Cashier]
  val timetables = table[Timetable]
  val workingTimeRanges = table[WorkingTimeRange]

  on(cashiers)(cashier => declare(
      cashier.name is (unique)
  ))

  on(timetables)(timetable => declare(
	columns(timetable.cashierId, timetable.startWeek) are (unique)
  ))

  on(workingTimeRanges)(workingTimeRange => declare(
    columns(workingTimeRange.begin, workingTimeRange.end) are (unique)
  ))

  val cashierToTimetables =
    oneToManyRelation(cashiers, timetables).
    via((c, t) => c.id === t.cashierId)

  val timetableToWorkingTimeRanges = 
    oneToManyRelation(timetables, workingTimeRanges).
    via((t, wtr) => t.id === wtr.timetableId)

}
