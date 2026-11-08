package functional.examples.strategy0


data class Person(val firstName: String) {

    fun greet() {
        println("Hola, que tal?")
    }
}

fun main() {
    val person = Person("Lorenzo Penco")
    // El objeto person siempre saluda de la misma forma
    person.greet()
}

