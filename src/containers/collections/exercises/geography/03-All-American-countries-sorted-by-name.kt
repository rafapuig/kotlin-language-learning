package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country

fun printAllAmericanCountriesSortedByName() {

    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedBy { it.name }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("----------------------------------------------------------")
    result.forEach { println(it) }
}


fun printAllAmericanCountriesSortedByName1() {

    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedBy(Country::name) // Usando una referencia a metodo

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
        .sortedWith { c1, c2 ->
            compareBy<Country> { it.name }.compare(c1, c2)
        }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("---------------------------------------------------------------")
    result.forEach { println(it) }
}


fun printAllAmericanCountriesSortedByName4() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 ->
            compareValues(c1.name, c2.name)
        }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("---------------------------------------------------------------")
    result.forEach { println(it) }
}


fun printAllAmericanCountriesSortedByName5() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 ->
            compareValuesBy(c1, c2) {it.name}
        }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("---------------------------------------------------------------")
    result.forEach { println(it) }
}


fun printAllAmericanCountriesSortedByName6() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 ->
            compareValuesBy(c1, c2, Country::name)
        }

    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("---------------------------------------------------------------")
    result.forEach { println(it) }
}


fun main() {
    printAllAmericanCountriesSortedByName()
}