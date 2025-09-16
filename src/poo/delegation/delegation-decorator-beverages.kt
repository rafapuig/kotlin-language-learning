package poo.delegation

interface Beverage {
    val description: String
    val cost: Double
}

class Decaf() : Beverage {
    override val description: String = "Café descafeinado"
    override val cost: Double = 2.0
}

class Expresso() : Beverage {
    override val description: String = "Café Expreso"
    override val cost: Double = 3.0
}

class Milk(beverage: Beverage) : Beverage by beverage {
    override val cost: Double = beverage.cost + 1.0
    override val description: String = "${beverage.description} con leche"

}

class Chocolate(beverage: Beverage) : Beverage by beverage {
    override val cost: Double = beverage.cost + 0.5
    override val description: String = "${beverage.description} con chocolate"
}

abstract class Condiment(private val beverage: Beverage) : Beverage by beverage {
    abstract val name: String
    override val description: String get() = "${beverage.description} con $name"
}

class Whip(beverage: Beverage) : Condiment(beverage) {
    override val name: String = "Whip"
    override val cost: Double = 1.5
}

fun Beverage.printInfo() {
    println("Un $description cuesta $cost")
}

fun main() {
    val milkedExpresso = Milk(Expresso())
    val chocoMilkDecaf = Chocolate(Milk(Decaf()))

    milkedExpresso.printInfo()
    chocoMilkDecaf.printInfo()

    val whippedMilkedDecaf = Whip(Milk(Decaf()))
    whippedMilkedDecaf.printInfo()
}