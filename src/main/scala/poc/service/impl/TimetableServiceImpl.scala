package poc.service.impl

import poc.resources.TimetableView
import poc.service.TimetableService
import java.util.Date
import java.text.SimpleDateFormat
import poc.resources.Snippets._

class TimetableServiceImpl extends TimetableService {

  def cashierTimetable(year: String, week: String, name: String): TimetableView = { 
    println("TimetableServiceImpl - cashierTimetable method")
    // TODO remove line below : TEST ONLY
    val startWeekIdx = new SimpleDateFormat("yyyyMMddHHmm").parse("201107180830")
    TimetableView(name, ((new Date(), new Date())::Nil).toArray, startWeekIdx) 
  }
  
  def saveSelection(name: String, selection: String, startWeekIdx: Long): TimetableView = {
    val workingTime = groupWorkingTimeList(string2Date(selection.split(',').toList))
    TimetableView(name, (workingTime).toArray, new Date(startWeekIdx))
  }

}