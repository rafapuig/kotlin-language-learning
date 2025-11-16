package coroutines.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * Cuando pasamos un elemento de contexto
 * como argumento para el parámetro context en un coroutine builder ( launch, async, etc)
 * o a la función withContext
 * estamos reemplazando este elemento para el contexto de la corrutina hija
 * Para reemplazar más de un elemento del contexto a la vez usamos el operador +
 * el cual está sobrecargado para su uso con los objetos CoroutineContext
 */

/**
 * Por ejemplo,
 * iniciar una corrutina
 * - con el builder runBlocking
 * - en el dispatcher IO
 * - con nombre Coolrutine
 */

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

/**
 * El dispatcher BlockingEventLoop se reemplaza por el Dispatcher.IO
 * El nombre coroutine se reemplaza por el de Coolrutine
 * El Job se mantiene en BlockingCoroutine
 */
fun main() {
    runBlocking(Dispatchers.IO + CoroutineName("Coolrutine")) {
        introspect()
    }
}