package poo.classes.properties2

class Person {

    /**
     * Toda propiedad mutable (var) define
     * - un campo de respaldo donde almacena el valor de la propiedad
     * al que se accede mediante la palabra identificador field
     * - un getter trivial que devuelve el valor del campo de respaldo
     * - un setter trivial que asigna el valor recibido como argumento al campo de respaldo
     */
    var name: String = "Anónimo" // Inicialización del campo de respaldo con el valor literal "Anónimo"
        get() {
            return field // Devuelve el valor del campo de respaldo de la propiedad
        }
        set(value) {
            field = value // Asigna el valor recibido como argumento al campo de respaldo
        }

    var age: Int = 0 // Inicialización del campo de respaldo de la propiedad age con el valor 0
        get() {
            return field
        }
        set(value) {
            field = value
        }
}

fun main() {
    val person = Person()
    println("${person.name} tiene ${person.age} años")

    person.name = "Perico Palotes"
    person.age = 30

    println("${person.name} tiene ${person.age} años")
}