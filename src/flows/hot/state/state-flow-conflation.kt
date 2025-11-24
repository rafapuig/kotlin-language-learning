package flows.hot.state

import coroutines.log
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Un state flow solo emite cuando el valor cambia realmente, esto se denomina: *
 *
 * Equality-based conflation
 */

enum class SwitchState { On, Off }

class Switch {

    private val _state = MutableStateFlow(SwitchState.Off)
    val state: StateFlow<SwitchState> = _state.asStateFlow()

    fun turn(state: SwitchState) {
        _state.update { state }
    }

}

fun main() = runBlocking {
    val switch = Switch()

    /**
     * Corrutina encargada de loggear los cambios de estado del switch
     * Será notificada solamente cuando el valor cambie de On a Off y viceversa
     */
    val logger = launch {
        switch.state.collect {
            log("El interruptor está $it")
        }
    }

    delay(200.milliseconds)
    switch.turn(SwitchState.On) // Cambia el estado de Off a On

    delay(200.milliseconds)
    switch.turn(SwitchState.Off) // Cambia el estado de On a Off

    delay(200.milliseconds)
    switch.turn(SwitchState.Off) // No hay cambio realmente porque estaba en Off

    delay(200.milliseconds)
    switch.turn(SwitchState.Off) // No hay cambio realmente porque estaba en Off

    delay(200.milliseconds)
    switch.turn(SwitchState.On) // Cambia el estado de Off a On

    delay(200.milliseconds)
    switch.turn(SwitchState.On) // No hay cambio realmente porque estaba en On

    delay(200.milliseconds)
    switch.turn(SwitchState.Off) // Cambia el estado de On a Off

    delay(200.milliseconds)
    switch.turn(SwitchState.On) // Cambia el estado de Off a On

    delay(200.milliseconds)
    /**
     * Cancelamos la corrutina hija, lo que dará por concluida la corrutina padre
     * creada con runBlocking
     */
    logger.cancel()
    //coroutineContext.cancelChildren()
}