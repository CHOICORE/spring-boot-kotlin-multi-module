package me.choicore.api.authenticator.infrastructure.persistence.inmemory

import me.choicore.api.authenticator.infrastructure.persistence.inmemory.model.UserEntity

internal interface Entity<K> {
    val id: K?

    fun id(): K? {
        return this.id
    }

}

internal abstract class InMemoryDb<V : Entity<K>, K> {

    protected val db = mutableMapOf<K, V>()

    fun save(value: V): K {
        val id = value.id ?: generateId()
        db[id] = value
        return id
    }

    fun findById(id: K): V? {
        return db[id]
    }

    fun findAll(): List<V> {
        return db.values.toList()
    }

    fun deleteById(id: K): Int = deletedCount(id)

    fun deleteByIds(ids: List<K>): Int {
        var deletedCount = 0
        ids.forEach { id ->
            deletedCount += deletedCount(id)
        }
        return deletedCount
    }

    private fun deletedCount(id: K?): Int {
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

    protected abstract fun generateId(): K

}

internal class UserInMemoryDb : InMemoryDb<UserEntity, Long>() {
    private val step: Long = 1L
    override fun generateId(): Long {
        val maxId = db.keys.maxOrNull() ?: 0L
        return maxId + this.step
    }

}




