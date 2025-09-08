fun localVariables() {
    val a = '3'
    print(a)
}

fun main() {
    val language: String = "Kotlin"
    val number: Int = 48

    // Inferencia del tipo de dato mediante la expresion de inicialización
    val name = "Rafa"
    val age = 23

    val x = 3.0
    val y: Double = 12.34

    /**
     * Si no inicializamos la variable el compilador no puede inferir el tipo
     * Es necesario especificar el tipo explicitamente
     */
    val points: Int
    points = 10 // Se inicializa con la primera asignación

    /**
     * val (value) solo lectura. Solamente se puede asignar una vez
     * var (variable) se puede reasignar nuevos valores
     */

    val result = if (age > 30) "Senior" else "Junior"
    //val result = "Otro" // Error de compilacion

    var count = 0
    count = 10
    count++
    count--
    count = 4
}

