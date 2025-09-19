package functional.intro.operation.structure1

data class Person(val name: String, val age: Int)


fun findMaxPerson(people: Array<Person>, comparator: Comparator<Person>): Person? {
    if (people.isEmpty()) return null
    var max: Person = people[0]
    for (person in people.slice(1 until people.size)) {
        if (comparator.compare(person, max) > 0) {
            max = person
        }
    }
    return max
}

fun findMaxPerson2(people: Array<Person>, comparator: Comparator<Person>): Person? {
    if (people.isEmpty()) return null
    var max: Person = people[0]
    for (i in 1 until people.size) {
        if (comparator.compare(people[i], max) > 0) {
            max = people[i]
        }
    }
    return max
}

fun main() {
    val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

    val byAgeComparator : Comparator<Person> = object : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return compareValues(p1.age, p2.age)
        }
    }

    val findOldestPerson = findMaxPerson(friends, byAgeComparator)
    println("Más Viejo = $findOldestPerson")
}