package poc.model
import org.squeryl.KeyedEntity
import java.sql.Timestamp

class Timetable (
  val startWeek: Timestamp,
  val cashierId: Long,
  val id: Long = 0
) extends KeyedEntity[Long]
