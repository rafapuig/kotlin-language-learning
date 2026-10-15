package poo.objects.expression

/**
 * Los objetos anónimos también pueden extender de una superclase
 * La clase Gaul está abierta a la extension
 */
open class Gaul(val name : String) {

    companion object {
        const val MAX_POWER = 1000
    }

    // El poder inicial de un galo es 10
    open var power = 10
        protected set // no se puede modificar desde fuera de la clase

    open fun drinkPotion() {
        println("$name bebiendo la poción mágica....")
        power = MAX_POWER
        println("Su poder aumenta a $power")
    }

    override fun toString() = name
}


fun main() {
    // Creamos a Asterix como un Galo normal
    val asterix = Gaul("Astérix")

    // Creamos a Obélix como un objeto de tipo anónimo que es subclase de Galo,
    // pero que responde de una manera especial al mensaje drinkPotion
    val obelix = object : Gaul("Obélix") {

        // Reemplazamos el comportamiento normal de un objeto Gaul cuando
        // responde a la llamada del metodo drinkPotion para este objeto de tipo anónimo
        override fun drinkPotion() {
            throw UnsupportedOperationException("$name no puede beber de la poción mágica");
        }

        // El poder inicial de Obélix es el máximo
        override var power: Int = MAX_POWER
            //get() = MAX_POWER
    }

    // Mostramos el poder de ambos galos
    println(asterix.toString() + " tiene un poder de " + asterix.power)
    println(obelix.toString() + " tiene un poder de " + obelix.power)

    // Ahora, hacemos que Asterix beba la poción mágica
    asterix.drinkPotion()

    // Cuando, intentamos que Obélix beba de la poción se producirá una excepción
    try {
        obelix.drinkPotion()
    } catch (e: Exception) {
        println(e.message)
    }

    // Mostramos de nuevo el poder de ambos galos
    println(asterix.toString() + " tiene un poder de " + asterix.power)
    println(obelix.toString() + " tiene un poder de " + obelix.power)

    // Mostrar nombres de los tipos de los objetos
    println(asterix.javaClass.name)
    println(obelix.javaClass.name)
}