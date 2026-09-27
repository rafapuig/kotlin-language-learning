# Ejercicios: Type Erasure y `reified` en Kotlin

## Objetivos

En estos ejercicios practicarás:

* Comprender qué ocurre con los tipos genéricos en tiempo de ejecución.
* Identificar las limitaciones producidas por **type erasure**.
* Comprender por qué no siempre es posible utilizar `T` en comprobaciones de tipo.
* Utilizar funciones `inline`.
* Utilizar parámetros de tipo `reified`.
* Comprobar tipos en tiempo de ejecución mediante `is`.
* Obtener la clase asociada a un tipo genérico.
* Comparar soluciones con y sin `reified`.

---

# 1. ¿Qué tipo es `T`?

Observa la siguiente función:

```kotlin
fun <T> showType(value: T) {
    println(value::class)
}
```

Prueba la función con diferentes tipos:

```kotlin
showType(10)
showType("Hello")
showType(3.14)
showType(true)
```

### Preguntas

1. ¿Qué tipo se muestra en cada caso?
2. ¿La función conoce el tipo concreto de `T` durante su ejecución?
3. ¿Qué diferencia existe entre conocer el tipo del objeto `value` y conocer el parámetro de tipo `T`?

---

# 2. El problema de `is T`

Intenta implementar la siguiente función:

```kotlin
fun <T> isType(value: Any): Boolean {
    return value is T
}
```

El compilador no permite esta implementación.

### Tareas

1. Comprueba el error que produce Kotlin.
2. Investiga por qué no se puede utilizar `is T`.
3. Explica qué relación tiene este problema con el **type erasure**.

---

# 3. Comparar dos objetos con `T`

Crea una función genérica:

```kotlin
fun <T> areEqual(first: T, second: T): Boolean
```

que determine si los dos valores tienen el mismo tipo concreto.

Por ejemplo:

```text
10 y 20       → true
"Hello" y "Hi" → true
10 y "Hello"  → false
```

### Restricción

No puedes utilizar `reified`.

Investiga si es posible implementar la función utilizando únicamente `T`.

Si no es posible, modifica el diseño para recibir explícitamente la información necesaria.

---

# 4. Pasar la clase como parámetro

Modifica el ejercicio anterior para recibir también la clase que se quiere comprobar.

Puedes utilizar:

```kotlin
KClass<T>
```

El objetivo es poder hacer algo conceptualmente parecido a:

```kotlin
isType(10, Int::class)
isType("Hello", String::class)
```

### Preguntas

* ¿Qué información aporta `KClass<T>`?
* ¿Por qué esta solución evita el problema de type erasure?
* ¿Qué inconveniente tiene respecto a utilizar `reified`?

---

# 5. Primera función `reified`

Crea una función:

```kotlin
inline fun <reified T> isType(value: Any): Boolean
```

que determine si `value` es de tipo `T`.

Debería permitir:

```kotlin
isType<Int>(10)
isType<String>("Hello")
isType<Double>(10)
```

### Objetivo

Comprueba que ahora sí puedes utilizar:

```kotlin
value is T
```

Explica por qué `reified` permite hacerlo.

---

# 6. `reified` y `when`

Crea una función genérica:

```kotlin
inline fun <reified T> describe(value: Any)
```

La función debe comprobar si `value` es de tipo `T`.

Prueba diferentes llamadas:

```kotlin
describe<Int>(10)
describe<String>("Hello")
describe<Double>(3.14)
```

Después modifica la función para mostrar mensajes diferentes cuando el objeto sea:

* `Int`
* `String`
* `Double`
* cualquier otro tipo.

### Restricción

No puedes utilizar `value::class` para resolver el ejercicio.

Debes utilizar comprobaciones de tipo.

---

# 7. Convertir utilizando `reified`

Crea una función:

```kotlin
inline fun <reified T> convert(value: Any): T?
```

La función debe devolver `value` convertido a `T` si el objeto es compatible con ese tipo.

Si no es compatible, debe devolver `null`.

Ejemplos conceptuales:

```text
convert<Int>(10)          → 10
convert<String>("Hello")  → "Hello"
convert<Int>("Hello")     → null
```

### Pista

