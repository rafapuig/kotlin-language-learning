# Ejercicios: tipos anulables y operadores de nulabilidad en Kotlin

## Objetivo

Estos ejercicios están diseñados para practicar los **tipos anulables de Kotlin** y los principales operadores y construcciones relacionados con la nulabilidad:

- Tipos anulables: `String?`, `Int?`, etc.
- `null`
- Operador de acceso seguro `?.`
- Operador Elvis `?:`
- Operador de aserción no nula `!!`
- `let` con valores anulables
- Comprobaciones de nulidad
- `isNullOrEmpty()`
- `isNullOrBlank()`
- Conversión segura `as?`
- Combinación de operadores de nulabilidad
- Encadenamiento de accesos seguros
- Uso de valores anulables en funciones
- Diferencias entre valores anulables y no anulables

**Importante:** todos los identificadores utilizados en el código están en inglés. El texto explicativo y las cadenas mostradas por los programas están en español.

---

# Nivel 1 — Conceptos básicos

### Ejercicio 1 — Una variable anulable

Declara una variable llamada `name` que pueda contener un `String` o `null`.

Asígnale inicialmente el valor `"Carlos"` e imprímela.

Después asígnale `null` e imprímela de nuevo.

---

### Ejercicio 2 — String no anulable frente a String anulable

Declara:

- una variable `firstName` de tipo `String`;
- una variable `lastName` de tipo `String?`.

Asigna un nombre a `firstName` y `null` a `lastName`.

Imprime ambas variables.

---

### Ejercicio 3 — ¿Puede contener null?

Indica cuáles de las siguientes declaraciones son válidas y cuáles producen un error:

```kotlin
val name: String = null
val name: String? = null
val age: Int = null
val age: Int? = null
val active: Boolean? = null
```

Después explica brevemente por qué.

---

### Ejercicio 4 — Cambiar entre valor y null

Crea una variable:

```kotlin
var score: Int? = 100
```

Haz que posteriormente contenga:

1. `50`
2. `0`
3. `null`
4. `75`

Después de cada asignación, imprime su contenido.

---

### Ejercicio 5 — El compilador protege contra null

Observa:

```kotlin
val name: String? = "Carlos"

println(name.length)
```

Explica por qué Kotlin no permite esta operación.

Después modifica el programa para poder obtener la longitud de `name` de forma segura.

---

# Nivel 2 — Operador `?.`

### Ejercicio 6 — Acceso seguro

Dada la siguiente variable:

```kotlin
val name: String? = "Carlos"
```

Utiliza `?.` para imprimir su longitud.

Después cambia `name` a `null`.

El programa debe seguir funcionando sin lanzar una excepción.

---

### Ejercicio 7 — Resultado nullable

Observa:

```kotlin
val name: String? = "Carlos"
val length = name?.length
```

Imprime `length`.

Después cambia `name` a `null` y vuelve a imprimir `length`.

¿Qué tipo crees que tiene `length`?

---

### Ejercicio 8 — Llamar a métodos de forma segura

Dada:

```kotlin
val text: String? = "Kotlin"
```

Utiliza `?.` para:

1. obtener su longitud;
2. convertirlo a mayúsculas;
3. convertirlo a minúsculas;
4. obtener el primer carácter.

El programa debe funcionar también si `text` contiene `null`.

---

### Ejercicio 9 — Encadenamiento de `?.`

Dada:

```kotlin
val text: String? = "Kotlin"
```

Obtén de forma segura:

- la longitud;
- el primer carácter;
- el último carácter.

No debes realizar ninguna comprobación explícita con `if`.

Después repite el ejercicio utilizando `null`.

---

### Ejercicio 10 — Propiedades anulables

Crea una clase:

```kotlin
class Person(
    val name: String,
    val age: Int
)
```

Crea una variable:

```kotlin
val person: Person? = Person("Ana", 25)
```

Utiliza `?.` para imprimir:

- el nombre;
- la edad.

Después cambia `person` a `null`.

---

# Nivel 3 — Operador Elvis `?:`

