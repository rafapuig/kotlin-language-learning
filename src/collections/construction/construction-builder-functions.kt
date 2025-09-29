package collections.construction.build

/**
 * Otra forma de crear colecciones es mediante las funciones build
 *
 * Estas funciones primero crean una colección mutable
 * para ser rellenada con operaciones de modificación
 * y devuelven una version inmutable (solo lectura) con los mismos elementos
 */

val greetings = buildSet {
    add("Hola")
    addAll(listOf("Hola", "Buenos dias", "Buenas tardes", "Hola"))
    this += "Hello"
    this += "Ciao"
    this -= "Buenas tardes"
}

val fruits = buildList {
    add("manzana")
    add("pera")
    addAll(listOf("naranja", "limon"))
    addAll(arrayOf("manzana", "kiwi"))
    this += "melón"
    this -= "manzana"
}

val rankMedal = buildMap {
    put(1, "Oro")
    this[2] = "Plata"
    putAll(mapOf(3 to "Bronce"))
    putAll(listOf(4 to "Chocolate"))
    putAll(arrayOf(5 to "Cartón", 6 to "Piedra"))
    remove(5)
    this -= 6 // Elimina la entrada con clave 6
    replace(4, "Diploma")
}

fun main() {
    println(fruits)
    println(greetings)
    println(rankMedal)
}
