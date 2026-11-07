# EXAMEN DE KOTLIN – UNIDAD 5
## Arrays, colecciones, mapas y secuencias

**Ciclo:** 2.º DAM  
**Módulo:** PMDM  
**Número de preguntas:** 40  
**Tipo:** Test (4 opciones, una única respuesta correcta)

**Nombre y apellidos:** ______________________________________

**Fecha:** __________________

---

## PARTE 1. ARRAYS Y CREACIÓN DE CONTENEDORES

**Pregunta 1.** ¿Cuál de las siguientes instrucciones crea correctamente un array de tres enteros?

A) `val numbers = arrayOf(1, 2, 3)`

B) `val numbers = Array<Int>(1, 2, 3)`

C) `val numbers = Int(1, 2, 3)`

D) `val numbers = listOf<Int>(1, 2, 3)`

**Pregunta 2.** ¿Qué característica diferencia principalmente a un array de una lista inmutable (`List`)?

A) Un array no puede almacenar objetos.

B) Un array permite modificar sus elementos mediante índices.

C) Una lista siempre tiene un tamaño fijo y un array no.

D) Un array no permite recorrer sus elementos.

**Pregunta 3.** ¿Qué imprime el siguiente código?

```kotlin
val numbers = intArrayOf(10, 20, 30)
numbers[1] = 50

println(numbers[1])
```

A) `10`

B) `20`

C) `30`

D) `50`

**Pregunta 4.** ¿Qué función permite crear un array indicando su tamaño y una función de inicialización?

A) `arrayOf()`

B) `Array()`

C) `listOf()`

D) `mutableListOf()`

**Pregunta 5.** ¿Qué resultado produce el siguiente código?

```kotlin
val numbers = Array(4) { index -> index * 2 }

println(numbers.contentToString())
```

A) `[0, 2, 4, 6]`

B) `[2, 4, 6, 8]`

C) `[0, 1, 2, 3]`

D) `[4, 4, 4, 4]`

**Pregunta 6.** ¿Cuál es la forma correcta de crear un array de enteros inicializado con cinco ceros?

A) `Array(5) { 0 }`

B) `Array(5, 0)`

C) `arrayOf(5) { 0 }`

D) `IntArray { 5 }`

**Pregunta 7.** ¿Qué diferencia existe entre `arrayOf(1, 2, 3)` e `intArrayOf(1, 2, 3)`?

A) No existe ninguna diferencia.

B) `arrayOf` crea un array de referencias (`Array<Int>`), mientras que `intArrayOf` crea un array especializado de enteros (`IntArray`).

C) `intArrayOf` crea una lista inmutable.

D) `arrayOf` solo admite tipos nullable.

**Pregunta 8.** ¿Qué devuelve la propiedad `size` de un array?

A) El último índice del array.

B) El número de elementos que contiene.

C) El tamaño en bytes de cada elemento.

D) La suma de todos sus elementos.

---

## PARTE 2. COLECCIONES: LISTAS, CONJUNTOS Y MAPAS

**Pregunta 9.** ¿Qué función factoría crea una lista no mutable?

A) `mutableListOf()`

B) `arrayListOf()`

C) `listOf()`

D) `mutableSetOf()`

**Pregunta 10.** ¿Qué sucede al ejecutar el siguiente código?

```kotlin
val names = listOf("Ana", "Luis", "Marta")
names.add("Pedro")
```

A) Se añade Pedro correctamente.

B) Se produce un error de compilación porque `List` no declara la operación `add`.

C) Se elimina el primer elemento y se añade Pedro.

D) La lista se convierte automáticamente en mutable.

**Pregunta 11.** ¿Qué función factoría permite crear un conjunto mutable?

A) `setOf()`

B) `listOf()`

C) `mutableSetOf()`

D) `mapOf()`

**Pregunta 12.** ¿Qué característica distingue principalmente a un `Set` de una `List`?

A) Un `Set` no permite almacenar elementos duplicados.

B) Un `Set` siempre mantiene los elementos ordenados.

C) Una `List` no permite elementos repetidos.

