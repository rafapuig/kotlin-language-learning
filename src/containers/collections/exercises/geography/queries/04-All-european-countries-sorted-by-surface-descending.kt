package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.formatting.printAsTable
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

fun getAllEuropeanCountriesSortedBySurfaceDescending() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .sortedByDescending { it.surface }


fun printAllEuropeanCountriesSortedBySurfaceDescending() {

     getAllEuropeanCountriesSortedBySurfaceDescending()
        .printAsTable("Todos los países de ${Continent.EUROPE} ordenados por superficie descendente:")

}

fun main() {
    printAllEuropeanCountriesSortedBySurfaceDescending()
}
