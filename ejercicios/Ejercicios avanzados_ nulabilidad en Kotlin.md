# Ejercicios avanzados: nulabilidad en Kotlin

## Objetivo

Estos ejercicios están diseñados para practicar la nulabilidad de Kotlin a un nivel más avanzado.

Se trabajarán especialmente:

- Tipos anulables (`String?`, `Int?`, etc.)
- `?.`
- `?:`
- `!!`
- `let`
- `run`
- `also`
- `takeIf`
- `takeUnless`
- Smart casts
- Encadenamiento de operadores seguros
- Valores anulables devueltos por funciones
- Conversión segura con `as?`
- Expresiones complejas con varios niveles de nulabilidad
- Transformación de código imperativo en expresiones
- Eliminación de `if` innecesarios
- Diferencias entre `null`, vacío y blanco
- Nulabilidad dentro de colecciones
- Combinación de varios operadores de nulabilidad

**Importante:** todos los identificadores utilizados en el código están en inglés. El texto explicativo y las cadenas mostradas por los programas están en español.

---

# Nivel 1 — Transformar comprobaciones de null

En estos ejercicios debes transformar código existente intentando conseguir una solución más idiomática.

## Ejercicio 1 — Eliminar un `if`

Dado:

```kotlin
val name: String? = "Carlos"

if (name != null) {
    println(name.length)
}
```

Reescribe el código utilizando `?.`.

No utilices `if`.

---

## Ejercicio 2 — `if` + valor alternativo

Dado:

```kotlin
val name: String? = null

val result: String

if (name != null) {
    result = name
} else {
    result = "Desconocido"
}

println(result)
```

Reescribe el código utilizando `?:`.

La variable `result` debe ser un `String` no anulable.

---

## Ejercicio 3 — Retorno anticipado

Dada:

```kotlin
fun getName(name: String?): String {
    if (name != null) {
        return name
    }

    return "Desconocido"
}
```

Reescribe la función utilizando una única expresión.

---

## Ejercicio 4 — Longitud

Dada:

```kotlin
fun getLength(text: String?): Int {
    if (text != null) {
        return text.length
    }

    return 0
}
```

Reescribe la función utilizando `?.` y `?:`.

Intenta hacerlo mediante una única expresión.

---

## Ejercicio 5 — Primera letra

Dada:

```kotlin
fun getFirstChar(text: String?): Char {
    if (text != null) {
        return text.first()
    }

    return '?'
}
```

Reescribe la función utilizando `?.` y `?:`.

---

# Nivel 2 — Eliminar `!!`

## Ejercicio 6 — Sustituir `!!`

Dado:

```kotlin
fun getNameLength(name: String?): Int {
    return name!!.length
}
```

Reescribe la función sin utilizar `!!`.

Debe devolver `0` cuando `name` sea `null`.

---

## Ejercicio 7 — Varias propiedades

Dada:

```kotlin
class User(
    val name: String?,
    val age: Int?
)
```

Y:

```kotlin
fun getDescription(user: User?): String {
    return "${user!!.name!!} - ${user!!.age!!}"
}
```

Reescribe la función sin utilizar `!!`.

Utiliza:

- `?.`
- `?:`

---

## Ejercicio 8 — Objeto anidado

Dadas:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val name: String?
)
```

La siguiente función utiliza `!!`:

```kotlin
fun getName(user: User?): String {
    return user!!.profile!!.name!!
}
```

Reescríbela sin utilizar `!!`.

Debe devolver `"Desconocido"` cuando no pueda obtener el nombre.

---

## Ejercicio 9 — Cuatro niveles

Dadas:

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
    val city: String?
)
```

Dada una variable:

```kotlin
val company: Company? = ...
```

Obtén la ciudad de forma segura.

Si no existe, devuelve:

```text
Ciudad desconocida
```

Intenta resolverlo mediante una única expresión.

---

# Nivel 3 — `let` correctamente

## Ejercicio 10 — Ejecutar solamente si existe

Dado:

