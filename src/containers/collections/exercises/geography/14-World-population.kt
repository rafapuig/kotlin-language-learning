package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries
import java.text.NumberFormat

fun printWorldPopulation() {
    val result = Countries.WORLD_COUNTRIES
        .mapNotNull { it.population }
        .sum()

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .map { it.population!! }
        .sum()

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation3() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sumOf { it.population!! }

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation4() {
    val result = Countries.WORLD_COUNTRIES
        .sumOf { it.population ?: 0 }

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation5() {
    val result = Countries.WORLD_COUNTRIES
        .mapNotNull { it.population }
        .reduce { acc, population -> acc + population }

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun main() {
    printWorldPopulation()
    printWorldPopulation2()
    printWorldPopulation3()
    printWorldPopulation4()
    printWorldPopulation5()
}