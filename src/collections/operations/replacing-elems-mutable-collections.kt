package collections

import collections.model.people

fun testReplaceAll() {
    val mutable =
        people
            .toMutableList()
            .replaceAll { it.copy(name = it.name.uppercase()) }
    println(mutable)
}

fun main() {
    testReplaceAll()
}