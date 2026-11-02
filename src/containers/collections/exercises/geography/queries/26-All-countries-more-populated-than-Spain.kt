package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.formatting.standardCountryNameColumn
import containers.collections.exercises.geography.formatting.standardCountryPopulationColumn
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country

/**
 * Obtener la lista de países más poblados que España
 */

fun getAllCountriesMorePopulatedThanSpain() =
    Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sortedBy { it.population }
        .dropWhile { it.population!! <= Countries.SPAIN.population!! }


fun getAllCountriesMorePopulatedThanSpain2() =
    Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sortedByDescending { it.population }
        .dropLastWhile { it.population!! <= Countries.SPAIN.population!! }

fun getAllCountriesMorePopulatedThanSpain3() =
    Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sortedBy { it.population }
        .takeLastWhile { it.population!! > Countries.SPAIN.population!! }

fun getAllCountriesMorePopulatedThanSpain4() =
    Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sortedByDescending { it.population }
        .takeWhile { it.population!! > Countries.SPAIN.population!! }



private fun List<Country>.prettyPrint() {
    asTable {
        column(standardCountryNameColumn)
        column(standardCountryPopulationColumn)
    }.display("Países más poblados que España")
}


fun main() {
    getAllCountriesMorePopulatedThanSpain().prettyPrint()
    getAllCountriesMorePopulatedThanSpain2().prettyPrint()
    getAllCountriesMorePopulatedThanSpain3().prettyPrint()
    getAllCountriesMorePopulatedThanSpain4().prettyPrint()
}

