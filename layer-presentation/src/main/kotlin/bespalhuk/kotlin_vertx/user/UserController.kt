package bespalhuk.kotlin_vertx.user

import bespalhuk.kotlin_vertx.user.newuser.NewUserRequest
import bespalhuk.kotlin_vertx.user.newuser.NewUserResponse
import bespalhuk.kotlin_vertx.user.newuser.NewUserUseCase
import org.json.JSONObject

class UserController(val newUserUseCase: NewUserUseCase) {

    fun newUser(json: JSONObject): String {
        val request = NewUserRequest.of(json)
        val response = NewUserResponse()
        newUserUseCase.execute(request, response)
        return response.get()
    }

}