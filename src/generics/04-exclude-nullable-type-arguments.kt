package generics.exclude.nullable.type.arguments

/**
 * Un parámetro de tipo
 * sin restricciones puede usar como argumento de tipo
 * cualquier tipo, esto incluye anulables y no anulables
 *
 * No indicar una restricción de tipo explícitamente equivale
 * a la restricción de tipo
 * `T : Any?`
 *
 * (Recordemos que Any es el equivalente a Object de Java, no anulable)
 * (Any? es, por tanto, el tipo que incluye como valores posibles
 * cualquier referencia a cualquier tipo de objeto y el valor null)
 */

class Processor<T> {
    fun process(value: T) {
        // value es anulable, incluso aunque la T no tenga el ? que señala los tipos anulables
        // por eso hay que usar el operador de llamada seguro
        println(value?.hashCode())
    }
}

fun testAnulableTypeArgumentProcessor() {
    // No hay restricción para instanciar un Processor con argumento de tipo anulable String?
    val nullableStringProcessor = Processor<String?>()
    nullableStringProcessor.process("abc")
    nullableStringProcessor.process(null)
}


/**
 * Si queremos garantizar que se usará como argumento de tipo un tipo no anulable
 * lo lograremos especificando la restricción T : Any, usando Any como upper bound o cualquier otro tipo
 * no anulable si fuera necesario ser más restrictivo
 */

class NonNullProcessor<T : Any /* Especificamos un upperbound no anulable: Any */> {
    fun process(value: T) {
        // El valor del tipo T ahora ya es no anulable
        // y no es necesario el uso del operador de llamada seguro
        println(value.hashCode())
    }
}

fun testNonAnulableTypeArgumentProcessor() {
    // ERROR, no podemos usar como argumento de tipo un tipo anulable
    // String? no es un subtipo de Any
    //val nullableStringProcessor = NonNullProcessor<String?>()
}


fun main() {
    testAnulableTypeArgumentProcessor()
    testNonAnulableTypeArgumentProcessor()
}

