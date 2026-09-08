package poo.person12

data class Person(
    val name: String = "Anónimo",
    val age: Int? = null
)

fun main() {

    val belen = Person("Belen", 57)

    /**
     * Desestructurar es obtener los valores de las propiedades que nos interesen de un objeto
     * de manera individual
     * (como si rompiéramos el objeto y nos quedáramos con las piezas)
     *
     * La lista de variables recoge valores en el orden en que fueron declaradas las propiedades en el constructor primario
     */

    // Desestructurar
    val (name, age) = belen
    println(name)
    println(age)
}