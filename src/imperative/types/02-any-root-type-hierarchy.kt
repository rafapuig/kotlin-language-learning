package imperative.types

/**
 * El tipo Object es el objeto raíz de la jerarquía de clases en Java
 * (Todo tipo por referencia hereda en último término de la clase Object, quedando excluidos los tipos primitivos)
 *
 * En Kotlin el tipo Any es el supertipo raíz de todos los tipos no anulables, incluidos los tipos primitivos como Int.
 *
 * Boxing
 *
 * En Java, asignar un valor de tipo primitivo a una variable de tipo Object conlleva una operación de BOXING.
 *
 * En Kotlin, sucede también un boxing automático si se asigna un valor de tipo primitivo a una variable de tipo Any.
 */

val boxed : Any = 50 // El valor es boxed porque Any es un tipo por referencia

/**
 * Any es un tipo no anulable,
 * no puede guardar el valor null
 *
 * Si necesitáramos que la variable pudiera guardar el valor null tenemos que usar la version anulable del tipo
 * Any?
 */

// val any : Any = null, // ERROR

val nullableAny : Any? = null // OK

/**
 * Cuando una función de Kotlin usa Any, se compila al tipo Object en el bytecode de Java.
 */

/**
 * Todas las clases de Kotlin tienen estos 3 métodos heredados de la clase Any:
 * - toString
 * - equals
 * - hasCode
 */