### Ejercicio 11 — Valor por defecto

Dada:

```kotlin
val name: String? = null
```

Utiliza `?:` para obtener `"Desconocido"` cuando `name` sea `null`.

Imprime el resultado.

---

### Ejercicio 12 — Nombre por defecto

Crea una función:

```kotlin
fun getDisplayName(name: String?): String
```

La función debe devolver:

- `name` si no es `null`;
- `"Invitado"` si es `null`.

---

### Ejercicio 13 — Edad por defecto

Crea:

```kotlin
fun getAge(age: Int?): Int
```

Si `age` es `null`, debe devolver `0`.

Prueba la función con:

- `25`;
- `18`;
- `0`;
- `null`.

---

### Ejercicio 14 — Mensaje por defecto

Dada:

```kotlin
val message: String? = null
```

Obtén un mensaje no anulable que contenga:

```text
Sin mensaje
```

si `message` es `null`.

---

### Ejercicio 15 — Resultado de una operación

Dada:

```kotlin
val text: String? = "Kotlin"
```

Obtén la longitud de `text`.

Si `text` es `null`, el resultado debe ser `0`.

El resultado final debe ser un `Int` no anulable.

---

# Nivel 4 — Combinando `?.` y `?:`

### Ejercicio 16 — Longitud con valor predeterminado

Dada:

```kotlin
val text: String? = null
```

Obtén su longitud de manera que:

- si tiene texto, obtengas su longitud;
- si es `null`, obtengas `0`.

---

### Ejercicio 17 — Primer carácter

Dada:

```kotlin
val text: String? = "Kotlin"
```

Obtén el primer carácter.

Si `text` es `null`, utiliza `'?'`.

El resultado final debe ser un `Char` no anulable.

---

### Ejercicio 18 — Nombre de una persona

Utiliza:

```kotlin
class Person(
    val name: String
)
```

Crea:

```kotlin
val person: Person? = null
```

Obtén el nombre de la persona.

Si `person` es `null`, utiliza:

```text
Desconocido
```

---

### Ejercicio 19 — Nombre y longitud

Dada:

```kotlin
val name: String? = null
```

Obtén un mensaje como:

```text
Nombre: Desconocido
Longitud: 11
```

La longitud debe corresponder al nombre que finalmente se está mostrando.

---

### Ejercicio 20 — Varias propiedades anulables

Crea:

```kotlin
class Person(
    val name: String?,
    val city: String?,
    val age: Int?
)
```

Crea una persona con algunos valores `null`.

Muestra:

```text
Nombre: ...
Ciudad: ...
Edad: ...
```

Utiliza valores predeterminados cuando alguna propiedad sea `null`.

---

# Nivel 5 — Comprobaciones con `if`

### Ejercicio 21 — Comprobar null

Dada:

```kotlin
val name: String? = "Carlos"
```

Utiliza `if` para comprobar si `name` es `null`.

Muestra:

```text
El nombre existe
```

o:

```text
El nombre es null
```

---

### Ejercicio 22 — Smart cast

Observa:

```kotlin
val name: String? = "Carlos"

if (name != null) {
    println(name.length)
}
```

Explica por qué dentro del `if` puedes utilizar `name.length` aunque `name` haya sido declarado como `String?`.

---

### Ejercicio 23 — Comprobar y utilizar

Crea:

```kotlin
fun printName(name: String?)
```

Si `name` no es `null`, imprime:

```text
El nombre tiene X caracteres
```

Si es `null`, imprime:

```text
No se proporcionó ningún nombre
```

---

### Ejercicio 24 — Edad válida

Crea:

```kotlin
fun printAge(age: Int?)
```

Debe mostrar:

- `"Edad: X"` si existe una edad;
- `"Edad desconocida"` si es `null`.

---

# Nivel 6 — Operador `!!`

### Ejercicio 25 — Aserción de no nulidad

Dada:

```kotlin
val name: String? = "Carlos"
```

Utiliza `!!` para obtener la longitud del nombre.

---

### Ejercicio 26 — ¿Qué ocurre con null?

