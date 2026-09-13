package poo.construction.builder

data class Person(
    val name: String = "Anónimo",
    val age: Int = 18,
    val married: Boolean = false
)

fun Person.print() = println("Name: $name, Age: $age, married: $married")

fun main() {
    // Y por defecto, married será false
    val person = Person(name = "Rafa Puig", age = 48)
    person.print()

    // Uso de argumentos nombrados
    val perico = Person(
        name = "Perico Palotes",
        age = 35,
        married = true
    )
    perico.print()

    val anonimo = Person(
        married = true,
        age = 90
    )
    anonimo.print()
}