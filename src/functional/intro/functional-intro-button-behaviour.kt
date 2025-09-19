package functional.intro.buttons

abstract class View

@FunctionalInterface
interface OnClickListener {
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

    val listener = object : OnClickListener {
        override fun onClick(button: View) {
            println("button is clicked")
        }
    }

    button.setOnClickListener(listener)
    button.onClick()
}

fun demo2() {
    val button = Button()
    button.setOnClickListener(object : OnClickListener {
        override fun onClick(button: View) {
            println("He sido pulsado")
        }
    })
    button.onClick()
}

fun main() {
    demo1()
    demo2()
}