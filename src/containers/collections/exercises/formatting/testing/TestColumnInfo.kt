package containers.collections.exercises.formatting.testing

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.ColumnInfo
import java.time.LocalDate

open class Person(
    val id: Int,
    val firstName: String,
    val lastName:String,
    val birth: LocalDate,
    val age: Int
)

val idColumn =
    ColumnInfo("id", 3) { person: Person -> person.id }

val nameColumn =
    ColumnInfo("nombre", 12, ColumnAlignment.Default, null,  Person::firstName)

val lastNameColumn : ColumnInfo<Person> =
    ColumnInfo("apellidos", 15) { it.lastName.uppercase() }

val birthColumn =
    ColumnInfo("nacimiento", 10, Person::birth)

val ageColumn =
    ColumnInfo<Person>("edad", 4) { person -> person.age }




fun main() {
    println(nameColumn.fieldValueExtractor(armando))
    println(lastNameColumn.fieldValueExtractor(armando))
}