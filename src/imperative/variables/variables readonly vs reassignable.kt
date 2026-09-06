package imperative.variables.valvar


/**
 * Declarar una variable
 *
 * Palabras clave para declarar una variable: `val` y `var`
 *
 * Inicializar una variable = Asignar el valor inicial
 *
 * `val` para variables de solo lectura (valores)
 * Su valor no cambia después de asignar el valor inicial
 *
 * `var` para variables mutables (variables en sentido estricto)
 * Su valor puede cambiarse por otro diferente varias veces
 *
 *
 * Por defecto, debemos priorizar el uso de variables readonly
 * es decir, declarar nuestras variables con `val` y dejar `var` solamente cuando sea necesario
 */

fun valDemo() {
    val name = "Rafa" // Se declara la variable name y se inicializa al valor Rafa
    val age = 49    // Se declara la variable age y se inicializa con el valor 49

    // Se usa una template de texto que contiene el signo $ antes del nombre de una variable
    // para que sea sustituida por su valor
    println("$name tiene $age años") // Consola: Rafa tiene 48 años

    // Que pasa si queremos cambiar el valor de la variable age?
    // age = 32 //val cannot be reassigned
}

/**
 * Operación de asignación --sintaxis--> variable = valor
 * cambia el valor almacenado en la variable por el nuevo valor a la derecha del =
 *
 * En general a la derecha del signo = se puede usar una expresión (más adelante)
 */

fun varDemo() {
    var name = "Rafa" // Se declara la variable name y se inicializa al valor Rafa
    var age = 49    // Se declara la variable age y se inicializa con el valor 49

    println("$name tiene $age años") // Consola: Rafa tiene 48 años

    name = "Rafael" // se cambia el valor de la variable name por Rafael
    age = 32  // se reasigna el valor de age de 49 a 32, mutamos la variable
}

/**
 * Un variable val se inicializa una sola vez durante la ejecución del bloque de código
 * donde está definida.
 *
 * Podemos inicializarla con valores distintos basándonos en una condición.
 */

fun canFly() = true

fun valConditionalInitializationDemo() {
    val result: String
    if(canFly()) result = "Yes" else "No"
}



fun main() {
    valDemo()
    varDemo()
}
