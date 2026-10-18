package functional.intro.operation.structure.globalfunctions

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


/**
 * función global, que busca la persona con la mayor edad
 * en el array de personas proporcionado como argumento para el parámetro people
 */
fun findOldest(people: Array<Person>): Person? {
    // Si el array está vacío devolver nulo
    if (people.isEmpty()) return null

    // Variable para almacenar la edad de la persona con mayor edad
    var maxAge : Int = Int.MIN_VALUE
    // Variable para almacenar la referencia a la persona de mayor edad
    var oldestPerson: Person? = null

    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            oldestPerson = person
        }
    }
    return oldestPerson
}


fun findOldest1(people: Array<Person>): Person? {
    // Si el array está vacío devolver nulo
    if (people.isEmpty()) return null

    // Variable para almacenar la referencia a la persona de mayor edad
    var oldestPerson: Person? = null

    for (person in people) {
        if (person.age > (oldestPerson?.age ?: Int.MIN_VALUE)) {
            oldestPerson = person
        }
    }
    return oldestPerson
}


/**
 * Otra implementación
 * Asumimos que si el array no está vacío
 * La persona de mayor edad es la primera del array
 * Y comparamos su edad con las del resto
 */
fun findOldest2(people: Array<Person>): Person? {
    if (people.isEmpty()) return null

    // Inicialmente la primera persona es la persona de más edad
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


/**
 * Otra implementación
 * Utilizando la función de extension slice y foreach
 */
fun findOldest4(people: Array<Person>): Person? {
    if (people.isEmpty()) return null
    var oldestPerson: Person = people[0]

   people.slice(1..<people.size).forEach {person ->
       if (person.age > oldestPerson.age) {
           oldestPerson = person
       }
   }

    return oldestPerson
}


fun testFindOldest() {
    val oldestPerson = findOldest(friends)
    println("Más Viejo = $oldestPerson")
}

fun testFindOldest1() {
    val oldestPerson = findOldest1(friends)
    println("Más Viejo = $oldestPerson")
}

fun testFindOldest2() {
    val oldestPerson = findOldest2(friends)
    println("Más Viejo = $oldestPerson")
}

fun testFindOldest3() {
    val oldestPerson = findOldest3(friends)
    println("Más Viejo = $oldestPerson")
}

fun testFindOldest4() {
    val oldestPerson = findOldest4(friends)
    println("Más Viejo = $oldestPerson")
}


fun main() {
    testFindOldest()
    testFindOldest1()
    testFindOldest2()
    testFindOldest3()
    testFindOldest4()
}