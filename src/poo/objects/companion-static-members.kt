package poo.objects.companion

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
    MyClass.callMe() //Companion object called, no hace falta especificar el objeto companion explícitamente

    MyClass.Companion.callMe() // Si se omite el nombre del objeto companion su nombre es Companion

    val myObject = MyClass()
    //myObject.callMe() -> error
}