package functional.intro.buttons3

abstract class View

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

    val listener = OnClickListener { button: View -> println("button is clicked") }

    button.setOnClickListener(listener)
    button.performClick()
}

fun demo2() {
    val button = Button()
    // Eliminamos los paréntesis de llamada a setOnClickListener porque quedan vacíos
    button.setOnClickListener { button: View -> println("He sido pulsado") }
    button.performClick()
}

fun main() {
    demo1()
    demo2()
}