package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat
import containers.collections.exercises.geography.toPopulationFormat
import java.text.NumberFormat

fun printPopulationPercentByContinentSortedByPopulationDescending() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!!.toLong() }
            val continentsTotals = it
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!!.toLong() } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.entries
        .sortedByDescending { it.value }
        .associate { it.key to it.value }

    result.entries
        .map { it.key to it.value.toPercentFormat() }
        .display("Porcentaje poblacion por continente:")
}

fun main() {
    printPopulationPercentByContinentSortedByPopulationDescending()
}