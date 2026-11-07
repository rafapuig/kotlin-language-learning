package containers.collections.exercises.formatting.testing

import containers.collections.exercises.formatting.TableFormatter
import java.time.LocalDate

class Employee(id:Int, val salary: Double)
    : Person(id,"Marta","Baco", LocalDate.now(),30)



val tableFormatter = TableFormatter(
    idColumn, nameColumn, lastNameColumn, birthColumn, ageColumn
)



fun main() {
    //println(tableFormatter.header)
    //println(tableFormatter.lineSeparator)
    with(tableFormatter) {
        //println(perico.toRow())
        //println(people.toRows())
        println(armando.asRow())
        people.asRows().forEach(::println)
        //println(people.toTable())
        people.asRows().forEach { row->
            println(row.value.joinToString(separator = " "))
        }
    }
}