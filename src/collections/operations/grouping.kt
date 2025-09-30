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
 * Genera un mapa
 * La clave de las entradas se forma a partir del resultado de la lambda
 * Y el valor es una lista de elementos para los cuales la lambda devuelve
 * el mismo resultado
 */

fun testGroupBy() {
    val genderGroups =
        people.groupBy { it.gender }
    println(genderGroups)
}

fun testGroupByWithTwoLambdaParameters() {
    val genderNamesMap =
        people.groupBy({ it.gender }, { it.name })
    println(genderNamesMap)
}

fun testGroupByWithTwoLambdaParametersOtherWay() {
    val genderNamesMap =
        people
            .groupBy { it.gender }
            .mapValues { it.value.map { it.name } }
    println(genderNamesMap)
}

fun testGroupByWithTwoLambdaParametersOtherWay2() {
    val genderNamesMap =
        people
            .groupBy { it.gender }
            .mapValues { (genderKey, personList) ->
                personList.map { it.name }
            }
    println(genderNamesMap)
}

fun testGroupByWithTwoLambdaParameters2() {
    val genderNamesMap =
        people.groupBy({ it.gender }) {
            it.name.split(" ").first()
        }
    println(genderNamesMap)
}

fun testGroupByWithTwoLambdaParameters2OtherWay() {
    val genderNamesMap =
        people
            .groupBy { it.gender }
            .mapValues { entry ->
                entry.value.map { person ->
                    person.name.split(" ").first()
                }
            }
    println(genderNamesMap)
}


/**
 * groupingBy
 *
 * Crea una agrupación para ser usada posteriormente
 * con operaciones de agrupamiento y plegado (fold)
 *
 * Devuelve una instancia de Grouping
 * que soporta las siguientes operaciones:
 * - eachCount() que cuenta los elementos de cada grupo
 * - fold() y reduce() que aplican la operación a cada grupo como colección separada
 * - aggregate() aplica la operación a todos los elementos del grupo (es más genérico, usar cuando fold y reduce no son suficiente)
 */

fun testGroupingByEachCount() {
    val genderGrouping =
        people.groupingBy { it.gender }

    val genderCountMap = genderGrouping.eachCount()
    println(genderCountMap)
}

/**
 * En este ejemplo vamos a hacer el equivalente a la función groupBy
 * pero usando groupingBy y fold
 */
fun testGroupingByFold() {
    val genderGrouping =
        people.groupingBy { it.gender }


    // Se crea una lista mutable por cada género para ir acumulando las personas de cada género
    val genderPersonsMap = genderGrouping
        .fold(mutableListOf<Person>()) { accumulator, element ->
            accumulator.apply { this += element } // Añadir el elemento a la lista mutable acumuladora
        }.mapValues { (_, personList) ->
            personList.toList() // Creamos una copia de solo lectura de la lista mutable
        }
}

/**
 * En este ejemplo de uso de la operación reduce sobre un Groping
 * vamos a aplicar la operación reduce para obtener la persona de más edad de cada género
 */
fun testGroupingByReduce() {
    val genderGrouping =
        people.groupingBy { it.gender }

    // Se crea una lista mutable por cada género para ir acumulando las personas de cada género
    val olderPersonByGender = genderGrouping
        .reduce { key, older, element ->
            if (element.age > older.age) element else older
        }

    println(olderPersonByGender)
}

fun testGroupingBy() {
    val genderGrouping =
        people.groupingBy { it.gender }

    // Con fold
    val genderPersons =
        genderGrouping
            .fold(mutableListOf<Person>()) { acc, person ->
                acc.apply { add(person) }
            }.mapValues { (gender, list) -> list.toList() }

    val genderPersons1 =
        genderGrouping
            .fold(mutableListOf<Person>()) { acc, person ->
                acc.apply { this += person }
            }.mapValues { it.value.toList() }


    /**
     * Cuidado!! esta forma no es eficiente,
     * se crea cada vez una nueva lista a partir de la anterior con un nuevo elemento añadido
     */
    val genderPersons2 =
        genderGrouping
            .fold(emptyList<Person>()) { acc, person ->
                acc + person
            }


    // Con aggregate
    val personsByGender =
        genderGrouping
            .aggregate { _, acc: List<Person>?, person, first ->
                (if (first) emptyList() else acc!!) + person
            }

    val personsByGender1 =
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

fun averageAgeByGender(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy({ it.gender }, { it.age })
        .mapValues { entry ->
            entry.value.average()
        }
}

fun averageAgeByGender1(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy { it.gender }
        .mapValues { entry ->
            entry.value.map { it.age }.average()
        }
}

fun averageAgeByGender2(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy { it.gender }
        .mapValues { (gender, peopleByGender) ->
            peopleByGender.map { it.age }.average()
        }
}

fun averageAgeByGender3(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupBy { it.gender }
        .mapValues { (_, peopleByGender) ->
            peopleByGender.map { it.age }.average()
        }
}

fun averageAgeByGender4(persons: List<Person>) =
    persons
        .groupingBy { it.gender }
        .aggregate { key, acc: Pair<Int, Double>?, element, first ->
            if (first) Pair(1, element.age.toDouble()) else acc!!.copy(
                first = acc.first + 1,
                second = acc.second + element.age.toDouble()
            )
        }.mapValues { (key, value) ->
            value.second / value.first
        }


fun averageAgeByGender5(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupingBy { it.gender }
        .let {
            val genderAgesSum =
                it.aggregate { _, accumulator: Double?, element, _ ->
                    (accumulator ?: 0.0) + element.age
                }

            val genderCount = it.eachCount()

            genderAgesSum.mapValues { (gender, sum)
                ->
                sum / genderCount[gender]!!
            }
        }
}


fun averageAgeByGender6(persons: List<Person>): Map<Gender, Double> {
    return persons
        .groupingBy { it.gender }
        .let {
            val sums =
                it.fold(0.0) { acc, person ->
                    acc + person.age
                }
            val genderCount = it.eachCount()

            sums.mapValues { (gender, sum) ->
                sum / genderCount[gender]!!
            }
        }
}


fun main() {
    testGroupBy()
    testGroupByWithTwoLambdaParameters()
    testGroupByWithTwoLambdaParametersOtherWay()
    testGroupByWithTwoLambdaParameters2()
    testGroupByWithTwoLambdaParameters2OtherWay()

    testGroupingByEachCount()
    testGroupingBy()
}