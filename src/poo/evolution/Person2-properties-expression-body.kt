package poo.evolution.properties.expresion.body

class Person {
    private var _name: String = "Anónimo"
    private var _age: Int? = null

    constructor(name: String?, age: Int?) {
        this._name = name ?: this._name
        this._age = age
    }

    constructor(name: String) //: this(name, null)

    constructor() //: this(null, null)

    /**
     * Implementación de los getters de las propiedades de solo lectura
     * mediante expression body
     */
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