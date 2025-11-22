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
import kotlin.time.Duration.Companion.seconds


fun main() = runBlocking<Unit> {

    with(Publisher()) {

        /** Iniciamos la difusión */
        //this@runBlocking.beginBroadcasting()
        beginBroadcasting()


        /**
         * Añadimos un segundo subscriptor en su propia corrutina
         * (lo ponemos antes porque collect no retorna nunca porque un
         * shared flow nunca termina)
         */

        launch {
            messageFlow.collect {
                log("B: Recolectado $it")
            }
        }


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
