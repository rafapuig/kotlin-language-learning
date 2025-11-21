package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * Para determinar si una corrutina ha sido cancelada
 * podemos comprobar la propiedad de tipo Boolean isActive del scope
 * si es false indica que ya no está activa.
 *
 * Podemos, al comprobar que ya no está activa terminar el trabajo que consideremos
 * oportuno, cerrar recursos, etc antes de retornar.
 *
 * También podemos usar la función ensureActive()
 */

private suspend fun doCpuHeavyWork(): Int {
    log("Estoy trabajando...")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
    }
    log("Trabajo terminado!")
    return counter
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */


fun main() {
    runBlocking {
        /**
         * Lanzamos la corrutina en el dispatcher Default porque
         * si la dejamos en el hilo main de la corrutina padre (runBlocking)
         * cuando esta corrutina padre haga el delay de 600 ms y se suspenda
         * ya no habrá oportunidad de retomar la ejecución (y, por tanto, cancelar)
         * hasta que no haya terminado la corrutina hija (launch) sin haberla cancelado
         */
        val job = launch(Dispatchers.Default) {
            repeat(5) {
                doCpuHeavyWork()
                /**
                 * Ahora antes hacer una nueva repetición del bucle
                 * comprobamos si la corrutina ha sido cancelada
                 * Para decidir si continuamos con una nueva repetición (hasta la quinta)
                 * o retornamos de la corrutina (terminamos la tarea)
                 */
                log("Corrutina activa? $isActive")
                if(!isActive) return@launch //o throw CancellationException()
            }
        }

        /**
         * Para que se pueda despachar la corrutina creada con launch tiene
         * que haber un punto de suspension en la corrutina runBlocking
         * para esto sirve además el delay en este ejemplo
         */
        delay(600.milliseconds)
        /**
         * Al cancelar la tarea (corrutina) la propiedad isActive del contexto de la corrutina
         * pasa a valer true, lo que permitirá decidir si parar o seguir
         * (lo normal seria liberar los recursos y parar)
         */
        log("Cancelando la corrutina hija...")
        job.cancel()
    }
}