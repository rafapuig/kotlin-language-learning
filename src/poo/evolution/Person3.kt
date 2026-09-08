package poo.person3

/**
 * El constructor que recibe un argumento para cada propiedad de la clase
 * podemos hacer que sea constructor primario
 *
 * Los argumentos proporcionados en el constructor primario se pueden acceder en el bloque init
 */
class Person constructor(name: String?, age: Int?) {

    private var _name: String = "Anonimo"
    private var _age: Int? = null

    init {
        this._name = name ?: this._name
        this._age = age
    }

    // Ahora este constructor secundario está llamando al constructor primario
    constructor(name: String): this(name, null)

    // Recuperamos this(null, null) porque es obligatorio que un constructor secundario acabe llamando a un primario
    constructor() : this(null, null)

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