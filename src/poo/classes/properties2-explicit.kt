package poo.classes.properties2

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