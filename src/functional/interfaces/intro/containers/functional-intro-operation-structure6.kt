package functional.intro.operation.structure.comparator.interfacelambdas.generic

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * Podemos hacer que la función findMax sea genérica
 * y en lugar de trabajar solamente con personas generalizamos a trabajar con
 * elementos del array de tipo T
 */
fun <T> Array<T>.findMax(comparator: Comparator<T>): T? {
    if (isEmpty()) return null
    var max: T = this[0]
    for (person in slice(1 until size)) {
        if (comparator.compare(person, max) > 0) {
            max = person
        }
    }
    return max
}


fun findMaxByAge() {
    /**
     * Como se trata de una función generica debemos proporcionar
     * además de los argumentos de llamada de la lista de parámetros de entrada
     * el argumento del parámetro de tipo T
     */
    val oldest = friends.findMax<Person> ({ p1, p2 ->
        compareValues(p1.age, p2.age)
    })
    println("Más Viejo = $oldest")
}

fun findMaxByName() {
    /**
     * El argumento del parámetro de tipo se puede inferir a partir de friends : Array<Person>
     */
    val max = friends.findMax { p1, p2 ->
        compareValues(p1.name, p2.name)
    }
    println("Último alfabeticamente = $max")
}


fun main() {
    findMaxByAge()
    findMaxByName()
}