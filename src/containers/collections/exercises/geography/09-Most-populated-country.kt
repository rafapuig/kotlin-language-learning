package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.model.Population


fun printMostPopulatedCountry() {
    val result: Country? = Countries.WORLD_COUNTRIES
        .maxByOrNull{ country -> country.population ?: Int.MIN_VALUE }

    val message =
        if (result != null)
            "El país mas poblado es ${result.name} con ${result.population} habitantes"
        else
            "Ninguno"

    println(message)
}

fun printMostPopulatedCountry2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .maxByOrNull { it.population!! }

    val message =
        if (result != null)
            "El país mas poblado es ${result.name} con ${result.population} habitantes"
        else
            "Ninguno"
    println(message)
}

fun main() {
    printMostPopulatedCountry()
    printMostPopulatedCountry2()
}