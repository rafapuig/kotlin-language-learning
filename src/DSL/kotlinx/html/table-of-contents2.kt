package DSL.kotlinx.html.better

import DSL.html.multiple_receivers_in_scope.HtmlTagMarker
import kotlinx.html.BODY
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.stream.createHTML
import kotlinx.html.ul

/**
 * Pero podemos hacerlo mejor que en ejemplo anterior
 * aprovechando que ul y h2 son simplemente funciones a las que llamar
 */
@HtmlTagMarker
class LISTWITHTOC {
    val entries = mutableListOf<Pair<String,String>>()

    fun item(headline: String, content: String) {
        entries += headline to content
    }
}

/**
 * Esta función listWithToc
 * codifica la lógica para crear la tabla de contenidos
 */
fun BODY.listWithToc(block:LISTWITHTOC.()->Unit) {
    with(LISTWITHTOC()) {
        this.block()
        ul {
            for ((index, entry) in entries.withIndex()) {
                li { a("$index") { +entry.first } }
            }
        }
        for ((index, entry) in entries.withIndex()) {
            h2 { id="$index" ; +entry.second }
            p { +entry.second }
        }
    }
}

fun buildBookList() = createHTML().body {
    listWithToc {
        item(
            headline = "Kotlin in Action",
            content = "El libro que explica temas avanzados de Kotlin"
        )
        item(
            headline = "Kotlin in Action",
            content = "El libro que explica como programar en Kotlin"
        )
        item(
            headline = "Android Studio Essentials",
            content = "El libro para desarrollo en Android"
        )
    }
}

fun main() {
    println(buildBookList())
}