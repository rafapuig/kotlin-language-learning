package coroutines.dispatchers

import coroutines.log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.milliseconds

val mainThreadQueue = ConcurrentLinkedQueue<suspend () -> Unit>()

private val MainDispatcher = object : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        log("Encolando..")
        mainThreadQueue.add { block.run() }
    }
}

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
fun main() {

    runBlocking(newSingleThreadContext("UI thread")) {

        log("runBlocking: $coroutineContext")

        // Procesamos la cola de tareas del hilo principal
        // Coroutine que procesa la cola sin bloquear el hilo
        val mainProcessor = launch {
            while (isActive) {
                val task = mainThreadQueue.poll()
                if (task != null) task()
                else delay(10)

                // Salimos automáticamente cuando no haya tareas pendientes y todas las coroutines hijas hayan terminado
                if (coroutineContext[Job]?.children?.none { it.isActive } == true
                    && mainThreadQueue.isEmpty()) {
                    break
                }
            }
        }



        val job = launch(Dispatchers.Default) {
            log("Hija: $coroutineContext")

            withContext(MainDispatcher) {
                log("Nieta 1: $coroutineContext")
            }

            delay(100.milliseconds)

           withContext(MainDispatcher) {
                log("Nieta 2: $coroutineContext")
            }

        }

        /**
         * Hacemos este yield para permitir al dispatcher (planificador)
         * que puede comenzar la corrutina hija lanzada con launch
         */
        job.join()

        mainProcessor.join()
    }
}


// Función helper para “postear” eventos al hilo principal
fun postToMain(block: suspend () -> Unit) {
    mainThreadQueue.add(block)
}




