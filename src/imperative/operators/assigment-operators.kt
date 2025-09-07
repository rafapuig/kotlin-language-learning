package imperative.operators
/*
Se usan cuando
se calcula el nuevo valor de una variable
a partir de su valor anterior
y se quiere guardar el resultado en la variable
 */

fun assigmentOperators() {
    var x = 5
    x += 5 // equivalente a x = x + 5 ( x pasa a valer 10)
    println(x)

    x -= 5 // equivalente a x = x - 5 (x pasa a valer 5)
    println(x)

    x *= 3 // equivalente a x = x * 3 (x pasa a valer 15)
    println(x)

    x /= 3 // equivalente a x = x / 3 (x pasa a valer 5)
    println(x)
}

fun main() {
    assigmentOperators()
}