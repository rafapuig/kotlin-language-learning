package poo.objects.nested.companion

/**
 * Para escribir una función a la que se pueda llamar sin tener una instancia,
 * pero que pueda acceder a los miembros privados de la clase
 * escribimos dicha función como una función miembro de un objeto declarado dentro de la clase
 *
 * Companion Object
 * Uno de estos objetos declarados dentro de una clase se puede marcar con la palabra clave companion
 * Con ello se puede acceder directamente a los miembros del objeto companion mediante el nombre de la clase contenedora
 * sin tener que especificar el nombre el objeto companion explícitamente.
 */

class MyClass {
    companion object {
        fun callMe() {
            println("Llamada al Companion object")
        }
    }
}

fun main() {

    // LLamada al metodo callMe del companion object
    /**
     * no hace falta especificar el objeto companion explícitamente
     * por eso, desde el punto de vista del código cliente
     * parece como si estuviéramos llamando a un metodo estático de Java: Clase.metodo
     */
    MyClass.callMe()

    /**
     * En realidad como el companion object es simplemente otro objeto anidado dentro de la clase
     * podemos usar una sintaxis más explícita, `Clase.Nombre_objeto_companion.metodo`
     * donde indicamos el nombre del objeto
     * En este caso, como se ha omitido el nombre del objeto companion su nombre es el
     * nombre por defecto, es decir, Companion
     */
    MyClass.Companion.callMe()

    /**
     * NOTA: Al contrario que en Java, en Kotlin NO se puede usar una referencia a una instancia
     * para llamar a miembros del objeto companion
     */
    val myObject = MyClass()
    //myObject.callMe() -> error
}