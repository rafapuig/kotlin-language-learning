# Ejercicios de clases, operadores relacionales y rangos en Kotlin

## Objetivos

En estos ejercicios aprenderás a utilizar clases definidas por ti con operadores que normalmente utilizamos con tipos básicos.

Trabajaremos principalmente con:

- `Comparable`;
- `compareTo()`;
- operadores `<`, `<=`, `>`, `>=`;
- `rangeTo()`;
- operador `..`;
- operador `in`;
- `ClosedRange`;
- rangos de objetos;
- y, en los ejercicios avanzados, `step`.

La idea fundamental es comprender que Kotlin permite **definir cómo se comportan los operadores cuando trabajamos con nuestras propias clases**.

---

# Parte 1 — Comparar objetos

## Ejercicio 1 — Comparar edades

Crea una clase:

```kotlin
class Age(val value: Int)
```

Queremos poder comparar objetos `Age` utilizando:

```kotlin
val age1 = Age(20)
val age2 = Age(30)
```

De manera que podamos escribir:

```kotlin
println(age1 < age2)
println(age1 > age2)
println(age1 <= age2)
println(age1 >= age2)
```

### Objetivo

Haz que `Age` implemente `Comparable<Age>`.

Investiga qué función debes implementar.

### Pista

La clase debe tener una función con esta forma:

```kotlin
override operator fun compareTo(other: Age): Int {
    // ...
}
```

---

## Ejercicio 2 — Entender `compareTo`

Una vez implementado el ejercicio anterior, prueba:

```kotlin
val age1 = Age(20)
val age2 = Age(30)
val age3 = Age(20)

println(age1.compareTo(age2))
println(age2.compareTo(age1))
println(age1.compareTo(age3))
```

### Preguntas

¿Qué significa que `compareTo()` devuelva:

- un número negativo;
- `0`;
- un número positivo?

### Comprueba

```kotlin
age1.compareTo(age2) < 0
age1.compareTo(age3) == 0
age2.compareTo(age1) > 0
```

Relaciona estos resultados con:

```kotlin
age1 < age2
age1 == age3
age2 > age1
```

---

# Parte 2 — Los operadores relacionales

## Ejercicio 3 — Temperaturas

Crea una clase:

```kotlin
class Temperature(val degrees: Double)
```

Haz que dos temperaturas puedan compararse utilizando:

```kotlin
val t1 = Temperature(18.5)
val t2 = Temperature(25.0)

println(t1 < t2)
println(t1 > t2)
println(t1 <= t2)
println(t1 >= t2)
```

La comparación debe realizarse utilizando `degrees`.

### Pregunta

¿Qué debería devolver?

```kotlin
t1.compareTo(t2)
```

---

## Ejercicio 4 — ¿Qué hace realmente `<`?

Después del ejercicio anterior, analiza esta expresión:

```kotlin
t1 < t2
```

Investiga cómo se relaciona con:

```kotlin
t1.compareTo(t2) < 0
```

### Objetivo

Comprender que:

```kotlin
a < b
```

se basa en la comparación entre `a` y `b`.

Haz lo mismo con:

```kotlin
a > b
a <= b
a >= b
```

---

# Parte 3 — Crear un rango de objetos

## Ejercicio 5 — Un rango de edades

Tenemos:

```kotlin
class Age(val value: Int) : Comparable<Age> {
    override operator fun compareTo(other: Age): Int {
        return value.compareTo(other.value)
    }
}
```

Queremos poder escribir:

```kotlin
val minimum = Age(18)
val maximum = Age(30)

val range = minimum..maximum
```

### Objetivo

Haz que la clase permita crear este rango.

Investiga qué función debe implementar la clase para que funcione:

```kotlin
minimum..maximum
```

### Pista

El operador `..` está relacionado con una función llamada:

```kotlin
rangeTo()
```

---

## Ejercicio 6 — Comprobar si un objeto está dentro de un rango

Utiliza la clase `Age` del ejercicio anterior.

Queremos poder hacer:

```kotlin
val adults = Age(18)..Age(65)

val age = Age(30)

println(age in adults)
```

Debe producir:

```text
true
```

Y:

```kotlin
val age = Age(70)

println(age in adults)
```

debe producir:

```text
false
```

### Preguntas

1. ¿Qué función permite utilizar `..`?
2. ¿Qué operación está utilizando `in` para comprobar si un valor pertenece al rango?
3. ¿Por qué es importante que `Age` implemente `Comparable<Age>`?

---

# Parte 4 — Crear nuestro propio `rangeTo`

## Ejercicio 7 — Rango de temperaturas

Crea:

```kotlin
class Temperature(val degrees: Double)
```

Haz que sea posible escribir:

```kotlin
val cold = Temperature(0.0)..Temperature(10.0)
```

Después comprueba:

```kotlin
println(Temperature(5.0) in cold)
println(Temperature(15.0) in cold)
```

### Objetivo

La clase debe permitir:

```text
Temperature(0.0) .. Temperature(10.0)
```

y:

```text
Temperature(5.0) in range
```

---

