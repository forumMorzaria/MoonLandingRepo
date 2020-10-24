package com.test.service;

import com.test.domain.Position;

/**
 * @author forum
 * @since 22-10-2020.
 */
public interface NavigationService {

    /**
     * Given the start position of a robot, process a series of instructions to determine the final position
     * @param initialPosition
     * @param instructionList
     */
    void processInstructions(Position initialPosition, char[] instructionList);
}
