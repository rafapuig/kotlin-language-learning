package flows.operations.intermediate

import coroutines.log
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
    val names = flow {
        emit("Consuelo Teria")
        emit("Belen Tilla")
        emit("Victor Nado")
        emit("Pedro Gado")
    }

    val uppercasedNames = names.map {
        it.uppercase()
    }

    runBlocking {
        uppercasedNames.collect { name ->
            log(name)
        }
    }

}