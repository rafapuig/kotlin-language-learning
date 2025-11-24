package flows.cold

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking
import model.geography.City

val cities = listOf(
    "Valencia",
    "Madrid",
    "Sevilla",
    "Bilbao",
    "Barcelona",
)

/**
 * Iterable cuenta con un metodo de extensión que crea un cold flow
 * que produce (emite) valores a partir de iterar los elementos
 */
val citiesFlow = cities.asFlow()


fun main() = runBlocking {
    citiesFlow.collect {
        println(it)
    }
}

