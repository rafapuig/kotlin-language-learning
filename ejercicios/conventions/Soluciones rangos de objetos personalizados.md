# Soluciones: rangos de objetos personalizados

## Ejercicio 1 — Días de la semana

Los `enum` ya tienen un orden natural según el orden en el que se declaran sus elementos.

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

Podemos definir `rangeTo` como una extensión:

```kotlin
operator fun Day.rangeTo(
    other: Day
): ClosedRange<Day> =
    object : ClosedRange<Day> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Ahora:

```kotlin
val workingDays =
    Day.MONDAY..Day.FRIDAY

println(Day.WEDNESDAY in workingDays)
println(Day.SUNDAY in workingDays)
```

Resultado:

```text
true
false
```

### Lo importante

No hemos creado:

```kotlin
DayRange
```

El operador `..` devuelve directamente un:

```kotlin
ClosedRange<Day>
```

---

## Ejercicio 2 — Meses del año

```kotlin
enum class Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER
}
```

`rangeTo`:

```kotlin
operator fun Month.rangeTo(
    other: Month
): ClosedRange<Month> =
    object : ClosedRange<Month> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Uso:

```kotlin
val firstQuarter =
    Month.JANUARY..Month.MARCH

println(Month.FEBRUARY in firstQuarter)
println(Month.JUNE in firstQuarter)
```

Resultado:

```text
true
false
```

---

## Ejercicio 3 — Temperaturas

```kotlin
data class Temperature(
    val celsius: Int
) : Comparable<Temperature> {

    override fun compareTo(
        other: Temperature
    ): Int =
        celsius.compareTo(other.celsius)
}
```

La extensión `rangeTo`:

```kotlin
operator fun Temperature.rangeTo(
    other: Temperature
): ClosedRange<Temperature> =
    object : ClosedRange<Temperature> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Uso:

```kotlin
val comfortable =
    Temperature(18)..Temperature(25)

println(Temperature(21) in comfortable)
println(Temperature(30) in comfortable)
```

Resultado:

```text
true
false
```

Aquí `ClosedRange` puede implementar correctamente `contains` porque `Temperature` implementa `Comparable`.

---

## Ejercicio 4 — Edades

```kotlin
data class Age(
    val years: Int
) : Comparable<Age> {

    override fun compareTo(
        other: Age
    ): Int =
        years.compareTo(other.years)
}
```

`rangeTo`:

```kotlin
operator fun Age.rangeTo(
    other: Age
): ClosedRange<Age> =
    object : ClosedRange<Age> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Uso:

```kotlin
val adults =
    Age(18)..Age(65)

println(Age(25) in adults)
println(Age(70) in adults)
```

---

## Ejercicio 5 — Coordenadas

```kotlin
data class Coordinate(
    val value: Int
) : Comparable<Coordinate> {

    override fun compareTo(
        other: Coordinate
    ): Int =
        value.compareTo(other.value)
}
```

```kotlin
operator fun Coordinate.rangeTo(
    other: Coordinate
): ClosedRange<Coordinate> =
    object : ClosedRange<Coordinate> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Uso:

```kotlin
val valid =
    Coordinate(-10)..Coordinate(10)

println(Coordinate(5) in valid)
println(Coordinate(20) in valid)
```

Resultado:

```text
true
false
```

---

## Ejercicio 6 — Versiones

```kotlin
data class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
) : Comparable<Version> {

    override fun compareTo(
        other: Version
    ): Int =
        compareValuesBy(
            this,
            other,
            Version::major,
            Version::minor,
            Version::patch
        )
}
```

`rangeTo`:

```kotlin
operator fun Version.rangeTo(
    other: Version
): ClosedRange<Version> =
    object : ClosedRange<Version> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Uso:

```kotlin
val supported =
    Version(1, 2, 0)..Version(2, 0, 0)

println(Version(1, 5, 3) in supported)
```

`compareValuesBy` permite comparar primero `major`, después `minor` y finalmente `patch`.

---

## Ejercicio 7 — Prioridades

```kotlin
enum class Priority {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}
```

Al igual que ocurre con los demás `enum`, podemos utilizar su orden natural.

```kotlin
operator fun Priority.rangeTo(
    other: Priority
): ClosedRange<Priority> =
    object : ClosedRange<Priority> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Uso:

```kotlin
val important =
    Priority.HIGH..Priority.CRITICAL

