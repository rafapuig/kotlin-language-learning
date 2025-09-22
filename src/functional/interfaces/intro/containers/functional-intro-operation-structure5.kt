package functional.intro.operation.structure.selector.lambdas.explicit.inside

data class Person(val name: String, val age: Int)

fun interface KeySelector<T, K : Comparable<K>> {
    fun extract(t: T): K
}

fun <T,K: Comparable<K>> Array<T>.findMaxBy(keySelector: KeySelector<T, K>): T? {
    if (isEmpty()) return null
    var max : T = this[0]
    var maxKey = keySelector.extract(max)
    for (i in 1 until size) {
        val key = keySelector.extract(this[i])
        if (key > maxKey) {
            max = this[i]
            maxKey = key
        }
    }
    return max
}

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


fun findMaxPersonByAge() {
    val oldest = friends.findMaxBy({ person -> person.age })
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val maxPerson = friends.findMaxBy({ person -> person.name })
    println("Máximo = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}