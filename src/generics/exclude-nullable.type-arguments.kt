package generics.exclude.nullable.type.arguments

/**
 * Un parámetro de tipo
 * sin restricciones puede usar como argumento de tipo
 * cualquier tipo, esto incluye anulables y no anulables
 *
 * No indicar una restricción de tipo explícitamente equivale
 * a T : Any?
 *
 * (Recordemos que Any es el equivalente a Object de Java)
 * (Any? es el tipo que incluye como valores posibles
 * cualquier referencia a objeto y el valor null)
 */

class Processor<T> {
    fun process(value: T) {
        println(value?.hashCode())
    }
}

class NonNullProcessor<T : Any> {
    fun process(value: T) {
        println(value.hashCode())
    }
}

fun main() {
    val nullableStringProcessor = Processor<String?>()
    nullableStringProcessor.process("abc")
    nullableStringProcessor.process(null)

    //val nonNullProcessor = NonNullProcessor<String?>() //ERROR
}

