package poo.enums.dominoes

enum class DominoTileType(val description: String) {
    DOUBLE("Ambos lados tiene el mismo numero"),
    MIXED("Cada lado tiene un número diferente");

    val isDouble get() = this == DOUBLE
}


data class DominoTile(
    val left: Int,
    val right: Int
) {
    // La propiedad se puede cachear dado que las propiedades son inmutables
    val type: DominoTileType =
         if (left == right) DominoTileType.DOUBLE else DominoTileType.MIXED

    val description = "[$left|$right] - Type: ${type.name} (${type.description})"
}

fun main() {
    val tile1 = DominoTile(6, 6)
    val tile2 = DominoTile(3, 5)

    println(tile1.description)
    println(tile2.description)
}
