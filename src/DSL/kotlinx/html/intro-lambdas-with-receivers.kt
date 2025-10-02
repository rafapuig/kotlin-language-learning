package DSL.kotlinx.html

import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr

/**
 * Kotlin hace uso de los denominados
 * Type-safe builders
 *
 * Veamos un ejemplo de como generar una tabla HTML
 * con un HTML builder
 * de la biblioteca kotlinx.html
 */

/**
 * table, tr y td son funciones
 * - son funciones de extensión
 * - son funciones de orden superior (parámetro de entrada tipo función)
 *
 * Se las llama con una lambda con receptor como argumento
 * Dentro de cada lambda cambia las reglas de resolución de nombres:
 * - dentro de la lambda argumento de llamada a la función table
 * se puede llamar a la función tr (tr es función de extensión para receptores de tipo TABLE)
 * - dentro de la lambda con la que se llama a tr
 * se puede llamar a la función td
 *
 * Name resolution context
 *
 * Esta es la característica distintiva entre una API regular
 * y un DSL, que haya un contexto dentro del cual se pueden llamar a unas funciones
 * y a otras no
 * La API del DSL nos fuerza a seguir las reglas de la GRAMÁTICA
 * del lenguaje HTML
 */

fun createSimpleTable(text:String) = createHTML()
    .table {// En la lambda pasada a la función table podemos llamar a tr
        tr {// En la lambda pasada a la función tr podemos llamar a la función td
            td {// función de extensión de TR y su param TD.() -> Unit
                +text   // el operador + está sobrecargado para añadir el contenido del string a la td
            }
        }
    }

fun main() {
    println(createSimpleTable("texto de la celda"))
}