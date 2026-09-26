# Ejercicios: Funciones de orden superior

## Objetivos

En estos ejercicios practicarás:

* Funciones que reciben funciones como parámetros.
* Funciones que devuelven funciones.
* Lambdas como argumentos.
* Referencias a funciones (`::nombreFuncion`).
* Funciones de orden superior con varios parámetros funcionales.
* Composición de funciones.
* Lambdas con receptor.

> **Restricción:** no utilices colecciones (`List`, `Set`, `Map`, etc.) en estos ejercicios. El objetivo es practicar las funciones de orden superior.

---

## 1. Aplicar una operación

Crea una función:

```kotlin
fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int
```

La función debe recibir dos números y una función que indique qué operación realizar.

Por ejemplo:

```kotlin
applyOperation(10, 5) { a, b -> a + b }
applyOperation(10, 5) { a, b -> a - b }
applyOperation(10, 5) { a, b -> a * b }
```

### Ampliación

Crea funciones independientes:

```kotlin
fun add(a: Int, b: Int): Int
fun subtract(a: Int, b: Int): Int
fun multiply(a: Int, b: Int): Int
```

Utiliza referencias a estas funciones:

```kotlin
applyOperation(10, 5, ::add)
```

---

## 2. Ejecutar una acción varias veces

Crea una función:

```kotlin
fun repeatAction(times: Int, action: () -> Unit)
```

La función debe ejecutar `action` tantas veces como indique `times`.

Por ejemplo:

```kotlin
repeatAction(5) {
    println("Hello")
}
```

Debe producir:

```text
Hello
Hello
Hello
Hello
Hello
```

### Ampliación

Haz que el número de repetición se pueda utilizar dentro de la lambda:

```kotlin
repeatAction(5) { number ->
    println("Iteration: $number")
}
```

Para ello tendrás que modificar la firma de la función.

---

## 3. Transformar un valor

Crea una función:

```kotlin
fun transform(value: Int, transformation: (Int) -> Int): Int
```

Debe devolver el resultado de aplicar `transformation` sobre `value`.

Ejemplos:

```kotlin
transform(5) { it * 2 }
transform(5) { it * it }
transform(10) { it + 100 }
```

### Ampliación

Crea funciones normales:

```kotlin
fun double(value: Int): Int
fun square(value: Int): Int
fun increment(value: Int): Int
```

Y utilízalas mediante referencias a funciones.

---

## 4. Validar un valor

Crea una función:

```kotlin
fun validate(value: Int, condition: (Int) -> Boolean): Boolean
```

Debe devolver el resultado de aplicar `condition` sobre `value`.

Prueba diferentes condiciones:

* El número es positivo.
* El número es par.
* El número es mayor que 100.
* El número está entre 10 y 20.

Ejemplo:

```kotlin
val result = validate(15) { it > 10 }
println(result)
```

---

## 5. Ejecutar si se cumple una condición

Crea una función:

```kotlin
fun executeIf(condition: Boolean, action: () -> Unit)
```

La función debe ejecutar `action` únicamente cuando `condition` sea `true`.

Ejemplo:

```kotlin
executeIf(10 > 5) {
    println("The condition is true")
}
```

### Ampliación

Modifica la función para que reciba la condición también como función:

```kotlin
fun executeIf(
    condition: () -> Boolean,
    action: () -> Unit
)
```

Ahora debería poder utilizarse así:

```kotlin
executeIf(
    { 10 > 5 },
    { println("The condition is true") }
)
```

Investiga también cómo escribir la llamada utilizando la sintaxis de lambda final.

---

## 6. Calculadora configurable

Crea una función:

```kotlin
fun calculator(
    a: Double,
    b: Double,
    operation: (Double, Double) -> Double
): Double
```

Debe permitir realizar diferentes operaciones.

Por ejemplo:

```kotlin
calculator(10.0, 5.0) { a, b -> a + b }
calculator(10.0, 5.0) { a, b -> a / b }
calculator(10.0, 5.0) { a, b -> a.pow(b) }
```

