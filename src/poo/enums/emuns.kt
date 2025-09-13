package intro.poo.enums

enum class Palo { Oros, Copas, Espadas, Bastos }

/**
 * La clase enumerada Color consta de 3 propiedades
 */
enum class Color(val r: Int, val g: Int, val b: Int) {
    Red(255, 0, 0), // Primera constante (se especifican los valores de las propiedades r,g,b
    Green(0, 255, 0), // Segunda constante
    Blue(0, 0, 255),
    Yellow(0, 255, 255); // Un ; para terminar los elementos

    //Definir una propiedad
    val rgb = (r * 256 + g) * 256 + b

    // Definir métodos en la clase enum
    fun print() = println("R$r, G$g, b$b")
    fun printInfo() = println("$this is $rgb")
}

fun main() {
    Color.Yellow.printInfo()
}