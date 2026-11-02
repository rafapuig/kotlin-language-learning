# Operaciones de orden superior en Kotlin

## 1. Introducción

Kotlin proporciona numerosas funciones para trabajar con arrays, listas, conjuntos y mapas de forma funcional.

Muchas de estas funciones reciben otra función como argumento. Por este motivo, se denominan **funciones de orden superior**.

Por ejemplo:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

val evenNumbers = numbers.filter { it % 2 == 0 }

println(evenNumbers) // [2, 4, 6]
```

En este ejemplo, `filter` recibe una función que determina qué elementos deben conservarse.

En las tablas siguientes utilizaremos estas abreviaturas:

- `A`: `Array<T>`.
- `L`: `List<T>`.
- `S`: `Set<T>`.
- `M`: `Map<K, V>`.
- `R`: tipo de resultado calculado por una función.
- `P`: `Pair<A, B>`.

Las funciones indicadas son, en general, aplicables a arrays, listas y conjuntos, salvo que se especifique lo contrario. En los mapas, algunas operaciones trabajan con las entradas (`Map.Entry<K, V>`), mientras que otras trabajan específicamente con las claves o los valores.

---

## 2. Transformación de elementos

Permiten convertir los elementos de un contenedor en otros valores.

| Función | Descripción | Tipo de retorno habitual |
|---|---|---|
| `map { }` | Transforma cada elemento. | `List<R>` |
| `mapIndexed { }` | Transforma cada elemento utilizando también su índice. | `List<R>` |
| `mapNotNull { }` | Transforma los elementos y descarta los resultados `null`. | `List<R>` |
| `mapIndexedNotNull { }` | Igual que `mapNotNull`, pero proporciona también el índice. | `List<R>` |
| `flatMap { }` | Transforma cada elemento en una colección y aplana los resultados. | `List<R>` |
| `flatMapIndexed { }` | Igual que `flatMap`, proporcionando también el índice. | `List<R>` |
| `flatten()` | Aplana una colección de colecciones. | `List<T>` |
| `zip(other)` | Combina elementos de dos contenedores por parejas. | `List<Pair<T, R>>` |
| `zip(other) { }` | Combina dos elementos mediante una función. | `List<R>` |
| `associate { }` | Construye un mapa a partir de pares calculados. | `Map<K, V>` |
| `associateBy { }` | Utiliza una propiedad calculada como clave. | `Map<K, T>` |
| `associateWith { }` | Utiliza los elementos como claves y calcula sus valores. | `Map<T, R>` |

### Ejemplos

```kotlin
val numbers = listOf(1, 2, 3, 4)

println(numbers.map { it * 2 })
// [2, 4, 6, 8]

println(numbers.mapIndexed { index, value -> index + value })
// [1, 3, 5, 7]

println(numbers.mapNotNull {
    if (it % 2 == 0) it * 10 else null
})
// [20, 40]

println(numbers.flatMap { listOf(it, it * 10) })
// [1, 10, 2, 20, 3, 30, 4, 40]

println(numbers.associateWith { it * it })
// {1=1, 2=4, 3=9, 4=16}
```

**Observación:** `map` conserva un resultado por cada elemento, mientras que `flatMap` permite generar varios resultados por elemento.

---

## 3. Filtrado de elementos

Permiten seleccionar los elementos que cumplen determinadas condiciones.

| Función | Descripción | Tipo de retorno habitual |
|---|---|---|
| `filter { }` | Conserva los elementos que cumplen la condición. | `List<T>` |
| `filterNot { }` | Conserva los elementos que no cumplen la condición. | `List<T>` |
| `filterIndexed { }` | Filtra utilizando también el índice. | `List<T>` |
| `filterNotNull()` | Elimina los elementos nulos. | `List<T no nulo>` |
| `filterIsInstance<R>()` | Conserva los elementos del tipo indicado. | `List<R>` |
| `partition { }` | Divide los elementos en dos grupos según una condición. | `Pair<List<T>, List<T>>` |
| `distinct()` | Elimina elementos duplicados. | `List<T>` |
| `distinctBy { }` | Elimina duplicados según una clave calculada. | `List<T>` |
| `filterKeys { }` | Filtra las entradas de un mapa según sus claves. | `Map<K, V>` |
| `filterValues { }` | Filtra las entradas de un mapa según sus valores. | `Map<K, V>` |
| `filter { }` sobre un mapa | Filtra las entradas del mapa. | `Map<K, V>` |

### Ejemplos

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

println(numbers.filter { it % 2 == 0 })
// [2, 4, 6]

println(numbers.filterNot { it > 3 })
// [1, 2, 3]

println(numbers.partition { it % 2 == 0 })
// ([2, 4, 6], [1, 3, 5])

println(numbers.distinctBy { it % 3 })
// [1, 2, 3]
```

