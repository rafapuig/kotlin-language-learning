package poo.intro

/**
 * val en la declaración del parámetro crea una propiedad de solo lectura (getter)
 * En Java una propiedad es la combinación de un campo de respaldo (backing field) más el accesor (getter) y el mutador (setter)
 */
class Person(val name: String)

class Person1(
    val name: String, // Propiedad de solo lectura (campo y getter)
    var isStudent: Boolean // Propiedad mutable (campo más getter y setter)
)