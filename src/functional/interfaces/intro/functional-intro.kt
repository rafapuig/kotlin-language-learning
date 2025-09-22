package functional.interfaces.intro

/**
 * Interface StringToInt
 * Es un interface para el solamente se define un metodo sin implementation por defecto (Single Abstract Method - SAM)
 */
interface StringToInt {
    fun apply(string: String) : Int
}

fun main() {
    /**
     * Mediante una expresión objeto podemos crear un objeto que implemente la interface StringToInt
     */
    val textLength = object : StringToInt {
        override fun apply(string: String): Int {
            return string.length // En este caso se devuelve la longitud del texto
        }
    }

    /**
     * usamos el objeto para llamar al metodo declarado en la interface e implementado por el objeto
     */
    val length = textLength.apply("Hola programación funcional")
    println("length = $length")
}