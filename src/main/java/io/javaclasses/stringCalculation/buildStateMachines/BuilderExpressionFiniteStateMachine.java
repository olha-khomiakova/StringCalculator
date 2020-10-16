package io.javaclasses.stringCalculation.buildStateMachines;

import io.javaclasses.stringCalculation.ExpressionFiniteStateMachine.ExpressionFiniteStateMachine;
import io.javaclasses.stringCalculation.ExpressionFiniteStateMachine.ExpressionState;
import io.javaclasses.stringCalculation.ExpressionFiniteStateMachine.ExpressionTransition;
import io.javaclasses.stringCalculation.finiteStateMachine.State;

/**
 * This class build graph of possible transition for string with expression
 *
 */

public class BuilderExpressionFiniteStateMachine {
    public ExpressionFiniteStateMachine buildExpressionFiniteStateMachine() {
        State startState = new ExpressionState();
        State binaryOperationState = new ExpressionState();
        State numberState = new ExpressionState(true);

        startState.with(new ExpressionTransition(" ", numberState));
        numberState.with(new ExpressionTransition("+",binaryOperationState));
        numberState.with(new ExpressionTransition("-",binaryOperationState));
        numberState.with(new ExpressionTransition("*",binaryOperationState));
        numberState.with(new ExpressionTransition("/",binaryOperationState));
        binaryOperationState.with(new ExpressionTransition(" ",numberState));
        return new ExpressionFiniteStateMachine(startState);
    }
}
