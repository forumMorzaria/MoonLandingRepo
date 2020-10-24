package com.test.domain;

/**
 * @author forum
 * @since 22-10-2020.
 */
public enum DirectionEnum {
    N(0, 1),
    E(1, 0),
    W(-1, 0),
    S(0, -1);

    private int x;
    private int y;

    DirectionEnum(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
