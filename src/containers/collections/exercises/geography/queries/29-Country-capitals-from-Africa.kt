package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.formatting.printAsTable
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import java.text.NumberFormat

fun getCountryCapitalsFromAfrica() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AFRICA }
        .mapNotNull { it.capital }


fun getCountryCapitalsFromAfricaWithCountryName() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AFRICA }
        .map { it.name to it.capital }


fun printCountryCapitalsFromAfrica() {
    getCountryCapitalsFromAfrica().printAsTable()
}

fun printCountryCapitalsFromAfricaWithCountryName() {
    getCountryCapitalsFromAfricaWithCountryName()
        .asTable {
            column {
                label = "país"
                width = 12
                value = { it.first }
            }
            column {
                label = "capital"
                width = 12
                value = { it.second?.name }
            }
            column {
                label = "poblacion"
                width = 10
                format = NumberFormat.getNumberInstance()
                value = { it.second?.population?.value }
            }
        }.display("")
}

fun main() {
    printCountryCapitalsFromAfrica()
    printCountryCapitalsFromAfricaWithCountryName()
}
