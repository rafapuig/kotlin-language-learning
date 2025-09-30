package functional.lambdas.intro

import kotlin.math.max

enum class Category { JOVEN, NUMEROSA, JUBILADO, ADULTO }

fun getDiscount(category: Category): Double.() -> Double {
    return when (category) {
        Category.JOVEN -> { price: Double -> max(price - 4, 0.0) }
        Category.NUMEROSA -> { price: Double -> price  * 0.5 }
        Category.JUBILADO -> { price: Double -> price * 0.75 }
        Category.ADULTO -> { price: Double -> price }
    }
}

fun main() {
    val price = 50.0

    var discount = getDiscount(Category.JOVEN)
    println(price.discount())

    discount = getDiscount(Category.JUBILADO)
    println(price.discount())
}