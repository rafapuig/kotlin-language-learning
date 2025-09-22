package functional.functiontypes

/**
 * El tipo Unit se usa para especificar que una función no devuelve un valor
 * Se puede omitir en la declaración de una función regular
 * Pero en una declaración de tipo de función NO se puede omitir
 * porque siempre hay que especificar el tipo de retorno
 */
fun explicitLambdaParameterTypesDeclaration() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val action: () -> Unit = { println("Hola lambdas") }
    val isPositive: (Int) -> Boolean = { x: Int -> x > 0 }
}

/**
 * Se pueden omitir los tipos de los parámetros de entrada de la expresión lambda
 * si están especificados en el tipo de la función
 * en la declaración explicita del tipo de dato de la variable que almacena la lambda
 */
fun implicitLambdaParameterTypesDeclaration() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val action: () -> Unit = { println("Hola lambdas") }
    val isPositive: (Int) -> Boolean = { x -> x > 0 }
}

fun nullability() {

    /**
     * Anulabilidad del tipo de retorno en el tipo de función
     */
    // El tipo de datos de la variable es una función que recibe 2 Int y que puede devolver un Int? (un Int o null)
    var canReturnNull: (Int, Int) -> Int? = { x, y -> if (x == y) x else null }
    // canReturnNull = null // error, la variable no puede contener el valor null

    /**
     * Anulabilidad del propio tipo de función
     */
    // La propia variable puede almacenar una función o el valor null (pero la función no devuelve null)
    var funOrNull: ((Int, Int) -> Int)? = null
    // funOrNull = { x, y -> if (x == y) x else null } // error, no podemos asignar una función que puede devolver null

    /**
     * Anulabilidad de ambas
     */
    // Tanto la variable puede valer null cono tener asignada una función que devuelve null
    var funCanReturnNullOrNull: ((Int, Int) -> Int?)? = null
    funCanReturnNullOrNull = {x,y -> if (x > y) x else null }
}


fun main() {
    explicitLambdaParameterTypesDeclaration()
    implicitLambdaParameterTypesDeclaration()
    nullability()
}

