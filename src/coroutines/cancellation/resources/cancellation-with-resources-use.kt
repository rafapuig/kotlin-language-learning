package coroutines.cancellation.finaly

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
            FakeDataBaseConnection().use {

                delay(500.milliseconds)
                it.write("Me encantan las corrutinas!")
                /**
                 * No es necesario llamar a close
                 * se llama automaticamente al finalizar el bloque o
                 * si hay una excepción / cancelación
                 */
                //it.close()
            }
        }
        delay(200.milliseconds)
        /**
         * A los 200 ms cancelamos la corrutina, que a la que le quedaran 300 ms
         * para retomar la ejecución ya qye fue suspendida durante 500 ms,
         * por tanto, no se ejecuta db.close()
         */
        dbTask.cancel()
    }
    log("Ya no hay fuga (leak) del recurso")
}
