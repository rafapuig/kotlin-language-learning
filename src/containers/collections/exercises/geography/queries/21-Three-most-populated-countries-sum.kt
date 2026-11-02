package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPopulationFormat
import java.text.NumberFormat

fun printThreeMostPopulatedCountriesSum() {
    val result = Countries.WORLD_COUNTRIES
        .sortedByDescending { it.population }
        .take(3)
        .sumOf { it.population?.toLong() ?: 0L }

    println(
        "Población total de los 3 países más poblados del mundo = ${result.toPopulationFormat()}"
    )
}

fun main() {
    printThreeMostPopulatedCountriesSum()
}