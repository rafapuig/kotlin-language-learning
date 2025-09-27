package collections.exercises.geography

import kotlin.collections.LinkedHashMap

import generics.functions.display
import model.geography.Area
import model.geography.Continent
import model.geography.Countries
import model.geography.Country
import java.text.NumberFormat
import java.util.TreeMap

fun <T> Collection<T>.display(title: String) {
    println(title)
    println("-".repeat(title.length))
    this.forEach { println(it) }
}

/**
 * Obtiene todos los países de Europa
 */

fun printAllEuropeanCountries() {

    val result = Countries.WORLD_COUNTRIES.filter { it.continent == Continent.EUROPE }

    println("Todos los países de ${Continent.EUROPE}:")
    println("----------------------------------------")

    result.forEach { println(it) }
}

/**
 * Obtiene todos los países de Europa ordenados por su orden natural
 */
fun printAllEuropeanCountriesSorted() {

    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .sorted()

    println("Todos los países de ${Continent.EUROPE} por orden natural:")
    println("----------------------------------------------------------")
    result.forEach { println(it) }
}

fun printAllAmericanCountriesSortedByName() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedBy { it.name }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("----------------------------------------------------------")
    result.forEach { println(it) }
}

fun printAllAmericanCountriesSortedByName2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith(compareBy { it.name })

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("---------------------------------------------------------------")
    result.forEach { println(it) }
}

fun printAllAmericanCountriesSortedByName3() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 -> compareBy<Country> { it.name }.compare(c1, c2) }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("---------------------------------------------------------------")
    result.forEach { println(it) }
}

fun printAllEuropeanCountriesSortedBySurfaceDescending() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .sortedByDescending { it.surface }

    println("Todos los países de ${Continent.EUROPE} ordenados por superficie descendente:")
    println("-----------------------------------------------------------------------------")
    result.forEach { println(it) }
}

fun printAllCountriesNamesSorted() {
    val result = Countries.WORLD_COUNTRIES
        .map { it.name }
        .sorted()

    result.display("Todos los nombres países ordenados:")
}

fun printCountriesNamesByContinentSorted() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues { it.value.map { it.name }.sorted() }

    result.entries.display("Todos los nombres países por continente:")
}

fun printAllCountriesWithKnownSurface() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.surface != null }

    data class NameSurfaceTuple(val name: String, val surface: Area?)

    result
        .map { NameSurfaceTuple(it.name, it.surface) }
        .display("Todos los países con superficie conocida:")
}

fun printAllCountriesNotInEurope() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent !in setOf(Continent.EUROPE) }

    result.display("Todos los paises que no estan en Europa:")
}


fun printMostPopulatedCountry() {
    val result = Countries.WORLD_COUNTRIES
        .maxByOrNull { it.population ?: Int.MIN_VALUE }

    val message =
        if (result != null) "El pais mas poblado es ${result.name} con ${result.population} habitantes" else "Ninguno"
    println(message)
}

fun printMostPopulatedCountry2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .maxByOrNull { it.population!! }

    val message =
        if (result != null) "El pais mas poblado es ${result.name} con ${result.population} habitantes" else "Ninguno"
    println(message)
}

fun printLeastPopulatedCountry() {
    val result = Countries.WORLD_COUNTRIES
        .minByOrNull { it.population ?: Int.MAX_VALUE }

    val message =
        if (result != null) "El pais menos poblado es ${result.name} con ${result.population} habitantes" else "Ninguno"
    println(message)
}

fun printLeastPopulatedCountry2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .minByOrNull { it.population!! }

    val message =
        if (result != null) "El pais menos poblado es ${result.name} con ${result.population} habitantes" else "Ninguno"
    println(message)
}

fun printMostAndLeastPopulatedCountries() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val most = it.maxByOrNull { country -> country.population!! }
            val least = it.minByOrNull { country -> country.population!! }
            listOf(most, least)
        }

    /** Al usar ?. ya dentro del bloque it no pude ser nulo */
    result[0]?.let {
        println("El pais mas poblado es ${it.name} con ${it.population} habitantes")
    }

    /** Al usar ?. ya dentro del bloque this no pude ser nulo */
    result[1]?.apply {
        println("El pais menos poblado es $name con $population habitantes")
    }
}


fun printMostAndLeastPopulatedCountries2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val (most, least) =
                it.maxByOrNull { country -> country.population!! } to
                        it.minByOrNull { country -> country.population!! }
            listOf(most, least)
        }

    /** Al usar ?. ya dentro del bloque it no pude ser nulo */
    result[0]?.let {
        println("El pais mas poblado es ${it.name} con ${it.population} habitantes")
    }

    /** Al usar ?. ya dentro del bloque this no pude ser nulo */
    result[1]?.apply {
        println("El pais menos poblado es $name con $population habitantes")
    }
}

inline fun <T, A, B, R> Iterable<T>.teeing(
    f1: (Iterable<T>) -> A,
    f2: (Iterable<T>) -> B,
    merge: (A, B) -> R
): R = merge(f1(this), f2(this))

fun printMostAndLeastPopulatedCountries3() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .teeing(
            { it.maxByOrNull { country -> country.population!! } },
            { it.minByOrNull { country -> country.population!! } }
        ) { most, least -> listOf(most, least) }


    /** Al usar ?. ya dentro del bloque it no pude ser nulo */
    result[0]?.let {
        println("El pais mas poblado es ${it.name} con ${it.population} habitantes")
    }

    /** Al usar ?. ya dentro del bloque this no pude ser nulo */
    result[1]?.apply {
        println("El pais menos poblado es $name con $population habitantes")
    }
}

fun printMostPopulatedCountryByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues { it.value.maxByOrNull { it.population!! } }

    result.entries.display("Pais mas poblado por continente:")
}


fun printMostAndLeastPopulatedCountryByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues {
            val most = it.value.maxByOrNull { it.population!! }
            val least = it.value.minByOrNull { it.population!! }
            listOf(most, least)
        }

    result.entries.display("Pais mas y menos poblado por continente:")
}

fun printMostAndLeastPopulatedCountryByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues {
            it.value.teeing(
                { it.maxByOrNull { it.population ?: Int.MIN_VALUE } },
                { it.minByOrNull { it.population ?: Int.MAX_VALUE } },
            ) { most, least -> listOf(most, least) }
        }

    result.entries.display("Pais mas y menos poblado por continente:")
}

fun printWorldPopulation() {
    val result = Countries.WORLD_COUNTRIES
        .mapNotNull { it.population }
        .sum()

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .map { it.population!! }
        .sum()

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation3() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sumOf { it.population!! }

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation4() {
    val result = Countries.WORLD_COUNTRIES
        .sumOf { it.population ?: 0 }

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
}

fun printWorldPopulation5() {
    val result = Countries.WORLD_COUNTRIES
        .mapNotNull { it.population }
        .reduce { acc, population -> acc + population }

    println("Poblacion total mundial = ${NumberFormat.getNumberInstance().format(result)} habs.")
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
    /*printAllEuropeanCountries()
    printAllEuropeanCountriesSorted()
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
    printPopulationPercentByContinentSortedByContinent()
    printPopulationPercentByContinentSortedByContinent2()
    printPopulationPercentByContinentSortedByPopulationDescending()
    printFiveMostPopulatedCountries()
    printThreeMostPopulatedCountriesSum()
}


