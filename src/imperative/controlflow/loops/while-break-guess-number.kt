fun main() {
    val secret = 7
    var guess: Int
    var attempts = 0

    while (true) {
        print("Guess the number (1 to 10): ")
        guess = readln().toInt()
        attempts++

        if (guess == secret) {
            println("Correct! You guessed it in $attempts attempts.")
            break  // Salir del bucle al acertar
        } else {
            println("Wrong, try again.")
        }
    }
}
