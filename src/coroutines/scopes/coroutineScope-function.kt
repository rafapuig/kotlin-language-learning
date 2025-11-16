package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Crear un ámbito de corrutina
 *
 * La función coroutineScope
 */

/**
 * Cuando creamos un corrutina con las funciones builder crean su propio CoroutineScope
 *
 * Podemos agrupar corrutinas usando un scope creado por nosotros,
 * sin que sea necesario tener que crear una nueva corrutina.
 *
 * La función coroutineScope es una función suspendida que crea un nuevo coroutine scope
 * y espera a que terminen todas las corrutinas hijas de ese scope para dar por terminada
 * la ejecución de la función.
 *
 * El caso típico de uso es la descomposición de trabajo
 */

suspend fun generateValue(): Int {
    log("Generando un valor aleatorio...")
    delay(500.milliseconds) // Supendemos la función durante 500 milisegundos
    return (0..10).random()
}

suspend fun computeSum() {
    log("Calculando la suma...")
    val sum = coroutineScope {
        val a = async { generateValue() }
        val b = async { generateValue() }
        /**
         *  El resultado devuelto por la lambda
         *  es el devuelto por la función coroutineScope
         *  que espera a que acaben sus corrutinas hijas para terminar
         */
        a.await() + b.await()
    }
    log("Suma = $sum")
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

fun main() = runBlocking {
    computeSum()
}