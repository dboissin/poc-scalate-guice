package poc.model

import org.squeryl.KeyedEntity

class Cashier (
    val name: String,
    val id: Long = 0
) extends KeyedEntity[Long]
