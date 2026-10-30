package functional.intro.buttons1

abstract class View

/**
 * Añadimos fun para convertirlo en un interface funcional de Kotlin
 */
fun interface OnClickListener {
    fun onClick(button: View)
}


class Button : View() {

    private var clickListener: OnClickListener? = null

    fun setOnClickListener(listener: OnClickListener) {
        clickListener = listener
    }

    fun performClick() {
        clickListener?.onClick(this)
    }

}

fun demo1() {
    val button = Button()

    // Ahora para crear el objeto OnClickListener podemos usar el constructor SAM
    val listener = OnClickListener { button: View -> println("button is clicked") }

    button.setOnClickListener(listener)
    button.performClick()
}

fun demo2() {
    val button = Button()

    // Si se trata de un argumento no es necesario explicitar la llamada al constructor SAM
    button.setOnClickListener ({ button: View -> println("He sido pulsado") })

    button.performClick()
}


fun main() {
    demo1()
    demo2()
}