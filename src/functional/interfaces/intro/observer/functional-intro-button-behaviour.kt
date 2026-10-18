package functional.interfaces.intro.observer

abstract class View

@FunctionalInterface
interface OnClickListener {
    fun onClick(button: View)
}

/**
 * La clase Button hereda de View
 */
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

    /**
     * Crear un objeto implementador de la interface OnClickListener mediante un objeto expresión
     */
    val listener = object : OnClickListener {
        override fun onClick(button: View) {
            println("button is clicked")
        }
    }

    // Establecer el objeto OnClickListener del botón
    button.setOnClickListener(listener)

    // Llamar al metodo performClick del botón que provoca que se llame al onClick del objeto OnClickListener
    button.performClick()
}


fun demo2() {
    val button = Button()

    button.setOnClickListener(object : OnClickListener {
        override fun onClick(button: View) {
            println("He sido pulsado")
        }
    })

    button.performClick()
}


fun main() {
    demo1()
    demo2()
}