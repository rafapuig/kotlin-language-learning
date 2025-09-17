package poo.inheritance.composition.interfaces

/**
 * Interface Person
 * Define el contrato (interfaz) de los objetos cuyas clases la implementen
 * Mediante una referencia de tipo Person se podrá acceder a dos propiedades
 * name y age (getters y setters)
 */
interface Person {
    var name: String
    var age: Int
}


/**
 * La clase PersonImpl
 * Implementa la interface Person
 * las propiedades abstractas name y age se reemplazan de la manera estándar,
 * de forma automática el compilador genera campos de respaldo para cada una
 */
class PersonImpl(
    override var name: String,
    override var age: Int
) : Person

/**
 * La clase Employee
 * También implementa la interface Person
 * Añade un atributo más para el salario
 * El constructor primario declara los parámetros name y age
 * para crear la instancia PersonImpl
 * y la propiedad salary para ampliar la clase Employee con la informacion del salario
 */
class Employee(
    name: String,
    age: Int,
    var salary: Int
) : Person {

    /**
     * La propiedad privada _super
     * Contiene la referencia a la Persona que todo empleado "lleva dentro", contiene
     * Como dentro del objeto Empleado se crea la instancia
     * ...se trata de una relación "tiene un" de tipo composición
     *
     * De esta manera simulamos la herencia manualmente por composición
     */
    private val _super: Person = PersonImpl(name, age)

    /**
     * La propiedad abstracta name de la interface person
     * Implementamos los getters y setter delegando en la implementación
     * de la clase PersonaImpl
     * El getter de la propiedad name en la clase Employee
     * redirige la llamada al getter de la propiedad name de la clase PersonImpl
     *
     * El setter de la propiedad name en la clase Employee
     * redirige la llamada al setter de la propiedad name de la clase PersonImpl
     *
     * (Como tanto la implementación del getter con del setter no hacen uso
     * del campo de respaldo "field", el compilador no generará un campo)
     */
    override var name
        get() = _super.name
        set(value) {
            _super.name = value
        }

    /**
     * La propiedad abstracta age de la interface person
     * Implementamos los getters y setter delegando en la implementación
     * de la clase PersonaImpl
     */
    override var age
        get() = _super.age
        set(value) {
            _super.age = value
        }

}

fun main() {
    val employee = Employee("Armando Bronca Segura", 35, 1900)

    /**
     * with es una "scope function" que nos permite no tener que repetir
     * siempre el mismo objeto receptor (receiver)
     * El objeto receptor dentro del scope (bloque) es accedido mediante this
     * Como this no es obligatorio escribirlo explícitamente
     * nos podemos ahorrar escribir el receptor y el punto para acceder a un miembro
     */
    with(employee) {
        println(name)
        println(age)
        println(salary)
    }

    /**
     * Una referencia de tipo Employee se puede asignar a una variable
     * de tipo Person
     * dado que la clase Employee implementa la interface Person
     */
    val person: Person = employee

    with(person) {
        println(name)
        println(age)
    }

}

