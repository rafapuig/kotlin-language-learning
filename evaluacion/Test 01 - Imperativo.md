# TEST 1 – FUNDAMENTOS DEL LENGUAJE KOTLIN

**Ciclo:** 2.º de Desarrollo de Aplicaciones Multiplataforma (DAM)  
**Módulo:** Programación  
**Unidad:** Fundamentos del lenguaje Kotlin  
**Número de preguntas:** 20  
**Tipo:** Respuesta múltiple (una única respuesta correcta)

**Nombre y apellidos:** __________________________________

**Fecha:** __________________

---

## Preguntas

### Pregunta 1. Declaración de variables

¿Qué afirmación describe correctamente la diferencia entre `val` y `var` en Kotlin?

A) `val` permite modificar el valor, mientras que `var` no.

B) `val` declara una variable de solo lectura y `var` una variable cuyo valor puede modificarse.

C) Ambas permiten modificar el valor, pero `val` es más eficiente.

D) `var` solamente permite almacenar números.

---

### Pregunta 2. Inferencia de tipos

¿Qué tipo infiere Kotlin para la siguiente variable?

```kotlin
val number = 25
```

A) `Double`

B) `Float`

C) `Int`

D) `Long`

---

### Pregunta 3. Conversión de tipos

¿Qué ocurre al ejecutar el siguiente código?

```kotlin
val number: Int = 10
val result: Double = number
```

A) Se convierte automáticamente el `Int` en `Double`.

B) Se produce un error de compilación porque Kotlin no realiza conversiones numéricas implícitas.

C) La variable `result` contiene el valor `10.0`.

D) El código es correcto únicamente si se utiliza `var`.

---

### Pregunta 4. Tipos numéricos

¿Cuál de las siguientes declaraciones representa correctamente un número de tipo `Float`?

A) `val number = 10.5`

B) `val number: Float = 10.5`

C) `val number = 10.5f`

D) `val number: Float = 10`

---

### Pregunta 5. Nulabilidad

¿Cuál de las siguientes declaraciones permite almacenar tanto un número entero como el valor `null`?

A) `val number: Int = null`

B) `val number: Int? = null`

C) `val number: Nullable<Int> = null`

D) `val number: Int = 0?`

---

### Pregunta 6. Operador Elvis

¿Qué valor contiene `result` después de ejecutar el siguiente código?

```kotlin
val name: String? = null
val result = name ?: "Desconocido"
```

A) `null`

B) Una cadena vacía.

C) `"Desconocido"`

D) Se produce una excepción.

---

### Pregunta 7. Operador de llamada segura

¿Qué sucede al ejecutar el siguiente código?

```kotlin
val text: String? = null
println(text?.length)
```

A) Se produce una excepción porque `text` es null.

B) Se imprime `0`.

C) Se imprime `null`.

D) Se produce un error de compilación.

---

### Pregunta 8. Operador de aserción de no nulidad

¿Qué sucede al ejecutar el siguiente código?

```kotlin
val name: String? = null
println(name!!.length)
```

A) Se imprime `0`.

B) Se imprime `null`.

C) Se produce una excepción en tiempo de ejecución.

D) El compilador convierte automáticamente `null` en una cadena vacía.

---

### Pregunta 9. Funciones con parámetros

Dada la siguiente función:

```kotlin
fun calculate(price: Double, quantity: Int): Double {
    return price * quantity
}
```

¿Cuál de las siguientes llamadas es correcta utilizando argumentos nombrados?

A) `calculate(price = 10.0, quantity = 3)`

B) `calculate(price: 10.0, quantity: 3)`

C) `calculate(10.0 = price, 3 = quantity)`

D) `calculate(price, quantity = 3, 10.0)`

---

### Pregunta 10. Parámetros con valores por defecto

¿Qué resultado produce el siguiente código?

```kotlin
fun greet(name: String = "Alumno") {
    println("Hola, $name")
}

greet()
```

A) Se produce un error porque falta el argumento `name`.

B) Se imprime `Hola, Alumno`.

C) Se imprime `Hola, null`.

D) No se imprime nada.

---

### Pregunta 11. Funciones con cuerpo de expresión

¿Cuál de las siguientes declaraciones utiliza correctamente un cuerpo de expresión?

A) `fun sum(a: Int, b: Int) = return a + b`

B) `fun sum(a: Int, b: Int): Int { a + b }`

C) `fun sum(a: Int, b: Int) = a + b`

D) `fun sum(a: Int, b: Int) => a + b`

---

### Pregunta 12. Funciones con cuerpo de bloque

¿Qué afirmación es correcta sobre una función con cuerpo de bloque?

A) Siempre debe utilizar la palabra reservada `return`, aunque no devuelva ningún valor.

B) Puede contener varias instrucciones entre llaves y utilizar `return` para devolver un resultado.

C) No puede declarar variables locales.

D) No puede recibir parámetros.

---

### Pregunta 13. Entrada de datos por consola

¿Qué devuelve la función `readln()`?

A) Un valor de tipo `Int`.

B) Un valor de tipo `Double`.

C) Un valor de tipo `String`.

D) Un valor de tipo `Boolean`.

---

