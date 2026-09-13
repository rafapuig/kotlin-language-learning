package poo.objects.nested.comparison.people1

data class Person(val name: String, val age: Int) {

    /**
     * Se puede declarar un objeto anidado dentro de una clase
     * El objeto pertenece directamente a la propia clase
     */
    object ByNameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }

    object ByAgeComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            compareValuesBy(p1, p2, Person::age)
    }
}

val people = listOf(
    Person("Rafa", 48),
    Person("Emilio", 49)
)

fun main() {

    println(people.sortedWith(Person.ByNameComparator))

    println(people.sortedWith(Person.ByAgeComparator))
}