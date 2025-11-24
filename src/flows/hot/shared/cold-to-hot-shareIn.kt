package flows.hot

import coroutines.log
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
fun main() {
    val temperatures = getTemperatures()

    runBlocking {

        val sharedTemps = temperatures
            .shareIn(this, SharingStarted.Lazily, replay = 0)


        launch {
            sharedTemps.collect {
                log("$it celsius")
            }
        }

        launch {
            sharedTemps.collect {
                val fahrenheit = Celsius(it.toDouble()).toFahrenheit()
                log("$it celsius - ${fahrenheit.temperature} fahrenheit")
            }
        }

        delay(5.seconds)
        coroutineContext.cancelChildren()
    }
}
