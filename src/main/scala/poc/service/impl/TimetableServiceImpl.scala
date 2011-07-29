package poc.service.impl

import java.sql.Timestamp
import java.util.Calendar
import java.util.Date
import scala.collection.immutable.StringOps
import scala.reflect.BeanProperty
import org.squeryl.PrimitiveTypeMode._
import poc.model.Timetable
import poc.model.Cashier
import poc.resources.Snippets._
import poc.resources.TimetableView
import poc.schema.TimetableDb._
import poc.service.TimetableService
import poc.schema.BootStrap
import poc.model.WorkingTimeRange

class TimetableServiceImpl extends TimetableService {

  val BEGIN_HOUR = 8
  val BEGIN_MINUTE = 30

  def cashierTimetable(year: String, week: String, name: String): TimetableView = { 
    
    implicit def string2Int(s: String): Int = new StringOps(s).toInt
    
    val cal = Calendar.getInstance
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.WEEK_OF_YEAR, week)
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
    cal.set(Calendar.HOUR_OF_DAY, BEGIN_HOUR)
    cal.set(Calendar.MINUTE, BEGIN_MINUTE)

    val workingTime = (new Date(), new Date())::Nil
    inTransaction {
      Timetable.findByWeekAndCashier(name, new Timestamp(cal.getTime.getTime))
    } match {
      case Some(t) => TimetableView(name, workingTime.toArray, t.startWeek, countTime(workingTime))
      case None => TimetableView(name, workingTime.toArray, cal.getTime, 0L)
    }
  }
  
  def saveSelection(name: String, selection: String, startWeekIdx: Long): TimetableView = {
    val workingTime = groupWorkingTimeList(string2Date(selection.split(',').toList))
    val week = new Timestamp(startWeekIdx)
    transaction {
      val timetable = Timetable.findByWeekAndCashier(name, week).getOrElse(
          timetables.insert(new Timetable(week, Cashier.findByName(name).id)))
      timetable.workingTimeRanges.deleteAll
      for (timeRange <- workingTime) {
        val wtr = new WorkingTimeRange(new Timestamp(timeRange._1.getTime),
            new Timestamp(timeRange._2.getTime), timetable.id)
        timetable.workingTimeRanges.associate(wtr)
      }
    }

    TimetableView(name, workingTime.toArray, new Date(startWeekIdx), countTime(workingTime))
  }

}

