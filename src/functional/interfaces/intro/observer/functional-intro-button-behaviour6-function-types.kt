package functional.interfaces.intro.observer6.functiontypes

abstract class View


class Button : View() {

    /**
     * Ahora en lugar de usar un interface funcional
     * usamos directamente tipos función
     */
    private var onClick: ((View) -> Unit)? = null

    fun setOnClickListener(listener: ((View) -> Unit)?) {
        onClick = listener
    }

    fun performClick() {
        onClick?.invoke(this)
    }

}

fun demo1() {
    val button = Button()

    val listener = { v: View -> println("button is clicked") }

    button.setOnClickListener(listener)
    button.performClick()
}

fun demo2() {
    val button = Button()
    button.setOnClickListener { println("He sido pulsado") }
    button.performClick()
}


fun demo3() {
    with(Button()) {
        setOnClickListener { println("Button clicked") }
        performClick()
    }
}

fun main() {
    demo1()
    demo2()
    demo3()
}