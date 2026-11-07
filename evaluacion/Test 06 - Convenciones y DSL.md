# EXAMEN DE KOTLIN – UNIDAD 6
## Convenciones, delegación de propiedades, rangos y DSLs

**Ciclo:** 2.º DAM  
**Módulo:** Programación  
**Número de preguntas:** 40  
**Tipo:** Test (4 opciones, una única respuesta correcta)

**Nombre y apellidos:** ______________________________________

**Fecha:** __________________

---

## PARTE 1. CONVENCIONES DEL LENGUAJE

**Pregunta 1.** ¿Qué permite implementar la función `operator fun invoke()` en una clase?

A) Permite utilizar una instancia de la clase como si fuera una función.

B) Permite convertir automáticamente la instancia en una cadena.

C) Permite utilizar la instancia como si fuera un array.

D) Permite crear objetos sin constructor.

**Pregunta 2.** ¿Qué imprime el siguiente código?

```kotlin
class Greeter {
    operator fun invoke(name: String) {
        println("Hola, $name")
    }
}

val greeter = Greeter()
greeter("Ana")
```

A) `Greeter(Ana)`

B) `Hola, Ana`

C) `Ana`

D) Se produce un error porque `greeter` no es una función.

**Pregunta 3.** ¿Qué palabra clave es necesaria para sobrecargar un operador en Kotlin?

A) `override`

B) `operator`

C) `overload`

D) `extension`

**Pregunta 4.** ¿Qué función debe implementar una clase para permitir utilizar el operador `+`?

A) `operator fun add()`

B) `operator fun plus()`

C) `operator fun sum()`

D) `operator fun increment()`

**Pregunta 5.** ¿Qué imprime el siguiente código?

```kotlin
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

val result = Point(2, 3) + Point(4, 5)
println(result)
```

A) `Point(x=2, y=3)`

B) `Point(x=4, y=5)`

C) `Point(x=6, y=8)`

D) `Point(x=8, y=15)`

**Pregunta 6.** ¿Qué función permite implementar el operador `++` en una clase?

A) `operator fun plus()`

B) `operator fun inc()`

C) `operator fun next()`

D) `operator fun increase()`

**Pregunta 7.** ¿Qué permite la desestructuración de objetos en Kotlin?

A) Dividir un objeto en varios objetos independientes.

B) Extraer varios valores de un objeto mediante una declaración de variables.

C) Convertir un objeto en una colección mutable.

D) Crear automáticamente una copia profunda del objeto.

**Pregunta 8.** ¿Qué imprime el siguiente código?

```kotlin
data class User(val name: String, val age: Int)

val (name, age) = User("Ana", 25)

println("$name - $age")
```

A) `User - 25`

B) `Ana - 25`

C) `Ana - User`

D) Se produce un error porque no se puede desestructurar un objeto.

**Pregunta 9.** ¿Qué convenciones utiliza Kotlin para permitir la desestructuración de un objeto?

A) Las funciones `get()` y `set()`.

B) Las funciones `component1()`, `component2()`, etc.

C) Las funciones `copy()` y `equals()`.

D) Las funciones `first()` y `last()`.

---

## PARTE 2. DELEGACIÓN DE PROPIEDADES Y RANGOS

**Pregunta 10.** ¿Qué interfaz debe implementar un delegado de lectura y escritura para una propiedad?

A) `Iterable<T>`

B) `ReadWriteProperty<ThisRef, T>`

C) `MutableList<T>`

D) `PropertyDelegate<T>`

**Pregunta 11.** ¿Qué función debe proporcionar un delegado de propiedad de solo lectura?

A) `getValue()`

B) `setValue()`

C) `provideDelegate()` obligatoriamente.

D) `invoke()`

**Pregunta 12.** ¿Qué imprime el siguiente código?

```kotlin
class Example {
    val message: String by lazy {
        println("Inicializando")
        "Hola Kotlin"
    }
}

val example = Example()

println("Antes")
println(example.message)
println(example.message)
```

A)
```text
Inicializando
Antes
Hola Kotlin
Hola Kotlin
```

B)
```text
Antes
Inicializando
Hola Kotlin
Hola Kotlin
```

C)
```text
Antes
Hola Kotlin
Inicializando
Hola Kotlin
```

