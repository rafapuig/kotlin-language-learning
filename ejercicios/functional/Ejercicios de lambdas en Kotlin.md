# Ejercicios — Lambdas en Kotlin

## Objetivos

En estos ejercicios profundizarás en el uso de las expresiones lambda en Kotlin.

Trabajarás:

* Sintaxis de las lambdas.
* Parámetros de las lambdas.
* Inferencia de tipos.
* El parámetro implícito `it`.
* Lambdas con varias instrucciones.
* Valor de retorno de una lambda.
* Lambdas como argumentos de funciones.
* Trailing lambdas.
* Lambdas almacenadas en variables.
* Lambdas pasadas directamente como argumentos.
* Lambdas con receptor.
* Funciones que reciben lambdas con receptor.
* Construcción de pequeños DSL mediante lambdas con receptor.

> **Restricción:** no utilizar listas, colecciones, `map`, `filter`, `forEach` ni otras operaciones sobre colecciones.

---

# 1. Sintaxis básica de las lambdas

## Ejercicio 1 — Una lambda sencilla

Crea una lambda que reciba un número entero y devuelva su doble.

Guárdala en una variable llamada `double`.

Utilízala para calcular el doble de `7`.

---

## Ejercicio 2 — Lambda con dos parámetros

Crea una lambda llamada `add` que reciba dos números enteros y devuelva su suma.

Utilízala para calcular:

```text
15 + 27
```

---

## Ejercicio 3 — Diferentes operaciones

Crea cuatro lambdas:

* `add`
* `subtract`
* `multiply`
* `divide`

Todas deben recibir dos valores `Double` y devolver un `Double`.

Utilízalas para realizar varias operaciones.

---

# 2. Tipado e inferencia

## Ejercicio 4 — Tipo explícito

Crea una lambda para calcular el cuadrado de un número.

Declara explícitamente el tipo de la variable:

```kotlin
(Int) -> Int
```

---

## Ejercicio 5 — Inferencia del tipo de la variable

Repite el ejercicio anterior, pero esta vez deja que Kotlin infiera el tipo de la variable.

---

## Ejercicio 6 — Tipo explícito de los parámetros

Crea una lambda que reciba dos números y calcule su media.

Especifica explícitamente el tipo de los parámetros de la lambda.

---

## Ejercicio 7 — Inferencia de los parámetros

Modifica la lambda anterior para que Kotlin pueda inferir los tipos de sus parámetros a partir del contexto.

---

# 3. El parámetro `it`

## Ejercicio 8 — Sustituir el nombre del parámetro

Crea una lambda que reciba un `Int` y devuelva su doble.

Escribe primero la lambda utilizando un nombre explícito para el parámetro:

```kotlin
{ number -> ... }
```

Después escribe la misma lambda utilizando `it`.

Comprueba que ambas producen el mismo resultado.

---

## Ejercicio 9 — Comparaciones

Crea una lambda que reciba un número entero y devuelva `true` si el número es positivo.

Escribe dos versiones:

1. Utilizando un nombre explícito para el parámetro.
2. Utilizando `it`.

---

## Ejercicio 10 — Conversión

Crea una lambda que reciba un nombre y devuelva:

```text
Hola, <nombre>
```

Escribe una versión utilizando un parámetro con nombre y otra utilizando `it`.

---

# 4. Lambdas con varias instrucciones

## Ejercicio 11 — Calcular el precio final

Crea una lambda que reciba:

* un precio,
* un porcentaje de descuento.

Debe calcular el precio final después de aplicar el descuento.

La lambda debe contener varias instrucciones.

Por ejemplo, para:

```text
precio = 100
descuento = 20
```

el resultado debe ser:

```text
80
```

---

## Ejercicio 12 — Calcular una edad

Crea una lambda que reciba el año de nacimiento y el año actual.

Debe devolver la edad calculada.

Utiliza una variable local dentro de la lambda antes de devolver el resultado.

---

