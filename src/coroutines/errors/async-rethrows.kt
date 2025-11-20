package coroutines.errors

import coroutines.log
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferredInt = async {
        throw UnsupportedOperationException("Ups!")
    }
    try {
        val i = deferredInt.await() // Relanza la excepcion
        log(i)
    } catch (e: UnsupportedOperationException) {
        log("Controlada $e")
    }

}