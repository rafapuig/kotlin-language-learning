package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.formatting.standardCountryNameColumn
import containers.collections.exercises.geography.formatting.standardCountryPopulationDensityColumn
import containers.collections.exercises.geography.formatting.standardCountrySurfaceColumn
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country

/**
 * Obtener los 5 países con mayor densidad de población en el mundo
 */

fun getFiveDenserCountries() =
    Countries.WORLD_COUNTRIES
        .sortedByDescending { it.populationDensity }
        .take(5)


private fun List<Country>.prettyPrint() {
    asTable {
        column(standardCountryNameColumn)
        column(standardCountryPopulationDensityColumn)
    }.display("Los cinco países mayor densidad de poblacion del mundo:")
}

fun main() {
    getFiveDenserCountries().prettyPrint()
}