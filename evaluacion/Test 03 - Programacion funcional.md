# TEST 3 – PROGRAMACIÓN FUNCIONAL EN KOTLIN

**Ciclo:** 2.º de Desarrollo de Aplicaciones Multiplataforma (DAM)  
**Módulo:** Programación  
**Unidad:** Programación funcional en Kotlin  
**Número de preguntas:** 40  
**Tipo:** Respuesta múltiple (una única respuesta correcta)

**Nombre y apellidos:** __________________________________

**Fecha:** __________________

---

# Preguntas

### Pregunta 1. Expresiones lambda

¿Cuál de las siguientes declaraciones representa correctamente una expresión lambda que recibe dos números enteros y devuelve su suma?

A)

```kotlin
val sum = (a: Int, b: Int) -> a + b
```

B)

```kotlin
val sum = { a: Int, b: Int -> a + b }
```

C)

```kotlin
val sum = { a, b: Int -> a + b }
```

D)

```kotlin
val sum = lambda(a: Int, b: Int) { a + b }
```

---

### Pregunta 2. Parámetros de una lambda

¿Qué imprime el siguiente código?

```kotlin
val operation: (Int, Int) -> Int = { a, b ->
    a * b
}

println(operation(4, 5))
```

A) 9.

B) 20.

C) 45.

D) Se produce un error porque una lambda no puede recibir dos parámetros.

---

### Pregunta 3. Inferencia de tipos en lambdas

¿Qué afirmación es correcta sobre el siguiente código?

```kotlin
val operation: (Int) -> Int = {
    it * 2
}
```

A) Se produce un error porque es obligatorio declarar el nombre del parámetro.

B) Kotlin infiere que `it` es de tipo `Int` a partir del tipo función esperado.

C) `it` siempre es de tipo `Any`.

D) `it` solamente puede utilizarse en lambdas con receptor.

---

### Pregunta 4. Uso de it

¿Cuándo permite Kotlin utilizar el identificador implícito `it` en una expresión lambda?

A) Cuando la lambda tiene exactamente un parámetro y no se declara explícitamente su nombre.

B) Cuando la lambda tiene dos o más parámetros.

C) Siempre que la lambda devuelva un valor.

D) Solamente cuando se utiliza una lambda con receptor.

---

### Pregunta 5. Lambdas con varios parámetros

¿Qué ocurre al ejecutar el siguiente código?

```kotlin
val operation: (Int, Int) -> Int = { a, b ->
    a - b
}

println(operation(10, 3))
```

A) Se imprime 13.

B) Se imprime 7.

C) Se imprime 30.

D) Se produce un error porque las lambdas solamente pueden tener un parámetro.

---

### Pregunta 6. Valor de retorno de una lambda

¿Qué valor devuelve la siguiente lambda?

```kotlin
val calculate: (Int) -> Int = { number ->
    val result = number * 2
    result + 5
}

println(calculate(10))
```

A) 10.

B) 20.

C) 25.

D) No devuelve ningún valor porque utiliza una variable local.

---

### Pregunta 7. Lambdas sin parámetros

¿Cuál de las siguientes declaraciones representa correctamente una lambda sin parámetros que imprime un mensaje?

A)

```kotlin
val action = { ->
    println("Hola")
}
```

B)

```kotlin
val action = {
    println("Hola")
}
```

C)

```kotlin
val action = () -> {
    println("Hola")
}
```

D)

```kotlin
val action = lambda {
    println("Hola")
}
```

---

### Pregunta 8. Tipo Unit en lambdas

¿Qué significa que una función tenga el siguiente tipo?

```kotlin
val action: (String) -> Unit = {
    println(it)
}
```

A) Recibe una cadena y devuelve otra cadena.

B) Recibe una cadena y no proporciona un resultado significativo.

C) No recibe parámetros y devuelve `Unit`.

D) Recibe cualquier tipo de dato y devuelve `null`.

---

### Pregunta 9. Lambdas como valores

¿Qué afirmación es correcta sobre el siguiente código?

```kotlin
val operation: (Int) -> Int = { it * 3 }

val anotherOperation = operation
```

A) `anotherOperation` contiene el resultado de ejecutar `operation`.

B) `anotherOperation` almacena una referencia al mismo valor función que `operation`.

C) El código es incorrecto porque las lambdas no pueden asignarse a otras variables.

D) `anotherOperation` es automáticamente una función de orden superior.

---

### Pregunta 10. Invocación de una lambda

¿Qué diferencia existe entre las siguientes expresiones?

```kotlin
operation(5)
```

```kotlin
operation.invoke(5)
```

