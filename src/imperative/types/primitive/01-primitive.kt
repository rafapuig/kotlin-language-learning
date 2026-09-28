package imperative.types.primitive

/**
 * Kotlin no diferencia entre tipos primitivos y tipos envoltorio (wrappers)
 *
 * Java distingue entre
 * - tipos primitivos
 * - tipos por referencia
 *
 * Una variable de un tipo primitivo almacena directamente el valor. (por ejemplo, int)
 * Una variable de un tipo por referencia guarda una referencia a la posición en la memoria que contiene el valor
 * (llamada en este caso objeto)
 *
 * Los valores de tipos primitivos
 * - se almacenan y se pasan de manera eficiente
 * - pero, no se puede llamar a metodos de instancia con estos valores
 * - y NO se pueden usar en colecciones <-----
 *
 * Java proporciona uns tipos especiales llamados envoltorios (wrappers), por ejemplo java.lang.Integer,
 * que envuelven / encapsulan el valor de tipo primitivo dentro de un objeto para usarlo cuando se necesita
 * trabajar con un objeto.
 *
 * No se puede crear una Collection<int> , se tiene que usar Collection<Integer> en su lugar.
 *
 */

/**
 * Kotlin NO distingue entre tipo primitivo y envoltorio.
 * Siempre se usa el mismo tipo
 * Por ejemplo, para enteros es Int
 */
val i: Int = 1
val list: List<Int> = listOf(1, 2, 3, 4, 5)

/**
 * Se puede llamar a metodos usando como objeto receptor valores de tipo numérico (como si fueran objetos)
 */

val n: Int = 1000
val percentage = n.coerceIn(0, 100)
val text = 123.toString()

/**
 * Esto no significa que Kotlin use objetos siempre para representar los valores numéricos
 * Los valores numéricos son representados de la forma más eficiente posible, pero eso es tarea
 * automática del compilador de Kotlin.
 * Por ejemplo, el tipo Int de Kotlin se compila al tipo primitivo de Java int
 * salvo que no sea posible porque se use como argumento de un tipo genérico, como en las colecciones.
 * En ese caso se usa el tipo envolvente Integer.
 */

/**
 * Los ocho tipos primitivos de Java (y sus envoltorios) se corresponden con los siguientes tipos de Kotlin
 *
 * Integrales: Byte, Short, Int y Long (byte, short, int, y long primitivos de Java, Byte, Short, Integer, Long envoltorios)
 * Punto flotante: Float y Double (float y double primitivos de Java y Float y Double envoltorios)
 * Carácter: Char (char primitivo y Character envoltorio)
 * Booleano: Boolean (boolean primitivo y Boolean envoltorio)
 */

/**
 * Tipos numéricos SIN signo
 *
 * Kotlin amplia los tipos primitivos de la JVM con tipos para enteros sin signo
 *
 * UByte (8 bits) 0-255
 * UShort (16 bits) 0-65535
 * UInt (32 bits) 0-2^32-1
 * ULong (64 bits) 0-2^64-1
 *
 * Estos tipos primitivos, igualmente, solamente son envueltos como objeto cuando es necesario.
 * (Internamente, se implementan mediante clases inline)
 *
 * Para declarar literales de tipo sin signo se usa el sufijo U (o u minúscula)
 *
 */

val aUByte: UByte = 255U
val aUShort: UShort = 65_535U
val aUInt: UInt = 4_000_000U
val aULong: ULong = 18_000_000_000_000__000_000U