package com.test.service;

import com.test.service.NavigationInstruction;
import com.test.service.NavigationInstructionLeft;
import com.test.service.NavigationInstructionMove;
import com.test.service.NavigationInstructionRight;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * @author forum
 * @since 24-10-2020.
 */
public enum NavigationFactory {
    L(NavigationInstructionLeft::new),
    R(NavigationInstructionRight::new),
    M(NavigationInstructionMove::new);

    public final Supplier<NavigationInstruction> factory;

    NavigationFactory(Supplier<NavigationInstruction> factory) {
        this.factory = requireNonNull(factory);
    }

}
