package com.test.service;

import com.test.exception.BackendException;
import com.test.domain.Position;

/**
 * @author forum
 * @since 23-10-2020.
 */
public class NavigationServiceImpl implements NavigationService {
    private int maxX;
    private int maxY;

    public NavigationServiceImpl(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void processInstructions(Position initialPosition, char[] instructionList) {
        for (char c : instructionList) {
            validatePosition(initialPosition);
            validateInstruction(c);
            navigate(initialPosition, c);
        }
    }

    private void navigate(Position p, char nextInstruction) {
        NavigationInstruction instruction = NavigationFactory.valueOf(String.valueOf(nextInstruction)).factory.get();
        instruction.processInstruction(p);
        validatePosition(p);
    }

    private void validatePosition(Position p) {
        if (p.getX() > maxX || p.getY() > maxY) {
            throw new BackendException("The current position is out of the grid!");
        }
    }

    private void validateInstruction(char instruction) {
        try {
            NavigationFactory.valueOf(String.valueOf(instruction));
        } catch (IllegalArgumentException e) {
            throw new BackendException("Incorrect Input instruction!");
        }

    }
}
