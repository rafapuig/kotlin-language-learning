package functional.examples.strategy3

/**
 * Convertirmos a Greeter en un interface funcional
 */
fun interface Greeter {
    fun greet()
}

data class Person(val firstName: String) {

    /* Nos deshacemos del setter y dejamos la propiedad publica */

    // Delegado, para encargarse de la estrategia de saludo
    var greeter: Greeter? = null

    fun greet() {
        // Delegando en el delegado
        greeter?.greet()
    }
}

/**
 * Polite Greeter es un objeto singleton
 * que implementa la estrategia de saludo de manera educada
 * (implementado la interface Greeter)
 */
object PoliteGreeter : Greeter {
    override fun greet() {
        println("Buenos dias, que tal esta usted!")
    }
}

fun main() {
    val person = Person("Lorenzo Penco")

    // Establecemos que person saluda de forma educada
    person.greeter = PoliteGreeter
    person.greet() // Saludar educadamente

    /**
     * Podemos crear un objeto de tipo anonimo
     * mediante una expresion objeto que implemente
     * la interface Greeter,
     * la estrategia de saludo de manera informal
     */
    val informalGreeter = Greeter { println("Que pasa tio!") }

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

