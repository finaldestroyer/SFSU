package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int value;
    private String id;

    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.getStack().newFrameAt(this.value);
        if ("ON".equals(virtualMachine.getDumpMode())) {
            System.out.println("ARGS " + this.value);
        }
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return String.valueOf(value);
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
