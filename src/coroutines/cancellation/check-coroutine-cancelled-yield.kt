package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * La función yield es una función suspendible
 * que introduce un punto en el código donde se puede lanzar una CancellationException
 * (y cancelar la corrutina)
 * y además permite que otras corrutinas puedan ejecutar su trabajo de manera concurrente
 * en un dispatcher ocupado, ya que hace al dispatcher cambiar y ejecutar otra corrutina
 * (si hay alguna esperando)
 */

private suspend fun doCpuHeavyWork(): Int {
    log("Estoy trabajando!")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
        //yield()
    }
    return counter
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */


fun main() {
    /**
     * Todas las corrutinas corren de manera concurrente en el hilo main
     * Por tanto, al no haber ningún yield
     * se ejecuta completamente el código de la corrutina runBlocking (#1)
     * después completamente el de la corrutina #2
     * y por último el de la corrutina #3
     */
    runBlocking {//#1

        //Primero se repiten todas las llamadas de esta corrutina
        launch {//#2
            repeat(3) {
                doCpuHeavyWork()
            }
        }

        // Luego van las 3 llamadas de la corrutina 3
        launch {//#3
            repeat(3) {
                doCpuHeavyWork()
            }
        }

    }
}