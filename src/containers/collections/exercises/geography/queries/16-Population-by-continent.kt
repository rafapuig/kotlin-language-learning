package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat
import containers.collections.exercises.geography.toPopulationFormat

fun printPopulationByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues { it.value.mapNotNull { it.population?.toLong() }.sum() }

    result.entries
        .map { it.key to it.value.toPopulationFormat() }
        .display("Poblacion total por continente:")
}

fun printPopulationByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues {
            it.value.mapNotNull { it.population?.toLong() }
                .reduce { acc, population -> acc + population }
        }

    result.entries
        .map { it.key to it.value.toPopulationFormat() }
        .display("Poblacion total por continente:")
}

fun main() {
    printPopulationByContinent()
    printPopulationByContinent2()
}