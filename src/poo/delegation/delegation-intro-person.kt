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
    override val gender: String get() = "masculino"
    override fun greet() = println("Hola soy el señor $name")
}


class Woman(override val name: String) : Person {
    override val gender: String get() = "femenino"
    override fun greet() = println("Hola soy la señora $name")
}


/**
 * Aunque se delega en la propiedad person
 * Cuando cambia la referencia de la propiedad person a otro objeto implementador de Person
 * no afecta al objeto en el que se ha delegado al inicio
 * (el objeto en que se delega queda establecido y fijado en el momento
 * de la inicializacion de la instancia Programmer)
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
     * Este es explícitamente el código que autogeneraría el compilador si usamos by person
     *
     * El compilador
     * cachea al inicializar la instancia Programmer en un campo: delegate
     * (Por eso si cambiar el valor de la propiedad person se obtiene informacion
     * diferente)
     */

    /**
     * Inicialización de la propiedad delegate
     * Solamente ocurre al principio (al crear la instancia)
     */
    private val delegate = person

    /**
     * La implementación del los miembros de a interface delega en el objeto
     * referenciado por la propiedad delegate
     *
     * Como la propiedad person puede mutar, puede acabar referenciando a otro objeto,
     * pero los metodos de la interfaz delegan en el objeto al que inicialmente apuntaba
     * person cuando se pasó como argumento al constructor
     */
    override val gender: String = delegate.gender

    override val name: String = delegate.name

    override fun greet() = delegate.greet()
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

fun Worker.printInfo() {
    this.greet()
    print("Informacion via delegación: ")
    print(javaClass.simpleName)
    println(" $name es $gender")
    print("Informacion via propiedad delegada: ")
    print(person.javaClass.simpleName)
    println(" ${person.name} es ${person.gender}")
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

