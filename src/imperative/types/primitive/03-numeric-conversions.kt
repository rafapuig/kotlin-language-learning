package imperative.types.primitive.conversion

/**
 * Kotlin No convierte automáticamente valores numéricos de un tipo a otro tipo (al contrario de Java)
 *
 * Ni siquiera cuando el tipo al que se convierte es más grande y podría almacenar el valor sin problema alguno.
 */

val i = 1
//val l: Long = i, // ERROR, Kotlin no permite conversión automática implícita de tipos numéricos

// Tenemos que hacer la conversion de manera explicita mediante un metodo toXXX(), toLong() en este caso.
val lo = i.toLong()

/**
 * Kotlin define una función toXXX() para cada tipo primitivo excepto para el tipo Boolean
 */

/**
 * Kotlin obliga a la conversión explícita para evitar sorpresas
 * Por ejemplo, con la comparación de valores cuando han sido envueltos (boxing)
 * El metodo equals cuando se usa para comparar dos valores boxed también comprueba el tipo del envoltorio (box)
 * no solo en valor almacenado en él.
 */

val result = java.lang.Integer.valueOf(42).equals(java.lang.Long.valueOf(42)) // devuelve falso

/**
 * Si Kotlin permitiera conversiones implícitas permitiría escribir algo así:
 */
val x = 1 // Un Int
val list = listOf(1L, 2L, 3L, 4L, 5L) // Lista de Long (como es una lista son envoltorios de Long)
//val containsX = x in list // ERROR, y si compilara en ejecución daría false!!!!!

val l = 1L // Un Long
val containsL = l in list
val containsX = x.toLong() in list // Se requiere conversion explícita para asegurar que se comparan mismos tipos

/**
 * Excepción:
 * Cuando usamos un valor literal, normalmente no es necesario llamar a la función de conversión
 * - para inicializar una variable
 * - pasarlo como argumento de llamada a una función
 */

val aLong = 1 // No es necesario llamar a toLong()

fun consumeLongValue(value: Long) = println(value)

fun main() {
    // Si pasamos un literal del tipo Long como argumento no hay problema
    consumeLongValue(5L)
    // Tampoco hay problema si pasamos un literal de tipo Int, en este caso es una excepción a la conversion explicita
    consumeLongValue(10)

    val i: Int = 15 // Pero si declaramos una variable de tipo Int
    // Si llamamos a la función y usamos como argumento la variable (y no un literal),
    // entonces sí que da error de compilación
    //consumeLongValue(i)

    // A no ser que hagamos la conversión explícitamente
    consumeLongValue(i.toLong())
}