## Ejercicio 13 — Comprobar un número

Crea una lambda que reciba un número entero.

Debe:

1. Calcular su valor absoluto.
2. Comprobar si es par.
3. Devolver un `Boolean`.

Utiliza varias instrucciones dentro de la lambda.

---

# 5. El valor de retorno de una lambda

## Ejercicio 14 — Última expresión

Crea una lambda que reciba un número y realice las siguientes operaciones:

1. Multiplicarlo por `2`.
2. Sumárselo a `10`.
3. Devolver el resultado.

No utilices `return` explícito.

---

## Ejercicio 15 — Devolver el resultado de una condición

Crea una lambda que reciba un número y devuelva `true` si está entre `10` y `20`, ambos incluidos.

No utilices un `return` explícito.

---

## Ejercicio 16 — Varias instrucciones

Crea una lambda que reciba un precio y un porcentaje de IVA.

Debe:

1. Calcular el importe del IVA.
2. Calcular el precio final.
3. Devolver el precio final.

---

# 6. Lambdas como argumentos

## Ejercicio 17 — Aplicar una operación

Utiliza la siguiente función:

```kotlin
fun applyOperation(
    number: Int,
    operation: (Int) -> Int
): Int
```

Utilízala pasando directamente diferentes lambdas para:

* Doblar el número.
* Triplicar el número.
* Elevarlo al cuadrado.
* Sumar `10`.
* Restar `5`.

No almacenes las lambdas en variables.

---

## Ejercicio 18 — Comprobar una condición

Utiliza:

```kotlin
fun check(
    number: Int,
    condition: (Int) -> Boolean
): Boolean
```

Pasa directamente diferentes lambdas para comprobar:

* Si el número es positivo.
* Si es negativo.
* Si es par.
* Si es mayor que `100`.
* Si está entre `10` y `20`.

---

## Ejercicio 19 — Transformar un valor

Crea:

```kotlin
fun transform(
    value: Double,
    transformation: (Double) -> Double
): Double
```

Utilízala pasando directamente lambdas para:

* Convertir euros a dólares utilizando un tipo de cambio determinado.
* Aplicar un descuento.
* Aplicar un IVA.
* Redondear el valor a dos decimales.

---

# 7. Trailing lambda

## Ejercicio 20 — Último argumento

Dada:

```kotlin
fun applyOperation(
    number: Int,
    operation: (Int) -> Int
): Int
```

Realiza las siguientes llamadas utilizando trailing lambda:

```kotlin
applyOperation(10) {
    ...
}
```

Crea llamadas para:

* Doblar `10`.
* Elevar `10` al cuadrado.
* Restar `3` a `10`.

---

## Ejercicio 21 — Comparar sintaxis

Utiliza la función:

```kotlin
fun transform(
    number: Int,
    operation: (Int) -> Int
): Int
```

Escribe la misma llamada utilizando las tres formas siguientes.

### Forma 1

Lambda dentro de los paréntesis.

### Forma 2

Trailing lambda.

### Forma 3

Lambda almacenada previamente en una variable.

Comprueba que las tres producen el mismo resultado.

---

## Ejercicio 22 — Varios parámetros y trailing lambda

Crea una función:

```kotlin
fun calculate(
    a: Double,
    b: Double,
    operation: (Double, Double) -> Double
): Double
```

Realiza diferentes llamadas utilizando trailing lambda.

Por ejemplo:

```text
suma
resta
multiplicación
división
media
```

---

# 8. Lambdas con varios parámetros

## Ejercicio 23 — Nombre completo

Crea una lambda que reciba:

```text
nombre
apellido
```

y devuelva el nombre completo.

Utilízala para construir diferentes nombres completos.

---

## Ejercicio 24 — Mayor de dos números

Crea una lambda que reciba dos `Int` y devuelva el mayor de ellos.

Prueba diferentes parejas de números.

---

## Ejercicio 25 — Mayor de tres números

