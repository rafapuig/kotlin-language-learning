package collections.sequences.example

data class Person(val name: String, val age: Int, val parent: Person? = null)

val adam = Person("Adan", 29)
val jose = Person("Jose", 50, adam)
val jesus = Person("Jesus", 33, jose)
val pedro = Person("Pedro", 45, adam)
val pablo = Person("Pablo", 77, pedro)

val people = listOf(adam, jesus, pedro, pablo)

fun Person.isDescendantOf(person: Person) =
    generateSequence(this) { it.parent }.any { it == person }

fun main() {
    // ¿Pablo es un descendiente de Adan?
    println(pablo.isDescendantOf(adam))
    // ¿Pablo es un descendiente de Jose?
    println(pablo.isDescendantOf(jose))
    // ¿Jesús es un descendiente de Jose?
    println(jesus.isDescendantOf(jose))

    // Árbol genealógico de Jesus
    val ancestors = generateSequence(jesus) { it.parent }
        .map { it.name }
        .toList()
    println(ancestors)

    // El ancestro mas inmediato de Pablo que se llame Pedro
    val pedro = generateSequence (pablo) {it.parent}
        .find { it.name == "Pedro" }
    println(pedro)
}