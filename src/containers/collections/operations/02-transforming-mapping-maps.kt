package containers.collections.operations.transforming.mapping.maps

/**
 * Cuando transformamos mapas tenemos 2 opciones adicionales a las de las colecciones
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

fun testMapInMap() {
    val keys = rankToMedal.map { entry -> entry.key }.toSet()
    val values = rankToMedal.map { entry -> entry.value }

    // Una lista de entradas de Mapa (Pair)
    val entryList = rankToMedal.map { entry ->
        entry.key to entry.value }

    // En la lambda podemos deconstruir el objeto Pair en sus componentes
    val entries = rankToMedal.map { (key, value) ->
        key to value
    }

    // Una lista de pares (entradas) se puede convertir con toMap en un mapa
    val entryMap = entryList.toMap()

    val newMap = rankToMedal.map { (rank, medal) ->
        medal.uppercase() to rank.rankName() }.toMap()

    newMap.forEach { entry ->
        println("${entry.key} -> ${entry.value}")
    }

}

fun testMapKeys() {
    val newMap = rankToMedal.mapKeys { entry ->
        entry.key.rankName()
    }
    newMap.forEach { (key, value) ->
        println("$key -> $value")
    }
}

fun testMapValues() {
    val newMap = rankToMedal.mapValues { entry ->
        entry.value.uppercase()
    }
    newMap.forEach { (key, value) ->
        println("$key -> $value")
    }
}

fun main() {
    testMapInMap()
    testMapKeys()
    testMapValues()
}