package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries

fun printPopulationPercentByContinentSortedByPopulationDescending() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!! }
            val continentsTotals = it
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!! } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.entries
        .sortedByDescending { it.value }
        .associate { it.key to it.value }

    result.entries.display("Porcentaje poblacion por continente:")
}

fun main() {
    printPopulationPercentByContinentSortedByPopulationDescending()
}