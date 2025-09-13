package intro.poo.enums

enum class TipoArma(val daño: Int, val alcance: Int) {
    ESPADA(50, 1),
    ARCO(30, 5),
    LANZA(40, 3);

    fun descripcion(): String {
        return "Arma: ${name}, Daño: $daño, Alcance: $alcance"
    }
}

fun main() {
    val arma = TipoArma.ARCO
    println(arma.descripcion())
}
