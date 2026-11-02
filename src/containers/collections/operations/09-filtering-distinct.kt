package containers.collections.operations.filtering.partition

import containers.collections.model.people


/**
 * partition
 *
 * Divide los elementos en dos grupos según cumplan o no la condición
 */


fun testDistinct() {
    val fruits = listOf("banana", "limón", "pera", "manzana", "kiwi", "limón", "pera")

    val distincts = fruits.distinct()

    println(distincts)
}

fun testDistinctBy() {
    val distinctByGender = people.distinctBy { it.gender }
    //val distinctByGender = people.distinctBy(Person::gender)
    println(distinctByGender)
}

fun main() {
    testDistinct()
    testDistinctBy()
}
