package poo.classes.properties1

class Person {
    /**
     * Propiedades de la clase Person
     */
    var name : String = "Anónimo"   // Mutable con valor inicial "Anónimo"
    var age : Int = 0               // Mutable con valor inicial 0
}

fun main() {
    val person = Person()

    // Se imprimiran los valores iniciales de las propiedades de un objeto Person
    println("${person.name} tiene ${person.age} años")

    // Mutamos el objeto (modificamos valores de las propiedades)
    person.name = "Perico Palotes"
    person.age = 30

    println("${person.name} tiene ${person.age} años")
}