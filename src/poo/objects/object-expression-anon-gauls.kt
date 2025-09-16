package poo.objects

open class Gaul(val name : String) {

    companion object {
        const val MAX_POWER = 1000
    }

    open var power = 10
        protected set

    open fun drinkPotion() {
        println("$name bebiendo la poción mágica....")
        power = MAX_POWER
        println("Su poder aumenta a $power")
    }

    override fun toString() = name
}

fun main() {
    val asterix = Gaul("Asterix")
    val obelix = object : Gaul("Obelix") {
        override fun drinkPotion() {
            throw UnsupportedOperationException("$name no puede beber de la poción mágica");
        }

        override var power: Int
            get() = MAX_POWER
    }

    println(asterix.toString() + " tiene un poder de " + asterix.power)
    println(obelix.toString() + " tiene un poder de " + obelix.power)

    asterix.drinkPotion()
    try {
        obelix.drinkPotion()
    } catch (e: Exception) {
        println(e.message)
    }

    println(asterix.toString() + " tiene un poder de " + asterix.power)
    println(obelix.toString() + " tiene un poder de " + obelix.power)
}