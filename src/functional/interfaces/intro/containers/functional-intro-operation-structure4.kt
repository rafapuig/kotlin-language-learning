package functional.intro.operation.structure.comparator.sam.contructor

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


fun Array<Person>.findMax(comparator: Comparator<Person>): Person? {
    if (isEmpty()) return null
    var max: Person = this[0]
    for (person in slice(1 until size)) {
        if (comparator.compare(person, max) > 0) {
            max = person
        }
    }
    return max
}


fun findMaxByAge() {
    /**
     * Para crear el objeto comparador usamos un SAM constructor
     */
    val byAgeComparator: Comparator<Person> = Comparator<Person> { p1, p2 ->
        compareValues(p1.age, p2.age)
    }

    val oldest = friends.findMax(byAgeComparator)
    println("Más Viejo = $oldest")
}

fun findMaxByName() {
    /**
     * Para crear el objeto comparador usamos un SAM constructor
     */
    val byNameComparator = Comparator<Person> { p1, p2 ->
        compareValues(p1.name, p2.name)
    }

    val max = friends.findMax(byNameComparator)
    println("Último alfabeticamente = $max")
}


fun main() {
    findMaxByAge()
    findMaxByName()
}