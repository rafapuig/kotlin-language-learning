package flows.hot

import coroutines.log
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds


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
    }
}
