package imperative.types

/**
 * El tipo Unit
 *
 * Cumple la misma función que el tipo void de Java
 *
 * Se usa como tipo de retorno de una función cuando la función no tiene nada que devolver.
 */

fun myFunction(): Unit {/*...*/
}

/**
 * Podemos omitir la declaración del tipo de retorno en lugar de usar Unit explícitamente,
 * en funciones con cuerpo de bloque.
 */

fun myImplicitUnitFunction() { /* ... */
}

/**
 * Cual es la diferencia entre void de Java y Unit de Kotlin?
 *
 * Unit es un tipo completo, con todas las funcionalidades, al contrario que void:
 *
 * - Unit se puede usar como tipo para un parámetro de función.
 * - Existe un solo valor del tipo Unit llamado Unit
 * (y es el que se devuelve implícitamente en una función que no devuelve nada mediante return)
 *
 */

fun myFunctionReturningUnit(): Unit {
    // Esta línea es redundante, y la añade automáticamente el compilador
    return Unit
}

/**
 * El tipo Unit puede ser util en casos en que un tipo genérico
 * define una función que devuelve un valor del tipo del parámetro de tipo
 */

interface Processor<T> {
    // Función que devuelve un valor del tipo T, parámetro de tipo del interface genérico Processor<T>
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    override fun process(): Unit { // Devuelve Unit, Unit es el valor del argumento de tipo
        println("NoResultProcessor.process()")
        // return Unit // No es necesario una instrucción return explícita, se añade por el compilador
    }
}

/**
 * Porque se eligió el nombre Unit y no Void para el tipo en Kotlin
 *
 * - Unit se usa en lenguajes funcionales con significado "Solamente una unica instancia"
 *
 * En Java no existe ningún valor de tipo void, pero en Kotlin si existe un valor, solo uno, de tipo Unit
 *
 * En Kotlin existe otro tipo, Nothing, que tiene otro papel en el lenguaje, que se puede confundir con Void
 * porque sus significados son cercanos.
 */