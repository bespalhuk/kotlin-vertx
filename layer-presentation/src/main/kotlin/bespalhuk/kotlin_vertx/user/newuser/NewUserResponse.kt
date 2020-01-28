package bespalhuk.kotlin_vertx.user.newuser

import org.json.JSONObject

class NewUserResponse : NewUserOutput {

    var id: Long = 0

    override fun apply(id: Long) {
        this.id = id
    }

    fun get(): String {
        val json = JSONObject()
        json.put("id", id)
        return json.toString()
    }

}