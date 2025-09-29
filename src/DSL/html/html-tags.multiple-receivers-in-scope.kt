package DSL.html.multiple_receivers_in_scope

/**
 * @DslMarker (meta-anotación)
 * Restringe la disponibilidad de acceder a los receptores más externos en
 * las lambdas
 *
 * Las meta-anotaciones se aplican a las anotaciones
 */

@DslMarker
annotation class HtmlTagMarker

/**
 * Cualquier declaración anotada con HtmlTagMarker tendrá restricciones
 * sobre sus receptores implícitos.
 * Nunca podrás tener 2 receptores implícitos dentro del mismo ámbito
 * si sus tipos están marcados con la misma anotación @DslMarker
 */

@HtmlTagMarker
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

class IMG : Tag("img") {
    //var href: String = ""
}

class A : Tag("a") {
    var href: String = ""
    fun img(init: IMG.() -> Unit) = doInit(IMG(), init)
}

class BODY : Tag("body") {
    fun a(init: A.() -> Unit) = doInit(A(), init)
}

fun body(init: BODY.() -> Unit) = BODY().apply(init)

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

fun createBody() =
    body {
        a {
            img {
                //href = "http://imageURL" // No se puede llamar con receptor implícito
                this@a.href = "http://linkURL" // Llamada con receptor explícito
            }
        }
    }

fun main() {
    println(createTable())
}