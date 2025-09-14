package poo.dataclasses.equals

data class Rectangle(
    val width: Int = 0,
    val height: Int = 0
) {
    val area = width * height
}

fun main() {
    val rect1 = Rectangle(3, 7)
    val rect2 = Rectangle(3, 7)

    println("Son el mismo objeto? ${if (rect1 === rect2) "Si" else "No"}")
    println("Son iguales? ${if (rect1 == rect2) "Si" else "No"}")

    /**
     * Dos objetos iguales deben generar el mismo código hash
     *
     * (recordar que al reves no tiene porqué ser cierto, dos objetos con mismo hash
     * no tienen porqué ser iguales)
     * Conclusión:
     * - Si el hash es diferente entonces no son iguales
     * (Lo que nos evita comparar propiedad por propiedad para saber si no son iguales)
     * - Si el hash es igual entonces se procederá a comparar las propiedades para
     * determinar si son iguales
     */
    println(rect1.hashCode())
    println(rect2.hashCode())

}