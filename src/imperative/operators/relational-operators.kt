package imperative.operators// Comparan dos valores
// El resultado es de tipo Boolean

// Igualdad (por valor) --> ==
// Inigualdad --> !=

// Mayor que -->  >
// Menor que -->  <

// Mayor o igual que -->  >=
// Menor o igual que -->  <=

fun numberComparison() {
    val x = 8
    val y = 4
    val areEqual = x == y
    val areNotEqual = x != y
    val isGreater = x > y
    val isLesser = x < y
    val isEqualOrGreater = x >= y
    val isEqualOrLesser = x <= y
}

fun stringComparison() {
    // Con strings
    val text1 = "Uno"
    val text2 = "Dos"

    val areEquals = text1 == text2
    val areNotEquals = text1 != text2
    val isGreater = text1 > text2
}

fun main() {
    numberComparison()
    stringComparison()
}
