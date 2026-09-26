# Ejercicios: Tipos de función en Kotlin

## Objetivos

En estos ejercicios practicarás:

* Tipos de función.
* Variables cuyo tipo es una función.
* Parámetros de tipo función.
* Valores de retorno de tipo función.
* Lambdas.
* Referencias a funciones.
* Funciones con varios parámetros.
* Funciones que no reciben parámetros.
* Funciones que devuelven `Unit`.
* Tipos función con receptor.
* Diferencias entre `(T) -> R` y `T.() -> R`.
* Uso de lambdas con receptor.

> **Restricción:** no utilices colecciones. El objetivo es practicar los tipos de función.

---

# 1. Variables de tipo función

Declara una variable llamada `operation` cuyo tipo sea:

```kotlin
(Int, Int) -> Int
```

Asígnale una lambda que sume dos números.

Después utiliza la variable:

```kotlin
println(operation(10, 5))
```

Haz después otras variables para:

* restar;
* multiplicar;
* dividir.

---

# 2. Funciones sin parámetros

Crea una variable cuyo tipo sea:

```kotlin
() -> String
```

Asígnale una lambda que devuelva:

```text
Hello, Kotlin!
```

Después invoca la función de las dos formas:

```kotlin
message()
```

y:

```kotlin
message.invoke()
```

Comprueba que ambas producen el mismo resultado.

---

# 3. Funciones que devuelven Unit

Crea una variable de tipo:

```kotlin
(String) -> Unit
```

Asígnale una lambda que muestre el texto recibido por consola.

Por ejemplo:

```kotlin
printMessage("Hello")
```

### Ampliación

Crea otras variables:

```text
printUpperCase
printLength
printWithPrefix
```

---

# 4. Tipos de función como parámetros

Crea una función:

```kotlin
fun execute(
    value: Int,
    operation: (Int) -> Int
): Int
```

La función debe aplicar `operation` sobre `value`.

Prueba:

```kotlin
execute(10) { it * 2 }
execute(10) { it + 5 }
execute(10) { it * it }
```

---

# 5. Dos parámetros funcionales

Crea:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int
```

Utiliza la función para realizar diferentes operaciones.

Después modifica la llamada para utilizar funciones normales mediante referencias:

```kotlin
calculate(10, 5, ::add)
```

---

# 6. Guardar referencias a funciones

Crea estas funciones:

```kotlin
fun double(value: Int): Int
fun square(value: Int): Int
fun negate(value: Int): Int
```

Después crea variables de tipo:

```kotlin
(Int) -> Int
```

utilizando referencias a las funciones:

```kotlin
val operation = ::double
```

Comprueba que puedes llamar a la función mediante la variable.

---

# 7. Inferencia del tipo función

Escribe:

```kotlin
val operation = { a: Int, b: Int -> a + b }
```

Sin ejecutar el programa, determina cuál es el tipo inferido de `operation`.

Después escribe explícitamente el tipo:

```kotlin
val operation: (Int, Int) -> Int = ...
```

Compara ambas declaraciones.

---

# 8. Funciones como valores de retorno

Crea:

```kotlin
fun createMultiplier(factor: Int): (Int) -> Int
```

La función debe devolver otra función que multiplique por `factor`.

Ejemplo:

```kotlin
val double = createMultiplier(2)
val triple = createMultiplier(3)

println(double(10))
println(triple(10))
```

---

# 9. Crear comparadores

Crea:

```kotlin
fun createValidator(limit: Int): (Int) -> Boolean
```

Debe devolver una función que compruebe si un número es mayor que `limit`.

Ejemplo:

```kotlin
val greaterThan10 = createValidator(10)

println(greaterThan10(5))
println(greaterThan10(20))
```

Después crea:

```text
createGreaterThan
createLessThan
createEqualTo
```

---

# 10. Función que devuelve una función con varios parámetros

Crea:

```kotlin
fun createOperation(operation: String): (Double, Double) -> Double
```

Debe devolver una función que realice:

```text
add
subtract
multiply
divide
```

Ejemplo:

```kotlin
val multiply = createOperation("multiply")

println(multiply(5.0, 4.0))
```

---

# 11. Composición de funciones

Crea:

```kotlin
fun compose(
    first: (Int) -> Int,
    second: (Int) -> Int
): (Int) -> Int
```

La función debe devolver una nueva función que aplique primero `first` y después `second`.

Ejemplo:

```kotlin
val double = { value: Int -> value * 2 }
val increment = { value: Int -> value + 1 }

val operation = compose(double, increment)

println(operation(5))
```

Resultado:

```text
11
```

---

# 12. Composición genérica

Generaliza el ejercicio anterior:

```kotlin
fun <A, B, C> compose(
    first: (A) -> B,
    second: (B) -> C
): (A) -> C
```

Prueba a combinar funciones con tipos diferentes.

Por ejemplo:

```kotlin
val numberToText: (Int) -> String = {
    it.toString()
}

