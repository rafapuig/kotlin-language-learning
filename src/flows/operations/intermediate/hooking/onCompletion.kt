package flows.operations.intermediate.hooking

import coroutines.log
import flows.operations.intermediate.getTemperatures
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun main() {
    val temperatures = getTemperatures()

    runBlocking {
        temperatures
            .take(5)
            /**
             * Para comprobar que las 5 lecturas se han completado sin error
             * Si ha habido un error el parámetro de la lambda sera != null
             */
            .onCompletion { cause ->
                /**
                 * Para saber si ha sido cancelado podemos capturar
                 */
                if (cause is CancellationException) {
                    println("El flow ha sido cancelado")
                }
                cause?.let {
                    log("Ha ocurrido un error $cause")
                } ?: log("Lecturas completadas")
                /**
                 * x?.let {a} ?: b Equivale a if(x!=null) a else b
                 */
            }
            .collect { temperature ->
                log("${temperature}ºC")
            }


    }
}