Ejemplo con mapas:

```kotlin
val prices = mapOf(
    "book" to 10,
    "pen" to 2,
    "bag" to 25
)

println(prices.filterValues { it > 5 })
// {book=10, bag=25}

println(prices.filterKeys { it.startsWith("b") })
// {book=10, bag=25}
```

---

## 4. Agregación y reducción

Permiten calcular un único resultado a partir de los elementos de un contenedor.

| Función | Descripción | Tipo de retorno |
|---|---|---|
| `count { }` | Cuenta los elementos que cumplen una condición. | `Int` |
| `sumOf { }` | Suma los valores calculados. | Numérico |
| `average()` | Calcula la media aritmética. | `Double` |
| `minOrNull()` | Obtiene el menor elemento o `null`. | `T?` |
| `maxOrNull()` | Obtiene el mayor elemento o `null`. | `T?` |
| `minByOrNull { }` | Obtiene el elemento con menor valor calculado. | `T?` |
| `maxByOrNull { }` | Obtiene el elemento con mayor valor calculado. | `T?` |
| `minOf { }` | Obtiene el menor resultado de una transformación. | `R` |
| `maxOf { }` | Obtiene el mayor resultado de una transformación. | `R` |
| `fold(initial) { }` | Acumula los elementos a partir de un valor inicial. | `R` |
| `reduce { }` | Acumula los elementos utilizando el primero como inicial. | `T` |
| `runningFold(initial) { }` | Devuelve los acumulados intermedios, incluido el inicial. | `List<R>` |
| `runningReduce { }` | Devuelve los acumulados intermedios. | `List<T>` |
| `joinToString()` | Construye una cadena con los elementos. | `String` |

### Ejemplos

```kotlin
val numbers = listOf(1, 2, 3, 4)

println(numbers.count { it > 2 })
// 2

println(numbers.sumOf { it * 2 })
// 20

println(numbers.average())
// 2.5

println(numbers.fold(0) { acc, n -> acc + n })
// 10

println(numbers.reduce { acc, n -> acc * n })
// 24

println(numbers.runningFold(0) { acc, n -> acc + n })
// [0, 1, 3, 6, 10]
```

### Diferencia entre `fold` y `reduce`

`fold` recibe un valor inicial:

```kotlin
val result = listOf(1, 2, 3).fold(10) { acc, n ->
    acc + n
}

println(result) // 16
```

`reduce` utiliza el primer elemento como acumulador inicial:

```kotlin
val result = listOf(1, 2, 3).reduce { acc, n ->
    acc + n
}

println(result) // 6
```

**Importante:** `reduce` falla si el contenedor está vacío. `fold`, en cambio, puede trabajar con un contenedor vacío porque dispone de un valor inicial.

---

## 5. Búsqueda y comprobación de condiciones

Permiten buscar elementos o comprobar si se cumple una condición.

