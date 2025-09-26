package functional.intro.operation.structure.selector.member.reference

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * Cuando un metodo se denomina invoke podemos declararlo como operador
 * De esta manera podemos omitir el nombre del metodo al hacer la llamada
 * Por ejemplo,
 * Si tenemos una referencia a un objeto que implementa el interface en uan variable con nombre extractor
 * podemos llamar al metodo invoke de dos maneras
 * extractor.invoke(elem)
 * o sin especificar el nombre del metodo invoke
 * extractor(elem)
 * pareciendo como si extractor fuera una función en lugar de una variable objeto
 */
fun interface KeyExtractor<T, K : Comparable<K>> {
    operator fun invoke(element: T): K
}

/**
 * Ahora el parámetro se denomina extract en lugar de extractor
 */
fun <T,K: Comparable<K>> Array<T>.findMaxBy(extract: KeyExtractor<T, K>): T? {
    if (isEmpty()) return null
    var maxElement: T = this[0]
    var maxKey : K = extract(maxElement)
    for (elem in slice(1 until size)) {
        val key = extract(elem)
        if (key > maxKey) {
            maxElement = elem
            maxKey = extract(elem)
        }
    }
    return maxElement
}




fun findMaxPersonByAge() {
    /**
     * Llamada al metodo de extension genérico findMaxBy
     * los argumentos de los parámetros de tipo se especifican de forma explícita
     * se usa una referencia a metodo como argumento para el parámetro selector
     */
    val oldest = friends.findMaxBy<Person, Int>(Person::age)
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val maxPerson = friends.findMaxBy(Person::name)
    println("Último alfabeticamente = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}