D) Una `List` no permite acceder mediante índices.

**Pregunta 13.** ¿Qué resultado produce el siguiente código?

```kotlin
val numbers = setOf(1, 2, 2, 3, 3, 3)

println(numbers.size)
```

A) `6`

B) `5`

C) `3`

D) `1`

**Pregunta 14.** ¿Qué función permite crear un mapa no mutable a partir de pares clave-valor?

A) `listOf()`

B) `mapOf()`

C) `mutableMapOf()`

D) `setOf()`

**Pregunta 15.** ¿Qué imprime el siguiente código?

```kotlin
val capitals = mapOf(
    "España" to "Madrid",
    "Francia" to "París"
)

println(capitals["España"])
```

A) `España`

B) `Madrid`

C) `París`

D) `null`

**Pregunta 16.** ¿Qué ocurre si se consulta una clave inexistente en un mapa utilizando el operador `[]`?

```kotlin
val ages = mapOf("Ana" to 20)

println(ages["Luis"])
```

A) Se produce una excepción.

B) Devuelve `0`.

C) Devuelve `null`.

D) Devuelve una cadena vacía.

**Pregunta 17.** ¿Qué sucede al ejecutar el siguiente código?

```kotlin
val ages = mutableMapOf("Ana" to 20)
ages["Luis"] = 25

println(ages.size)
```

A) `1`

B) `2`

C) `0`

D) Error de compilación.

---

## PARTE 3. MUTABILIDAD, COPIAS Y FUNCIONES DE CONVERSIÓN

**Pregunta 18.** ¿Qué diferencia existe entre `List` y `MutableList`?

A) `List` permite añadir elementos y `MutableList` no.

B) `MutableList` permite modificar la colección mediante operaciones de escritura.

C) `List` siempre contiene elementos inmutables.

D) No existe ninguna diferencia.

**Pregunta 19.** ¿Qué devuelve la siguiente expresión?

```kotlin
val numbers = listOf(1, 2, 3)
val mutableNumbers = numbers.toMutableList()
```

A) Una nueva lista mutable con los mismos elementos.

B) La misma lista original, sin modificar su tipo.

C) Un array de enteros.

D) Una lista vacía.

**Pregunta 20.** ¿Qué hace la función `toSet()` aplicada a una colección?

A) Convierte todos sus elementos en cadenas.

B) Crea un conjunto que elimina los elementos duplicados.

C) Ordena automáticamente los elementos.

D) Convierte la colección en un mapa.

**Pregunta 21.** ¿Qué resultado produce el siguiente código?

```kotlin
val numbers = listOf(1, 2, 3)
val result = numbers.toMutableList()

result.add(4)

println(numbers.size)
println(result.size)
```

A)
```text
4
4
```

B)
```text
3
4
```

C)
```text
4
3
```

D)
```text
3
3
```

**Pregunta 22.** ¿Qué hace la función `copy()` de una clase `data class`?

A) Crea una copia del objeto, permitiendo modificar determinados argumentos.

B) Convierte el objeto en un array.

C) Hace que todas sus propiedades sean inmutables.

D) Elimina el objeto original.

**Pregunta 23.** Observa el siguiente código:

```kotlin
data class User(val name: String, val age: Int)

val user1 = User("Ana", 20)
val user2 = user1.copy(age = 25)

println(user2)
```

¿Qué imprime?

A) `User(name=Ana, age=20)`

B) `User(name=Ana, age=25)`

C) `User(name=25, age=20)`

D) `Ana`

**Pregunta 24.** ¿Qué afirmación describe correctamente las funciones `toList()` y `toMutableList()`?

A) Ambas devuelven siempre la misma instancia original.

B) `toList()` devuelve una lista de solo lectura y `toMutableList()` devuelve una lista mutable.

C) `toList()` devuelve un array y `toMutableList()` un conjunto.

D) Ambas eliminan los elementos duplicados.

---

## PARTE 4. OPERADORES FUNCIONALES Y BUILDERS

**Pregunta 25.** ¿Qué hace la función `map()` aplicada a una colección?