Investiga cómo combinar:

```kotlin
is T
```

con un cast seguro.

---

# 8. `as? T` y type erasure

Intenta implementar:

```kotlin
fun <T> convert(value: Any): T?
```

utilizando:

```kotlin
value as? T
```

Comprueba qué ocurre.

Después crea una versión:

```kotlin
inline fun <reified T> convert(value: Any): T?
```

### Preguntas

1. ¿Qué problema aparece en la primera versión?
2. ¿Por qué `reified` permite solucionarlo?
3. ¿Qué diferencia hay entre un cast realizado con información de tipo disponible y uno afectado por type erasure?

---

# 9. Buscar un elemento de un tipo determinado

Crea una clase:

```kotlin
class Box<T>(val value: T)
```

Después crea una función que reciba un objeto de tipo `Any` y determine si contiene un `Box` cuyo contenido sea de tipo `T`.

Por ejemplo:

```text
Box(10)       → buscar Int → true
Box("Hello")  → buscar Int → false
```

Primero intenta resolverlo **sin `reified`**.

Después crea una versión:

```kotlin
inline fun <reified T> ...
```

### Objetivo

Comprender una situación real en la que el tipo genérico necesita estar disponible en tiempo de ejecución.

---

# 10. Fábrica genérica

Crea una función:

```kotlin
inline fun <reified T> create(): T?
```

La función debe intentar crear un objeto de tipo `T`.

Investiga qué dificultades aparecen al intentar hacer algo como:

```kotlin
T()
```

### Preguntas

1. ¿Puede `reified` resolver directamente este problema?
2. ¿Qué información adicional necesitarías para poder crear una instancia?
3. ¿Qué diferencia hay entre conocer la clase de `T` y disponer de un constructor adecuado?

---

# 11. Obtener `KClass<T>` mediante `reified`

Crea una función:

```kotlin
inline fun <reified T> getType()
```

que muestre la clase asociada a `T`.

Debería ser posible hacer:

```kotlin
getType<Int>()
getType<String>()
getType<Person>()
```

Investiga cómo obtener:

```kotlin
T::class
```

dentro de una función genérica.

### Pregunta

¿Por qué `T::class` tampoco es posible en una función genérica normal?

---

# 12. Comparar tipos con `reified`

Crea:

```kotlin
inline fun <reified T, reified R> sameType(): Boolean
```

La función debe indicar si `T` y `R` representan el mismo tipo.

Ejemplos:

```text
sameType<Int, Int>()       → true
sameType<Int, String>()    → false
sameType<String, String>() → true
```

### Objetivo

Utilizar dos parámetros de tipo `reified` dentro de la misma función.

---

# 13. Detectar una instancia de una clase genérica

Crea:

```kotlin
class Container<T>(val value: T)
```

Ahora intenta crear:

```kotlin
fun isIntContainer(value: Any): Boolean
```

que determine si `value` es un `Container<Int>`.

Primero intenta hacerlo directamente mediante:

```kotlin
value is Container<Int>
```

Observa el error del compilador.

Después crea una solución utilizando `reified`.

### Pregunta importante

¿Por qué `reified` permite comprobar `T` pero no hace que automáticamente puedas comprobar cualquier tipo genérico compuesto como `Container<Int>`?

---

# 14. Función genérica para ejecutar una acción según el tipo

Crea:

```kotlin
inline fun <reified T> execute(value: Any)
```

La función debe ejecutar un comportamiento diferente dependiendo de `T`.

Por ejemplo:

```text
T = Int     → mostrar "Processing integer"
T = String  → mostrar "Processing string"
T = Double  → mostrar "Processing double"
```

Si `T` es otro tipo:

```text
→ mostrar "Unknown type"
```

### Restricción

No puedes recibir `KClass<T>` como parámetro.

Debes utilizar exclusivamente `reified`.

---

# 15. Reified frente a `KClass`

Implementa dos versiones de una misma funcionalidad.

### Versión A

Utiliza:

```kotlin
KClass<T>
```

### Versión B

Utiliza:

```kotlin
inline fun <reified T>
```

La funcionalidad será comprobar si un objeto pertenece al tipo indicado.

Por ejemplo:

