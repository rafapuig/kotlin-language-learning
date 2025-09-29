package collections.construction.factory

/**
 * La forma más habitual de crear colecciones es
 * a partir de las funciones factoría de la biblioteca estándar
 *
 * listOf, setOf, mutableListOf, mutableSetOf
 */

val articles = setOf("el", "la", "los", "las", "un", "una", "unos", "unas")

// Cuando se crea una colección vacía el compilador no puede inferir el tipo de los elementos
val emptySet = emptySet<String>() //Hay que indicar el tipo

val words = mutableSetOf<String>() // Crea un LinkedHashSet


val names = listOf("Rafa", "Miguel", "Rafa", "Pedro", "Luis", "Ramón", "Luis")
val emptyStringList = emptyList<String>()

val fruits = mutableListOf<String>() // Crea un ArrayList

/**
 * Para crear mapas tenemos
 * mapOf y mutableMapOf
 */

val emptyMap = emptyMap<Int, String>()

// Se crean objetos Pair mediante la función infija to
val rankMedalMap = mapOf(1 to "Oro", 2 to "Plata", 3 to "Bronce")

// Otras sintaxis más verbosas equivalentes
val rankMedalMap1 = mapOf<Int, String>(1 to "Plata", 2 to "Bronce") // Argumentos de tipo explícitos
val rankMedalMap2 = mapOf(1.to("Oro"), 2.to("Plata"), 3.to("Bronce"))
val rankMedalMap3 = mapOf(Pair(1, "Oro"), Pair(2, "Plata"), Pair(3, "Bronce"))

val countryCapitalMap = mutableMapOf("España" to "Madrid")

fun main() {
    words.add("si")
    words.add("no")
    //words.add(3) // Error, no podemos añadir elementos de otro tipo
    words.add("si") // Un valor duplicado no se añade al conjunto
    words += "bien" // El operador plusAssign añade el elemento al conjunto

    fruits.add("manzana")
    fruits.add("pera")
    fruits.add("naranja")
    //fruits.add(3) // // Error, no podemos añadir elementos de otro tipo
    fruits += "limon" // El operador plusAssign añade el elemento a la lista

    countryCapitalMap.put("Italia", "Roma")
    countryCapitalMap.set("Francia", "Paris") // función de extension operador set
    countryCapitalMap["Portugal"] = "Lisboa" // Por convención set esquivale al operador de indexación en escritura
}