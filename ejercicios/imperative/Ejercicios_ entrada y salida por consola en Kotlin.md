# Ejercicios: entrada y salida por consola en Kotlin

## Objetivo

Estos ejercicios están diseñados para practicar la **entrada y salida de datos mediante la consola en Kotlin**.

Se trabajarán progresivamente:

- `print()`
- `println()`
- `readln()`
- Lectura de `String`
- Conversión mediante `toInt()`
- Conversión mediante `toLong()`
- Conversión mediante `toDouble()`
- Conversión mediante `toFloat()`
- Conversión mediante `toBoolean()`
- Interpolación de strings
- Plantillas de strings
- Lectura de varios datos
- Operaciones con los datos introducidos
- Formateo de resultados
- Combinación de entrada, procesamiento y salida
- Validación básica de datos
- Programas interactivos por consola

**Importante:** todos los identificadores utilizados en el código están en inglés. El texto explicativo y las cadenas mostradas por los programas están en español.

---

# Nivel 1 — Salida por consola

## Ejercicio 1 — Primer mensaje

Escribe un programa que muestre por consola:

```text
Hola, mundo
```

---

## Ejercicio 2 — Varias líneas

Muestra exactamente:

```text
Nombre: Carlos
Edad: 25
Ciudad: Madrid
```

Utiliza `println()`.

---

## Ejercicio 3 — Una sola línea

Muestra:

```text
Kotlin es un lenguaje de programación
```

Utiliza `print()`.

---

## Ejercicio 4 — Varias llamadas

Muestra:

```text
Hola
Me llamo Carlos
Estoy aprendiendo Kotlin
```

Cada línea debe escribirse mediante una llamada independiente a `println()`.

---

## Ejercicio 5 — `print()` frente a `println()`

Escribe un programa que produzca:

```text
Hola Carlos
Bienvenido
```

Utiliza una combinación de `print()` y `println()`.

---

# Nivel 2 — Primera entrada de datos

## Ejercicio 6 — Leer un nombre

Pide al usuario su nombre.

Después muestra:

```text
Hola, Carlos
```

si el usuario introduce:

```text
Carlos
```

---

## Ejercicio 7 — Leer una ciudad

Pide al usuario que introduzca su ciudad.

Después muestra:

```text
Vives en Madrid
```

si introduce:

```text
Madrid
```

---

## Ejercicio 8 — Nombre y apellido

Pide:

1. el nombre;
2. el apellido.

Después muestra:

```text
Nombre completo: Carlos García
```

---

## Ejercicio 9 — Tres datos

Pide al usuario:

- nombre;
- ciudad;
- profesión.

Muestra los tres datos en una sola línea.

Por ejemplo:

```text
Carlos - Madrid - Programador
```

---

## Ejercicio 10 — Presentación

Crea un programa que pregunte:

```text
¿Cuál es tu nombre?
¿Cuántos años tienes?
¿Dónde vives?
```

Después muestra:

```text
Te llamas Carlos, tienes 25 años y vives en Madrid.
```

---

# Nivel 3 — Leer números

## Ejercicio 11 — Leer un entero

Pide al usuario un número entero.

Después muestra:

```text
Has introducido: 25
```

El valor debe almacenarse como `Int`.

---

## Ejercicio 12 — Sumar dos números

Pide dos números enteros.

Muestra su suma.

Por ejemplo:

```text
Primer número: 8
Segundo número: 5

Resultado: 13
```

---

## Ejercicio 13 — Restar dos números

Pide dos números enteros y muestra su resta.

Por ejemplo:

```text
Primer número: 10
Segundo número: 4
Resultado: 6
```

---

## Ejercicio 14 — Multiplicar

Pide dos números enteros y muestra su producto.

---

## Ejercicio 15 — Dividir

Pide dos números enteros y muestra el resultado de dividir el primero entre el segundo.

Por ejemplo:

```text
Primer número: 20
Segundo número: 4
Resultado: 5
```

---

## Ejercicio 16 — Las cuatro operaciones

Pide dos números enteros.

Muestra:

```text
Suma: ...
Resta: ...
Multiplicación: ...
División: ...
```

---

# Nivel 4 — Conversión de tipos

## Ejercicio 17 — `String` a `Int`

Lee un número mediante `readln()`.

