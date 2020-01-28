package bespalhuk.kotlin_vertx.user

data class User(val username: String) {
    var id: Long? = null

    constructor(id: Long, username: String) : this(username) {
        this.id = id
    }
}