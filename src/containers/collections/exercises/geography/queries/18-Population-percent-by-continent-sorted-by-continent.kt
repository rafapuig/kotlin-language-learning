package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat
import java.util.TreeMap

fun printPopulationPercentByContinentSortedByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null && it.continent != null }
        .let { countries ->
            val total = countries.sumOf { it.population!!.toLong() }
            val continentsTotals = countries
                .groupBy { it.continent!! }
                .mapValues { entry -> entry.value.sumOf { it.population!!.toLong() } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.let { map ->
            TreeMap<Continent, Double>(compareBy { it.displayName }).apply {
                putAll(map)
            }
        }

    result.entries
        .map { it.key to it.value.toPercentFormat() }
        .display("Porcentaje poblacion por continente ordenados por nombre del continente:")
}

fun printPopulationPercentByContinentSortedByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let { countries ->
            val total = countries.sumOf { it.population!!.toLong() }
            val continentsTotals = countries
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!!.toLong() } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.toSortedMap(compareBy { it?.displayName })

    result.entries
        .map { it.key to it.value.toPercentFormat() }
        .display("Porcentaje poblacion por continente ordenados por nombre del continente:")
}



fun main() {
    printPopulationPercentByContinentSortedByContinent()
    printPopulationPercentByContinentSortedByContinent2()
}