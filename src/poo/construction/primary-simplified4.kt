package poo.construction.primary.simplified.visibility

/**
 * El constructor primario se define
 * después del nombre de la clase
 *
 * la palabra clave constructor solamente es necesaria si queremos
 * indicar un modificador de acceso o una anotación
 *
 * Si el cuerpo de la clase queda vacío también se pueden eliminar las llaves
 */
class Circle public constructor(val radius: Double) {

}

fun main() {

    val circle = Circle(4.0)

    println("Circulo de radio ${circle.radius}")

    //circle.radius = 5.0 // la propiedad radius es de solo lectura
    println("Circulo de radio ${circle.radius}")
}