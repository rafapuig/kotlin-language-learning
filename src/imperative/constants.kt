package imperative// palabra clave const

const val PI = 3.14159265359 // Por convención identificador todas en mayúsculas

/* Para valores conocidos en tiempo de compilación */

// Tiempo de compilación
/* Momento en que se compila (crea el programa) */

// Tiempo de ejecución
/* Momento en que se ejecuta el programa (compilado con éxito) */

/*
Para el programador, que algo tenga que ser conocido
en tiempo de compilación significa que el valor se conoce
y se escribe en el código fuente
 */

/*
- Mejora la eficiencia del programa
- Mejora la claridad del código fuente --> evita "números mágicos"
 */

// Convención de nomenclatura para constantes --> SNAKE_CASE
/*
-Todos los caracteres de cada palabra en mayúsculas
-Las palabras se separan mediante _
 */

// Ejemplos
const val MAX_LIVES = 5
const val MAX_SCREEN_WIDTH = 1920

fun main() {
    val radius = 2
    val area = PI * radius * radius
    println("El area de un circulo de radio $radius es igual a $area")
}