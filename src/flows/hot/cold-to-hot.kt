package flows.hot

import coroutines.log
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun querySensor() = (-10..30).random()

suspend fun FlowCollector<Int>.emitTemperature() {
    emit(querySensor())
    delay(500.milliseconds)
}

fun getTemperatures() = flow {
    while (currentCoroutineContext().isActive) {
        //emitTemperature()
        emit(querySensor())
        delay(500.milliseconds)
    }
}

@JvmInline
value class Celsius(val temperature: Double) {
    fun toFahrenheit(): Fahrenheit {
        return Fahrenheit(temperature * 9.0 / 5.0 + 32.0)
    }
}

@JvmInline
value class Fahrenheit(val temperature: Double)

fun main() {
    val temperatures = getTemperatures()

    runBlocking {

        launch {
            temperatures.collect {
                log("$it celsius")
            }
        }

        launch {
            temperatures.collect {
                val fahrenheit = Celsius(it.toDouble()).toFahrenheit()
                log("$it celsius - ${fahrenheit.temperature} fahrenheit")
            }
        }
    }
}
