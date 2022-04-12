package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    int value;
    String id;


    private String label;
    private int resolvedAddress;

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        /*if(virtualMachine.getStack().peek() != 0){
            return;
        }*/
        if (virtualMachine.getStack().pop() == 0) {
            virtualMachine.setProgramCounter(resolvedAddress);
        }
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("FALSEBRANCH  " + this.label);
        }
    }

    public int getResolvedAddress() {
        return this.resolvedAddress;
    }

    @Override
    public void setResolvedAddress(Integer integer) {
        this.resolvedAddress = integer;
    }

    public int getTargetAddress() {
        return this.resolvedAddress;
    }

    public void setTargetAddress(int num) {
        this.resolvedAddress = num;
    }

    @Override
    public String getLabel() {
        return String.valueOf(resolvedAddress);
    }

    @Override
    public String getCode() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return null;
    }
}
