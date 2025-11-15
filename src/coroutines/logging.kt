package coroutines

private var zeroTime = System.currentTimeMillis()

/**
 * Imprime una marca temporal y el hilo en el que
 * se ha llamada a la función
 */
fun log(message: Any?) =
    println("${System.currentTimeMillis() - zeroTime}" +
            "[${Thread.currentThread().name}] $message")