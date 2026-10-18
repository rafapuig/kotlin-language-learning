package poo.delegation.decorator.beverages

/**
 * La delegación de clases permite implementar el patron decorator directamente
 * por el lenguaje Kotlin
 */

/**
 * Bebida abstracta
 */
sealed interface Beverage {
    val cost: Double
    val description: String
}

/**
 * La clase Decaf (cafe descafeinado)
 * Es una concreción de bebida (implemente la interface Beverage)
 */
class Decaf : Beverage {
    override val description = "Café Descafeinado"
    override val cost = 2.0
}

/**
 * El objeto Espresso
 * (mejor un singleton para las bebidas base porque no hace falta crear multiples instancias iguales)
 * Es otra concreción de bebida
 */

object Espresso : Beverage {
    override val description = "Café Expreso"
    override val cost = 3.0
}

/**
 * Objeto LongCoffee (cafe largo)
 */
object LongCoffee : Beverage {
    override val description = "Café largo"
    override val cost = 3.5
}


/**
 * Decoradores
 *
 * Un decorador
 * implementa la interface (Beverage)
 * y recibe la implementación que quiere extender por composición en lugar de heredar
*/

/**
 * La clase Milk es un decorador de bebidas
 */
class Milk(private val beverage: Beverage) : Beverage by beverage {
    override val cost = beverage.cost + 1.0
    override val description = "${beverage.description} con leche"
}

class Chocolate(private val beverage: Beverage) : Beverage by beverage {
    override val cost = beverage.cost + 0.5
    override val description: String get() = "${beverage.description} con chocolate"
}

class Sugar(private val beverage: Beverage) : Beverage by beverage {
    // El azúcar es gratis (no modifica el coste)
    //override val cost: Double get() = beverage.cost + 0.0
    override val description = "${beverage.description} con azúcar"
}

/**
 * Decorador Propina (Tip)
 */
class Tip(amount: Double, private val beverage: Beverage) : Beverage by beverage {
    override val cost = beverage.cost + amount
    // No se modifica la descripción (solo el coste)
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
abstract class Condiment(private val beverage: Beverage) : Beverage by beverage {
    abstract val name: String
    override val description = "${beverage.description} con $name"
}

class Whip(private val beverage: Beverage) : Condiment(beverage) {
    override val name get() = "nata"
    override val cost = beverage.cost + 1.5
}

class Ginger(private val beverage: Beverage) : Condiment(beverage) {
    override val name get() = "jengibre"
    override val cost = beverage.cost + 0.25
}


/**
 * Funciones de extension de la interface Beverage
 */

fun Beverage.withMilk(): Beverage = Milk(this)
fun Beverage.whipped(): Beverage = Whip(this)
fun Beverage.withChocolate(): Beverage = Chocolate(this)
fun Beverage.withSugar(): Sugar = Sugar(this)
fun Beverage.withGinger(): Beverage = Ginger(this)
fun Beverage.tipped(amount: Double): Beverage = Tip(amount, this)


fun Beverage.printInfo() {
    println("Un $description cuesta $cost")
}



fun testDecorators() {
    val chocoMilkDecaf = Chocolate(Milk(Decaf()))
    val milkedEspresso = Milk(Espresso)

    milkedEspresso.printInfo()
    chocoMilkDecaf.printInfo()

    val whippedMilkedDecaf = Whip(Milk(Decaf()))
    whippedMilkedDecaf.printInfo()

    val doubleWhippedMilkedLongCoffee = Whip(Whip(Milk(LongCoffee)))
    doubleWhippedMilkedLongCoffee.printInfo()
}


fun testExtensionFunctions() {

    val chocoMilkDecaf = Decaf().withMilk().withChocolate()
    val dobleWhipDecaf = Decaf().whipped().whipped()

    val espressoWithMilk = Espresso.withMilk()
    val longCoffeeWhippedWithChocolate = LongCoffee.whipped().withChocolate()
    val longCoffeeDoubleWhippedWithMilk = LongCoffee.whipped().whipped().withMilk()

    val longCoffeeWithSugar = LongCoffee.withSugar()
    val longCoffeeWithMilkAndSugar = LongCoffee.withMilk().withSugar()
    val espressoWithGinger = Espresso.withGinger()

    val espressoTippedWithSugarAndMilk = Espresso.tipped(0.6).withSugar().withMilk()

    espressoWithMilk.printInfo()
    chocoMilkDecaf.printInfo()
    dobleWhipDecaf.printInfo()
    longCoffeeWhippedWithChocolate.printInfo()
    longCoffeeWithSugar.printInfo()
    longCoffeeWithMilkAndSugar.printInfo()
    espressoWithGinger.printInfo()
    espressoTippedWithSugarAndMilk.printInfo()
}


fun main() {
    testDecorators()
    testExtensionFunctions()
}