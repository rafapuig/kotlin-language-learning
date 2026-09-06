# Ejercicios: de Block Body a Expression Body en Kotlin

## Objetivo

En estos ejercicios practicarás la transformación de funciones Kotlin que utilizan **block body** a funciones que utilizan **expression body**.

### Block body

Una función con *block body* utiliza llaves `{}` y normalmente devuelve el resultado mediante `return`:

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

### Expression body

Una función con *expression body* utiliza `=` para indicar directamente la expresión que devuelve:

```kotlin
fun add(a: Int, b: Int): Int = a + b
```

En algunos casos, también es posible eliminar el tipo de retorno gracias a la **inferencia de tipos**:

```kotlin
fun add(a: Int, b: Int) = a + b
```

---

# Ejercicios

## Nivel 1 — Expresiones sencillas

Transforma cada función para que utilice **expression body**.

### 1. Duplicar un número

```kotlin
fun double(number: Int): Int {
    return number * 2
}
```

### 2. Calcular el cuadrado

```kotlin
fun square(number: Int): Int {
    return number * number
}
```

### 3. Saludar

```kotlin
fun greet(name: String): String {
    return "Hola, $name"
}
```

### 4. Calcular el área de un cuadrado

```kotlin
fun calculateArea(side: Double): Double {
    return side * side
}
```

### 5. Comprobar si un número es par

```kotlin
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}
```

---

# Nivel 2 — Expresiones condicionales

Transforma las siguientes funciones utilizando **expression body**.

### 6. Obtener el mayor de dos números

```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}
```

### 7. Comprobar si una persona puede votar

```kotlin
fun canVote(age: Int): Boolean {
    return if (age >= 18) {
        true
    } else {
        false
    }
}
```

### 8. Obtener el valor absoluto

```kotlin
fun absolute(number: Int): Int {
    return if (number < 0) {
        -number
    } else {
        number
    }
}
```

### 9. Determinar el signo de un número

```kotlin
fun sign(number: Int): String {
    return if (number > 0) {
        "positivo"
    } else if (number < 0) {
        "negativo"
    } else {
        "cero"
    }
}
```

---

# Nivel 3 — Expresiones `when`

Transforma las siguientes funciones a **expression body**.

### 10. Obtener el nombre de un día

```kotlin
fun dayName(day: Int): String {
    return when (day) {
        1 -> "lunes"
        2 -> "martes"
        3 -> "miércoles"
        4 -> "jueves"
        5 -> "viernes"
        6 -> "sábado"
        7 -> "domingo"
        else -> "día inválido"
    }
}
```

### 11. Clasificar una edad

```kotlin
fun classifyAge(age: Int): String {
    return when {
        age < 13 -> "niño"
        age < 18 -> "adolescente"
        age < 65 -> "adulto"
        else -> "mayor"
    }
}
```

### 12. Convertir una nota numérica en texto

```kotlin
fun getGradeDescription(grade: Int): String {
    return when (grade) {
        10 -> "sobresaliente"
        9 -> "sobresaliente"
        7, 8 -> "notable"
        5, 6 -> "aprobado"
        else -> "suspenso"
    }
}
```

---

# Nivel 4 — Inferencia de tipos

Convierte las funciones a **expression body**.

Además, comprueba si puedes eliminar el tipo de retorno utilizando la **inferencia de tipos de Kotlin**.

### 13.

```kotlin
fun multiply(a: Int, b: Int): Int {
    return a * b
}
```

### 14.

```kotlin
fun getMessage(): String {
    return "Hola, Kotlin"
}
```

### 15.

```kotlin
fun isPositive(number: Int): Boolean {
    return number > 0
}
```

### 16.

```kotlin
fun calculatePrice(price: Double, discount: Double): Double {
    return price - price * discount
}
```

---

# Nivel 5 — Varias sentencias

En estos ejercicios hay más de una sentencia dentro del cuerpo.

Intenta convertirlos a **expression body** siempre que sea posible.

### 17.

```kotlin
fun calculateTriangleArea(base: Double, height: Double): Double {
    val area = base * height
    return area / 2
}
```

### 18.

```kotlin
fun getFullName(firstName: String, lastName: String): String {
    val result = "$firstName $lastName"
    return result
}
```

### 19.

```kotlin
fun calculateTotal(price: Double, quantity: Int): Double {
    val subtotal = price * quantity
    return subtotal + subtotal * 0.21
}
```

### 20.

```kotlin
fun isAdult(age: Int): Boolean {
    val minimumAge = 18
    return age >= minimumAge
}
```

---

# Nivel 6 — ¿Es posible convertirla?

En estos ejercicios debes decidir si la función puede convertirse directamente a **expression body**.

Si es posible, realiza la conversión.

Si no es posible, explica por qué.

### 21.

```kotlin
fun showMessage(name: String) {
    println("Hola, $name")
}
```

### 22.

```kotlin
fun incrementCounter(counter: Int): Int {
    println("Incrementando...")
    return counter + 1
}
```

### 23.

```kotlin
fun getMaximum(a: Int, b: Int): Int {
    val result = if (a > b) a else b
    return result
}
```

### 24.

```kotlin
fun processNumber(number: Int): Int {
    println("Procesando número...")
    val result = number * 2
    println("Resultado: $result")
    return result
}
```

---

# Reto final

Convierte las siguientes funciones a **expression body** intentando utilizar correctamente:

- `=`
- `if` como expresión
- `when` como expresión
- Inferencia de tipos
- Expresiones anidadas

### 25.

```kotlin
fun calculateDiscount(price: Double, percentage: Int): Double {
    return if (percentage > 0) {
        price - price * percentage / 100
    } else {
        price
    }
}
```

### 26.

```kotlin
fun classifyNumber(number: Int): String {
    return when {
        number == 0 -> "cero"
        number > 0 && number % 2 == 0 -> "positivo par"
        number > 0 -> "positivo impar"
        number % 2 == 0 -> "negativo par"
        else -> "negativo impar"
    }
}
```

### 27.

```kotlin
fun getGradeDescription(grade: Int): String {
    return when {
        grade < 0 -> "nota inválida"
        grade > 10 -> "nota inválida"
        grade < 5 -> "suspenso"
        grade < 7 -> "aprobado"
        grade < 9 -> "notable"
        else -> "sobresaliente"
    }
}
```

### 28.

```kotlin
fun calculateSalary(baseSalary: Double, overtimeHours: Int): Double {
    val overtimeRate = 15.0
    val overtimePay = overtimeHours * overtimeRate
    return baseSalary + overtimePay
}
```

---

# Objetivo final

Al terminar los ejercicios deberías ser capaz de:

1. Reconocer una función que puede utilizar **expression body**.
2. Sustituir correctamente un `return` por `=`.
3. Utilizar `if` y `when` como expresiones.
4. Aprovechar la **inferencia de tipos** cuando sea apropiado.
5. Identificar funciones que contienen varias sentencias.
6. Determinar cuándo una función no puede simplificarse directamente a un **expression body**.