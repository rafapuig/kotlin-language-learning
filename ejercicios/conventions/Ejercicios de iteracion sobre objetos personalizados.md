# Ejercicios: Convenciones de Kotlin e iteración sobre objetos personalizados

## Introducción

Kotlin permite utilizar objetos personalizados directamente en un bucle `for` gracias a determinadas **convenciones**.

Por ejemplo:

```kotlin
for (number in 1..10) {
    println(number)
}
```

El rango `1..10` puede recorrerse porque Kotlin dispone de las convenciones necesarias para obtener un iterador y avanzar por sus elementos.

En estos ejercicios tendrás que crear tus propias clases para poder utilizar construcciones como:

```kotlin
for (element in objeto) {
    println(element)
}
```

El objetivo principal es practicar las convenciones:

* `iterator()`
* `hasNext()`
* `next()`

---

## Ejercicio 1 — Un objeto iterable sencillo

Crea una clase `NumberRange` que represente un rango de números enteros.

Debe poder utilizarse de esta forma:

```kotlin
val range = NumberRange(3, 7)

for (number in range) {
    println(number)
}
```

La salida debe ser:

```text
3
4
5
6
7
```

### Requisitos

Implementa las convenciones necesarias para que `NumberRange` pueda utilizarse con `for`.

No puedes utilizar una colección interna para almacenar los números.

---

## Ejercicio 2 — Recorrido descendente

Modifica el ejercicio anterior para crear una clase:

```kotlin
DescendingRange(10, 5)
```

que permita escribir:

```kotlin
for (number in range) {
    println(number)
}
```

con la siguiente salida:

```text
10
9
8
7
6
5
```

### Requisitos

* No utilices una colección.
* El recorrido debe realizarse mediante un iterador.
* El rango debe incluir ambos extremos.

---

## Ejercicio 3 — Rango de caracteres

Crea una clase `CharRange` que permita recorrer caracteres consecutivos.

Por ejemplo:

```kotlin
val range = CharRange('d', 'h')

for (character in range) {
    print("$character ")
}
```

Salida:

```text
d e f g h
```

### Requisitos

La clase debe funcionar con cualquier rango válido de caracteres:

```kotlin
CharRange('a', 'z')
CharRange('M', 'R')
CharRange('0', '5')
```

No puedes almacenar previamente los caracteres en una colección.

---

## Ejercicio 4 — Días de la semana

Define el siguiente `enum`:

```kotlin
enum class Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

Crea una clase:

```kotlin
DayRange
```

que permita hacer:

```kotlin
val range = DayRange(Day.MONDAY, Day.FRIDAY)

for (day in range) {
    println(day)
}
```

La salida será:

```text
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
```

### Requisitos

* El primer y último día deben formar parte del rango.
* No puedes utilizar una colección para almacenar los días.
* El iterador debe avanzar de un `Day` al siguiente.

### Ampliación

Permite también:

```kotlin
DayRange(Day.FRIDAY, Day.MONDAY)
```

para recorrer los días en sentido inverso.

---

## Ejercicio 5 — Versiones de un videojuego

Crea una clase:

```kotlin
Version(
    val major: Int,
    val minor: Int
)
```

Una versión como:

```text
1.4
```

debe ser posterior a:

```text
1.3
```

y anterior a:

```text
2.0
```

Crea una clase:

```kotlin
VersionRange
```

que permita escribir:

```kotlin
val range = VersionRange(
    Version(1, 2),
    Version(1, 5)
)

for (version in range) {
    println(version)
}
```

Salida:

```text
1.2
1.3
1.4
1.5
```

### Requisitos

El incremento debe producir:

```text
1.2 → 1.3 → 1.4 → 1.5
```

Cuando se llegue a:

```text
1.9
```

el siguiente elemento debe ser:

```text
2.0
```

No puedes utilizar una colección para implementar el recorrido.

---

## Ejercicio 6 — Fechas simplificadas

Crea una clase:

```kotlin
SimpleDate(
    val day: Int,
    val month: Int
)
```

Para simplificar el ejercicio, considera que todos los meses tienen 30 días.

Crea una clase:

```kotlin
DateRange
```

que permita:

```kotlin
val range = DateRange(
    SimpleDate(28, 3),
    SimpleDate(3, 4)
)

for (date in range) {
    println(date)
}
```

Salida:

```text
28/3
29/3
30/3
1/4
2/4
3/4
```

### Requisitos

El iterador debe saber pasar de:

```text
30/3
```

a:

```text
1/4
```

No utilices `LocalDate` para resolver el ejercicio.

---

## Ejercicio 7 — Horas

Crea una clase:

```kotlin
Time(
    val hour: Int,
    val minute: Int
)
```

Representa una hora del día utilizando formato de 24 horas.

Crea una clase:

```kotlin
TimeRange
```

que permita recorrer las horas de minuto en minuto.

Por ejemplo:

```kotlin
val range = TimeRange(
    Time(10, 58),
    Time(11, 2)
)

for (time in range) {
    println(time)
}
```

Salida:

```text
10:58
10:59
11:00
11:01
11:02
```

### Requisitos

El iterador debe controlar correctamente el cambio de hora.

No utilices `LocalTime`.

---

## Ejercicio 8 — Posiciones de un tablero

Crea una clase:

```kotlin
Position(
    val row: Int,
    val column: Int
)
```

Representa una posición dentro de un tablero de ajedrez de 8 × 8.

Crea una clase:

```kotlin
PositionRange
```

que permita recorrer las posiciones comprendidas entre dos posiciones.

Por ejemplo:

```kotlin
val range = PositionRange(
    Position(2, 3),
    Position(2, 7)
)

