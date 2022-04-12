package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {

    private String label;
    String id = label;
    private int resolvedAddress;
    int value = resolvedAddress;

    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }


    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setProgramCounter(this.resolvedAddress);
        if ("ON".equals(virtualMachine.getDumpMode())) {
            System.out.println("GOTO " + this.label);
        }

    }

    @Override
    public String getLabel() {
        return String.valueOf(label);
    }

    @Override
    public String getCode() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return null;
    }

    public int getResolvedAddress() {
        return this.resolvedAddress;
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    public void setResolvedAddress(int resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }
}