## Ejercicio 8 — Analizar el tipo del rango

A partir del ejercicio anterior:

```kotlin
val range = Temperature(0.0)..Temperature(10.0)
```

averigua qué tipo tiene `range`.

Investiga la interfaz:

```kotlin
ClosedRange<T>
```

### Preguntas

1. ¿Qué significa que sea un `ClosedRange`?
2. ¿Cuál es su límite inferior?
3. ¿Cuál es su límite superior?
4. ¿Qué significa que los extremos estén incluidos?

---

# Parte 5 — Rangos con una clase más interesante

## Ejercicio 9 — Calificaciones

Crea una clase:

```kotlin
class Grade(val value: Int)
```

Una calificación estará entre `0` y `10`.

Haz que sea posible comparar calificaciones:

```kotlin
val grade1 = Grade(5)
val grade2 = Grade(8)

println(grade1 < grade2)
```

Después crea rangos:

```kotlin
val fail = Grade(0)..Grade(4)
val pass = Grade(5)..Grade(10)
```

Comprueba:

```kotlin
println(Grade(3) in fail)
println(Grade(7) in pass)
println(Grade(9) in fail)
```

### Objetivo

Utilizar simultáneamente:

- `Comparable`;
- `compareTo`;
- `rangeTo`;
- `..`;
- `in`.

---

## Ejercicio 10 — Clasificar una nota

Utiliza la clase `Grade`.

Crea los siguientes rangos:

```text
0..4     → Suspenso
5..6     → Aprobado
7..8     → Notable
9..10    → Sobresaliente
```

Pero utiliza objetos `Grade`, no `Int`.

Por ejemplo:

```kotlin
val fail = Grade(0)..Grade(4)
val pass = Grade(5)..Grade(6)
val good = Grade(7)..Grade(8)
val excellent = Grade(9)..Grade(10)
```

Después crea una función:

```kotlin
fun classify(grade: Grade): String
```

que determine en qué rango se encuentra.

Ejemplo:

```kotlin
println(classify(Grade(8)))
```

Resultado:

```text
Notable
```

---

# Parte 6 — Comparar objetos más complejos

## Ejercicio 11 — Versiones de un programa

Crea una clase:

```kotlin
class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
)
```

Ejemplos:

```text
1.0.0
1.2.0
1.2.5
2.0.0
```

Haz que las versiones puedan compararse.

El orden debe ser:

1. primero `major`;
2. si coincide, `minor`;
3. si también coincide, `patch`.

Por ejemplo:

```kotlin
Version(2, 0, 0) > Version(1, 9, 9)
```

debe ser `true`.

Y:

```kotlin
Version(1, 3, 0) > Version(1, 2, 9)
```

también debe ser `true`.

---

## Ejercicio 12 — Rangos de versiones

Utiliza la clase `Version`.

Queremos poder definir:

```kotlin
val supportedVersions =
    Version(1, 0, 0)..Version(2, 5, 0)
```

Y comprobar:

```kotlin
println(Version(1, 5, 0) in supportedVersions)
```

y:

```kotlin
println(Version(3, 0, 0) in supportedVersions)
```

### Pregunta

¿Por qué no necesitamos escribir nosotros mismos una función como:

```kotlin
isBetween(version, minimum, maximum)
```

para comprobar si una versión está dentro del rango?

---

# Parte 7 — Rangos con fechas

## Ejercicio 13 — Día del mes

Crea una clase:

```kotlin
class Day(val value: Int)
```

Haz que pueda compararse con otros días.

Después crea:

```kotlin
val firstWeek = Day(1)..Day(7)
```

Comprueba:

```kotlin
println(Day(3) in firstWeek)
println(Day(10) in firstWeek)
```

### Después

Crea los rangos:

```text
1..7    → primera semana
8..14   → segunda semana
15..21  → tercera semana
22..31  → cuarta semana
```

y crea una función que determine en qué semana se encuentra un día.

---

# Parte 8 — Comprender los límites del rango

## Ejercicio 14 — ¿El rango incluye los extremos?

Utiliza:

```kotlin
val range = Grade(5)..Grade(10)
```

Comprueba:

```kotlin
println(Grade(5) in range)
println(Grade(10) in range)
println(Grade(4) in range)
println(Grade(11) in range)
```

### Pregunta

¿Qué observas?

Explica qué significa que `..` cree un rango **cerrado**.

---

# Parte 9 — Investigar `rangeTo`

## Ejercicio 15 — El operador `..`

Analiza:

```kotlin
val range = Grade(5)..Grade(10)
```

Investiga qué llamada equivalente se encuentra detrás del operador.

La idea es descubrir la relación entre:

```kotlin
a..b
```

y:

```kotlin
a.rangeTo(b)
```

### Después

Haz que ambas formas produzcan el mismo resultado:

```kotlin
val range1 = Grade(5)..Grade(10)

val range2 = Grade(5).rangeTo(Grade(10))
```

---

# Parte 10 — Diseña tu propia clase comparable

## Ejercicio 16 — Peso

Crea:

