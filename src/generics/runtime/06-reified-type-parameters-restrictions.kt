package generics.runtime

/**
 * Un parámetro de tipo revivido se puede usar:
 *
 * - En comprobaciones de tipo y casting (is !is as as?)
 * - Con el API de reflexion de Kotlin ::class
 * - Para obtener la java.lang.Class (::class.java)
 * - Como argumento de tipo para llamar a otras funciones
 *
 * Pero no se puede:
 * - Crear nuevas instancias de la clase especificada por el parámetro de tipo
 * - Llamar a metodos en el companion object de la clase del parámetro de tipo
 * - Marcar como reified los parámetros de tipo de clases o interfaces genéricas
 * o de funciones genéricas no inline
 *
 */