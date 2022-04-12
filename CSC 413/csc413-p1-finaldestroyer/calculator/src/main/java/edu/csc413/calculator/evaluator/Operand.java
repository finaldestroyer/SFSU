package edu.csc413.calculator.evaluator;
import java.io.IOException;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    public int value;
    //Operand operandOne = new Operand(token);
    //Operand operandTwo = new Operand(token);

    /**
     * construct operand from string token.
     */
    public Operand(String token) {
        try {
            this.value = Integer.parseInt(token);
        }
        catch(Exception e){
            System.out.print("Not a valid number");
        }
    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        this.value = value;
    }

    /**
     * return value of operand
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
        try{
            Integer.parseInt(token);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
