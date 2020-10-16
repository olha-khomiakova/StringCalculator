package io.javaclasses.stringCalculation.NumberFiniteStateMaschine;
import io.javaclasses.stringCalculation.finiteStateMachine.*;
/**
 * Transition in number finite state machine.
 */
public  class NumberTransition implements Transition {

    private String rule;
    private State next;

    public NumberTransition(String rule, State next) {
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