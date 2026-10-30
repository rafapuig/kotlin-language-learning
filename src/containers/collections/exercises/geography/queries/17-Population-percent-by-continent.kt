package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat


fun printPopulationPercentByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!!.toLong() }
            val continentsTotals = it
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!!.toLong() } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }

    result.entries
        .map { it.key to it.value.toPercentFormat() }
        .display("Porcentaje poblacion por continente:")
}


fun printPopulationPercentByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!!.toLong() }
            val continentsTotals = it
                .groupingBy { it.continent }
                .fold(0L) { acc, country ->
                    acc + country.population!!.toLong()
                }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }

    result.entries
        .map { it.key to it.value.toPercentFormat() }
        .display("Porcentaje poblacion por continente:")
}

fun main() {
    printPopulationPercentByContinent()
    printPopulationPercentByContinent2()
}

