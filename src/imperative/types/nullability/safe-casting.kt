package imperative.types.nullability.safe.casting

import java.util.Objects

class Person(val name: String, val age: Int) {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Person) return false
        /**
         * Como no hemos salido con el return del if predecesor
         * es debido a que other !is Person es falso, luego other is Person es true
         * A partir de aqui el compilador infiere que other es de tipo Person
         * Y, por tanto, se puede usar la referencia other para acceder a los miembros
         * declarados en la clase Person
         */
        return name == other.name && age == other.age
    }

    fun equals2(other: Any?): Boolean {
        /**
         * El operador as? realiza la operación  other as Person si other is Person
         * si no, devuelve null en lugar de lanzar la excepción ClassCastException
         *
         * Si es null con el operador Elvis el resultado es el operador de la derecha
         * es decir, retornar de la función y devolver falso
         */
        val otherPerson = other as? Person ?: return false
        return name == otherPerson.name && age == otherPerson.age
    }

    override fun hashCode(): Int = name.hashCode() * 31 + age
}

fun main() {
    val p1 = Person("Perico", 34)
    val p2 = Person("Perico", 34)
    println(p1 == null) // falso (nigun objeto es igual a null)
    println(p1 == p2) // verdadero
    println(p1.equals("Perico")) // falso (no son del mismo tipo
}