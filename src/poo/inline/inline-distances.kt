package inline

interface Distance {
    val amount: Int
}

@JvmInline
value class Meter(val value: Int) : Distance {
    override val amount: Int
        get() = value * 1
}

@JvmInline
value class Kilometer(val value: Int) : Distance {
    override val amount: Int
        get() = value * 1000
}

object DistanceAdder {

    var total : Int = 0

    fun addDistance(distance: Distance) {
        total += distance.amount
    }
}

operator fun Distance.plus(distance: Distance): Distance = Meter(amount + distance.amount)


fun main() {
    DistanceAdder.addDistance(Kilometer(2))
    DistanceAdder.addDistance(Meter(500))
    println(DistanceAdder.total)

    val total = Kilometer(2) + Meter(500)
    println(total)
}