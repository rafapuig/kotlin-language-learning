package poo.person5

class Person (name: String?, age: Int?) {

    private var _name: String = name ?: "Anonimo"
    private var _age: Int? = age

    constructor(name: String): this(name, null)

    constructor(): this(null, null)

    val name: String get() = this._name
    val age: Int? get() = _age
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