# Ejercicios: rangos de objetos personalizados

En estos ejercicios practicarás las convenciones de Kotlin que permiten utilizar objetos definidos por el usuario con los operadores de rangos y los bucles `for`.

El objetivo es utilizar las abstracciones y convenciones propias de Kotlin, especialmente:

* `Comparable`
* `ClosedRange`
* `rangeTo`
* `contains`
* `iterator`

**No debes crear clases específicas como `AgeRange`, `TemperatureRange`, `VersionRange`, etc.**

Cuando necesites representar un rango, utiliza:

```kotlin
ClosedRange<T>
```

---

## Ejercicio 1 — Días de la semana

Define un `enum class Day` con los siete días de la semana.

Haz que los días puedan compararse según su orden natural.

Después implementa una extensión `rangeTo` que permita escribir:

```kotlin
val workingDays = Day.MONDAY..Day.FRIDAY
```

El resultado debe ser un `ClosedRange<Day>`.

Por ahora solamente debe funcionar la comprobación de pertenencia:

```kotlin
println(Day.WEDNESDAY in workingDays)
println(Day.SUNDAY in workingDays)
```

---

## Ejercicio 2 — Meses del año

Define un `enum class Month` con los doce meses.

Implementa `rangeTo` para poder escribir:

```kotlin
val firstQuarter = Month.JANUARY..Month.MARCH
```

El rango debe ser un `ClosedRange<Month>`.

Comprueba que funciona el operador `in`:

```kotlin
println(Month.FEBRUARY in firstQuarter)
println(Month.JUNE in firstQuarter)
```

---

## Ejercicio 3 — Temperaturas

Define:

```kotlin
data class Temperature(
    val celsius: Int
)
```

Haz que `Temperature` implemente `Comparable<Temperature>`.

Después implementa `rangeTo` para poder escribir:

```kotlin
val comfortable = Temperature(18)..Temperature(25)
```

Comprueba:

```kotlin
println(Temperature(21) in comfortable)
println(Temperature(30) in comfortable)
```

---

## Ejercicio 4 — Edades

Define:

```kotlin
data class Age(
    val years: Int
)
```

Haz que sea comparable y permite crear rangos:

```kotlin
val adults = Age(18)..Age(65)
```

Después comprueba:

```kotlin
println(Age(25) in adults)
println(Age(70) in adults)
```

---

## Ejercicio 5 — Coordenadas

Define:

```kotlin
data class Coordinate(
    val value: Int
)
```

Permite crear:

```kotlin
val valid = Coordinate(-10)..Coordinate(10)
```

y comprobar si una coordenada pertenece al rango.

Por ejemplo:

```kotlin
println(Coordinate(5) in valid)
println(Coordinate(20) in valid)
```

---

## Ejercicio 6 — Versiones

Define:

```kotlin
data class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
)
```

Implementa el orden natural de las versiones:

1. Primero `major`.
2. Después `minor`.
3. Finalmente `patch`.

Debe ser posible escribir:

```kotlin
val supported =
    Version(1, 2, 0)..Version(2, 0, 0)
```

y:

```kotlin
println(Version(1, 5, 3) in supported)
```

---

## Ejercicio 7 — Prioridades

Define:

```kotlin
enum class Priority {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}
```

Permite crear:

```kotlin
val important =
    Priority.HIGH..Priority.CRITICAL
```

y comprobar la pertenencia mediante `in`.

---

## Ejercicio 8 — Horas

Define:

```kotlin
data class Hour(
    val value: Int
)
```

Las horas deben poder compararse.

Permite crear:

```kotlin
val morning = Hour(8)..Hour(12)
```

y comprobar:

```kotlin
println(Hour(10) in morning)
println(Hour(15) in morning)
```

---

## Ejercicio 9 — Implementar `iterator`

Modifica la clase `Age` del ejercicio 4 para que también pueda recorrerse un rango mediante un `for`.

Debe ser posible:

```kotlin
for (age in Age(18)..Age(22)) {
    println(age)
}
```

Resultado:

```text
Age(years=18)
Age(years=19)
Age(years=20)
Age(years=21)
Age(years=22)
```

Utiliza la convención `iterator`.

No crees una clase `AgeRange`.

---

## Ejercicio 10 — Temperaturas iterables

Modifica `Temperature` para que pueda recorrerse un rango.

Debe ser posible:

```kotlin
for (temperature in Temperature(20)..Temperature(25)) {
    println(temperature)
}
```

El incremento debe ser de un grado:

```text
20
21
22
23
24
25
```

---

## Ejercicio 11 — Coordenadas iterables

Modifica `Coordinate` para que:

```kotlin
for (coordinate in Coordinate(-2)..Coordinate(2)) {
    println(coordinate)
}
```

produzca:

```text
-2
-1
0
1
2
```

No crees ninguna clase adicional para representar el rango.

---

## Ejercicio 12 — Letras

Define:

```kotlin
data class Letter(
    val value: Char
)
```

Haz que sea posible escribir:

```kotlin
val letters =
    Letter('a')..Letter('f')
```

y recorrer el rango:

```kotlin
for (letter in letters) {
    println(letter.value)
}
```

Resultado:

```text
a
b
c
d
e
f
```

No utilices `CharRange`.

---

## Ejercicio 13 — Puntuaciones

Define:

```kotlin
data class Score(
    val value: Int
)
```

Permite crear:

```kotlin
val passing =
    Score(5)..Score(10)
```

Debe funcionar `in`:

```kotlin
println(Score(7) in passing)
```

y también:

```kotlin
for (score in passing) {
    println(score)
}
```

---

## Ejercicio 14 — Fechas simplificadas

Define:

```kotlin
data class SimpleDate(
    val day: Int
)
```

Supón que solamente trabajamos con los días del 1 al 31.

Permite:

```kotlin
val period =
    SimpleDate(10)..SimpleDate(15)
```

y:

```kotlin
for (date in period) {
    println(date)
}
```

El resultado debe contener los días 10, 11, 12, 13, 14 y 15.

---

## Ejercicio 15 — Convención genérica para cualquier `ClosedRange`

Define:

```kotlin
interface Next<T> {
    fun next(): T
}
```

Crea:

```kotlin
data class Counter(
    val value: Int
)
```

Haz que `Counter` sea comparable y que implemente `Next<Counter>`.

Después define una extensión genérica de `ClosedRange<T>` que permita obtener un `Iterator<T>` para cualquier tipo que:

* sea `Comparable<T>`;
* implemente `Next<T>`.

Debe ser posible escribir:

```kotlin
for (counter in Counter(3)..Counter(7)) {
    println(counter)
}
```

sin crear una clase `CounterRange`.

El resultado esperado es:

```text
Counter(value=3)
Counter(value=4)
Counter(value=5)
Counter(value=6)
Counter(value=7)
```

### Restricción adicional

La implementación del `iterator` debe ser una **extensión genérica de `ClosedRange<T>`**, no una implementación específica para `Counter`.
