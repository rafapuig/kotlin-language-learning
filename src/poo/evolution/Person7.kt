package poo.person7

/**
 * Si hacemos uso de los valores por defecto de los parámetros de una función
 * y además estos parámetros al añadir val o var en su declaración obtienen la consideración de propiedades
 * de la clase
 * entonces en innecesario el uso de los constructores secundarios
 */
class Person(
    private var _name: String = "Anónimo",
    private var _age: Int? = null) {

   // constructor(name: String) : this(name, null)

//    constructor() : this(age = null)

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