Convierte el texto obtenido a `Int`.

Después muestra el doble del número.

---

## Ejercicio 18 — Edad

Pide al usuario su edad.

Convierte la entrada a `Int`.

Muestra:

```text
Tienes 25 años.
```

---

## Ejercicio 19 — Próximo año

Pide la edad actual.

Muestra cuántos años tendrá el usuario el próximo año.

Por ejemplo:

```text
Edad actual: 25
El próximo año tendrás 26 años.
```

---

## Ejercicio 20 — Edad dentro de diez años

Pide la edad actual y muestra:

```text
Dentro de 10 años tendrás X años.
```

---

## Ejercicio 21 — `Double`

Pide al usuario un número decimal.

Guárdalo como `Double`.

Muestra:

```text
Has introducido: 12.5
```

---

## Ejercicio 22 — Área de un círculo

Pide el radio de un círculo.

Calcula su área mediante:

```text
π × radio²
```

Muestra el resultado.

---

## Ejercicio 23 — Área de un rectángulo

Pide:

- base;
- altura.

Calcula el área.

Por ejemplo:

```text
Base: 10
Altura: 5
Área: 50
```

---

## Ejercicio 24 — Precio con descuento

Pide:

- precio original;
- porcentaje de descuento.

Calcula el precio final.

Por ejemplo:

```text
Precio: 100
Descuento: 20
Precio final: 80
```

---

# Nivel 5 — Interpolación de strings

## Ejercicio 25 — Variables dentro de un mensaje

Dadas:

```kotlin
val name = "Carlos"
val age = 25
```

Muestra:

```text
Carlos tiene 25 años.
```

Utiliza interpolación de strings.

---

## Ejercicio 26 — Expresiones dentro de strings

Dadas:

```kotlin
val firstNumber = 10
val secondNumber = 5
```

Muestra:

```text
10 + 5 = 15
```

La suma debe realizarse directamente dentro de la plantilla de string.

---

## Ejercicio 27 — Datos personales

Lee:

- nombre;
- edad;
- ciudad.

Muestra una frase utilizando interpolación.

---

## Ejercicio 28 — Resultado de operaciones

Pide dos números y muestra:

```text
10 + 5 = 15
10 - 5 = 5
10 * 5 = 50
```

Utiliza interpolación de strings.

---

# Nivel 6 — Entrada de varios datos

## Ejercicio 29 — Datos de un producto

Pide:

- nombre del producto;
- precio;
- cantidad.

Después muestra:

```text
Producto: Laptop
Precio: 900.0 €
Cantidad: 2
Total: 1800.0 €
```

---

## Ejercicio 30 — Compra

Pide:

- nombre de un producto;
- precio;
- cantidad.

Calcula el coste total.

Después muestra una pequeña factura por consola.

---

## Ejercicio 31 — Conversión de temperatura

Pide una temperatura en grados Celsius.

Convierte a Fahrenheit mediante:

```text
F = C × 9 / 5 + 32
```

Muestra ambas temperaturas.

---

## Ejercicio 32 — Conversión de distancia

Pide una distancia en kilómetros.

Convierte a:

- metros;
- centímetros.

Muestra los tres valores.

---

## Ejercicio 33 — Conversión de tiempo

Pide una cantidad de segundos.

Calcula cuántas:

- horas;
- minutos;
- segundos

representa esa cantidad.

Por ejemplo:

```text
Segundos: 3672

Horas: 1
Minutos: 1
Segundos: 12
```

---

# Nivel 7 — Entrada y salida con cálculos

## Ejercicio 34 — Media de tres números

Pide tres números.

Calcula su media y muestra el resultado.

---

## Ejercicio 35 — Área y perímetro

Pide:

- base;
- altura.

Calcula:

- área;
- perímetro.

Muestra ambos resultados.

---

## Ejercicio 36 — Velocidad

Pide:

- distancia en kilómetros;
- tiempo en horas.

Calcula la velocidad:

```text
velocidad = distancia / tiempo
```

Muestra el resultado en km/h.

---

## Ejercicio 37 — Salario

Pide:

- salario mensual;
- número de meses trabajados.

Calcula cuánto dinero se ha ganado durante ese periodo.

---

## Ejercicio 38 — Precio final

Pide:

- precio;
- porcentaje de IVA.

