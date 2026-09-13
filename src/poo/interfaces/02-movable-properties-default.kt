package poo.interfaces

interface Moveable {
    /**
     * Propiedades abstractas de la interface
     */
    var x: Double
    var y: Double

    // Metodo con implementación por defecto
    fun moveTo(dx: Double, dy: Double) {
        x += dx
        y += dy
    }
}

/**
 * Clase Actor
 * implementadora de la interface Moveable
 *
 * Implementación de las propiedades en el constructor primario
 * Permite inicializarlas durante la construcción de la instancia pasando argumentos al constructor
 */
class Actor(
    override var x: Double = 0.0, // Implementación de la propiedad abstracta x
    override var y: Double = 0.0  // Implementación de la propiedad abstracta y
) : Moveable {

    override fun toString(): String {
        return arrayOf(
            "X = $x",
            "Y = $y"
        ).joinToString(", ", "${javaClass.simpleName} {", "}")
    }

    // El metodo moveTo se puede reemplazar en la clase implementadora
    override fun moveTo(dx: Double, dy: Double) {
        println("Moving from $x,$y ...")

        // Delegación en la implementación por defecto de la interface
        super<Moveable>.moveTo(dx, dy)
    }
}



class Shape : Moveable {
    /**
     * Implementación de las propiedades abstractas en el cuerpo de la clase
     */
    override var x: Double = 0.0
    override var y: Double = 0.0
}



fun testMoveableActor() {
    val moveable: Moveable = Actor(10.0,10.0)

    println(moveable)

    moveable.x = 12.0
    moveable.y = 15.6

    println(moveable)

    moveable.moveTo(2.0, 5.0)
    println(moveable)
}


fun testMoveableShape() {
    //val shape = Shape(10.0, 10.0) // ERROR, aqui no podemos inicializar las propiedades durante la contrucción

    val shape = Shape()
    println(shape)

    shape.x = 12.0
    shape.y = 15.0
    println(shape)

    shape.moveTo(2.0, 5.0)
    println(shape)

}


fun main() {
    testMoveableActor()
    testMoveableShape()
}