### Ampliación

Crea las operaciones como funciones independientes y pásalas mediante referencias.

---

# Funciones que devuelven funciones

A partir de este ejercicio comienza a trabajar con funciones que **devuelven otra función**.

---

## 7. Crear multiplicadores

Crea una función:

```kotlin
fun createMultiplier(factor: Int): (Int) -> Int
```

La función debe devolver una función que multiplique un número por `factor`.

Ejemplo:

```kotlin
val double = createMultiplier(2)
val triple = createMultiplier(3)

println(double(10))
println(triple(10))
```

Resultado:

```text
20
30
```

### Objetivo

Comprender que:

```kotlin
createMultiplier(2)
```

no devuelve un `Int`, sino una función.

---

## 8. Crear comparadores

Crea una función:

```kotlin
fun createGreaterThan(limit: Int): (Int) -> Boolean
```

Debe devolver una función que compruebe si un número es mayor que `limit`.

Ejemplo:

```kotlin
val greaterThan10 = createGreaterThan(10)

println(greaterThan10(5))
println(greaterThan10(20))
```

Resultado:

```text
false
true
```

### Ampliación

Crea también:

```kotlin
createLessThan(limit)
createEqualTo(value)
```

---

## 9. Generador de saludos

Crea una función:

```kotlin
fun createGreeter(greeting: String): (String) -> String
```

Debe devolver una función que reciba un nombre y genere un saludo.

Ejemplo:

```kotlin
val hello = createGreeter("Hello")

println(hello("Rafael"))
println(hello("Ana"))
```

Resultado:

```text
Hello Rafael
Hello Ana
```

Prueba a crear también:

```kotlin
val welcome = createGreeter("Welcome")
val goodbye = createGreeter("Goodbye")
```

---

## 10. Generador de descuentos

Crea una función:

```kotlin
fun createDiscount(discount: Double): (Double) -> Double
```

Debe devolver una función que aplique el descuento indicado a un precio.

Ejemplo:

```kotlin
val studentDiscount = createDiscount(0.20)

println(studentDiscount(100.0))
```

Resultado:

```text
80.0
```

### Ampliación

Crea diferentes funciones:

```kotlin
val studentDiscount = createDiscount(0.20)
val vipDiscount = createDiscount(0.30)
val employeeDiscount = createDiscount(0.40)
```

---

# Combinar funciones

## 11. Componer dos funciones

Crea una función:

```kotlin
fun compose(
    first: (Int) -> Int,
    second: (Int) -> Int
): (Int) -> Int
```

La función debe devolver una nueva función que aplique primero `first` y después `second`.

Por ejemplo:

```kotlin
val double = { value: Int -> value * 2 }
val increment = { value: Int -> value + 1 }

val operation = compose(double, increment)

println(operation(5))
```

El resultado debe ser:

```text
11
```

Es decir:

```text
5 → double → 10 → increment → 11
```

### Ampliación

Prueba:

```kotlin
compose(increment, double)
```

y observa que el resultado es diferente.

---

## 12. Componer funciones de distintos tipos

Crea una función genérica:

```kotlin
fun <A, B, C> compose(
    first: (A) -> B,
    second: (B) -> C
): (A) -> C
```

Debe permitir combinar funciones cuyos tipos de entrada y salida sean diferentes.

Por ejemplo:

```kotlin
val numberToText: (Int) -> String = { it.toString() }

val addPrefix: (String) -> String = {
    "Number: $it"
}

val operation = compose(numberToText, addPrefix)

println(operation(25))
```

Resultado:

```text
Number: 25
```

---

## 13. Crear una tubería de operaciones

Crea una función:

```kotlin
fun pipeline(
    value: Int,
    first: (Int) -> Int,
    second: (Int) -> Int,
    third: (Int) -> Int
): Int
```

Debe aplicar las tres funciones consecutivamente.

Por ejemplo:

