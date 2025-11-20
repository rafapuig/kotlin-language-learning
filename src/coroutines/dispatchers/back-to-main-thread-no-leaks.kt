package coroutines.dispatchers

import coroutines.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * En esta version evitamos fugas llamando a close
 */

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
private val MainDispatcher = newSingleThreadContext("Main")


@OptIn(ExperimentalCoroutinesApi::class)
fun main(): Unit =
    MainDispatcher.use { mainDispatcher ->

        runBlocking(mainDispatcher) {
            log("runBlocking: $coroutineContext")

            launch(Dispatchers.Default) {
                log("Hija: $coroutineContext")

                launch(mainDispatcher) {
                    log("Nieta: $coroutineContext")
                }
            }
        }
        // Liberar el contexto para evitar fugas (explicitamente aqui)
        // Pero en realidad se ejecuta automaticamente por estar en la función use
        MainDispatcher.close()
    }

