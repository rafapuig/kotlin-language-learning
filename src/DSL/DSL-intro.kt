package DSL

import java.io.FileReader
import java.util.Locale.getDefault

/**
 * El diseño de un DSL en Kotlin descansa en varias características del lenguaje:
 * - Lambdas con receptores
 * - La convención invoke (mayor flexibilidad para combinar lambdas)
 * Permiten una estructura al DSL mediante la definición de
 * - funciones específicas de un bloque de código
 * - propiedades
 * - comportamiento
 */

/**
 * Clean API
 * - Debe quedar claro que está sucediendo en el código para quien lo lea
 *      -- Buena elección de los nombres y conceptos
 * - Minimalismo, evitando sintaxis innecesaria y ceremonia
 *      -- Que sea indistinguible de una característica integrada en el propio lenguaje
 *
 * Características (elementos) de Kotlin que hacen posible construir clean APIs
 * - Funciones de extensión
 * - Llamadas infijas
 * - Sintaxis de lambdas con atajos
 * - sobrecarga de operadores
 */

class StringUtil {
    companion object {
        fun capitalize(string: String): String =
            string.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString()
            }
    }
}

fun String.capitalize(): String =
    replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString()
    }

fun main() {
    val s = "rafael"

    val csrs = StringUtil.capitalize(s) // Sintaxis regular
    val cscs = s.capitalize() // Clean sintaxis (extension function)

    val prs = 1.to("one") // Sintaxis regular
    val pcs = 1 to "one" // Clean sintaxis (llamada infija)

    val set = mutableSetOf(1, 3)
    set.add(2) // Sintaxis regular
    set += 2   // Sobrecarga de operadores

    val map = mutableMapOf("uno" to 1, "dos" to 2)
    val mvrs = map.get("dos") // Sintaxis regular de llamada al metodo get de un Map
    val mvcs = map["dos"] // Clean sintaxis con operador de indexación sobrecargado

    val file = FileReader("/users/rafapuig/text.txt")
    file.use({ file -> file.read() })  // Llamada a función
    file.use { it.read() } // Clean sintaxis, lambda fuera de los paréntesis y uso de it

    val sb = StringBuilder()
    // Sintaxis regular, se indica el objeto receptor el punto y el metodo cada vez
    sb.append("si")
    sb.append("no")

    with(sb) { // Clean sintaxis, lambda con receptor
        append("si")    // Dentro del bloque lambda el receiver es this
        append("no")    // no es necesario usar explícitamente this para llamar a un metodo
    }

    // Sintaxis regular para fabricar una lista inmutable paso a paso
    val m = mutableListOf<Int>()
    m.add(1)
    m.add(2)
    val list = m.toList() // Construye una lista inmutable con los mismos elementos de la mutable

    // Clean sintaxis mediante funciones fabrica (builder) con lambdas
    val cleanList = buildList {
        add(1)
        add(2)
    }
}
