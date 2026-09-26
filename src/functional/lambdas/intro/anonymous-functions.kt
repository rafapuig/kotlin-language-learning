package functional.lambdas.intro.anonymous

data class Person(val name: String, val age: Int) {
    fun greet() {
        println("Hola, me llamo $name y tengo $age años")
    }
}

/**
 * Funciones anónimas
 */
// Función anónima con block-body
val getAgeFunBB = fun(p: Person): Int { return p.age }

// Función anónima con expression-body
val getAgeFunEB = fun(p: Person) = p.age

val greetToConsole = fun(p: Person) = p.greet()

// Función anónima de extensión (con receptor)
val greetToConsoleEx = fun Person.() = this.greet()


fun main() {
    val person = Person("Perico", 23)
    println(getAgeFunBB(person))
    println(getAgeFunEB(person))
    greetToConsole(person)

    // Llamada a la función de extensión pasando el receptor como primer argumento
    greetToConsoleEx(person)

    // Llamada a la función de extension mediante la sintaxis de receptor.metodo
    person.greetToConsoleEx()
}