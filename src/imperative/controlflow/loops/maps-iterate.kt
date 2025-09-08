package intro.loops

val map = mapOf(1 to "I", 5 to "V", 10 to "X", 50 to "L", 100 to "C")

fun main() {
    for((number, name) in map) {
        println("$number -> $name")
    }

    for(entry in map) {
        println("${entry.key} -> ${entry.value}")
    }

    for((key, value) in map) {
        println("$key -> $value")
    }

    for (entry in map) {
        println("${entry.key} -> ${map[entry.key]}")
    }
}