Modifica el ejercicio anterior para que:

```kotlin
val name: String? = null
```

Ejecuta el programa y observa qué ocurre.

Explica por qué se produce la excepción.

---

### Ejercicio 27 — Sustituir `!!`

Dado:

```kotlin
val name: String? = "Carlos"

println(name!!.length)
```

Reescribe el programa utilizando `?.` y `?:` en lugar de `!!`.

El programa no debe lanzar ninguna excepción aunque `name` sea `null`.

---

### Ejercicio 28 — ¿Es necesario `!!`?

Para cada caso, decide si utilizar `!!` es apropiado:

```kotlin
val name: String? = "Carlos"
println(name!!.length)
```

```kotlin
val name: String? = null
println(name!!.length)
```

```kotlin
val name: String? = getName()
println(name!!.length)
```

Explica los riesgos de utilizar `!!`.

---

# Nivel 7 — `let` y valores anulables

### Ejercicio 29 — Ejecutar código solamente si no es null

Dada:

```kotlin
val name: String? = "Carlos"
```

Utiliza `let` para imprimir:

```text
Nombre: Carlos
```

El código dentro de `let` no debe ejecutarse si `name` es `null`.

---

### Ejercicio 30 — Longitud con `let`

Dada:

```kotlin
val text: String? = "Kotlin"
```

Utiliza `let` para imprimir su longitud.

Prueba también con `null`.

---

### Ejercicio 31 — Procesar una edad

Crea:

```kotlin
val age: Int? = 25
```

Utiliza `let` para mostrar:

```text
La edad es 25
```

Si `age` es `null`, no debe mostrarse ningún mensaje.

---

### Ejercicio 32 — `let` con transformación

Dada:

```kotlin
val name: String? = "carlos"
```

Utiliza `let` para convertir el nombre a mayúsculas y mostrarlo.

---

### Ejercicio 33 — `let` frente a `?.`

Compara estas dos formas:

```kotlin
val name: String? = "Carlos"

name?.let {
    println(it.length)
}
```

y:

```kotlin
println(name?.length)
```

Explica qué diferencias observas.

---

# Nivel 8 — Funciones que reciben y devuelven valores anulables

### Ejercicio 34 — Buscar un usuario

Crea:

```kotlin
class User(
    val name: String
)
```

Crea una función:

```kotlin
fun findUser(id: Int): User?
```

La función debe devolver:

- un `User` para algunos identificadores;
- `null` para los demás.

Después llama a la función y muestra el nombre del usuario si existe.

---

### Ejercicio 35 — Buscar y obtener nombre

Utiliza la función del ejercicio anterior.

Obtén directamente el nombre del usuario utilizando `?.`.

Si no existe, muestra:

```text
Usuario no encontrado
```

---

### Ejercicio 36 — Buscar y obtener longitud

A partir de:

```kotlin
fun findUser(id: Int): User?
```

obtén la longitud del nombre del usuario.

Si el usuario no existe, devuelve `0`.

---

### Ejercicio 37 — Cadena de operaciones anulables

Crea:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val name: String?
)
```

Dado:

```kotlin
val user: User? = ...
```

Obtén de forma segura el nombre:

```text
user → profile → name
```

Si cualquiera de los elementos es `null`, utiliza `"Desconocido"`.

---

# Nivel 9 — Encadenamiento de `?.`

### Ejercicio 38 — Objeto anidado

Crea:

```kotlin
class Address(
    val city: String?
)

class Person(
    val address: Address?
)
```

Dada una persona que puede ser `null`, obtiene su ciudad utilizando solamente accesos seguros.

---

### Ejercicio 39 — Cadena completa

Crea:

```kotlin
class Company(
    val address: Address?
)

class Address(
    val city: City?
)

class City(
    val name: String?
)
```

Obtén el nombre de la ciudad mediante una única expresión utilizando accesos seguros.

Si cualquier elemento es `null`, el resultado debe ser `null`.

---

### Ejercicio 40 — Cadena con valor predeterminado

Modifica el ejercicio anterior para que el resultado final sea:

```text
Ciudad desconocida
```

cuando no sea posible obtener el nombre.

---

### Ejercicio 41 — Cadena más compleja

Crea:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val address: Address?
)

class Address(
    val city: String?
)
```