```kotlin
val name: String? = "Carlos"

if (name != null) {
    println("Nombre: $name")
}
```

Reescribe el código utilizando `let`.

---

## Ejercicio 11 — Transformación con `let`

Dado:

```kotlin
val name: String? = "carlos"
```

Utiliza `let` para obtener:

```text
CARLOS
```

El resultado debe almacenarse en una variable `String?`.

---

## Ejercicio 12 — `let` y Elvis

Dado:

```kotlin
val name: String? = null
```

Utiliza `let` y `?:` para producir:

```text
Nombre: Carlos
```

cuando el nombre exista y:

```text
Sin nombre
```

cuando sea `null`.

---

## Ejercicio 13 — Devolver desde una función

Crea:

```kotlin
fun formatName(name: String?): String
```

Utiliza `let` para transformar el nombre a mayúsculas.

Si es `null`, devuelve:

```text
Sin nombre
```

Intenta escribir la función como una única expresión.

---

## Ejercicio 14 — Evitar `let` innecesario

Analiza:

```kotlin
val length = name?.let {
    it.length
}
```

¿Podría escribirse de una forma más sencilla utilizando directamente `?.`?

Reescribe el código.

---

## Ejercicio 15 — Decidir cuándo utilizar `let`

Compara:

```kotlin
name?.let {
    println(it.length)
}
```

con:

```kotlin
println(name?.length)
```

Explica cuál utilizarías si:

1. solamente quieres obtener la longitud;
2. quieres ejecutar varias instrucciones;
3. quieres realizar varias operaciones sobre el mismo objeto.

---

# Nivel 4 — Cadenas complejas de `?.`

## Ejercicio 16 — Perfil de usuario

Dadas:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val email: String?
)
```

Obtén el email de:

```kotlin
val user: User? = ...
```

Si no existe, devuelve:

```text
Sin email
```

---

## Ejercicio 17 — Dirección completa

Dadas:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val address: Address?
)

class Address(
    val city: String?,
    val country: String?
)
```

Obtén la ciudad y el país.

Los valores predeterminados deben ser:

```text
Ciudad desconocida
País desconocido
```

---

## Ejercicio 18 — Cadena dentro de una expresión

Dado:

```kotlin
val city = user?.profile?.address?.city ?: "Desconocida"
```

Explica exactamente qué sucede cuando:

1. `user` es `null`;
2. `user.profile` es `null`;
3. `user.profile.address` es `null`;
4. `city` es `null`;
5. `city` contiene `"Madrid"`.

---

## Ejercicio 19 — Dos cadenas independientes

Dado:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val name: String?,
    val city: String?
)
```

Crea una expresión que genere:

```text
Carlos vive en Madrid
```

Si falta el nombre:

```text
Desconocido vive en Madrid
```

Si falta la ciudad:

```text
Carlos vive en una ciudad desconocida
```

Si faltan ambos:

```text
Desconocido vive en una ciudad desconocida
```

---

## Ejercicio 20 — Encadenamiento y transformación

Dado:

```kotlin
class User(
    val profile: Profile?
)

