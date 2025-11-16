package coroutines.scopes.context

import coroutines.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking(CoroutineName("A")) {
    log("Job de A: ${coroutineContext.job}")

    launch(CoroutineName("B")) {
        log("Job de B: ${coroutineContext.job}")
        log("Padre de B: ${coroutineContext.job.parent}")
    }

    log("Hijas de A: ${coroutineContext.job.children.toList()}")
}