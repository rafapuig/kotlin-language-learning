package poo.classes.properties4

class Person {

    /**
     * Con la anotación JvmField
     * El compilador no genera getters y setters
     * Crea un campo
     */
    @JvmField
    var _name: String = "Anonimo"

    /**
     * Una propiedad que no hace uso de field
     * El compilador no genera el campo de respaldo
     * No podemos inicilazarla porque no hay campo de respaldo
     */
    var name: String //_name
        get() = _name
        set(value) {
            _name = value
        }


    var age: Int = 0
        get() = field
        set(value) {
            if (value < 0)
                throw IllegalArgumentException("La edad no puede ser negativa")
            field = value
        }
}

fun main() {
    val person = Person()
    println("${person.name} tiene ${person.age} años")

    person.name = "Perico Palotes"
    person.age = 30

    println("${person.name} tiene ${person.age} años")

    try {
        person.age = -40
    } catch (ex: IllegalArgumentException) {
        println(ex.message)
    }
}