val addPrefix: (String) -> String = {
    "Number: $it"
}
```

Construye una función que permita:

```kotlin
println(operation(25))
```

obteniendo:

```text
Number: 25
```

---

# 13. Funciones de orden superior como propiedades

Crea una clase:

```kotlin
class Calculator(
    val operation: (Double, Double) -> Double
)
```

Permite crear calculadoras diferentes:

```kotlin
val addition = Calculator { a, b -> a + b }
val multiplication = Calculator { a, b -> a * b }
```

Utiliza la propiedad `operation` para realizar cálculos.

---

# 14. Sustituir lambdas por referencias

Crea:

```kotlin
fun add(a: Int, b: Int): Int
fun subtract(a: Int, b: Int): Int
fun multiply(a: Int, b: Int): Int
```

Después crea:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int
```

Realiza las llamadas utilizando referencias:

```kotlin
calculate(10, 5, ::add)
calculate(10, 5, ::subtract)
calculate(10, 5, ::multiply)
```

Después intenta utilizar una lambda directamente.

---

# 15. Función que recibe y devuelve funciones

Crea:

```kotlin
fun repeatTransformation(
    transformation: (Int) -> Int,
    times: Int
): (Int) -> Int
```

Debe devolver una función que aplique `transformation` `times` veces.

Por ejemplo:

```kotlin
val operation = repeatTransformation(
    { it * 2 },
    3
)

println(operation(5))
```

El resultado debe ser:

```text
40
```

Porque:

```text
5 → 10 → 20 → 40
```

---

# 16. Tipo función con receptor

Declara una variable cuyo tipo sea:

```kotlin
String.() -> Int
```

Asígnale una lambda con receptor que devuelva la longitud de la cadena:

```kotlin
val length: String.() -> Int = {
    this.length
}
```

Utilízala sobre una cadena.

Investiga las dos formas siguientes:

```kotlin
length("Kotlin")
```

y:

```kotlin
"Kotlin".length()
```

¿Son ambas posibles?

---

# 17. Comparar función normal y función con receptor

Crea estas dos variables:

```kotlin
val normal: (String) -> Int
```

y:

```kotlin
val withReceiver: String.() -> Int
```

Haz que ambas devuelvan la longitud de una cadena.

Después comprueba cómo se invoca cada una.

### Pregunta

Explica qué diferencia sintáctica existe entre:

```kotlin
normal("Kotlin")
```

y:

```kotlin
"Kotlin".withReceiver()
```

---

# 18. Función con receptor para modificar un objeto

Crea:

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}
```

Crea una función:

```kotlin
fun configure(
    person: Person,
    configuration: Person.() -> Unit
)
```

Debe ejecutar `configuration` sobre `person`.

Permite:

```kotlin
val person = Person()

configure(person) {
    name = "Alice"
    age = 25
}
```

Después muestra las propiedades del objeto.

---

# 19. Función que devuelve una lambda con receptor

Crea:

```kotlin
fun createFormatter(
    prefix: String
): String.() -> String
```

Debe devolver una función con receptor que añada `prefix` delante del texto.

Ejemplo:

```kotlin
val formatter = createFormatter("Name: ")

println(formatter("Rafael"))
```

### Ampliación

Intenta hacer que también pueda utilizarse de forma equivalente como una extensión:

```kotlin
println("Rafael".formatter())
```

Analiza qué permite y qué no permite hacer realmente el tipo función.

---

# 20. Lambda con receptor sobre una clase

Crea:

```kotlin
class Rectangle {
    var width: Double = 0.0
    var height: Double = 0.0
}
```

Crea:

```kotlin
fun configureRectangle(
    configuration: Rectangle.() -> Unit
): Rectangle
```

La función debe:

1. crear un `Rectangle`;
2. ejecutar `configuration`;
3. devolver el rectángulo.

Debe permitir:

```kotlin
val rectangle = configureRectangle {
    width = 10.0
    height = 5.0
}
```

Después calcula el área.

---

# 21. Lambda con receptor para construir un objeto

Crea:

```kotlin
class Product {
    var name: String = ""
    var price: Double = 0.0
}
```

Implementa:

```kotlin
fun buildProduct(
    configuration: Product.() -> Unit
): Product
```

Debe permitir:

```kotlin
val product = buildProduct {
    name = "Keyboard"
    price = 49.99
}
```

### Ampliación

Crea también:

```text
buildPerson
buildCar
buildBook
```

---

# 22. Función con receptor como parámetro de otra función

Crea:

```kotlin
fun useConfiguration(
    configuration: StringBuilder.() -> Unit
): String
```

Debe crear un `StringBuilder`, ejecutar `configuration` sobre él y devolver el resultado como `String`.

Debe poder utilizarse:

```kotlin
val text = useConfiguration {
    append("Hello")
    append(" ")
    append("Kotlin")
}
```

Resultado:

```text
Hello Kotlin
```

Observa cómo dentro de la lambda `append()` puede utilizarse directamente.

---

# 23. Receptor y `this`

Utiliza el ejercicio anterior.

Crea una configuración que utilice explícitamente:

```kotlin
this.append(...)
```

y otra que utilice:

```kotlin
append(...)
```

Comprueba que ambas funcionan.

### Pregunta

¿Qué representa `this` dentro de una lambda con receptor?

---

# 24. Receptor frente a parámetro

Compara:

```kotlin
val operation: (String, Int) -> String
```

con:

```kotlin
val operation: String.(Int) -> String
```

Haz que ambas realicen exactamente la misma operación.

Por ejemplo, recibir una cadena y un número y repetir conceptualmente parte de su contenido.

Después compara cómo se invocan.

### Objetivo

Comprender que:

```kotlin
(String, Int) -> String
```

y:

```kotlin
String.(Int) -> String
```

tienen una diferencia importante en la forma en la que se proporciona el objeto receptor.

---

# 25. Función con receptor y varios parámetros

Crea:

```kotlin
val calculate: Double.(Double) -> Double
```

Haz que represente una operación matemática entre el receptor y el parámetro.

Por ejemplo:

```kotlin
val sum: Double.(Double) -> Double = {
    this + it
}
```

Comprueba:

```kotlin
println(sum(10.0, 5.0))
```

Después crea:

```text
subtract
multiply
divide
```

---

# 26. Referencias a funciones de extensión

Crea una función de extensión:

```kotlin
fun String.addPrefix(prefix: String): String
```

Después crea una variable cuyo tipo sea:

```kotlin
String.(String) -> String
```

utilizando una referencia a la función:

```kotlin
val operation = String::addPrefix
```

Utiliza `operation`.

### Objetivo

Relacionar:

* funciones de extensión;
* tipos función con receptor;
* referencias a funciones.

---

# 27. Composición con receptores

Crea una función:

```kotlin
fun <T> configureAndReturn(
    value: T,
    configuration: T.() -> Unit
): T
```

Debe ejecutar la configuración sobre `value` y devolverlo.

Utilízala con:

```kotlin
Person
Rectangle
Product
```

### Ampliación

Explica por qué esta función resulta especialmente cómoda cuando se utilizan lambdas con receptor.

---

# 28. Reto: mini DSL

Crea las siguientes clases:

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}

class Address {
    var street: String = ""
    var city: String = ""
}
```

