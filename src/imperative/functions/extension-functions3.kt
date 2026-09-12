package imperative.functions

import java.time.LocalDate

fun LocalDate.age() = this.until(LocalDate.now()).years


fun main() {
    val birthDate = LocalDate.of(1977, 2, 18)

    val age = birthDate.age()

    println("Nacimiento: $birthDate")
    println("Edad: $age")
}
