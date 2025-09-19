package functional.functiontypes

fun explicitLambdaParameterTypesDeclaration() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val action: () -> Unit = { println("Hola lambdas") }
    val isPositive: (Int) -> Boolean = { x: Int -> x > 0 }
}

/**
 * Se pueden omitir los tipos de los parámetros de entrada de la expresión lambda
 * si están especificados en el tipo de la función
 * el la declaración explicita del tipo de dato de la variable
 */
fun implicitLambdaParameterTypesDeclaration() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val action: () -> Unit = { println("Hola lambdas") }
    val isPositive: (Int) -> Boolean = { x -> x > 0 }
}

fun xxxx() {
    // El tipo de datos de la variable es una función que recibe 2 Int y que puede devolver un Int? (un Int o null)
    var canReturnNull: (Int, Int) -> Int? = { x, y -> if (x == y) x else null }
    // canReturnNull = null // error, la variable no puede contener el valor null

    // La propia variable puede almacenar una función o el valor null (pero la función no devuelve null)
    var funOrNull: ((Int, Int) -> Int)? = null
    // funOrNull = { x, y -> if (x == y) x else null } // error, no podemos asignar una función que puede devolver null

    // Tanto la variable puede valer null cono tener asignada una función que devuelve null
    var funCanReturnNullOrNull: ((Int, Int) -> Int?)? = null
    funCanReturnNullOrNull = {x,y -> if (x > y) x else null }
}


fun main() {
    explicitLambdaParameterTypesDeclaration()

}

