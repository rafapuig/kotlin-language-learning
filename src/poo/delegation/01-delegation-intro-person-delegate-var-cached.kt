package poo.delegation

interface Person {
    val name: String
    val gender: String

    /**
     * Metodo greet con implementación por defecto
     */
    fun greet() = println("Hola me llamo $name")
}


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
 * Cuando cambia el objeto referenciado mediante la propiedad person a otro objeto implementador de Person
 * esto no afecta al objeto en el que se ha delegado al inicio
 * (el objeto en que se delega queda establecido y fijado en el momento
 * de la inicialización de la instancia Programmer)
 */
class Programmer(var person: Person) : Person by person {
    /**
     * Mientras la clase Programmer no reemplace un método de la interface Person
     * será como si la implementación del método de reemplazo
     * delegara manualmente en el objeto apuntado por la referencia en la propiedad person
     * pero la genera automáticamente el compilador
     */
}

class Worker(var person: Person) : Person { //by person
    /**
     * Este es explícitamente el código que autogenera el compilador cuando usamos by person
     *
     * El compilador
     * cachea al inicializar la instancia Worker en un campo: delegate
     * (Por eso si cambia el valor de la propiedad person se obtiene información
     * diferente)
     */

    /**
     * Inicialización de la propiedad delegate
     * Solamente ocurre al principio (al crear la instancia)
     */
    private val _delegate = person

    /**
     * La implementación del los miembros de la interface delega en el objeto
     * referenciado por la propiedad delegate
     *
     * Como la propiedad person puede mutar, puede acabar referenciando a otro objeto,
     * pero los metodos de la interface delegan en el objeto al que inicialmente apuntaba
     * person cuando se pasó como argumento al constructor
     */
    override val gender = _delegate.gender

    override val name = _delegate.name

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

fun Worker.printInfo() {
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

    workerChangingGenderDemo(man)
}

/**
 * Tendremos el mismo problema con Worker al cambiar de hombre a mujer
 */
fun workerChangingGenderDemo(man: Man) {
    with(Worker(man)) {
        printInfo()

        /**
         * Intentamos el cambio de personalidad (cambiar de hombre a mujer)
         */
        person = Woman("Loreto")
        printInfo() // Serán datos inconsistentes
    }
}

