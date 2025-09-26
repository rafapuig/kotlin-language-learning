package functional.intro.operation.structure.extension.methods

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * Esta vez usaremos funciones de extensión
 * Con lo cual el array de personas (los datos) se convierte en el objeto receiver
 * Y para acceder al receiver se usa la referencia this
 * Se puede omitir el this para acceder a los miembros
 * y usar directamente la llamada a los miembros del receiver
 * Es decir, puedo usar:
 * this.isEmpty() o isEmpty()
 */

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

fun Array<Person>.findOldestPerson2(): Person? {
    if (isEmpty()) return null
    var oldestPerson: Person = this[0]
    for (i in 1 until size) {
        if (this[i].age > oldestPerson.age) {
            oldestPerson = this[i]
        }
    }
    return oldestPerson
}

fun Array<Person>.findOldest3(): Person? {
    if (isEmpty()) return null
    var oldestPerson: Person = this[0]
    for (person in slice(1 until size)) {
        if (person.age > oldestPerson.age) {
            oldestPerson = person
        }
    }
    return oldestPerson
}

fun main() {
    /**
     * Ahora la llamada al metodo de extension sitúa a los datos de array
     * como objeto receptor y no como argumento de llamada
     */
    val oldestPerson = friends.findOldest()
    println("Más Viejo = $oldestPerson")
}