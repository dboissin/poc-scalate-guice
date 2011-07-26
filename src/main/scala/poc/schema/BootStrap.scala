package poc.schema
import org.squeryl.SessionFactory
import org.squeryl.Session
import org.squeryl.adapters.H2Adapter
import org.squeryl.PrimitiveTypeMode._
import poc.model.Cashier
import poc.model.Timetable
import java.sql.Timestamp

object BootStrap {

  def startDatabaseSession() {
    Class.forName("org.h2.Driver");
    SessionFactory.concreteFactory = Some(()=>
      Session.create(
        java.sql.DriverManager.getConnection("jdbc:h2:mem:example", "sa", ""),
        new H2Adapter)
    )
  }
  
  def testBootStrapDB () {
    inTransaction {
      import poc.schema.TimetableDb._

      drop  // Bad idea in production application !!!
      create
      printDdl

      cashiers.insert(new Cashier("Blip"))
      cashiers.insert(new Cashier("Blop"))

      timetables.insert(new Timetable(new Timestamp(System.currentTimeMillis), 1L))
      val queried = cashiers.where(cashier => cashier.id === 2L).single
      println(queried.id + " -- " + queried.name)

    }
  }
  
}
