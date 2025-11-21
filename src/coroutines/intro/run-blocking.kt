package coroutines.intro

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

/**
 * Para hacer uso de la corrutinas es necesaria
 * la dependencia:
 * org.jetbrains.kotlinx:kotlinx-coroutines-core
 */

/**
 * Suspending functions
 *
 * A las funciones suspendidas (suspendibles)
 * (que permiten ser suspendidas, que permiten suspender su ejecución)
 * solamente se las puede llamar desde una corrutina
 *
 * Llevan delante la palabra clave del lenguaje suspend
 */
suspend fun doSomethingSlowly() {
    println("Haciendo una tarea que cuesta 2 segundos...")
    /**
     * delay es una función suspendida
     */
    delay(2.seconds)
    println("Terminé")
}

/**
 * El puente entre el código bloqueante "normal"
 * y el "reino" de las funciones suspendidas
 * es la función builder runBlocking
 * a la que se le pasa un bloque de código que
 * se considera el cuerpo de la corrutina
 *
 * Crea u ejecuta la corrutina bloqueando el hilo
 * hasta que la corrutina termina.
 *
 * Dentro del bloque de código se puede llamar
 * a las funciones suspendidas
 * Por eso decimos que conecta ambos "reinos"
 * Dentro de la corrutina creada e iniciada por runBlocking
 * podemos iniciar corrutinas hijas, que usarán otras
 * funciones builder: launch y async
 */
fun main() {
    /**
     * runBlocking es una función builder
     * que crea una corrutina
     * para poder llamar a funciones suspendidas
     */
    println("Se va a iniciar una corrutina...")
    runBlocking {
        doSomethingSlowly()
    }
    println("Corrutina terminada")
}