package poo.interfaces

// Definimos una interfaz
interface Drivable {
    fun drive()
    fun stop()
}

// Clase que implementa la interfaz
class Car : Drivable {
    override fun drive() {
        println("El coche está conduciendo.")
    }

    override fun stop() {
        println("El coche se ha detenido.")
    }
}

// Otra clase que implementa la interfaz
class Bike : Drivable {
    override fun drive() {
        println("La bicicleta está en movimiento.")
    }

    override fun stop() {
        println("La bicicleta se ha detenido.")
    }
}

// Función que recibe cualquier objeto Drivable
fun startJourney(vehicle: Drivable) {
    vehicle.drive()
    vehicle.stop()
}

// Función main para probar el código
fun main() {
    val myCar = Car()
    val myBike = Bike()

    println("Trayecto con el coche:")
    startJourney(myCar)

    println("\nTrayecto con la bicicleta:")
    startJourney(myBike)
}
