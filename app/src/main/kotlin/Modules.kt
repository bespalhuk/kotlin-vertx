import bespalhuk.kotlin_vertx.user.UserController
import bespalhuk.kotlin_vertx.user.newuser.NewUserUseCase
import bespalhuk.kotlin_vertx.user.repository.UserRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single { NewUserUseCase(UserRepositoryImpl()) }

    single { UserController(get()) }
}