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

    shortCircuitAnd()
    shortCircuitOr()
}

fun shortCircuitAnd() {
    val x = true
    val y = false

    // Como el primer operando es verdadero
    // el resultado depende del valor del segundo operando
    // hay que evaluar el segundo operando
    val andResult = evaluate(x) && evaluate(y)

    println("&& cortocircuita cuando el primero es falso...")
    // Como el primer operando es falso
    // da lo mismo cuál sea el valor del segundo operando
    // el resultado ya se sabe que será falso
    // no se evalúa el segundo operando
    val andResult2 = evaluate(y) && evaluate(x)

    println("Mediante la función and... no hay cortocircuito")
    // Con la función and no hay cortocircuito
    // se evalúan ambos operandos
    val andResult3 = evaluate(y) and evaluate(x)
}

fun shortCircuitOr() {
    val x = true
    val y = false

    // Como el primer operando es falso
    // el resultado depende del valor del segundo operando
    // hay que evaluar el segundo operando
    val orResult = evaluate(y) || evaluate(x)

    println("|| cortocircuita cuando el primero es verdadero...")
    // Como el primer operando es verdadero
    // da lo mismo cuál sea el valor del segundo operando
    // el resultado ya se sabe que será verdadero
    // no se evalúa el segundo operando
    val orResult2 = evaluate(x) || evaluate(y)

    println("Mediante la función or... no hay cortocircuito")
    // Con la función or no hay cortocircuito
    // se evalúan ambos operandos
    val orResult3 = evaluate(x) or evaluate(y)
}

fun evaluate(expr : Boolean) : Boolean {
    println("Evaluando operando... $expr")
    return expr
}