class Profile(
    val name: String?
)
```

Obtén el nombre:

- eliminando espacios;
- convirtiéndolo a mayúsculas;
- utilizando `"SIN NOMBRE"` si no existe.

Intenta resolverlo sin utilizar `if`.

---

# Nivel 5 — Nulabilidad y funciones

## Ejercicio 21 — Función nullable

Crea:

```kotlin
fun findUser(id: Int): User?
```

La función debe devolver un usuario cuando `id` sea `1` y `null` para cualquier otro identificador.

Después crea:

```kotlin
fun getUserName(id: Int): String
```

que utilice `findUser()`.

No puedes utilizar `!!`.

---

## Ejercicio 22 — Encadenar llamadas

Dadas:

```kotlin
fun findUser(id: Int): User?
fun findProfile(user: User): Profile?
fun getCity(profile: Profile): String?
```

Obtén la ciudad de un usuario utilizando las tres funciones.

Si no existe, devuelve:

```text
Ciudad desconocida
```

---

## Ejercicio 23 — Funciones que pueden devolver null

Dadas:

```kotlin
fun getName(): String?
fun getAge(): Int?
fun getCity(): String?
```

Crea una función:

```kotlin
fun getSummary(): String
```

que produzca:

```text
Nombre: Carlos
Edad: 25
Ciudad: Madrid
```

Utiliza `"Desconocido"` para los valores de texto inexistentes y `0` para la edad inexistente.

---

## Ejercicio 24 — Evitar cálculos innecesarios

Dado:

```kotlin
fun getName(): String? {
    println("Buscando nombre...")
    return "Carlos"
}
```

Crea una función que solamente imprima el nombre si existe.

Después modifica la solución para convertirlo a mayúsculas antes de imprimirlo.

Utiliza `let`.

---

# Nivel 6 — `takeIf` y `takeUnless`

## Ejercicio 25 — Obtener solamente nombres válidos

Dado:

```kotlin
val name: String? = "Carlos"
```

Obtén el nombre solamente si tiene al menos 3 caracteres.

En caso contrario, el resultado debe ser `null`.

Utiliza `takeIf`.

---

## Ejercicio 26 — Nombre no vacío

Dado:

```kotlin
val name: String? = ""
```

Obtén el nombre solamente cuando no esté vacío.

Utiliza `takeIf`.

---

## Ejercicio 27 — Nombre no blanco

Dado:

```kotlin
val name: String? = "   "
```

Obtén el nombre solamente si contiene algún carácter que no sea un espacio.

Utiliza `takeIf`.

---

## Ejercicio 28 — `takeUnless`

Utiliza `takeUnless` para obtener una contraseña solamente cuando:

- no sea `null`;
- no esté vacía.

---

## Ejercicio 29 — Combinar `takeIf` y `?:`

Crea:

```kotlin
fun getValidName(name: String?): String
```

Debe devolver el nombre solamente cuando tenga entre 3 y 20 caracteres.

En cualquier otro caso:

```text
Nombre no válido
```

Utiliza `takeIf` y `?:`.

---

# Nivel 7 — `run`, `let` y alcance

## Ejercicio 30 — Varias operaciones

Dado:

```kotlin
val name: String? = "Carlos"
```

Utiliza `let` para:

1. eliminar espacios;
2. convertir el nombre a mayúsculas;
3. obtener su longitud.

El resultado final debe ser la longitud.

---

## Ejercicio 31 — `run`

Dado:

```kotlin
class User(
    val name: String,
    val age: Int
)
```

Dada una variable:

```kotlin
val user: User? = ...
```

Utiliza `run` para generar:

```text
Carlos tiene 25 años
```

si el usuario existe.

Si es `null`, devuelve:

```text
Usuario desconocido
```

---

## Ejercicio 32 — Elegir entre `let` y `run`

Resuelve las siguientes situaciones utilizando la construcción más apropiada:

### A

Tienes un `String?` y quieres transformarlo.

### B

Tienes un objeto nullable y quieres ejecutar varias operaciones utilizando varias de sus propiedades.

### C

Tienes un valor nullable y solamente quieres ejecutar una función sobre él.

Explica tus decisiones.

---

## Ejercicio 33 — Encadenar `let`

Dado:

```kotlin
val name: String? = "  Carlos  "
```

Crea una expresión que:

1. elimine los espacios;
2. compruebe que el resultado tiene contenido;
3. lo convierta a mayúsculas;
4. devuelva `"SIN NOMBRE"` si no existe.

---

# Nivel 8 — Nulabilidad dentro de colecciones

## Ejercicio 34 — Filtrar valores null

Dada:

```kotlin
val names = listOf(
    "Carlos",
    null,
    "Ana",
    null,
    "Pedro"
)
```

Crea una nueva lista que solamente contenga los nombres no anulables.

---

## Ejercicio 35 — Transformar valores anulables

Dada:

```kotlin
val names = listOf(
    "Carlos",
    null,
    "Ana",
    null
)
```

Obtén una lista con las longitudes de los nombres existentes.

---

## Ejercicio 36 — `map` frente a `mapNotNull`

Compara:

```kotlin
names.map {
    it?.length
}
```

con:

```kotlin
names.mapNotNull {
    it?.length
}
```

Explica la diferencia entre los resultados.

---

## Ejercicio 37 — Primer elemento válido

Dada:

```kotlin
val names = listOf(
    null,
    "",
    "   ",
    "Carlos",
    "Ana"
)
```

Obtén el primer nombre válido.

Si no existe, devuelve:

```text
Sin nombre
```

---

## Ejercicio 38 — Lista de usuarios

Dadas:

```kotlin
class User(
    val name: String?
)
```

Y:

```kotlin
val users = listOf(
    User("Carlos"),
    User(null),
    User("Ana"),
    User(null)
)
```

Obtén una lista que contenga solamente los nombres válidos.

---

## Ejercicio 39 — Lista de ciudades

Dadas:

```kotlin
class User(
    val address: Address?
)

