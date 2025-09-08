fun main() {
    var number = 0

    while (number < 10) {
        number++

        if (number % 2 == 0) {
            continue  // Salta los números pares
        }

        println("Odd number: $number")
    }
}
