package functional.intro.operation.structure.selector.functiontype.lambda.with.receiver

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


/**
 * Cambiamos la interface funcional por una función
 * El parámetro extract es de tipo función T.() -> K (una función aplicada a un receiver de tipo T)
 */
fun <T, K : Comparable<K>> Array<T>.findMaxBy(extract: T.() -> K): T? {
    var max: T = this.firstOrNull() ?: return null
    for (elem in slice(1 until size)) {
        if (elem.extract() > max.extract()) {
            max = elem
        }
    }
    return max
}


fun findMaxPersonByAge() {
    /**
     * El tipo T se infiere mediante el receiver friends que es Array<Person> luego T es Person
     * El tipo K se infiere a partir de la lambda con receiver this.age es Int
     */
    val oldest = friends.findMaxBy { this.age }
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val maxPerson = friends.findMaxBy { name }
    println("Último por orden alfabético = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}