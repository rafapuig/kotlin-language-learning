package coroutines.context

import coroutines.log
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

/**
 * Cada corrutina lleva consigo información adicional que sirve de contexto
 * en forma de un objeto CoroutineContext
 * que no es más que un conjunto de elementos de contexto (entre ellos el dispatcher)
 *
 * También contiene un objeto Job responsable de su ciclo de vida y cancelación potencial
 *
 * Y además contiene otros metadatos:
 * - CoroutineName
 * - CoroutineExceptionHandler
 *
 * Para acceder al contexto usamos la propiedad coroutineContext dentro
 * de cualquier función suspendida
 */

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

suspend fun introspect() {
    log(coroutineContext)
}

fun main() {
    runBlocking {
        introspect()
    }
}