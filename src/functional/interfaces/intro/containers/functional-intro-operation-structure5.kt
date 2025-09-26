package functional.intro.operation.structure.comparator.interfacelambdas

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
     * Podemos pasar de manera literal el argumento para el parámetro comparator
     * si hacemos uso de una expresión lambda
     */
    val oldest = friends.findMax ({ p1, p2 ->
        compareValues(p1.age, p2.age)
    })
    println("Más Viejo = $oldest")
}

fun findMaxByName() {
    /**
     * Como la expresión lambda es el argumento del último parámetro
     * la podemos sacar fuera de los paréntesis de llamada
     * Y como los paréntesis se quedan vacíos podemos eliminarlos
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