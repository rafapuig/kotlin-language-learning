package poo.construction.builder

data class Person(
    val name: String = "Anonimo",
    val age: Int = 18,
    val married: Boolean = false
)

fun main() {
    val person = Person(name = "Rafa Puig", age = 48)

    val perico = Person(
        name = "Perico Palotes",
        age = 35,
        married = true
    )
}