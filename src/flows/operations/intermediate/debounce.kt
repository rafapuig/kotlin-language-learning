package flows.operations.intermediate


import coroutines.log
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * debounce es un operador intermedio que:
 *
 * Retrasa la emisión de un valor durante un cierto tiempo.
 * Si llega un nuevo valor antes de que pase ese tiempo, descarta el anterior.
 * Solo emite el último valor recibido después de que haya pasado el periodo de silencio (inactividad).
 *
 * Es decir: espera a que el flujo deje de emitir por un tiempo, y entonces emite el último valor.
 *
 * Se usa cuando no quieres reaccionar a cada emisión, sino solo a la última emisión después de que la actividad pare.
 *
 * Ejemplos típicos:
 * - Búsqueda en tiempo real mientras el usuario escribe (esperar a que deje de teclear).
 * - Manejar eventos rápidos de sensores. *
 * - Evitar sobrecargar la UI con actualizaciones constantes.
 */

/**
 * Simulamos la introducción de caracteres por teclado de un usuario
 */
val searchQuery = flow {
    emit("R")
    delay(100.milliseconds)
    emit("Ra")
    delay(200.milliseconds)
    emit("Rafa")
    delay(500.milliseconds)
    emit("Rafael")
}

@OptIn(FlowPreview::class)
fun main() = runBlocking {
    searchQuery
        .debounce(250.milliseconds) // Filtra un valor si llega otro nuevo antes del timeout
        .collect {
            log("Buscando $it")
        }
}