```kotlin
class Weight(val kilograms: Double)
```

Haz que:

```kotlin
Weight(70.0) > Weight(60.0)
```

funcione correctamente.

Después permite crear:

```kotlin
val normalWeight = Weight(60.0)..Weight(80.0)
```

y comprobar:

```kotlin
println(Weight(72.5) in normalWeight)
```

---

## Ejercicio 17 — Velocidad

Crea:

```kotlin
class Speed(val kmh: Double)
```

Haz que se pueda comparar.

Después crea:

```kotlin
val legalSpeed = Speed(0.0)..Speed(120.0)
```

y utiliza:

```kotlin
if (Speed(100.0) in legalSpeed) {
    println("Velocidad permitida")
}
```

---

# Parte 11 — Reto

## Ejercicio 18 — Temperaturas de una estación meteorológica

Crea una clase:

```kotlin
class Temperature(val degrees: Double)
```

Debe permitir:

- comparar temperaturas;
- utilizar `<`, `>`, `<=` y `>=`;
- crear rangos con `..`;
- utilizar `in`.

Después define:

```text
Muy fría      → -20..0
Fría          → 0..15
Templada      → 15..25
Calurosa      → 25..40
```

Utiliza objetos `Temperature`.

Crea:

```kotlin
fun classify(temperature: Temperature): String
```

que devuelva la categoría correspondiente.

### Ejemplo

```kotlin
println(classify(Temperature(22.5)))
```

Debe producir:

```text
Templada
```

---

# Parte 12 — Reto avanzado: `step`

## Ejercicio 19 — ¿Podemos hacer `step`?

Tenemos:

```kotlin
class Number(val value: Int)
```

Y queremos conseguir algo parecido a:

```kotlin
Number(1)..Number(10)
```

pero además:

```kotlin
Number(1)..Number(10) step 2
```

### Investiga

¿Funciona directamente?

Si no funciona, averigua por qué.

### Objetivo

Comprender que crear un rango mediante `rangeTo()` y crear una **progresión** son conceptos relacionados, pero no exactamente iguales.

---

# Reto final — Un rango de objetos

## Ejercicio 20 — Nivel de un personaje

Crea:

```kotlin
class Level(val value: Int)
```

Los niveles posibles van de `1` a `100`.

La clase debe permitir:

```kotlin
Level(10) < Level(20)
Level(50) >= Level(25)
```

y:

```kotlin
val beginner = Level(1)..Level(10)
val intermediate = Level(11)..Level(50)
val advanced = Level(51)..Level(100)
```

Después crea:

```kotlin
fun classify(level: Level): String
```

que determine:

```text
1..10    → Beginner
11..50   → Intermediate
51..100  → Advanced
```

### Ejemplo

```kotlin
println(classify(Level(35)))
```

Resultado:

```text
Intermediate
```

---

# Reto final 2 — Sistema de precios

Crea:

```kotlin
class Price(val euros: Double)
```

Haz que los precios puedan compararse y utilizarse en rangos.

Define:

```text
0..20      → Barato
20..100    → Medio
100..500   → Caro
500..∞     → Muy caro
```

Para el último caso, investiga cómo representar un rango cuyo límite superior no esté establecido.

### Pregunta adicional

¿Puedes utilizar:

```kotlin
in
```

para comprobar si un precio pertenece a cada categoría?

---

# Lo que debes aprender

Al terminar estos ejercicios deberías entender la relación entre estos conceptos:

```text
                 Comparable
                     │
                     ▼
                 compareTo()
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
       < > <= >=             ordenar
          │
          │
          ▼
       rangeTo()
          │
          ▼
          ..
          │
          ▼
     ClosedRange<T>
          │
          ▼
         in
```

## Idea fundamental

Cuando escribimos:

```kotlin
age1 < age2
```

Kotlin utiliza la capacidad de comparación proporcionada por:

```kotlin
compareTo()
```

Cuando escribimos:

```kotlin
Age(18)..Age(65)
```

estamos utilizando:

```kotlin
rangeTo()
```

Y cuando escribimos:

```kotlin
Age(30) in range
```

estamos preguntando si el objeto pertenece al rango.

Por tanto, una clase definida por nosotros puede integrarse con los operadores de Kotlin si proporcionamos las operaciones que esos operadores necesitan.

---

# Preguntas de reflexión

Después de completar los ejercicios, intenta responder sin mirar el código:

1. ¿Qué interfaz debe implementar una clase para poder compararse mediante `<` y `>`?

2. ¿Qué función debe implementar?

3. ¿Qué significa que `compareTo()` devuelva `0`?

4. ¿Qué significa que devuelva un número negativo?

5. ¿Qué significa que devuelva un número positivo?

6. ¿Qué función está relacionada con el operador `..`?

7. ¿Qué tipo de objeto representa normalmente un rango como `5..10`?

8. ¿Qué operación se utiliza al escribir `x in range`?

9. ¿Por qué `Comparable` es importante cuando queremos crear rangos de nuestros propios objetos?

10. ¿Qué diferencia conceptual existe entre un **rango** y una **progresión**?