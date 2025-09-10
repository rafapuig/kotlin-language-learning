package imperative.controlflow.whens

import kotlin.random.Random

fun getRandomNumber(from: Int = -1, to: Int = 1): Int = Random.nextInt(from, to - 1)

/**
 * La expresión when sin un argumento
 * Cada rama es una expresión de tipo Boolean
 */
fun testWhenExpression() {
    val number = getRandomNumber()
    println("El numero es $number")

    when {
        number > 0 -> println("el numero es positivo")
        number == 0 -> println("el numero es cero")
        number < 0 -> println("el numero es negativo") // Si llega hasta aqui es porque no es > ni = entonces es <
        else -> println("error")
    }
}

/**
 * La expresión when con argumento
 * Se compara con posibles valores que pueda tener el argumento
 */
fun testWhenExpression2() {
    val number = getRandomNumber()
    println("El numero es $number")

    when (number) {
        -1 -> println("el numero es negativo")
        0 -> println("el numero es cero")
        1 -> println("el numero es positivo")
        else -> println("error")
    }
}

/**
 * También podemos utilizar rangos para seleccionar una rama del when
 */

fun testWhenExpression3() {
    val number = getRandomNumber()
    println("El numero es $number")

    when (number) {
        in Int.MIN_VALUE..-1 -> println("el numero es negativo") // Cambiar extremo del rango por <0
        in 1..Int.MAX_VALUE -> println("el numero es positivo")
        0 -> println("el numero es cero")
        else -> println("error")
    }
}

fun testWhenExpression4() {
    val hour = getRandomNumber(0, 23)
    println("Son las $hour horas")
    when (hour) {
        in 0..11 -> println("Buenos dias")
        in 12..20 -> println("Buenas tardes")
        in 21..23 -> println("Buenas noches")
    }
}


fun main() {
    testWhenExpression()
    testWhenExpression2()
    testWhenExpression3()
    testWhenExpression4()
}