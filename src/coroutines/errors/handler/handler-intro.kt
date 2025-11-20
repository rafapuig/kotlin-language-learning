package coroutines.errors.handler

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.time.Duration.Companion.seconds

/**
 * Una corrutina hija propaga una excepción no controlada hacia sus padres
 * hasta que la excepción encuentra un supervisor
 * o hasta que alcanza la raíz o tope de la jerarquía (una corrutina sin padre)
 *
 * En ese momento la excepcion pasa a un manejador especial llamado:
 * CoroutineExceptionHandler
 * (parte del contexto de la corrutina)
 *
 * Si no hay un CoroutineExceptionHandler entonces pasa al manejador del sistema
 * para excepciones no controladas global
 * En el caso de la JVM este manejador global imprime la stack trace en la consola
 * En el caso de Android el manejador global crashea la app
 */

private val exceptionHandler =
    CoroutineExceptionHandler { context, exception ->
        println("[ERROR] $exception")
    }

class ComponentWithScope(
    dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    private val scope =
        CoroutineScope(dispatcher + exceptionHandler + SupervisorJob())

    /**
     * Esta corrutina lanzada es hija del scope con supervisor
     * El supervisor tiene configurado un exceptionHandler que manejará la excepción
     */
    fun action() = scope.launch {
        throw UnsupportedOperationException("Ups!")
    }
}

fun main() = runBlocking {

    val supervisor = ComponentWithScope()

    /**
     * El scope de runBlocking no se usa para crear nuevas corrutinas
     * Por tanto, para mantener con vida a las corrutinas creadas por otro scope
     * hay que esperar a que terminen parando la corrutina de runBlocking hasta
     * que estas acaben llamando al metodo join a traves del job que devuelve
     * el builder de la corrutina
     */
    val job = supervisor.action()

    // Dar paso a que se ejecute la corrutina creada por llamar al método action
    // (al ser join una función suspendible) y esperar a que termine (es lo que hace join)
    job.join()
}