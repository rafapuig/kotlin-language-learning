package functional.examples.strategy4


data class Person(val firstName: String) {


    // Delegado, ahora tipo funcion
    var greeter: (() -> Unit)? = null

    fun greet() {
        // Delegando en el delegado (ahora el SAM se llama invoke)
        greeter?.invoke()
    }
}

/**
 * Polite Greeter es un objeto de tipo funcion () -> Unit
 * que implementa la estrategia de saludo de manera educada
 * (implementado la interface Greeter)
 */
val PoliteGreeter = {
    println("Buenos dias, que tal esta usted!")
}

fun main() {
    val person = Person("Lorenzo Penco")

    // Establecemos que person saluda de forma educada
    person.greeter = PoliteGreeter
    person.greet() // Saludar educadamente


    val informalGreeter = { println("Que pasa tio!") }

    person.greeter = informalGreeter
    // Ahora la misma persona saluda de manera informal
    person.greet()

    // Ahora saludará con un Holi!
    person.greeter = { println("Holi!") }
    person.greet()

    //De nuevo volvemos a saludar de forma educada
    person.greeter = PoliteGreeter
    person.greet()
}