D)
```text
Antes
Inicializando
Hola Kotlin
Inicializando
Hola Kotlin
```

**Pregunta 13.** ¿Cuándo se ejecuta normalmente el bloque de inicialización de `lazy`?

A) Cada vez que se consulta la propiedad.

B) Cuando se crea la instancia que contiene la propiedad.

C) La primera vez que se accede a la propiedad.

D) Cuando finaliza el programa.

**Pregunta 14.** ¿Qué permite utilizar `by observable()` en una propiedad mutable?

A) Ejecutar una acción cuando cambia el valor de la propiedad.

B) Convertir la propiedad en constante.

C) Evitar que la propiedad pueda modificarse.

D) Inicializar la propiedad de forma perezosa.

**Pregunta 15.** ¿Qué representa la expresión `1..10` en Kotlin?

A) Un rango que contiene los números del 1 al 9.

B) Un rango que contiene los números del 1 al 10, ambos incluidos.

C) Un rango que contiene exclusivamente el 1 y el 10.

D) Una lista mutable de diez elementos.

**Pregunta 16.** ¿Qué diferencia existe entre `..` y `..<`?

A) `..` excluye el límite superior y `..<` lo incluye.

B) Ambos operadores generan siempre el mismo rango.

C) `..` incluye el límite superior y `..<` lo excluye.

D) `..<` solo puede utilizarse con números decimales.

**Pregunta 17.** ¿Qué representa la expresión `10 downTo 2 step 2`?

A) Los números 10, 8, 6, 4 y 2.

B) Los números 2, 4, 6, 8 y 10.

C) Los números 10, 9, 8, 7 y 6.

D) Los números 10, 8, 6 y 4.

**Pregunta 18.** ¿Qué función permite comprobar si un valor pertenece a un rango?

A) `contains()`

B) `includes()`

C) `inside()`

D) `has()`

---

## PARTE 3. CONVENCIONES EN COLECCIONES

**Pregunta 19.** ¿Qué representa el operador `in` en una expresión como esta?

```kotlin
if (3 in numbers) {
    println("Encontrado")
}
```

A) Comprueba si el valor pertenece a la colección.

B) Añade el valor a la colección.

C) Elimina el valor de la colección.

D) Comprueba si la colección está vacía.

**Pregunta 20.** ¿Qué convención permite implementar el operador `in` en una clase?

A) `operator fun contains(element: T): Boolean`

B) `operator fun include(element: T): Boolean`

C) `operator fun has(element: T): Boolean`

D) `operator fun inside(element: T): Boolean`

**Pregunta 21.** ¿Qué operación representa normalmente `numbers += 5` cuando `numbers` es una colección mutable compatible con esta operación?

A) Elimina el elemento 5.

B) Añade el elemento 5.

C) Multiplica todos los elementos por 5.

D) Sustituye la colección por una colección vacía.

**Pregunta 22.** ¿Qué operación representa normalmente `numbers -= 5` cuando `numbers` es una colección mutable compatible con esta operación?

A) Añade el elemento 5.

B) Elimina el elemento 5.

C) Resta 5 a todos los elementos.

D) Cambia el tamaño de cada elemento.

**Pregunta 23.** ¿Qué imprime el siguiente código?

```kotlin
val numbers = mutableListOf(1, 2, 3)

numbers += 4
numbers -= 2

println(numbers)
```

A) `[1, 2, 3, 4]`

B) `[1, 3, 4]`

C) `[1, 3]`

D) `[2, 4]`

---

## PARTE 4. PATRÓN BUILDER Y CONSTRUCCIÓN DE OBJETOS

**Pregunta 24.** ¿Cuál es el objetivo principal del patrón de diseño Builder?

A) Crear objetos complejos mediante un proceso de construcción paso a paso.

B) Evitar el uso de constructores en cualquier circunstancia.

C) Convertir objetos en colecciones.

D) Permitir que una clase herede de varias clases.

**Pregunta 25.** ¿Qué ventaja ofrece el patrón Builder frente a un constructor con muchos parámetros?

A) Permite construir objetos mediante pasos más claros y configurables.

B) Elimina la necesidad de definir propiedades.

C) Impide que existan valores por defecto.

D) Hace que todos los objetos sean singletons.

