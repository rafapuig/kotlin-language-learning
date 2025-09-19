package functional.intro

interface StringToInt {
    fun apply(string: String) : Int
}

fun main() {
    val textLength = object : StringToInt {
        override fun apply(string: String): Int {
            return string.length
        }
    }

    val length = textLength.apply("Hola programación funcional")
    println("length = $length")
}