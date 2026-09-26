package functional.intro.buttons4

abstract class View

/**
 * Añadimos fun para convertirlo en un interface funcional
 */
fun interface OnClickListener {
    fun onClick(button: View)
}


class Button : View() {

    private var clickListener: OnClickListener? = null

    fun setOnClickListener(listener: OnClickListener) {
        clickListener = listener
    }

    fun onClick() {
        clickListener?.onClick(this)
    }

}

fun demo1() {
    val button = Button()

    val listener = OnClickListener { println("button is clicked") }

    button.setOnClickListener(listener)
    button.onClick()
}

fun demo2() {
    val button = Button()
    // Se simplifica si la lambda solamente tiene un parámetro (it)
    button.setOnClickListener { println("He sido pulsado") }
    button.onClick()
}

fun main() {
    demo1()
    demo2()
}