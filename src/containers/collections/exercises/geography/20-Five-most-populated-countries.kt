package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries

fun printFiveMostPopulatedCountries() {
    val result = Countries.WORLD_COUNTRIES
        .sortedByDescending { it.population }
        .take(5)

    result.display("Los 5 países más poblados del mundo:")
}

fun main() {
    printFiveMostPopulatedCountries()
}