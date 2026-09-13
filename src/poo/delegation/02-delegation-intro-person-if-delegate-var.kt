package poo.delegation.withvardelegate

interface Person {
    val name: String
    val gender: String

    /**
     * Método greet con implementación por defecto
     */
    fun greet() {
        println("Hola me llamo $name")
    }
}


/**
 * Tenemos dos clases implementadoras de la interface Person
 */
class Man(override val name: String) : Person {

    override val gender = "masculino"

    override fun greet() = println("Hola soy el señor $name")
}


class Woman(override val name: String) : Person {

    override val gender = "femenino"

    override fun greet() = println("Hola soy la señora $name")
}

/**
 * Aunque se delega en la propiedad person
 * Cuando cambia la referencia a otro objeto implementador de Person
 * no afecta al objeto en el que se ha delegado al inicio
 * (el objeto en que se delega queda establecido y fijado en el momento
 * de la inicialización de la instancia Programmer)
 */
class Programmer(var person: Person) : Person {

    /** Este es el código que autogeneraría el compilador si usamos by */
    /*val _delegate = person

    override val gender: String = _delegate.gender

    override val name: String = _delegate.name

    override fun greet() = _delegate.greet()*/

    /**
     * Si la propiedad delegada no es de solo lectura,
     * Tendremos que realizar la delegación manualmente miembro a miembro
     * para que cuando cambie el valor de la propiedad delegada person
     * se obtenga la version no cacheada al inicio, hacinado uso de un getter en lugar de asignarlo
     */

    private val _delegate get() = person

    override val name: String get() = _delegate.name

    override val gender: String get() = _delegate.gender

    override fun greet() = _delegate.greet()
}


fun Programmer.printInfo() {
    this.greet()
    print("Información via delegación: ")
    print(javaClass.simpleName)
    println(" $name es $gender")
    print("Información via propiedad delegada: ")
    print(person.javaClass.simpleName)
    println(" ${person.name} es ${person.gender}")
}


fun main() {
    val man = Man("Jose")
    val woman = Woman("Maria")

    val manProgrammer = Programmer(man)
    manProgrammer.printInfo()


    val womanProgrammer = Programmer(woman)
    womanProgrammer.printInfo()


    /**
     * Intentamos el cambio de personalidad (cambiar de hombre a mujer)
     */
    manProgrammer.person = Woman("Loreto")
    manProgrammer.printInfo()
}