package functional.intro.operation.structure.selector.interfacelambdas

data class Person(val name: String, val age: Int)

fun interface KeySelector<T, K : Comparable<K>> {
    fun extract(t: T): K
}


fun <T : Comparable<T>> Array<Person>.findMaxBy(keySelector: KeySelector<Person, T>): Person? {
    if (isEmpty()) return null
    var maxPerson: Person = this[0]
    var max = keySelector.extract(maxPerson)
    for (person in slice(1 until size)) {
        val personKey = keySelector.extract(person)
        if (personKey > max) {
            maxPerson = person
            max = keySelector.extract(person)
        }
    }
    return maxPerson
}



val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


fun findMaxPersonByAge() {

    val ageExtractor = KeySelector<Person, Int> { person -> person.age }

    val oldest = friends.findMaxBy(ageExtractor)
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {

    val nameExtractor = KeySelector<Person, String> { person -> person.name }

    val maxPerson = friends.findMaxBy(nameExtractor)
    println("Máximo = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}