class Address(
    val city: String?
)
```

Obtén una lista con todas las ciudades disponibles.

Los usuarios sin ciudad deben desaparecer de la lista.

---

# Nivel 9 — Conversión segura

## Ejercicio 40 — `as?` y `let`

Dado:

```kotlin
val value: Any? = "Kotlin"
```

Intenta convertirlo a `String`.

Si la conversión tiene éxito:

- elimina los espacios;
- conviértelo a mayúsculas.

Si no tiene éxito, devuelve `null`.

---

## Ejercicio 41 — Conversión + valor predeterminado

Dado:

```kotlin
val value: Any? = 42
```

Intenta convertirlo a `String`.

Si no es posible:

```text
Valor no válido
```

---

## Ejercicio 42 — Diferentes tipos

Dado:

```kotlin
val values: List<Any?> = listOf(
    "Carlos",
    25,
    null,
    "Ana",
    true,
    42.5
)
```

Obtén solamente los valores que sean `String`.

No utilices `!!`.

---

## Ejercicio 43 — Convertir y filtrar

Utilizando la lista anterior, obtén una lista que contenga:

- solamente `String`;
- sin cadenas vacías;
- sin cadenas que contengan únicamente espacios.

---

# Nivel 10 — Razonamiento sobre expresiones

## Ejercicio 44 — ¿Qué devuelve?

Determina el resultado de cada expresión:

```kotlin
val name: String? = null

val result = name?.length
```

¿Qué tipo tiene `result`?

---

Después:

```kotlin
val result = name?.length ?: 0
```

¿Qué tipo tiene ahora `result`?

---

Y finalmente:

```kotlin
val result = name!!.length
```

¿Qué sucede?

---

## Ejercicio 45 — Tipo resultante

Sin ejecutar el programa, determina el tipo de cada variable:

```kotlin
val a: String? = null
val b = a?.length
val c = a?.length ?: 10
val d = a?.uppercase()
val e = a?.uppercase() ?: "UNKNOWN"
```

---

## Ejercicio 46 — Evaluación de una cadena

Dado:

```kotlin
val result =
    user?.profile?.address?.city?.uppercase()
        ?: "UNKNOWN"
