package io.javaclasses.stringCalculation.finiteStateMachine;
/**
 * This interface is interface for different types FiniteStateMachine
 *
 *
 */
public interface FiniteStateMachine {
    /**
     * Follow a transition, switch the state of the machine.
     *
     *
     */
    FiniteStateMachine switchState(char c);

    /**
     * Is the current state a final one?
     * @return true or false.
     */
    boolean canStop();
}
