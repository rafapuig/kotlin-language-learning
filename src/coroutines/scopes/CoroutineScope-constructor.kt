package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

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

class ComponentWithScope constructor(
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

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
fun main() {

    val dispatcher = newSingleThreadContext("Main")

    runBlocking(dispatcher) {
        val component = ComponentWithScope(dispatcher)

        /**
         * Podemos crear un corrutina mediante el scope del componente
         * que tendrá una duración controlada por el ciclo de vida del componente
         */
        component.scope.launch {
            while (true) {
                log("Aqui con dos pares de...")
                /**
                 * Podemos usar una implementación particular que
                 * tiene el mismo comportamiento que la función delay de la biblioteca estándar
                 */
                myDelay(700.milliseconds)
            }
        }

        /**
         * Iniciamos el componente (y se lanzan las corrutinas)
         */
        component.start()
        /**
         * Si llamamos a sleep dormimos el hilo (no hacer nada durante n milisegundos)
         * Si las corrutinas creadas son despachadas en también en el hilo main
         * nunca tendrán oportunidad de ejecutarse porque a este hilo con sleep
         * lo que estamos haciendo es dormirlo (no cederlo / entregarlo)
         */
        //Thread.sleep(2000)
        /**
         * Pero si hacemos un delay, lo que hacemos es suspender la corrutina y dejar el
         * hilo libre para que otra corrutina ejecute su código
         */
        //delay(2.seconds)
        myDelay(2.seconds)
        /**
         * Paramos el componente
         */
        component.stop()
    }
}

suspend fun myDelay(duration: Duration) {
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() - startTime < duration.inWholeMilliseconds) {
        yield()
    }
}

/**
 * Los frameworks que tienen que gestionar components con ciclo de vida
 * hacen uso internamente de la función CoroutineScope.
 * Por ejemplo la clase ViewModel de Android
 */