**Pregunta 26.** ¿Qué característica de Kotlin facilita especialmente la implementación de builders mediante DSLs?

A) Las lambdas con receptor.

B) Las clases abstractas exclusivamente.

C) Los arrays primitivos.

D) Las excepciones comprobadas.

**Pregunta 27.** ¿Qué imprime el siguiente código?

```kotlin
class UserBuilder {
    var name: String = ""
    var age: Int = 0

    fun build(): String {
        return "$name - $age"
    }
}

val user = UserBuilder().apply {
    name = "Ana"
    age = 25
}.build()

println(user)
```

A) ` - 0`

B) `Ana - 25`

C) `UserBuilder`

D) Se produce un error porque `apply` no permite modificar propiedades.

---

## PARTE 5. LAMBDAS CON RECEPTOR Y EXTENSIONES

**Pregunta 28.** ¿Qué diferencia existe entre una función de tipo `(String) -> Unit` y una función de tipo `String.() -> Unit`?

A) No existe ninguna diferencia.

B) La segunda tiene un receptor de tipo `String`, accesible mediante `this`.

C) La primera siempre devuelve una cadena.

D) La segunda no puede utilizarse con lambdas.

**Pregunta 29.** ¿Qué imprime el siguiente código?

```kotlin
val action: String.() -> String = {
    uppercase()
}

println("kotlin".action())
```

A) `kotlin`

B) `Kotlin`

C) `KOTLIN`

D) Se produce un error porque `action` no es una función.

**Pregunta 30.** ¿Qué es una función de extensión en Kotlin?

A) Una función que permite añadir nuevos miembros a una clase modificando su código fuente.

B) Una función que permite llamar a una operación como si perteneciera a un tipo, sin modificar realmente su clase.

C) Una función que solo puede utilizarse dentro de una clase abstracta.

D) Una función que siempre debe ser `inline`.

**Pregunta 31.** ¿Qué imprime el siguiente código?

```kotlin
fun String.addExclamation(): String {
    return "$this!"
}

println("Hola".addExclamation())
```

A) `Hola`

B) `!Hola`

C) `Hola!`

D) `addExclamation`

**Pregunta 32.** ¿Qué característica tiene una función infija en Kotlin?

A) Se puede invocar sin utilizar el punto ni los paréntesis, cumpliendo las condiciones de las funciones infijas.

B) Solo puede recibir dos parámetros de forma obligatoria.

C) No puede ser una función de extensión.

D) Siempre devuelve un valor booleano.

**Pregunta 33.** ¿Cuál de las siguientes declaraciones permite definir una función infija válida?

A)
```kotlin
infix fun Int.times(value: Int): Int = this * value
```

B)
```kotlin
infix fun Int.times(a: Int, b: Int): Int = a * b
```

C)
```kotlin
fun infix Int.times(value: Int): Int = this * value
```

D)
```kotlin
infix Int fun times(value: Int): Int = this * value
```

**Pregunta 34.** ¿Qué resultado produce el siguiente código?

```kotlin
infix fun Int.times(value: Int): Int = this * value

val result = 3 times 4

println(result)
```

A) `7`

B) `12`

C) `34`

D) Se produce un error porque `times` debe utilizarse con un punto.

---

## PARTE 6. CONSTRUCCIÓN DE DSLs

**Pregunta 35.** ¿Qué es un DSL (*Domain Specific Language*)?

A) Un lenguaje diseñado para resolver problemas de un dominio concreto.

B) Un lenguaje que sustituye obligatoriamente a Kotlin.

C) Un lenguaje que solo permite trabajar con bases de datos.

D) Una biblioteca que convierte Kotlin en Java.

**Pregunta 36.** ¿Qué característica de Kotlin permite escribir construcciones DSL de forma más natural?

A) Las lambdas con receptor.

B) Los tipos primitivos exclusivamente.

C) La herencia múltiple de clases.

D) La ausencia de funciones de extensión.

**Pregunta 37.** ¿Qué permite la siguiente declaración?

```kotlin
fun html(block: HtmlBuilder.() -> Unit): HtmlBuilder {
    return HtmlBuilder().apply(block)
}
```

A) Ejecutar una lambda cuyo receptor es `HtmlBuilder`, permitiendo acceder a sus miembros directamente.