Obtén la ciudad utilizando:

- `?.`
- `?:`

No utilices `!!`.

---

# Nivel 10 — `isNullOrEmpty()` e `isNullOrBlank()`

### Ejercicio 42 — Cadena vacía

Dada:

```kotlin
val text: String? = ""
```

Utiliza `isNullOrEmpty()` para determinar si la cadena está vacía o es `null`.

---

### Ejercicio 43 — Cadena con espacios

Dada:

```kotlin
val text: String? = "   "
```

Comprueba si contiene únicamente espacios.

Investiga qué diferencia existe entre:

```kotlin
isNullOrEmpty()
```

e:

```kotlin
isNullOrBlank()
```

---

### Ejercicio 44 — Validar un nombre

Crea:

```kotlin
fun isValidName(name: String?): Boolean
```

Debe devolver `false` cuando:

- `name` sea `null`;
- `name` sea `""`;
- `name` contenga únicamente espacios.

En cualquier otro caso debe devolver `true`.

---

### Ejercicio 45 — Mensaje para un campo vacío

Crea:

```kotlin
fun getMessage(message: String?): String
```

Debe devolver:

- el propio mensaje si contiene texto;
- `"Sin mensaje"` si es `null`, vacío o contiene únicamente espacios.

---

# Nivel 11 — Conversión segura `as?`

### Ejercicio 46 — Conversión segura

Dado:

```kotlin
val value: Any = "Kotlin"
```

Utiliza `as?` para intentar convertir `value` a `String`.

Guarda el resultado en una variable y muestra su contenido.

---

### Ejercicio 47 — Conversión que falla

Dado:

```kotlin
val value: Any = 42
```

Intenta convertirlo a `String` utilizando `as?`.

Observa el resultado.

¿Se produce una excepción?

---

### Ejercicio 48 — Conversión con valor predeterminado

Dado:

```kotlin
val value: Any = 42
```

Intenta convertirlo a `String`.

Si la conversión no es posible, muestra:

```text
No es un texto
```

---

### Ejercicio 49 — Función de conversión

Crea:

```kotlin
fun getText(value: Any): String
```

La función debe:

- devolver el texto si `value` es un `String`;
- devolver `"Valor no válido"` en cualquier otro caso.

Utiliza `as?`.

---

# Nivel 12 — Combinaciones

### Ejercicio 50 — Buscar, acceder y proporcionar un valor

Crea una función:

```kotlin
fun findName(id: Int): String?
```

Después:

1. llama a la función;
2. utiliza `?.`;
3. utiliza `?:`;
4. muestra el resultado final.

No utilices `!!`.

---

### Ejercicio 51 — Buscar usuario

Utiliza:

```kotlin
class User(
    val name: String?,
    val age: Int?
)
```

Crea:

```kotlin
fun findUser(id: Int): User?
```

Obtén:

- el nombre, utilizando `"Desconocido"` como valor predeterminado;
- la edad, utilizando `0` como valor predeterminado.

---

### Ejercicio 52 — Procesar un usuario

Crea una función:

```kotlin
fun getUserDescription(user: User?): String
```

Debe devolver algo parecido a:

```text
Nombre: Carlos, Edad: 25
```

Si `user` es `null`, debe devolver:

```text
Usuario desconocido
```

Si alguna propiedad es `null`, debe utilizar un valor predeterminado apropiado.

---

### Ejercicio 53 — Nombre normalizado

Crea:

```kotlin
fun normalizeName(name: String?): String
```

La función debe:

1. comprobar si existe un nombre;
2. eliminar espacios al principio y al final;
3. convertirlo a mayúsculas;
4. devolver `"SIN NOMBRE"` si no existe o está vacío.

Intenta resolverlo utilizando operadores de nulabilidad en lugar de múltiples `if`.

---

