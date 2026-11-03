package containers.collections.exercises.geography.model

import containers.collections.exercises.geography.model.Surface.Companion.M2_PER_KM2
import java.text.DecimalFormat

@JvmInline
value class Surface(val value: Float) : Comparable<Surface> {

    companion object {
        const val M2_PER_KM2 = 1_000_000
        private val formatter = DecimalFormat.getNumberInstance()
    }

    override fun compareTo(other: Surface) =
        compareValuesBy(this,other) {it.value}
        //value.compareTo(other.value)

    override fun toString() = value.let {
        // Si el valor supera el millón los pasamos de m2 a Km2
        val number = if (it > M2_PER_KM2) it / M2_PER_KM2 else it
        // Y el sufijo pasa de m2 a Km2
        val suffix = if (it > M2_PER_KM2) "km²" else "m²"
        "${formatter.format(number)} $suffix"
    }
}


/**
 * Propiedades de extensión
 *
 * Si a un número le añadimos la llamada a la propiedad m2 o km2 se convierte en una Surface
 */

val Float.m2 get() = Surface(this)

val Number.m2 get() = toFloat().m2

val Number.km2 get() = (toFloat() * M2_PER_KM2).m2



fun main() {

    val surface1 = 500.97.km2
    val surface2 = 5.7f.km2
    val surface3 = 1200.m2
    val surface4 = 1200L.m2
    val surface5 = 1_500_000L.m2

    println(surface1)
    println(surface2)
    println(surface3)
    println(surface4)
    println(surface5)
}