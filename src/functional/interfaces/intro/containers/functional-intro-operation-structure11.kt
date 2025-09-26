package functional.intro.operation.structure.selector.lambdas.implicit.outside

data class Person(val name: String, val age: Int)

/**
 * Cambiamos el nombre del metodo por invoke
 */
fun interface KeyExtractor<T, K : Comparable<K>> {
    fun invoke(element: T): K
}

fun <T,K: Comparable<K>> Array<T>.findMaxBy(extractor: KeyExtractor<T, K>): T? {
    if (isEmpty()) return null
    var maxElement: T = this[0]
    var maxKey : K = extractor.invoke(maxElement)
    for (elem in slice(1 until size)) {
        val key = extractor.invoke(elem)
        if (key > maxKey) {
            maxElement = elem
            maxKey = extractor.invoke(elem)
        }
    }
    return maxElement
}

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


fun findMaxPersonByAge() {
    val oldest = friends.findMaxBy { it.age }
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val maxPerson = friends.findMaxBy { it.name }
    println("Máximo = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}