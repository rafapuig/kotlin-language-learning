# Ejercicios de sobrecarga de operadores en Kotlin

## Objetivos

En estos ejercicios practicarás la **sobrecarga de operadores en Kotlin**.

Aprenderás a definir el comportamiento de operadores como:

```text
+   -   *   /   %
==  !=
<   <=  >   >=
+=  -=  *=  /=
unaryMinus
unaryPlus
[]
()
..  in
```

También aprenderás que no todos los operadores tienen sentido para todas las clases.

La idea fundamental es que, en Kotlin, una expresión como:

```kotlin
a + b
```

puede traducirse en una llamada a una función como:

```kotlin
a.plus(b)
```

Por tanto, podemos definir qué significa `+` cuando `a` y `b` son objetos de una clase creada por nosotros.

---

# Nivel 1 — Primer contacto

## Ejercicio 1 — Dinero

Crea una clase:

```kotlin
class Money(
    val amount: Double,
    val currency: String
)
```

Queremos poder sumar dos cantidades de dinero:

```kotlin
val money1 = Money(10.0, "EUR")
val money2 = Money(5.0, "EUR")

val result = money1 + money2
```

El resultado debe ser:

```text
15 EUR
```

### Requisitos

Sobrecarga el operador `+`.

### Pregunta

¿Qué función debes implementar para sobrecargar `+`?

---

## Ejercicio 2 — Restar dinero

Amplía el ejercicio anterior para poder escribir:

```kotlin
val result = money1 - money2
```

Por ejemplo:

```kotlin
Money(20.0, "EUR") - Money(7.0, "EUR")
```

debe producir:

```text
13 EUR
```

### Decisión de diseño

¿Qué debería ocurrir si se intenta hacer:

```kotlin
Money(10.0, "EUR") + Money(5.0, "USD")
```

Decide cómo debe comportarse tu clase.

---

## Ejercicio 3 — Multiplicar dinero

Queremos poder multiplicar una cantidad por un número:

```kotlin
val price = Money(20.0, "EUR")

val result = price * 3
```

Resultado:

```text
60 EUR
```

Implementa la sobrecarga correspondiente.

### Pregunta

Observa que ahora los dos operandos no son del mismo tipo:

```text
Money * Int
```

¿Qué tipo debe recibir la función `times()`?

---

# Nivel 2 — Vector2D

## Ejercicio 4 — Sumar vectores

Crea:

```kotlin
class Vector2D(
    val x: Double,
    val y: Double
)
```

Queremos poder escribir:

```kotlin
val v1 = Vector2D(2.0, 3.0)
val v2 = Vector2D(4.0, 1.0)

val result = v1 + v2
```

El resultado debe ser:

```text
(6, 4)
```

Sobrecarga `+`.

---

## Ejercicio 5 — Restar vectores

Permite:

```kotlin
val result = v1 - v2
```

De forma que:

```text
(5, 7) - (2, 3) = (3, 4)
```

Sobrecarga `-`.

---

## Ejercicio 6 — Multiplicar un vector por un escalar

Permite:

```kotlin
val result = vector * 3
```

Por ejemplo:

```text
(2, 4) * 3 = (6, 12)
```

### Después

Haz que también funcione:

```kotlin
val result = 3 * vector
```

### Pregunta

¿Por qué necesitas una segunda sobrecarga?

---

## Ejercicio 7 — Dividir un vector

Permite:

```kotlin
val result = vector / 2
```

Por ejemplo:

```text
(10, 6) / 2 = (5, 3)
```

¿Qué debería ocurrir si se intenta dividir por `0`?

Implementa una solución adecuada.

---

## Ejercicio 8 — Vector opuesto

Sobrecarga el operador unario `-`.

Queremos:

```kotlin
val vector = Vector2D(3.0, -5.0)

val result = -vector
```

Resultado:

```text
(-3, 5)
```

Investiga qué función corresponde al operador unario `-`.

---

# Nivel 3 — Igualdad

## Ejercicio 9 — Puntos

Crea:

```kotlin
class Point(
    val x: Int,
    val y: Int
)
```

