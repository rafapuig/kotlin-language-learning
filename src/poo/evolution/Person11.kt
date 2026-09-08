package poo.person11

/**
 * Si colocamos la palabra data delante de class
 * Creamos una data class
 * Lo que hace que se redefina el metodo equals de la clase para tratar dos objetos como iguales
 * si tienen el mismo estado (mismo valor de todas sus propiedades): igualdad estructural
 */
data class Person(val name: String = "Anonimo", val age: Int? = null)

fun main() {

    val belen = Person("Belen", 57)
    val clon = Person(belen.name, belen.age) // mismo estado que el objeto referenciado por la variable belen

    val belen2 = belen
    println(clon === belen) //false
    println(belen2 === belen) // true igualdad referencial

    println(clon == belen) // TRUE !!! igualdad estructural, llamada al metodo equals
    println(clon.equals(belen)) // Equivalente verboso de la instrucción anterior
}