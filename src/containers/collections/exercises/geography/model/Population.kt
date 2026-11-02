package containers.collections.exercises.geography.model

import java.text.NumberFormat

@JvmInline
value class Population(val value: Int) {

    override fun toString() =
        "${NumberFormat.getNumberInstance().format(value)} habs"

}