package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries
import java.text.NumberFormat

fun printThreeMostPopulatedCountriesSum() {
    val result = Countries.WORLD_COUNTRIES
        .sortedByDescending { it.population }
        .take(3)
        .sumOf { it.population ?: 0 }

    println(
        "Población total de los 3 países más poblados del mundo = " +
                "${NumberFormat.getNumberInstance().format(result)} habs."
    )
}

fun main() {
    printThreeMostPopulatedCountriesSum()
}