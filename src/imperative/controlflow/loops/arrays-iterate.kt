package imperative.controlflow.loops

fun main() {
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    for (number in numbers) {
        println(number)
    }

    for (indexedValue in numbers.withIndex()) {
        println("Indice: ${indexedValue.index} = ${indexedValue.value}")
    }

    // Desestructurar
    for ((index, number) in numbers.withIndex()) {
        println("Indice: $index = $number")
    }

}