package poo.objects.nested.comparison.people2

import java.time.LocalDate

val LocalDate?.age get() = this?.until(LocalDate.now())?.years

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age: Int?
        get() = birth.age

    /**
     * La implementación de la interface Comparable
     * delega en el metodo compare del companion object
     * Se comparar dos objetos Person según los compare el comparador por edad
     */
    override fun compareTo(other: Person)= compare(this, other)


    /**
     * De todos los objetos anidados (anidados / nested) de la clase
     * podemos designar a uno (solamente uno) como objeto companion
     * Esto hace que directamente con el nombre de la clase contendora tengamos
     * la referencia a este objeto y podamos llamar a sus miembros
     * mediante la sintaxis:
     * <Clase>.<metodo-objeto-companion>
     */
    companion object ByAgeComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person) =
            -compareValues(p1.birth, p2.birth)

    }

    /**
     * Objeto anidado a la clase
     * Pertenece a la propia clase
     *
     * Los objetos pueden implementar interfaces
     */
    object ByNameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            val lastNameComparison = compareValues(p1.lastName, p2.lastName)
            if (lastNameComparison != 0) return lastNameComparison
            return compareValues(p1.firstName, p2.firstName)
        }
    }

}

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
    println(people.sortedWith(Person.ByNameComparator))
}

fun testAgeComparator() {
    val ordered = people.sortedWith(Person.ByAgeComparator)
    println(ordered)
}

fun testComparison() {
    // Estamos llamando al metodo compare del companion object
    Person.compare(people[0], people[1])

    // Podemos usar el nombre del companion explícitamente para llamar al metodo
    Person.ByAgeComparator.compare(people[0], people[1])

    // Para el resto de objetos anidados hay que usar explícitamente el nombre del objeto
    Person.ByNameComparator.compare(people[0], people[1])
}

fun main() {
    testNameComparator()
    testAgeComparator()
}