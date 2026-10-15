package poo.objects.expression.comparators.lambdas

import java.time.LocalDate

val LocalDate?.age get() =  this?.until(LocalDate.now())?.years

data class Person(
    val firstName: String,
    val lastName: String = "",
    val birth: LocalDate? = null
) : Comparable<Person> {

    val age
        get() = birth.age

    override fun compareTo(other: Person) = ageComparator.compare(this, other)

    companion object Comparison {

        // Es más joven (menor edad) el que nace despues (fecha nacimiento mayor)
        val ageComparator = Comparator<Person> { o1: Person, o2: Person ->
            compareValues(o2.birth, o1.birth) // Ponemos invertidos o2 y o1
        }

        val nameComparator = Comparator<Person> { o1, o2 ->
            compareValues(o1.firstName, o2.firstName)
        }

        val fullNameComparator = Comparator<Person> { p1, p2 ->
            compareValuesBy(p1,p2, Person::lastName, Person::firstName)
        }


        val byFullNameComparator =
            compareBy<Person> { it.lastName }.thenBy { it.firstName }


        val byAgeComparator = compareBy<Person> { it.age }

        val byBirthComparator = compareByDescending<Person> { it.birth }
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

    val peopleSortedByLastNameAndFirstName =
        people.sortedWith(Person.nameComparator)

    println(peopleSortedByLastNameAndFirstName)
}


fun testAgeComparator() {

    val sortedByAgePeople = people.sortedWith(Person.ageComparator)

    println(sortedByAgePeople)
}





fun main() {
    testNameComparator()
    testAgeComparator()


    people.sortedWith(Person.byFullNameComparator)
    println(people)

    people.sortedWith(Person.byAgeComparator)
    println(people)

    people.sortedWith(Person.byBirthComparator)
    println(people)

    people.sortedWith { p1, p2 -> compareValues(p1.age, p2.age) }
}


