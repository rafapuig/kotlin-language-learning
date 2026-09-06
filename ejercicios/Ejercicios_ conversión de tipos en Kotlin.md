# Ejercicios: conversión de tipos en Kotlin

En estos ejercicios practicarás la **conversión entre tipos** en Kotlin utilizando únicamente:

- `Int`
- `Long`
- `Float`
- `Double`
- `String`

No se utilizarán clases, objetos, herencia ni conceptos de programación orientada a objetos.

## Tipos que utilizaremos

```kotlin
Int
Long
Float
Double
String
```

Algunas conversiones habituales son:

```kotlin
toInt()
toLong()
toFloat()
toDouble()
toString()
```

> **Importante:** convertir un valor no es lo mismo que cambiar simplemente el tipo de una variable. En Kotlin, las conversiones numéricas se realizan explícitamente.

---

# Nivel 1 — Primeras conversiones

## Ejercicio 1

Crea un `Int` con el valor `25`.

Conviértelo a `Double` y muestra el resultado.

---

## Ejercicio 2

Crea un `Int` con el valor `50`.

Conviértelo a `Long` y muestra el resultado.

---

## Ejercicio 3

Crea un `Int` con el valor `15`.

Conviértelo a `Float`.

---

## Ejercicio 4

Crea un `Double` con el valor `12.5`.

Conviértelo a `Int`.

Muestra el resultado.

---

## Ejercicio 5

Crea un `Double` con el valor `99.9`.

Conviértelo a `Int`.

Observa qué ocurre con la parte decimal.

---

## Ejercicio 6

Crea un `Float` con el valor `25.8f`.

Conviértelo a `Int`.

---

# Nivel 2 — Conversiones entre tipos numéricos

## Ejercicio 7

Crea:

```kotlin
val number = 100
```

Convierte el valor sucesivamente a:

```text
Long
Double
Float
```

Muestra cada resultado.

---

## Ejercicio 8

Crea:

```kotlin
val number = 25.75
```

Convierte el valor a:

```text
Float
Int
Long
```

Muestra los tres resultados.

---

## Ejercicio 9

Crea:

```kotlin
val number = 500L
```

Conviértelo a:

```text
Int
Double
Float
```

---

## Ejercicio 10

Crea:

```kotlin
val number = 15.5f
```

Conviértelo a:

```text
Int
Long
Double
```

---

# Nivel 3 — Conversión y pérdida de información

## Ejercicio 11

Crea:

```kotlin
val number = 19.99
```

Conviértelo a `Int`.

Muestra:

```text
Original: 19.99
Convertido: 19
```

---

## Ejercicio 12

Crea un `Double` con el valor `123.456`.

Conviértelo a `Int`.

Después convierte nuevamente ese `Int` a `Double`.

Muestra los tres valores:

```text
Original:
Primera conversión:
Segunda conversión:
```

---

## Ejercicio 13

Crea:

```kotlin
val number = 75.8
```

Realiza esta secuencia:

```text
Double → Int → Double
```

Comprueba si el valor final es exactamente igual al original.

---

## Ejercicio 14

Crea:

```kotlin
val number = 75
```

Realiza:

```text
Int → Double → Int
```

Comprueba si recuperas exactamente el valor original.

---

## Ejercicio 15

Crea un `Double` con varios decimales.

Realiza:

```text
Double → Int → Double
```

Explica qué información se ha perdido durante la conversión.

---

# Nivel 4 — Conversión de `String` a números

## Ejercicio 16

Crea:

```kotlin
val text = "25"
```

Convierte el `String` a `Int`.

---

## Ejercicio 17

Crea:

```kotlin
val text = "123456"
```

Convierte el texto a `Long`.

---

## Ejercicio 18

Crea:

```kotlin
val text = "15.75"
```

Convierte el texto a `Double`.

---

## Ejercicio 19

Crea:

```kotlin
val text = "12.5"
```

Convierte el texto a `Float`.

---

## Ejercicio 20

Crea:

```kotlin
val text = "100"
```

Convierte el texto a `Int` y después a `Double`.

