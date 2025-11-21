package coroutines.builders

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

/**
 * Ejemplo de ejecución entrelazada entre corrutinas sin paralelismo
 * (todas las corrutinas se ejecutan en el mismo hilo)
 *
 * En este ejemplo todas las corrutinas corren en el mismo hilo: main
 *
 * La primera corrutina (padre) la crea e inicia la función runBlocking
 * Esta corrutina padre crea y lanza 2 corrutinas hijas mediante la función launch
 *
 * La corrutina 2 se ejecuta hasta que se suspende (delay) en el hilo main
 *
 * Cuando se suspende la corrutina 2 deja libre el hilo main para que se ejecute
 * la corrutina 3
 *
 * Cuando pasan los 100 milisegundos se retoma su ejecución
 *
 * Cuando terminan todas la corrutinas hijas se da por teminada la ejecucion
 * de la corrutina padre
 */
fun main() {
    //log("Entrando en el reino de las corrutinas ........")
    runBlocking {
        log("Inicia de la primera corrutina, padre...")
        /**
         * Se usa launch para crear e iniciar una nueva corrutina (lanzarla)
         * apropiada para las tareas de tipo "iniciar y olvidar"
         * La utilidad de lanzarla es por el efecto secundario (side effect) que produce
         *
         * launch devuelve un Job (para controlar la ejecución de la corrutina)
         */
        launch {
            log("Empieza la segunda corrutina (y esta lista para ser suspendida)...")
            delay(100.milliseconds) // Se suspenderá por esta llamada a delay
            log("Se reanuda la segunda corrutina!")
        }
        launch {
            log("Una tercera corrutina puede ejecutarse mientras tanto !!!")
        }
        log("La primera corrutina ha lanzado dos corrutinas mas.")
    }
    log("Vuelta al mundo de la ejecución secuencial :(")
}