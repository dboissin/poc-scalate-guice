package poc.service.impl

import poc.resources.TimetableView
import poc.service.TimetableService
import java.util.Date

class TimetableServiceImpl extends TimetableService {

  def cashierTimetable(year: String, week: String, name: String): TimetableView = { 
    println("TimetableServiceImpl - cashierTimetable method")
    TimetableView(name, new Date()::Nil, false)
  }

}