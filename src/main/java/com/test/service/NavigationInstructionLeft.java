package com.test.service;

import com.test.domain.DirectionEnum;
import com.test.domain.Position;

/**
 * @author forum
 * @since 24-10-2020.
 */
public class NavigationInstructionLeft implements NavigationInstruction {
    @Override
    public void processInstruction(Position p) {
        switch (p.getDirectionEnum()) {
            case N:
                p.setDirectionEnum(DirectionEnum.W);
                break;
            case S:
                p.setDirectionEnum(DirectionEnum.E);
                break;
            case E:
                p.setDirectionEnum(DirectionEnum.N);
                break;
            case W:
                p.setDirectionEnum(DirectionEnum.S);
                break;

        }

    }
}
