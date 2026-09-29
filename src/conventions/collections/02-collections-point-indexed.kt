package conventions.collections

class Point(var x: Int, var y: Int)

operator fun Point.get(index: Int) = when(index) {
    0 -> x
    1 -> y
    else -> throw IndexOutOfBoundsException("Indice $index de coordenadas inválido")
}

operator fun Point.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Indice $index de coordenadas inválido")
    }
}

fun main() {
    val point = Point(5,9)
    println(point[0])
    println(point[1])
}