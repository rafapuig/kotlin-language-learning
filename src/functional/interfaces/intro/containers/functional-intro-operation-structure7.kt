package functional.intro.operation.structure.selector.expression.objects

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * Declaramos un interface KeyExtractor
 * Servirá para que los objetos que lo implementen indiquen como
 * obtener el valor de un atributo de un objeto
 * Este interface declara dos parámetros de tipo
 * T - será el tipo de elemento al que se le obtiene el valor de alguna de sus propiedades
 * K - es el tipo de la propiedad cuyo valor es obtenido
 */
interface KeyExtractor<in T, K : Comparable<K>> {
    /**
     * El metodo extracto obtiene el valor de un atributo del objeto de tipo T
     * proporcionado por el parámetro element
     * el valor del atributo es de tipo K y es el valor retornado
     */
    fun extract(element: T): K
}

/**
 * Podemos usar un singleton
 */
object AgeExtractor : KeyExtractor<Person, Int> {
    override fun extract(element: Person): Int = element.age
}

/**
 * O una expresión objeto y guardar la referencia en una variable
 */
val nameExtractor: KeyExtractor<Person, String> = object : KeyExtractor<Person, String> {
    override fun extract(element: Person): String = element.name
}


fun <T, K : Comparable<K>> Array<T>.findMaxBy(extractor: KeyExtractor<T, K>): T? {
    if (isEmpty()) return null
    var maxElement: T = this[0]
    var maxKey: K = extractor.extract(maxElement)
    for (elem  in  slice(1 until size)) {
        val key = extractor.extract(elem)
        if (key > maxKey) {
            maxElement = elem
            maxKey = key
        }
    }
    return maxElement
}


fun findMaxPersonByAge() {
    val oldest = friends.findMaxBy(AgeExtractor)
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val max = friends.findMaxBy(nameExtractor)
    println("Último alfabeticamente = $max")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}