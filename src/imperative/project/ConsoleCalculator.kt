package imperative.project

import kotlin.system.exitProcess

fun main() {
    println("Calculadora por Consola")

    // paso 1: obtención de datos de entrada
    println()
    println("Introduce dos numeros:")

    val number1 = readDoubleInput("Numero 1: ")
    val number2 = readDoubleInput("Numero 2: ")

    // paso 2: selección de la operación
    showChoices()
    val operation = getArithmeticOperation()

    // paso 3: Cálculo
    val result = performCalculation(number1, number2, operation)

    // paso 4: mostrar el resultado
    println("Resultado: $number1 $operation $number2 = $result")
}

fun performCalculation(number1: Double, number2: Double, operation: String): Double {
    return when (operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> if (number2 != 0.0) number1 / number2 else {
            println("No se permite la division por cero")
            exitProcess(3)
        }

        else -> {
            println("Error no esperado")
            exitProcess(4)
        }
    }
}

fun getArithmeticOperation(): String {
    print("Introduce una operacion aritmetica (+.-,*,/): ")
    val operation = readln()

    if (!"+-*/".contains(operation, true)) {
        println("Operacion no valida. Saliendo...")
        exitProcess(2)
    }
    return operation
}

fun showChoices() {
    println("\nOperaciones:")
    println("1. Sumar (+)")
    println("2. Restar (-)")
    println("3. Multiplicar (*)")
    println("4. Dividir (/)")

}

fun readDoubleInput(prompt: String): Double {
    print(prompt)
    val input = readln()
    try {
        return input.toDouble()
    } catch (ex: NumberFormatException) {
        println("Error leyendo la entrada: ${ex.message}")
        exitProcess(1)
    }

}