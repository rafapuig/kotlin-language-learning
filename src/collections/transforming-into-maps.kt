package collections

import collections.model.Gender
import collections.model.Person
import collections.model.people
import kotlin.collections.component2

/**
 * groupBy
 *
 * Divide los elementos de una colección en grupos
 * Cada grupo se almacena en una lista
 */

fun testGroupBy() {
    val genderGroups =
        people.groupBy { it.gender }
    println(genderGroups)
}

fun main() {
    testGroupBy()
    testGroupingBy()
}

/**
 * groupingBy
 *
 * Crea una agrupación para ser usada posteriormente con operaciones de agrupamiento y plegado (fold)
 */

fun testGroupingBy() {
    val genderGrouping =
        people.groupingBy { it.gender }

    val groups =
        genderGrouping
            .fold(mutableListOf<Person>()) { acc, person ->
                acc.apply { add(person) }
            }.mapValues { (_, list) -> list.toList() }


    // Con aggregate
    val personsByGender =
        genderGrouping
            .aggregate { _, acc: List<Person>?, person, first ->
                if (first) listOf(person) else acc!! + person
            }

    val personsByGender2 =
        genderGrouping
            .aggregate { _, acc: List<Person>?, person, _ ->
                (acc ?: emptyList()) + person
            }

    println(personsByGender)
}

fun averageAgeByGender1(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy { it.gender }
        .mapValues { entry -> entry.value.map { it.age }.average() }
}

fun averageAgeByGender2(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy { it.gender }
        .mapValues { (gender, peopleByGender) -> peopleByGender.map { it.age }.average() }
}

fun averageAgeByGender3(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy { it.gender }
        .mapValues { (_, peopleByGender) -> peopleByGender.map { it.age }.average() }
}

fun averageAgeByGender4(persons: List<Person>)=
    persons
        .groupingBy { it.gender }
        .aggregate { key, acc: Pair<Int, Double>?, element, first ->
            if(first) Pair(1, element.age.toDouble()) else acc!!.copy(
                first = acc.first + 1,
                second = acc.second + element.age.toDouble()
            )
        }.mapValues { (key, value) ->
            value.second / value.first
        }


fun averageAgeByGender5(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupingBy { it.gender }
        .aggregate { key, accumulator, element, _ ->
            (accumulator?: 0.0) + element.age
        }
}

fun averageAgeByGender6(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupingBy { it.gender }
        .fold(0.0) { acc, person -> acc + person.age }
}