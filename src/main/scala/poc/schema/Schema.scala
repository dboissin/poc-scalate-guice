package poc.schema

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import poc.model.Cashier
import poc.model.Timetable

object Schema extends Schema {
  
  val cashiers = table[Cashier]
  val timetables = table[Timetable]
  
  on(cashiers)(cashier => declare(
	  cashier.id is (autoIncremented),
      cashier.name is (unique)    
  ))

  on(timetables)(timetable => declare(
	  timetable.id is (autoIncremented)
  ))

}
