package com.test.domain;

/**
 * @author forum
 * @since 22-10-2020.
 */
public class Position {

    private int x;
    private int y;
    private DirectionEnum directionEnum;

    public Position(int x, int y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.directionEnum = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirectionEnum getDirectionEnum() {
        return directionEnum;
    }

    public void setDirectionEnum(DirectionEnum directionEnum) {
        this.directionEnum = directionEnum;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + directionEnum;
    }

}
