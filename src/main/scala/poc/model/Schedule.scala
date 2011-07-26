package poc.model
import org.squeryl.KeyedEntity
import org.squeryl.dsl.CompositeKey2
import org.squeryl.PrimitiveTypeMode._

class Schedule (
  val timetableId: Long,
  val workingTimeRangeId: Long
) extends KeyedEntity[CompositeKey2[Long, Long]] {
  def id = compositeKey(timetableId, workingTimeRangeId)
}