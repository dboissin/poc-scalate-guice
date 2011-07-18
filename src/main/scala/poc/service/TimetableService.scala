package poc.service
import poc.resources.TimetableView

trait TimetableService {

  def cashierTimetable(year: String, week: String, name: String) : TimetableView
  
}