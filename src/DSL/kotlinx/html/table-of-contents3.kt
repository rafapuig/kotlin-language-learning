package DSL.kotlinx.html.better.even

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

data class Book(val title: String, val description: String)

val books = listOf(
    Book(
        title = "Kotlin in Action",
        description = "El libro que explica temas avanzados de Kotlin"
    ),
    Book(
        title = "Kotlin in Action",
        description = "El libro que explica como programar en Kotlin"
    ),
    Book(
        title = "Android Studio Essentials",
        description = "El libro para desarrollo en Android"
    )
)


@HtmlTagMarker
class LISTWITHTOC {
    val entries = mutableListOf<Pair<String, String>>()

    fun item(headline: String, content: String) {
        entries += headline to content
    }
}

fun BODY.listWithToc(block: LISTWITHTOC.() -> Unit) {
    with(LISTWITHTOC()) {
        this.block()
        ul {
            for ((index, entry) in entries.withIndex()) {
                li { a("$index") { +entry.first } }
            }
        }
        for ((index, entry) in entries.withIndex()) {
            h2 { id = "$index"; +entry.second }
            p { +entry.second }
        }
    }
}


fun buildBooksToc(books: List<Book>) = createHTML().body {
    listWithToc {
        for (book in books) {
            item(
                headline = book.title,
                content = book.description
            )
        }
    }
}

fun main() {
    println(buildBooksToc(books))
}

