package coroutines.intro

import coroutines.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Awaitable computations
 * Cálculos a los que se puede esperar por el resultado
 *
 * Para realizar computación de manera asíncrona
 * se usa la función builder de corrutinas async
 *
 * La función async devuelve un Deferred<T>
 *
 * Lo más importante que se puede hacer con un objeto Deferred<T>
 * es esperar al resultado mediante la función suspendida await
 */

private suspend fun slowlyAddNumbers(a: Int, b: Int): Int {
    log("Esperado un rato antes de calcular $a + $b ...")
    //delay(100.milliseconds * a)
    Thread.sleep(100L*a)
    return a + b
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

/**
 * El cálculo de 2 + 2 tarda 200 ms
 * El cálculo de 4 +4 tarda 400 ms
 * Pero el tiempo total que tarda el programa no es 600 ms
 * porque ambos cálculos se ejecutan de manera concurrente
 * y, por tanto, obtenemos el primer valor a los 200 ms
 * y el segundo a los 400 ms
 * y en ese momento tenemos los dos resultados
 */
fun main(): Unit = runBlocking {
    log("Comenzando la computacion asíncrona...")
    val firstDeferred = async(Dispatchers.Default) { slowlyAddNumbers(2,2) }
    val secondDeferred = async(Dispatchers.Default) { slowlyAddNumbers(4,4) }

    log("Esperando a que esten disponibles los valores diferidos")
    val firstResult = firstDeferred.await()
    log("El primer resultado esta disponible: $firstResult")

    val secondResult = secondDeferred.await()
    log("El segundo resultado esta disponible: $secondResult")
}

/**
 * En kotlin solamente usamos async cuando queremos ejecutar
 * de manera concurrente tareas independientes y esperar sus resultados
 */