Crea una lambda que reciba tres números enteros y devuelva el mayor.

Intenta resolverlo sin utilizar funciones auxiliares.

---

# 9. Lambdas que reciben y devuelven otras funciones

## Ejercicio 26 — Crear una operación

Crea una función:

```kotlin
fun createOperation(
    multiplier: Int
): (Int) -> Int
```

La función debe devolver una lambda que multiplique su argumento por `multiplier`.

Por ejemplo:

```kotlin
val double = createOperation(2)
val triple = createOperation(3)
```

Después utiliza `double` y `triple`.

---

## Ejercicio 27 — Crear una función de incremento

Crea:

```kotlin
fun createAdder(
    amount: Int
): (Int) -> Int
```

Debe devolver una lambda que sume `amount` al número recibido.

Por ejemplo:

```kotlin
val addTen = createAdder(10)
```

debe permitir realizar:

```text
5 → 15
20 → 30
100 → 110
```

---

## Ejercicio 28 — Crear comparadores

Crea:

```kotlin
fun createChecker(
    limit: Int
): (Int) -> Boolean
```

Debe devolver una lambda que compruebe si un número es mayor que `limit`.

Crea diferentes comprobadores:

```text
mayor que 10
mayor que 50
mayor que 100
```

---

# 10. Lambdas con receptor

## Ejercicio 29 — Primera lambda con receptor

Crea una función:

```kotlin
fun calculate(operation: Int.() -> Int): Int
```

Utilízala para crear una lambda con receptor que duplique el valor.

Por ejemplo, el resultado debe ser equivalente a:

```text
5 → 10
```

---

## Ejercicio 30 — Operaciones sobre un `Int`

Crea una función:

```kotlin
fun process(number: Int, operation: Int.() -> Int): Int
```

Utilízala con lambdas con receptor para:

* Duplicar el número.
* Elevarlo al cuadrado.
* Sumárselo a `10`.
* Multiplicarlo por `5`.

Observa cómo puedes utilizar `this` dentro de la lambda.

---

## Ejercicio 31 — `this` frente a `it`

Utiliza:

```kotlin
fun process(
    number: Int,
    operation: (Int) -> Int
): Int
```

y:

```kotlin
fun process(
    number: Int,
    operation: Int.() -> Int
): Int
```

Realiza una operación equivalente con ambas versiones.

Analiza qué representa:

```kotlin
it
```

en la primera versión y qué representa:

```kotlin
this
```

en la segunda.

---

# 11. Lambdas con receptor sobre `String`

## Ejercicio 32 — Transformar un texto

Crea:

```kotlin
fun processText(
    text: String,
    operation: String.() -> String
): String
```

Utiliza esta función para:

* Convertir el texto a mayúsculas.
* Convertirlo a minúsculas.
* Añadir un texto al principio.
* Añadir un texto al final.

---

## Ejercicio 33 — Analizar un texto

Utiliza una lambda con receptor `String.() -> Boolean`.

Crea diferentes operaciones para comprobar:

* Si el texto está vacío.
* Si tiene más de 10 caracteres.
* Si comienza por `"Kotlin"`.
* Si termina en `"!"`.

---

# 12. Varias operaciones con receptor

## Ejercicio 34 — Procesador de texto

Crea:

```kotlin
fun processText(
    text: String,
    operation: String.() -> String
): String
```

Utiliza diferentes lambdas con receptor para realizar transformaciones sobre un texto.

Por ejemplo:

```text
"Kotlin"
```

podría transformarse en:

```text
"KOTLIN"
```

o:

```text
"Programando con Kotlin"
```

podría transformarse en:

```text
"PROGRAMANDO CON KOTLIN"
```

Crea al menos cinco transformaciones diferentes.

---

# 13. Funciones que reciben lambdas con receptor

## Ejercicio 35 — Configurar un número

Crea:

```kotlin
fun configure(
    number: Int,
    block: Int.() -> Int
): Int
```

