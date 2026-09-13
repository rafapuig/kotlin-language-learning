package poo.objects.nested.companion.members

class Person(val name: String) {

    /**
     * El companion object
     *
     * - Es un objeto anidado dentro de la clase al que se le añade la palabra `companion`
     * - Se puede considerar el equivalente en Kotlin a los miembros estáticos de una clase Java
     * - El objeto companion pertenece directamente a la clase
     * y solo se instancía uno por clase
     * - Se accede a sus miembros calificándolos con el nombre de la clase contenedora
     * lo que implica una sintaxis equivalente a Java
     * (En este caso Person)
     * - No es necesario asignar un nombre al objeto companion, por defecto tendrá como nombre `Companion`
     *
     */
    companion object {

        /**
         * La propiedad `population` pertenece al objeto companion
         * Desde fuera de la clase se accede mediante Person.population
         * Pero solamente para lectura (el setter es privado)
         */
        var population = 0
            private set

        /**
         * El metodo `casar` necesita acceder al setter de conyuge de la clase Person
         * que es privado
         * El objeto companion tiene acceso a los miembros privados de la clase contenedora
         * Por eso, definimos esta función dentro del objeto companion
         */
        fun casar(person1: Person, person2: Person) {
            person1.conyuge = person2 // accedemos al setter de conyuge
            person2.conyuge = person1 // accedemos al setter de conyuge
        }
    }

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

}


fun printPeoplePopulation() {
    println("Número de personas: ${Person.population}")
}

/**
 * Metodo de extensión de la clase Person
 * para imprimir información acerca del cónyuge de la persona
 */
fun Person.printConyugeInfo() =
    println("El cónyuge de $this es ${this.conyuge}")


/**
 * Metodo de extension de un companion object
 * Añadimos el metodo al objeto companion (no a la clase contenedora)
 * La sintaxis es fun <nombre-clase-contenedora>.<nombre-objeto-companion>.<nombre-metodo>
 * Si no se ha explicitado nombre del objeto companion, entonces el nombre es Companion
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

    printPeoplePopulation()

    val adan = Person("Adan")
    printPeoplePopulation()

    val eva = Person("Eva")
    printPeoplePopulation()

    /** Llamada al método de extensión del objeto companion de Person */
    Person.printPopulation()


    /**
     * El tipo del objeto companion es Person.Companion
     */
    // Obtener una referencia al objeto companion
    val companionReference = Person.Companion
    println(companionReference.population)

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