```

Explica el orden conceptual en el que se evalúa la expresión.

---

## Ejercicio 47 — Elvis con expresión

Dado:

```kotlin
val name: String? = null
```

Utiliza `?:` para ejecutar una acción cuando `name` sea `null`.

El resultado debe mostrar:

```text
No se proporcionó un nombre
```

Investiga qué tipo de expresión puede colocarse a la derecha de `?:`.

---

# Nivel 11 — Detectar código problemático

## Ejercicio 48 — Encontrar el problema

Analiza:

```kotlin
fun printUser(user: User?) {
    if (user != null) {
        println(user.name!!.uppercase())
    }
}
```

Identifica todos los posibles problemas relacionados con `null`.

Reescribe la función de forma segura.

---

## Ejercicio 49 — `!!` oculto

Analiza:

```kotlin
fun getName(user: User?): String {
    val profile = user!!.profile
    val name = profile!!.name

    return name!!
}
```

Elimina todos los `!!`.

Intenta reducir el código al mínimo sin perder legibilidad.

---

## Ejercicio 50 — `if` innecesario

Analiza:

```kotlin
fun getCity(user: User?): String {
    if (user != null) {
        if (user.address != null) {
            if (user.address.city != null) {
                return user.address.city
            }
        }
    }

    return "Desconocida"
}
```

Reescribe la función utilizando `?.` y `?:`.

---

# Nivel 12 — Retos de razonamiento

## Ejercicio 51 — Tres estados

Una variable `String?` puede encontrarse en tres situaciones:

1. `null`;
2. `""`;
3. contiene texto.

Crea:

```kotlin
fun describe(text: String?): String
```

que devuelva:

```text
No existe
```

para `null`,

```text
Está vacío
```

para `""`,

y:

```text
Tiene contenido
```

para cualquier otro valor.

Intenta evitar `!!`.

---

## Ejercicio 52 — Tres estados y espacios

Amplía el ejercicio anterior.

Ahora distingue:

1. `null`;
2. vacío;
3. solamente espacios;
4. texto válido.

---

## Ejercicio 53 — Nombre normalizado

Crea:

```kotlin
fun normalizeName(name: String?): String
```

La función debe:

1. eliminar espacios iniciales y finales;
2. rechazar nombres vacíos;
3. rechazar nombres con menos de 3 caracteres;
4. convertir el resultado a mayúsculas;
5. devolver `"SIN NOMBRE"` si no es válido.

Intenta utilizar:

- `?.`
- `let`
- `takeIf`
- `?:`

sin utilizar `!!`.

---

## Ejercicio 54 — Precio opcional

Dado:

```kotlin
class Product(
    val name: String?,
    val price: Double?
)
```

Crea:

```kotlin
fun getPriceDescription(product: Product?): String
```

Debe producir:

```text
Precio de Laptop: 999.99 €
```

Si el producto es `null`:

```text
Producto desconocido
```

Si el nombre es `null`:

```text
Precio de producto desconocido: 999.99 €
```

Si el precio es `null`:

```text
Precio de Laptop: no disponible
```

---

# Nivel 13 — Retos avanzados

## Ejercicio 55 — Perfil completo

Dadas:

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

Crea:

```kotlin
fun getUserSummary(user: User?): String
```

Debe producir:

```text
Nombre: Carlos
Email: carlos@example.com
Ciudad: Madrid
País: España
```

Cualquier propiedad puede ser `null`.

No utilices `!!`.

Intenta utilizar una combinación razonable de:

- `?.`;
- `?:`;
- `let`;
- `run`.

---

## Ejercicio 56 — Evitar cálculos duplicados

Dado:

```kotlin
fun loadUser(): User? {
    println("Cargando usuario...")
    return User("Carlos")
}
```

No debes llamar a `loadUser()` más de una vez.

Utiliza `let` o `run` para procesar el usuario.

El programa debe imprimir:

```text
Cargando usuario...
Usuario: Carlos
```

---

## Ejercicio 57 — Validación completa

Crea:

```kotlin
fun validateUsername(username: String?): String
```

Debe devolver:

```text
Nombre válido
```

si:

- no es `null`;
- no está vacío;
- no contiene solamente espacios;
- tiene entre 3 y 20 caracteres.

En cualquier otro caso debe devolver:

```text
Nombre no válido
```

Intenta resolverlo utilizando `takeIf`.

---

## Ejercicio 58 — Resultado nullable intermedio

Crea:

```kotlin
fun findUser(id: Int): User?
```

Después crea:

```kotlin
fun getValidUserName(id: Int): String
```

La función debe:

1. buscar el usuario;
2. obtener su nombre;
3. eliminar espacios;
4. comprobar que tenga contenido;
5. convertirlo a mayúsculas;
6. devolver `"USUARIO DESCONOCIDO"` si cualquier paso falla.

Intenta evitar `if` y `!!`.

---

## Ejercicio 59 — Procesar una respuesta de API

Dadas:

```kotlin
class Response(
    val data: Data?
)

