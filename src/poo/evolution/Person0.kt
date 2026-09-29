package poo.evolution.person0

class Person {

    // Propiedades sin inicializar, solo posible por los constructores declarados
    // (al ser privadas no generan getters ni setters, solamente campos internos a la clase)
    private var _name: String
    private var _age: Int?

    // En Kotlin el constructor se indica utilizando la palabra clave constructor
    constructor(name: String?, age: Int?) {
        this._name = name ?: "Anónimo" // Si name es nulo se usará "Anónimo"
        this._age = age
    }

    // Constructor con un parámetro para establecer el nombre,
    // delega en el constructor que declara parámetros para inicializar todas las propiedades
    constructor(name: String) : this(name, null)

    // Constructor sin parámetros, delega en el constructor que más parámetros declara
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