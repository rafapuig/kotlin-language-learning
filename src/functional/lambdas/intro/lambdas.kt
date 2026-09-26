package functional.lambdas.intro.lambdas

data class Person(val name: String, val age: Int) {
    fun greet() {
        println("Hola, me llamo $name y tengo $age años")
    }
}

// Expresión lambda asignada a la variable getAge
val getAge = { person: Person -> person.age }

// Expresión lambda con tipo del parámetro implícito (Person)
val getAgeLIP: (Person) -> Int = { person -> person.age }

// Expresión lambda con parámetro implícito it
val getAgeLIT: (Person) -> Int = { it.age }


// Expresión lambda
val greetToConsole = { person: Person -> person.greet() }

// Expresión lambda con tipo del parámetro implícito (Person)
val greetToConsoleLIP: (Person) -> Unit = { person -> person.greet() }

// Expresión lambda con parámetro implícito it
val greetToConsoleLIT: (Person) -> Unit = { it.greet() }

val greetToConsoleReceiver: Person.() -> Unit = { this.greet() }


fun main() {
    val person = Person("Perico Palotes", 29)
    val age = getAge(person)
    println(age)

    greetToConsole(person)
}