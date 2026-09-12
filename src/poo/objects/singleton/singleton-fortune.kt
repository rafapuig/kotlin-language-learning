package poo.objects.singleton.fortune

object FortuneCookieMachine {

    private val messages = listOf(
        "Vas a ganar... pero no hoy.",
        "Un bug inesperado será tu mayor maestro.",
        "Tu próximo commit debería tener emojis 🎯.",
        "Evita los bucles infinitos... y las relaciones tóxicas.",
        "Hoy es un buen día para refactorizar.",
        "Tu código compilará a la primera (si rezas fuerte).",
        "No subestimes un warning... puede ser una profecía.",
        "Haz backup. La suerte favorece a los precavidos.",
        "Un breakpoint aparecerá cuando menos lo esperes.",
        "Tu teclado tiene más poder del que crees."
    )

    fun crack(): String = messages.random()
}


fun main() {
    println("Abriendo una galleta de la fortuna...")
    val fortune = FortuneCookieMachine.crack()
    println("Tu fortuna: \"$fortune\"")
}
