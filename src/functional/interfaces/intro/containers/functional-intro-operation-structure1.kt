package functional.intro.operation.structure.comparator.objectexpression

data class Person(val name: String, val age: Int)

fun Array<Person>.findMax(comparator: Comparator<Person>): Person? {
    if (isEmpty()) return null
    var max: Person = this[0]
    for (i in 1 until size) {
        if (comparator.compare(this[i], max) > 0) {
            max = this[i]
        }
    }
    return max
}

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

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
     */
    val byNameComparator: Comparator<Person> = object : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return compareValues(p1.name, p2.name)
        }
    }

    val max = friends.findMax(byNameComparator)
    println("Máximo = $max")
}


fun main() {
    findMaxByAge()
    findMaxByName()
}