package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

class FakeDataBaseConnection : AutoCloseable {

    fun write(data:String) = println("Escribiendo $data")

    override fun close() {
        log("Cerrando!")
    }
}

fun main() {
    runBlocking {
        val dbTask = launch {
            val db = FakeDataBaseConnection()
            delay(500.milliseconds)
            db.write("Me encantan las corrutinas!")
            db.close()
        }
        delay(200.milliseconds)
        /**
         * A los 200 ms cancelamos la corrutina, que a la que le quedaran 300 ms
         * para remotar la ejecución ya qye fue suspendida durante 500 ms
         * por tanto, no se ejecuta db.close()
         */
        dbTask.cancel()
    }
    log("Acabo de fugar (leak) un recurso")
}
