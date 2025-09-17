package poo.interfaces

/**
 * Una interface puede declarar un companion object
 * En el companion object declaramos todos los miembros que en Java
 * declararíamos como miembros estáticos de la interface
 */
interface Choices {

    companion object {
        const val YES = "Yes"
        const val NO = "No"
    }

}

fun main() {
    Choices.YES
    Choices.NO
}