### Ejercicio 54 — Obtener el dominio de un email

Crea:

```kotlin
fun getDomain(email: String?): String?
```

La función debe obtener la parte posterior a `@`.

Ejemplo:

```text
"alice@example.com" → "example.com"
```

Si `email` es `null`, el resultado debe ser `null`.

Si no contiene `@`, también debe devolver `null`.

---

### Ejercicio 55 — Dominio con valor predeterminado

Utiliza la función anterior para mostrar:

```text
Dominio: example.com
```

o:

```text
Dominio desconocido
```

Utiliza `?.` y `?:` donde sea apropiado.

---

# Nivel 13 — Retos

### Ejercicio 56 — Sistema de configuración

Crea:

```kotlin
class Configuration(
    val host: String?,
    val port: Int?,
    val username: String?
)
```

Crea una configuración en la que algunos valores sean `null`.

Genera un texto:

```text
Host: localhost
Port: 8080
User: Invitado
```

Utiliza valores predeterminados cuando sea necesario.

---

### Ejercicio 57 — Información de una película

Crea:

```kotlin
class Movie(
    val title: String?,
    val director: Person?
)

class Person(
    val name: String?
)
```

Dada una película que puede ser `null`, muestra:

```text
Título: ...
Director: ...
```

Todos los valores deben tener un valor predeterminado razonable.

No utilices `!!`.

---

### Ejercicio 58 — Perfil de usuario

Crea:

```kotlin
class User(
    val name: String?,
    val profile: Profile?
)

class Profile(
    val city: String?,
    val country: String?
)
```

Genera:

```text
Nombre: Carlos
Ciudad: Madrid
País: España
```

Todos los valores pueden ser `null`.

El programa debe funcionar correctamente en cualquier combinación posible de valores.

---

### Ejercicio 59 — Procesar una lista de nombres

Dada:

```kotlin
val names = listOf(
    "Carlos",
    null,
    "Ana",
    "",
    null,
    "Pedro"
)
```

Recorre la lista y muestra solamente los nombres que no sean:

- `null`;
- vacíos;
- blancos.

---

### Ejercicio 60 — Contar valores válidos

Utilizando la misma lista del ejercicio anterior, calcula cuántos nombres válidos existen.

Un nombre válido:

- no es `null`;
- no está vacío;
- no contiene únicamente espacios.

---

### Ejercicio 61 — Primer nombre válido

Dada una lista de nombres anulables:

```kotlin
val names = listOf(
    null,
    "",
    "   ",
    "Ana",
    "Carlos"
)
```

Obtén el primer nombre válido.

Si no existe ninguno, utiliza:

```text
Sin nombre
```

---

### Ejercicio 62 — Cadena completa de nulabilidad

Crea las siguientes clases:

```kotlin
class Company(
    val owner: User?
)

class User(
    val profile: Profile?
)

class Profile(
    val address: Address?
)

class Address(
    val city: City?
)

class City(
    val name: String?
)
```

Obtén el nombre de la ciudad mediante una única expresión.

Si no existe ninguna ciudad, devuelve:

```text
Ciudad desconocida
```

No puedes utilizar `!!`.

---

### Ejercicio 63 — Reescribir código evitando `!!`

Dado:

```kotlin
fun getName(user: User?): String {
    return user!!.profile!!.name!!
}
```

Reescribe la función para que:

- no utilice `!!`;
- nunca lance una excepción por `null`;
- devuelva `"Desconocido"` cuando no pueda obtener el nombre.

---

### Ejercicio 64 — Reescribir usando `?.` y `?:`

Dado:

```kotlin
fun getAge(user: User?): Int {
    if (user != null) {
        if (user.age != null) {
            return user.age
        }
    }

    return 0
}
```

Reescribe la función utilizando `?.` y `?:`.

Intenta conseguir una solución de una sola expresión.

---

### Ejercicio 65 — Reescribir utilizando `let`

Dado:

```kotlin
val name: String? = "Carlos"

if (name != null) {
    println("Nombre: $name")
}
```

Reescribe el código utilizando `let`.

