# Soluciones: Convenciones de Kotlin e iteración sobre objetos personalizados

## Ejercicio 1 — Un objeto iterable sencillo

```kotlin
class NumberRange(
    private val start: Int,
    private val end: Int
) {
    operator fun iterator(): Iterator<Int> = object : Iterator<Int> {
        private var current = start

        override fun hasNext(): Boolean =
            current <= end

        override fun next(): Int {
            if (!hasNext()) throw NoSuchElementException()
            return current++
        }
    }
}

fun main() {
    val range = NumberRange(3, 7)

    for (number in range) {
        println(number)
    }
}
```

La convención `iterator()` permite que `NumberRange` pueda utilizarse como expresión de un `for`.

---

## Ejercicio 2 — Recorrido descendente

```kotlin
class DescendingRange(
    private val start: Int,
    private val end: Int
) {
    operator fun iterator(): Iterator<Int> = object : Iterator<Int> {
        private var current = start

        override fun hasNext(): Boolean =
            current >= end

        override fun next(): Int {
            if (!hasNext()) throw NoSuchElementException()
            return current--
        }
    }
}

fun main() {
    val range = DescendingRange(10, 5)

    for (number in range) {
        println(number)
    }
}
```

Aquí el estado del iterador comienza en `start` y se decrementa después de cada llamada a `next()`.

---

## Ejercicio 3 — Rango de caracteres

```kotlin
class CharRange(
    private val start: Char,
    private val end: Char
) {
    operator fun iterator(): Iterator<Char> = object : Iterator<Char> {
        private var current = start

        override fun hasNext(): Boolean =
            current <= end

        override fun next(): Char {
            if (!hasNext()) throw NoSuchElementException()

            val result = current
            current++
            return result
        }
    }
}

fun main() {
    val range = CharRange('d', 'h')

    for (character in range) {
        print("$character ")
    }
}
```

Los `Char` se pueden incrementar mediante `++`, por lo que resulta sencillo avanzar al siguiente carácter.

---

## Ejercicio 4 — Días de la semana

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

class DayRange(
    private val start: Day,
    private val end: Day
) {
    operator fun iterator(): Iterator<Day> = object : Iterator<Day> {
        private var current = start

        override fun hasNext(): Boolean =
            current.ordinal <= end.ordinal

        override fun next(): Day {
            if (!hasNext()) throw NoSuchElementException()

            val result = current
            current = Day.entries[current.ordinal + 1]
            return result
        }
    }
}

fun main() {
    val range = DayRange(Day.MONDAY, Day.FRIDAY)

    for (day in range) {
        println(day)
    }
}
```

### Ampliación: recorrido en ambos sentidos

Una solución más completa consiste en determinar la dirección del recorrido:

```kotlin
class DayRange(
    private val start: Day,
    private val end: Day
) {
    operator fun iterator(): Iterator<Day> = object : Iterator<Day> {
        private var current = start
        private val step = if (start.ordinal <= end.ordinal) 1 else -1

        override fun hasNext(): Boolean =
            if (step > 0) {
                current.ordinal <= end.ordinal
            } else {
                current.ordinal >= end.ordinal
            }

        override fun next(): Day {
            if (!hasNext()) throw NoSuchElementException()

            val result = current
            val nextOrdinal = current.ordinal + step

            if (nextOrdinal in Day.entries.indices) {
                current = Day.entries[nextOrdinal]
            }

            return result
        }
    }
}
```

---

## Ejercicio 5 — Versiones de un videojuego

```kotlin
data class Version(
    val major: Int,
    val minor: Int
) : Comparable<Version> {

    override fun compareTo(other: Version): Int =
        compareValuesBy(this, other, Version::major, Version::minor)

    override fun toString(): String =
        "$major.$minor"
}

class VersionRange(
    private val start: Version,
    private val end: Version
) {
    operator fun iterator(): Iterator<Version> = object : Iterator<Version> {
        private var current = start

        override fun hasNext(): Boolean =
            current <= end

        override fun next(): Version {
            if (!hasNext()) throw NoSuchElementException()

            val result = current

            current = if (current.minor == 9) {
                Version(current.major + 1, 0)
            } else {
                Version(current.major, current.minor + 1)
            }

            return result
        }
    }
}

fun main() {
    val range = VersionRange(
        Version(1, 2),
        Version(1, 5)
    )

    for (version in range) {
        println(version)
    }
}
```

La comparación mediante `Comparable` permite utilizar:

```kotlin
current <= end
```

La transición especial entre `1.9` y `2.0` se controla en `next()`.

---

## Ejercicio 6 — Fechas simplificadas

```kotlin
data class SimpleDate(
    val day: Int,
    val month: Int
) {
    override fun toString(): String =
        "$day/$month"
}

class DateRange(
    private val start: SimpleDate,
    private val end: SimpleDate
) {
    operator fun iterator(): Iterator<SimpleDate> = object : Iterator<SimpleDate> {
        private var current = start

        override fun hasNext(): Boolean =
            current.month < end.month ||
                (current.month == end.month && current.day <= end.day)

        override fun next(): SimpleDate {
            if (!hasNext()) throw NoSuchElementException()

            val result = current

            current = if (current.day == 30) {
                SimpleDate(1, current.month + 1)
            } else {
                SimpleDate(current.day + 1, current.month)
            }

            return result
        }
    }
}

