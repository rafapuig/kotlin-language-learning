package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

/**
 * Función constructora CoroutineScope
 *
 * Crea un nuevo coroutineScope que podemos usar para crear nuevas corrutinas
 *
 * Recibe un parámetro de tipo CoroutineContext (un contexto de corrutinas)
 * donde podemos especificar los elementos de contexto que queramos:
 * - dispatcher
 * - job
 * - etc
 *
 * Si llamamos a la función CoroutineScope
 * y solamente especificamos el elemento dispatcher del contexto, pero no un Job
 * entonces nos crea un objeto Job nuevo para el contexto
 */

class ComponentWithScope(
    dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    /**
     * Creamos un scope especificando los elementos del contexto dispatcher y job
     * Como Job usamos un objeto de tipo SupervisorJob (un supervisor)
     */
    val scope =
        CoroutineScope(dispatcher + SupervisorJob())

    fun start() {
        log("Iniciando componente!")

        /**
         * Se inicia en el scope una tarea
         * que no terminaría nunca si no la cancelamos
         * (es un bucle infinito y se mantiene en ejecución)
         */
        scope.launch {
            while (true) {
                delay(500.milliseconds)
                log("Componente trabajando!")
            }
        }

        /**
         * También se inicia una tarea que termina por si sola a los 500 milisegundos
         */
        scope.launch {
            log("Realizando una tarea única...")
            delay(500.milliseconds)
            log("Tarea única completada!")
        }
    }

    /**
     * Cancela el scope asociado con el objeto de la clase
     * y con ello las corrutinas que en este scope se habían iniciado
     * y que aún no hayan finalizado
     */
    fun stop() {
        log("Deteniendo componente...")
        scope.cancel()
    }

}

fun main() {
    val component = ComponentWithScope()
    component.scope.launch {
        while (true) {
            log("Aqui con dos pares de...")
            delay(700.milliseconds)
        }
    }
    component.start()
    Thread.sleep(2000)
    component.stop()
}

/**
 * Los frameworks que tienen que gestionar components con ciclo de vida
 * hacen uso internamente de la función CoroutineScope.
 * Por ejemplo la clase ViewModel de Android
 */