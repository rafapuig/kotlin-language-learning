package functional.intro.operation.structure.comparator.objectexpression

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * función findMax
 * Recibe un comparador de personas y lo utiliza como estrategia para compararlas
 */
fun Array<Person>.findMax(comparator: Comparator<Person>): Person? {
    if (isEmpty()) return null
    var max: Person = this[0]
    for (person in this.slice(1 until size)) {
        if (comparator.compare(person, max) > 0) {
            max = person
        }
    }
    return max
}


fun findMaxByAge() {
    /**
     * Creamos un comparador mediante una expresión objeto
     * que compara dos personas usando la edad
     */
    val byAgeComparator: Comparator<Person> = object : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return compareValues(p1.age, p2.age)
        }
    }

    val oldest = friends.findMax(byAgeComparator)
    println("Más Viejo = $oldest")
}


fun findMaxByName() {
    /**
     * Creamos un comparador mediante una expresión objeto
     * que compara dos personas usando el nombre
     *
     * Podemos usar un expresión-body en la función compare
     * y la inferencia de tipos en la declaración de la variable byNameComparator
     * para reducir algo el código
     */
    val byNameComparator = object : Comparator<Person> {
        override fun compare(p1: Person, p2: Person) =
            compareValues(p1.name, p2.name)
    }

    val max = friends.findMax(byNameComparator)
    println("Último alfabeticamente = $max")
}


fun main() {
    findMaxByAge()
    findMaxByName()
}