A) Elimina los elementos que no cumplen una condición.

B) Transforma cada elemento y devuelve una nueva colección con los resultados.

C) Ordena los elementos de forma ascendente.

D) Devuelve únicamente el primer elemento.

**Pregunta 26.** ¿Qué resultado produce el siguiente código?

```kotlin
val numbers = listOf(1, 2, 3, 4)

val result = numbers.filter { it % 2 == 0 }

println(result)
```

A) `[1, 3]`

B) `[2, 4]`

C) `[1, 2, 3, 4]`

D) `[2]`

**Pregunta 27.** ¿Qué devuelve la función `flatMap()`?

A) Una colección cuyos elementos son los resultados de transformar cada elemento en una colección y aplanar esos resultados.

B) Una colección ordenada de mayor a menor.

C) Un único elemento de la colección original.

D) Una colección sin elementos duplicados necesariamente.

**Pregunta 28.** ¿Qué imprime el siguiente código?

```kotlin
val numbers = listOf(1, 2, 3)

val result = numbers.map { it * 2 }

println(result.sum())
```

A) `6`

B) `10`

C) `12`

D) `14`

**Pregunta 29.** ¿Qué hace la función `fold()`?

A) Ordena una colección.

B) Acumula un resultado recorriendo los elementos a partir de un valor inicial.

C) Elimina todos los elementos de una colección.

D) Devuelve siempre el primer elemento.

**Pregunta 30.** ¿Qué resultado produce el siguiente código?

```kotlin
val numbers = listOf(1, 2, 3, 4)

val result = numbers.fold(0) { acc, number ->
    acc + number
}

println(result)
```

A) `4`

B) `6`

C) `10`

D) `24`

**Pregunta 31.** ¿Qué función permite construir una lista mutable dentro de un bloque y obtener una lista como resultado?

A) `buildList { }`

B) `listOf { }`

C) `toList { }`

D) `mutableListOf { }`

**Pregunta 32.** ¿Qué imprime el siguiente código?

```kotlin
val numbers = buildList {
    add(10)
    add(20)
    add(30)
}

println(numbers.sum())
```

A) `30`

B) `50`

C) `60`

D) `0`

---

## PARTE 5. SEQUENCE, ITERABLE E ITERATOR

**Pregunta 33.** ¿Qué diferencia principal existe entre una colección y una `Sequence` al aplicar operaciones como `map` y `filter`?

A) Las operaciones sobre colecciones son siempre perezosas.

B) Las operaciones intermedias de una `Sequence` se ejecutan de forma perezosa.

C) Una `Sequence` no permite utilizar `map`.

D) Una colección no permite recorrer sus elementos.

**Pregunta 34.** ¿Qué función permite convertir una colección en una `Sequence`?

A) `toArray()`

B) `asSequence()`

C) `toIterator()`

D) `asIterable()`

**Pregunta 35.** ¿Cuándo se ejecutan las operaciones intermedias de una `Sequence`?

A) Inmediatamente al declarar la secuencia.

B) Cuando se solicita una operación terminal.

C) Al crear la variable.

D) Nunca se ejecutan.

**Pregunta 36.** ¿Cuál de las siguientes es una operación terminal de `Sequence`?

A) `map`

B) `filter`

C) `take`

D) `toList`

**Pregunta 37.** ¿Qué imprime el siguiente código?

```kotlin
val result = sequenceOf(1, 2, 3, 4, 5)
    .filter { it % 2 == 0 }
    .map { it * 10 }
    .toList()

println(result)
```

A) `[10, 20, 30, 40, 50]`

B) `[2, 4]`

C) `[20, 40]`

D) `[1, 3, 5]`

**Pregunta 38.** ¿Qué representa la interfaz `Iterable<T>`?

A) Una interfaz que permite obtener un iterador para recorrer sus elementos.

B) Una interfaz que obliga a almacenar los elementos en un array.

C) Una interfaz que permite modificar cualquier colección.

D) Una interfaz que solo pueden implementar los mapas.

**Pregunta 39.** ¿Qué métodos forman parte de la interfaz `Iterator<T>`?