println(Priority.CRITICAL in important)
```

---

# A partir de aquí: `iterator`

Hasta ahora hemos conseguido:

```kotlin
a..b
```

y:

```kotlin
x in a..b
```

Pero todavía no podemos hacer:

```kotlin
for (x in a..b)
```

Para ello necesitamos proporcionar la convención `iterator`.

---

## Ejercicio 8 — Horas

```kotlin
data class Hour(
    val value: Int
) : Comparable<Hour> {

    override fun compareTo(
        other: Hour
    ): Int =
        value.compareTo(other.value)
}
```

`rangeTo`:

```kotlin
operator fun Hour.rangeTo(
    other: Hour
): ClosedRange<Hour> =
    object : ClosedRange<Hour> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Hasta aquí:

```kotlin
val morning =
    Hour(8)..Hour(12)
```

funciona perfectamente.

Para poder recorrerlo necesitamos:

```kotlin
operator fun ClosedRange<Hour>.iterator():
        Iterator<Hour> =
    object : Iterator<Hour> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): Hour {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current = Hour(current.value + 1)

            return result
        }
    }
```

Ahora:

```kotlin
for (hour in Hour(8)..Hour(12)) {
    println(hour)
}
```

produce:

```text
Hour(value=8)
Hour(value=9)
Hour(value=10)
Hour(value=11)
Hour(value=12)
```

---

## Ejercicio 9 — Edades iterables

Partimos de:

```kotlin
data class Age(
    val years: Int
) : Comparable<Age> {

    override fun compareTo(
        other: Age
    ): Int =
        years.compareTo(other.years)

    operator fun inc(): Age =
        Age(years + 1)
}
```

El operador `inc()` nos permite utilizar:

```kotlin
current++
```

Ahora podemos definir:

```kotlin
operator fun ClosedRange<Age>.iterator():
        Iterator<Age> =
    object : Iterator<Age> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): Age {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current++

            return result
        }
    }
```

Y:

```kotlin
for (age in Age(18)..Age(22)) {
    println(age)
}
```

produce:

```text
Age(years=18)
Age(years=19)
Age(years=20)
Age(years=21)
Age(years=22)
```

---

## Ejercicio 10 — Temperaturas iterables

```kotlin
data class Temperature(
    val celsius: Int
) : Comparable<Temperature> {

    override fun compareTo(
        other: Temperature
    ): Int =
        celsius.compareTo(other.celsius)

    operator fun inc(): Temperature =
        Temperature(celsius + 1)
}
```

`rangeTo`:

```kotlin
operator fun Temperature.rangeTo(
    other: Temperature
): ClosedRange<Temperature> =
    object : ClosedRange<Temperature> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Iterador:

```kotlin
operator fun ClosedRange<Temperature>.iterator():
        Iterator<Temperature> =
    object : Iterator<Temperature> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): Temperature {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current++

            return result
        }
    }
```

Uso:

```kotlin
for (temperature in Temperature(20)..Temperature(25)) {
    println(temperature.celsius)
}
```

---

## Ejercicio 11 — Coordenadas iterables

```kotlin
data class Coordinate(
    val value: Int
) : Comparable<Coordinate> {

    override fun compareTo(
        other: Coordinate
    ): Int =
        value.compareTo(other.value)

    operator fun inc(): Coordinate =
        Coordinate(value + 1)
}
```

`rangeTo`:

```kotlin
operator fun Coordinate.rangeTo(
    other: Coordinate
): ClosedRange<Coordinate> =
    object : ClosedRange<Coordinate> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Iterador:

```kotlin
operator fun ClosedRange<Coordinate>.iterator():
        Iterator<Coordinate> =
    object : Iterator<Coordinate> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): Coordinate {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current++

            return result
        }
    }
```

Uso:

```kotlin
for (coordinate in Coordinate(-2)..Coordinate(2)) {
    println(coordinate.value)
}
```

Resultado:

```text
-2
-1
0
1
2
```

---

## Ejercicio 12 — Letras

```kotlin
data class Letter(
    val value: Char
) : Comparable<Letter> {

    override fun compareTo(
        other: Letter
    ): Int =
        value.compareTo(other.value)

    operator fun inc(): Letter =
        Letter(value + 1)
}
```

`rangeTo`:

```kotlin
operator fun Letter.rangeTo(
    other: Letter
): ClosedRange<Letter> =
    object : ClosedRange<Letter> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Iterador:

```kotlin
operator fun ClosedRange<Letter>.iterator():
        Iterator<Letter> =
    object : Iterator<Letter> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): Letter {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current++

            return result
        }
    }
