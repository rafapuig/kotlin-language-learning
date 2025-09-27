package functional.intro.buttons5

abstract class View


class Button : View() {

    private var onClick: ((View) -> Unit)? = null

    fun setOnClickListener(listener: ((View) -> Unit)?) {
        onClick = listener
    }

    fun onClick() {
        onClick?.invoke(this)
    }

}

fun demo1() {
    val button = Button()

    val listener = { v: View -> println("button is clicked") }

    button.setOnClickListener(listener)
    button.onClick()
}

fun demo2() {
    val button = Button()
    button.setOnClickListener { println("He sido pulsado") }
    button.onClick()
}

fun main() {
    demo1()
    demo2()
}