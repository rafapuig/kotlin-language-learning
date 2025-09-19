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
class PersonImpl(override var name: String, override var age: Int) : Person {
    override fun greet() = println("Hola me llamo $name y tengo $age años")
}


/**
 * Clase Programmer
 * Utiliza composición y delegación para "simular la herencia"
 */
class Programmer(name: String, age: Int, var language: String) : Person {

    private val _super = PersonImpl(name, age)

    override var name: String = _super.name
    override var age: Int = _super.age

    override fun greet() = _super.greet()
}

/**
 * La palabra clave by de Kotlin equivale a
 * delegar la implementación del interface situado a la izquierda de by
 * en el objeto que indicamos a la derecha del by
 */
class Manager(
    name: String, age: Int, var salary: Int,
    private val _super: Person = PersonImpl(name, age)
) : Person by _super

class Worker(name: String, age: Int, var salary: Int) : Person by PersonImpl(name, age)


fun main() {
    val programmer = Programmer("Perico Palotes", 37, "Kotlin")
    programmer.greet()

    val manager = Manager(name = "Armando Bronca Segura", 49, 3800)
    manager.greet()

    val worker = Worker(name = "Amador Denador", 26, 1400)
    worker.greet()
}