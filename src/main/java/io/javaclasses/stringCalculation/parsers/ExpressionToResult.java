package io.javaclasses.stringCalculation.parsers;

import io.javaclasses.stringCalculation.ExpressionFiniteStateMachine.ExpressionFiniteStateMachine;
import io.javaclasses.stringCalculation.buildStateMachines.BuilderExpressionFiniteStateMachine;
import io.javaclasses.stringCalculation.ShuntingYard.*;

/**
 * This class parses expression and return result
 */
public class ExpressionToResult {

    public Double parseExpression(String string) {
        Double result = 0.0;
        ShuntingYard shuntingYard = new ShuntingYard();
        ExpressionFiniteStateMachine machine = new BuilderExpressionFiniteStateMachine().buildExpressionFiniteStateMachine();
        for (int i = 0; i < string.length(); ) {
            ExpressionFiniteStateMachine newMachine = machine.switchState(string);
            if (newMachine == null) {
                break;
            }
            shuntingYard.pushNumber(machine.getNumber());
            string = machine.getGarbage();
            if (!string.isEmpty()) {
                machine = newMachine;
                ExpressionFiniteStateMachine chara = newMachine.switchState(string.charAt(i));
                if (chara == null) {
                    break;
                }
                shuntingYard.pushBinaryOperation(string.charAt(i));
                string = string.substring(i + 1);
                machine = chara;
            }
        }
        result = shuntingYard.calculateExpression();
        return result;
    }

}
