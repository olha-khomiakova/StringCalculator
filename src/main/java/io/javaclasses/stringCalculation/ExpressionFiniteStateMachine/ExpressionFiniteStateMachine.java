package io.javaclasses.stringCalculation.ExpressionFiniteStateMachine;

import io.javaclasses.stringCalculation.finiteStateMachine.FiniteStateMachine;
import io.javaclasses.stringCalculation.finiteStateMachine.State;
import io.javaclasses.stringCalculation.parsers.StringToNumber;
/**
 * Implementation interface for extracting a expression from a string
 *
 */
public class ExpressionFiniteStateMachine implements FiniteStateMachine {
    private State currentState;
    private StringToNumber parser;
    private Double number;
    private String garbage;
    public ExpressionFiniteStateMachine(State initial) {
        this.currentState = initial;
    }

    @Override
    public ExpressionFiniteStateMachine switchState(char c) {
        if(this.currentState.transit(c)!=null){
            return new ExpressionFiniteStateMachine(this.currentState.transit(c));
        }else
        {
            return null;
        }
    }
    public ExpressionFiniteStateMachine switchState(String string) {
        parser = new StringToNumber();
        this.number = parser.parse(string);
        this.garbage = parser.getGarbageAfterNumber();
        if(this.currentState.transit(' ')!=null) {
            return new ExpressionFiniteStateMachine(this.currentState.transit(' '));
        }else
        {
            return null;
        }
    }
    public String  getGarbage()
    {
        return garbage;
    }
    public Double getNumber()
    {
        return number;
    }
    @Override
    public boolean canStop() {
        return this.currentState.isFinal();
    }
}