Utiliza la función para realizar diferentes configuraciones sobre un número.

Por ejemplo:

* Multiplicarlo por `2`.
* Sumárselo a `100`.
* Elevarlo al cuadrado.

---

## Ejercicio 36 — Configurar un `String`

Crea:

```kotlin
fun configure(
    text: String,
    block: String.() -> String
): String
```

Utiliza la función para realizar diferentes transformaciones.

Prueba, entre otras:

* Mayúsculas.
* Minúsculas.
* Añadir prefijo.
* Añadir sufijo.
* Invertir el texto.

---

# 14. Crear un pequeño DSL

## Ejercicio 37 — Configuración de una persona

Crea una clase:

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}
```

Crea una función:

```kotlin
fun person(block: Person.() -> Unit): Person
```

La función debe:

1. Crear un objeto `Person`.
2. Ejecutar `block` sobre ese objeto.
3. Devolver el objeto.

Deberías poder utilizarla de una forma similar a:

```kotlin
val person = person {
    name = "Ana"
    age = 25
}
```

---

## Ejercicio 38 — Configuración de un producto

Crea una clase:

```kotlin
class Product {
    var name: String = ""
    var price: Double = 0.0
}
```

Crea una función que permita construir un `Product` utilizando una lambda con receptor.

La utilización debería tener una estructura similar a:

```kotlin
val product = product {
    name = "Laptop"
    price = 999.99
}
```

---

# 15. Reto final

## Ejercicio 39 — Constructor mediante lambda con receptor

Crea una clase `Car` con las propiedades:

```text
brand
model
year
color
```

Crea una función:

```kotlin
fun car(block: Car.() -> Unit): Car
```

que permita crear y configurar un coche utilizando una lambda con receptor.

El resultado debería poder utilizarse de una forma similar a:

```kotlin
val car = car {
    brand = "Toyota"
    model = "Corolla"
    year = 2026
    color = "Black"
}
```

Muestra posteriormente las propiedades del coche.

---

## Ejercicio 40 — Mini DSL de configuración

Crea una clase `Game` con algunas propiedades configurables, por ejemplo:

```text
title
width
height
fullscreen
volume
```

Crea una función:

```kotlin
fun game(block: Game.() -> Unit): Game
```

que permita configurar un juego mediante una lambda con receptor.

El objetivo es poder escribir:

```kotlin
val game = game {
    title = "My Game"
    width = 1920
    height = 1080
    fullscreen = true
    volume = 80
}
```

Después muestra por consola la configuración resultante.

### Restricciones

* Utilizar una lambda con receptor.
* No utilizar colecciones.
* No utilizar `map`, `filter` ni `forEach`.
* La función `game` debe crear el objeto y ejecutar el bloque recibido.
* La configuración debe realizarse dentro de la lambda con receptor.

---

# 16. Reto adicional

## Ejercicio 41 — Diferentes formas de invocar una lambda

Utiliza la función:

```kotlin
fun execute(
    number: Int,
    operation: (Int) -> Int
): Int
```

Realiza la misma operación de cuatro formas diferentes:

### A

Utilizando una función normal y una referencia mediante `::`.

### B

Utilizando una lambda almacenada en una variable.

### C

Pasando una lambda directamente entre los paréntesis.

### D

Utilizando trailing lambda.

Comprueba que las cuatro formas producen exactamente el mismo resultado.

---

## Ejercicio 42 — Comparación final

Crea un programa que permita comparar las siguientes formas de representar una operación:

### Función normal

```kotlin
fun double(number: Int): Int
```

### Referencia a función

```kotlin
::double
```

### Lambda almacenada

```kotlin
val double = { ... }
```

### Lambda como argumento

```kotlin
process(10) { ... }
```

### Lambda con receptor

```kotlin
process(10) { ... }
```

Utiliza ejemplos equivalentes para que puedas observar las diferencias sintácticas entre todas ellas.

Explica mediante comentarios en el código qué representa cada una.
