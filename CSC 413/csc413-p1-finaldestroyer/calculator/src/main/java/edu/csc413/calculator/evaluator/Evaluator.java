package edu.csc413.calculator.evaluator;
import edu.csc413.calculator.exceptions.InvalidTokenException;
import edu.csc413.calculator.operators.*;
import edu.csc413.calculator.evaluator.Operand;
import edu.csc413.calculator.operators.Operator;
import edu.csc413.calculator.operators.ParenOperator;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Evaluator {
    private Stack<Operand> operandStack = new Stack();
    private Stack<Operator> operatorStack = new Stack();
    private StringTokenizer expressionTokenizer;
    private final String delimiters = " ( ) + / * - ^ ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int evaluateExpression(String expression ) throws InvalidTokenException {
    String expressionToken;
    this.expressionTokenizer = new StringTokenizer(expression, this.delimiters, true);
    while (this.expressionTokenizer.hasMoreTokens()) {
      // filter out spaces
      expressionToken = this.expressionTokenizer.nextToken();
      if (!((expressionToken).equals(" "))) {
        // check if token is an operand

        if (Operand.check(expressionToken)) {
          operandStack.push(new Operand(expressionToken));
        } else {
          if (!Operator.check(expressionToken)) {
            throw new InvalidTokenException(expressionToken);
          }

          //Check If theres any parenthese: "(" or ")"
          Operator newOperator = Operator.getOperator(expressionToken);
          if (newOperator instanceof ParenOperator) {
            //If theres a left parenthesis, it will push it as new stack
            if (expressionToken.equals("(")){
            operatorStack.push( newOperator );
            continue;
            }
          //when it hits a right parenthesis, it will evaluate inside the stack
          if (expressionToken.equals(")")) {
            do {
              CompleteOperation();
            } while (!(operatorStack.peek() instanceof ParenOperator));
            operatorStack.pop();
            continue;
          }
          }
          if(!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority()) {
              CompleteOperation();
          }
          operatorStack.push(newOperator);
        }
      }
    }

    while (!operatorStack.isEmpty()) {
      CompleteOperation();
    }

    //Since the solution is in the stack, it needs to be popped and returned
    int total = operandStack.pop().getValue();
    System.out.println(total);
    operatorStack.clear();
    operandStack.clear();
    System.gc();
    return total;
  }

  public void CompleteOperation(){
    Operator operatorFromStack = operatorStack.pop();
    Operand operandTwo = operandStack.pop();
    Operand operandOne = operandStack.pop();
    operandStack.push(operatorFromStack.execute(operandOne, operandTwo));
  }
}
