package poo.objects.companion.members

class Person(val name: String) {

    /**
     * bloque de inicialización de los objetos Person
     * Tiene acceso directo a los miembros declarados en el companion object
     */
    init {
        population++
    }

    /**
     * Propiedad cónyuge
     * Se puede acceder desde fuera de la clase Person (visibilidad public)
     * Peros solamente se puede mutar desde la clase (setter con visibilidad private)
     */
    var conyuge: Person? = null
        private set

    override fun toString(): String {
        return name
    }


    /**
     * El companion object
     *
     * Se puede considerar un equivalente a los miembros estáticos de una clase Java
     * El objeto companion pertenece directamente a la clase
     * solo se instancía uno por clase
     * Se accede a sus miembros calificándolos con el nombre de la clase contenedora
     * lo que daría una sintaxis equivalente a Java
     * (En este caso Person)
     *
     */
    companion object {

        /**
         * La propiedad population pertenece al objeto companion
         * Desde fuera de la clase se accede mediante Person.population
         * Pero solamente para lectura (el setter es privado)
         */
        var population = 0
            private set

        /**
         * El método casar necesita acceder al setter de la clase Person
         * que es privado
         * Por eso, lo definimos dentro de el objeto companion
         */
        fun casar(person1: Person, person2: Person) {
            person1.conyuge = person2 // accedemos al setter de conyuge
            person2.conyuge = person1
        }
    }
}

fun printNumPeople() {
    println("Número de personas: ${Person.population}")
}

fun Person.printConyugeInfo() {
    println("El cónyuge de $this es ${this.conyuge}")
}

/**
 * Método de extension de un companion object
 * La sintaxis es fun <nombre-clase-contenedora>.<nombre-objeto-companion>.<nombre-metodo>
 */
fun Person.Companion.printPopulation() {
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
    val companionRefence = Person.Companion
    println(companionRefence.population)

    /**
     * La clase Person se considera una referencia a su companion object
     */
    val personReference = Person
    println(personReference.population)

    /**
     * Casamos a adan con eva
     * Para llamar al método casar se usa como receiver la clase Person
     */
    Person.casar(adan, eva)
    println("El cónyuge de $adan es ${adan.conyuge}")
    println("El cónyuge de $eva es ${eva.conyuge}")

    adan.printConyugeInfo()
    eva.printConyugeInfo()
}

