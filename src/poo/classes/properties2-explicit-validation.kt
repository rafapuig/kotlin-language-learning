package poo.classes.properties2v

class Person {

    var name: String = "Anonimo"
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
