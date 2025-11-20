package coroutines.dispatchers

import coroutines.log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 * Versión Back to Main Thread usando un Scope creado con la función CoroutineScope
 */

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
private val MainDispatcher = newSingleThreadContext("Main")

/**
 * Usar un scope con el nuevo dispatcher
 */
@OptIn(ExperimentalCoroutinesApi::class)
private val mainScope = CoroutineScope(MainDispatcher + SupervisorJob())


val CoroutineContext.dispatcher
    get() = this[ContinuationInterceptor] as CoroutineDispatcher


@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    runBlocking(mainScope.coroutineContext) {
        log("Padre: $coroutineContext")

        launch(Dispatchers.Default) {
            log("Hija: $coroutineContext")

            val dispatcher =
                mainScope.coroutineContext.dispatcher

            // Otra forma (a partir del scope del padre)
            val dispatcherAlt =
                this@runBlocking.coroutineContext.dispatcher

            launch(dispatcher) {
                log("Nieta 1: $coroutineContext")
            }

            launch(dispatcherAlt) {
                log("Nieta 2: $coroutineContext")
            }

        }
    }

    //MainDispatcher.close()
}




