package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.toNumericFormat

fun printLeastPopulatedCountry() {
    val result = Countries.WORLD_COUNTRIES
        .minByOrNull { it.population ?: Int.MAX_VALUE }

    printResult(result)
}

fun printLeastPopulatedCountry2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .minByOrNull { it.population!! }

    printResult(result)
}

private fun printResult(country: Country?) {
    val message =
        if (country != null)
            "El país menos poblado es ${country.name} con ${country.population.toNumericFormat()} habitantes"
        else
            "Ninguno"
    println(message)
}

fun main() {
    printLeastPopulatedCountry()
    printLeastPopulatedCountry2()
}