A) `add()` y `remove()`.

B) `hasNext()` y `next()`.

C) `map()` y `filter()`.

D) `first()` y `last()`.

**Pregunta 40.** ¿Qué sucede al ejecutar el siguiente código?

```kotlin
val numbers = listOf(10, 20, 30)
val iterator = numbers.iterator()

println(iterator.next())
println(iterator.hasNext())
println(iterator.next())
```

A)
```text
10
true
20
```

B)
```text
10
false
20
```

C)
```text
20
true
30
```

D)
```text
10
true
30
```

---

# PLANTILLA DE RESPUESTAS

1. _____
2. _____
3. _____
4. _____
5. _____
6. _____
7. _____
8. _____
9. _____
10. _____
11. _____
12. _____
13. _____
14. _____
15. _____
16. _____
17. _____
18. _____
19. _____
20. _____
21. _____
22. _____
23. _____
24. _____
25. _____
26. _____
27. _____
28. _____
29. _____
30. _____
31. _____
32. _____
33. _____
34. _____
35. _____
36. _____
37. _____
38. _____
39. _____
40. _____

---

# SOLUCIONES PARA EL PROFESOR

| Pregunta | Correcta | Concepto evaluado |
|---|---|---|
| 1 | A | Creación de arrays |
| 2 | B | Mutabilidad de los arrays |
| 3 | D | Acceso y modificación por índice |
| 4 | B | Constructor `Array()` |
| 5 | A | Inicialización mediante lambda |
| 6 | A | Inicialización de `IntArray` equivalente mediante `Array` |
| 7 | B | Arrays genéricos y especializados |
| 8 | B | Propiedad `size` |
| 9 | C | Función factoría `listOf()` |
| 10 | B | Interfaz `List` |
| 11 | C | Función factoría `mutableSetOf()` |
| 12 | A | Características de `Set` |
| 13 | C | Eliminación de duplicados |
| 14 | B | Función factoría `mapOf()` |
| 15 | B | Acceso a mapas |
| 16 | C | Consulta de claves inexistentes |
| 17 | B | Modificación de mapas |
| 18 | B | Diferencias entre colecciones mutables y no mutables |
| 19 | A | Conversión mediante `toMutableList()` |
| 20 | B | Conversión mediante `toSet()` |
| 21 | B | Copia y modificación de listas |
| 22 | A | Función `copy()` |
| 23 | B | Copia de objetos data class |
| 24 | B | Funciones de conversión |
| 25 | B | Operador `map()` |
| 26 | B | Operador `filter()` |
| 27 | A | Operador `flatMap()` |
| 28 | C | Composición de operadores |
| 29 | B | Operador `fold()` |
| 30 | C | Acumulación de valores |
| 31 | A | Builder `buildList()` |
| 32 | C | Construcción de colecciones |
| 33 | B | Evaluación perezosa |
| 34 | B | Conversión a `Sequence` |
| 35 | B | Operaciones terminales |
| 36 | D | Operaciones terminales |
| 37 | C | Operaciones funcionales con secuencias |
| 38 | A | Interfaz `Iterable` |
| 39 | B | Interfaz `Iterator` |
| 40 | A | Recorrido mediante iteradores |

---

# CRITERIOS DE CORRECCIÓN

- Respuesta correcta: **+0,25 puntos**.
- Respuesta incorrecta: **−0,0625 puntos**.
- Pregunta sin responder: **0 puntos**.

**Puntuación máxima:** 10 puntos.

`Nota = (Aciertos × 0,25) − (Errores × 0,0625)`

---

# DISTRIBUCIÓN DE CONTENIDOS

| Bloque | Preguntas | Número |
|---|---:|---:|
| Arrays y creación | 1-8 | 8 |
| Listas, conjuntos y mapas | 9-17 | 9 |
| Mutabilidad, copias y conversiones | 18-24 | 7 |
| Operadores funcionales y builders | 25-32 | 8 |
| Sequence, Iterable e Iterator | 33-40 | 8 |
| **Total** | **1-40** | **40** |