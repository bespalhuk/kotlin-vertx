import bespalhuk.kotlin_vertx.user.UserController
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.FaviconHandler
import org.json.JSONObject
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject

class App : KoinComponent {

    fun init() {
        startKoin {
            modules(appModule)
        }
        vertx()
    }

    private fun vertx() {
        val userController: UserController by inject()

        val vertx = Vertx.vertx()
        val server = vertx.createHttpServer()
        val router = Router.router(vertx)

        router.route()
            .handler(FaviconHandler.create("static/icons/favicon.ico"))

        router.get("/")
            .handler { context ->
                context.response()
                    .putHeader("content-type", "text/plain; charset=UTF8")
                    .end("index")
            }

        router.get("/:username")
            .handler { context ->
                val username = context.request().getParam("username")
                val json = JSONObject().put("username", username)
                context.response()
                    .putHeader("content-type", "application/json; charset=UTF8")
                    .end(userController.newUser(json))
            }

        server
            .requestHandler(router::handle)
            .listen(8080)
    }
}