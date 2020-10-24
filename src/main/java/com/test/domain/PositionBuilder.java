package com.test.domain;

/**
 * @author forum
 * @since 23-10-2020.
 */
public class PositionBuilder {

    private int x;
    private int y;
    private DirectionEnum directionEnum;

    public PositionBuilder withX(int x) {
        this.x = x;
        return this;
    }

    public PositionBuilder withY(int y) {
        this.y = y;
        return this;
    }

    public PositionBuilder withDirectionEnum(DirectionEnum direction) {
        this.directionEnum = direction;
        return this;
    }

    public Position build() {
        return new Position(x, y, directionEnum);
    }
}
