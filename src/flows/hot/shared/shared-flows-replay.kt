package flows.hot.replay

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
import kotlin.time.Duration.Companion.seconds

class Publisher {
    /**
     * Para emitir valores de tipo T necesitamos una referencia a un objeto de tipo
     * MutableSharedFlow<T>
     */
    private val _messageFlow = MutableSharedFlow<Int>(replay = 5)
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
    fun beginBroadcasting(scope: CoroutineScope) = scope.launch {
        while (isActive) {
            broadcastRandomNumber()
        }
    }

}


fun main() = runBlocking<Unit> {

    val broadcaster = Publisher()

    /** Iniciamos la difusión */
    //this@runBlocking.beginBroadcasting()
    broadcaster.beginBroadcasting(this)

    /** Esperamos 3 segundos */
    delay(3.seconds)

    /** Nos ponemos a escuchar pasados los 3 segundos  */
    /**
     * Podremos recuperar hasta los últimos 5 valores emitidos antes de
     * iniciar la escucha
     */
    broadcaster.messageFlow.collect {
        log("A: Recolectado $it")
    }

}
