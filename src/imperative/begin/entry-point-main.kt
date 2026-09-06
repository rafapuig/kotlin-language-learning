package imperative.begin

/*
Para suprimir los warnings de JDK 24
he habilitado --enable-native-access=ALL-UNNAMED
en la template de running configurations de Kotlin
(no en Java 26)
 */

/**
 * Las funciones se pueden declarar en el nivel top
 * (no es necesario ponerlas dentro de una clase)
 * - fun palabra clave para declarar una función
 * - main es el nombre de la función punto de entrada del programa
 * definida en el nivel top
 * Se puede declarar sin parámetros de entrada adicionales
 * (el típico array con los argumentos de la línea de comandos)
 */
fun main() {
    // Kotlin hace hincapié en la brevedad y concisión
    // println, función para imprimir por la consola (wrapper de System.out.println) de la biblioteca standard de kotlin
    println("Hello World") //no hace falta ;
}