```kotlin
val result = pipeline(
    5,
    { it * 2 },
    { it + 10 },
    { it / 3 }
)
```

Calcula manualmente el resultado antes de ejecutar el programa.

### Ampliación

Modifica el ejercicio para que la función `pipeline` devuelva una función en lugar del resultado directamente.

---

# Funciones de orden superior más completas

## 14. Procesar un número

Crea una función:

```kotlin
fun processNumber(
    value: Int,
    transformation: (Int) -> Int,
    condition: (Int) -> Boolean,
    action: (Int) -> Unit
)
```

El comportamiento será:

1. Transformar `value`.
2. Comprobar la condición sobre el resultado.
3. Si se cumple, ejecutar `action`.

Ejemplo:

```kotlin
processNumber(
    10,
    { it * 3 },
    { it > 20 },
    { println("Result: $it") }
)
```

---

## 15. Sistema de operaciones configurable

Crea una función:

```kotlin
fun createOperation(
    operation: String
): (Double, Double) -> Double
```

Debe devolver una función diferente dependiendo de `operation`.

Debe soportar:

* `"add"`
* `"subtract"`
* `"multiply"`
* `"divide"`

Ejemplo:

```kotlin
val operation = createOperation("multiply")

println(operation(5.0, 4.0))
```

Resultado:

```text
20.0
```

### Restricción

No utilices colecciones.

---

## 16. Generador de validadores

Crea una función:

```kotlin
fun createValidator(
    min: Int,
    max: Int
): (Int) -> Boolean
```

Debe devolver una función que compruebe si un número está dentro del intervalo `[min, max]`.

Ejemplo:

```kotlin
val validateAge = createValidator(18, 65)

println(validateAge(20))
println(validateAge(70))
```

### Ampliación

Crea también:

```kotlin
createStringValidator(...)
```

para validar la longitud de una cadena.

---

# Lambdas con receptor

## 17. Configurar un objeto

Crea una clase:

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}
```

Crea una función:

```kotlin
fun configurePerson(
    configuration: Person.() -> Unit
): Person
```

La función debe:

1. Crear un `Person`.
2. Ejecutar `configuration` sobre él.
3. Devolver el objeto configurado.

Debe poder utilizarse así:

```kotlin
val person = configurePerson {
    name = "Alice"
    age = 25
}

println(person.name)
println(person.age)
```

Observa que dentro de la lambda puedes acceder directamente a las propiedades del objeto.

---

## 18. Constructor de objetos configurable

Crea una clase:

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

Crea `buildPerson`, `buildCar` y `buildBook` utilizando el mismo patrón.

---

## 19. Ejecutar código sobre un objeto

Crea una función genérica:

```kotlin
fun <T> withObject(
    value: T,
    action: T.() -> Unit
): T
```

Debe ejecutar `action` utilizando `value` como receptor y devolver después el mismo objeto.

Ejemplo:

```kotlin
val person = Person()

withObject(person) {
    name = "John"
    age = 30
}
```

Después del bloque, `person` debe estar configurado.

---

# Reto final

## 20. Sistema de reglas

Diseña un pequeño sistema de reglas utilizando exclusivamente funciones de orden superior.

Crea una función:

```kotlin
fun createRule(
    condition: (Int) -> Boolean,
    action: (Int) -> String
): (Int) -> String
```

La función debe devolver una nueva función que:

1. Reciba un número.
2. Compruebe `condition`.
3. Si se cumple, ejecute `action`.
4. Si no se cumple, devuelva otro mensaje.

Ejemplo conceptual:

```kotlin
val positiveRule = createRule(
    { it > 0 },
    { "$it is positive" }
)

println(positiveRule(10))
println(positiveRule(-5))
```

### Reto adicional

Crea varias reglas y una función que permita combinarlas:

```kotlin
val evenRule = ...
val positiveRule = ...
val greaterThan100Rule = ...
```

La idea es practicar la composición de funciones de orden superior, sin utilizar colecciones.