| Función | Descripción | Tipo de retorno |
|---|---|---|
| `any { }` | Comprueba si algún elemento cumple la condición. | `Boolean` |
| `all { }` | Comprueba si todos los elementos cumplen la condición. | `Boolean` |
| `none { }` | Comprueba si ningún elemento cumple la condición. | `Boolean` |
| `find { }` | Obtiene el primer elemento que cumple la condición. | `T?` |
| `findLast { }` | Obtiene el último elemento que cumple la condición. | `T?` |
| `firstOrNull { }` | Obtiene el primero que cumple o `null`. | `T?` |
| `lastOrNull { }` | Obtiene el último que cumple o `null`. | `T?` |
| `first { }` | Obtiene el primero que cumple; falla si no existe. | `T` |
| `last { }` | Obtiene el último que cumple; falla si no existe. | `T` |
| `singleOrNull { }` | Obtiene el único elemento que cumple o `null`. | `T?` |
| `indexOfFirst { }` | Obtiene el índice del primer elemento que cumple. | `Int` |
| `indexOfLast { }` | Obtiene el índice del último elemento que cumple. | `Int` |

### Ejemplos

```kotlin
val numbers = listOf(2, 4, 7, 8)

println(numbers.any { it % 2 != 0 })
// true

println(numbers.all { it > 0 })
// true

println(numbers.none { it < 0 })
// true

println(numbers.find { it % 2 != 0 })
// 7

println(numbers.indexOfFirst { it > 5 })
// 2
```

**Observación:** `indexOfFirst` y `indexOfLast` requieren un contenedor con índices, como un array o una lista. No son las operaciones adecuadas para un `Set` o un `Map`.

---

## 6. Ordenación

Permiten obtener los elementos en un orden determinado.

| Función | Descripción | Tipo de retorno |
|---|---|---|
| `sorted()` | Ordena de forma ascendente. | `List<T>` |
| `sortedDescending()` | Ordena de forma descendente. | `List<T>` |
| `sortedBy { }` | Ordena según una propiedad calculada. | `List<T>` |
| `sortedByDescending { }` | Ordena según una propiedad calculada, descendentemente. | `List<T>` |
| `sortedWith(comparator)` | Ordena mediante un comparador. | `List<T>` |
| `reversed()` | Devuelve los elementos en orden inverso. | `List<T>` |
| `shuffled()` | Devuelve los elementos en orden aleatorio. | `List<T>` |
| `toSortedSet()` | Crea un conjunto ordenado. | `SortedSet<T>` |
| `toSortedMap()` | Crea un mapa ordenado por claves. | `SortedMap<K, V>` |

### Ejemplos

```kotlin
val names = listOf("Luis", "Ana", "Roberto")

println(names.sorted())
// [Ana, Luis, Roberto]

println(names.sortedBy { it.length })
// [Ana, Luis, Roberto]

println(names.sortedByDescending { it.length })
// [Roberto, Luis, Ana]

println(names.reversed())
// [Roberto, Ana, Luis]
```

---

## 7. Selección de partes de una colección

Permiten obtener una parte de los elementos.

| Función | Descripción | Tipo de retorno habitual |
|---|---|---|
| `take(n)` | Obtiene los primeros `n` elementos. | `List<T>` |
| `takeLast(n)` | Obtiene los últimos `n` elementos. | `List<T>` |
| `takeWhile { }` | Obtiene elementos iniciales mientras se cumpla la condición. | `List<T>` |
| `takeLastWhile { }` | Obtiene elementos finales mientras se cumpla la condición. | `List<T>` |
| `drop(n)` | Descarta los primeros `n` elementos. | `List<T>` |
| `dropLast(n)` | Descarta los últimos `n` elementos. | `List<T>` |
| `dropWhile { }` | Descarta elementos iniciales mientras se cumpla la condición. | `List<T>` |
| `dropLastWhile { }` | Descarta elementos finales mientras se cumpla la condición. | `List<T>` |
| `slice(indices)` | Selecciona los índices indicados. | `List<T>` |
| `chunked(n)` | Divide los elementos en grupos de hasta `n`. | `List<List<T>>` |
| `windowed(n)` | Genera ventanas deslizantes de tamaño `n`. | `List<List<T>>` |

### Ejemplos

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

println(numbers.take(3))
// [1, 2, 3]

println(numbers.drop(2))
// [3, 4, 5, 6]

println(numbers.takeWhile { it < 4 })
// [1, 2, 3]

println(numbers.chunked(2))
// [[1, 2], [3, 4], [5, 6]]