A) La primera es válida, pero la segunda no.

B) La segunda es válida, pero la primera no.

C) Ambas permiten invocar el valor función y son equivalentes en este contexto.

D) La primera crea una nueva lambda y la segunda la ejecuta.

---

### Pregunta 11. Tipos función

¿Qué representa el siguiente tipo función?

```kotlin
(Int, Double) -> String
```

A) Una función que recibe una cadena y devuelve dos números.

B) Una función que recibe un entero y un decimal y devuelve una cadena.

C) Una función que recibe dos cadenas y devuelve un entero.

D) Una función que no recibe parámetros y devuelve una cadena.

---

### Pregunta 12. Tipos función y nulabilidad

¿Qué significa la siguiente declaración?

```kotlin
val operation: ((Int) -> Int)? = null
```

A) La función recibe un entero nullable y devuelve un entero.

B) La variable puede contener una función que recibe un entero y devuelve otro entero, o bien `null`.

C) La función siempre devuelve `null`.

D) La variable contiene una función que no recibe parámetros.

---

### Pregunta 13. Tipos función con receptor

¿Qué representa el siguiente tipo función?

```kotlin
String.(Int) -> String
```

A) Una función que recibe una cadena y devuelve un entero.

B) Una función que tiene un receptor de tipo `String`, recibe además un `Int` y devuelve un `String`.

C) Una función que recibe dos cadenas y devuelve una cadena.

D) Una función que solamente puede utilizarse dentro de una clase `String`.

---

### Pregunta 14. Lambdas con receptor

¿Qué característica distingue a una lambda con receptor de una lambda convencional?

A) Una lambda con receptor no puede recibir parámetros.

B) Una lambda con receptor dispone de un objeto receptor que puede utilizarse mediante `this`.

C) Una lambda con receptor siempre devuelve `Unit`.

D) Una lambda con receptor no puede asignarse a una variable.

---

### Pregunta 15. Uso de this en una lambda con receptor

¿Qué imprime el siguiente código?

```kotlin
val action: String.() -> String = {
    this.uppercase()
}

println(action("kotlin"))
```

A) `kotlin`.

B) `KOTLIN`.

C) `null`.

D) Se produce un error porque `this` no puede utilizarse dentro de una lambda.

---

### Pregunta 16. Uso de it y this

¿Cuál de las siguientes afirmaciones es correcta?

A) `it` y `this` son intercambiables en cualquier lambda.

B) `it` representa el receptor de una lambda con receptor y `this` su único parámetro.

C) `it` es el nombre implícito del único parámetro de determinadas lambdas, mientras que `this` permite acceder al receptor de una lambda con receptor.

D) `this` solamente puede utilizarse en funciones de orden superior.

---

### Pregunta 17. Lambdas con receptor y parámetros

¿Qué resultado produce el siguiente código?

```kotlin
val operation: String.(Int) -> String = { number ->
    this.repeat(number)
}

println(operation("Kotlin", 2))
```

A) `Kotlin`.

B) `KotlinKotlin`.

C) `2Kotlin`.

D) Se produce un error porque una lambda con receptor no puede tener parámetros adicionales.

---

### Pregunta 18. Tipos función y lambdas con receptor

¿Qué diferencia existe entre los siguientes tipos?

```kotlin
(String) -> Int
```

```kotlin
String.() -> Int
```

A) No existe ninguna diferencia.

B) El primero representa una función que recibe un `String` como parámetro; el segundo representa una función que tiene un receptor de tipo `String`.

C) El primero solamente admite referencias a funciones y el segundo solamente lambdas.

D) El primero devuelve `String` y el segundo devuelve `Int`.

---

### Pregunta 19. Referencias a funciones

¿Qué operador utiliza Kotlin para crear una referencia a una función?

A) `&`

B) `#`

C) `::`

D) `->`

---

### Pregunta 20. Referencias a funciones y tipos función

Dada la siguiente función:

```kotlin
fun square(number: Int): Int {
    return number * number
}
```

¿Qué declaración almacena correctamente una referencia a dicha función?

A)

```kotlin
val operation: (Int) -> Int = square
```

B)

```kotlin
val operation: (Int) -> Int = ::square
```

C)

```kotlin
val operation: (Int) -> Int = square()
```

D)

```kotlin
val operation = -> square
```

---

### Pregunta 21. Ejecución de referencias a funciones

¿Qué imprime el siguiente código?

```kotlin
fun double(number: Int): Int {
    return number * 2
}

fun main() {
    val operation: (Int) -> Int = ::double
    println(operation(6))
}
```

A) 6.

B) 12.

C) La referencia a la función `double`.

