package conventions.collections

/**
 * Convenciones usadas en colecciones
 *
 * Las operaciones más habituales cuando se trabaja con colecciones son las de
 * - obtener y establecer sus elementos mediante un índice.
 * - comprobar si un elemento pertenece a la colección.
 *
 * Estas dos operaciones están soportadas en Kotlin mediante sintaxis de operador:
 * - get y set mediante el operador `[]`
 * - comprobar pertenencia mediante el operador `in` (además de iterarla)
 *
 * Si definimos alguna clase que deba comportarse como una colección podemos añadirle estas operaciones.
 */

/**
 * Acceder elementos mediante índice. Convenciones get y set
 */

fun testCollectionIndexAccessing() {

    val names = mutableListOf("Rafael", "Miguel")

    println(names)

    // Obtener el elemento mediante índice y sintaxis de operador []
    println(names[0])
    // Equivale a usar el metodo operador get con sintaxis de llamada a función
    println(names.get(1))

    // Establecer el elemento mediante índice y sintaxis de operador []
    names[0] = "Rafa"

    // Equivale a establecer el elemento mediante llamada explícita a la función operador set
    names.set(1, "Javier")
    println(names)

    //names[2] = "Gabriel" // ERROR, índice fuera de rango
}

fun testMapIndexAccessing() {
    val map = mutableMapOf(1 to "uno", 2 to "dos", 3 to "tres")
    println(map)

    println(map[2])
    println(map.get(3))

    map[4] = "cuatro"
    map.put(5, "cinco")

    println(map)
}

fun main() {
    //testCollectionIndexAccessing()
    testMapIndexAccessing()
}