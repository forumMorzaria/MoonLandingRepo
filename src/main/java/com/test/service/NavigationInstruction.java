package com.test.service;

import com.test.domain.Position;

/**
 * @author forum
 * @since 24-10-2020.
 */
public interface NavigationInstruction {

    /**
     * Process instructions based on the Navigation instruction passed
     */
    void processInstruction(Position p);
}
