package flows.operations.terminal

import coroutines.log
import flows.operations.intermediate.getTemperatures
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

private suspend fun collectDemo() {
    getTemperatures()
        .onEach { log("Leida temperatura: ${it}ºC") }
        .catch {
            log("Capturada la exception: $it")
        }
        .take(5)
        .collect() // atajo para collect{}
}

suspend fun collectIndexedDemo() {
    getTemperatures()
        .take(5)
        .collectIndexed { index, temperature ->
            log("Lectura[${index+1}] ${temperature}ºC")
        }
}



fun main() = runBlocking {
    //collectDemo()
    //collectIndexedDemo()
}