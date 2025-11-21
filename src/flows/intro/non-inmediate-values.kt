package flows.intro

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

/**
 * Una función suspendida puede pausar su ejecución (una o varias veces)
 * Pero, solamente puede devolver un único valor al final
 * (primitivo, objeto, o colección de objetos)
 */

/**
 * La función createValues devuelve de una vez, al final,
 * todos los valores que ha ido calculando
 * transcurridos 3 segundos
 */
private suspend fun createValues(): List<Int> {
    return buildList {
        log("Adding 1...")
        add(1) // El primer elemento esta disponible al instante
        delay(1.seconds)
        log("Adding 2...")
        add(2) // El segundo está disponible después de un segundo
        delay(1.seconds)
        log("Adding 3...")
        add(3) // El tercero está disponible a los 2 segundos
        delay(1.seconds)
    } // La función retorna a los 3 segundos
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

fun main() = runBlocking {
    val list = createValues()
    list.forEach { log(it) }
}

/**
 * En escenarios como este, donde una función calcula varios valores a lo largo
 * del tiempo es deseable que devuelva los valores de manera asincrona
 * en el momento en que estos valores están disponibles
 * en lugar de esperar a tenerlos todos a la vez cuando finaliza su ejecución.
 */