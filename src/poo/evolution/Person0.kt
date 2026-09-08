package poo.person0

class Person {

    // Propiedades sin inicializar, solo posible por los constructores declarados
    private var _name: String
    private var _age: Int?

    constructor(name: String?, age: Int?) {
        this._name = name ?: "Anónimo"
        this._age = age
    }

    constructor(name: String) : this(name, null)

    constructor() : this(null, null)

    val name: String
        get() {
            return this._name
        }

    val age: Int?
        get() {
            return _age
        }

}

fun main() {

    val person: Person
    person = Person() // Crear una persona mediante en constructor por defecto, nombre y edad por defecto

    val armando = Person("Armando")
    val belen = Person("Belen", 57)

    println(person.name)
    println(person.age)

    println(armando.name)
    println(armando.age)

    println(belen.name)
    println(belen.age)
}