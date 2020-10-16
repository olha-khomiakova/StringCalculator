package io.javaclasses.stringCalculation.buildStateMachines;
import io.javaclasses.stringCalculation.finiteStateMachine.*;
import io.javaclasses.stringCalculation.NumberFiniteStateMaschine.*;

/**
 * This class build graph of possible transition for string with number and garbage
 *
 */
public class BuilderNumberFiniteStateMachine {
    public FiniteStateMachine buildNumberFiniteStateMachine() {
        State startState = new NumberState();
        State minusState = new NumberState();
        State digitState = new NumberState(true);
        State dotState = new NumberState();
        State finishState = new NumberState();
        startState.with(new NumberTransition("-", minusState));//1
        for (int i = 0; i <= 9; i++) {
            startState.with(new NumberTransition(String.valueOf(i), digitState));//2
            minusState.with(new NumberTransition(String.valueOf(i), digitState));//3
            digitState.with(new NumberTransition(String.valueOf(i), digitState));//4//8
            dotState.with(new NumberTransition(String.valueOf(i), digitState));//6
        }
        digitState.with(new NumberTransition(".", dotState));//5
        return new NumberFiniteStateMachine(startState);
    }
}