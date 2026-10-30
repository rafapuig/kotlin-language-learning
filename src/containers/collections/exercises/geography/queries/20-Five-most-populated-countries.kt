package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPopulationFormat

fun printFiveMostPopulatedCountries() {
    val result = Countries.WORLD_COUNTRIES
        .sortedByDescending { it.population }
        .take(5)

    result
        .map { it.name to it.population.toPopulationFormat() }
        .display("Los 5 países más poblados del mundo:")
}

fun main() {
    printFiveMostPopulatedCountries()
}