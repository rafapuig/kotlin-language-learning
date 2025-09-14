package poo.construction.primary.simplified.property.readonly

/**
 * El constructor primario se define
 * después del nombre de la clase
 *
 * El constructor primario de la clase Circle
 * declara una PROPIEDAD radius de tipo Double (en este caso de solo lectura)
 * En este caso el constructor cuenta con un parámetro radius
 * que inicializa la propiedad radius declarada en el constructor
 * al usar val la propiedad declarada es de solo lectura
 */
class Circle constructor(val radius: Double) {

    //var radius: Double = radius

}

fun main() {

    val circle = Circle(4.0)

    println("Circulo de radio ${circle.radius}")

    //circle.radius = 5.0 // la propiedad radius es de solo lectura
    println("Circulo de radio ${circle.radius}")
}