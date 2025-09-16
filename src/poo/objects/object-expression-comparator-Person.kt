package poo.objects.expression.comparators

import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age: Int?
        //    get() = Period.between(birth, LocalDate.now()).years
        //get() = ChronoUnit.YEARS.between(birth, LocalDate.now()).toInt()
        get() = birth?.until(LocalDate.now())?.years

    override fun compareTo(other: Person): Int = ageComparator.compare(this, other)

    companion object Comparison {
        val ageComparator = object : Comparator<Person> {
            override fun compare(o1: Person, o2: Person): Int = run {
                if (o1 === o2) return 0
                if (o2.birth == null) return -1
                else o2.birth.compareTo(o1.birth)
            }
        }

        val nameComparator = object : Comparator<Person> {
            override fun compare(o1: Person, o2: Person): Int {
                val lastNameComparison = compareValues(o1.lastName, o2.lastName)
                if (lastNameComparison != 0) return lastNameComparison
                return o1.firstName.compareTo(o2.firstName)
            }
        }

    }

    /**
     * Si lo dejamos aquí cada objeto Person tiene su propia instancia...
     */
    val fullNameComparator =
        compareBy<Person> { it.lastName }.thenBy { it.firstName }

    val byAgeComparator = compareBy<Person> { it.age }

    val byBirthComparator = compareByDescending<Person> { it.birth }
}



fun testNameComparator() {
    val people = listOf(
        Person("Amador", "Denador"),
        Person("Belen", "Tilla"),
        Person("Aitor", "Tilla"),
    )

    println(people.sortedWith(Person.nameComparator))
    println(people.sortedWith(compareBy<Person> { it.lastName }.thenBy { it.birth }))
}

fun testAgeComparator() {
    val people = listOf(
        Person("Amador", "Denador", LocalDate.of(1990, 5, 18)),
        Person("Belen", "Tilla", LocalDate.of(1985, 4, 30)),
        Person("Aitor", "Tilla", LocalDate.of(1996,2, 21)),
    )
    val ordered =  people.sortedWith(Person.ageComparator)
    println(ordered)
}

fun main() {

    testNameComparator()
    testAgeComparator()

    testTimeInterval()

}



private fun testTimeInterval() {
    val today = LocalDate.of(1981, 1, 3)
    val person = Person("Bob", birth = LocalDate.of(1980, 1, 1))

    val result = person.birth?.until(today.plusDays(1))?.days

    println(result)
}