Calcula el precio final.

Por ejemplo:

```text
Precio: 100
IVA: 21
Precio final: 121
```

---

## Ejercicio 39 — Precio con IVA y descuento

Pide:

- precio original;
- porcentaje de descuento;
- porcentaje de IVA.

Calcula:

1. precio después del descuento;
2. IVA;
3. precio final.

Muestra los tres valores.

---

# Nivel 8 — Operaciones con caracteres y strings

## Ejercicio 40 — Longitud de un texto

Pide al usuario que introduzca una palabra.

Muestra:

```text
La palabra tiene X caracteres.
```

---

## Ejercicio 41 — Primera letra

Pide una palabra.

Muestra su primera letra.

---

## Ejercicio 42 — Última letra

Pide una palabra.

Muestra su última letra.

---

## Ejercicio 43 — Mayúsculas y minúsculas

Pide un texto.

Muestra:

```text
Original: Kotlin
Mayúsculas: KOTLIN
Minúsculas: kotlin
```

---

## Ejercicio 44 — Nombre completo

Pide:

- nombre;
- apellido.

Construye el nombre completo.

Después muestra:

- nombre completo;
- longitud del nombre completo;
- nombre completo en mayúsculas.

---

## Ejercicio 45 — Repetir un texto

Pide:

- un texto;
- un número.

Muestra el texto repetido ese número de veces.

Por ahora puedes utilizar `repeat()`.

---

# Nivel 9 — Entrada y decisiones

## Ejercicio 46 — Número positivo o negativo

Pide un número entero.

Muestra si es:

- positivo;
- negativo;
- cero.

---

## Ejercicio 47 — Mayor de edad

Pide la edad.

Muestra:

```text
Eres mayor de edad.
```

o:

```text
Eres menor de edad.
```

---

## Ejercicio 48 — Número par o impar

Pide un número entero.

Indica si es par o impar.

---

## Ejercicio 49 — Mayor de dos números

Pide dos números.

Muestra cuál es mayor.

Si son iguales, muestra:

```text
Los números son iguales.
```

---

## Ejercicio 50 — Mayor de tres números

Pide tres números.

Muestra cuál es el mayor.

---

# Nivel 10 — Validación básica de entrada

## Ejercicio 51 — Número dentro de un intervalo

Pide un número.

Indica si está entre 1 y 100.

---

## Ejercicio 52 — Nota válida

Pide una nota.

Una nota válida debe estar entre 0 y 10.

Muestra si la nota es válida.

---

## Ejercicio 53 — Edad válida

Pide una edad.

Considera válida una edad entre 0 y 120.

Muestra:

```text
Edad válida
```

o:

```text
Edad no válida
```

---

## Ejercicio 54 — Contraseña

Pide una contraseña.

Comprueba si coincide con una contraseña previamente almacenada.

Muestra:

```text
Contraseña correcta
```

o:

```text
Contraseña incorrecta
```

---

## Ejercicio 55 — Usuario y contraseña

Pide:

- nombre de usuario;
- contraseña.

Comprueba que ambos coincidan con unos valores previamente establecidos.

Muestra si el acceso ha sido concedido o rechazado.

---

# Nivel 11 — Formatear la salida

## Ejercicio 56 — Dos decimales

Pide un número decimal.

Muestra el resultado con exactamente dos decimales.

Investiga cómo utilizar `format()` para conseguirlo.

Por ejemplo:

```text
Precio: 12.50 €
```

---

## Ejercicio 57 — Precio

Pide un precio.

Muestra:

```text
Precio: 19.99 €
```

aunque el usuario introduzca más o menos decimales.

---

## Ejercicio 58 — Porcentaje

Pide un porcentaje decimal.

Muestra el valor con dos decimales y el símbolo `%`.

---

## Ejercicio 59 — Media formateada

Pide tres notas.

Calcula la media.

Muestra el resultado con exactamente dos decimales.

---

# Nivel 12 — Programas completos

## Ejercicio 60 — Calculadora sencilla

Crea una calculadora que pida:

```text
Primer número:
Segundo número:
```

Después muestra:

```text
Suma: ...
Resta: ...
Multiplicación: ...
División: ...
```

---

## Ejercicio 61 — Conversor de monedas

Pide:

- cantidad de euros;
- tipo de cambio.

