package poo.person6

/**
 * Se puede hacer que los parámetros del constructor primario, además de parámetros, sean considerados como propiedades
 * de la clase, lo que permite usarlos en otros miembros y no solo en el bloque init
 */
class Person (private var _name: String?, private var _age: Int?) {

    init {
        this._name = _name ?: "Anónimo"
        this._age = _age ?: 0
    }

    constructor(name: String): this(name, null)

    constructor(): this(null, null)

    val name: String get() = this._name!! // podemos usar aquí _name porque es una propiedad
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