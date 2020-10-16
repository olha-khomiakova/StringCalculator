package io.javaclasses.stringCalculation;

import io.javaclasses.stringCalculation.parsers.ExpressionToResult;

public class Main {
    public static void main(String[] args){
        String string = "5.99+7*8/2-10.01";
        double res =new ExpressionToResult().parseExpression(string);
        System.out.println(res);
    }

}
