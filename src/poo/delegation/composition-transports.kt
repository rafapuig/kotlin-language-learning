package poo.delegation

abstract class Transport(
    private val engine: Engine
) {
    private var driver: Driver? = null

    fun setDriver(driver: Driver) =
        apply { this.driver = driver }

    fun deliver(destination: String, cargo: String) {
        if (driver == null) throw IllegalStateException("No se ha establecido conductor")
        println("Entregando por ${this.javaClass.simpleName} $cargo a $destination")
        driver!!.navigate()
        engine.move()
    }
}

class Car(engine: Engine) : Transport(engine)

class Truck(engine: Engine) : Transport(engine)


abstract class Engine {
    abstract fun move()
}

abstract class Driver {
    abstract fun navigate()
}

class CombustionEngine : Engine() {
    override fun move() {
        println("Moviendose mediante un motor de Combustion")
    }
}

class ElectricEngine : Engine() {
    override fun move() {
        println("Moviendose mediante un motor Electrico")
    }
}

class Robot : Driver() {
    override fun navigate() {
        println("Navegado por Robot")
    }
}

class Human : Driver() {
    override fun navigate() {
        println("Navegado por Human")
    }
}

fun main() {
    val robotDriver = Robot()
    val humanDriver = Human()

    val autopilotCombustionEngineCar: Transport = Car(CombustionEngine()).setDriver(robotDriver)
    autopilotCombustionEngineCar.deliver("Madrid", "Paquete 001")

    val electricEngineTruck: Transport = Truck(ElectricEngine())
    electricEngineTruck.setDriver(robotDriver)
    electricEngineTruck.deliver("Valencia", "Paquete 002")
    electricEngineTruck.setDriver(humanDriver)
    electricEngineTruck.deliver("Barcelona", "Paquete 003")

    val combustionEngineTruck: Transport = Truck(CombustionEngine())
    combustionEngineTruck.setDriver(humanDriver).deliver("Bilbao", "Paquete 004")

    val electricEngineCar: Transport = Car(ElectricEngine())

}
