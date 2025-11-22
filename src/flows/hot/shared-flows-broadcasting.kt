package flows.hot

import coroutines.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

class Publisher {
    /**
     * Para emitir valores de tipo T necesitamos una referencia a un objeto de tipo
     * MutableSharedFlow<T>
     */
    private val _messageFlow = MutableSharedFlow<Int>()
    val messageFlow = _messageFlow.asSharedFlow() // Vista de solo lectura


    suspend fun broadcastRandomNumber() {
        delay(500.milliseconds)
        val number = Random.nextInt(0..10)
        log("Emitiendo $number")
        _messageFlow.emit(number) //difunde el numero aleatorio
    }

    /**
     * Como las emisiones suceden independientemente de que haya subscriptores
     * tenemos que iniciar la corrutina que realiza las emisiones
     */
    fun CoroutineScope.beginBroadcasting() = launch {
        while (isActive) {
            broadcastRandomNumber()
        }
    }

}


fun main() = runBlocking<Unit> {

    with(Publisher()) {

        /** Iniciamos la difusión */
        //this@runBlocking.beginBroadcasting()
        beginBroadcasting()

        /** Esperamos 600 ms */
        delay(600.milliseconds)

        /** Nos ponemos a escuchar pasados 600 ms  */
        /**
         * El primer valor emitido lo perderemos porque se emite a los 500 ms de empezar
         * y empezamos a recolectar a partir de los 600 ms
         */
        messageFlow.collect {
            log("A: Recolectado $it")
        }

    }

}
