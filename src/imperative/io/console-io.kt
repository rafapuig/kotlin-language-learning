package imperative.io

/**
 * Para obtener la entrada del usuario por consola en Kotlin
 * se usa la función readln()
 * devuelve el texto introducido o una string vacía (si el usuario simplemente pulsa INTRO)
 */
fun testReadln() {
    print("Introduce texto: ")
    val userInput = readln()
    println("Has introducido: $userInput")
}

/**
 * Los datos de entrada leídos por consola siempre se devuelven como un String
 * Para convertir a otro tipo se realiza un casting (asumiendo que sea compatible)
 * Si la conversion falla lanzará una excepción
 * Es conveniente
 * - Informar al usuario mediante el PROMPT adecuado del dato que le estamos solicitando
 * - VALIDAR la entrada del usuario *
 */

fun readInt(prompt: String = "Introduce un numero entero: "): Int {
    while (true) {
        print(prompt)
        val userInput = readln()

        try {
            val number = userInput.toInt()
            return number
        } catch (nfe: NumberFormatException) {
            println("Numero introducido no valido")
        }
    }
}

fun testReadInt() {
    val intNumber = readInt("Introduce un numero entero: ")
    println("Numero introducido: $intNumber")
}


fun main() {
    //testReadln()
    testReadInt()
}