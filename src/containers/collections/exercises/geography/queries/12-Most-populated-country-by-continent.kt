package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPopulationFormat

fun printMostPopulatedCountryByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues { it.value.maxByOrNull { it.population!! } }

    result
        .mapValues { it.value?.name to it.value?.population.toPopulationFormat() }
        .entries.display("Pais más poblado por continente:")
}

fun printMostPopulatedCountryByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filterNot { it.population == null }
        .groupBy { it.continent }
        .mapValues { entry ->
            entry.value.maxByOrNull { it.population!! }?.let { country ->
                country.name to country.population
            }
        }

    result
        .mapValues { it.value?.first to it.value?.second.toPopulationFormat() }
        .entries.display("Pais más poblado por continente:")
}

fun main() {
    printMostPopulatedCountryByContinent()
    printMostPopulatedCountryByContinent2()
}