D) Se produce un error porque las referencias a funciones no pueden almacenarse en variables.

---

### Pregunta 22. Referencias a funciones como argumentos

¿Qué ocurre al ejecutar el siguiente código?

```kotlin
fun calculate(number: Int, operation: (Int) -> Int): Int {
    return operation(number)
}

fun double(number: Int) = number * 2

fun main() {
    println(calculate(5, ::double))
}
```

A) Se imprime 5.

B) Se imprime 10.

C) Se imprime 25.

D) Se produce un error porque una función no puede recibir otra función como argumento.

---

### Pregunta 23. Funciones anónimas

¿Cuál de las siguientes afirmaciones describe correctamente una función anónima en Kotlin?

A) Es una función que no puede recibir parámetros.

B) Es una función que se declara sin nombre y puede utilizarse como valor función.

C) Es una función que solamente puede declararse dentro de una clase.

D) Es una función que no puede devolver ningún valor.

---

### Pregunta 24. Funciones de orden superior

¿Qué caracteriza a una función de orden superior?

A) Es una función que tiene más de dos parámetros.

B) Es una función que recibe funciones como parámetros, devuelve una función o ambas cosas.

C) Es una función que solamente puede utilizarse con clases abstractas.

D) Es una función que siempre devuelve un valor de tipo `Unit`.

---

### Pregunta 25. Funciones que reciben otras funciones

¿Qué imprime el siguiente código?

```kotlin
fun execute(operation: (Int) -> Int): Int {
    return operation(10)
}

fun main() {
    val result = execute { it + 5 }
    println(result)
}
```

A) 5.

B) 10.

C) 15.

D) Se produce un error porque no se ha declarado el tipo de la lambda.

---

### Pregunta 26. Sintaxis de trailing lambda

¿Qué afirmación es correcta sobre la siguiente llamada?

```kotlin
execute { it * 2 }
```

A) Es una sintaxis especial que permite pasar una lambda como último argumento fuera de los paréntesis de una llamada.

B) Solamente puede utilizarse cuando la función no tiene parámetros.

C) Es equivalente a declarar una función anónima fuera de la llamada.

D) Es incorrecta porque las lambdas siempre deben escribirse entre paréntesis.

---

### Pregunta 27. Funciones de orden superior que devuelven funciones

¿Qué imprime el siguiente código?

```kotlin
fun multiplier(factor: Int): (Int) -> Int {
    return { number -> number * factor }
}

fun main() {
    val triple = multiplier(3)
    println(triple(4))
}
```

A) 3.

B) 4.

C) 7.

D) 12.

---

### Pregunta 28. Closures

¿Qué sucede en el siguiente código?

```kotlin
fun createIncrementer(): () -> Int {
    var value = 0

    return {
        value++
    }
}

fun main() {
    val increment = createIncrementer()

    println(increment())
    println(increment())
}
```

A) Se imprimen 0 y 0.

B) Se imprimen 0 y 1.

C) Se imprimen 1 y 1.

D) Se produce un error porque una lambda no puede acceder a una variable local de la función que la crea.

---

### Pregunta 29. Funciones de orden superior y parámetros

Dada la siguiente función:

```kotlin
fun apply(
    number: Int,
    operation: (Int) -> Int
): Int {
    return operation(number)
}
```

¿Cuál de las siguientes llamadas es correcta?

A) `apply(5)`

B) `apply(5, { it * 2 })`

C) `apply({ it * 2 }, 5)`

D) `apply { 5, it * 2 }`

---

### Pregunta 30. Funciones como valores de retorno

¿Qué tipo función devuelve la siguiente función?

```kotlin
fun createOperation(): (Int, Int) -> Int {
    return { a, b -> a + b }
}
```

A) `(Int) -> Int`

B) `() -> Int`

C) `(Int, Int) -> Int`

D) `(Int, Int) -> Unit`

---

### Pregunta 31. Interfaces funcionales

¿Qué característica debe cumplir una interfaz Kotlin para poder declararse mediante `fun interface`?

A) Debe tener exactamente una función abstracta.

B) Debe tener exactamente una propiedad.

C) No puede contener funciones con implementación.

D) Debe heredar obligatoriamente de otra interfaz funcional.

---

### Pregunta 32. Declaración de una interfaz funcional

¿Cuál de las siguientes declaraciones es correcta?

A)

```kotlin
fun interface Validator {
    fun validate(value: String): Boolean
}
```

B)

```kotlin
interface fun Validator {
    fun validate(value: String): Boolean
}
```

C)

```kotlin
fun interface Validator {
    fun validate(value: String): Boolean
    fun reset()
}
```

