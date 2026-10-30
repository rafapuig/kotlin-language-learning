package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toNumericFormat
import containers.collections.exercises.geography.toPopulationFormat
import java.text.NumberFormat

fun printWorldPopulation() {
    val result = Countries.WORLD_COUNTRIES
        .mapNotNull { it.population?.toLong() }
        .sum()

    printResults(result)
}



fun printWorldPopulation2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .map { it.population!!.toLong() }
        .sum()

    printResults(result)
}

fun printWorldPopulation3() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sumOf { it.population!!.toLong() }

    printResults(result)
}

fun printWorldPopulation4() {
    val result = Countries.WORLD_COUNTRIES
        .sumOf { it.population?.toLong() ?: 0L }

    printResults(result)
}

fun printWorldPopulation5() {
    val result = Countries.WORLD_COUNTRIES
        .mapNotNull { it.population?.toLong() }
        .reduce { acc, population -> acc + population }

    printResults(result)
}

private fun printResults(result: Long) {
    println("Poblacion total mundial = ${result.toPopulationFormat()}")
}

fun main() {
    printWorldPopulation()
    printWorldPopulation2()
    printWorldPopulation3()
    printWorldPopulation4()
    printWorldPopulation5()
}