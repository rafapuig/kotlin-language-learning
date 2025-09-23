package functional.intro.operation.structure.selector.member.reference

data class Person(val name: String, val age: Int)

fun interface KeySelector<T, K : Comparable<K>> {
    fun extract(element: T): K
}

fun <T, K : Comparable<K>> Array<T>.findMaxBy(keySelector: KeySelector<T, K>): T? {
    if (isEmpty()) return null
    var max: T = this[0]
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
    println("Máximo = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}