/**
 * En Java no pueden existir funciones (ni miembros en general) declarados fuera de una clase.
 *
 * Muchas veces en Java se crean clases (sin estado ni miembros de instancia)
 * simplemente para ser contenedoras de un conjunto de funciones todas estáticas.
 * Por ejemplo, la clase Collections del JDK
 *
 * En Kotlin no hace falta crear este tipo de clases de utilidad para contener funciones estáticas.
 * Simplemente las declaramos directamente en un archivo fuente .kt de Kotlin
 * fuera de cualquier clase.
 *
 * Estas funciones son miembros del paquete declarado al principio del archivo fuente
 * y podemos importarlas si queremos usarlas en otro archivo fuente que use otro paquete diferente.
 *
 * El mecanismo subyacente es que se utiliza el nombre del archivo fuente más el sufijo Kt como nombre
 * de la clase Java que contenedora de todas esa funciones (y propiedades) declararas en el archivo.
 *
 * Podemos cambiar ese nombre por defecto, con la anotación @file:JvmName("...") colocada antes de la declaración
 * del nombre del paquete
 */
@file:JvmName("StringUtils")

package imperative.functions.strings

// función top-level
fun joinToString(): String = ""

//propiedad top-level
var operationCount = 0 // <-- Se expone en Java con un getter y un setter

fun performOperation() {
    operationCount++
}

val NUM_POINTS = 100 // <-- se expone en Java con un getter por ser una variable declarada con val

//constante top-level
const val DOUBLE_PI = 3.14159 * 2 // <-- se expone en Java como un campo final estático