package poc.resources

import java.util.GregorianCalendar
import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat

object Snippets {

  def generateTimetable(year: Int, month: Int, day: Int): String = {
    val cal = new GregorianCalendar(year, month - 1, day, 8, 30)
    
    def listDate(calendar: Calendar, idxDay: Int, idxHalfHour: Int): List[Date] = (idxDay, idxHalfHour) match {
      case (6, 8) => calendar.getTime::Nil
      case (d, 23) =>
        val c = calendar.clone().asInstanceOf[Calendar]
        c.add(Calendar.MINUTE, 60 * 12 + 30)
        calendar.getTime::listDate(c, d + 1, 0)
      case (d, hh) =>
        val c = calendar.clone().asInstanceOf[Calendar]
        c.add(Calendar.MINUTE, 30)
        calendar.getTime::listDate(c, d, hh + 1)
    }
    
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    val dates = listDate(cal, 0, 0) map (d => df.format(d.getTime)) 
    dates reduceLeft(_ + ", " + _)
  }
}
