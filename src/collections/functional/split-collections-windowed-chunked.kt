package collections.splitting

/**
 * Para casos en los que la colección representa una serie de datos
 *
 * Puede que sea necesario trabajar con datos consecutivos
 */

val temperatures = listOf(31.5, 30.2, 28.4, 35.9, 26.3)

/**
 * Para obtener las medias durante tres días consecutivos
 *
 * Usamos una ventana deslizante de tamaño 3
 *
 * 1) Sacamos la media de las 3 primeras temperaturas (0,1,2)
 * 2) deslizamos la ventana una unidad /índice
 * 3) Sacamos la media de las temperaturas (1,2,3)
 * 3) Seguimos deslizando hasta llegar a las 3 últimas
 */

/**
 * windowed
 *
 * Realiza la iteración de la colección en forma de ventana deslizante
 */

fun testWindowed() {
    val windowed = temperatures.windowed(3)
    println(windowed)

    val averages = temperatures
        .windowed(3) { it.average() }
    println(averages)
}


/**
 * función chunked
 *
 * Podemos romper la colección en fragmentos (chunks) de un tamaño dado
 * que no se solapan entre sí
 * El último chunk puede no llegar al tamaño, dado que usa los
 * elementos restantes
 */

fun testChunked() {
    val chunked = temperatures.chunked(2)
    println(chunked)
    val sumChunked = temperatures.chunked(2) {it.sum()}
    println(sumChunked)
}

fun main() {
    testWindowed()
    testChunked()
}