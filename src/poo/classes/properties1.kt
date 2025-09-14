package poo.classes.properties1

class Person {
    var name : String = "Anonimo"
    var age : Int = 0
}

fun main() {
    val person = Person()
    println("${person.name} tiene ${person.age} años")

    person.name = "Perico Palotes"
    person.age = 30

    println("${person.name} tiene ${person.age} años")
}