fun main() {
    val range = DateRange(
        SimpleDate(28, 3),
        SimpleDate(3, 4)
    )

    for (date in range) {
        println(date)
    }
}
```

En este ejercicio se ha supuesto que todos los meses tienen exactamente 30 días.

---

## Ejercicio 7 — Horas

```kotlin
data class Time(
    val hour: Int,
    val minute: Int
) {
    override fun toString(): String =
        "%02d:%02d".format(hour, minute)
}

class TimeRange(
    private val start: Time,
    private val end: Time
) {
    operator fun iterator(): Iterator<Time> = object : Iterator<Time> {
        private var current = start

        private fun toMinutes(time: Time): Int =
            time.hour * 60 + time.minute

        override fun hasNext(): Boolean =
            toMinutes(current) <= toMinutes(end)

        override fun next(): Time {
            if (!hasNext()) throw NoSuchElementException()

            val result = current

            current = if (current.minute == 59) {
                Time(current.hour + 1, 0)
            } else {
                Time(current.hour, current.minute + 1)
            }

            return result
        }
    }
}

fun main() {
    val range = TimeRange(
        Time(10, 58),
        Time(11, 2)
    )

    for (time in range) {
        println(time)
    }
}
```

La función `toMinutes()` permite comparar fácilmente dos horas.

---

## Ejercicio 8 — Posiciones de un tablero

```kotlin
data class Position(
    val row: Int,
    val column: Int
) {
    override fun toString(): String =
        "($row, $column)"
}

class PositionRange(
    private val start: Position,
    private val end: Position
) {
    operator fun iterator(): Iterator<Position> = object : Iterator<Position> {
        private var current = start

        override fun hasNext(): Boolean =
            current.row < end.row ||
                (current.row == end.row && current.column <= end.column)

        override fun next(): Position {
            if (!hasNext()) throw NoSuchElementException()

            val result = current

            current = if (current.column == 8) {
                Position(current.row + 1, 1)
            } else {
                Position(current.row, current.column + 1)
            }

            return result
        }
    }
}

fun main() {
    val range = PositionRange(
        Position(2, 3),
        Position(2, 7)
    )

    for (position in range) {
        println(position)
    }
}
```

### Ampliación

La misma idea permite recorrer el final de una fila y continuar en la siguiente:

```text
(2, 7)
(2, 8)
(3, 1)
```

La transición se realiza cuando `column == 8`.

---

## Ejercicio 9 — Iterador con estado

```kotlin
class EvenRange(
    private val start: Int,
    private val end: Int
) {
    operator fun iterator(): Iterator<Int> = object : Iterator<Int> {
        private var current =
            if (start % 2 == 0) start else start + 1

        override fun hasNext(): Boolean =
            current <= end

        override fun next(): Int {
            if (!hasNext()) throw NoSuchElementException()

            val result = current
            current += 2

            return result
        }
    }
}

fun main() {
    val range = EvenRange(3, 12)

    for (number in range) {
        println(number)
    }
}
```

El iterador comienza directamente en el primer número par que pertenece al intervalo.

---

## Ejercicio 10 — Rango de objetos ordenables

```kotlin
data class Temperature(
    val value: Int
) : Comparable<Temperature> {

    override fun compareTo(other: Temperature): Int =
        value.compareTo(other.value)

    override fun toString(): String =
        "$value °C"
}

class TemperatureRange(
    private val start: Temperature,
    private val end: Temperature
) {
    operator fun iterator(): Iterator<Temperature> = object : Iterator<Temperature> {
        private var current = start

        override fun hasNext(): Boolean =
            current <= end

        override fun next(): Temperature {
            if (!hasNext()) throw NoSuchElementException()

            val result = current
            current = Temperature(current.value + 1)

            return result
        }
    }
}

fun main() {
    val range = TemperatureRange(
        Temperature(18),
        Temperature(22)
    )

    for (temperature in range) {
        println(temperature)
    }
}
```

Aquí aparecen dos convenciones distintas:

- `compareTo()` permite utilizar operadores relacionales.
- `iterator()` permite utilizar el objeto en un `for`.

---

## Ejercicio 11 — ¿Qué convenciones necesita `for`?

Dado:

```kotlin
for (element in objeto) {
    println(element)
}
```

Kotlin necesita una función:

```kotlin
operator fun iterator(): Iterator<T>
```

El objeto devuelto debe proporcionar:

```kotlin
hasNext()
next()
```

Conceptualmente, el `for` puede entenderse como:

```kotlin
val iterator = objeto.iterator()

