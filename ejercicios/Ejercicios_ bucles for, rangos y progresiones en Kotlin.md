# Ejercicios: bucles `for`, rangos y progresiones en Kotlin

## Objetivo

En estos ejercicios practicarás el uso de los bucles `for` junto con los **rangos y progresiones de Kotlin**.

Trabajarás principalmente con:

- Rangos inclusivos con `..`
- Rangos con límite superior exclusivo mediante `until`
- Rangos con límite superior exclusivo mediante `..<`
- Rangos descendentes con `downTo`
- Progresiones con `step`
- Combinaciones de `downTo` y `step`
- Uso de `for` con índices
- Uso de rangos con variables
- Bucles `for` anidados

> **Nota:** Todos los identificadores utilizados en el código están en inglés. El texto explicativo y las cadenas mostradas por los programas están en español.

---

# Nivel 1 — Rangos básicos

## 1. Mostrar los números del 1 al 10

Escribe un bucle que muestre por pantalla todos los números desde `1` hasta `10`, ambos incluidos.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 2. Mostrar los números del 5 al 15

Completa el rango para mostrar los números del `5` al `15`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 3. Mostrar los números del 10 al 20

Completa el siguiente programa.

El resultado debe ser:

```text
10
11
12
13
14
15
16
17
18
19
20
```

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 4. Mostrar los números del 0 al 100

Escribe un `for` que recorra todos los números desde `0` hasta `100`, incluyendo ambos extremos.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

# Nivel 2 — Rangos con `..`

El operador `..` crea un rango **inclusivo**: tanto el límite inferior como el superior forman parte del rango.

Por ejemplo:

```kotlin
1..5
```

produce:

```text
1
2
3
4
5
```

## 5. Rango inclusivo

Completa el siguiente código para mostrar los números del `20` al `30`, incluyendo el `30`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 6. Rango con variables

Utiliza las variables `start` y `end` para crear un rango inclusivo.

```kotlin
val start = 5
val end = 15

for (number in __________________) {
    println(number)
}
```

---

## 7. Sumar un rango

Calcula la suma de todos los números desde `1` hasta `100`.

```kotlin
var sum = 0

for (number in __________________) {
    sum += number
}

println(sum)
```

---

# Nivel 3 — `until`

`until` permite crear un rango cuyo límite superior **no está incluido**.

Por ejemplo:

```kotlin
for (number in 0 until 5) {
    println(number)
}
```

produce:

```text
0
1
2
3
4
```

El `5` no forma parte del rango.

---

## 8. Utilizar `until`

Completa el rango para mostrar los números del `0` al `9`.

Debes utilizar `until`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 9. Del 1 al 9

Muestra los números del `1` al `9`, sin incluir el `10`.

Utiliza `until`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 10. Rango definido por variables

Muestra los números desde `start` hasta `end - 1`.

```kotlin
val start = 5
val end = 15

for (number in __________________) {
    println(number)
}
```

Utiliza `until`.

---

## 11. Utilizar `until` con `length`

Utiliza `until` y la propiedad `length` para recorrer todos los índices de la cadena.

```kotlin
val text = "Kotlin"

for (index in __________________) {
    println(text[index])
}
```

El resultado debe ser:

```text
K
o
t
l
i
n
```

---

# Nivel 4 — `..<`

En Kotlin moderno también puedes utilizar `..<` para crear un rango con límite superior exclusivo.

Por ejemplo:

```kotlin
0..<5
```

produce:

```text
0
1
2
3
4
```

Por tanto:

```kotlin
0 until 5
```

y:

```kotlin
0..<5
```

representan el mismo rango de enteros.

---

## 12. Utilizar `..<`

Muestra los números del `0` al `9`, sin incluir el `10`.

```kotlin
for (number in __________________) {
    println(number)
}
```

Utiliza `..<`.

---

## 13. Comparar `until` y `..<`

Completa los dos bucles para que produzcan exactamente el mismo resultado.

```kotlin
for (number in 0 until 10) {
    println(number)
}

for (number in __________________) {
    println(number)
}
```

---

## 14. Convertir `until` a `..<`

Transforma el siguiente código para utilizar `..<` en lugar de `until`.

```kotlin
for (number in 5 until 20) {
    println(number)
}
```

---

## 15. Convertir `..<` a `until`

Transforma el siguiente código para utilizar `until` en lugar de `..<`.

```kotlin
for (number in 10..<25) {
    println(number)
}
```

---

# Nivel 5 — Elegir entre `..`, `until` y `..<`

En los siguientes ejercicios debes elegir el operador adecuado.

## 16. Incluir el límite superior

Muestra todos los números del `1` al `10`, incluyendo el `10`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 17. Excluir el límite superior

Muestra todos los números del `1` al `10`, pero sin incluir el `10`.

