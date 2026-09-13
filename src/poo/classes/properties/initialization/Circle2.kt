package poo.classes.properties.initialization.circle2

import kotlin.math.PI

class Circle {

    constructor(radius: Double = 0.0) {
        this.radius = radius
    }

    fun circumference(): Double = 2 * PI * radius
    fun area(): Double = PI * radius * radius

    private var _area  = area()

    private var _circumference: Double = circumference()


    private fun update() {
        println("Recalculando el area...")
        _area = area()
        println("Recalculando la circunferencia...")
        _circumference = circumference()
    }


    var radius: Double = 0.0
        set(value) {
            field = value
            update()
        }


    val area get() = _area

    val circumference: Double get() = _circumference
}


fun main() {
    val circle = Circle(10.0)

    println(circle.circumference)
    println(circle.area)


    // Volvemos a acceder a las propiedades sin caer en el coste de recalcular su valor
    println(circle.circumference)
    println(circle.area)


    // Ahora mutamos el objeto círculo cambiando su propiedad radius
    // Se recalculan el área y la circunferencia
    circle.radius = 3.0

    println(circle.area)
    println(circle.circumference)

    println(circle.area)
    println(circle.circumference)
}