package intro.poo.enums

enum class DominoTileType(val description: String) {
    DOUBLE("Both sides have the same number"),
    MIXED("Each side has a different number");

    fun isDouble(): Boolean = this == DOUBLE
}


data class DominoTile(val left: Int, val right: Int) {
    val type: DominoTileType
        get() = if (left == right) DominoTileType.DOUBLE else DominoTileType.MIXED

    fun description(): String {
        return "[$left|$right] - Type: ${type.name} (${type.description})"
    }
}

fun main() {
    val tile1 = DominoTile(6, 6)
    val tile2 = DominoTile(3, 5)

    println(tile1.description())
    println(tile2.description())
}
