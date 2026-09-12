package imperative.functions

fun Int.isEven(): Boolean = this % 2 == 0

fun Int.isOdd(): Boolean = this % 2 != 0

fun Int.isPositive(): Boolean = this > 0

fun Int.isNegative(): Boolean = this < 0

fun Int.isZero(): Boolean = this == 0



fun Int.isPrime(): Boolean {
    for (i in 2..<this) {
        if (this % i == 0) return false
    }
    return true
}

fun isPrime_static(n: Int): Boolean {
    for (i in 2..<n) {
        if (n % i == 0) return false
    }
    return true
}


fun Int.double() = this * 2


fun main() {
    val x = 11
    println(isPrime_static(x))
    println(x.isPrime())
    x.isEven()
    x.isOdd()

    val y = x.double()
}