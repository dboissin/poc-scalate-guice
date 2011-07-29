package poc.model

import org.squeryl.KeyedEntity
import org.squeryl.dsl.OneToMany
import poc.schema.TimetableDb

class Cashier (
    val name: String,
    val id: Long = 0
) extends KeyedEntity[Long] {
  lazy val timetables: OneToMany[Timetable] = TimetableDb.cashierToTimetables.left(this)
}

object Cashier {
  import poc.schema.TimetableDb._
  import org.squeryl.PrimitiveTypeMode._
  
  def findByName(name: String) =
    cashiers.where(c => c.name === name).single
}
