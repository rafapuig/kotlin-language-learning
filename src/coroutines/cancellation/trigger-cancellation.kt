package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {

    val launchedJob = launch {
        log("Job lanzado!")
        delay(500.milliseconds)
        log("Job completado!") // No se llega a ejecutar
    }

    val asyncDeferred = async {
        log("Soy la corrutina async!")
        delay(1000.milliseconds)
        log("Async completado!") // No se llega a ejecutar
    }

    launch {
        log("Corrutina que se autoterminará")
        delay(100.milliseconds)
        coroutineContext.job.cancel() // Pedimos que se cancele
        //this.cancel()
        //cancel()
        // La suspendemos para que tenga la oportunidad de cancelarse
        yield() // Si comentamos esta línea la siguiente instrucción se ejecutará
        log("Corrutina completada!")
    }

    delay(200.milliseconds) // Transcurridos 200 milisegundos ...
    launchedJob.cancel() // Cancelamos la corrutina lanzada con launch
    asyncDeferred.cancel() // Cancelamos la corrutina creada con async
}