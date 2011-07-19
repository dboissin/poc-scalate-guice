package poc.service.impl

import poc.resources.TimetableView
import poc.service.TimetableService
import java.util.Date
import java.text.SimpleDateFormat
import poc.resources.Snippets._

class TimetableServiceImpl extends TimetableService {

  def cashierTimetable(year: String, week: String, name: String): TimetableView = { 
    println("TimetableServiceImpl - cashierTimetable method")
    val startWeekIdx = new SimpleDateFormat("yyyyMMdd").format(new Date().getTime())
    TimetableView(name, (new Date(), new Date())::Nil, Some(startWeekIdx)) //None)
  }
  
  def saveSelection(name: String, selection: String, startWeekIdx: String): TimetableView = {
    val workingTime = groupWorkingTimeList(string2Date(selection.split(',').toList))
    TimetableView(name, workingTime, Some(startWeekIdx))
  }

}