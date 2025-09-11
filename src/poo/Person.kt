package poo.people

import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age: Int?
        //    get() = Period.between(birth, LocalDate.now()).years
        //get() = ChronoUnit.YEARS.between(birth, LocalDate.now()).toInt()
        get() = birth?.until(LocalDate.now())?.years

    override fun compareTo(other: Person): Int = AgeComparator.compare(this, other)

    object AgeComparator : Comparator<Person> {
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
            //compareBy<Person> { it.lastName }.compare(o1, o2)
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

fun main() {

    testNameComparator()

    val today = LocalDate.of(1981, 1, 3)
    val person = Person("Bob", birth = LocalDate.of(1980, 1, 1))

    val result = person.birth?.until(today.plusDays(1))?.days

    println(result)

}