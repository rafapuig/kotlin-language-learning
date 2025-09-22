package functional.intro.operation.structure

data class Person(val name: String, val age: Int)

fun Array<Person>.findOldest(): Person? {
    if (isEmpty()) return null
    var maxAge = 0
    var oldestPerson: Person? = null
    for (person in this) {
        if (person.age > maxAge) {
            maxAge = person.age
            oldestPerson = person
        }
    }
    return oldestPerson
}

fun Array<Person>.findOldest2(): Person? {
    if (isEmpty()) return null
    var oldestPerson: Person = this[0]
    for (person in slice(1 until size)) {
        if (person.age > oldestPerson.age) {
            oldestPerson = person
        }
    }
    return oldestPerson
}

fun Array<Person>.findOldestPerson3(): Person? {
    if (isEmpty()) return null
    var oldestPerson: Person = this[0]
    for (i in 1 until size) {
        if (this[i].age > oldestPerson.age) {
            oldestPerson = this[i]
        }
    }
    return oldestPerson
}

fun main() {
    val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))
    val oldestPerson = friends.findOldest()
    println("Más Viejo = $oldestPerson")
}