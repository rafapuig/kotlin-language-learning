package imperative.types
// Un valor pertenece a un tipo de dato

// Varios tipos de información almacenable por una variable
/*
- Número
- Texto
- Valor lógico (verdadero, falso) --> true - false
 */


// Toda variable está asociada con un tipo de dato
// Solamente puede almacenar valores de ese tipo (o convertidos)
// No puede almacenar valores de otro tipo distinto al establecido

// Tipos comunes en Kotlin

/*
Numérico:
    Entero: Byte, Short, Int, Long
    Decimales: Float, Double
Texto:
    Char, String
 Lógico:
    Boolean
 */

// Caracterización de un tipo
/*
Un tipo de dato se caracteriza según 3 ...
- Conjunto de valores
- Operaciones (que se pueden realizar con valores del conjunto)
- Representación interna en memoria
 */

/*
Los tipos de datos abstractos
permiten su uso sin necesidad de conocer su representación interna
Incluso esta puede cambiar sin afectar al código programa
 */

// Para especificar explícitamente el tipo de dato de la variable
// Se coloca el signo : después del identificador y antes del nombre del tipo de datos

var initial : Char = 'R' // Valores literales Char entre ''
var name : String = "Rafa" // Valores literales String entre ""
var age : Int = 48
var radius : Float = 2.48f // Sufijo f para valores de tipo Float
var distance : Double = 103.59
var isAlive : Boolean = true
var aLong : Long = 1_000_000_000_000_000_000L // Sufijo L para valores Long
var aByte: Byte = 127 // (-128, 127)



// INFERENCIA DE TIPO
// Al declarar una variable NO es obligatorio especificar el tipo

var aFloat = 3.1415F // Si no ponemos el sufijo F se infiere tipo Double
var anInt = 18
var otherLong = 18L