```

Uso:

```kotlin
for (letter in Letter('a')..Letter('f')) {
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

---

## Ejercicio 13 — Puntuaciones

```kotlin
data class Score(
    val value: Int
) : Comparable<Score> {

    override fun compareTo(
        other: Score
    ): Int =
        value.compareTo(other.value)

    operator fun inc(): Score =
        Score(value + 1)
}
```

`rangeTo`:

```kotlin
operator fun Score.rangeTo(
    other: Score
): ClosedRange<Score> =
    object : ClosedRange<Score> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Iterador:

```kotlin
operator fun ClosedRange<Score>.iterator():
        Iterator<Score> =
    object : Iterator<Score> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): Score {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current++

            return result
        }
    }
```

Uso:

```kotlin
val passing =
    Score(5)..Score(10)

println(Score(7) in passing)

for (score in passing) {
    println(score.value)
}
```

---

## Ejercicio 14 — Fechas simplificadas

```kotlin
data class SimpleDate(
    val day: Int
) : Comparable<SimpleDate> {

    init {
        require(day in 1..31)
    }

    override fun compareTo(
        other: SimpleDate
    ): Int =
        day.compareTo(other.day)

    operator fun inc(): SimpleDate =
        SimpleDate(day + 1)
}
```

`rangeTo`:

```kotlin
operator fun SimpleDate.rangeTo(
    other: SimpleDate
): ClosedRange<SimpleDate> =
    object : ClosedRange<SimpleDate> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Iterador:

```kotlin
operator fun ClosedRange<SimpleDate>.iterator():
        Iterator<SimpleDate> =
    object : Iterator<SimpleDate> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): SimpleDate {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current++

            return result
        }
    }
```

Uso:

```kotlin
for (date in SimpleDate(10)..SimpleDate(15)) {
    println(date.day)
}
```

Resultado:

```text
10
11
12
13
14
15
```

---

# Ejercicio 15 — Solución genérica

Ahora podemos generalizar la solución.

Primero definimos:

```kotlin
interface Next<T> {
    fun next(): T
}
```

Nuestro tipo:

```kotlin
data class Counter(
    val value: Int
) : Comparable<Counter>, Next<Counter> {

    override fun compareTo(
        other: Counter
    ): Int =
        value.compareTo(other.value)

    override fun next(): Counter =
        Counter(value + 1)
}
```

Ahora `rangeTo`:

```kotlin
operator fun Counter.rangeTo(
    other: Counter
): ClosedRange<Counter> =
    object : ClosedRange<Counter> {
        override val start = this@rangeTo
        override val endInclusive = other
    }
```

Y aquí está la parte más importante del ejercicio: el `iterator` es completamente genérico.

```kotlin
operator fun <T> ClosedRange<T>.iterator():
        Iterator<T>
    where T : Comparable<T>,
          T : Next<T> =
    object : Iterator<T> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = current
            current = current.next()

            return result
        }
    }
```

Ahora:

```kotlin
for (counter in Counter(3)..Counter(7)) {
    println(counter)
}
```

produce:

```text
Counter(value=3)
Counter(value=4)
Counter(value=5)
Counter(value=6)
Counter(value=7)
```

---

# ¿Qué hemos aprendido?

El objetivo de los ejercicios no es simplemente conseguir que funcione:

```kotlin
for (x in a..b)
```

sino entender cómo Kotlin transforma esa sintaxis mediante sus convenciones.

## `a..b`

Utiliza la convención:

```kotlin
operator fun T.rangeTo(other: T)
```

Por ejemplo:

```kotlin
operator fun Age.rangeTo(
    other: Age
): ClosedRange<Age>
```

---

## `x in range`

Utiliza la convención `contains`.

En nuestro caso no necesitamos implementarla porque `ClosedRange<T>` ya proporciona una implementación basada en:

```kotlin
start
endInclusive
compareTo
```

Por eso es suficiente con:

```kotlin
data class Age(
    val years: Int
) : Comparable<Age>
```

---

## `for (x in range)`

Utiliza la convención:

```kotlin
operator fun iterator(): Iterator<T>
```

Y por eso podemos añadirla directamente a `ClosedRange<T>`:

```kotlin
operator fun <T> ClosedRange<T>.iterator(): Iterator<T>
```

---

## La arquitectura conceptual

Al final, para un tipo como:

```kotlin
data class Age(
    val years: Int
)
```

podemos construir toda esta funcionalidad:

```text
Age
 │
 ├── Comparable<Age>
 │      └── permite comparar edades
 │
 ├── rangeTo()
 │      └── permite Age(18)..Age(65)
 │
 └── iterator()
        └── permite for (age in Age(18)..Age(65))
```

Y lo más importante desde el punto de vista idiomático es que **no hemos necesitado crear `AgeRange`**.

Trabajamos directamente con la abstracción estándar:

```kotlin
ClosedRange<Age>
```

Ese es precisamente el patrón que interesa que los alumnos reconozcan cuando estudian las convenciones de Kotlin.
