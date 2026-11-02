package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries

fun printCountriesNamesByContinentSorted() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues {
            it.value.map {
                    country -> country.name
            }.sorted()
        }

    result.entries.display("Todos los nombres países por continente:")
}

fun main() {
    printCountriesNamesByContinentSorted()
}