package coroutines.scopes.context

import coroutines.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * La función coroutineScope cuenta con su propio objeto Job
 * que también participa en la jerarquía padre-hijo
 */

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit>(CoroutineName("A")) {
    log("Job de A: ${coroutineContext.job}")

    coroutineScope {
        log("Padre del Job del coroutineScope: ${coroutineContext.job.parent}") // A
        log("Job del coroutineScope: ${coroutineContext.job}")

        launch(CoroutineName("C")) {
            log("Job de C: ${coroutineContext.job}")
            /**
             * El padre de esta corrutina es el Job creado al llamar a coroutineScope
             */
            log("Padre de C: ${coroutineContext.job.parent}")
        }
    }
}