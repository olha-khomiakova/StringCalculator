package io.javaclasses.stringCalculation.finiteStateMachine;

/**
 * Transition in a finite State machine.
 */
public interface Transition {

    /**
     * Is the transition possible with the given character?
     *
     *
     */
    boolean isPossible(char c);

    /**
     * The state to which this transition leads.
     */
    State state();
}
