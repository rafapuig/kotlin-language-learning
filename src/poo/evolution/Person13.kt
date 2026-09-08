package poo.person13

/**
 * Uso del metodo copy de una data class
 * para crear versiones modificadas de un objeto
 * util cuando las propiedades de una data class son val (solo lectura)
 */

data class Person(
    val name: String = "Anonimo",
    val age: Int? = null
)

fun main() {

    val belen = Person("Belen", 57)

    /**
     * Las data class definen un metodo copy
     * que permite obtener una copia superficial del objeto
     */
    val clone = belen.copy() // Crea un objeto con el mismo estado que el objeto receptor

    val modifiedNameClone = belen.copy(name = "Marta") // con edad 57

    val modifiedAgeClone = belen.copy(age = 50) // Belen con 50 años

    val everythingModifiedClone = belen.copy(name = "Alicia", age = 25)

    println(belen)
    println(clone)
    println(modifiedNameClone)
    println(modifiedAgeClone)
    println(everythingModifiedClone)
}