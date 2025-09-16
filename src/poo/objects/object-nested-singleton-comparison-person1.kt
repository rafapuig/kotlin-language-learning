package poo.objects.singleton.comparison.people

import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age: Int?
        get() = birth?.until(LocalDate.now())?.years

    override fun compareTo(other: Person): Int = AgeComparator.compare(this, other)


    companion object AgeComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = run {
            if (o1 === o2) return 0
            if (o2.birth == null) return -1
            else o2.birth.compareTo(o1.birth)
        }
    }

    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            val lastNameComparison = compareValues(o1.lastName, o2.lastName)
            if (lastNameComparison != 0) return lastNameComparison
            return o1.firstName.compareTo(o2.firstName)
        }
    }

}

fun testNameComparator() {
    val people = listOf(
        Person("Amador", "Denador"),
        Person("Belen", "Tilla"),
        Person("Aitor", "Tilla"),
    )

    println(people.sortedWith(Person.NameComparator))
    println(people.sortedWith(compareBy<Person> { it.lastName }.thenBy { it.birth }))
}

fun testAgeComparator() {
    val people = listOf(
        Person("Amador", "Denador", LocalDate.of(1990, 5, 18)),
        Person("Belen", "Tilla", LocalDate.of(1985, 4, 30)),
        Person("Aitor", "Tilla", LocalDate.of(1996,2, 21)),
    )
    val ordered =  people.sortedWith(Person.AgeComparator)
    println(ordered)
}

fun main() {
    testNameComparator()
    testAgeComparator()
}