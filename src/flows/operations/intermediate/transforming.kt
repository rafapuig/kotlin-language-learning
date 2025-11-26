package flows.operations.intermediate

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() {
    val names = flowOf(
        "Consuelo Teria",
        "Belen Tilla",
        "Victor Nado",
        "Pedro Gado"
    )

    /**
     * Por cada valor del upstream flow
     * se puede emit 0, 1, 2, ... n valores
     * al downstream
     */
    val upperAndLowercasedNames = names.transform {
        emit(it.uppercase())
        emit(it.lowercase())
    }

    runBlocking {
        upperAndLowercasedNames.collect { name ->
            println(name)
        }
    }

}