for (position in range) {
    println(position)
}
```

debe producir:

```text
(2, 3)
(2, 4)
(2, 5)
(2, 6)
(2, 7)
```

### Ampliación

Haz que también pueda recorrer:

```text
(2, 7) → (3, 1)
```

produciendo:

```text
(2, 7)
(2, 8)
(3, 1)
```

---

## Ejercicio 9 — Iterador con estado

Crea una clase:

```kotlin
EvenRange(
    val start: Int,
    val end: Int
)
```

que permita recorrer únicamente los números pares.

Por ejemplo:

```kotlin
val range = EvenRange(3, 12)

for (number in range) {
    println(number)
}
```

Salida:

```text
4
6
8
10
12
```

### Requisitos

El iterador debe comenzar por el primer número par que esté dentro del rango.

Por ejemplo:

```kotlin
EvenRange(4, 10)
```

debe producir:

```text
4
6
8
10
```

y:

```kotlin
EvenRange(5, 10)
```

debe producir:

```text
6
8
10
```

---

## Ejercicio 10 — Rango de objetos ordenables

Crea una clase:

```kotlin
Temperature(
    val value: Int
)
```

Implementa una clase:

```kotlin
TemperatureRange
```

que permita recorrer todas las temperaturas entre dos temperaturas dadas, avanzando un grado cada vez.

Por ejemplo:

```kotlin
val range = TemperatureRange(
    Temperature(18),
    Temperature(22)
)

for (temperature in range) {
    println(temperature)
}
```

Salida:

```text
18 °C
19 °C
20 °C
21 °C
22 °C
```

### Requisitos

El objeto `Temperature` debe poder compararse con otro `Temperature`.

Puedes utilizar la convención correspondiente para los operadores relacionales.

---

## Ejercicio 11 — ¿Qué convenciones necesita `for`?

Analiza el siguiente código:

```kotlin
for (element in objeto) {
    println(element)
}
```

Responde:

1. ¿Qué método busca Kotlin en `objeto`?
2. ¿Qué debe devolver ese método?
3. ¿Qué métodos necesita el objeto devuelto?
4. ¿Cuándo se ejecuta `hasNext()`?
5. ¿Cuándo se ejecuta `next()`?
6. ¿Qué ocurre cuando `hasNext()` devuelve `false`?

Después, representa mediante pseudocódigo el funcionamiento equivalente al siguiente `for`:

```kotlin
for (element in objeto) {
    println(element)
}
```

---

## Ejercicio 12 — Implementación manual de un iterador

Crea una clase:

```kotlin
Countdown(val start: Int)
```

que pueda utilizarse así:

```kotlin
for (number in Countdown(5)) {
    println(number)
}
```

Salida:

```text
5
4
3
2
1
0
```

### Restricciones

No puedes utilizar:

* `IntRange`
* colecciones
* `downTo`
* `generateSequence`

Debes implementar manualmente las convenciones necesarias.

---

## Ejercicio 13 — Rango de letras con salto

Crea una clase:

```kotlin
CharStepRange(
    val start: Char,
    val end: Char,
    val step: Int
)
```

Debe permitir:

```kotlin
val range = CharStepRange('a', 'z', 3)

for (character in range) {
    print("$character ")
}
```

Salida:

```text
a d g j m p s v y
```

### Ampliación

Permite utilizar pasos negativos:

```kotlin
CharStepRange('z', 'a', -3)
```

---

## Ejercicio 14 — Convención `iterator` como extensión

Reimplementa el ejercicio de `NumberRange`, pero esta vez sin modificar la clase `NumberRange`.

La clase será:

```kotlin
class NumberRange(
    val start: Int,
    val end: Int
)
```

Y deberás conseguir que funcione:

```kotlin
val range = NumberRange(3, 7)

for (number in range) {
    println(number)
}
```

### Restricción

La función `iterator()` debe implementarse como una **función de extensión**.

---

## Ejercicio 15 — Reto final

Crea una clase:

```kotlin
IPAddress(
    val value: Int
)
```

que represente una dirección IPv4 utilizando un único entero.

Por ejemplo:

```text
127.0.0.1
```

Crea una clase:

```kotlin
IPAddressRange
```

que permita recorrer todas las direcciones comprendidas entre dos direcciones.

Por ejemplo:

```kotlin
val range = IPAddressRange(
    IPAddress.fromString("192.168.1.254"),
    IPAddress.fromString("192.168.2.2")
)

for (ip in range) {
    println(ip)
}
```

Debe producir:

```text
192.168.1.254
192.168.1.255
192.168.2.0
192.168.2.1
192.168.2.2
```

### Restricciones

* No utilizar colecciones.
* No utilizar `Sequence`.
* No utilizar `IntRange`.
* El recorrido debe implementarse mediante las convenciones de Kotlin.
* El iterador debe mantener su propio estado.

### Pregunta final

Explica qué parte de tu solución corresponde a cada una de estas convenciones:

```kotlin
iterator()
hasNext()
next()
```
