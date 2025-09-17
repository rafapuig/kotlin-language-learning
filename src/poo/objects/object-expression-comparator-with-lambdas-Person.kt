package poo.objects.expression.comparators.lambdas

import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age
        get() = birth?.until(LocalDate.now())?.years

    override fun compareTo(other: Person) = ageComparator.compare(this, other)

    companion object Comparison {

        val ageComparator = Comparator<Person> { o1: Person, o2: Person ->
            compareValues(o2.birth, o1.birth)
        }

        val nameComparator = Comparator<Person> { o1, o2 ->
             compareValues(o1.firstName,o2.firstName)
        }

        val fullNameComparator =
            compareBy<Person> { it.lastName }.thenBy { it.firstName }

    }

    /**
     * Si lo dejamos aquí cada objeto Person tiene su propia instancia...
     */

    val byAgeComparator = compareBy<Person> { it.age }

    val byBirthComparator = compareByDescending<Person> { it.birth }
}


fun testNameComparator() {
    val people = listOf(
        Person("Amador", "Denador"),
        Person("Belen", "Tilla"),
        Person("Aitor", "Tilla"),
    )

    println(people.sortedWith(Person.fullNameComparator))
    println(people.sortedWith(compareBy<Person> { it.lastName }.thenBy { it.birth }))
}

fun testAgeComparator() {
    val people = listOf(
        Person("Amador", "Denador", LocalDate.of(1990, 5, 18)),
        Person("Belen", "Tilla", LocalDate.of(1985, 4, 30)),
        Person("Aitor", "Tilla", LocalDate.of(1996, 2, 21)),
    )
    val ordered = people.sortedWith(Person.ageComparator)
    println(ordered)
}

fun main() {
    testNameComparator()
    testAgeComparator()
}

