package poo.intro.properties

/**
 * Propiedades derivadas del valor de otras propiedades (calculadas)
 */

class Rectangle (
    var height: Int,
    var width: Int
) {
    /**
     * La propiedad isSquare se calcula a partir del valor de height y width
     * no necesita un campo de respaldo
     * y por tanto, definimos un getter personalizado
     */
    val isSquare: Boolean
        get() {
            return height == width
        }

    val isSquare2 get() = height == width
}

fun createUnitSquare() = Rectangle(1,1)


fun main() {
    val rect = Rectangle(5, 5)
    println(rect.height)
    println(rect.width)
    println(rect.isSquare)

    rect.width *= 2
    println(rect.isSquare)

    println(createUnitSquare().isSquare)
}