---

# Nivel 5 — Números a `String`

## Ejercicio 21

Crea:

```kotlin
val number = 25
```

Convierte el número a `String`.

Muestra el resultado.

---

## Ejercicio 22

Crea:

```kotlin
val number = 25.5
```

Conviértelo a `String`.

---

## Ejercicio 23

Crea:

```kotlin
val number = 500L
```

Conviértelo a `String`.

---

## Ejercicio 24

Crea:

```kotlin
val number = 12.5f
```

Conviértelo a `String`.

---

## Ejercicio 25

Crea un `Int` y conviértelo a `String`.

Después concatena el resultado con:

```text
" unidades"
```

Por ejemplo:

```text
25 unidades
```

---

# Nivel 6 — Conversiones encadenadas

## Ejercicio 26

Crea:

```kotlin
val number = 25
```

Realiza:

```text
Int → Double → String
```

Muestra el resultado final.

---

## Ejercicio 27

Crea:

```kotlin
val number = 15.75
```

Realiza:

```text
Double → Int → String
```

Muestra el resultado final.

---

## Ejercicio 28

Crea:

```kotlin
val text = "50"
```

Realiza:

```text
String → Int → Double
```

Muestra el resultado final.

---

## Ejercicio 29

Crea:

```kotlin
val text = "19.95"
```

Realiza:

```text
String → Double → Int
```

Muestra el resultado final.

---

## Ejercicio 30

Crea:

```kotlin
val text = "100"
```

Realiza:

```text
String → Int → Long → Double → String
```

Muestra el resultado final.

---

# Nivel 7 — Conversiones dentro de expresiones

## Ejercicio 31

Crea:

```kotlin
val first = 10
val second = 5.5
```

Calcula la suma convirtiendo el `Int` al tipo necesario.

---

## Ejercicio 32

Crea:

```kotlin
val price = 19.99
val quantity = 3
```

Calcula el precio total.

Convierte explícitamente `quantity` al tipo necesario.

---

## Ejercicio 33

Crea:

```kotlin
val distance = 150
val time = 2.5
```

Calcula la velocidad media.

---

## Ejercicio 34

Crea:

```kotlin
val total = 100
val people = 3
```

Calcula cuánto corresponde a cada persona utilizando un resultado decimal.

---

## Ejercicio 35

Crea:

```kotlin
val first = 10
val second = 3
```

Calcula el resultado de dividir `first` entre `second` como:

1. `Int`
2. `Double`

Muestra ambos resultados y compáralos.

---

# Nivel 8 — Comprender la diferencia entre `Int` y `Double`

## Ejercicio 36

Observa:

```kotlin
val result = 10 / 3
```

Muestra el resultado.

---

## Ejercicio 37

Modifica el ejercicio anterior para obtener un resultado decimal.

---

## Ejercicio 38

Crea:

```kotlin
val first = 10
val second = 3
```

Calcula:

```text
10 / 3
```

como `Int` y como `Double`.

---

## Ejercicio 39

Explica mediante comentarios en el código por qué estos dos resultados son diferentes:

```kotlin
10 / 3
10.0 / 3
```

---

## Ejercicio 40

Crea dos variables `Int`.

Obtén su división decimal convirtiendo solamente uno de los operandos a `Double`.

No conviertas ambos.

---

# Nivel 9 — Conversiones con varias operaciones

## Ejercicio 41

Crea:

```kotlin
val price = 19.95
val quantity = 4
```

Calcula:

```text
Precio total: 79.8
```

El resultado debe conservar los decimales.

---

## Ejercicio 42

Crea:

```kotlin
val distance = 125
val hours = 2
val minutes = 30
```

Calcula la velocidad media en kilómetros por hora.

Ten en cuenta que `30 minutos` representa `0.5 horas`.

---

## Ejercicio 43

Crea:

```kotlin
val totalSeconds = 3675
```

Calcula:

- horas
- minutos
- segundos

Utiliza conversiones de tipos cuando sean necesarias.

---

## Ejercicio 44

Crea:

