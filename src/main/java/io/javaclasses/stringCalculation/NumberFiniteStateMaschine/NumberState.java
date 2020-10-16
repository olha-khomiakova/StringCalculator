package io.javaclasses.stringCalculation.NumberFiniteStateMaschine;

import io.javaclasses.stringCalculation.finiteStateMachine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * State in a Number finite state machine.
 */
public final class NumberState implements State {

    private List<Transition> transitions;
    private boolean isFinal;

    public NumberState() {
        this(false);
    }

    public NumberState(boolean isFinal) {
        this.transitions = new ArrayList<>();
        this.isFinal = isFinal;
    }

    public State transit(char c) {
        for (Transition transition : this.transitions) {
            if (transition.isPossible(c)) {
                return transition.state();
            }
        }
        return null;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    @Override
    public State with(Transition tr) {
        this.transitions.add(tr);
        return this;
    }

}
