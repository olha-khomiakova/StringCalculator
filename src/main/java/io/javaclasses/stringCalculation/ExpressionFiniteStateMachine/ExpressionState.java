package io.javaclasses.stringCalculation.ExpressionFiniteStateMachine;

import io.javaclasses.stringCalculation.finiteStateMachine.State;
import io.javaclasses.stringCalculation.finiteStateMachine.Transition;
import io.javaclasses.stringCalculation.parsers.StringToNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * State in a expression finite state machine.
 */
public class ExpressionState implements State {

    private List<Transition> transitions;
    private boolean isFinal;
    public ExpressionState() {
        this(false);
    }

    public ExpressionState(boolean isFinal) {
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