Calcula cuántas unidades de la otra moneda corresponden a esos euros.

Muestra el resultado con dos decimales.

---

## Ejercicio 62 — Calculadora de IMC

Pide:

- peso en kilogramos;
- altura en metros.

Calcula:

```text
IMC = peso / altura²
```

Muestra el resultado con dos decimales.

---

## Ejercicio 63 — Factura

Pide:

- nombre del producto;
- precio;
- cantidad;
- porcentaje de descuento;
- porcentaje de IVA.

Calcula:

1. subtotal;
2. descuento;
3. precio después del descuento;
4. IVA;
5. total.

Muestra una factura organizada.

---

## Ejercicio 64 — Viaje

Pide:

- distancia del viaje;
- consumo del vehículo en litros cada 100 km;
- precio del combustible por litro.

Calcula:

- litros necesarios;
- coste total del combustible.

Muestra los resultados con dos decimales.

---

# Nivel 13 — Programas interactivos

## Ejercicio 65 — Presentación interactiva

Crea un programa que pregunte:

```text
¿Cuál es tu nombre?
¿Cuántos años tienes?
¿Cuál es tu ciudad?
¿Cuál es tu profesión?
```

Después genera una presentación completa:

```text
Hola, Carlos.
Tienes 25 años.
Vives en Madrid.
Eres programador.
```

---

## Ejercicio 66 — Calculadora de edad

Pide:

- año de nacimiento;
- año actual.

Calcula la edad aproximada.

Por ejemplo:

```text
Año de nacimiento: 1990
Año actual: 2026

Tienes aproximadamente 36 años.
```

---

## Ejercicio 67 — Conversor de tiempo

Pide una cantidad de segundos y muestra:

```text
Días: X
Horas: X
Minutos: X
Segundos: X
```

---

## Ejercicio 68 — Desglose de dinero

Pide una cantidad entera de euros.

Calcula cuántos billetes/monedas de cada denominación serían necesarios utilizando:

- 50 €
- 20 €
- 10 €
- 5 €
- 2 €
- 1 €

No es necesario utilizar bucles todavía.

---

# Nivel 14 — Retos

## Ejercicio 69 — Calculadora de sueldo

Pide:

- salario bruto mensual;
- porcentaje de impuestos;
- número de meses.

Calcula:

- salario neto mensual;
- salario neto anual.

Muestra todos los resultados con dos decimales.

---

## Ejercicio 70 — Tienda

Crea un programa que pida información sobre tres productos.

Para cada producto se debe introducir:

- nombre;
- precio;
- cantidad.

Calcula el total de la compra.

Después pide un porcentaje de descuento y calcula el precio final.

Muestra una factura.

---

## Ejercicio 71 — Conversor universal

Crea un programa que pida:

```text
Introduce una distancia en kilómetros:
```

y muestre:

```text
Metros: ...
Centímetros: ...
Millas: ...
```

Utiliza las conversiones correspondientes.

---

## Ejercicio 72 — Analizador de texto

Pide al usuario una frase.

Muestra:

```text
Frase: ...
Número de caracteres: ...
Primera letra: ...
Última letra: ...
Mayúsculas: ...
Minúsculas: ...
```

---

## Ejercicio 73 — Datos personales

Pide:

- nombre;
- apellido;
- edad;
- ciudad;
- código postal.

Después muestra una ficha:

```text
========================
DATOS PERSONALES
========================
Nombre: Carlos García
Edad: 25
Ciudad: Madrid
Código postal: 28001
========================
```

---

## Ejercicio 74 — Calculadora de viaje

Pide:

- distancia;
- velocidad media.

Calcula cuánto tiempo tardará el viaje.

Muestra el resultado en:

- horas;
- minutos.

Por ejemplo:

```text
Distancia: 450 km
Velocidad media: 90 km/h

Tiempo estimado: 5 horas y 0 minutos
```

---

# Nivel 15 — Retos finales

## Ejercicio 75 — Factura completa

Crea un programa que simule una factura.

Debe pedir:

- nombre del cliente;
- nombre del producto;
- precio;
- cantidad;
- descuento;
- IVA.

Debe mostrar una factura similar a:

