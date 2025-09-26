package functional.intro.operation.structure.selector.interfacelambdas

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * Si hacemos que interface sea funcional
 * (añadiendo la palabra fun antes de interface)
 * Podremos usar expresiones lambda y SAM Constructor (como con Comparator)
 */
fun interface KeyExtractor<T, K : Comparable<K>> {
    fun extract(element: T): K
}

fun <T ,K: Comparable<K>> Array<T>.findMaxBy(extractor: KeyExtractor<T,K>): T? {
    if (isEmpty()) return null
    var maxElement: T = this[0] // Aqui this se refiere al objeto receiver, el array
    /**
     * Dentro del bloque lambda de la scope function with
     * this se refiere al primer argumento de la llamada a with, en este caso extractor
     */
    with(extractor) {
        var maxKey : K = this.extract(maxElement)
        for (elem in slice(1 until size)) {
            val key = this.extract(elem)
            if (key > maxKey) {
                maxElement = elem
                maxKey = this.extract(elem)
            }
        }
    }

    return maxElement
}


fun findMaxPersonByAge() {

    /**
     * Utilizando un SAM Constructor
     */
    val ageExtractor = KeyExtractor<Person, Int> { person -> person.age }

    val oldest = friends.findMaxBy(ageExtractor)
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {

    val nameExtractor = KeyExtractor<Person, String> { person -> person.name }

    val max = friends.findMaxBy(nameExtractor)
    println("Último alfabeticamente = $max")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}