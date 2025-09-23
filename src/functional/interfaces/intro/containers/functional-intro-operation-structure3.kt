package functional.intro.operation.structure.selector.expression.objects

data class Person(val name: String, val age: Int)

fun interface KeySelector<T, K : Comparable<K>> {
    fun extract(element: T): K
}

/*val ageExtractor = fun(p: Person, key: KeySelector<String, Int>): Int {
    p.age
}*/

val ageExtractor: KeySelector<Person, Int> = object : KeySelector<Person, Int> {
    override fun extract(element: Person): Int = element.age
}

val nameExtractor: KeySelector<Person, String> = object : KeySelector<Person, String> {
    override fun extract(element: Person): String = element.name
}


fun <T, K : Comparable<K>> Array<T>.findMaxBy(keySelector: KeySelector<T, K>): T? {
    if (isEmpty()) return null
    var maxElement: T = this[0]
    var maxKey = keySelector.extract(maxElement)
    for (i in 1 until size) {
        val key = keySelector.extract(this[i])
        if (key > maxKey) {
            maxElement = this[i]
            maxKey = key
        }
    }
    return maxElement
}

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))


fun findMaxPersonByAge() {
    val oldest = friends.findMaxBy(ageExtractor)
    println("Más Viejo = $oldest")
}


fun findMaxPersonByName() {
    val maxPerson = friends.findMaxBy(nameExtractor)
    println("Máximo = $maxPerson")
}


fun main() {
    findMaxPersonByAge()
    findMaxPersonByName()
}