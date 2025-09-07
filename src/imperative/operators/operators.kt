package imperative.operators//OPERADORES

// Realizan operaciones matemáticas, lógicas o de texto

// Cada tipo de dato define un conjunto de operaciones

// OPERACIONES ARITMÉTICAS
// Suma, resta, multiplicación y división
// Existe una version distinta por cada tipo de dato numérico

/*
- No es la misma operación la suma de dos Int que de dos Long
- Cuando los operandos del operador sean de tipo diferente
    - primero se convierte un valor al tipo del otro
    - ya del mismo tipo se opera
 */

fun arithmeticOperators() {
    val a = 11
    val b = 4
    val sum = a + b // suma enteros
    val difference = a - b // resta de enteros
    val product = a * b // multiplicación entera
    val quotient = a / b // division entera, resultado 2

    println("Suma: $sum")
    println("Resta: $difference")
    println("Producto: $product")
    println("Cociente $quotient")
}

fun arithmeticOperationsDecimals() {
    val a = 11.0
    val b = 4.0

    val sum = a + b // suma de doubles
    val difference = a - b // resta de doubles
    val product = a * b // multiplicación entre doubles
    val quotient = a / b // division real con decimales

    println("Suma: $sum")
    println("Resta: $difference")
    println("Producto: $product")
    println("Cociente $quotient")
}

fun operationWithTypeConversion() {
    val anInt = 8
    val aDouble = 8.0
    val divider = 3
    val longNumber = 1L

    val quotientInt = anInt / divider
    val quotientDouble = aDouble / divider

    // Se convierte el valor de la variable imperative.types.anInt al tipo Long
    val sum = anInt + longNumber
}

// Operación resto (remainder) --> %
/* Obtiene el resto de dividir el dividendo y el divisor */

fun remainderOperationInteger() {
    val a = 8
    val b = 3
    val quotient = a / b
    val remainder = a % b

    println("Cociente $quotient")
    println("Resto: $remainder")
}

fun remainderOperationDecimal() {
    val a = 8.0
    val b = 3.5
    val quotient = a / b
    val remainder = a % b

    println("Cociente $quotient")
    println("Resto: $remainder")
}

// PRECEDENCIA DE OPERADORES (uso de paréntesis)
/*
Division y multiplicación
Suma y resta
 */

fun main() {
    arithmeticOperators()
    arithmeticOperationsDecimals()
    remainderOperationInteger()
    remainderOperationDecimal()
}