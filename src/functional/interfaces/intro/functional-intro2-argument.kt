package functional.interfaces.intro2

interface IntToInt {
    fun apply(number: Int) : Int
}

/**
 * Supongamos que queremos aplicar una operación, que se proporcionará como valor argumento,
 * sobre un dato del cual disponemos y que se lo proporcionaremos a su vez la operación
 */
fun applyIntToIntOperationToFive(operation: IntToInt) : Int {
    // Dato del cual disponemos, valor sobre el que queremos aplicar la operación
    val number = 5
    // Pasamos el dato number, a la operación recibida como argumento para obtener un resultado
    val result = operation.apply(number)
    return result
}


fun testIntToIntInterfaceWithObjectExpression() {

    /**
     * La variable triple guarda una referencia a un objeto
     * que implementa el metodo apply de la interface IntToInt
     * de manera que devuelve el valor triplicado
     * del valor proporcionado como argumento de llamada
     */
    val triple: IntToInt = object : IntToInt {
        override fun apply(number: Int): Int {
            return number * 3
        }
    }

    /**
     * La variable square, igual pero devolviendo el valor al cuadrado
     */
    val square: IntToInt = object : IntToInt {
        override fun apply(number: Int): Int {
            return number * number
        }
    }

    // Al llamar a la función applyIntToIntOperationToFive
    // le estamos proporcionando el comportamiento como argumento (lo que tiene que hacer)
    // no los datos con los que tiene que operar
    val tripleOfFive = applyIntToIntOperationToFive(triple)
    val squareOfFive = applyIntToIntOperationToFive(square)

    println("El triple de 5 = $tripleOfFive")
    println("5 al cuadrado = $squareOfFive")
}




fun main() {
    testIntToIntInterfaceWithObjectExpression()
}

