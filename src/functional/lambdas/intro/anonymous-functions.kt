package functional.lambdas.intro.anonymous

data class Person(val name: String, val age: Int) {
    fun greet() {
        println("Hola, me llamo $name y tengo $age años")
    }
}

// Expresión lambda
val getAge = { person: Person -> person.age }

// Expresión lambda con tipo del parámetro implícito
val getAgeLIP : (Person)-> Int = { person -> person.age }

// Expresión lambda con parámetro implícito it
val getAgeLIT : (Person)-> Int = { it.age }

/**
 * Funciones anónimas
 */
// Función anónima con block-body
val getAgeFunBB = fun(p: Person): Int { return p.age }

// Función anónima con expression-body
val getAgeFunEB = fun(p: Person) = p.age


/**
 * Referencia a miembro
 */

// Referencia a miembro
val getAgeMR = Person::age

val personGreet = Person::greet
