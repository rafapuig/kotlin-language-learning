package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPopulationFormat

fun printEuropePopulation() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .mapNotNull { it.population }
        .reduce { acc, population -> acc + population }

    println("Poblacion total de Europa = ${result.toPopulationFormat()}")
}

fun main() {
    printEuropePopulation()
}
