package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import java.text.NumberFormat

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
