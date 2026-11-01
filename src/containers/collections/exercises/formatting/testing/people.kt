package containers.collections.exercises.formatting.testing

import java.time.LocalDate

val armando =
    Person(1, "Armando", "Bronca Segura",
        LocalDate.of(1960,5,3),65)

val people = arrayOf(
    armando,
    Person(2,"Lorenzo","Penco",LocalDate.now(),67),
    Employee(2,2000.0)
)