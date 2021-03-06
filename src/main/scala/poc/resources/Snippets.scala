package poc.resources

import java.util.GregorianCalendar
import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat
import scala.xml.NodeBuffer

object Snippets {

  def generateTimetable(date: Date, selectedTime: Option[Array[(Date, Date)]] = None) = {
    val cal = new GregorianCalendar()
    cal.setTime(date)
    
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
    
    val selected = selectedTime match {
      case Some(s) => date2String(detailWorkingTimeList(s.toList))
      case None => Nil
    }
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    val html = listDate(cal, 0, 0) map {d =>
        val id = df.format(d.getTime)
        val uiselected = if (selected.contains(id)) " ui-selected" else ""
        <li id={id} class={"ui-widget-content" + uiselected}></li>
    }

    genTimetableHeader(cal) &+ <ol id="selectable">{html}</ol>
  }

  private def genTimetableHeader(cal: java.util.GregorianCalendar): scala.xml.NodeBuffer = {
      
    var header = new NodeBuffer
    cal.add(Calendar.MINUTE, 30)
    for (_ <- 1 to 12) {
      header += <li>{cal.get(Calendar.HOUR_OF_DAY)}h</li>
      cal.add(Calendar.MINUTE, 60)
    }
     <ul id="header">{header}</ul><div style="clear:both;"></div>
  }

  /**
   * Convert a list of working time in a list of working time range.
   * 30 * 60 * 1000 = 1800000
   */
  def groupWorkingTimeList(dates: List[Date], timeOffset: Int = 1800000): List[(Date, Date)] = {
    dates.foldRight(List[(Date, Date)]()) {
      (d, list) => list match {
        case (begin, end)::tail =>
          if (begin.getTime == (d.getTime + timeOffset))
            (d, end)::tail
          else
            (d, d)::list
        case Nil => (d, d)::list
      }
    }
  }

  /**
   * Convert a list of range time to a list of index time.
   * 30 * 60 * 1000 = 1800000
   */
  def detailWorkingTimeList(dates: List[(Date, Date)], timeOffset: Int = 1800000): List[Date] = {
    if (dates == null) return Nil
    dates flatMap { case (begin, end) => 
      val nb = (end.getTime - begin.getTime) / timeOffset 
      var result = end::Nil
	  for (i <- 1 to nb.asInstanceOf[Int])
	    result = new Date(end.getTime - (timeOffset * i)) :: result
	  result
    }
  }

  def countTime(dates: List[(Date, Date)]) = {
    dates.foldLeft(0L) ( (t, r) => (r._2.getTime - r._1.getTime) + t )
  }

  def string2Date(dates: List[String]): List[Date] = {
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    dates map (d => df.parse(d))
  }

  def date2String(dates: List[Date]): List[String] = {
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    dates map (d => df.format(d.getTime))
  }

  def dateTuple2String(dates: List[(Date, Date)]): List[String] = {
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    dates map {case (d1, d2) => df.format(d1.getTime) + ", " + df.format(d2.getTime)}
  }

  def dateTuple2StringTuple(dates: List[(Date, Date)]): List[(String, String)] = {
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    dates map {case (d1, d2) => (df.format(d1.getTime), df.format(d2.getTime))}
  }

  def stringTuple2DateTuple(dates: List[(String, String)]): List[(Date, Date)] = {
    val df = new SimpleDateFormat("yyyyMMddHHmm")
    dates map {case (d1, d2) => (df.parse(d1), df.parse(d2))}
  }

}
