package poo.person10

class Person(val name: String = "Anonimo", val age: Int? = null)

fun main() {
    val belen = Person("Belen", 57)

    // Creamos un objeto con los mismos valores de atributos que otro (mismo estado)
    val clon = Person("Belen", 57)

    // la variable belen2 hará referencia a la misma persona a la que se hace referencia mediante la variable belen
    val belen2 = belen

    // Comprobamos con el operador === si se refieren exactamente a la misma instancia / objeto (equivale a == de Java)
    println(clon === belen) //false no son el mismo objeto
    println(belen2 === belen) // true, si son el mismo objeto

    // El operador == es el equivalente al método equals de Java
    println(clon == belen) // false !!!

}