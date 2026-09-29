package poo.evolution.properties.backing.field.initialization.by.constructor.parameters


class Person constructor(name: String?, age: Int?) {

    /**
     * También se pueden usar los parámetros del constructor primario
     * en la expresión de inicialización de las propiedades
     *
     * Lo que hace innecesario en este caso el uso del bloque init
     */
    private var _name: String = name ?: "Anónimo"
    private var _age: Int? = age

    constructor(name: String): this(name, null)

    constructor(): this(null, null)

    val name: String get() = _name
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