```kotlin
val totalCents = 1575
```

Calcula el precio en euros utilizando un `Double`.

El resultado debe ser:

```text
15.75
```

---

## Ejercicio 45

Crea:

```kotlin
val total = 100
val percentage = 15
```

Calcula el `15 %` de `100` utilizando un resultado decimal.

---

# Nivel 10 — Conversiones de texto y números

## Ejercicio 46

Crea:

```kotlin
val ageText = "25"
```

Convierte el texto a `Int`.

Después calcula qué edad tendrá la persona dentro de `10` años.

---

## Ejercicio 47

Crea:

```kotlin
val priceText = "19.99"
val quantityText = "3"
```

Convierte ambos textos a los tipos apropiados y calcula el precio total.

---

## Ejercicio 48

Crea:

```kotlin
val widthText = "12.5"
val heightText = "8.0"
```

Convierte los valores a `Double` y calcula el área del rectángulo.

---

## Ejercicio 49

Crea:

```kotlin
val radiusText = "5.5"
```

Convierte el valor a `Double` y calcula el área de un círculo.

Utiliza:

```text
π × radio²
```

---

## Ejercicio 50

Crea tres valores como `String`:

```text
"10"
"20"
"30"
```

Convierte los tres a `Int` y calcula su media como `Double`.

---

# Nivel 11 — Razonamiento sobre conversiones

En estos ejercicios no basta con escribir el código. Antes de ejecutarlo, intenta predecir el resultado.

## Ejercicio 51

¿Qué valor tendrá `result`?

```kotlin
val number = 15.8
val result = number.toInt()
```

---

## Ejercicio 52

¿Qué valor tendrá `result`?

```kotlin
val number = 15
val result = number.toDouble()
```

---

## Ejercicio 53

¿Qué valor tendrá `result`?

```kotlin
val text = "25"
val result = text.toInt()
```

---

## Ejercicio 54

¿Qué valor tendrá `result`?

```kotlin
val text = "25.5"
val result = text.toDouble()
```

---

## Ejercicio 55

¿Qué ocurre aquí?

```kotlin
val text = "25.5"
val result = text.toInt()
```

Investiga por qué.

---

## Ejercicio 56

¿Qué ocurre aquí?

```kotlin
val text = "hello"
val result = text.toInt()
```

Ejecuta el programa y observa el resultado.

---

# Nivel 12 — Conversiones seguras

Kotlin dispone de versiones seguras de algunas conversiones:

```kotlin
toIntOrNull()
toLongOrNull()
toFloatOrNull()
toDoubleOrNull()
```

Estas funciones pueden devolver `null` cuando el texto no representa correctamente el tipo solicitado.

## Ejercicio 57

Crea:

```kotlin
val text = "25"
```

Utiliza `toIntOrNull()` para convertirlo a `Int`.

---

## Ejercicio 58

Crea:

```kotlin
val text = "hello"
```

Utiliza `toIntOrNull()`.

Observa el resultado.

---

## Ejercicio 59

Crea:

```kotlin
val text = "19.95"
```

Utiliza `toDoubleOrNull()`.

---

## Ejercicio 60

Crea:

```kotlin
val text = "19.95"
```

Intenta convertirlo utilizando `toIntOrNull()`.

Explica por qué el resultado es diferente al del ejercicio anterior.

---

## Ejercicio 61

Crea:

```kotlin
val text = "100"
```

Utiliza `toIntOrNull()`.

Si la conversión tiene éxito, muestra el número multiplicado por `2`.

---

## Ejercicio 62

Crea:

```kotlin
val text = "hello"
```

Utiliza `toIntOrNull()`.

Si la conversión no es posible, muestra:

```text
El valor no es un número entero
```

---

# Nivel 13 — Retos

## Ejercicio 63

Tienes:

```kotlin
val priceText = "24.95"
val quantityText = "5"
```

Convierte ambos valores y calcula:

```text
Precio total: 124.75
```

---

## Ejercicio 64

Tienes:

```kotlin
val distanceText = "350.5"
val timeText = "4.5"
```

