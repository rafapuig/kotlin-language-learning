package coroutines.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * Cuando pasamos un elemento de contexto
 * como argumento para el parámetro context en un coroutine builder (launch, async, etc)
 * o a la función withContext
 * estamos reemplazando este elemento para el contexto de la corrutina hija
 * Para reemplazar más de un elemento del contexto a la vez usamos el operador +
 * el cual está sobrecargado para su uso con los objetos CoroutineContext
 *
 * Cada uno de los elementos del contexto se considera a su vez un contexto especializado
 * De modo que un dispatcher es un subtipo de contexto
 * En general un elemento de contexto es un CoroutineContext
 * que se puede combinar con otros Elementos (CoroutineContext) mediante el operador +
 * que cuando se aplica genera un CoroutineContext resultado de la combinación
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
 * El nombre coroutine se reemplaza por el de Coolroutine
 * El Job se mantiene en BlockingCoroutine
 */
fun main() {
    runBlocking(Dispatchers.IO + CoroutineName("Coolroutine")) {
        introspect()
    }
}