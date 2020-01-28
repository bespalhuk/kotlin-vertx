package bespalhuk.kotlin_vertx.user.newuser

import bespalhuk.kotlin_vertx.user.User
import bespalhuk.kotlin_vertx.user.UserRepository

class NewUserUseCase(val useRepository: UserRepository) {

    fun execute(input: NewUserInput, output: NewUserOutput) {
        val user = User(input.username)
        val id = useRepository.save(user)
        output.apply(id)
    }

}