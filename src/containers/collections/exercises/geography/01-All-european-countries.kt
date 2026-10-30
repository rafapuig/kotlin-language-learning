package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

/**
 * Obtiene todos los países de Europa
 */

fun printAllEuropeanCountries() {

    val result = Countries.WORLD_COUNTRIES.filter {
        it.continent == Continent.EUROPE
    }

    println("Todos los países de ${Continent.EUROPE}:")
    println("----------------------------------------")

    result.forEach { println(it) }
}

fun main() {
    printAllEuropeanCountries()
}