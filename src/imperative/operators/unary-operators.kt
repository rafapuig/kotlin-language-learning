package imperative.operators// Los operadores unarios solo tienen un operador

// La variable siempre se incrementa con ++
// La variable siempre se decremente con --

// Existen dos versiones: pre y post
// la versión prefija da como resultado de la expresión el valor NUEVO
// la version postfija da como resultado el valor PREVIO

fun unaryIntegers() {
    var i = 10

    println(i)

    i++ // incrementa en una unidad el valor almacenado en la variable i
    println(i)

    i-- //// decrementa en una unidad el valor almacenado en la variable i
    println(i)
}

fun unaryDecimals() {
    var i = 10.9

    println(i)

    i++ // incrementa en una unidad el valor almacenado en la variable i
    println(i)

    i-- // decrementa en una unidad el valor almacenado en la variable i
    println(i)
}

fun unaryPrePost() {
    var x = 5
    println(x++) // Post, incrementa x pero da como resultado de la expresión 5
    println(x) // El valor nuevo de x es 6

    var y = 4
    println(--y) // Pre, decrementa y a 3 y da como resultado el nuevo valor 3
    println(y)
}

fun main() {
    unaryIntegers()
    unaryDecimals()
    unaryPrePost()
}