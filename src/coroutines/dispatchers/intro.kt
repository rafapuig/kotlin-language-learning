package coroutines.dispatchers

import coroutines.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatchers
 *
 * Decidir en que hilo debe correr el código de una corrutina
 *
 * Al elegir un dispatcher
 * se puede confinar la ejecución de una corrutina a un hilo especifico
 * o un pool de hilos
 *
 * Las corrutinas no están vinculadas a un hilo particular
 * se puede supender su ejecución en un hilo y retomarla
 * en otro hilo distinto
 *
 * De esto se encarga el dispatcher
 *
 * Dispatchers.Default
 * Dispatchers.Main
 * Dispatchers.IO
 *
 * Dispatchers.Default
 * - Un pool con tantos hilos como CPU cores disponibles
 * - Distribuye las corrutinas para que puedan correr en paralelo
 *   en maquinas multicore
 *
 * Dispatchers.Main
 * - Usado en frameworks (JavaFX, Android, etc) donde se necesita
 * restringir ciertas operaciones a un hilo específico denominado
 * hilo de la UI o hilo principal (main) como el redibujado de
 * los elementos la interfaz de usuario.
 *
 * En Android la implementación de Dispatchers.Main se encuentra
 * en el artefacto org.jetbrains.kotlinx:kotlinx-coroutines-android
 *
 *
 * Tareas bloqueantes de entrada / salida
 * Dispatchers.IO
 * Cuando tenemos que usar una API bloqueante (no usa corrutinas)
 * Si usamos el Dispatchers.Default podemos agotar el número de cores
 * disponibles si invocamos tantas operaciones que bloquean el hilo
 * como cores disponemos y ninguna otra corrutinas podrá correr
 * mientras alguna de las otras operaciones termine.
 *
 * El dispatcher de IO esta pensado para estos escenarios.
 *
 * El pool de hilos no es fijo sino que escala automaticamente,
 * y la corrutina se aloja en alguno de esos hilos donde
 * queda a la espera de que la llamada bloqueante a la API retorne.
 * Este tipo de tareas se consideran non-CPU intensive
 * (no requieren CPU y la mayor parte del tiempo esperan IO)
 *
 */

/**
 * Para que una corrutina corra en un dispatcher específico
 * hay que pasar un dispatcher como argumento de llamada
 * a la función builder (runBlocking, launch, async)
 */

fun main() {
    runBlocking {
        log("Haciendo algo de trabajo...")
        launch(Dispatchers.Default) {
            log("Haciendo un trabajo en segundo plano !!!")
        }
    }
}