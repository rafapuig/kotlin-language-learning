package poo.inheritance

/**
 * Para que una clase sea extensible (base, heredable)
 * Hay que indicarlo explícitamente al compilador
 * Con la palabra open
 * Clase abierta a la extensión
 */
open class Cat(val name: String) {

    /**
     * Los métodos reemplazables (overridables)
     * también se deben indicar explícitamente
     */
    open fun makeSound() {
        println("Miau")
    }

    open fun feed() {
        println("$name come")
    }

    /**
     * Este método no se puede reemplazar en las subclases
     */
    fun display() {
        println(name)
    }
}

/**
 * La clase WildCat hereda de Cat
 * declara un constructor primario con un parámetro name:String
 * el valor del parámetro se usa como argumento para
 * el constructor de la clase base Car
 * y asi inicializar la propiedad name
 */
open class WildCat(name: String) : Cat(name) {

    /**
     * El metodo makeSound es reemplazado en la clase derivada,
     * pero a su vez es declarado no reemplazable en las subclases
     * mediante la palabra clave final
     */
    final override fun makeSound() {
        println("FFFFFFF!!!")
    }

    /**
     * El metodo feed es reemplazado en la clase derivada,
     * y a su vez es reemplazable en las subclases
     */
    override fun feed() {
        super.feed()
        println("Y zarpazo!!!")
    }

    /*override fun display() {
        super.display()
    }*/
}

class BigWildCat(name: String) : WildCat(name) {
    /**
     * No se puede reemplazar el metodo makeSound
     * porque ha sido cerrado para el reemplazo en la clase base
     */
    /*override fun makeSound() {
        super.makeSound()
    }*/

    override fun feed() {
        super.feed()
        println("Y morisco!!!")
    }
}

fun useCat(cat: Cat) {
    println("Testeando el gato ${cat.name} de tipo ${cat.javaClass.simpleName}")
    cat.display()
    cat.makeSound()
    cat.feed()
}

fun main() {
    val tom = Cat("Tom")
    val salem = WildCat("Salem")
    val garfield = BigWildCat("Garfield")

    useCat(tom)
    useCat(salem)
    useCat(garfield)
}