Queremos poder escribir:

```kotlin
val p1 = Point(10, 20)
val p2 = Point(10, 20)

println(p1 == p2)
```

El resultado debe ser:

```text
true
```

aunque sean dos objetos diferentes.

### Objetivo

Implementa correctamente la igualdad de la clase.

### Pregunta

¿Qué diferencia hay entre:

```kotlin
p1 == p2
```

y:

```kotlin
p1 === p2
```

---

## Ejercicio 10 — Productos

Crea una clase:

```kotlin
class Product(
    val id: Int,
    val name: String,
    val price: Double
)
```

Dos productos deben considerarse iguales cuando tienen el mismo `id`.

Por ejemplo:

```kotlin
Product(10, "Keyboard", 50.0)
```

debe considerarse igual que:

```kotlin
Product(10, "Mechanical Keyboard", 80.0)
```

porque ambos tienen el mismo identificador.

### Objetivo

Sobrecarga correctamente la igualdad.

---

# Nivel 4 — Operadores relacionales

## Ejercicio 11 — Fracciones

Crea:

```kotlin
class Fraction(
    val numerator: Int,
    val denominator: Int
)
```

Haz que las fracciones puedan compararse:

```kotlin
val f1 = Fraction(1, 2)
val f2 = Fraction(3, 4)

println(f1 < f2)
println(f1 > f2)
```

### Objetivo

Haz que `Fraction` implemente `Comparable<Fraction>`.

### Importante

No conviertas necesariamente las fracciones a `Double`.

Piensa en cómo puedes comparar:

```text
a / b
```

con:

```text
c / d
```

mediante productos cruzados.

---

## Ejercicio 12 — Versiones

Crea:

```kotlin
class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
)
```

Permite:

```kotlin
Version(2, 0, 0) > Version(1, 9, 9)
```

y:

```kotlin
Version(1, 5, 0) < Version(1, 6, 0)
```

El orden debe ser:

```text
major
  ↓
minor
  ↓
patch
```

### Después

Haz que también sea posible crear rangos:

```kotlin
val supported = Version(1, 0, 0)..Version(2, 5, 0)
```

y comprobar:

```kotlin
Version(1, 5, 0) in supported
```

---

# Nivel 5 — Operadores de asignación

## Ejercicio 13 — `+=` con vectores

Utiliza `Vector2D`.

Queremos poder escribir:

```kotlin
var position = Vector2D(10.0, 20.0)

position += Vector2D(5.0, -3.0)
```

Después de la operación:

```text
position = (15, 17)
```

### Pregunta

¿Necesitas implementar necesariamente una función llamada `plusAssign()`?

Experimenta primero con `plus()` y observa qué ocurre.

Después investiga cuándo utilizar:

```kotlin
plus()
```

y cuándo:

```kotlin
plusAssign()
```

---

## Ejercicio 14 — Cartera

Crea:

```kotlin
class Wallet(
    var balance: Double
)
```

Permite:

```kotlin
val wallet = Wallet(100.0)

wallet += 50.0
wallet -= 20.0
```

Después de esas operaciones:

```text
balance = 130
```

Implementa los operadores adecuados.

---

# Nivel 6 — Operador `[]`

## Ejercicio 15 — Matriz 2D

Crea una clase:

```kotlin
class Matrix(
    val rows: Int,
    val columns: Int
)
```

Internamente deberá almacenar sus valores.

Queremos poder escribir:

```kotlin
matrix[2, 3]
```

para obtener el elemento situado en la fila `2`, columna `3`.

### Objetivo

Sobrecarga el operador `[]`.

Investiga qué función corresponde al acceso mediante corchetes.

---

## Ejercicio 16 — Modificar una matriz

Amplía el ejercicio anterior para poder escribir:

```kotlin
matrix[2, 3] = 10
```

### Objetivo

Implementa el operador necesario para permitir asignaciones mediante `[]`.

### Pregunta

Observa que:

```kotlin
matrix[2, 3]
```

y:

```kotlin
matrix[2, 3] = 10
```

necesitan comportamientos diferentes.

---

