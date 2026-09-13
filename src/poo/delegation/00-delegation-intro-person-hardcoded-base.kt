package poo.delegation.harcoded.delegate

interface Person {
    var name: String
    var age: Int

    fun greet()
}

/**
 * Clase implementadora de la interface
 * Aportará la implementación, el comportamiento concreto
 */
class PersonImpl(
    override var name: String,
    override var age: Int
) : Person {
    override fun greet() =
        println("Hola me llamo $name y tengo $age años")
}


/**
 * Clase Programmer
 * Utiliza composición y delegación para "simular la herencia"
 */
class Programmer(name: String, age: Int, var language: String) : Person {

    // Composición
    private val _super = PersonImpl(name, age)

    /* Delegación de las propiedades y el metodo greet en el objeto _super */
    override var name: String = _super.name
    override var age: Int = _super.age

    override fun greet() = _super.greet()
}


/**
 * La palabra clave `by` de Kotlin equivale a
 * delegar la implementación del interface situado a la izquierda de by
 * en el objeto que indicamos a la derecha del by
 */

/**
 * Class Worker
 * Implementa la interface Person delegando en la clase implementadora PersonImpl
 */
class Worker(name: String, age: Int, var salary: Int) : Person by PersonImpl(name, age)


/**
 * Clase Manager
 * La clase Manager tiene la mejora sobre la clase Worker en que permite especificar
 * el objeto cuya clase implementa la interface Person (y si no tiene valor por defecto PersonImpl)
 * en el constructor
 */
class Manager(
    name: String, age: Int, var salary: Int,
    private val _super: Person = PersonImpl(name, age)
) : Person by _super



fun main() {

    val programmer = Programmer("Perico Palotes", 37, "Kotlin")
    programmer.greet()

    val worker = Worker(name = "Amador Denador", 26, 1400)
    worker.greet()

    val manager = Manager(name = "Armando Bronca Segura", 49, 3800)
    manager.greet()


    testCustomPersonImpl()

}

fun testCustomPersonImpl() {

    val aName = "Jose Luis Torrente"
    val anAge = 69
    val aSalary = 20_000

    val manager = Manager(aName, anAge, aSalary, object : Person {

        private var _name = aName

        override var name: String
            get() = _name
            set(value) {
                _name = value
            }

        private var _age = anAge
        override var age: Int
            get() = _age
            set(value) {
                _age = value
            }

        override fun greet() {
            println("Que pasa chavales!!, soy $name con $age tacos")
        }
    })

    manager.greet()
}