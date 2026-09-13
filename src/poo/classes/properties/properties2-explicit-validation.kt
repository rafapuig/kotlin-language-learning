package poo.classes.properties2v

/**
 * Un caso para el que resulta provecho definir explícitamente el setter de una propiedad
 * podría ser para la validación del valor a asignar al campo de respaldo (y, por lo tanto, a la propiedad)
 */

class Person {

    var name: String = "Anónimo"
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var age: Int = 0
        get() {
            return field
        }
        /**
         * Este setter no es trivial, comprueba si el valor es válido
         * en este caso requerimos que la edad sea positiva
         */
        set(value) {
            if(value < 0)
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
