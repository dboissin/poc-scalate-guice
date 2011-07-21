package poc.service.impl

import java.util.Calendar
import java.util.Date

import scala.collection.immutable.StringOps
import scala.reflect.BeanProperty

import poc.resources.Snippets._
import poc.resources.TimetableView
import poc.service.TimetableService

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
    TimetableView(name, (workingTime).toArray, cal.getTime, countTime(workingTime))
  }
  
  def saveSelection(name: String, selection: String, startWeekIdx: Long): TimetableView = {
    val workingTime = groupWorkingTimeList(string2Date(selection.split(',').toList))
    TimetableView(name, (workingTime).toArray, new Date(startWeekIdx), countTime(workingTime))
  }

}
