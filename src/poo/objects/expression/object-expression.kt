package poo.objects.expression

fun drawCircle() {
    /**
     * Objeto de tipo anónimo, su tipo es Any
     * (sin utilidad al pasarlo como argumento o retornarlo)
     *
     * Util para agrupar unas cuantas variables locales
     */
    val circle = object {
        val x = 10
        val y = 15
        val radius = 2
    }
    println("Circulo x:${circle.x} y:${circle.y} radio:${circle.radius} ")
}



fun main() {
    drawCircle()
}