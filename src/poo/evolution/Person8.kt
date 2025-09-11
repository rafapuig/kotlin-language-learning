package poo.person8

class Person(val name: String = "Anonimo", val age: Int? = null) {

   // constructor(name: String) : this(name, null)

//    constructor() : this(age = null)

 //   val name: String get() = this._name
 //   val age: Int? get() = _age
}

fun main() {
    val person = Person()
    val armando = Person("Armando")
    val belen = Person("Belen", 57)

    println(person.name)
    println(person.age)

    println(armando.name)
    println(armando.age)

    println(belen.name)
    println(belen.age)
}