Crea una función:

```kotlin
fun person(
    configuration: Person.() -> Unit
): Person
```

Después intenta diseñar una solución que permita configurar una persona y su dirección mediante lambdas con receptor.

El objetivo es conseguir una sintaxis parecida a:

```kotlin
val person = person {
    name = "Alice"
    age = 25

    // configuración de Address
}
```

No es necesario conseguir exactamente esta sintaxis: el objetivo es experimentar con las posibilidades de las lambdas con receptor.

---

# 29. Reto de tipos

Indica el tipo de función de cada una de las siguientes expresiones:

### A

```kotlin
{ value: Int -> value * 2 }
```

### B

```kotlin
{ println("Hello") }
```

### C

```kotlin
{ a: Int, b: Int -> a + b }
```

### D

```kotlin
String.{
    length
}
```

La última expresión no tiene una sintaxis válida. Corrígela para representar una función con receptor de tipo:

```kotlin
String.() -> Int
```

---

# 30. Reto final: tipos función normales y con receptor

Diseña una función:

```kotlin
fun transform(...)
```

que permita transformar un objeto utilizando un tipo función con receptor.

Debe poder utilizarse con una clase `Person`.

Por ejemplo, se pretende conseguir algo conceptualmente parecido a:

```kotlin
val person = transform(Person()) {
    name = "Alice"
    age = 30
}
```

Después crea una segunda versión utilizando un tipo función normal:

```kotlin
(Person) -> Unit
```

Compara las dos soluciones.

### Preguntas finales

1. ¿Qué ventaja sintáctica aporta el receptor?
2. ¿Qué representa `this` dentro de la lambda?
3. ¿Cuándo puede resultar más natural utilizar un tipo función con receptor?
4. ¿Qué relación existe entre una función con receptor y una función de extensión?
5. ¿Puede una función con receptor tener parámetros adicionales?
6. ¿Puede devolver un valor?

---

# 31. Reto de análisis: identificar tipos

Determina el tipo de cada variable:

```kotlin
val a = { x: Int -> x * 2 }

val b: (Int) -> Int = { x -> x * 2 }

val c: String.() -> Int = { length }

val d: (String) -> Int = { it.length }

val e: (Int, Int) -> Int = { a, b -> a + b }
```

Para cada una indica:

* número de parámetros;
* tipos de los parámetros;
* tipo de retorno;
* si tiene receptor;
* cómo se invoca.

---

# 32. Reto final de diseño

Diseña una pequeña API que permita configurar un objeto mediante un tipo función con receptor.

Debe existir una función:

```kotlin
fun buildSomething(
    configuration: Something.() -> Unit
): Something
```

Diseña tú mismo la clase `Something` y decide qué propiedades tendrá.

El programa debe permitir una construcción mediante:

```kotlin
val something = buildSomething {
    ...
}
```

### Condiciones

* Utiliza un tipo función con receptor.
* No utilices `fun interface`.
* No utilices colecciones.
* Utiliza al menos una propiedad dentro del receptor.
* Utiliza `this` explícitamente al menos una vez.
* Crea también una versión equivalente utilizando un tipo función normal.
* Explica las diferencias entre ambas versiones.
