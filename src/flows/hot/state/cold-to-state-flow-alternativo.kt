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

fun main() = runBlocking {

    val temperatureState = getTemperatures().stateIn(this)

    val job = launch {
        repeat(3) {
            log("Temperatura: ${temperatureState.value} celsius")
            delay(500.milliseconds)
        }
    }

    job.join()
    coroutineContext.cancelChildren()
}