## Ejercicio 17 — Agenda telefónica

Crea una clase `PhoneBook`.

Queremos poder hacer:

```kotlin
phoneBook["Ana"]
```

para obtener el número de teléfono asociado a `"Ana"`.

También debe ser posible:

```kotlin
phoneBook["Ana"] = "600123456"
```

### Objetivo

Utilizar `get()` y `set()` mediante la sobrecarga del operador `[]`.

---

# Nivel 7 — Operador `contains`

## Ejercicio 18 — Biblioteca

Crea una clase:

```kotlin
class Book(
    val isbn: String,
    val title: String
)
```

Crea una clase `Library` que contenga libros.

Queremos poder escribir:

```kotlin
if (book in library) {
    println("El libro está en la biblioteca")
}
```

### Objetivo

Sobrecarga el operador necesario para que funcione `in`.

### Pregunta

¿Qué función utiliza Kotlin para implementar el comportamiento de `in`?

---

## Ejercicio 19 — Código postal

Crea:

```kotlin
class PostalCode(
    val value: Int
)
```

Y una clase:

```kotlin
class PostalCodeRange(
    val minimum: PostalCode,
    val maximum: PostalCode
)
```

Queremos poder escribir:

```kotlin
if (PostalCode(46010) in range) {
    println("Está dentro del rango")
}
```

Implementa el operador adecuado.

---

# Nivel 8 — Operador `()`

## Ejercicio 20 — Conversor de unidades

Crea una clase:

```kotlin
class CelsiusToFahrenheit
```

Queremos poder utilizar un objeto como si fuera una función:

```kotlin
val converter = CelsiusToFahrenheit()

val result = converter(20.0)
```

El resultado debe ser:

```text
68.0
```

### Objetivo

Investiga cómo sobrecargar el operador `()`.

### Pista

La función que necesitas se llama:

```kotlin
operator fun invoke(...)
```

---

## Ejercicio 21 — Generador de salud

Crea una clase:

```kotlin
class DamageCalculator(
    val multiplier: Double
)
```

Queremos:

```kotlin
val calculator = DamageCalculator(1.5)

val damage = calculator(100.0)
```

El resultado será:

```text
150.0
```

La idea es que el objeto se comporte como una función.

---

# Nivel 9 — Operadores unarios

## Ejercicio 22 — Temperatura

Crea:

```kotlin
class Temperature(
    val degrees: Double
)
```

Sobrecarga:

```kotlin
-temperature
```

de manera que:

```kotlin
val temperature = Temperature(20.0)

val opposite = -temperature
```

produzca una temperatura de `-20 °C`.

---

## Ejercicio 23 — Contador

Crea:

```kotlin
class Counter(
    var value: Int
)
```

Investiga cómo funcionan:

```kotlin
counter++

counter--
```

y consigue que puedan utilizarse con tu clase.

### Pregunta

¿Qué diferencia existe entre:

```kotlin
counter++
```

y:

```kotlin
++counter
```

?

---

# Nivel 10 — Combinando operadores

## Ejercicio 24 — Vector2D completo

Amplía `Vector2D` para que soporte:

```text id="k73qdu"
+   suma
-   resta
*   multiplicación por escalar
/   división por escalar
-   vector opuesto
==  igualdad
```

Queremos poder escribir:

```kotlin
val a = Vector2D(2.0, 3.0)
val b = Vector2D(4.0, 5.0)

val c = a + b
val d = a - b
val e = a * 2
val f = a / 2
val g = -a

println(a == b)
```

### Reto adicional

Haz que también funcione:

```kotlin
val result = 2 * a
```

---

# Nivel 11 — Un caso diferente: dinero

## Ejercicio 25 — Clase `Money`

Crea una clase:

```kotlin
class Money(
    val amount: Double,
    val currency: String
)
```

Implementa:

```text id="r8wz8f"
+       sumar dinero
-       restar dinero
*       multiplicar por número
/       dividir por número
==      comparar cantidades
```

### Ejemplo

```kotlin
val salary = Money(2000.0, "EUR")
val bonus = Money(500.0, "EUR")

val total = salary + bonus
```

