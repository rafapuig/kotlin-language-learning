# Ejercicios — Introducción a la programación funcional en Kotlin

## Objetivos

En estos ejercicios practicarás progresivamente:

- Referencias a funciones mediante `::`.
- Tipos función.
- Variables que almacenan funciones.
- Funciones que reciben otras funciones como parámetros.
- Lambdas.
- Funciones de orden superior.
- Parámetros función.

> **Importante:** todavía no se utilizarán listas, colecciones, `map`, `filter` ni otras operaciones sobre colecciones.

---

# 1. Referencias a funciones

## Ejercicio 1 — Doblar un número

Crea una función llamada `double` que reciba un número entero y devuelva su doble.

Después, crea una variable llamada `operation` que almacene una referencia a la función `double`.

Utiliza `operation` para calcular el doble de `8`.

Resultado esperado:

```text
16
```

---

## Ejercicio 2 — Cuadrado de un número

Crea una función llamada `square` que reciba un `Int` y devuelva su cuadrado.

Crea una variable que almacene una referencia a esta función y utilízala para calcular el cuadrado de `7`.

Resultado esperado:

```text
49
```

---

## Ejercicio 3 — Conversión de temperatura

Crea una función `toFahrenheit` que reciba una temperatura en grados Celsius y devuelva su equivalente en Fahrenheit.

Utiliza una referencia a la función para convertir:

- 0 ºC
- 20 ºC
- 37 ºC
- 100 ºC

La fórmula es:

```text
F = C × 9 / 5 + 32
```

---

# 2. Variables que almacenan funciones

## Ejercicio 4 — Operación matemática

Crea las siguientes funciones:

```kotlin
fun add(a: Int, b: Int): Int
fun subtract(a: Int, b: Int): Int
fun multiply(a: Int, b: Int): Int
```

Crea una variable llamada `operation` que pueda almacenar cualquiera de estas funciones.

Haz que `operation` almacene inicialmente la función `add`.

Utilízala para calcular:

```text
10 + 5
```

Después haz que almacene `multiply` y calcula:

```text
10 × 5
```

Finalmente haz que almacene `subtract` y calcula:

```text
10 - 5
```

---

## Ejercicio 5 — Operaciones sobre números

Crea las siguientes funciones:

```kotlin
fun double(number: Int): Int
fun triple(number: Int): Int
fun square(number: Int): Int
```

Crea una variable `operation` capaz de almacenar cualquiera de ellas.

Prueba las tres operaciones utilizando siempre la misma variable.

---

## Ejercicio 6 — Operaciones con `Double`

Crea las siguientes funciones:

```kotlin
fun add(a: Double, b: Double): Double
fun subtract(a: Double, b: Double): Double
fun multiply(a: Double, b: Double): Double
fun divide(a: Double, b: Double): Double
```

Crea una variable que pueda almacenar cualquiera de estas funciones.

Utiliza la variable para realizar diferentes operaciones con los números:

```text
10.0
4.0
```

---

# 3. Tipos función

## Ejercicio 7 — Declarar el tipo de una función

Dada la siguiente función:

```kotlin
fun double(number: Int): Int {
    return number * 2
}
```

Crea una variable llamada `operation` cuyo tipo sea explícitamente el tipo función correspondiente.

La variable debe almacenar una referencia a `double`.

Utiliza posteriormente `operation` para calcular el doble de `12`.

---

## Ejercicio 8 — Diferentes tipos función

Indica qué tipo función corresponde a cada una de las siguientes funciones:

```kotlin
fun square(number: Int): Int
```

```kotlin
fun add(a: Int, b: Int): Int
```

```kotlin
fun isEven(number: Int): Boolean
```

```kotlin
fun greet(name: String): String
```

Después crea una variable para cada tipo y almacena en ella la referencia a la función correspondiente.

---

## Ejercicio 9 — Una variable, diferentes funciones

Crea las siguientes funciones:

```kotlin
fun isPositive(number: Int): Boolean
fun isNegative(number: Int): Boolean
fun isZero(number: Int): Boolean
```

Declara una variable cuyo tipo permita almacenar cualquiera de estas funciones.

Haz que la variable almacene cada una de las funciones y comprueba su resultado utilizando el número:

```text
-5
```

---

# 4. Funciones que reciben funciones

## Ejercicio 10 — Aplicar una operación

Crea una función:

```kotlin
fun applyOperation(
    number: Int,
    operation: (Int) -> Int
): Int
```

La función debe aplicar `operation` sobre `number`.

Crea además:

```kotlin
fun double(number: Int): Int
fun square(number: Int): Int
```

Utiliza `applyOperation` para calcular:

- El doble de `6`.
- El cuadrado de `6`.

---

## Ejercicio 11 — Calculadora

Crea una función:

```kotlin
fun calculate(
    a: Double,
    b: Double,
    operation: (Double, Double) -> Double
): Double
```

Utiliza esta función junto con las funciones:

```text
add
subtract
multiply
divide
```

para realizar diferentes operaciones.

Por ejemplo:

```text
10 + 5
10 - 5
10 × 5
10 / 5
```

---

## Ejercicio 12 — Aplicar una transformación

Crea una función:

```kotlin
fun transform(
    number: Int,
    transformation: (Int) -> Int
): Int
```

Crea las funciones:

```text
double
triple
square
```

Utiliza `transform` para aplicar cada una de ellas al número `5`.

---

# 5. Primeras lambdas

## Ejercicio 13 — Primera lambda

Crea una variable llamada `double` que almacene una lambda capaz de calcular el doble de un número.

La variable debe tener explícitamente su tipo función.

