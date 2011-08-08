package poc.schema
import org.squeryl.SessionFactory
import org.squeryl.Session
import org.squeryl.adapters.H2Adapter
import org.squeryl.PrimitiveTypeMode._
import poc.model.Cashier
import poc.model.Timetable
import java.sql.Timestamp
import poc.model.WorkingTimeRange

object BootStrap {

  SessionFactory.concreteFactory = Some(() => connection)

  def connection = Session.create(DbPool.cpds.getConnection, new H2Adapter)
    
  def testBootStrapDB () {
    inTransaction {
      import poc.schema.TimetableDb._

      drop  // Bad idea in production application !!!
      create
      printDdl

      val t = new Timetable(new Timestamp(System.currentTimeMillis), 1L)
      val t2 = new Timetable(new Timestamp(System.currentTimeMillis+500000), 1L)
      val blip = new Cashier("Blip")
      cashiers.insert(blip)
      println("blipId : " + blip.id)
      blip.timetables.associate(t)
      blip.timetables.associate(t2)

      val c = cashiers.lookup(1L)
      val titi = c.get.timetables.foldLeft(">>> ")((tmp, res) => tmp + res.id + ", " )
      println (titi)

      val blop = new Cashier("Blop")
      println ("before insert => blopId : " + blop.id)
      cashiers.insert(blop)
      println ("after insert => blopId : " + blop.id)


      //timetables.insert(t)
      val t3 = timetables.where(t => t.id === 2L).single

      val wtr = new WorkingTimeRange(new Timestamp(System.currentTimeMillis),
          new Timestamp(System.currentTimeMillis + 60000), t3.id)
      t3.workingTimeRanges.associate(wtr)
      t3.workingTimeRanges.deleteAll
      //t3.workingTimeRanges.associate(wtr)
//      schedules.associate(t, wtr)

      //timetables.insert(new Timetable(new Timestamp(System.currentTimeMillis), 1L))
      val queried = cashiers.where(cashier => cashier.id === 2L).single
      println(queried.id + " -- " + queried.name)

    }
  }
  
}