Resultado:

```text
2500 EUR
```

### Importante

Decide qué debe suceder si se intenta:

```kotlin
Money(100.0, "EUR") + Money(50.0, "USD")
```

Justifica tu decisión.

---

# Nivel 12 — Un caso diferente: coordenadas

## Ejercicio 26 — Punto y desplazamiento

Crea:

```kotlin
class Point(
    val x: Double,
    val y: Double
)
```

y:

```kotlin
class Vector2D(
    val x: Double,
    val y: Double
)
```

Queremos poder escribir:

```kotlin
val point = Point(10.0, 20.0)
val movement = Vector2D(5.0, -3.0)

val newPoint = point + movement
```

Resultado:

```text
(15, 17)
```

### Pregunta

¿Tiene sentido permitir:

```kotlin
point + point
```

?

Decide qué operaciones deben estar permitidas y cuáles no.

---

# Nivel 13 — Un caso diferente: tiempo

## Ejercicio 27 — Duración

Crea:

```kotlin
class Duration(
    val seconds: Long
)
```

Permite:

```kotlin
val morning = Duration(3600)
val afternoon = Duration(1800)

val total = morning + afternoon
```

También:

```kotlin
val doubleDuration = morning * 2
```

y:

```kotlin
val halfDuration = morning / 2
```

### Después

Haz que las duraciones sean comparables:

```kotlin
Duration(3600) > Duration(1800)
```

---

# Nivel 14 — Un caso diferente: números complejos

## Ejercicio 28 — Números complejos

Crea:

```kotlin
class Complex(
    val real: Double,
    val imaginary: Double
)
```

Implementa:

```text id="y7o0xw"
+       suma
-       resta
*       multiplicación
-       opuesto
==      igualdad
```

Recuerda que:

```text
(a + bi) + (c + di)
=
(a + c) + (b + d)i
```

y:

```text
(a + bi)(c + di)
=
(ac - bd) + (ad + bc)i
```

### Ejemplo

```kotlin
val z1 = Complex(2.0, 3.0)
val z2 = Complex(4.0, 1.0)

val sum = z1 + z2
val product = z1 * z2
```

---

# Nivel 15 — Operadores con significado semántico

## Ejercicio 29 — Fracción

Crea:

```kotlin
class Fraction(
    val numerator: Int,
    val denominator: Int
)
```

Implementa:

```text id="1c2r7y"
+       suma
-       resta
*       multiplicación
/       división
-       opuesto
==      igualdad
```

Por ejemplo:

```kotlin
Fraction(1, 2) + Fraction(1, 3)
```

debe producir una fracción equivalente a:

```text
5 / 6
```

### Reto adicional

Simplifica automáticamente las fracciones.

Por ejemplo:

```text id="48n0zh"
2 / 4
```

debería almacenarse o mostrarse como:

```text id="p1gy7h"
1 / 2
```

---

# Nivel 16 — Diseñar los operadores adecuados

## Ejercicio 30 — ¿Qué operadores tienen sentido?

Para cada clase, decide qué operadores tendría sentido sobrecargar.

### A — `Temperature`

```text
+ ?
- ?
* ?
/ ?
< ?
> ?
== ?
```

### B — `BankAccount`

```text
+ ?
- ?
* ?
/ ?
== ?
```

### C — `Vector2D`

```text
+ ?
- ?
* ?
/ ?
== ?
```

### D — `Book`

```text
+ ?
- ?
* ?
== ?
```

### E — `Duration`

```text
+ ?
- ?
* ?
/ ?
< ?
> ?
```

### Objetivo

No debes implementar los operadores.

Simplemente **justifica cuáles tienen sentido y cuáles no**.

---

# Nivel 17 — Detectar errores de diseño

## Ejercicio 31

Un alumno ha creado esta clase:

```kotlin
class Student(
    val name: String,
    val age: Int
) {
    operator fun plus(other: Student): Student {
        return Student(
            "$name ${other.name}",
            age + other.age
        )
    }
}
```

Por tanto puede escribir:

