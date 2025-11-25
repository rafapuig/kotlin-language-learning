package coroutines.errors

import coroutines.log
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    launch {
        try {
            throw UnsupportedOperationException("Ups!")
        } catch (e: UnsupportedOperationException) {
            log("Controlada $e") // Si se captura, se maneja
        }
    }
}