Utilízala para calcular:

```text
8 × 2
```

---

## Ejercicio 14 — Lambdas matemáticas

Crea las siguientes variables utilizando lambdas:

- `add`: suma dos números.
- `subtract`: resta dos números.
- `multiply`: multiplica dos números.
- `divide`: divide dos números.

Utiliza tipos `Double`.

Después utiliza las cuatro variables para realizar diferentes operaciones.

---

## Ejercicio 15 — Comparaciones

Crea mediante lambdas las siguientes funciones:

- Comprobar si un número es positivo.
- Comprobar si un número es negativo.
- Comprobar si un número es par.
- Comprobar si un número es múltiplo de `5`.

Todas las lambdas deben recibir un `Int` y devolver un `Boolean`.

---

## Ejercicio 16 — Saludos

Crea una variable llamada `greet` que almacene una lambda que reciba un nombre y devuelva:

```text
Hola, <nombre>
```

Por ejemplo:

```text
Hola, Ana
```

Utiliza la lambda con varios nombres.

---

# 6. Lambdas como argumentos

## Ejercicio 17 — Transformar un número

Utiliza la función:

```kotlin
fun transform(
    number: Int,
    transformation: (Int) -> Int
): Int
```

Sin crear funciones adicionales, utiliza lambdas directamente para:

1. Calcular el doble de `10`.
2. Calcular el triple de `10`.
3. Calcular el cuadrado de `10`.
4. Sumar `5` al número.
5. Restar `3` al número.

---

## Ejercicio 18 — Comprobar un número

Crea la siguiente función:

```kotlin
fun check(
    number: Int,
    condition: (Int) -> Boolean
): Boolean
```

Utiliza lambdas directamente para comprobar si:

1. `10` es positivo.
2. `10` es par.
3. `10` es mayor que `5`.
4. `10` es menor que `5`.
5. `10` es múltiplo de `3`.

---

## Ejercicio 19 — Calculadora con lambdas

Utiliza:

```kotlin
fun calculate(
    a: Double,
    b: Double,
    operation: (Double, Double) -> Double
): Double
```

Sin crear funciones adicionales, utiliza lambdas para realizar:

1. Una suma.
2. Una resta.
3. Una multiplicación.
4. Una división.
5. El promedio de los dos números.

---

# 7. Parámetros función

## Ejercicio 20 — Aplicar dos operaciones

Crea una función:

```kotlin
fun applyTwice(
    number: Int,
    operation: (Int) -> Int
): Int
```

La función debe aplicar `operation` dos veces sobre el número.

Por ejemplo, si se utiliza:

```kotlin
applyTwice(5) { it * 2 }
```

el resultado debe ser:

```text
20
```

porque:

```text
5 → 10 → 20
```

Prueba la función utilizando diferentes operaciones.

---

## Ejercicio 21 — Aplicar tres operaciones

Modifica la idea del ejercicio anterior creando:

```kotlin
fun applyThreeTimes(
    number: Int,
    operation: (Int) -> Int
): Int
```

Prueba la función con:

```kotlin
{ it + 1 }
```

y con:

```kotlin
{ it * 2 }
```

Calcula los resultados manualmente antes de ejecutar el programa.

---

## Ejercicio 22 — Procesar un número

Crea una función:

```kotlin
fun process(
    number: Int,
    transformation: (Int) -> Int,
    condition: (Int) -> Boolean
): Int
```

La función debe:

1. Aplicar `transformation` al número.
2. Comprobar el resultado mediante `condition`.
3. Si cumple la condición, devolver el resultado.
4. Si no la cumple, devolver `0`.

Por ejemplo:

```kotlin
process(
    5,
    { it * 2 },
    { it > 5 }
)
```

debe devolver:

```text
10
```

Mientras que:

```kotlin
process(
    5,
    { it * 2 },
    { it > 20 }
)
```

debe devolver:

```text
0
```

---

# 8. Reto final

## Ejercicio 23 — Procesador de números

Crea una función:

```kotlin
fun processNumber(
    number: Int,
    operation: (Int) -> Int
): Int
```

Utilízala para realizar diferentes transformaciones sobre un número.

El programa debe permitir probar, al menos, las siguientes operaciones:

- Doblar.
- Triplicar.
- Elevar al cuadrado.
- Obtener el valor absoluto.
- Añadir `10`.
- Restar `10`.

Utiliza lambdas directamente al realizar las operaciones.

---

## Ejercicio 24 — Validador genérico

Crea una función:

```kotlin
fun validate(
    value: Int,
    condition: (Int) -> Boolean
): String
```

Debe devolver:

```text
"Valid"
```

si `condition` devuelve `true`, y:

```text
"Invalid"
```

en caso contrario.

Utilízala para comprobar:

- Si un número es positivo.
- Si un número es par.
- Si un número es mayor que `100`.
- Si un número está entre `10` y `20`.

---

## Ejercicio 25 — Calculadora funcional

Crea un pequeño programa de calculadora utilizando funciones y lambdas.

Debe existir una función:

```kotlin
fun calculate(
    a: Double,
    b: Double,
    operation: (Double, Double) -> Double
): Double
```

El programa debe poder realizar:

- Suma.
- Resta.
- Multiplicación.
- División.
- Potencia.

Las operaciones deben proporcionarse a `calculate` mediante lambdas.

### Restricciones

- No utilizar `if` para decidir qué operación matemática realizar.
- No utilizar `when` para decidir qué operación matemática realizar.
- No crear una función diferente para cada operación.
- Utilizar lambdas.
- No utilizar listas ni colecciones.
