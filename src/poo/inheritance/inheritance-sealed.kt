package poo.inheritance.sealed


sealed class Person(val name: String)

class Man(name: String) : Person(name)
class Woman(name: String) : Person(name)


fun processPerson(person: Person) {
    when (person) {
        is Man -> println("${person.name} es un hombre")
        is Woman -> println("${person.name} es una mujer")
    }
}

fun main() {
    val man = Man("Pepe")
    val woman = Woman("Pepa")

    processPerson(man)
    processPerson(woman)
}