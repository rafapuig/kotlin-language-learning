package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import java.text.NumberFormat
import java.util.*

fun <T> Collection<T>.display(title: String) {
    println(title)
    println("-".repeat(title.length))
    this.forEach { println(it) }
}







fun printEuropePopulation() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .mapNotNull { it.population }
        .reduce { acc, population -> acc + population }

    println("Poblacion total de Europa = ${NumberFormat.getNumberInstance().format(result)} habs.")
}


fun printPopulationByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues { it.value.mapNotNull { it.population }.sum() }

    result.entries.display("Poblacion total por continente:")
}

fun printPopulationByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues { it.value.mapNotNull { it.population }.reduce { acc, population -> acc + population } }

    result.entries.display("Poblacion total por continente:")
}


fun printPopulationPercentByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!! }
            val continentsTotals = it
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!! } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }

    result.entries.display("Porcentaje poblacion  por continente:")
}

fun printPopulationPercentByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!! }
            val continentsTotals = it
                .groupingBy { it.continent }
                .fold(0) { acc, country ->
                    acc + country.population!!
                }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }

    result.entries.display("Porcentaje poblacion  or continente:")
}


fun printPopulationPercentByContinentSortedByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null && it.continent != null }
        .let { countries ->
            val total = countries.sumOf { it.population!! }
            val continentsTotals = countries
                .groupBy { it.continent!! }
                .mapValues { entry -> entry.value.sumOf { it.population!! } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.let { map ->
            TreeMap<Continent, Double>(compareBy { it.displayName }).apply {
                putAll(map)
            }
        }

    result.entries.display("Porcentaje poblacion por continente ordenados por nombre del continente:")
}

fun printPopulationPercentByContinentSortedByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let { countries ->
            val total = countries.sumOf { it.population!! }
            val continentsTotals = countries
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!! } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.toSortedMap(compareBy { it?.displayName })

    result.entries.display("Porcentaje poblacion por continente ordenados por nombre del continente:")
}


fun printPopulationPercentByContinentSortedByPopulationDescending() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!! }
            val continentsTotals = it
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!! } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }.entries
        .sortedByDescending { it.value }
        .associate { it.key to it.value }

    result.entries.display("Porcentaje poblacion por continente:")
}


fun printFiveMostPopulatedCountries() {
    val result = Countries.WORLD_COUNTRIES
        .sortedByDescending { it.population }
        .take(5)

    result.display("Los 5 países más poblados del mundo:")
}


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
    printAllEuropeanCountries()
    /*printAllEuropeanCountriesSorted()
    printAllAmericanCountriesSortedByName()
    printAllEuropeanCountriesSortedBySurfaceDescending()
    printAllCountriesNamesSorted()
    printCountriesNamesByContinentSorted()
    printAllCountriesWithKnownSurface()
    printAllCountriesNotInEurope()
    printMostPopulatedCountry()
    printLeastPopulatedCountry()
    printMostAndLeastPopulatedCountries()
    printMostAndLeastPopulatedCountries3()
    printMostPopulatedCountryByContinent()
    printMostAndLeastPopulatedCountryByContinent()
    printWorldPopulation()
    printWorldPopulation5()*/
    //printPopulationByContinent()
    //printPopulationPercentByContinent()
    //printPopulationPercentByContinentSortedByContinent()
    //printPopulationPercentByContinentSortedByContinent2()
    //printPopulationPercentByContinentSortedByPopulationDescending()
    //printFiveMostPopulatedCountries()
    //printThreeMostPopulatedCountriesSum()
}


