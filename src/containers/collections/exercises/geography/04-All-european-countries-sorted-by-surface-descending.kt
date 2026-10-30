package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

fun printAllEuropeanCountriesSortedBySurfaceDescending() {

    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .sortedByDescending { it.area }

    println("Todos los países de ${Continent.EUROPE} ordenados por superficie descendente:")
    println("-----------------------------------------------------------------------------")
    result.forEach { println(it) }
}

fun main() {
    printAllEuropeanCountriesSortedBySurfaceDescending()
}
