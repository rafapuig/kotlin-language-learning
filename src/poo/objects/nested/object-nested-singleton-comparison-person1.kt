package poo.objects.nested.comparison.people1

/**
 * Usamos data clase porque nos interesa el toString automático que genera
 */
data class Person(val name: String, val age: Int) {

    /**
     * Se puede declarar un objeto anidado dentro de una clase
     * El objeto pertenece directamente a la propia clase
     */
    object ByNameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }

    /**
     * Los objetos singleton (anidados o no) pueden implementar interfaces y heredar de una superclase
     */
    object ByAgeComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            compareValuesBy(p1, p2, Person::age)
    }
}

val people = listOf(
    Person("Ramon", 50),
    Person("Rafa", 48),
    Person("Emilio", 49)
)


fun main() {

    // Imprime una lista de personas ordenadas usando el objeto ByNameComparator anidado en la clase Person
    println(people.sortedWith(Person.ByNameComparator))

    // Ahora se ordenan utilizando el otro objeto comparador ByAgeComparator
    println(people.sortedWith(Person.ByAgeComparator))

    // La lista original NO se modifica, sortedWith genera nuevas listas con los elementos de la original
    println(people)
}