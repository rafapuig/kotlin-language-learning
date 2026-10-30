package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.teeing
import containers.collections.exercises.geography.toNumericFormat


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
        println("El país mas poblado es ${it.name} con ${it.population.toNumericFormat()} habitantes")
    }

    /** Al usar ?. ya dentro del bloque this no pude ser nulo */
    result[1]?.apply {
        println("El país menos poblado es $name con ${population.toNumericFormat()} habitantes")
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


    result.first()?.let {
        println("El país mas poblado es ${it.name} con ${it.population.toNumericFormat()} habitantes")
    }

    result.last()?.apply {
        println("El país menos poblado es $name con ${population.toNumericFormat()} habitantes")
    }
}

fun printMostAndLeastPopulatedCountries3() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            it.maxByOrNull { country ->
                country.population!!
            } to it.minByOrNull { country ->
                country.population!!
            }
        }


    with(result) {
        first?.let {
            println("El país más poblado es ${it.name} con ${it.population.toNumericFormat()} habitantes")
        }

        second?.apply {
            println("El país menos poblado es $name con ${population.toNumericFormat()} habitantes")
        }
    }
}


fun printMostAndLeastPopulatedCountries4() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .teeing(
            { it.maxByOrNull { country -> country.population!! } },
            { it.minByOrNull { country -> country.population!! } }
        ) { most, least -> listOf(most, least) }


    with(result) {

        first()?.let {
            println("El país más poblado es ${it.name} con ${it.population.toNumericFormat()} habitantes")
        }

        last()?.apply {
            println("El país menos poblado es $name con ${population.toNumericFormat()} habitantes")
        }
    }
}


fun main() {
    printMostAndLeastPopulatedCountries()
    printMostAndLeastPopulatedCountries2()
    printMostAndLeastPopulatedCountries3()
    printMostAndLeastPopulatedCountries4()
}
