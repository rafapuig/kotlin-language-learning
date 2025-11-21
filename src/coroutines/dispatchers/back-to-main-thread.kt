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
import kotlinx.coroutines.withContext

/**
 * No se puede volver al hilo original de runBlocking
 * No existe posibilidad de volver al hilo main
 * que usa el contexto por defecto de la corrutina creada por runBlocking
 *
 * Porque el hilo “main” de una aplicación JVM estándar: *
 * - no es parte de ningún Dispatcher
 * - no está registrado en ningún CoroutineDispatcher *
 * - no se puede recuperar
 *
 * El hilo se llama “main” por el nombre del thread de la JVM, pero:
 *
 * 🚫 No existe un Dispatchers.Main
 * 🚫 No existe un dispatcher que represente ese hilo
 * 🚫 No existe un mecanismo para saltar a ese hilo automáticamente
 *
 * Si queremos un hilo main al que volver al crear una corrutina hija
 * dentro de una corrutina hija de runBlocking que haya cambiado de dispatcher..
 * tenemos que crear nuestro propio hilo main
 * mediante newSingleThreadContext
 */

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
private val MainDispatcher = newSingleThreadContext("Main")



@OptIn(ExperimentalCoroutinesApi::class)
fun main(): Unit =
    runBlocking(MainDispatcher) {
        log("runBlocking: $coroutineContext")

        launch(Dispatchers.Default) {
            log("Hija: $coroutineContext")

            launch (MainDispatcher) {
                log("Nieta: $coroutineContext")
            }
        }
    }



