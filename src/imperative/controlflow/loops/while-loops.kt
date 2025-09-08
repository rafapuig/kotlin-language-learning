package intro.loops

fun main() {

}

fun testWhile() {
    val condition: Boolean = true
    val shouldExit: Boolean = false
    while(condition) {
        if (shouldExit) break
    }
}

fun testWhile2() {
    var counter = 0
    while (counter < 10) {
        counter++
        println("Iteracion numero $counter")
    }
}

fun testWhile3() {
    var counter = 0
    while (counter < 10) {
        counter++
        if(counter == 4) break
        println("Iteración numero $counter")
    }
}

fun testDoWhile() {
    val condition: Boolean = true
    val shouldSkip: Boolean = true
    do {
        if (shouldSkip) continue
    } while (condition)
}

/**
 * Una etiqueta es un identificador seguido del signo @
 */
fun testWhileWithLabels() {
    val outerCondition = true
    val innerCondition = true
    val shouldSkipOuter: Boolean = true
    val shouldSkipInner: Boolean = true
    val shouldExitOuter: Boolean = true
    val shouldExitInner: Boolean = true
    outer@ while (outerCondition) {
        while (innerCondition) {
            if(shouldExitInner) break
            if (shouldSkipInner) continue
            if (shouldExitOuter) break@outer
            if (shouldSkipOuter) continue@outer
            //...
        }
        //...
    }
}