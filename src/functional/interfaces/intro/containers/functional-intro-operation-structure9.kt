package functional.intro.operation.structure.selector.lambdas.explicit.inside

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

fun interface KeyExtractor<T, K : Comparable<K>> {
    fun extract(element: T): K
}

fun <T,K: Comparable<K>> Array<T>.findMaxBy(extractor: KeyExtractor<T, K>): T? {
    if (isEmpty()) return null
    var maxElement: T = this[0]
    /**
     * Dentro del bloque lambda de la scope function with
     * this se refiere al primer argumento de la llamada a with, en este caso extractor
     * y lo podemos omitir al llamar al metodo extract
     */
    with(extractor) {
        var maxKey : K = extract(maxElement)
        for (elem in slice(1 until size)) {
            val key = extract(elem)
            if (key > maxKey) {
                maxElement = elem
                maxKey = extract(elem)
            }
        }
    }
    return maxElement
}


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