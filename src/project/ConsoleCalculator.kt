package project

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


}

fun getArithmeticOperation() : String {
    TODO("Not yet implemented")
}

fun showChoices() {

}

fun readDoubleInput(prompt: String) : Double {
    print(prompt)
    val input = readln()
    try {
        return input.toDouble()
    } catch (ex: NumberFormatException) {
        println("Error leyendo la entrada: ${ex.message}")
        exitProcess(1)
    }

}