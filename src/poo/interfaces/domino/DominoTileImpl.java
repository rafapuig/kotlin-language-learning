package poo.interfaces.domino;

import org.jetbrains.annotations.NotNull;

public class DominoTileImpl implements DominoTile {

    private final int left;
    private final int right;

    DominoTileImpl(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public boolean canConnectWith(@NotNull DominoTile other) {
        return this.right == other.getLeft() || this.right == other.getRight() ||
                this.left == other.getLeft() || this.left == other.getRight();
    }

    @Override
    @NotNull
    public DominoTile flip() {
        return new DominoTileImpl(this.right, this.left);
    }
}