```text
isType(10, Int::class)
isType<Int>(10)
```

### Preguntas

Compara ambas soluciones:

1. ¿Cuál necesita pasar explícitamente la clase?
2. ¿Cuál permite inferir el tipo mediante el argumento de tipo?
3. ¿Cuál necesita `inline`?
4. ¿Cuál puede utilizar `is T`?
5. ¿Qué ventajas y desventajas tiene cada diseño?

---

# 16. Reified con una interfaz genérica

Crea:

```kotlin
interface Processor<T> {
    fun process(value: T)
}
```

y varias implementaciones:

```text
IntProcessor
StringProcessor
DoubleProcessor
```

Después crea una función:

```kotlin
inline fun <reified T> processIfCorrect(
    value: Any,
    processor: Processor<T>
)
```

La función solamente debe ejecutar `processor` si `value` es realmente de tipo `T`.

### Objetivo

Combinar:

* Interfaces genéricas.
* Type erasure.
* `reified`.
* Comprobación de tipos en tiempo de ejecución.

---

# 17. Reto: localizar el problema de type erasure

Analiza las siguientes funciones:

```kotlin
fun <T> function1(value: T) {
    println(value)
}
```

```kotlin
fun <T> function2(value: T) {
    println(value!!::class)
}
```

```kotlin
inline fun <reified T> function3(value: T) {
    println(T::class)
}
```

Determina cuáles pueden conocer información sobre el tipo durante la ejecución y cuáles no.

Explica el motivo en cada caso.

---

# 18. Reto final: `typeOf`

Investiga la API:

```kotlin
typeOf<T>()
```

y la anotación:

```kotlin
@OptIn(ExperimentalStdlibApi::class)
```

Crea una función:

```kotlin
inline fun <reified T> showType()
```

que muestre información sobre el tipo `T` utilizando `typeOf<T>()`.

Prueba con:

```text
Int
String
List<Int>
List<String>
Pair<Int, String>
```

### Preguntas

1. ¿Qué diferencia observas entre `T::class` y `typeOf<T>()`?
2. ¿Qué información adicional proporciona `typeOf<T>()`?
3. ¿Qué relación tiene esto con el problema del type erasure?

---

# 19. Reto final: sistema de conversión

Diseña un pequeño sistema genérico de conversión.

Debe existir una función:

```kotlin
inline fun <reified T> parse(value: String): T?
```

Debe permitir convertir cadenas a algunos tipos concretos:

```text
"25"   → Int
"3.14" → Double
"true" → Boolean
"Hello" → String
```

Si se solicita un tipo no soportado, debe devolver `null`.

Por ejemplo:

```kotlin
parse<Int>("25")
parse<Double>("3.14")
parse<Boolean>("true")
```

### Restricción

La función debe utilizar `reified` para decidir qué conversión realizar.

No se permite pasar `KClass<T>` como argumento.

---

# 20. Reto de reflexión

Crea una función:

```kotlin
inline fun <reified T> describeType()
```

que muestre:

* El nombre de la clase.
* Si el tipo es nullable.
* Su representación mediante `typeOf<T>()`.

Prueba con tipos como:

```text
Int
String
Int?
String?
List<Int>
List<String>
```

### Objetivo

Comprender que `reified` no solamente permite utilizar `is T`, sino que también permite acceder a información del tipo en tiempo de ejecución.

---

# Ejercicio de investigación

Sin ejecutar el programa, razona qué sucede en cada caso:

```kotlin
fun <T> test(value: Any) {
    // ¿Se puede hacer value is T?
}
```

```kotlin
inline fun <reified T> test(value: Any) {
    // ¿Se puede hacer value is T?
}
```

Y responde:

1. ¿Qué es el type erasure?
2. ¿Por qué los tipos genéricos normalmente no están disponibles en tiempo de ejecución?
3. ¿Qué significa que un tipo sea `reified`?
4. ¿Por qué una función `reified` debe ser `inline`?
5. ¿Qué operaciones permite hacer `reified` que no permite un parámetro de tipo normal?
6. ¿Cuándo puede ser preferible utilizar `KClass<T>` en lugar de `reified`?
7. ¿Qué información adicional aporta `typeOf<T>()`?
