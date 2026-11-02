package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries

/**
 * Obtener los nombres ordenados alfabéticamente de todos los países
 */

fun getAllCountriesNamesSorted() =
    Countries.WORLD_COUNTRIES
        .map { it.name }
        .sorted()

fun printAllCountriesNamesSorted() {
    val result = getAllCountriesNamesSorted()
    result.display("Todos los nombres países ordenados:")
}

fun main() {
    printAllCountriesNamesSorted()
}