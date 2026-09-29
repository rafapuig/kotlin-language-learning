package conventions.operators.comparison

/**
 * En Java las clases implementan la interface Comparable
 * para que ser usada por algoritmos que comparan valores para ordenar elementos o encontrar el máximo, etc
 *
 * El metodo compareTo de la interface Comparable determina si un objeto es mayor que otro.
 *
 * Solamente los valores primitivos se pueden comparar mediante > <
 * el resto se comparan mediante
 * elem1 > elem2 -->  elem1.compareTo(elem2) > 0
 * elem1 < elem2 --> elem1.compareTo(elem2) < 0
 *
 * En Kolin el metodo compareTo se puede llamar por convención usando los operadores de comparación > < >= y <=
 *
 * a >= b --> a.compareTo(b) >= 0
 *
 */

class Person(
    val firstName: String,
    val lastName: String,
) : Comparable<Person> {

    // No es necesario repetir la palabra operator al hacer el override
    override fun compareTo(other: Person) =
        compareValuesBy(this, other, Person::lastName, Person::firstName)
}

fun stringComparisonExample() {
    println("abc" < "bac") // true
}

fun main() {
    val person1 = Person("Alberto", "Oliver")
    val person2 = Person("Marco", "Oliver")
    val person3 = Person("Rafael", "Puig")

    println(person1 < person2) // true
    println(person1 >= person3) // false
    println(person3 <= person3) // true
}