while (iterator.hasNext()) {
    val element = iterator.next()
    println(element)
}
```

Por tanto:

1. `iterator()` obtiene el iterador.
2. `hasNext()` indica si quedan elementos.
3. `next()` devuelve el siguiente elemento.
4. `hasNext()` se consulta antes de obtener cada elemento.
5. `next()` avanza el iterador y devuelve el elemento actual.
6. Cuando `hasNext()` devuelve `false`, termina el recorrido.

---

## Ejercicio 12 — Implementación manual de un iterador

```kotlin
class Countdown(
    private val start: Int
) {
    operator fun iterator(): Iterator<Int> = object : Iterator<Int> {
        private var current = start

        override fun hasNext(): Boolean =
            current >= 0

        override fun next(): Int {
            if (!hasNext()) throw NoSuchElementException()

            return current--
        }
    }
}

fun main() {
    for (number in Countdown(5)) {
        println(number)
    }
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

---

## Ejercicio 13 — Rango de letras con salto

```kotlin
class CharStepRange(
    private val start: Char,
    private val end: Char,
    private val step: Int
) {
    init {
        require(step != 0)
    }

    operator fun iterator(): Iterator<Char> = object : Iterator<Char> {
        private var current = start

        override fun hasNext(): Boolean =
            if (step > 0) {
                current <= end
            } else {
                current >= end
            }

        override fun next(): Char {
            if (!hasNext()) throw NoSuchElementException()

            val result = current
            current = (current.code + step).toChar()

            return result
        }
    }
}

fun main() {
    val range = CharStepRange('a', 'z', 3)

    for (character in range) {
        print("$character ")
    }
}
```

Para soportar pasos negativos:

```kotlin
val range = CharStepRange('z', 'a', -3)

for (character in range) {
    print("$character ")
}
```

La condición de `hasNext()` depende de si el paso es positivo o negativo.

---

## Ejercicio 14 — Convención `iterator` como extensión

La clase no necesita contener ningún `iterator()`:

```kotlin
class NumberRange(
    val start: Int,
    val end: Int
)
```

La convención se puede proporcionar mediante una extensión:

```kotlin
operator fun NumberRange.iterator(): Iterator<Int> =
    object : Iterator<Int> {

        private var current = start

        override fun hasNext(): Boolean =
            current <= end

        override fun next(): Int {
            if (!hasNext()) throw NoSuchElementException()

            return current++
        }
    }

fun main() {
    val range = NumberRange(3, 7)

    for (number in range) {
        println(number)
    }
}
```

Esto demuestra que las convenciones no tienen por qué estar declaradas dentro de la propia clase.

---

## Ejercicio 15 — Reto final

```kotlin
class IPAddress(
    val value: Int
) {
    override fun toString(): String =
        "${(value ushr 24) and 255}." +
        "${(value ushr 16) and 255}." +
        "${(value ushr 8) and 255}." +
        "${value and 255}"

    companion object {
        fun fromString(address: String): IPAddress {
            val parts = address.split(".")

            require(parts.size == 4)

            val value =
                (parts[0].toInt() shl 24) or
                (parts[1].toInt() shl 16) or
                (parts[2].toInt() shl 8) or
                parts[3].toInt()

            return IPAddress(value)
        }
    }
}

class IPAddressRange(
    private val start: IPAddress,
    private val end: IPAddress
) {
    operator fun iterator(): Iterator<IPAddress> =
        object : Iterator<IPAddress> {

            private var current = start.value

            override fun hasNext(): Boolean =
                current <= end.value

            override fun next(): IPAddress {
                if (!hasNext()) throw NoSuchElementException()

                return IPAddress(current++)
            }
        }
}

fun main() {
    val range = IPAddressRange(
        IPAddress.fromString("192.168.1.254"),
        IPAddress.fromString("192.168.2.2")
    )

    for (ip in range) {
        println(ip)
    }
}
```

Salida:

```text
192.168.1.254
192.168.1.255
192.168.2.0
192.168.2.1
192.168.2.2
```

### Convenciones utilizadas

La función:

```kotlin
operator fun iterator(): Iterator<IPAddress>
```

hace posible escribir:

```kotlin
for (ip in range)
```

El iterador implementa:

```kotlin
override fun hasNext(): Boolean
```

para determinar si quedan elementos.

Y:

```kotlin
override fun next(): IPAddress
```

para devolver el siguiente elemento y avanzar el estado interno.

Conceptualmente:

```kotlin
val iterator = range.iterator()

while (iterator.hasNext()) {
    val ip = iterator.next()
    println(ip)
}
```

---

# Resumen de las convenciones practicadas

| Convención | Función | Utilidad |
|---|---|---|
| `iterator()` | `operator fun iterator()` | Permite utilizar un objeto en un `for` |
| `hasNext()` | `override fun hasNext()` | Indica si quedan elementos |
| `next()` | `override fun next()` | Devuelve el siguiente elemento |
| `compareTo()` | `operator fun compareTo()` | Permite utilizar operadores relacionales |
| Extensión `iterator()` | `operator fun Tipo.iterator()` | Permite añadir la convención sin modificar la clase |

La transformación conceptual de:

```kotlin
for (element in objeto) {
    println(element)
}
```

es:

```kotlin
val iterator = objeto.iterator()

while (iterator.hasNext()) {
    val element = iterator.next()
    println(element)
}
```

Esta es la idea fundamental que hay detrás de la convención de iteración de Kotlin.
