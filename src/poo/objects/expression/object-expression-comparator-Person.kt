package poo.objects.expression.comparators

import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

//fun LocalDate.age() = Period.between(this, LocalDate.now()).years
//fun computeAge(date: LocalDate) = ChronoUnit.YEARS.between(date, LocalDate.now()).toInt()

fun LocalDate?.age() = this?.until(LocalDate.now())?.years

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age: Int?
        get() = birth.age()


    companion object Comparison {
        /**
         * Expresión Objeto
         * utilizada para crear un objeto de tipo anónimo
         */
        val nameComparator = object : Comparator<Person> {

            override fun compare(p1: Person, p2: Person): Int {
                if (p1 === p2) return 0
                /*val lastNameComparison = p1.lastName.compareTo(p2.lastName)
                if (lastNameComparison != 0) return lastNameComparison*/
                p1.lastName.compareTo(p2.lastName).also { comparison ->
                    if (comparison != 0) return comparison
                }
                return p1.firstName.compareTo(p2.firstName)
            }
        }

        /**
         * Expresión Objeto
         * utilizada para crear un objeto de tipo anónimo
         */
        val ageComparator = object : Comparator<Person> {
            override fun compare(p1: Person, p2: Person): Int =
            // Multiplicamos por -1 para invertir el resultado
                // Ya que si nacimiento1 < nacimiento2 --> edad1 > edad2 y persona1 > persona2
                compareValues(p1.birth, p2.birth) * -1
        }
    }

    /**
     * La comparación por defecto entre objetos Person
     * se va a realizar atendiendo al criterio de la edad (fecha de nacimiento)
     */
    override fun compareTo(other: Person): Int = ageComparator.compare(this, other)


    object Comparators {

        val byAgeComparator = compareBy<Person> { it.age }

        val byBirthComparator = compareByDescending<Person> { it.birth }
    }
}

val Person.Comparison.fullNameComparator: Comparator<Person>
    get() = compareBy<Person> { it.lastName }.thenBy { it.firstName }


/**
 * Lista de personas ejemplo
 */
val people = listOf(
    Person(
        "Amador",
        "Denador",
        LocalDate.of(1990, 5, 18)
    ),
    Person(
        "Belen",
        "Tilla",
        LocalDate.of(1985, 4, 30)
    ),
    Person(
        "Aitor",
        "Tilla",
        LocalDate.of(1996, 2, 21)
    ),
)


fun testNameComparator() {

    val peopleSortedByLastNameAndFirstName =
        people.sortedWith(Person.nameComparator)

    println(peopleSortedByLastNameAndFirstName)
}


fun testAgeComparator() {

    val sortedByAgePeople = people.sortedWith(Person.ageComparator)

    println(sortedByAgePeople)
}


fun testCompareBy() {

    val sortedPeople =
        people.sortedWith(compareBy<Person> { it.lastName }.thenBy { it.birth })

    println(sortedPeople)
}


fun main() {
    //testNameComparator()
    //testAgeComparator()
    //testCompareBy()

    people.sortedWith(Person.fullNameComparator)
    println(people)

    people.sortedWith(Person.Comparators.byAgeComparator)
    println(people)

    people.sortedWith(Person.Comparators.byAgeComparator)
    println(people)

    people.sortedWith { p1, p2 -> compareValues(p1.age, p2.age) }
}
