package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries

fun printAllCountriesNamesSorted() {
    val result = Countries.WORLD_COUNTRIES
        .map { it.name }
        .sorted()

    result.display("Todos los nombres países ordenados:")
}

fun main() {
    printAllCountriesNamesSorted()
}