```kotlin
val student1 = Student("Ana", 20)
val student2 = Student("Pedro", 22)

val student3 = student1 + student2
```

### Preguntas

1. ¿Es legal el código?
2. ¿Está bien diseñado?
3. ¿Qué significa realmente sumar dos estudiantes?
4. ¿Qué problema puede causar utilizar operadores simplemente porque técnicamente es posible?
5. ¿Sería mejor una función como `combineWith()`?

---

# Nivel 18 — Reto final

## Ejercicio 32 — Clase `Money` completa

Diseña una clase `Money` que permita:

```kotlin
val a = Money(100.0, "EUR")
val b = Money(50.0, "EUR")
```

y soporte:

```text id="o7cq52"
a + b
a - b
a * 2
a / 2
a == b
a < b
a > b
```

Además:

```kotlin
a += b
a -= b
```

### Requisitos

- No se pueden combinar monedas de diferentes divisas.
- No se puede dividir por cero.
- La igualdad debe tener sentido.
- Las comparaciones deben tener sentido.
- Debes decidir qué operadores implementar y justificar cada uno.

---

# Reto final 2 — Tu propia clase

Diseña una clase para la que tenga sentido utilizar **al menos cinco operadores**.

Algunas ideas:

- `Vector2D`
- `Money`
- `Fraction`
- `Complex`
- `Duration`
- `Temperature`
- `Distance`
- `Time`
- `Matrix`
- `Color`
- `Point`
- `Rectangle`

### Debes implementar

Como mínimo:

- un operador binario aritmético;
- un operador unario;
- igualdad;
- un operador de comparación;
- un operador de asignación (`+=`, `-=`, etc.).

Después escribe un pequeño programa que utilice todos los operadores.

---

# Tabla de referencia

| Operador | Función |
|---|---|
| `a + b` | `plus()` |
| `a - b` | `minus()` |
| `a * b` | `times()` |
| `a / b` | `div()` |
| `a % b` | `rem()` |
| `a == b` | `equals()` |
| `a < b` | `compareTo()` |
| `a <= b` | `compareTo()` |
| `a > b` | `compareTo()` |
| `a >= b` | `compareTo()` |
| `-a` | `unaryMinus()` |
| `+a` | `unaryPlus()` |
| `++a` / `a++` | `inc()` |
| `--a` / `a--` | `dec()` |
| `a += b` | `plusAssign()` |
| `a -= b` | `minusAssign()` |
| `a *= b` | `timesAssign()` |
| `a /= b` | `divAssign()` |
| `a % b` | `rem()` |
| `a..b` | `rangeTo()` |
| `a in b` | `contains()` |
| `a[i]` | `get()` |
| `a[i] = x` | `set()` |
| `a()` | `invoke()` |

---

# Preguntas finales

Al terminar los ejercicios, deberías poder responder:

1. ¿Qué significa sobrecargar un operador?

2. ¿Por qué una clase puede definir su propio comportamiento para `+`?

3. ¿Qué diferencia hay entre `plus()` y `plusAssign()`?

4. ¿Qué función se utiliza para implementar `<` y `>`?

5. ¿Por qué `==` no se implementa mediante una función `operator fun ==()`?

6. ¿Qué función permite utilizar `[]`?

7. ¿Qué función permite utilizar `()`?

8. ¿Qué función permite utilizar `in`?

9. ¿Qué función permite utilizar `..`?

10. ¿Por qué no es buena idea sobrecargar un operador simplemente porque Kotlin lo permite?

## Idea fundamental

La sobrecarga de operadores debe hacer que el código sea **más natural y legible**, no más extraño.

Por ejemplo, esto tiene sentido:

```kotlin
val total = price1 + price2
```

porque sumar dos cantidades de dinero es una operación natural.

También tiene sentido:

```kotlin
val position = position + velocity
```

porque estamos sumando vectores.

Pero esto probablemente no tendría sentido:

```kotlin
val student3 = student1 + student2
```

aunque técnicamente podamos programarlo.

> **No preguntes solamente "¿puedo sobrecargar este operador?". Pregunta también "¿tiene sentido que este operador represente esta operación?".**