```kotlin
for (number in __________________) {
    println(number)
}
```

Utiliza `until`.

---

## 18. Recorrer los índices de una lista

Dada la siguiente lista, muestra todos sus elementos utilizando sus índices.

```kotlin
val numbers = listOf(10, 20, 30, 40, 50)

for (index in __________________) {
    println(numbers[index])
}
```

Utiliza `until`.

---

## 19. Recorrer los índices con `..<`

Resuelve el ejercicio anterior utilizando `..<`.

```kotlin
val numbers = listOf(10, 20, 30, 40, 50)

for (index in __________________) {
    println(numbers[index])
}
```

---

## 20. ¿Qué construcción utilizarías?

Para cada situación, indica si utilizarías `..`, `until` o `..<`.

### A

Recorrer los números del `1` al `10`, incluyendo el `10`.

### B

Recorrer los índices de una cadena.

### C

Recorrer los números del `0` al `99`, sin incluir el `100`.

### D

Recorrer los números del `10` al `20`, incluyendo el `20`.

---

# Nivel 6 — Rangos descendentes con `downTo`

`downTo` permite crear rangos descendentes.

Por ejemplo:

```kotlin
10 downTo 1
```

produce:

```text
10
9
8
7
6
5
4
3
2
1
```

## 21. Cuenta atrás desde 10

Muestra los números desde `10` hasta `1`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 22. Cuenta atrás desde 20

Muestra los números desde `20` hasta `0`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 23. Cuenta atrás desde 100

Muestra todos los números desde `100` hasta `90`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 24. Rango descendente con variables

Utiliza `start` y `end` para recorrer los números desde `end` hasta `start`.

```kotlin
val start = 5
val end = 15

for (number in __________________) {
    println(number)
}
```

---

# Nivel 7 — Progresiones con `step`

`step` permite indicar cuánto debe avanzar una progresión en cada iteración.

Por ejemplo:

```kotlin
0..10 step 2
```

produce:

```text
0
2
4
6
8
10
```

---

## 25. Números pares

Muestra los números pares desde `0` hasta `20`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 26. Múltiplos de 5

Muestra los múltiplos de `5` desde `5` hasta `50`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 27. De 10 en 10

Muestra los números desde `0` hasta `100`, avanzando de `10` en `10`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 28. Números impares

Muestra todos los números impares desde `1` hasta `19`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

# Nivel 8 — `downTo` y `step`

También puedes utilizar `step` con una progresión descendente.

Por ejemplo:

```kotlin
20 downTo 0 step 2
```

produce:

```text
20
18
16
14
12
10
8
6
4
2
0
```

## 29. Cuenta atrás de dos en dos

Muestra los números desde `20` hasta `0`, disminuyendo de `2` en `2`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 30. Cuenta atrás de cinco en cinco

Muestra los números desde `50` hasta `0`, disminuyendo de `5` en `5`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 31. Cuenta atrás de diez en diez

El resultado debe ser:

```text
100
90
80
70
60
50
40
30
20
10
0
```

```kotlin
for (number in __________________) {
    println(number)
}
```

---

## 32. Números pares descendentes

Muestra los números pares desde `20` hasta `2`, en orden descendente.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

# Nivel 9 — Operaciones dentro del `for`

## 33. Mostrar los cuadrados

Muestra el cuadrado de los números del `1` al `10`.

El resultado debe ser:

```text
1
4
9
16
25
36
49
64
81
100
```

```kotlin
for (number in 1..10) {
    println(__________________)
}
```

---

## 34. Mostrar los dobles

Muestra el doble de los números del `1` al `10`.

```kotlin
for (number in 1..10) {
    println(__________________)
}
```

---

## 35. Mostrar múltiplos de 3

Muestra los múltiplos de `3` desde `3` hasta `30`.

```kotlin
for (number in __________________) {
    println(number)
}
```

---

# Nivel 10 — Acumuladores

## 36. Sumar los números del 1 al 10

Calcula la suma de todos los números desde `1` hasta `10`.

El resultado debe ser:

```text
55
```

```kotlin
var sum = 0

for (number in __________________) {
    sum += number
}

println(sum)
```

---

## 37. Sumar los números pares

Calcula la suma de todos los números pares desde `2` hasta `100`.

```kotlin
var sum = 0

for (number in __________________) {
    sum += number
}

println(sum)
```

---

## 38. Multiplicar los números

Calcula el producto de los números desde `1` hasta `5`.

```kotlin
var product = 1

for (number in __________________) {
    product *= number
}

println(product)
```

---

## 39. Sumar múltiplos de 5

Calcula la suma de todos los múltiplos de `5` entre `0` y `100`.

```kotlin
var sum = 0

for (number in __________________) {
    sum += number
}

println(sum)
```

---

# Nivel 11 — Índices

## 40. Recorrer una cadena mediante índices

