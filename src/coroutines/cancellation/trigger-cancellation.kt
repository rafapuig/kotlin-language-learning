package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {

    val launchedJob = launch {
        log("Job lanzado!")
        delay(1000.milliseconds)
        log("Job completado!")
    }

    val asyncDeferred = async {
        log("Soy la corrutina async!")
        delay(1000.milliseconds)
        log("Async completado!")
    }

    launch {
        log("Corrutina que se autoterminará")
        delay(100.milliseconds)
        coroutineContext.job.cancel() // Pedimos que se cancele
        // La suspendemos para que tenga la oportunidad de cancelarse
        yield()
        log("Corrutina completada!")
    }

    delay(200.milliseconds) // Tracurridos 200 milisegundos ...
    launchedJob.cancel() // Cancelamos la corrutina lanzada con launch
    asyncDeferred.cancel() // Cancelamos la corrutina creada con async
}