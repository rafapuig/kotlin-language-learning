package flows.operations.terminal

import coroutines.log
import flows.operations.intermediate.custom.latency
import flows.operations.intermediate.getTemperatures
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * collectLatest es un operador terminal de Kotlin Flow
 * que se usa cuando quieres procesar solo el valor más reciente
 * y cancelar el procesamiento anterior si llega un nuevo valor.
 *
 * Es muy útil para Flows de eventos rápidos o UI,
 * donde no quieres que la operación anterior siga corriendo *
 * si llega un nuevo dato.
 *
 * Cómo funciona:
 * - Cuando llega un valor al Flow, se ejecuta el bloque de collectLatest. *
 * - Si llega otro valor mientras se procesa el anterior,
 * se cancela automáticamente la ejecución previa y comienza con el nuevo. *
 * - Solo el último valor recibido es procesado completamente si no hay valores nuevos en medio.
 *
 * Cuándo usar collectLatest
 * - Procesos costosos que se vuelven obsoletos si llega un nuevo valor *
 * - Actualización de UI a partir de eventos rápidos (por ejemplo, búsqueda en tiempo real) *
 * - Flujos de animaciones, GPS, sensores, o cualquier flujo de datos continuo
 *
 * Diferencia con collect*
 * - collect procesa todos los valores, uno tras otro, sin cancelar nada. *
 * - collectLatest cancela el procesamiento anterior si llega un nuevo valor antes de que termine.
 */


fun main() = runBlocking {
    getTemperatures()
        .latency { (1..3).random() * 40L }
        .take(5)
        .collectLatest {
            log("Inicio procesado de $it")
            delay(100.milliseconds) // Simula trabajo largo
            log("Fin de procesado de $it")
        }
}