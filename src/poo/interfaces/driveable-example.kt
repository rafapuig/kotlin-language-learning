package poo.interfaces

// Definimos una interface
interface Drivable {
    fun drive()
    fun stop()
}


// Clase que implementa la interface
class Car : Drivable {
    override fun drive() {
        println("El coche se está conduciendo.")
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
fun performMovement(vehicle: Drivable) {
    vehicle.drive()
    vehicle.stop()
}

// Función main para probar el código
fun main() {
    val myCar = Car()
    val myBike = Bike()

    println("Trayecto con el coche:")
    performMovement(myCar)

    println("\nTrayecto con la bicicleta:")
    performMovement(myBike)
}
