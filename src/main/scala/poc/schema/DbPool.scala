package poc.schema
import com.mchange.v2.c3p0.ComboPooledDataSource

object DbPool {
  val databaseUsername = "sa"
  val databasePassword = ""
//  val databaseConnection = "jdbc:h2:mem:example;DB_CLOSE_DELAY=-1"
  val databaseConnection = "jdbc:h2:~/timetable"

  val cpds = new ComboPooledDataSource
  cpds.setDriverClass("org.h2.Driver")
  cpds.setJdbcUrl(databaseConnection)
  cpds.setUser(databaseUsername)
  cpds.setPassword(databasePassword)

  cpds.setMinPoolSize(1)
  cpds.setAcquireIncrement(1)
  cpds.setMaxPoolSize(5)
  cpds.setMaxIdleTime(10)
  cpds.setMaxStatements(50)
  cpds.setIdleConnectionTestPeriod(10)
}
