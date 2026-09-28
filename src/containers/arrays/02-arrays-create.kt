package containers.arrays

/**
 * Para crear un array existen 3 posibilidades:
 *
 * - arrayOf (función factoría)
 *
 *      Crea un array que contiene los elementos especificados explicitamente como argumentos de la llamada
 */

val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val names = arrayOf("Rafael", "Pablo", "Emilio")

/** - arrayOfNulls (función factoría)
 *
 *      Crea un array de un tamaño indicado que contiene elementos nulos en todos los indices
 */

// En el caso de usar arrayOfNulls el argumento de tipo será de tipo anulable
val nulls = arrayOfNulls<String>(3)

/** - Array (constructor)
 *
 *      Crea un array tomando como argumentos un valor para el tamaño, y una lambda para inicializar cada elemento
 *
 *      La lambda recibe como parametro el indice del elementoy devuelve el valor que se debe colocar en esa posición
      del array
 */

val letters = Array<String>(26) { index -> ('a' + index).toString() }
val squares = Array<Int>(10) { index -> index * index }
val naturals = Array<Int>(10) { index -> index + 1 }

/**
 * Podemos crear una array al convertir una colección a array
 * - toTypedArray
 *
 * Util si una función espera un argumento de tipo varargs usándola junto con el operador de expansion (spread) *
 */

val threeLetters = listOf("A", "B", "C")

val threeLettersArray = threeLetters.toTypedArray()

// Usamos el operador de expansión * para separar los elementos del array en elementos para varargs
val text = "%s %s %s".format(*threeLettersArray)

val threeLettersNewArray = listOf(*threeLetters.toTypedArray())


/**
 * Si usamos estas formas de construir arrays cuando queremos que los elementos sean tipos primitivos
 * el array será de elementos boxed. (Integer de Java)
 */

val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) // Boxed Integer elements

/**
 * Para crear arrays que contengan los valores primitivos sin boxing (int primitivo de Java)
 *
 * Existen clases separadas, una por cada tipo primitivo (incluidos los adicionales sin signo de Kotlin)
 */

val intArr = IntArray(5) // Array de valores tipo int de Java (en este caso valor 0 inicial)
val intArr2 = IntArray(5) { it } // Valor inicial igual al valor índice

val byteArr = ByteArray(5)
val byteArr2 = ByteArray(5) { index -> index.toByte() }

val shortArr = ShortArray(5) { index -> index.toShort() }
val longArr = LongArray(5) { index -> index.toLong() }
val charArr = CharArray(5) { index -> index.toChar() }
val doubleArr = DoubleArray(5) { index -> index.toDouble() }

val boolArr = BooleanArray(5) { index -> index % 2 == 0 }

@OptIn(ExperimentalUnsignedTypes::class)
val ulongArr = ULongArray(5) { index -> index.toULong() }

/**
 * También existen funciones factoría para las versiones de arrays de tipos primitivos sin boxing
 */

val intArr3 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val byteArr3 = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

/**
 * Si ya tenemos una array (o colección) que contiene valores boxed de un tipo primitivo
 * se puede convertir en un array de elementos sin boxing con la función de conversion correspondiente
 */

val boxedIntArr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val unboxedIntArr = boxedIntArr.toIntArray()