```text
========================================
                 FACTURA
========================================

Cliente: Carlos García

Producto: Teclado
Precio: 50.00 €
Cantidad: 2

----------------------------------------
Subtotal:              100.00 €
Descuento:              10.00 €
Base imponible:         90.00 €
IVA:                    18.90 €
----------------------------------------
TOTAL:                 108.90 €
========================================
```

Todos los valores calculados deben aparecer con dos decimales.

---

## Ejercicio 76 — Calculadora de préstamo

Pide:

- cantidad solicitada;
- número de años;
- porcentaje de interés anual.

Calcula una estimación de:

- intereses totales;
- cantidad total a devolver;
- coste medio mensual.

No es necesario utilizar todavía una fórmula financiera de cuota; utiliza una aproximación sencilla.

---

## Ejercicio 77 — Analizador de nombre

Pide el nombre completo de una persona.

Muestra:

```text
Nombre completo: Carlos García López
Número de caracteres: 20
Mayúsculas: CARLOS GARCÍA LÓPEZ
Minúsculas: carlos garcía lópez
Primera letra: C
Última letra: z
```

---

## Ejercicio 78 — Registro de usuario

Crea un programa que solicite:

```text
Nombre de usuario:
Nombre:
Edad:
Ciudad:
```

Después muestra una ficha de registro.

El programa debe comprobar que la edad sea válida antes de mostrar los datos.

---

## Ejercicio 79 — Conversor de temperatura completo

Pide:

```text
Introduce una temperatura en Celsius:
```

Muestra:

```text
Celsius: 25.00 °C
Fahrenheit: 77.00 °F
Kelvin: 298.15 K
```

Todos los resultados deben tener dos decimales.

---

## Ejercicio 80 — Reto final

Crea un programa completo de consola que simule una **compra en una tienda**.

El programa debe:

1. pedir el nombre del cliente;
2. pedir tres productos;
3. pedir precio y cantidad de cada producto;
4. calcular el subtotal de cada producto;
5. calcular el subtotal general;
6. pedir un porcentaje de descuento;
7. calcular el descuento;
8. calcular la base imponible;
9. pedir el porcentaje de IVA;
10. calcular el IVA;
11. calcular el total;
12. mostrar una factura completa.

La salida debe ser clara y organizada.

Por ejemplo:

```text
========================================
              TIENDA KOTLIN
========================================

Cliente: Carlos García

Producto 1: Teclado
Precio: 50.00 €
Cantidad: 2
Subtotal: 100.00 €

Producto 2: Ratón
Precio: 25.00 €
Cantidad: 1
Subtotal: 25.00 €

Producto 3: Monitor
Precio: 300.00 €
Cantidad: 1
Subtotal: 300.00 €

----------------------------------------
Subtotal:              425.00 €
Descuento:              42.50 €
Base imponible:         382.50 €
IVA:                     80.33 €
----------------------------------------
TOTAL:                  462.83 €
========================================

Gracias por su compra.
```

### Condiciones

El programa debe utilizar:

- `print()`;
- `println()`;
- `readln()`;
- conversiones de tipos;
- variables;
- operaciones aritméticas;
- interpolación de strings;
- `format()` para los valores monetarios;
- `if` para las validaciones necesarias.

Todavía no es necesario utilizar funciones, colecciones ni bucles.

---

# Resumen

| Elemento | Para qué sirve |
|---|---|
| `print()` | Escribir sin salto de línea |
| `println()` | Escribir y terminar con un salto de línea |
| `readln()` | Leer una línea de la consola |
| `toInt()` | Convertir a `Int` |
| `toLong()` | Convertir a `Long` |
| `toDouble()` | Convertir a `Double` |
| `toFloat()` | Convertir a `Float` |
| `toBoolean()` | Convertir a `Boolean` |
| `$variable` | Insertar una variable en un string |
| `${expression}` | Insertar una expresión en un string |
| `format()` | Formatear valores para mostrarlos |

## Objetivo final

Al terminar estos ejercicios deberías ser capaz de construir programas sencillos de consola siguiendo este esquema:

```text
ENTRADA
   ↓
readln()
   ↓
CONVERSIÓN
   ↓
PROCESAMIENTO
   ↓
SALIDA
   ↓
print() / println()
```

y ser capaz de crear pequeños programas interactivos que reciban información del usuario, la procesen y presenten los resultados de forma clara.