package functional.intro4

/**
 * Interface funcional,
 * al añadir delante de la palabra interface la palabra fun estamos declarando un interface funcional
 *
 * El compilador genera una función denominada SAM constructor que permite convertir una expresión lambda
 * en una instancia de un interface funcional
 * El nombre del constructor SAM es el mismo que el de interface funcional
 */
fun interface IntToInt {
    fun apply(number: Int): Int
    //fun otherOperation(number: Int): Int // Error, un interface funcional solamente puede declarar un metodo abstracto
}

fun applyIntToIntOperationToNumber(number: Int, operation: IntToInt) = operation.apply(number)

fun Int.applyIntToIntOperation(operation: IntToInt) = operation.apply(this)



fun testInToIntInterfaceWithSAMConstructorsAndLambda() {

    // Llamada al constructor SAM para crear un objeto que implementa la interface funcional IntToInt
    // Se le pasa una expresión lambda que será la implementación del metodo abstracto único SAM
    val triple: IntToInt = IntToInt({ number -> number * 3 })

    // Como cualquier función, si el argumento es una lambda se puede sacar fuera de los paréntesis
    val square: IntToInt = IntToInt() { number -> number * number }

    // Y si la lista de argumentos de los paréntesis queda vacía, se pueden omitir los paréntesis
    val half = IntToInt { number -> number / 2 }

    val result1 = triple.apply(5)
    val result2 = square.apply(5)
    val result3 = half.apply(10)

    println("result1 = $result1")
    println("result2 = $result2")
    println("result3 = $result3")


    // Variable para guardar referencia a objetos que implementan IntToInt
    var operation: IntToInt

    // la variable operation guarda la referencia al mismo objeto referenciado por la variable triple
    operation = triple
    // Llamamos al metodo apply del objeto proporcionando un número sobre el que aplicar la operación
    val result4 = operation.apply(5)
    println("result4 = $result4")

    // reasignamos la variable para que apunte al mismo objeto que la variable square
    operation = square
    val result5 = operation.apply(5)
    println("result4 = $result4")

    operation = half
    val result6 = 8.applyIntToIntOperation(operation)
    println("result6 = $result6")
}


fun testIntToIntInterfacePassingArguments() {

    // Cuando llamamos a una función que espera una referencia a un objeto implementador
    // de la interface funcional NO es necesario usar explícitamente el constructor SAM

    val num: Int = 9

    val result1 = 4.applyIntToIntOperation(IntToInt({ it * 10 }))
    println("result1 = $result1")

    val result2 = 8.applyIntToIntOperation({ number -> number * 2 })
    println("result2 = $result2")

    val result3 = num.applyIntToIntOperation { number -> number * number }
    println("result3 = $result3")

    val result4 = num.applyIntToIntOperation({ it - 1 })
    println("result4 = $result4")

    val result5 = num.applyIntToIntOperation { it * 2 }
    println("result5 = $result5")

}


fun main() {
    testInToIntInterfaceWithSAMConstructorsAndLambda()
}