class Data(
    val user: User?
)

class User(
    val profile: Profile?
)

class Profile(
    val name: String?,
    val email: String?
)
```

Crea:

```kotlin
fun getUserName(response: Response?): String
```

Debe obtener el nombre siguiendo:

```text
response
    ↓
data
    ↓
user
    ↓
profile
    ↓
name
```

Si cualquier nivel es `null`, devuelve:

```text
Desconocido
```

---

## Ejercicio 60 — Respuesta de API completa

Utilizando las mismas clases, crea:

```kotlin
fun getUserDescription(response: Response?): String
```

Debe devolver:

```text
Usuario: Carlos
Email: carlos@example.com
```

Si falta algún dato, utiliza:

```text
Usuario: Desconocido
Email: Sin email
```

No utilices `!!`.

---

# Nivel 14 — Retos finales

## Ejercicio 61 — Refactorización completa

Dado:

```kotlin
fun getUserCity(user: User?): String {
    if (user != null) {
        if (user.profile != null) {
            if (user.profile.address != null) {
                if (user.profile.address.city != null) {
                    if (user.profile.address.city.isNotBlank()) {
                        return user.profile.address.city.trim()
                    }
                }
            }
        }
    }

    return "Ciudad desconocida"
}
```

Refactoriza completamente la función.

Condiciones:

- no utilizar `!!`;
- evitar `if` anidados;
- utilizar `?.`;
- utilizar `?:`;
- eliminar espacios;
- rechazar una ciudad en blanco.

---

## Ejercicio 62 — Refactorización con `takeIf`

Reescribe el ejercicio anterior utilizando `takeIf`.

El resultado debe ser equivalente.

---

## Ejercicio 63 — Una sola expresión

Intenta resolver:

```kotlin
fun getCity(user: User?): String
```

mediante una **única expresión**.

Debe:

1. acceder a la ciudad;
2. eliminar espacios;
3. rechazar una ciudad vacía;
4. devolver `"Ciudad desconocida"` si no existe.

No utilices:

- `if`;
- `!!`.

---

## Ejercicio 64 — Pipeline nullable

Crea:

```kotlin
fun processName(name: String?): String
```

Construye una cadena de operaciones que:

```text
String?
   ↓
trim()
   ↓
validación
   ↓
uppercase()
   ↓
resultado String
```

El resultado para un valor no válido debe ser:

```text
SIN NOMBRE
```

Intenta utilizar:

```kotlin
?.let { ... }
```

y:

```kotlin
takeIf { ... }
```

---

## Ejercicio 65 — Reto final: procesador de usuarios

Crea:

```kotlin
class User(
    val name: String?,
    val email: String?,
    val profile: Profile?
)

