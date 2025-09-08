package poo.person6

class Person (private var _name: String?, private var _age: Int?) {

    private var __name: String = _name ?: "Anonimo"
    private var __age: Int? = _age

    constructor(name: String): this(name, null)

    constructor(): this(null, null)

    val name: String get() = this.__name
    val age: Int? get() = __age
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