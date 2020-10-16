package io.javaclasses.stringCalculation.ExpressionFiniteStateMachine;

import io.javaclasses.stringCalculation.finiteStateMachine.State;
import io.javaclasses.stringCalculation.finiteStateMachine.Transition;

/**
 * Transition in expression finite state machine.
 */
public  class ExpressionTransition implements Transition {

    private String rule;
    private State next;

    public ExpressionTransition(String rule, State next) {
        this.rule = rule;
        this.next = next;
    }


    public State state() {
        return this.next;
    }
    @Override
    public boolean isPossible(char c) {
        return this.rule.equalsIgnoreCase(String.valueOf(c));
    }

}