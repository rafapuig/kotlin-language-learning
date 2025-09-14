package poo.construction.primary.simplified

/**
 * El constructor primario se define
 * después del nombre de la clase
 *
 * El constructor primario de la clase Circle
 * declara un parámetro radius de tipo Double
 */
class Circle constructor(radius: Double) {

    /**
     * Para inicializar la propiedad con el valor del parámetro del constructor
     * primario no es necesario el bloque init
     * se puede usar el parámetro en la expresión de inicialización
     */
    var radius: Double = radius

    /*init {
        this.radius = radius
    }*/

}

fun main() {

    val circle = Circle(4.0)

    println("Circulo de radio ${circle.radius}")
}