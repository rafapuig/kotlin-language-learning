package poo.objects.companion.factory.method

class Person private constructor(val name: String) {

    var conyuge: Person? = null
        private set

    override fun toString(): String {
        return name
    }

    companion object Factory {

        var population = 0
            private set

        /**
         * Método factoría
         * Crea (fabrica) instancias de clase Person
         * Los métodos factoría son útiles cuando además de crear el objeto
         * se requieren pasos adicionales
         * en este caso incrementar el contador de la población
         * Nota: Para poder usar una expresión body en la función
         * hacemos uso de la scope function also
         * La función also devuelve una referencia a su objeto receptor (receiver)
         * En este caso el objeto instanciado mediante la llamada al constructor
         * después de ejecutar el código dentro del bloque {}
         */
        fun create(name: String): Person =
            Person(name).also {
                println("Creando a $name")
                population++
            }

    }
}


fun Person.Factory.printPopulation() {
    println("Poblacion actual: $population")
}


fun main() {

    Person.printPopulation()

    /** Llamada al método factoría para que nos fabrique a Adan */
    val adan = Person.create("Adan")

    Person.printPopulation()

    /** Llamada alternativa al método factoría indicando el nombre del objeto companion */
    val eva = Person.Factory.create("Eva")

    Person.printPopulation()


}
