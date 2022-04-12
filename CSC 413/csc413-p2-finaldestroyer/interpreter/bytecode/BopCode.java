package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    int value;
    String operator;

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }


    @Override
    public void execute(VirtualMachine virtualMachine) {
        int top = virtualMachine.getStack().pop();
        int sec = virtualMachine.getStack().pop();
        String temp1 = operator;
        if (temp1.equals("+")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = op2 + op1;
            virtualMachine.push(result);
        } else if (temp1.equals("-")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = op2 - op1;
            virtualMachine.push(result);
        } else if (temp1.equals("*")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = op2 * op1;
            virtualMachine.push(result);
        } else if (temp1.equals("/")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = op2 / op1;
            virtualMachine.push(result);
        } else if (temp1.equals("==")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 == op1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals("!=")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 != op1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals("<")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 < op1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals("<=")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 <= op1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals(">")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 > op1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals(">=")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 >= op1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals("|")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 == 1 || op1 == 1) {
                result = 1;
            }
            virtualMachine.push(result);
        } else if (temp1.equals("&")) {
            int op1 = virtualMachine.getStack().pop();
            int op2 = virtualMachine.getStack().pop();
            int result = 0;
            if (op2 == 1 && op1 == 1) {
                result = 1;
            }
            virtualMachine.push(result);
        }

    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return "BOP";
    }

    @Override
    public String getCode() {
        return String.valueOf(operator);
    }

    @Override
    public String toString() {
        return ("BOP " + operator);
    }
}
