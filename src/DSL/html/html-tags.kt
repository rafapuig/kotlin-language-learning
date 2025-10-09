package DSL.html

/**
 * Clase base de todas las etiquetas de la gramática de HTML
 */
open class Tag(val name: String) {

    /**
     * Lista de etiquetas hijas de esta etiqueta actuando de padre
     */
    private val children = mutableListOf<Tag>()

    /**
     * El método doInit
     * invoca al objeto función de extensión para receptor de tipo T
     * usando como receptor el objeto child recibido como argumento de llamada
     * Y a continuación añade el objeto child a la lista children de hijos
     */
    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString(): String =
        children.joinToString("", "<$name>", "</$name>")

}

/**
 * Las clases TABLEScope, TRScope y TDScope son clases de utilidad interna y no
 * deberán aparecer explícitamente en el código que usa el DSL
 * para generar un código HTML
 *
 * Estas clases extienden la superclase Tag
 *
 * Cada clase define los métodos para crear las etiquetas html
 * permitidas dentro de ese elemento HTML
 * Por ejemplo,
 * TABLE define un método tr porque según la gramática de HTML
 * dentro de una etiqueta <table> se puede contener elementos tr
 * TR define un método td por la misma razón
 *
 * El parámetro init de las funciones table, tr y td
 * es un tipo función de extensión, cada una determina el tipo de receptor
 * Por ejemplo,
 * en la función td el parámetro init es de tipo TD.() -> Unit
 * por tanto, la lambda que se use como argumento tendrá como receptor un objeto TD
 */

class TDScope : Tag("td") {

    private var content = ""

    operator fun String.unaryPlus() {
        this@TDScope.content = this // this es el String receptor
    }

    override fun toString(): String {
        return "<$name>$content</$name>"
    }
}

class TRScope : Tag("tr") {
    fun td(init: TDScope.() -> Unit) = doInit(TDScope(), init)
}

class TableScope : Tag("table") {
    fun tr(init: TRScope.() -> Unit) = doInit(TRScope(), init)
}

fun table(init: TableScope.() -> Unit) = TableScope().apply(init)


/**
 * Ejemplos de uso del DSL
 */

/**
 * Al hacer que receptor de lambda quede implícito omitiendo this
 * conseguimos gracias a los builders una sintaxis sencilla
 * y similar a la del HTML original
 */
fun createSimpleTable() =
    table {
        tr {
            td { +"Hola" }
        }
    }


/**
 * Usando la sintaxis this@nombre-funcion para acceder a los
 * receptores de las lambdas de manera explícita
 * podemos violar las reglas de la gramática del DSL
 * El receptor definido en la lambda exterior
 * es accesible dentro de la lambda anidada (interior)
 * Por ejemplo,
 * En la lambda proporcionada como argumento de llamada a la
 * función builder td
 * Los tres receptores this@table, this@tr y this@td están disponibles
 */
fun createSimpleTableExplicitReceivers() =
    table {
        this@table.tr {
            this@table.tr {} // Violamos la gramática, dentro de un tr otro tr
            this@tr.td {
                +"Hola"
                this@tr.td { +"Adios" } // Violamos la gramática
            }
        }
    }


fun createTable() =
    table {
        tr {
            td { }
            td { }
        }
        tr {
            td { }
            td { }
        }
    }

fun createTableExplicit() =
    table(
        init = {
            this.tr(
                init = {
                    this.td(init = { })
                    this.td(init = { })
                }
            )
            this.tr(
                init = {
                    this.td(init = { })
                    this.td(init = { })
                }
            )
        }
    )

fun main() {
    //println(createSimpleTable())
    println(createSimpleTableExplicitReceivers())
    //println(createTable())
}