B) Crear automáticamente un documento HTML válido sin necesidad de implementar `HtmlBuilder`.

C) Convertir una cadena en una página web.

D) Ejecutar una lambda que no puede acceder a las propiedades de `HtmlBuilder`.

**Pregunta 38.** En un DSL HTML de Kotlin, ¿qué ventaja ofrece utilizar funciones con receptor para representar elementos como `body`, `div` o `p`?

A) Permite construir una estructura anidada de elementos mediante bloques lambda.

B) Permite eliminar todas las etiquetas HTML.

C) Impide anidar elementos.

D) Convierte automáticamente cualquier etiqueta en una clase de Kotlin.

**Pregunta 39.** Observa el siguiente ejemplo simplificado:

```kotlin
class HtmlBuilder {
    fun body(block: BodyBuilder.() -> Unit) {
        println("Inicio body")
        BodyBuilder().block()
        println("Fin body")
    }
}

class BodyBuilder {
    fun p(text: String) {
        println("<p>$text</p>")
    }
}

fun html(block: HtmlBuilder.() -> Unit) {
    HtmlBuilder().block()
}

html {
    body {
        p("Hola Kotlin")
    }
}
```

¿Qué imprime el programa?

A)
```text
<p>Hola Kotlin</p>
Inicio body
Fin body
```

B)
```text
Inicio body
<p>Hola Kotlin</p>
Fin body
```

C)
```text
Inicio body
Fin body
<p>Hola Kotlin</p>
```

D) Se produce un error porque no se pueden anidar lambdas con receptor.

**Pregunta 40.** ¿Cuál de las siguientes afirmaciones describe mejor cómo se construye un DSL en Kotlin?

A) Se basa exclusivamente en crear clases abstractas e interfaces.

B) Combina características como funciones de extensión, lambdas con receptor, funciones infijas, operadores y propiedades para crear una sintaxis expresiva.

C) Requiere utilizar obligatoriamente reflexión y anotaciones.

D) Solo se puede implementar utilizando clases `data`.

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
| 1 | A | Convención `invoke` |
| 2 | B | Invocación de objetos |
| 3 | B | Sobrecarga de operadores |
| 4 | B | Operador `plus` |
| 5 | C | Sobrecarga del operador `+` |
| 6 | B | Operador `inc` |
| 7 | B | Desestructuración |
| 8 | B | Desestructuración de data classes |
| 9 | B | Convenciones `componentN` |
| 10 | B | Delegados de propiedades |
| 11 | A | Delegados de solo lectura |
| 12 | B | Inicialización perezosa |
| 13 | C | Funcionamiento de `lazy` |
| 14 | A | Delegado `observable` |
| 15 | B | Rangos inclusivos |
| 16 | C | Rangos abiertos por el extremo superior |
| 17 | A | Rangos descendentes y `step` |
| 18 | A | Comprobación de pertenencia |
| 19 | A | Operador `in` |
| 20 | A | Convención `contains` |
| 21 | B | Operador `+=` |
| 22 | B | Operador `-=` |
| 23 | B | Modificación de colecciones |
| 24 | A | Patrón Builder |
| 25 | A | Ventajas del patrón Builder |
| 26 | A | Lambdas con receptor |
| 27 | B | Construcción mediante `apply` |
| 28 | B | Tipos función con receptor |
| 29 | C | Invocación de funciones con receptor |
| 30 | B | Funciones de extensión |
| 31 | C | Extensiones de `String` |
| 32 | A | Funciones infijas |
| 33 | A | Sintaxis de funciones infijas |
| 34 | B | Invocación infija |
| 35 | A | Concepto de DSL |
| 36 | A | Lambdas con receptor en DSL |
| 37 | A | Funciones con receptor |
| 38 | A | Anidamiento de estructuras DSL |
| 39 | B | Ejecución de DSL anidado |
| 40 | B | Características de Kotlin para crear DSLs |

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
| Convenciones: invoke, operadores y desestructuración | 1-9 | 9 |
| Delegación de propiedades y rangos | 10-18 | 9 |
| Convenciones en colecciones | 19-23 | 5 |
| Patrón Builder | 24-27 | 4 |
| Lambdas con receptor y extensiones | 28-34 | 7 |
| Construcción de DSLs | 35-40 | 6 |
| **Total** | **1-40** | **40** |