Convierte ambos valores a `Double` y calcula la velocidad media.

---

## Ejercicio 65

Tienes:

```kotlin
val eurosText = "25.50"
```

Convierte el texto a `Double`.

Después conviértelo a `Int`.

Finalmente conviértelo nuevamente a `String`.

Muestra cada paso.

---

## Ejercicio 66

Crea:

```kotlin
val number = 123.456
```

Realiza esta secuencia:

```text
Double
↓
Int
↓
Double
↓
String
```

Muestra el resultado después de cada conversión.

---

## Ejercicio 67

Crea tres valores:

```kotlin
val firstText = "15"
val secondText = "20"
val thirdText = "25"
```

Convierte los tres a `Double` y calcula su media.

---

## Ejercicio 68

Crea:

```kotlin
val number = 25
```

Convierte el número a:

```text
Long
Double
Float
String
```

Muestra cada resultado indicando su tipo mediante el texto de salida.

Por ejemplo:

```text
Double: ...
String: ...
```

---

# Nivel 14 — Reto final

## Ejercicio 69 — Conversión completa

Crea:

```kotlin
val value = "125.75"
```

Realiza las siguientes conversiones:

```text
String
↓
Double
↓
Int
↓
Long
↓
Double
↓
String
```

Muestra el resultado de cada etapa.

Después analiza qué información se ha perdido y en qué momento.

---

## Ejercicio 70 — Precio

Crea:

```kotlin
val priceText = "15.95"
val quantityText = "7"
val discountText = "10"
```

Convierte los tres valores a los tipos adecuados.

Calcula:

1. Precio sin descuento.
2. Importe del descuento.
3. Precio final.

Muestra los tres resultados.

---

## Ejercicio 71 — Velocidad

Crea:

```kotlin
val distanceText = "125.5"
val hoursText = "2"
val minutesText = "30"
```

Convierte los valores y calcula la velocidad media en km/h.

El resultado debe ser decimal.

---

## Ejercicio 72 — Media

Crea tres números como `String`:

```text
"15"
"18"
"22"
```

Convierte los tres valores y calcula su media.

El resultado debe ser `Double`.

---

## Ejercicio 73 — Conversión segura

Crea:

```kotlin
val valueText = "125"
```

Utiliza `toIntOrNull()`.

Si la conversión es correcta, muestra el número.

Si no es correcta, muestra:

```text
Valor no válido
```

---

## Ejercicio 74 — Conversión segura decimal

Crea:

```kotlin
val valueText = "15.75"
```

Utiliza `toDoubleOrNull()`.

Si la conversión es correcta, calcula el doble del número.

Si no es correcta, muestra:

```text
Valor no válido
```

---

# Conceptos que debes dominar

Al terminar estos ejercicios deberías saber utilizar correctamente:

```kotlin
toInt()
toLong()
toFloat()
toDouble()
toString()

toIntOrNull()
toLongOrNull()
toFloatOrNull()
toDoubleOrNull()
```

Y comprender especialmente estas diferencias:

| Situación | Ejemplo |
|---|---|
| `Int` → `Double` | `number.toDouble()` |
| `Double` → `Int` | `number.toInt()` |
| `String` → `Int` | `text.toInt()` |
| `String` → `Double` | `text.toDouble()` |
| Número → `String` | `number.toString()` |
| `String` → `Int` seguro | `text.toIntOrNull()` |
| `String` → `Double` seguro | `text.toDoubleOrNull()` |

## Orden recomendado

La progresión que seguiremos después puede ser:

```text
Tipos básicos
     ↓
Conversión de tipos
     ↓
Conversión segura
     ↓
Entrada por consola
     ↓
readln()
     ↓
readln() + conversiones
     ↓
readln() + toIntOrNull()
     ↓
Nulabilidad
```

De esta forma, cuando aparezca algo como:

```kotlin
val age = readln().toIntOrNull()
```

el alumno ya habrá aprendido por separado qué significa **leer un `String`**, qué significa **convertirlo a `Int`** y por qué una conversión puede producir `null`.