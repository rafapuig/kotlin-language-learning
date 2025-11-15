package poo.delegation.decorator.beverages

/**
 * La delegación de clases permite implementar el patron decorator directamente
 * por el lenguaje Kotlin
 */

/**
 * Bebida abstracta
 */
interface Beverage {
    val description: String
    val cost: Double
}

/**
 * La clase Decaf (cafe descafeinado)
 * Es una concreción de bebida (implemente la interface Beverage)
 */
class Decaf() : Beverage {
    override val description: String = "Café descafeinado"
    override val cost: Double = 2.0
}

/**
 * La clase Expresso
 * Es otra concreción de bebida
 */

class Expresso() : Beverage {
    override val description: String = "Café Expreso"
    override val cost: Double = 3.0
}

/**
 * La clase Milk es un decorador
 */
class Milk(private val beverage: Beverage) : Beverage by beverage {
    override val cost: Double get() = beverage.cost + 1.0
    override val description: String = "${beverage.description} con leche"
}

class Chocolate(private val beverage: Beverage) : Beverage by beverage {
    override val cost: Double get() = beverage.cost + 0.5
    override val description: String get() = "${beverage.description} con chocolate"
}

/**
 * Condiment es un decorador de bebidas abstracto
 * Como delegamos la implementación de la interface Beverage a la propiedad beverage
 *
 * El compilador nos genera la implementación de los miembros de Beverage
 * que no reemplazamos manualmente
 * En este caso reemplazamos la propiedad description
 * Pero no reemplazamos la propiedad cost (el compilador nos la genera automáticamente)
 */
abstract class Condiment(private val beverage: Beverage) : Beverage {
    abstract val name: String
    override val description: String get() = "${beverage.description} con $name"
}

class Whip(private val beverage: Beverage) : Condiment(beverage) {
    override val name: String = "nata"
    override val cost: Double get() = beverage.cost + 1.5
}


fun Beverage.printInfo() {
    println("Un $description cuesta $cost")
}

fun Beverage.milked(): Beverage = Milk(this)
fun Beverage.whipped(): Beverage = Whip(this)
fun Beverage.chocolated(): Beverage = Chocolate(this)

object LongCoffee : Beverage {
    override val description: String get() = "Café largo"
    override val cost: Double get() = 3.5
}

fun testExtensionFunctions() {
    val milkedExpresso = Expresso().milked()
    val chocoMilkDecaf = Decaf().milked().chocolated()
    val dobleWhipDecaf = Decaf().whipped().whipped()

    val whippedChocoLong = LongCoffee.whipped().milked()

    milkedExpresso.printInfo()
    chocoMilkDecaf.printInfo()
    dobleWhipDecaf.printInfo()
    whippedChocoLong.printInfo()
}

fun main() {
    val milkedExpresso = Milk(Expresso())
    val chocoMilkDecaf = Chocolate(Milk(Decaf()))

    milkedExpresso.printInfo()
    chocoMilkDecaf.printInfo()

    val whippedMilkedDecaf = Whip(Milk(Decaf()))
    whippedMilkedDecaf.printInfo()

    testExtensionFunctions()
}