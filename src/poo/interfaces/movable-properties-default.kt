package poo.interfaces

interface Moveable {
    var x: Double
    var y: Double

    // metodo con implementación por defecto
    fun moveTo(dx: Double, dy: Double) {
        x += dx
        y += dy
    }
}

class Actor(
    override var x: Double = 0.0,
    override var y: Double = 0.0
) : Moveable {

    override fun toString(): String {
        return arrayOf(
            "X = $x",
            "Y = $y"
        ).joinToString(", ", "${javaClass.simpleName} {", "}")
    }

    // Se puede reemplazar en la clase implementadora
    override fun moveTo(dx: Double, dy: Double) {
        println("Moving $x to $y ...")
        super<Moveable>.moveTo(dx, dy) // Delegacion en la implementacion por defecto de la interface
    }
}

fun main() {
    val moveable: Moveable = Actor()
    moveable.x = 12.0
    moveable.y = 15.6

    println(moveable)

    moveable.moveTo(2.0, 5.0)
    println(moveable)
}