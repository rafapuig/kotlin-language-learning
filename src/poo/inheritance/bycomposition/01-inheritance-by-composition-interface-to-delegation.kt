package poo.inheritance.composition.interfaces.composition.delegation

interface Person {
    var name: String
    var age: Int
}


class PersonImpl(
    override var name: String,
    override var age: Int
) : Person

/**
 * Versión modificada de la clase Employee
 * Con la misma funcionalidad que la anterior
 * En este caso la propiedad privada se declara en el constructor primario
 */

class Employee private constructor(
    private val _super: Person,
    var salary: Int
) : Person {

    /**
     * El constructor secundario recibe tres parámetros
     * name y age, con los que instancia el objeto PersonImpl base
     * y salary para inicializar la propiedad salary declara en constructor primario
     */
    constructor(name: String, age: Int, salary: Int) :
            this(PersonImpl(name, age), salary) // Llamada al constructor primario

    override var name
        get() = _super.name
        set(value) {
            _super.name = value
        }

    override var age
        get() = _super.age
        set(value) {
            _super.age = value
        }

}

fun main() {
    val manEmployee = Employee("Armando Bronca Segura", 35, 1900)

    println(manEmployee.name)
    println(manEmployee.age)
    println(manEmployee.salary)

    val person: Person = manEmployee
}

