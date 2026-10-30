package functional.interfaces.intro4

/**
 * Interface funcional
 * ------------------------------------------------------------------------------------------------------
 * al añadir delante de la palabra `interface` la palabra `fun` estamos declarando un interface funcional
 *
 * En una interface funcional el compilador genera una función denominada `constructor SAM`,
 * que permite convertir una expresión lambda en una instancia de un interface funcional
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

    // Como cualquier función, si el último argumento es una lambda se puede sacar fuera de los paréntesis
    val square: IntToInt = IntToInt() { number -> number * number }

    // Y si la lista de argumentos de los paréntesis queda vacía,
    // se pueden omitir los paréntesis
    val half = IntToInt { number -> number / 2 }

    // Si hacemos explícito el tipo de la variable,
    // no es necesario llamar al constructor SAM explícitamente
    val next: IntToInt = { number -> number + 1 }

    val result1 = triple.apply(5)
    val result2 = square.apply(5)
    val result3 = half.apply(10)
    val result4 = next.apply(9)

    println("result1 = $result1")
    println("result2 = $result2")
    println("result3 = $result3")
    println("result4 = $result4")


    // Variable operation, para guardar una referencia a objetos que implementan IntToInt
    var operation: IntToInt

    // la variable operation guarda la referencia al mismo objeto referenciado por la variable triple
    operation = triple

    // Llamamos al metodo apply del objeto proporcionando con un número sobre el que aplicar la operación
    val result5 = operation.apply(5) // se calcula el triple de 5
    println("result5 = $result5")

    // reasignamos la variable para que apunte al mismo objeto que la variable square
    operation = square
    val result6 = operation.apply(5) // Se calcula el cuadrado de 5
    println("result6 = $result6")

    // reasignamos la variable para que apunte al mismo objeto que la variable half
    operation = half
    val result7 = operation.apply(8) // Se calcula la mitad de 8
    println("result7 = $result7")
}


fun main() {
    testInToIntInterfaceWithSAMConstructorsAndLambda()
}

