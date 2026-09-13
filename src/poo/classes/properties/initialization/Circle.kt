package poo.classes.properties.initialization

import kotlin.math.PI

class Circle {

    var radius: Double = 0.0

    constructor(radius: Double = 0.0) {
        this.radius = radius
    }

    fun circumference(): Double {
        return 2 * PI * radius
    }

    // Es una inicialización de una propiedad (solo al crear el objeto)
    // Como el valor del radio puede cambiar, es un error cachear el valor del área calculado con el valor inicial del radio
    val areaWrong: Double = PI * radius * radius

    // Es un getter, se calcula cada vez que se accede a la propiedad para su lectura
    val area: Double get() = PI * radius * radius

    val circumference: Double get() = 2 * PI * radius
}





fun main() {
    val circle = Circle(10.0)
    println(circle.circumference())
    println(circle.circumference)
    println(circle.areaWrong)
    println(circle.area)

    // Ahora mutamos el objeto círculo cambiando su propiedad radius
    circle.radius = 3.0

    // La propiedad cacheada no cambia su valor porque se calculó durante la creación del objeto
    println(circle.areaWrong)

    // La propiedad calculada en cada acceso de lectura si que obtiene el valor correcto
    println(circle.area)
    println(circle.circumference)
}