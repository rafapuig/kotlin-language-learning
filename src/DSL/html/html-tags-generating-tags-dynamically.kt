package DSL.html.dynamic

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString(): String =
        children.joinToString("", "<$name>", "</$name>")
}

class TD : Tag("td") {

    private var content = ""

    operator fun String.unaryPlus() {
        this@TD.content = this // this es el String receptor
    }

    override fun toString(): String {
        return "<$name>$content</$name>"
    }
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)


/**
 * Ejemplos de uso del DSL
 */

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

fun createTableDynamicTags() =
    table {
        for (i in 1..2) {
            tr {
                td { +"$i" }
                td { +"Contenido de la celda $i" }
            }
        }
    }

fun main() {
    //println(createTable())
    println(createTableDynamicTags())
}