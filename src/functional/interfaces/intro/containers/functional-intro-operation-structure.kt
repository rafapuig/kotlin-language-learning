package functional.intro.operation.structure.globalfunctions

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


/**
 * función global, que busca la persona con la mayor edad
 * en el array de personas proporcionado como argumento para el parámetro people
 */
fun findOldest(people: Array<Person>): Person? {
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

/**
 * Otra implementación
 * Asumimos que si el array no esta vacío
 * La persona de mayor edad es la primera del array
 * Y comparamos su edad con las del resto
 */
fun findOldest2(people: Array<Person>): Person? {
    if (people.isEmpty()) return null
    var oldestPerson: Person = people[0]
    for (i in 1 until people.size) {
        if (people[i].age > oldestPerson.age) {
            oldestPerson = people[i]
        }
    }
    return oldestPerson
}

/**
 * Otra implementación
 * Utilizando la función de extension slice
 */
fun findOldest3(people: Array<Person>): Person? {
    if (people.isEmpty()) return null
    var oldestPerson: Person = people[0]
    for (person in people.slice(1 until people.size)) {
        if (person.age > oldestPerson.age) {
            oldestPerson = person
        }
    }
    return oldestPerson
}

fun main() {
    val oldestPerson = findOldest(friends)
    println("Más Viejo = $oldestPerson")
}