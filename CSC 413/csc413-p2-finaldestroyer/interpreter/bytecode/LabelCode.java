package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    int value;
    String id;
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("LABEL " + this.label);
        }
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getCode() {
        return String.valueOf(value);
    }
}
