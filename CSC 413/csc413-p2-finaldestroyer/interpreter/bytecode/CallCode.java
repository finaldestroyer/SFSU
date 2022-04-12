package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private int value;
    private String funct;
    private int target;


    @Override
    public void init(ArrayList<String> args) {
        this.funct = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.getReturnAddress().push(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(target);
        this.value = virtualMachine.getStack().peek();
        if ("ON".equals(virtualMachine.getDumpMode())) {
            int n = this.funct.indexOf("<");
            String temp;
            if (n < 0) {
                temp = this.funct;
            } else {
                temp = this.funct.substring(0, n);
            }

            System.out.println("CALL " + this.funct + "    " + temp + "(" + this.value + ")");
        }
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return funct;
    }

    @Override
    public String getCode() {
        return String.valueOf(funct);
    }

    public int getTargetAddress() {
        return this.target;
    }

    public void setTargetAddress(int num) {
        this.target = num;
    }

    @Override
    public String toString() {
        return null;
    }
}
