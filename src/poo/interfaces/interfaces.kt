package poo.interfaces

/**
 * Los interfaces en Kotlin pueden contener
 * definiciones (declaraciones) de métodos abstractos
 * implementaciones de métodos no abstractos
 */
interface Clickable {

    val numClicks: Int

    fun click()
    fun showOff() = println("Soy clickable!!!")
}

interface Focusable {
    fun setFocus(focused: Boolean) =
        println("He ${if(focused) "obtenido" else "perdido"} el foco.")

    fun showOff() = println("Soy focusable!!!")
}

class Button() : Clickable, Focusable {

    var _numClicks: Int = 0

    override val numClicks: Int get() = _numClicks

    override fun click() {
        println("He sido clicado!!!")
        _numClicks++
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    println( button.numClicks)
    button.click()
    println(button.numClicks)
}

