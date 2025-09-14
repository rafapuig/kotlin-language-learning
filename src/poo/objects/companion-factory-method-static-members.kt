package `object`

/**
 * Para escribir una funcion que se pueda llamar sin tener una instancia
 * pero que pueda acceder a los miembros privados de la clase
 * escribimos la funcion como un miembro de un objeto declarado dentro de la clase
 *
 * Uno de estos objetos se puede marcar con la palabra clave companion
 * Con ello se puede acceder a los miembros del objeto directamente mediante el nombre de la clase contenedora
 * sin tener que especificar el nombre el objeto explicitamente.
 */

class MyClass {
    companion object {
        fun callMe() {
            println("Companion object called")
        }
    }
}

fun main() {
    MyClass.callMe() //Companion object called, no hace falta especificar el objeto companion explicitamente

    MyClass.Companion.callMe() // Si se omite el nombre del objeto companion su nombre es Companion

    val myObject = MyClass()
    //myObject.callMe() -> error
}