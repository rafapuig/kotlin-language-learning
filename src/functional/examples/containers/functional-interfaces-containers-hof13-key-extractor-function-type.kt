package functional.intro.operation.structure.selector.functiontype

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


/**
 * Cambiamos la interface funcional por una función
 * El parámetro extract es de tipo función (T) -> K
 */
fun <T, K : Comparable<K>> Array<T>.findMaxBy(extract: (T) -> K): T? {
    var maxElement: T = this.firstOrNull() ?: return null
    var maxKey = extract(maxElement)
    for (elem in slice(1 until size)) {
        val key = extract(elem)
        if (key > maxKey) {
            maxElement = elem
            maxKey = key
        }
    }
    return maxElement
}


fun findMaxPersonByAge() {
    /**
     * El tipo T se infiere mediante el receiver friends que es Array<Person> luego T es Person
     * El tipo K se infiere a partir de la lambda it.age es Int
     */
    val oldest = friends.findMaxBy { it.age }
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val maxPerson = friends.findMaxBy { it.name }
    println("Último por orden alfabético = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}