Utiliza un rango para recorrer los índices de la cadena.

```kotlin
val text = "Kotlin"

for (index in __________________) {
    println(text[index])
}
```

---

## 41. Recorrer una cadena hacia atrás

Utiliza `downTo` para mostrar los caracteres de la cadena en orden inverso.

```kotlin
val text = "Kotlin"

for (index in __________________) {
    println(text[index])
}
```

El resultado debe ser:

```text
n
i
l
t
o
K
```

---

## 42. Mostrar índices y caracteres

Muestra cada índice junto con el carácter correspondiente.

```kotlin
val text = "Kotlin"

for (index in __________________) {
    println("$index: ${text[index]}")
}
```

El resultado debe ser:

```text
0: K
1: o
2: t
3: l
4: i
5: n
```

---

## 43. Mostrar caracteres en índices pares

Muestra únicamente los caracteres situados en índices pares.

```kotlin
val text = "Kotlin programming"

for (index in __________________) {
    println(text[index])
}
```

---

## 44. Mostrar caracteres en índices impares

Modifica el ejercicio anterior para mostrar únicamente los caracteres situados en índices impares.

```kotlin
val text = "Kotlin programming"

for (index in __________________) {
    println(text[index])
}
```

---

# Nivel 12 — Rangos con variables

## 45. Progresión definida por variables

Utiliza las siguientes variables para mostrar los números desde `start` hasta `end`, avanzando según `step`.

```kotlin
val start = 0
val end = 100
val step = 10

for (number in __________________) {
    println(number)
}
```

---

## 46. Progresión descendente definida por variables

Utiliza las siguientes variables para crear una progresión descendente.

```kotlin
val start = 100
val end = 0
val step = 10

for (number in __________________) {
    println(number)
}
```

---

# Nivel 13 — Bucles anidados

## 47. Tabla de multiplicar

Escribe un programa que muestre la tabla de multiplicar del número `7`.

El resultado debe ser:

```text
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
...
7 x 10 = 70
```

Puedes comenzar con:

```kotlin
val number = 7

for (multiplier in __________________) {
    println("$number x $multiplier = ${__________________}")
}
```

El multiplicador debe ir del `1` al `10`.

---

## 48. Recorrer una matriz

Dada una matriz de tres filas y cuatro columnas, utiliza `until` para recorrer todos sus elementos.

```kotlin
val matrix = arrayOf(
    intArrayOf(1, 2, 3, 4),
    intArrayOf(5, 6, 7, 8),
    intArrayOf(9, 10, 11, 12)
)

for (row in __________________) {
    for (column in __________________) {
        print("${matrix[row][column]} ")
    }
    println()
}
```

El resultado debe ser:

```text
1 2 3 4
5 6 7 8
9 10 11 12
```

---

# Nivel 14 — Retos

## 49. Cuenta atrás

Escribe un programa que muestre una cuenta atrás desde `10` hasta `0`.

Después del bucle debe mostrar:

```text
¡Despegue!
```

```kotlin
for (number in __________________) {
    println(number)
}

println("¡Despegue!")
```

---

## 50. Suma descendente

Calcula la suma de todos los números impares desde `99` hasta `1`.

```kotlin
var sum = 0

for (number in __________________) {
    sum += number
}

println(sum)
```

---

## 51. Pirámide numérica

Utiliza un `for` con un rango para generar la siguiente salida:

```text
1
12
123
1234
12345
123456
1234567
12345678
123456789
```

Puedes utilizar un `for` dentro de otro `for`.

```kotlin
for (row in __________________) {

    for (number in __________________) {
        print(number)
    }

    println()
}
```

---

## 52. Pirámide descendente

Genera la siguiente salida:

```text
123456789
12345678
1234567
123456
12345
1234
123
12
1
```

Utiliza `downTo` en alguno de los bucles.

```kotlin
for (row in __________________) {

    for (number in __________________) {
        print(number)
    }

    println()
}
```

---

# Objetivo final

Al terminar los ejercicios deberías ser capaz de:

1. Crear rangos inclusivos utilizando `..`.
2. Crear rangos con límite superior exclusivo utilizando `until`.
3. Crear rangos con límite superior exclusivo utilizando `..<`.
4. Entender la diferencia entre `..`, `until` y `..<`.
5. Crear progresiones descendentes utilizando `downTo`.
6. Utilizar `step` para controlar el incremento de una progresión.
7. Combinar `downTo` y `step`.
8. Combinar `until` o `..<` con `step`.
9. Recorrer cadenas y colecciones mediante índices.
10. Utilizar rangos definidos mediante variables.
11. Utilizar rangos y progresiones junto con acumuladores.
12. Combinar varios `for` mediante bucles anidados.
13. Elegir correctamente entre `..`, `until`, `..<`, `downTo` y `step` según el problema.