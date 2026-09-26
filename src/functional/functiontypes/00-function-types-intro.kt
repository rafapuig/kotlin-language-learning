package functional.functiontypes

/**
 * En Kotlin existen los tipos función
 * Sus valores pueden ser:
 * - referencias a funciones o miembros
 * - funciones anónimas
 * o directamente literales de función (lambdas)
 *
 * Una clase o tipo de funciones se caracteriza por su firma y el tipo de valor devuelto
 *
 * La sintaxis para especificar un tipo de función en general es:
 *
 * (Tipo1, Tipo2, Tipo3, ...) -> TipoRetorno
 *
 * La lista de parámetros podría estar vacía si se trata de representar funciones que no reciben ningún argumento
 *
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
    // En la lambda podemos omitir que x e y son de tipo Int porque se indica en el tipo de función de la variable sum
    val sum: (Int, Int) -> Int = { x, y -> x + y }

    val action: () -> Unit = { println("Hola lambdas") }

    // En la lambda omitimos le tipo del parametro x porque se deduce del tipo de función de la variable isPositive
    val isPositive: (Int) -> Boolean = { x -> x > 0 }
}


fun main() {
    explicitLambdaParameterTypesDeclaration()
    implicitLambdaParameterTypesDeclaration()
}

