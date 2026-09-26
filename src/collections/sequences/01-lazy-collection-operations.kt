package collections.sequences

import collections.model.people
import java.io.File

/**
 * Cuando encadenamos llamadas a funciones de colección como map o filter
 * se crean objetos colección intermedios (de forma impaciente - eagerly)
 * El resultado intermedio de cada paso se guarda en una colección temporal
 *
 * Las secuencias (Streams en Java)
 * Son la alternativa para evitar la creación de objetos colección temporales intermedios
 * Las secuencias tienen la misma API de funciones que las colecciones
 */

fun example() {
    val result = people // Lista origen
        .map { it.name } // Lista intermedia del paso de mapeo
        .filter { it.startsWith("A") } // Lista final
}

fun withSequence() {
    val result =
        people.asSequence() // Convierte la lista en una secuencia
            .map { it.name }
            .filter { it.startsWith("A") }
            .toList() // Convierte la secuencia resultante de nuevo en lista
}

/**
 * Las operaciones sobre una secuencia se dividen en dos categorías:
 * - intermedias (devuelven otra secuencia, son perezosas - lazy)
 * - terminales (devuelven un resultado, provocan que se ejecuten las intermedias)
 */

/**
 * En las secuencias las operaciones se aplican a cada elemento secuencialmente
 * Si se aplica una operación map y después una operación filter
 * Se procesa el primer elemento, se mapea y se filtra
 * Después el segundo elemento, se mapea y se filtra
 * Y asi sucesivamente
 */

/**
 * Crear secuencias
 * - asSequence en un Iterable
 * - generateSequence
 */

/**
 * generateSequence
 *
 * Calcula el siguiente elemento de una secuencia dado el elemento previo
 */

fun testGenerateSequence1() {
    /**
     * Secuencia de números infinita
     */
    val naturalNumbers = generateSequence(0) { it + 1 }
    /**
     * El foreach no termina nunca
     */
    naturalNumbers.forEach { println(it) }
}

fun testGenerateSequence2() {
    /**
     * Secuencia de números infinita
     */
    val naturalNumbers = generateSequence(0) { it + 1 }

    /**
     * El foreach no termina nunca
     */
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    val sum = numbersTo100.sum() // Operación terminal sum
    println(sum)
}


fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }
        .any { it.isHidden }

fun testGenerateSequence3() {
    val filename = "/Users/Perico/.HiddenDir/cosas/mis_cosas.txt"
    println(File(filename).isInsideHiddenDirectory())
}

fun main() {
    //testGenerateSequence1()
    testGenerateSequence2()
    testGenerateSequence3()
}