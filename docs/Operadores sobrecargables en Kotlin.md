# Operadores sobrecargables en Kotlin

En Kotlin es posible definir el comportamiento de determinados operadores para nuestras propias clases mediante funciones marcadas con la palabra clave `operator`.

Por ejemplo:

```kotlin
operator fun plus(other: Vector2D): Vector2D
```

permite utilizar:

```kotlin
val result = vector1 + vector2
```

que Kotlin interpreta como una llamada equivalente a:

```kotlin
val result = vector1.plus(vector2)
```

## Operadores unarios

| Operador     | Función        |
| ------------ | -------------- |
| `+a`         | `unaryPlus()`  |
| `-a`         | `unaryMinus()` |
| `!a`         | `not()`        |
| `++a`, `a++` | `inc()`        |
| `--a`, `a--` | `dec()`        |

### Ejemplo

```kotlin
operator fun unaryMinus(): Vector2D
```

Permite escribir:

```kotlin
val inverted = -vector
```

---

## Operadores aritméticos

| Operador | Función   |
| -------- | --------- |
| `a + b`  | `plus()`  |
| `a - b`  | `minus()` |
| `a * b`  | `times()` |
| `a / b`  | `div()`   |
| `a % b`  | `rem()`   |

### Ejemplo

```kotlin
operator fun plus(other: Vector2D): Vector2D
```

Permite:

```kotlin
val result = vector1 + vector2
```

---

## Operadores de comparación

| Operador | Función       |
| -------- | ------------- |
| `a < b`  | `compareTo()` |
| `a > b`  | `compareTo()` |
| `a <= b` | `compareTo()` |
| `a >= b` | `compareTo()` |

Los cuatro operadores utilizan `compareTo()`.

Por ejemplo:

```kotlin
operator fun compareTo(other: Person): Int
```

Permite utilizar:

```kotlin
person1 < person2
person1 > person2
person1 <= person2
person1 >= person2
```

---

## Operadores de igualdad

| Operador | Función    |
| -------- | ---------- |
| `a == b` | `equals()` |
| `a != b` | `equals()` |

Por ejemplo:

```kotlin
override fun equals(other: Any?): Boolean
```

Permite utilizar:

```kotlin
person1 == person2
person1 != person2
```

> `===` y `!==` **no se pueden sobrecargar**. Estos operadores comprueban la identidad de referencia.

---

## Operadores de rango

| Operador | Función        |
| -------- | -------------- |
| `a..b`   | `rangeTo()`    |
| `a..<b`  | `rangeUntil()` |

Por ejemplo:

```kotlin
operator fun rangeTo(other: Number): NumberRange
```

Permitiría:

```kotlin
val range = number1..number2
```

---

## Operadores de pertenencia

| Operador  | Función      |
| --------- | ------------ |
| `a in b`  | `contains()` |
| `a !in b` | `contains()` |

Por ejemplo:

```kotlin
operator fun contains(value: Int): Boolean
```

Permite:

```kotlin
if (5 in range) {
    // ...
}
```

El operador `!in` también utiliza `contains()`:

```kotlin
if (5 !in range) {
    // ...
}
```

---

## Operadores de indexación

| Sintaxis       | Función |
| -------------- | ------- |
| `a[i]`         | `get()` |
| `a[i] = value` | `set()` |

Por ejemplo:

```kotlin
operator fun get(index: Int): String
```

permite:

```kotlin
val value = container[3]
```

Y:

```kotlin
operator fun set(index: Int, value: String)
```

permite:

```kotlin
container[3] = "Hello"
```

También pueden existir varios índices:

```kotlin
operator fun get(row: Int, column: Int): Int
```

permitiendo:

```kotlin
val value = matrix[2, 3]
```

---

## Operador de invocación

| Sintaxis | Función    |
| -------- | ---------- |
| `a()`    | `invoke()` |

Por ejemplo:

```kotlin
operator fun invoke(value: Int): Int
```

permite utilizar un objeto como si fuera una función:

```kotlin
val result = calculator(10)
```

También pueden existir diferentes parámetros:

```kotlin
operator fun invoke(x: Int, y: Int): Int
```

---

## Operadores de asignación

| Operador | Función         |
| -------- | --------------- |
| `a += b` | `plusAssign()`  |
| `a -= b` | `minusAssign()` |
| `a *= b` | `timesAssign()` |
| `a /= b` | `divAssign()`   |
| `a %= b` | `remAssign()`   |

Por ejemplo:

```kotlin
operator fun plusAssign(other: Vector2D)
```

permite:

```kotlin
vector += other
```

Mientras que:

```kotlin
operator fun plus(other: Vector2D): Vector2D
```

permite:

```kotlin
val result = vector + other
```

---

# Tabla resumen

| Categoría       | Operador     | Función        |
| --------------- | ------------ | -------------- |
| **Unario**      | `+a`         | `unaryPlus()`  |
|                 | `-a`         | `unaryMinus()` |
|                 | `!a`         | `not()`        |
|                 | `++a`, `a++` | `inc()`        |
|                 | `--a`, `a--` | `dec()`        |
| **Aritmético**  | `a + b`      | `plus()`       |
|                 | `a - b`      | `minus()`      |
|                 | `a * b`      | `times()`      |
|                 | `a / b`      | `div()`        |
|                 | `a % b`      | `rem()`        |
| **Comparación** | `a < b`      | `compareTo()`  |
|                 | `a > b`      | `compareTo()`  |
|                 | `a <= b`     | `compareTo()`  |
|                 | `a >= b`     | `compareTo()`  |
| **Igualdad**    | `a == b`     | `equals()`     |
|                 | `a != b`     | `equals()`     |
| **Rango**       | `a..b`       | `rangeTo()`    |
|                 | `a..<b`      | `rangeUntil()` |
| **Pertenencia** | `a in b`     | `contains()`   |
|                 |              |                |
