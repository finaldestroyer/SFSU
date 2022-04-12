package edu.csc413.calculator.operators;
import java.lang.Math;

import edu.csc413.calculator.evaluator.Operand;

public class SubtractOperator extends Operator {
    //Operand total;

    @Override
    public int priority() {
        return 1;
    }

    //When it sees an "-", it will evaluate and subtract the two numbers
    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        Operand total = new Operand(operandOne.getValue() - operandTwo.getValue());
        return total;
    }
}