package bespalhuk.kotlin_vertx.user.newuser

import org.json.JSONObject

class NewUserRequest private constructor(override val username: String):
    NewUserInput {

    companion object Builder {
        fun of(json: JSONObject): NewUserRequest {
            val username = json.get("username").toString()
            return NewUserRequest(username)
        }
    }

}