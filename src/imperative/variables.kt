package imperative

/**
Una variable es un contenedor de un dato en la memoria
Se le asigna un nombre: identificador
Se usa el nombre para acceder al valor del dato almacenado
*/

// El nombre de la variable (identificador) debe ser significativo:
// Debe describir el dato al que se accede
/* Ejemplos
name -> para guardar en nombre de una persona
age -> para la edad
 */

// Convenciones de nombres --> camelCase
/*
- No espacios entre palabras
- la primera palabra empieza por minúscula
- la segunda y siguientes empiezan por mayúscula

Ejemplos:
age
firstName
ageInYears
weightInKilograms
*/

// Declarar una variable
// Palabras clave para declarar una variable : val y var

// Inicializar una variable
/* Asignar el valor inicial */

// val para variables de solo lectura
/* Su valor no cambia después de asignar el valor inicial */

// var para variables mutables
/* Su valor puede cambiarse por otro diferente varias veces */

fun valDemo() {
    val name = "Rafa" // Se declara la variable name y se inicializa al valor Rafa
    val age = 48    // Se declara la variable age y se inicializa con el valor 48

    // Se usa una template de texto con el signo $ antes del nombre de una variable
    // para que sea sustituida por su valor
    println("$name tiene $age años") // Consola: Rafa tiene 48 años

    // Que pasa si queremos cambiar el valor de la variable age?
    // age = 32 //val cannot be reassigned
}

// Operación de asignación --sintaxis--> variable = valor
// cambia el valor almacenado en la variable por el nuevo valor a la derecha del =
/*
En general a la derecha del signo = se puede usar una expresión (más adelante)
*/

fun varDemo() {
    var name = "Rafa" // Se declara la variable imperative.types.name y se inicializa al valor Rafa
    var age = 48    // Se declara la variable imperative.types.age y se inicializa con el valor 48

    // Se usa una template de texto con el signo $ antes del nombre de una variable
    // para que sea sustituida por su valor
    println("$name tiene $age años") // Consola: Rafa tiene 48 años

    name = "Rafael" // se cambiar el valor de la variable name por Rafael
    age = 32  // se reasigna el valor de age de 48 a 32, mutamos la variable
}



fun main() {
    valDemo()
    varDemo()
}
