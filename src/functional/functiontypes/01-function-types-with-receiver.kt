package functional.functiontypes.receiver

import functional.lambdas.receivers2.alphabet
import functional.lambdas.receivers2.alphabetWithExplicitThis


/**
 * Un tipo de función puede representar un metodo de instancia aplicado sobre un objeto (receptor)
 *
 * Se indica anteponiendo a la lista de tipos de los parámetros de entrada
 * el tipo del receptor seguido de un punto
 *
 * Sintaxis:
 *
 * TipoReceptor.(TipoParam1, TipoParam2, ...) -> TipoRetorno
 *
 *
 * Para invocar la función de un objeto tipo función con receptor se necesita proporcionar el receptor
 * y se puede hacer de dos maneras:
 * - la sintaxis orientada a objetos: receptor.metodo(argumentos...)
 * - la sintaxis funcional: funcion(receptor, argumentos...)
 */

// Tipo función con parámetro de entrada Int y retorna Int
val triple: (Int) -> Int = { it * 3 }

// Tipo función con receptor de tipo Int (llamado por un Int y devuelve un Int)
val double: Int.() -> Int = { this * 2 }

// Tipo función con receptor de tipo Int (llamado por un Int, pasando un argumento Int y devuelve un Boolean)
val isMultipleOf: Int.(Int) -> Boolean = {
    this % it == 0
}

// Versión tipo función (sin receptor)
val multipleOf: (Int, Int) -> Boolean = { number, factor -> number % factor == 0 }


fun testWithIntReceiver() {

    println(triple(4))
    println(multipleOf(8, 4))

    // Llamadas con sintaxis OO
    println(4.double())
    println(8.isMultipleOf(2))

    // Llamadas con sintaxis de función imperativa
    println(double(4))
    println(isMultipleOf(8, 2)) // Mucho menos clara que la version OO

    // Ambas sintaxis con traducidas internamente por el compilador en estas
    double.invoke(4)
    isMultipleOf.invoke(8, 2)
}


val containsVowelA: String.() -> Boolean = { "a" in this }

val containsCharacter: String.(Char) -> Boolean = { it in this }

fun testWithStringReceiver() {
    val text = "Hello Kotlin"

    // Llamadas con sintaxis OO
    text.containsVowelA()
    text.containsCharacter('K')

    // Llamadas con sintaxis de función imperativa
    containsVowelA(text)
    containsCharacter(text, 'K')

    // Ambas sintaxis con traducidas internamente por el compilador en estas
    containsVowelA.invoke(text)
    containsCharacter.invoke(text, 'K')
}


data class Person(var firstName: String = "", val lastName: String = "")

val fullName: Person.() -> String = { "${this.firstName} $lastName" }

// El calificador this no es necesario explícitamente
val changeName: Person.(String) -> Unit = { firstName = it }


fun testWithPersonReceiver() {

    val person = Person("Perico", "Palotes")

    // Llamadas con sintaxis OO
    println(person.fullName())

    person.changeName("Pedro")
    println(person.fullName())

    // Llamadas con sintaxis de función imperativa
    println(fullName(person))
    changeName(person, "Peter")

    // Ambas sintaxis con traducidas internamente por el compilador en estas
    fullName.invoke(person)
    changeName.invoke(person, "Pere")
}

fun main() {
    testWithIntReceiver()
    testWithStringReceiver()
    testWithPersonReceiver()
}

