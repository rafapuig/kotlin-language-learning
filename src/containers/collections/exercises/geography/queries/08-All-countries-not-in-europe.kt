package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import kotlin.collections.contains

fun printAllCountriesNotInEurope() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent !in setOf(Continent.EUROPE) }

    result.display("Todos los países que no están en Europa:")
}

fun main() {
    printAllCountriesNotInEurope()
}