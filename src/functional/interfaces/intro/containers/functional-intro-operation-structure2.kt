package functional.intro.operation.structure.comparator.interfacelambdas

data class Person(val name: String, val age: Int)


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


val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

fun findMaxByAgeWithLambdaToFunInterface() {
    /**
     * Para crear el objeto comparador usamos un SAM constructor
     */
    val byAgeComparator: Comparator<Person> = Comparator<Person> { p1, p2 ->
        compareValues(p1.age, p2.age)
    }

    val oldest = friends.findMax(byAgeComparator)
    println("Más Viejo = $oldest")
}

fun findMaxByNameeWithLambdaToFunInterface() {
    /**
     * Para crear el objeto comparador usamos un SAM constructor
     */
    val byNameComparator: Comparator<Person> = Comparator<Person> { p1, p2 ->
        compareValues(p1.name, p2.name)
    }

    val findOldestPerson = friends.findMax(byNameComparator)
    println("Máximo = $findOldestPerson")
}

fun testCompareByAgeWithLambda() {
    val findOldestPerson = friends.findMax { p1, p2 ->
        compareValues(p1.age, p2.age)
    }
    println("Más Viejo = $findOldestPerson")
}

fun testFindMaxByNameLambda() {
    val findOldestPerson = friends.findMax { p1, p2 ->
        compareValues(p1.name, p2.name)
    }
    println("Máximo = $findOldestPerson")
}


fun main() {
    findMaxByAgeWithLambdaToFunInterface()
    findMaxByNameeWithLambdaToFunInterface()
    testCompareByAgeWithLambda()
    testFindMaxByNameLambda()
}