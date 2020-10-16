package io.javaclasses.stringCalculation.finiteStateMachine;

/**
 * State. Part of a finite state machine.
 */
public interface State {

    /**
     * Add a Transition to this state.
     *
     * @param tr Given transition.
     * @return Modified State.
     */
    State with(Transition tr);

    /**
     * Follow one of the transitions, to get
     * to the next state.
     *
     */
    State transit(char c);

    /**
     * Can the automaton stop on this state?
     *
     *
     */
    boolean isFinal();
}
