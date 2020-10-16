package io.javaclasses.stringCalculation.NumberFiniteStateMaschine;

import io.javaclasses.stringCalculation.finiteStateMachine.*;

/**
 * Implementation interface for extracting a number from a string
 *
 *
 */
public final class NumberFiniteStateMachine implements FiniteStateMachine {

    private State currentState;

    public NumberFiniteStateMachine(State initial) {
        this.currentState = initial;
    }

    public FiniteStateMachine switchState(char c) {
        if (this.currentState.transit(c) != null) {
            return new NumberFiniteStateMachine(this.currentState.transit(c));
        } else {
            return null;
        }
    }

    public boolean canStop() {
        return this.currentState.isFinal();
    }

}
