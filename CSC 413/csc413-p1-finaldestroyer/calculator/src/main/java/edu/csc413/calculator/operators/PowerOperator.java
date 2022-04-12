package edu.csc413.calculator.operators;
import java.lang.Math;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {
    //Operand total;

    @Override
    public int priority() {
        return 3;
    }

    //When it sees an "^", it will evaluate and raise the first number to the second number
    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        double temp = Math.pow(Double.valueOf(operandOne.getValue()),Double.valueOf(operandTwo.getValue()));
        Operand total = new Operand((int) temp);
        return total;
    }
    /*
    public Operand execute(Operand operandOne, Operand operandTwo) {
        Operand total = new Operand((int) Math.pow(operandOne.getValue(), operandTwo.getValue()));
        return total;
    }*/
}
