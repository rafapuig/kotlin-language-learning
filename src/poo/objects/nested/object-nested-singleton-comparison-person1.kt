package poo.objects.singleton.comparison.people

import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age: Int?
        get() = birth?.until(LocalDate.now())?.years

    /**
     * La implementación de la interface Comparable
     * delega en el método compare del companion object
     * Se comparar dos objetos Person según los compare el comparador por edad
     */
    override fun compareTo(other: Person)= compare(this, other)


    /**
     * De todos los objetos anidados (anidados / nested) de la clase
     * podemos designar a uno (solamente uno) como objeto companion
     * Esto hace que directamente con el nombre de la clase contendora tengamos
     * la referencia a este objeto
     */
    companion object AgeComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person) =
            compareValues(p2.birth, p1.birth)

    }

    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            val lastNameComparison = compareValues(p1.lastName, p2.lastName)
            if (lastNameComparison != 0) return lastNameComparison
            return compareValues(p1.firstName, p2.firstName)
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
        Person("Aitor", "Tilla", LocalDate.of(1996, 2, 21)),
    )
    val ordered = people.sortedWith(Person.AgeComparator)
    println(ordered)
}

fun main() {
    testNameComparator()
    testAgeComparator()
}