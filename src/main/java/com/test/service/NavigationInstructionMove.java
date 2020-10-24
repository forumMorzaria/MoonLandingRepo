package com.test.service;

import com.test.domain.Position;

/**
 * @author forum
 * @since 24-10-2020.
 */
public class NavigationInstructionMove implements NavigationInstruction {
    @Override
    public void processInstruction(Position p) {
        p.setX(p.getX() + p.getDirectionEnum().getX());
        p.setY(p.getY() + p.getDirectionEnum().getY());
    }
}
