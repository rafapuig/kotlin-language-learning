package poo.delegation

/**
 * Un Transport
 * se compone de:
 * - un motor (Engine) inyectado en el constructor --> inyección de dependencias
 * - un conductor (Driver) que se establece con un setter
 */
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
        engine.run()
    }
}

/* Subclases de la clase Trasporte: Car y Truck */
class Car(engine: Engine) : Transport(engine)

class Truck(engine: Engine) : Transport(engine)


/**
 * Motor
 * es una abstracción
 */
sealed interface Engine {
    fun run()
}


data object CombustionEngine : Engine {
    override fun run() {
        println("Moviéndose mediante un motor de Combustion")
    }
}
class ElectricEngine : Engine {
    override fun run() {
        println("Moviéndose mediante un motor Eléctrico")
    }
}


/**
 * En lugar de una interface se puede usar una clase abstracta
 * (No es conveniente aquí, ya que no ha sido necesario definir ningún ESTADO
 * y con un interface nos habría sido suficiente)
 */
abstract class Driver {
    abstract fun navigate()
}

object Robot : Driver() {
    override fun navigate() {
        println("Navegado por Robot")
    }
}

class Human(val name: String) : Driver() {
    override fun navigate() {
        println("Navegado por Human con nombre $name")
    }
}

fun main() {

    // Creamos un coche con motor de combustion pilotado por el robot
    val autopilotCombustionEngineCar: Transport = Car(CombustionEngine).setDriver(Robot)
    autopilotCombustionEngineCar.deliver("Madrid", "Paquete 001")

    // Creamos un conductor humano
    val humanDriver = Human("Bautista")

    // Creamos un camion con motor eléctrico
    val electricEngineTruck: Transport = Truck(ElectricEngine())
    with(electricEngineTruck) {
        // Establecemos el robot como conductor
        setDriver(Robot)
        // Hacemos una entrega
        deliver("Valencia", "Paquete 002")
        // Ahora, establecemos al humano como conductor
        setDriver(humanDriver)
        // Y hacemos otra entrega
        deliver("Barcelona", "Paquete 003")
    }

    // Creamos un camion con motor de combustión
    val combustionEngineTruck: Transport = Truck(CombustionEngine)
    combustionEngineTruck.setDriver(humanDriver).deliver("Bilbao", "Paquete 004")

    val electricEngineCar: Transport = Car(ElectricEngine())

    Car(ElectricEngine()).setDriver(Human("Bartolo")).also {
        it.deliver("Sevilla", "Paquete 004")
    }

}
