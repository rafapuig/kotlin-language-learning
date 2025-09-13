package poo.interfaces;

import org.jetbrains.annotations.NotNull;

public class Implementer implements DominoTile {

    @Override
    public int getLeft() {
        return 0;
    }

    @Override
    public int getRight() {
        return 0;
    }

    @Override
    public boolean canConnectWith(@NotNull DominoTile other) {
        return false;
    }

    @Override
    @NotNull
    public DominoTile flip() {
        return null;
    }
}
