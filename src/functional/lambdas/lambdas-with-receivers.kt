package functional.lambdas.receivers1

/**
 * Lambdas con receptor (lambdas with receiver)
 *
 * Permiten llamar a los métodos de un objeto
 * dentro del cuerpo de la lambda
 * sin tener que usar cualificadores (this)
 *
 * Cumplen el papel de los metodos de instancia
 * Cuando se ejecuta el código de una lambda con receptor se habrá un objeto receptor
 * sobre el cual se ha ejecutado la invocación de la lambda (igual que en los metodos de instancia)
 *
 * Por tanto, para invocar una lambda con receptor se necesita una referencia a un objeto,
 * que será el receptor
 * Dentro del cuerpo de la lambda accedemos a este objeto mediante this
 */

/**
 * El tipo del receptor se indica en el tipo de función de la variable
 * mediante su clase seguida de un punto y después van los paréntesis para el resto de parámetros
 */

/**
 * Las lambdas con receptor se pueden invocar como si fueran funciones globales (no metodos de instancia)
 * que reciben como primer argumento el receptor
 */


val textLength: String.() -> Int = {
    this.length
}


data class Circle(var radius: Float)

val setRadius: Circle.(Float) -> Unit = { newRadius ->
    this.radius = newRadius
}

val changeRadius: Circle.(Float) -> Unit = {
    this.radius = it
}


val translateRectangle: Rectangle.(Int, Int) -> Unit = { offsetX, offsetY ->
    this.width += offsetX
    this.height += offsetY
}

data class Rectangle(var width: Int, var height: Int)

val scaleRectangle: Rectangle.(Int) -> Unit = {
    this.width *= it
    this.height *= it
}

fun testWithStringReceiver() {
    // El objeto receptor es el String "Perico Palotes" que será this en el cuerpo de la lambda con receptor
    println("Perico Palotes".textLength())

    // La variable text guarda la referencia a un objeto de tipo String
    val text = "Hola Kotlin"

    // Se usa text como referencia al objeto receptor en la invocación de la lambda
    val length = text.textLength()
    println(length)

    // Invocación de la lambda a traves de la variable textLength
    // que guarda su referencia como si fuera una función global
    // El primer argumento de la "llamada" debe ser un valor del tipo del receptor
    val len = textLength(text)
    println(len)
}


fun testWithCircleReceiver() {

    val circle = Circle(100f)
    println(circle)

    circle.setRadius(50f)
    println(circle)

    circle.changeRadius(80f)
    println(circle)

    // Invocación de la lambda con receptor de tipo Circle
    // a traves de la variable que guarda su referencia como si fuera una función global
    // El primer argumento debe ser un objeto de tipo Circle, el segundo el del parámetro de la lambda (Float)
    setRadius(circle, 20f)
    // Invocación de la lambda con receptor de tipo Circle a traves de la variable changeRadius
    // que guarda su referencia como si fuera una función global
    changeRadius(circle, 30f)
}

fun testWithRectangleReceiver() {
    val rectangle: Rectangle = Rectangle(4, 7)
    println(rectangle)

    rectangle.scaleRectangle(2)
    println(rectangle)

    rectangle.translateRectangle(3, 4)
    println(rectangle)

    // Invocación de la lambda con receptor a traves de la variable que guarda su referencia
    // como si fuera una función global
    // Pasamos como primer argumento un objeto Rectangle y luego el resto de argumentos
    scaleRectangle(rectangle, 2)
    println(rectangle)

    // Invocación de la lambda a traves de la variable que guarda su referencia como si fuera una función global
    translateRectangle(rectangle, -1, -2)
    println(rectangle)
}

fun main() {
    testWithStringReceiver()
    testWithCircleReceiver()
    testWithRectangleReceiver()
}