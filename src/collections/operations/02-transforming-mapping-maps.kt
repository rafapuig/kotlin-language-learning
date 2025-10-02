package collections.operations.transforming.mapping.maps

import collections.operations.transforming.mapping.collections.testMap

/**
 * Cuando transformamos mapas tenemos 2 opciones
 *
 * 1. mapKeys - Transformar las claves (y dejar igual los valores)
 * 2. mapValues - Transformar los valores (y dejar igual las claves)
 *
 * En ambas la función de transformación recibe como parámetro
 * una entrada de mapa,
 * por tanto, contamos para la transformation con la clave y el valor
 * del elemento (entrada) del mapa a trasformar
 */

val rankToMedal = mapOf(1 to "oro", 2 to "plata", 3 to "bronce")

fun Int.rankName()  = when(this) {
    1 -> "Primero"
    2 -> "Segundo"
    3 -> "Tercero"
    else -> "Fuera de medallas"
}

fun testMapKeys() {
    val newMap = rankToMedal.mapKeys {
        it.key.rankName()
    }
    newMap.forEach { (key, value) ->
        println("$key -> $value")
    }
}

fun testMapValues() {
    val newMap = rankToMedal.mapValues {
        it.value.uppercase()
    }
    newMap.forEach { (key, value) ->
        println("$key -> $value")
    }
}

fun main() {
    testMapKeys()
    testMapValues()
}