---

### Ejercicio 66 — Elegir el operador adecuado

Para cada situación, decide qué construcción utilizarías principalmente:

- `?.`
- `?:`
- `!!`
- `let`
- `as?`
- `isNullOrBlank()`

#### A

Quieres acceder a una propiedad que podría pertenecer a un objeto `null`.

#### B

Quieres proporcionar un valor alternativo cuando un valor es `null`.

#### C

Sabes con certeza que un valor nullable nunca será `null`, pero el compilador no puede saberlo.

#### D

Quieres ejecutar un bloque de código solamente cuando un valor no sea `null`.

#### E

Quieres intentar convertir un objeto a otro tipo sin provocar una excepción.

#### F

Quieres comprobar si un `String?` es `null`, vacío o contiene solamente espacios.

---

# Nivel 14 — Retos finales

### Ejercicio 67 — Login

Crea:

```kotlin
class User(
    val username: String?,
    val password: String?
)
```

Crea una función:

```kotlin
fun login(user: User?): String
```

Debe devolver:

```text
Bienvenido, Carlos
```

cuando exista un usuario con nombre.

Si el usuario es `null`:

```text
Usuario desconocido
```

Si el nombre es `null` o está vacío:

```text
Nombre de usuario no válido
```

No utilices `!!`.

---

### Ejercicio 68 — Datos de un producto

Crea:

```kotlin
class Product(
    val name: String?,
    val price: Double?,
    val category: Category?
)

class Category(
    val name: String?
)
```

Genera una descripción:

```text
Producto: Laptop
Precio: 999.99
Categoría: Electrónica
```

Todos los valores pueden ser `null`.

Utiliza operadores de nulabilidad para gestionar todos los casos.

---

### Ejercicio 69 — Obtener información de una API

Supón que una API puede devolver:

```kotlin
class Response(
    val data: Data?
)

class Data(
    val user: User?
)

class User(
    val name: String?
)
```

Obtén el nombre del usuario.

Si cualquiera de los niveles es `null`, muestra:

```text
Usuario desconocido
```

Intenta resolverlo mediante una única expresión.

---

### Ejercicio 70 — Reto final

Crea un pequeño sistema de información de usuarios:

```kotlin
class User(
    val name: String?,
    val profile: Profile?
)

class Profile(
    val email: String?,
    val address: Address?
)

class Address(
    val city: String?,
    val country: String?
)
```

Crea una función:

```kotlin
fun getUserSummary(user: User?): String
```

Debe producir información como:

```text
Nombre: Carlos
Email: carlos@example.com
Ciudad: Madrid
País: España
```

Pero cualquier dato puede ser `null`.

Si no existe:

- nombre → `"Desconocido"`;
- email → `"Sin email"`;
- ciudad → `"Ciudad desconocida"`;
- país → `"País desconocido"`.

**Condiciones:**

- No utilizar `!!`.
- Utilizar `?.` cuando sea apropiado.
- Utilizar `?:` cuando sea apropiado.
- Utilizar `let` al menos una vez donde tenga sentido.
- La función debe funcionar correctamente incluso cuando `user` sea `null`.
- Intenta mantener el código sencillo y legible.

---

# Resumen de operadores practicados

| Construcción | Uso principal |
|---|---|
| `String?` | Indicar que un valor puede ser `null` |
| `null` | Representar ausencia de valor |
| `?.` | Acceder de forma segura a un valor nullable |
| `?:` | Proporcionar un valor alternativo |
| `!!` | Afirmar que un valor no es `null` |
| `let` | Ejecutar código cuando existe un valor |
| `as?` | Realizar una conversión segura |
| `isNullOrEmpty()` | Comprobar `null` o vacío |
| `isNullOrBlank()` | Comprobar `null`, vacío o espacios |

## Objetivo final

Al terminar estos ejercicios deberías ser capaz de leer código como:

```kotlin
val city = user?.profile?.address?.city ?: "Ciudad desconocida"
```

y entender exactamente qué ocurre cuando cada uno de los objetos intermedios contiene `null`.