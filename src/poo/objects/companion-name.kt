package poo.objects.companion.explicit.name

class Person(val name: String) {

    init {
        population++
    }

    var conyuge: Person? = null
        private set

    override fun toString(): String {
        return name
    }

    /**
     * El companion object
     *
     * Se le puede asignar un nombre explícitamente
     * Si no se le asigna un nombre el compilador le asigna el nombre por defecto Companion
     *
     */
    companion object Manager {

        var population = 0
            private set

        fun casar(person1: Person, person2: Person) {
            person1.conyuge = person2 // accedemos al setter de conyuge
            person2.conyuge = person1
        }
    }
}

fun printNumPeople() {
    println("Número de personas: ${Person.population}")
    // Equivalente a
    //println("Número de personas: ${Person.Manager.population}")
}

fun Person.printConyugeInfo() {
    println("El conyuge de $this es ${this.conyuge}")
}

/**
 * Método de extension de un companion object
 * La sintaxis es fun <nombre-clase-contenedora>.<nombre-objeto-companion>.<nombre-metodo>
 */
fun Person.Manager.printPopulation() {
    /** En un método de extension la referencia this
     * hace referencia al objeto companion
     * y puede acceder a los miembros de este
     */

    println("Poblacion actual: $population" )
    /** equivale a */
    //println("Poblacion actual: ${this.population}" )
}


fun main() {

    printNumPeople()

    val adan = Person("Adan")
    printNumPeople()

    val eva = Person("Eva")
    printNumPeople()

    /** Llamada al método de extensión del objeto companion de Person */
    Person.printPopulation()


    /**
     * El tipo del objeto companion es Person.Companion
     */
    // Obtener una referencia al objeto companion
    val companionRefence = Person.Manager
    println(companionRefence.population)

    /**
     * La clase Person se considera una referencia a su companion object
     */
    val personReference = Person
    println(personReference.population)

    /**
     * Casamos a adan con eva
     * Para llamar al método casar se usa como receiver la clase Person por
     * ser Person.Manager el objeto companion
     */
    Person.casar(adan, eva)
    println("El conyuge de $adan es ${adan.conyuge}")
    println("El conyuge de $eva es ${eva.conyuge}")

    /**
     * También se puede utilizar con el nombre del objeto
     * (como cualquier objeto interno de una clase)
     */
    Person.Manager.casar(adan, eva)

    adan.printConyugeInfo()
    eva.printConyugeInfo()
}

