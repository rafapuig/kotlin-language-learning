package flows.hot.state

import coroutines.log
import flows.hot.getTemperatures
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

fun main() = runBlocking {//#1

    val temperaturesFlow = getTemperatures()

    /**
     * Creamos un scope donde recolectar el cold flow distinto
     * al de la corrutina creado por runBlocking
     * para luego poder cancelarlo cuando
     * se hayan realizado las 3 lecturas
     */
    val scope = CoroutineScope(coroutineContext + SupervisorJob()) //#2

    val temperatureState = temperaturesFlow.stateIn(scope)

    repeat(3) {
        log("Temperatura: ${temperatureState.value} celsius")
        delay(500.milliseconds)
    }

    /** Ya podemos parar el cold flow que está emitiendo en su propio scope */
    scope.cancel()
}

