package io.javaclasses.stringCalculation.parsers;

import io.javaclasses.stringCalculation.buildStateMachines.BuilderNumberFiniteStateMachine;
import io.javaclasses.stringCalculation.finiteStateMachine.FiniteStateMachine;

/**
 * This class parses string and return number
 */
public class StringToNumber {
    private String garbageAfterNumber;

    public Double parse(String string) {
        String numberAsString = new String();
        FiniteStateMachine machine = new BuilderNumberFiniteStateMachine().buildNumberFiniteStateMachine();
        for (int i = 0; i < string.length(); ) {
            FiniteStateMachine newMachine = machine.switchState(string.charAt(i));
            if (newMachine == null) {
                break;
            }
            machine = newMachine;
            numberAsString += string.charAt(i);
            string = string.substring(i + 1);
        }
        garbageAfterNumber = string;
        return Double.parseDouble(numberAsString);

    }

    public String getGarbageAfterNumber() {
        return this.garbageAfterNumber;
    }
}
