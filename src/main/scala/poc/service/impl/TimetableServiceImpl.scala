package poc.service.impl

import poc.resources.TimetableView
import poc.service.TimetableService
import java.util.Date
import java.text.SimpleDateFormat

class TimetableServiceImpl extends TimetableService {

  def cashierTimetable(year: String, week: String, name: String): TimetableView = { 
    println("TimetableServiceImpl - cashierTimetable method")
    val startWeekIdx = new SimpleDateFormat("yyyyMMdd").format(new Date().getTime())
    TimetableView(name, (new Date(), new Date())::Nil, Some(startWeekIdx)) //None)
  }

}