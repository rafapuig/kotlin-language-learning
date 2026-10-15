package poo.objects.nested.companion.factory

import generics.runtime.reified.accesors.canonical


enum class Gender { MALE, FEMALE }

/**
 * La clase persona debe ser extensible (puede ser usada como superclase)
 * para ello, hay que abrirla a la extension explícitamente (hacerla heredable)
 * con la palabra clave `open`
 */
/**
 * El constructor es un "miembro" privado
 * Solamente pueden acceder a este los miembros declarados dentro de clase
 * El companion object es un objeto interno (anidado) y, por tanto, tiene acceso al constructor
 */
open class Person private constructor(val name: String, val gender: Gender) {

    /**
     * Los métodos factoría permiten abstraer la lógica
     * para decidir que subclase se instancia
     * en función de los parámetros de entrada del metodo factoría
     */
    companion object Factory {
        fun of(name: String, gender: Gender): Person =
            when (gender) {
                Gender.MALE -> Man(name)
                Gender.FEMALE -> Woman(name)
            }
    }

    /**
     * Los miembros de una clase no son reemplazables (overridables) por defecto
     * están cerrados a la extensión
     * Para que un miembro sea reemplazable se debe abrir con la palabra open
     */
    open fun describe() {
        println("$name es una persona de género $gender")
    }

    /**
     * La clase Man es una subclase (anidada) de Person
     * El constructor primario debe llamar al constructor de la clase base
     */
    private class Man(name: String) : Person(name, Gender.MALE) {
        /**
         * La clase Man reemplaza la implementación del método describe()
         */
        override fun describe() {
            println("$name es un hombre")
        }
    }

    private class Woman(name: String) : Person(name, Gender.FEMALE) {
        /**
         * La clase Woman reemplaza la implementación del método describe()
         */
        override fun describe() {
            println("$name es una mujer")
        }
    }

}


fun main() {

    // Creamos a Adan, que será un objeto de tipo Hombre
    val adan = Person.of("Adan", gender = Gender.MALE)

    // Creamos a Eva, que será de tipo Mujer (por usar como argumento para gender Gender.FEMALE)
    val eva = Person.of("Eva", gender = Gender.FEMALE)

    adan.describe()
    eva.describe()

    // Comprobamos los tipos de los objetos adan y eva
    println(adan.javaClass.canonicalName)
    println(eva.javaClass.name)
}