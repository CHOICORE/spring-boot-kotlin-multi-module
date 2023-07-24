package me.choicore.api.authenticator.infrastructure.persistence.inmemory

import me.choicore.api.authenticator.infrastructure.persistence.inmemory.model.UserEntity

internal interface Entity<ID> {
    val id: ID?
}

internal abstract class InMemoryDb<V : Entity<ID>, ID> {

    protected val db = mutableMapOf<ID, V>()

    /**
     * Save entity to db.
     *
     * If entity has id, then update entity.
     * If entity has no id, then create entity.
     *
     * @param value [V] entity
     * @return [ID] of saved entity
     */
    fun save(value: V): ID {
        val id = value.id ?: run {
            val newId = generateId()
            value.javaClass.getDeclaredField("id").apply {
                isAccessible = true
                set(value, newId)
                isAccessible = false
            }
            newId
        }
        db[id] = value
        return id
    }


    fun findById(id: ID): V? {
        return db[id]
    }

    fun findAll(): List<V> {
        return db.values.toList()
    }

    fun deleteById(id: ID): Int = deletedCount(id)

    fun deleteByIds(ids: List<ID>): Int {
        var deletedCount = 0
        ids.forEach { id ->
            deletedCount += deletedCount(id)
        }
        return deletedCount
    }

    private fun deletedCount(id: ID?): Int {
        var deletedCount = 0
        when (id) {
            null -> {
                deletedCount = db.size
                db.clear()
            }

            else -> {
                db.remove(id)?.let { deletedCount++ }
            }
        }
        return deletedCount
    }

    fun deleteAll(): Int = deletedCount(null)

    protected abstract fun generateId(): ID

}

internal class UserInMemoryDb : InMemoryDb<UserEntity, Long>() {
    private val step: Long = 1L
    override fun generateId(): Long {
        val maxId = db.keys.maxOrNull() ?: 0L
        return maxId + this.step
    }
}




