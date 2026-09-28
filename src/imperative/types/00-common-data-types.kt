package imperative.types

/**
 * Todo valor pertenece o se asocia con un tipo de dato
 */

// Varios tipos de información que puede ser almacenada por una variable
/*
- Número
- Texto
- Valor lógico (verdadero, falso) --> true - false
 */


// Toda variable está asociada con un tipo de dato
// Solamente puede almacenar valores de ese tipo (o convertidos)
// No puede almacenar valores de otro tipo distinto al establecido

/** Tipos comunes en Kotlin */

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
Un tipo de dato se caracteriza según 3 características:
- Conjunto de valores posibles
- Operaciones (que se pueden realizar con los valores del conjunto)
- Representación interna en memoria de los valores
 */

/*
Los tipos de datos abstractos ADT
permiten su uso sin necesidad de conocer su representación interna
Incluso esta puede cambiar sin afectar al código programa
 */

// Para especificar explícitamente el tipo de dato de la variable
// Se coloca el signo : después del identificador y antes del nombre del tipo de datos

var initial : Char = 'R' // Valores literales Char entre ''
var name : String = "Rafa" // Valores literales String entre ""
var age : Int = 48 // Valor literal entero 48 en base decimal
var radius : Float = 2.48f // Sufijo f para valores literales de tipo Float
var distance : Double = 103.59 // El punto indica valores con decimales Double
var isAlive : Boolean = true // true es valor literal de tipo Boolean que indica Verdadero
var isDead : Boolean = false // false es valor literal de tipo Boolean que indica Falso
var aLong : Long = 1_000_000_000_000_000_000L // Sufijo L para valores Long
var aByte: Byte = 127 // Rango entre [-128, 127]



// INFERENCIA DE TIPO
// Al declarar una variable NO es obligatorio especificar el tipo (si el compilador lo puede inferir)

var aFloat = 3.1415F // Si no ponemos el sufijo F se infiere tipo Double
var anInt = 18
var otherLong = 18L



