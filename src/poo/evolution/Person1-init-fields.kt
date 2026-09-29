package poo.evolution.person.init.fields

class Person {

    /**
     * Si inicializamos las propiedades,
     * ya no es obligatorio que todos los constructores garanticen
     * que se proporciona un valor para construir la instancia
     */
    private var _name: String = "Anónimo"
    private var _age: Int? = null

    constructor(name: String?, age: Int?) {
        if (name != null) this._name = name // Smart cast de name desde String? a String
        this._age = age
    }

    /**
     * Ya no es obligatorio delegar en el constructor que inicializa todas las propiedades
     */
    constructor(name: String) //: this(name, null)

    /**
     * Ya no es obligatorio delegar en el constructor que inicializa todas las propiedades
     */
    constructor() // : this(null, null)


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
    person = Person()

    val armando = Person("Armando")
    val belen = Person("Belen", 57)

    println(person.name)
    println(person.age)

    println(armando.name)
    println(armando.age)

    println(belen.name)
    println(belen.age)
}