D)

```kotlin
fun interface Validator {
    val validate: (String) -> Boolean
}
```

---

### Pregunta 33. Constructor SAM

¿Qué permite hacer el constructor SAM de una interfaz funcional Kotlin?

Dada la siguiente interfaz:

```kotlin
fun interface Validator {
    fun validate(value: String): Boolean
}
```

¿Cuál de las siguientes declaraciones es correcta?

A)

```kotlin
val validator = Validator("Kotlin")
```

B)

```kotlin
val validator = Validator { it.isNotEmpty() }
```

C)

```kotlin
val validator = Validator()
```

D)

```kotlin
val validator = fun Validator { it.isNotEmpty() }
```

---

### Pregunta 34. Constructor SAM y lambdas

¿Qué imprime el siguiente código?

```kotlin
fun interface Validator {
    fun validate(value: String): Boolean
}

fun main() {
    val validator = Validator {
        it.length >= 5
    }

    println(validator.validate("Kotlin"))
}
```

A) `true`.

B) `false`.

C) `6`.

D) Se produce un error porque `it` no puede utilizarse en un constructor SAM.

---

### Pregunta 35. Interfaces funcionales y tipos función

¿Cuál de las siguientes afirmaciones es correcta?

A) Una interfaz funcional y un tipo función son exactamente lo mismo en Kotlin.

B) Un tipo función representa una función como valor, mientras que una interfaz funcional define un contrato con un único método abstracto.

C) Los tipos función no pueden utilizarse como parámetros de funciones.

D) Una interfaz funcional no puede implementarse mediante una lambda.

---

### Pregunta 36. Objetos función

¿Qué afirmación describe correctamente los valores de tipo función en Kotlin?

A) Son exclusivamente referencias a métodos estáticos.

B) Son valores que pueden almacenarse en variables, pasarse como argumentos y devolverse desde otras funciones.

C) Solamente pueden utilizarse dentro de expresiones lambda.

D) No pueden invocarse directamente.

---

### Pregunta 37. Relación entre SAM y objetos función

¿Cuál de las siguientes afirmaciones es correcta?

A) Una lambda utilizada para crear una instancia de una interfaz funcional mediante el constructor SAM permite proporcionar la implementación de su único método abstracto.

B) El constructor SAM convierte cualquier clase en una interfaz funcional.

C) El constructor SAM permite implementar automáticamente todos los métodos de una interfaz normal.

D) Una interfaz funcional no puede utilizarse para almacenar una lambda.

---

### Pregunta 38. Funciones de orden superior y tipos función

¿Qué sucede al ejecutar el siguiente código?

```kotlin
fun process(
    value: String,
    transformation: String.() -> String
): String {
    return value.transformation()
}

fun main() {
    val result = process("kotlin") {
        uppercase()
    }

    println(result)
}
```

A) Se imprime `kotlin`.

B) Se imprime `KOTLIN`.

C) Se imprime `null`.

D) Se produce un error porque las funciones de orden superior no admiten lambdas con receptor.

---

### Pregunta 39. Lambdas y referencias a funciones

¿Cuál de las siguientes afirmaciones es correcta?

A) Una referencia a función siempre ejecuta la función inmediatamente.

B) Una lambda y una referencia a función pueden utilizarse como valores de un tipo función compatible.

C) Una referencia a función no puede almacenarse en una variable.

D) Una lambda no puede asignarse a un tipo función explícito.

---

### Pregunta 40. Combinación de conceptos

¿Qué imprime el siguiente código?

```kotlin
fun operate(
    number: Int,
    operation: (Int) -> Int
): Int {
    return operation(number)
}

fun square(number: Int) = number * number

fun main() {
    val result = operate(4, ::square)

    println(result)
}
```

A) 4.

B) 8.

C) 16.

D) Se produce un error porque `::square` no es una expresión lambda.

---

# Plantilla de respuestas

| Pregunta | Respuesta | Pregunta | Respuesta |
|:---:|:---:|:---:|:---:|
| 1 | | 21 | |
| 2 | | 22 | |
| 3 | | 23 | |
| 4 | | 24 | |
| 5 | | 25 | |
| 6 | | 26 | |
| 7 | | 27 | |
| 8 | | 28 | |
| 9 | | 29 | |
| 10 | | 30 | |
| 11 | | 31 | |
| 12 | | 32 | |
| 13 | | 33 | |
| 14 | | 34 | |
| 15 | | 35 | |
| 16 | | 36 | |
| 17 | | 37 | |
| 18 | | 38 | |
| 19 | | 39 | |
| 20 | | 40 | |

---

# SOLUCIONARIO PARA EL PROFESOR

