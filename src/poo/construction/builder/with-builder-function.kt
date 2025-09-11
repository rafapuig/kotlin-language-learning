package poo.construction.builder3

data class Person(
    var name: String = "Anonimo",
    var age: Int = 18,
    var married: Boolean = false
)

fun buildPerson(block: Person.() -> Unit): Person = Person().apply(block)


fun main() {
    val person = Person(name = "Rafa Puig", age = 48)

    val perico = Person(
        name = "Perico Palotes",
        age = 35,
        married = true
    )

    val armando = Person().apply {
        name = "Armando"
        age = 45
        married = true
    }

    val belen = buildPerson {
        name = "Belen"
        age = 36
        married = false
    }
}