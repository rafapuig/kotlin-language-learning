package DSL.html

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString(): String =
        children.joinToString("", "<$name>", "</$name>")

}

class TD : Tag("td")

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

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
                    this.td (init = { })
                    this.td (init = { })
                }
            )
            this.tr(
                init = {
                    this.td (init = { })
                    this.td (init = { })
                }
            )
        }
    )

fun main() {
    println(createTable())
}