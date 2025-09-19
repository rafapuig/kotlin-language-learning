package functional.intro.operation.structure

data class Person(val name: String, val age: Int)

fun findOldestPerson(people: Array<Person>): Person? {
    if (people.isEmpty()) return null
    var maxAge = 0
    var oldestPerson: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            oldestPerson = person
        }
    }
    return oldestPerson
}

fun findOldestPerson2(people: Array<Person>): Person? {
    if (people.isEmpty()) return null
    var oldestPerson: Person = people[0]
    for (person in people.slice(1 until people.size)) {
        if (person.age > oldestPerson.age) {
            oldestPerson = person
        }
    }
    return oldestPerson
}

fun findOldestPerson3(people: Array<Person>): Person? {
    if (people.isEmpty()) return null
    var oldestPerson: Person = people[0]
    for (i in 1 until people.size) {
        if (people[i].age > oldestPerson.age) {
            oldestPerson = people[i]
        }
    }
    return oldestPerson
}

fun main() {
    val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))
    val findOldestPerson = findOldestPerson(friends)
    println("Más Viejo = $findOldestPerson")
}