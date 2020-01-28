package bespalhuk.kotlin_vertx.user.repository

import bespalhuk.kotlin_vertx.user.User
import bespalhuk.kotlin_vertx.user.UserEntry
import bespalhuk.kotlin_vertx.user.UserRepository

class UserRepositoryImpl : UserRepository {

    var count : Long = 0
    val users: MutableMap<Long, UserEntry> = mutableMapOf()

    override fun save(user: User): Long {
        val entry = UserEntry(count, user.username)
        users.put(entry.id, entry)
        count++
        return entry.id
    }

    override fun findById(id: Long): User {
        val entry = users.get(id)
        if (entry != null) {
            return User(entry.id, entry.username)
        }
        throw NoSuchElementException()
    }

}