println(numbers.windowed(3))
// [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6]]
```

---

## 8. Operaciones específicas de mapas

Estas operaciones permiten transformar claves y valores o seleccionar entradas.

| Función | Descripción | Tipo de retorno |
|---|---|---|
| `mapKeys { }` | Transforma las claves. | `Map<R, V>` |
| `mapValues { }` | Transforma los valores. | `Map<K, R>` |
| `filterKeys { }` | Filtra por clave. | `Map<K, V>` |
| `filterValues { }` | Filtra por valor. | `Map<K, V>` |
| `filter { }` | Filtra las entradas del mapa. | `Map<K, V>` |
| `toList()` | Convierte las entradas en pares. | `List<Pair<K, V>>` |
| `toSortedMap()` | Ordena las entradas por clave. | `SortedMap<K, V>` |
| `getOrElse(key) { }` | Proporciona un valor alternativo si la clave no está presente. | `V` |

### Ejemplos

```kotlin
val prices = mapOf(
    "book" to 10,
    "pen" to 2,
    "bag" to 25
)

println(prices.mapValues { it.value * 2 })
// {book=20, pen=4, bag=50}

println(prices.mapKeys { it.key.uppercase() })
// {BOOK=10, PEN=2, BAG=25}

println(prices.filterValues { it > 5 })
// {book=10, bag=25}

println(prices.toList())
// [(book, 10), (pen, 2), (bag, 25)]
```

---

## 9. Diferencias entre los tipos de contenedor

Aunque muchas funciones se pueden utilizar sobre arrays, listas y conjuntos, el tipo de retorno no tiene por qué coincidir con el tipo original.

| Operación | Array | List | Set | Map |
|---|---|---|---|---|
| `map { }` | Devuelve `List<R>` | Devuelve `List<R>` | Devuelve `List<R>` | Devuelve una lista al mapear entradas |
| `filter { }` | Devuelve `List<T>` | Devuelve `List<T>` | Devuelve `List<T>` | Devuelve `Map<K, V>` al filtrar entradas |
| `sorted()` | Devuelve `List<T>` | Devuelve `List<T>` | Devuelve `List<T>` | No es una operación directa sobre las claves y valores del mapa |
| `fold()` | Devuelve el acumulador | Devuelve el acumulador | Devuelve el acumulador | Puede reducir las entradas |
| `forEach { }` | Devuelve `Unit` | Devuelve `Unit` | Devuelve `Unit` | Devuelve `Unit` |

Por ejemplo:

```kotlin
val numbers = setOf(1, 2, 3)

val doubled = numbers.map { it * 2 }

println(doubled) // [2, 4, 6]
```

Aunque el origen es un conjunto, el resultado es una lista.

Si se necesita un conjunto como resultado:

```kotlin
val doubled = numbers.map { it * 2 }.toSet()
```

---

## 10. Recomendaciones de uso

1. Utiliza `map` cuando quieras transformar todos los elementos.
2. Utiliza `filter` cuando quieras seleccionar elementos.
3. Utiliza `flatMap` cuando cada elemento pueda generar varios resultados.
4. Utiliza `fold` cuando necesites acumular un resultado con un valor inicial.
5. Utiliza `reduce` cuando el primer elemento pueda actuar como valor inicial.
6. Utiliza `any`, `all` y `none` para comprobar condiciones.
7. Utiliza `groupBy` cuando quieras agrupar elementos según una propiedad.
8. Utiliza `associateBy` o `associateWith` cuando quieras construir un mapa a partir de una colección.
9. Comprueba el tipo de retorno de cada operación: no siempre coincide con el tipo del contenedor original.
10. Recuerda que `List`, `Set` y `Map` son interfaces de solo lectura; eso no garantiza por sí solo que el objeto subyacente sea inmutable.

### Documentación oficial

- [Operaciones sobre colecciones](https://kotlinlang.org/docs/collection-operations.html)
- [Operaciones sobre listas](https://kotlinlang.org/docs/list-operations.html)
- [Operaciones sobre mapas](https://kotlinlang.org/docs/map-operations.html)
- [Arrays](https://kotlinlang.org/docs/arrays.html)
