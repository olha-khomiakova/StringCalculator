package io.javaclasses.stringCalculation.ShuntingYard;

import java.util.HashMap;
import java.util.Stack;

/**
 * This class counts an expression from two stacks
 *
 *
 */

public class ShuntingYard {
    private Stack<Double> operands;
    private Stack<Character> operations;
    private HashMap<Character, Integer> operationPriority;


    public ShuntingYard() {
        operationPriority = new HashMap<>();
        operationPriority.put('*', 1);
        operationPriority.put('/', 1);
        operationPriority.put('+', 2);
        operationPriority.put('-', 2);
        operands = new Stack<>();
        operations = new Stack<>();
        flag = false;
    }
    private boolean flag;


    public void pushBinaryOperation(char operation) {
        this.operations.push(operation);
    }

    public void pushNumber(double number) {
        if (operations.size() > 1) {
            char operation = operations.pop();
            char previousOperation = operations.peek();
            if (operationPriority.get(operation) > operationPriority.get(previousOperation)) {
                this.operations.push(operation);
                this.operands.push(number);
            } else {
                double secondOperand = number;
                double firstOperand = operands.pop();
                //calculate(firstOperand, secondOperand, operation);
                this.operands.push(calculate(firstOperand, secondOperand, operation));
            }
        } else
            this.operands.push(number);

    }

    public Double calculateExpression() {
        for (char operation : operations) {
            double secondOperand = operands.pop();
            double firstOperand = operands.pop();
            //calculate(firstOperand, secondOperand, operation);
            this.operands.push(calculate(firstOperand, secondOperand, operation));
        }
        return operands.peek();
    }

    private double calculate(double first, double second, char operation) {
        switch (operation) {
            case ('+'):
                return first + second;
            case ('-'):
                return first - second;
            case ('*'):
                return first * second;
            case ('/'):
                return first / second;
        }
        return 0;
    }
}
