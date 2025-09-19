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

class Man(override val name: String) : Person {
    override val gender: String = "masculino"

    override fun greet() {
        println("Hola soy el señor $name")
    }

}

class Woman(override val name: String) : Person {
    override val gender: String
        get() = "femenino"

    override fun greet() {
        println("Hola soy la señora $name")
    }
}

/**
 * Aunque se delega en la propiedad person
 * Cuando cambia la referencia a otro objeto implementador de Person
 * no afecta al objeto en el que se ha delegado al inicio
 * (el objeto en que se delega queda establecido y fijado en el momento
 * de la inicialización de la instancia Programmer)
 */
class Programmer(var person: Person) : Person {

    /** Esto es el código que autogeneraría el compilador */
    /*val _delegate = person

    override val gender: String = _delegate.gender

    override val name: String = _delegate.name

    override fun greet() = _delegate.greet()*/

    /**
     * Si la propiedad delegada no es de solo lectura,
     * Tendríamos que realizar la delegación manualmente miembro a miembro
     */
    override val name: String get() = person.name

    override val gender: String get() = person.gender

    override fun greet() = person.greet()
}


fun Programmer.printInfo() {
    this.greet()
    print("Informacion via delegación: ")
    print(javaClass.simpleName)
    println(" $name es $gender")
    print("Informacion via propiedad delegada: ")
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