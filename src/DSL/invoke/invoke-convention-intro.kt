package DSL.invoke.convention.intro

/**
 * La convención invoke (objetos llamables, como funciones)
 *
 * Permite llamar a objetos de tipos definidos por el usuario (programador)
 * como si fueran funciones
 *
 * Los objetos de tipo función se pueden "llamar" como si fueran funciones
 *
 * Con la convención invoke puedes definir tus propios tipos de objetos
 * que soportan la misma sintaxis.
 *
 * Mu util para definir DSLs
 */

/**
 * La variable triple es de tipo función (Int) -> Int
 * se inicializa con la lambda { it * 3 }, un literal de tipo función
 * la variable triple contiene una referencia a un objeto de tipo función
 */

val triple: (Int) -> Int = { it * 3 }

fun testFunctionTypeCall() {
    // Usamos el objeto triple, en forma de llamada
    val result = triple(10)

    // En realidad es una convención
    // Si lo vemos de manera explícita lo que estamos haciendo en realidad
    // es llamar al metodo invoke del objeto triple
    val result2 = triple.invoke(20)
}


/**
 * Clase Greeter
 * En ella declaramos una función operador invoke
 */
class Greeter(val greeting: String) {
    /**
     * El operador invoke no está restringido por una firma específica
     * Se puede definir con cualquier tipo y número de parámetros
     * y de tipo devuelto
     */
    operator fun invoke(name: String) =
        println("$greeting, $name!")

    /**
     * Se puede sobrecargar
     */
    operator fun invoke(firstName: String, lastName:String) {
        println("$greeting, $firstName $lastName")
    }
}

fun testCustomTypeCall() {
    val spanishGreeter = Greeter("Hola")
    spanishGreeter.invoke("Rafa")

    // Ahora hacemos uso de la convención invoke
    val englishGreeter = Greeter("Hello")
    englishGreeter("John")

    // Usamos la version de sobrecarga de dos parámetros String
    spanishGreeter("Rafa Puig")
}

/**
 * En realidad, una lambda se compila en una clase
 * que implementa la interface FunctionN siendo N 1,2,3
 * dependiendo del número de parámetros de la lambda
 */

interface Function1<in P1, out R> {
    operator fun invoke(p1: P1): R
}

/**
 * Este es el código que generaría el compilador
 * para una lambda {it * 3} de tipo (Int) -> Int
 */
val tripleLambda = object : Function1<Int,Int> {
    override fun invoke(p1: Int): Int {
        return p1 * 3
    }
}


fun main() {
    testFunctionTypeCall()
    testCustomTypeCall()
}