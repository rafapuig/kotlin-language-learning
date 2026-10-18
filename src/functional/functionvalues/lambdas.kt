package functional.functionvalues.lambdas

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

// Expresión lambda con receptor
val getAgeWithReceiver : Person.() -> Int = { this.age }

// Expresión lambda con receptor (no hace falta el uso de this para calificar)
val getAgeWithReceiverNoThis : Person.() -> Int = { age }


// Expresión lambda
val greetToConsole = { person: Person -> person.greet() }

// Expresión lambda con tipo del parámetro implícito (Person)
val greetToConsoleLIP: (Person) -> Unit = { person -> person.greet() }

// Expresión lambda con parámetro implícito it
val greetToConsoleLIT: (Person) -> Unit = { it.greet() }

val greetToConsoleWithReceiver: Person.() -> Unit = { this.greet() }



fun main() {

    val person = Person("Perico Palotes", 29)

    var age = getAge(person)
    println(age)

    age = person.getAgeWithReceiver()
    println(age)

    age = getAgeWithReceiver(person)
    println(age)


    greetToConsole(person)

    /* Para invocar un objeto de tipo función cuyo tipo tiene como primer parámetro un receptor */
    // podemos usar la sintaxis orientada a objetos
    person.greetToConsoleWithReceiver()

    // o la sintaxis imperativa
    greetToConsoleWithReceiver(person)
}