class Profile(
    val city: String?,
    val country: String?
)
```

Crea:

```kotlin
fun formatUser(user: User?): String
```

La función debe generar:

```text
Carlos <carlos@example.com> - Madrid, España
```

Pero todos los datos son opcionales.

Reglas:

- usuario `null` → `"Usuario desconocido"`;
- nombre `null`, vacío o blanco → `"Desconocido"`;
- email `null`, vacío o blanco → `"Sin email"`;
- ciudad `null`, vacía o blanca → `"Ciudad desconocida"`;
- país `null`, vacío o blanco → `"País desconocido"`.

Además:

- elimina los espacios de los valores de texto;
- convierte el nombre a formato adecuado;
- no utilices `!!`;
- evita `if` anidados;
- utiliza `?.`;
- utiliza `?:`;
- utiliza `let`;
- utiliza `takeIf`.

Intenta que la solución sea legible y no simplemente una expresión gigantesca.

---

# Nivel 15 — Reto de análisis

## Ejercicio 66 — ¿Qué solución es mejor?

Compara las siguientes soluciones:

### Solución A

```kotlin
if (user != null) {
    if (user.name != null) {
        println(user.name)
    }
}
```

### Solución B

```kotlin
user?.name?.let {
    println(it)
}
```

### Solución C

```kotlin
println(user?.name)
```

Explica qué hace cada una y en qué situaciones elegirías cada solución.

---

## Ejercicio 67 — ¿Dónde colocar el Elvis?

Compara:

```kotlin
val name = user?.profile?.name ?: "Desconocido"
```

con:

```kotlin
val name = user?.profile?.name?.uppercase() ?: "DESCONOCIDO"
```

Explica qué diferencia existe si `name` contiene `"carlos"`.

---

## Ejercicio 68 — El Elvis demasiado pronto

Analiza:

```kotlin
val name = user?.name ?: "Desconocido"

val result = name.uppercase()
```

y:

```kotlin
val result = user?.name?.uppercase() ?: "DESCONOCIDO"
```

¿Son siempre equivalentes?

Explica las diferencias.

---

## Ejercicio 69 — `let` innecesario

Analiza:

```kotlin
val result = user?.let {
    it.profile?.let {
        it.name
    }
}
```

Intenta simplificarlo.

¿Cuántos `let` son realmente necesarios?

---

## Ejercicio 70 — Reto máximo

Diseña una función:

```kotlin
fun getDisplayText(response: Response?): String
```

utilizando las clases de los ejercicios anteriores.

La función debe:

1. comprobar toda la cadena de objetos anulables;
2. obtener un nombre;
3. eliminar espacios;
4. comprobar que el nombre sea válido;
5. convertirlo a mayúsculas;
6. obtener un email;
7. comprobar que sea válido;
8. obtener una ciudad;
9. proporcionar valores predeterminados;
10. generar un texto final.

Ejemplo:

```text
CARLOS — carlos@example.com — MADRID
```

Si solamente existe el nombre:

```text
CARLOS — Sin email — Ciudad desconocida
```

Si no existe ningún dato:

```text
USUARIO DESCONOCIDO
```

### Condiciones adicionales

La solución:

- no puede utilizar `!!`;
- no debe contener `if` anidados;
- debe utilizar `?.`;
- debe utilizar `?:`;
- debe utilizar `let`;
- debe utilizar `takeIf`;
- debe mantener una buena legibilidad;
- debe evitar repetir llamadas a funciones;
- debe evitar expresiones innecesariamente complejas.

---

# Resumen de herramientas

| Construcción | Objetivo |
|---|---|
| `T?` | Permitir `null` |
| `?.` | Acceso seguro |
| `?:` | Valor alternativo |
| `!!` | Forzar un valor no nulo |
| `let` | Ejecutar una transformación o bloque si existe un valor |
| `run` | Ejecutar un bloque sobre un objeto nullable |
| `takeIf` | Conservar un valor solamente si cumple una condición |
| `takeUnless` | Conservar un valor mientras no cumpla una condición |
| `as?` | Conversión segura |
| `isNullOrEmpty()` | Comprobar `null` o vacío |
| `isNullOrBlank()` | Comprobar `null`, vacío o espacios |
| `mapNotNull()` | Transformar y eliminar resultados `null` |

## Objetivo final

Al terminar estos ejercicios deberías ser capaz de transformar código como:

```kotlin
if (user != null) {
    if (user.profile != null) {
        if (user.profile.name != null) {
            return user.profile.name.uppercase()
        }
    }
}

return "DESCONOCIDO"
```

en una solución idiomática de Kotlin, por ejemplo mediante una cadena de operaciones seguras, sin utilizar `!!` y sin crear una sucesión innecesaria de comprobaciones.

El objetivo no es simplemente **evitar errores de null**, sino aprender a **diseñar expresiones claras y seguras alrededor de valores anulables**.