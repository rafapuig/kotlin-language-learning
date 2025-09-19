package functional.intro.buttons2

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

    val listener = OnClickListener { button: View -> println("button is clicked") }

    button.setOnClickListener(listener)
    button.onClick()
}

fun demo2() {
    val button = Button()
    button.setOnClickListener (){ button: View -> println("He sido pulsado") }
    button.onClick()
}

fun main() {
    demo1()
    demo2()
}