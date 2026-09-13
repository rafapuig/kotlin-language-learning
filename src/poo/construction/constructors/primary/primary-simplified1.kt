package poo.construction.constructors.primary.simplified

/**
 * El constructor primario
 * se define después del nombre de la clase
 * mediante la palabra constructor y la lista de parámetros
 * (la palabra constructor no es necesaria a no ser que se declare modificadores de acceso o anotaciones)
 *
 * El constructor primario de la clase Circle
 * declara un parámetro de nombre radius de tipo Double
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