package functional.examples.strategy2

/**
 * Convertimos a Greeter en un interface funcional
 */
fun interface Greeter {
    fun greet()
}

data class Person(val firstName: String) {

    // Delegado, para encargarse de la estrategia de saludo
    private var greeter: Greeter? = null

    // Metodo para establecer la estrategia de saludo del objeto
    fun setGreeter(gretter: Greeter) {
        this.greeter = gretter
    }

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
    person.setGreeter(PoliteGreeter)
    person.greet() // Saludar educadamente

    /**
     * Podemos crear un objeto de tipo anónimo
     * mediante una expresión objeto que implemente
     * la interface Greeter,
     * la estrategia de saludo de manera informal
     */
    val informalGreeter = Greeter { println("Que pasa tio!") }

    person.setGreeter(informalGreeter)
    // Ahora la misma persona saluda de manera informal
    person.greet()

    // Ahora saludará con un Holi!
    person.setGreeter { println("Holi!") }
    person.greet()

    //De nuevo volvemos a saludar de forma educada
    person.setGreeter(PoliteGreeter)
    person.greet()
}

