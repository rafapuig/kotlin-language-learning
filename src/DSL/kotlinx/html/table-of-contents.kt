package DSL.kotlinx.html

import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.stream.createHTML
import kotlinx.html.ul

fun buildBookList() = createHTML().body {
    ul {
        li { a("#1") { "Kotlin in Action" } }
        li { a("#2") { "Programming Kotlin" } }
        li { a("#3") { "Android Studio Essentials" } }
    }
    h2 { id = "1"; +"Kotlin in-action" }
    p { +"El libro que explica temas avanzados de Kotlin" }

    h2 { id = "2"; +"Programming Kotlin" }
    p { +"El libro que explica como programar en Kotlin" }

    h2 { id = "3"; +"Android Studio Essentials" }
    p { +"El libro para desarrollo en Android" }
}

fun main() {
    println(buildBookList())
}