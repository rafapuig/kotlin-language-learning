package poo.construction.builder3

data class Person(
    var name: String = "Anónimo",
    var age: Int = 18,
    var married: Boolean = false
)

fun Person.print() = println("Name: $name, Age: $age, married: $married")

/**
 * Función buildXXX para construir un XXX paso a paso siguiendo las instrucciones
 * que indica el block de código proporcionado como argumento
 *
 * En este caso buildPerson permitirá indicar mediante instrucciones como queremos crear un objeto Persona
 */
fun buildPerson(block: Person.() -> Unit): Person = Person().apply(block)


fun main() {

    val person = Person("Rafa Puig", 48)
    person.print()

    val perico = Person(
        name = "Perico Palotes",
        age = 35,
        married = true
    )
    perico.print()

    val armando = Person().apply {
        name = "Armando"
        age = 45
        married = true
    }
    armando.print()


    val belen = buildPerson {
        name = "Belen"
        age = 36
        married = false
    }
    belen.print()
}