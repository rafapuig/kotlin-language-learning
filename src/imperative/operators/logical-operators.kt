package imperative.operators// Son los operadores del tipo Boolean

// AND && y and
// OR || y or
// NOT !

fun main() {
    val x = true
    val y = false

    val andResult = x && y
    val orResult = x || y
    val notResult = !x

    testShortCircuitAnd()
    shortCircuitOr()
}

fun testShortCircuitAnd() {
    val examPassed = true
    val tasksDone = false

    // Como el primer operando es verdadero
    // el resultado depende del valor del segundo operando
    // hay que evaluar el segundo operando
    val andResult = evaluate(examPassed) && evaluate(tasksDone)

    println("&& cortocircuita cuando el primero es falso...")
    // Como el primer operando es falso
    // da lo mismo cuál sea el valor del segundo operando
    // el resultado ya se sabe que será falso
    // no se evalúa el segundo operando
    val andResult2 = evaluate(tasksDone) && evaluate(examPassed)

    println("Mediante la función and... no hay cortocircuito")
    // Con la función and no hay cortocircuito
    // se evalúan ambos operandos
    val andResult3 = evaluate(tasksDone) and evaluate(examPassed)
}

fun shortCircuitOr() {
    val isHandsome = true
    val isWealthy = false

    // Como el primer operando es falso
    // el resultado depende del valor del segundo operando
    // hay que evaluar el segundo operando
    val orResult = evaluate(isWealthy) || evaluate(isHandsome)

    println("|| cortocircuita cuando el primero es verdadero...")
    // Como el primer operando es verdadero
    // da lo mismo cuál sea el valor del segundo operando
    // el resultado ya se sabe que será verdadero
    // no se evalúa el segundo operando
    val orResult2 = evaluate(isHandsome) || evaluate(isWealthy)

    println("Mediante la función or... no hay cortocircuito")
    // Con la función or no hay cortocircuito
    // se evalúan ambos operandos
    val orResult3 = evaluate(isHandsome) or evaluate(isWealthy)
}

/**
 * La función evaluate imprime por consola el valor booleano que se esta avaluando por el operador lógico
 * y lo devuelve sin más
 */
fun evaluate(expr : Boolean) : Boolean  {
    println("Evaluando operando... $expr")
    return expr
}

fun evaluateExprBody(expr : Boolean) = run {
    println("Evaluando operando... $expr")
    expr
}