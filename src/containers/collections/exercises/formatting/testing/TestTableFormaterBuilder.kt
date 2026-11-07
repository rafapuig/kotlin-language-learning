package containers.collections.exercises.formatting.testing

import containers.collections.exercises.formatting.ColumnInfo
import containers.collections.exercises.formatting.builders.buildTableFormatter
import containers.collections.exercises.formatting.builders.toTable
import generics.variance.name


fun main() {

    val personTableFormatter = buildTableFormatter {
        column(
            ColumnInfo(
                name = "id",
                length = 3,
                fieldValueExtractor = Person::id,
            )
        )
        column {
            name = "nombre"
            width = 12
            value = Person::firstName
        }
        column {
            name = "apellidos"
            width = 15
            value = Person::lastName
        }
        column(birthColumn)
        column(ageColumn)
    }

    with(personTableFormatter) {
        println(people.toTable())
    }

    people.toTable(personTableFormatter).let { println(it) }

}