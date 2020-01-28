package bespalhuk.kotlin_vertx.user

interface UserRepository {

    fun save(user: User): Long

    fun findById(id: Long): User

}