### Pregunta 14. Conversión de datos introducidos por teclado

¿Qué expresión permite leer un número entero desde la consola?

A) `readln().toInt()`

B) `readln().toString()`

C) `readln().toBoolean()`

D) `readln().toDouble()`

---

### Pregunta 15. Expresión if

¿Qué valor contiene la variable `result`?

```kotlin
val number = 8

val result = if (number > 5) {
    "Mayor"
} else {
    "Menor o igual"
}
```

A) `true`

B) `false`

C) `"Mayor"`

D) `"Menor o igual"`

---

### Pregunta 16. Expresión when

¿Qué imprime el siguiente código?

```kotlin
val number = 2

when (number) {
    1 -> println("Uno")
    2 -> println("Dos")
    3 -> println("Tres")
    else -> println("Otro")
}
```

A) `Uno`

B) `Dos`

C) `Tres`

D) `Otro`

---

### Pregunta 17. Bucle for y rangos

¿Cuántas veces se ejecuta el siguiente bucle?

```kotlin
for (i in 1..5) {
    println(i)
}
```

A) 4 veces.

B) 5 veces.

C) 6 veces.

D) Infinitas veces.

---

### Pregunta 18. Rangos y progresiones

¿Qué valores toma la variable `i` en el siguiente bucle?

```kotlin
for (i in 10 downTo 2 step 2) {
    println(i)
}
```

A) 10, 8, 6, 4, 2.

B) 10, 9, 8, 7, 6, 5, 4, 3, 2.

C) 2, 4, 6, 8, 10.

D) 10, 8, 6, 4.

---

### Pregunta 19. Bucle while y do-while

¿Cuál es la principal diferencia entre `while` y `do-while`?

A) `while` siempre se ejecuta al menos una vez.

B) `do-while` siempre se ejecuta al menos una vez, porque comprueba la condición después del bloque.

C) `while` solamente puede utilizarse con números enteros.

D) No existe ninguna diferencia entre ambos.

---

### Pregunta 20. Constantes

¿Cuál de las siguientes declaraciones define correctamente una constante de compilación en Kotlin?

A) `var MAX_VALUE = 100`

B) `val MAX_VALUE = 100`

C) `const val MAX_VALUE = 100`

D) `constant MAX_VALUE = 100`

---

## Plantilla de respuestas

| Pregunta | Respuesta | Pregunta | Respuesta |
|:---:|:---:|:---:|:---:|
| 1 | | 11 | |
| 2 | | 12 | |
| 3 | | 13 | |
| 4 | | 14 | |
| 5 | | 15 | |
| 6 | | 16 | |
| 7 | | 17 | |
| 8 | | 18 | |
| 9 | | 19 | |
| 10 | | 20 | |

---

# SOLUCIONARIO PARA EL PROFESOR

**Este apartado no debe incluirse en la copia que se entregue al alumnado.**

| Pregunta | Respuesta correcta | Concepto evaluado |
|:---:|:---:|---|
| 1 | B | `val` y `var` |
| 2 | C | Inferencia de tipos |
| 3 | B | Conversión explícita |
| 4 | C | Literales `Float` |
| 5 | B | Tipos nullable |
| 6 | C | Operador Elvis |
| 7 | C | Llamada segura |
| 8 | C | Aserción de no nulidad |
| 9 | A | Argumentos nombrados |
| 10 | B | Parámetros por defecto |
| 11 | C | Cuerpo de expresión |
| 12 | B | Cuerpo de bloque |
| 13 | C | `readln()` |
| 14 | A | Conversión a entero |
| 15 | C | `if` como expresión |
| 16 | B | `when` |
| 17 | B | Rango inclusivo |
| 18 | A | `downTo` y `step` |
| 19 | B | `do-while` |
| 20 | C | `const val` |

## Criterios de corrección

Se propone la siguiente puntuación:

- Respuesta correcta: **+0,5 puntos**.
- Respuesta incorrecta: **−0,15 puntos**.
- Pregunta sin responder: **0 puntos**.

La puntuación máxima del test es de **10 puntos**.

---

## Distribución de contenidos evaluados

| Bloque | Preguntas | Número |
|---|---|:---:|
| Variables y tipos | 1-4 | 4 |
| Nulabilidad | 5-8 | 4 |
| Funciones | 9-12 | 4 |
| Entrada y salida | 13-14 | 2 |
| Control de flujo | 15-19 | 5 |
| Constantes | 20 | 1 |
| **Total** | | **20** |

## Observaciones didácticas

Este primer test tiene como objetivo comprobar que el alumnado conoce los fundamentos del lenguaje Kotlin y comprende sus principales diferencias respecto a otros lenguajes.

Se evalúan tres niveles de conocimiento:

1. **Conocimiento conceptual:** reconocer las características del lenguaje y sus reglas.
2. **Conocimiento sintáctico:** identificar declaraciones y expresiones correctas.
3. **Comprensión del código:** interpretar pequeños fragmentos y anticipar su comportamiento.

En los siguientes test se puede aumentar progresivamente la dificultad mediante fragmentos de código más extensos, combinaciones de funciones y nulabilidad, y detección de errores de compilación.