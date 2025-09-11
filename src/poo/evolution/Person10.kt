package poo.person10

class Person(val name: String = "Anonimo", val age: Int? = null)

fun main() {
    val person = Person()
    val armando = Person("Armando")
    val belen = Person("Belen", 57)
    val anonymous34 = Person(age = 34)

    println(person.name)
    println(person.age)

    println(armando.name)
    println(armando.age)

    println(belen.name)
    println(belen.age)

    println(anonymous34.name)
    println(person.age)

    println(belen) // poo.person10.Person@63961c42

    val clon = Person("Belen", 57)

    val belen2 = belen
    println(clon === belen) //false
    println(belen2 === belen) // true

    println(clon == belen) // false !!!

}