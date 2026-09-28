package imperative.types.primitive


//CONVERSION DE TIPOS (CASTING)
// Convertir un valor de un tipo en otro valor "equivalente" de otro tipo


// Conversión implícita (inicialización mediante literales)
var intNumber = 18
var longNumber : Long = 45 // 45 es un valor Int convertido implícitamente a 45L Long
//var convertedToLong : Long = intNumber // No es posible

// Conversion explícita
/*
Mediante funciones toXXX() donde XXX es el nombre del tipo al cual convertir el valor
 */

var doubleNumber : Double = 33.toDouble()
var explicitLongNumber : Long = 45.toLong()
var convertedToLongExplicit : Long = intNumber.toLong() // Así si es posible

/*
No todas las conversiones van a poder realizarse correctamente en tiempo de ejecución
 */
var message : String = "Hola Kotlin!"
val intValue : Int = message.toInt() // Lanzará una excepción NumberFormatException