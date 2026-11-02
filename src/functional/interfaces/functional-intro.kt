package functional.interfaces

/**
 * Interface StringToInt
 * Es un interface para el cual solamente se define un metodo sin implementation por defecto
 * (Single Abstract Method - SAM)
 *
 */
interface StringToInt {

     // Este metodo SAM recibe como argumento un valor de tipo String y devuelve un valor de tipo Int
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

    /*
     * Usamos el objeto para llamar al metodo `apply`
     * declarado en la interface StringToInt
     * e implementado por el objeto referenciado por la variable textLength
     */
    val length = textLength.apply("Hola programación funcional")
    println("length = $length")
}