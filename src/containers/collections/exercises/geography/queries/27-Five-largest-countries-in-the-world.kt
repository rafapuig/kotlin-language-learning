package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.formatting.standardCountryNameColumn
import containers.collections.exercises.geography.formatting.standardCountrySurfaceColumn
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country

/**
 * Obtener los 5 países más grandes (superficie) del mundo
 */

fun getFiveLargestCountries() =
    Countries.WORLD_COUNTRIES
        .sortedByDescending { it.surface }
        .take(5)


private fun List<Country>.prettyPrint() {
    asTable {
        column(standardCountryNameColumn)
        column(standardCountrySurfaceColumn)
    }.display("Los cinco países mas grandes del mundo:")
}

fun main() {
    getFiveLargestCountries().prettyPrint()
}