**Este apartado no debe incluirse en la copia que se entregue al alumnado.**

| Pregunta | Respuesta correcta | Concepto evaluado |
|:---:|:---:|---|
| 1 | B | Sintaxis de las lambdas |
| 2 | B | Parámetros de una lambda |
| 3 | B | Inferencia de tipos |
| 4 | A | Parámetro implícito `it` |
| 5 | B | Lambdas con varios parámetros |
| 6 | C | Valor de retorno de una lambda |
| 7 | B | Lambdas sin parámetros |
| 8 | B | Tipo `Unit` |
| 9 | B | Lambdas como valores |
| 10 | C | Invocación mediante `invoke()` |
| 11 | B | Tipos función |
| 12 | B | Tipos función nullable |
| 13 | B | Tipos función con receptor |
| 14 | B | Lambdas con receptor |
| 15 | B | Uso de `this` |
| 16 | C | Diferencia entre `it` y `this` |
| 17 | B | Receptor y parámetros adicionales |
| 18 | B | Funciones con y sin receptor |
| 19 | C | Referencias a funciones |
| 20 | B | Referencias mediante `::` |
| 21 | B | Ejecución de referencias |
| 22 | B | Referencias como argumentos |
| 23 | B | Funciones anónimas |
| 24 | B | Funciones de orden superior |
| 25 | C | Funciones que reciben lambdas |
| 26 | A | Sintaxis trailing lambda |
| 27 | D | Funciones que devuelven funciones |
| 28 | B | Closures |
| 29 | B | Paso de funciones como argumentos |
| 30 | C | Tipos función como retorno |
| 31 | A | Interfaces funcionales |
| 32 | A | Declaración `fun interface` |
| 33 | B | Constructor SAM |
| 34 | A | SAM y lambdas |
| 35 | B | Interfaces funcionales y tipos función |
| 36 | B | Funciones como valores |
| 37 | A | Relación entre SAM y lambdas |
| 38 | B | Funciones de orden superior y receptor |
| 39 | B | Lambdas y referencias |
| 40 | C | Combinación de conceptos |

---

## Criterios de corrección

Se propone la siguiente puntuación:

- Respuesta correcta: **+0,25 puntos**.
- Respuesta incorrecta: **−0,0625 puntos**.
- Pregunta sin responder: **0 puntos**.

La puntuación máxima del test es de **10 puntos**.

La fórmula de cálculo sería:

`Nota = (Aciertos × 0,25) − (Errores × 0,0625)`

Donde:

- Aciertos: número de respuestas correctas.
- Errores: número de respuestas incorrectas.
- Las preguntas sin responder no suman ni restan.

---

## Distribución de contenidos evaluados

| Bloque | Preguntas | Número |
|---|---|:---:|
| Sintaxis y características de las lambdas | 1-10 | 10 |
| Tipos función | 11-13 | 3 |
| Lambdas con receptor, it y this | 14-18 | 5 |
| Referencias a funciones y funciones anónimas | 19-23 | 5 |
| Funciones de orden superior | 24-30 | 7 |
| Interfaces funcionales y constructor SAM | 31-37 | 7 |
| Integración de conceptos | 38-40 | 3 |
| **Total** | | **40** |

---

## Observaciones didácticas

Este test pretende comprobar que el alumnado comprende los fundamentos de la programación funcional en Kotlin, especialmente el tratamiento de las funciones como valores.

Se evalúan cuatro niveles de conocimiento:

1. **Conocimiento conceptual:** comprender qué son las lambdas, los tipos función, las funciones de orden superior y las interfaces funcionales.
2. **Conocimiento sintáctico:** identificar declaraciones correctas de lambdas, lambdas con receptor, referencias a funciones y constructores SAM.
3. **Comprensión del código:** interpretar fragmentos de Kotlin y determinar el resultado de su ejecución.
4. **Razonamiento:** distinguir entre conceptos relacionados, como lambdas y referencias a funciones, tipos función e interfaces funcionales, o lambdas convencionales y lambdas con receptor.

### Consideraciones sobre el alcance

El test se limita a los contenidos de programación funcional indicados para esta unidad.

No se incluyen:

- Operaciones sobre colecciones.
- Funciones `map`, `filter`, `forEach`, `reduce` o similares.
- Secuencias (`Sequence`).
- Operaciones funcionales sobre listas o conjuntos.
- Programación funcional aplicada a Android.

El objetivo es que el alumnado comprenda primero cómo se representan, almacenan, transmiten, invocan y devuelven las funciones en Kotlin, antes de aplicar estos conocimientos al procesamiento de colecciones.