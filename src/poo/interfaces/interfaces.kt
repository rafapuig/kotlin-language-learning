package poo.interfaces

/**
 * Los interfaces en Kotlin pueden contener
 * - definiciones (declaraciones) de métodos abstractos
 * - implementaciones de métodos no abstractos
 * - NO pueden contener ESTADO
 */
interface Clickable {

    /**
     * Propiedad numClicks
     * Es una propiedad de solo lectura abstracta, un getter sin implementación
     */
    val numClicks: Int

    /**
     * Método abstracto click
     * Las clases (no abstractas) que implementen la interface Clickable
     * necesitan proporcionar una implementación de este método
     */
    fun click()

    /**
     * Un método de una interface puede tener una implementación por defecto
     * Simplemente hay que escribir el cuerpo del método
     * Por ejemplo, este método showOff es un método con implementación por defecto
     */
    fun showOff() = println("Soy clickable!!!")
}


/**
 * Para declarar que una clase implementa una interface se
 * pone el nombre de la interface a continuación de los :
 *
 * Hay que proporcionar la implementación de los miembros (propiedades y funciones) abstractos de la interface
 *
 * Una clase puede implementar tantas interfaces como se quiera, pero solamente puede extender (heredar) una clase
 *
 * Se usa el modificador `override` para marcar los miembros que reemplazan a los definidos
 * tanto en una interfaz como en una clase base
 */
class HyperLink : Clickable {

    /**
     * Es obligatorio proporcionar una implementación para la propiedad numClicks
     * en este caso un getter
     */
    override val numClicks: Int
        get() = TODO("Not yet implemented")

    /**
     * Es obligatorio proporcionar una implementación para el método click de la interface Clickable
     */
    override fun click() {
        TODO("Not yet implemented")
    }

    /**
     * Podemos redefinir la implementación por defecto del método showOff, pero no es obligatorio
     * (prueba a comentarlo y verás que no hay error de compilación por ello)
     */
    override fun showOff() {
        super.showOff()
        println("Y soy un HyperLink")
    }
}


/**
 * Supongamos que otro interface, Focusable, también define un método showOff
 */
interface Focusable {
    fun setFocus(focused: Boolean) =
        println("He ${if (focused) "obtenido" else "perdido"} el foco.")

    fun showOff() = println("Soy focusable!!!")
}


/**
 * Que sucede si una clase necesita implementar los dos interfaces que definen un método con el mismo nombre
 * (el método showOff en este caso)
 */
class Button : Clickable, Focusable {

    var _numClicks: Int = 0

    override val numClicks: Int get() = _numClicks

    override fun click() {
        println("He sido clicado!!!")
        _numClicks++
    }

    /**
     * En este caso SI es obligatorio reemplazar el método showOff explicitamente
     * Ahora hay que proporcionar una reimplementación del método
     * Usando la palabra super cualificada mediante el nombre de la interface (entre <> )
     * permite llamar a la implementación definida en esa interface
     */
    override fun showOff() {
        // Llama a la implementación del metodo showOff de la interface Clickable
        super<Clickable>.showOff()

        // Llama a la implementación del metodo showOff de la interface Focusable
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    println(button.numClicks)
    button.click()
    println(button.numClicks)
}

