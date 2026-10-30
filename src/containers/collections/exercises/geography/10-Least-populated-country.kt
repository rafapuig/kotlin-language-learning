package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries

fun printLeastPopulatedCountry() {
    val result = Countries.WORLD_COUNTRIES
        .minByOrNull { it.population ?: Int.MAX_VALUE }

    val message =
        if (result != null) "El país menos poblado es ${result.name} con ${result.population} habitantes" else "Ninguno"
    println(message)
}

fun printLeastPopulatedCountry2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .minByOrNull { it.population!! }

    val message =
        if (result != null) "El país menos poblado es ${result.name} con ${result.population} habitantes" else "Ninguno"
    println(message)
}

fun main() {
    printLeastPopulatedCountry()
    printLeastPopulatedCountry2()
}