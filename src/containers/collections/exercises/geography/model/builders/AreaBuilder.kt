package containers.collections.exercises.geography.model.builders

import containers.collections.exercises.geography.model.Area
import containers.collections.exercises.geography.model.ISUnit


class AreaBuilder {
    var value: Long? = null
    var units: ISUnit = ISUnit.KILO

    fun build() = run {
        require(value != null) { "El valor del area no puede ser nulo" }
        Area(value?.toFloat() ?: 0f, units)
    }
}