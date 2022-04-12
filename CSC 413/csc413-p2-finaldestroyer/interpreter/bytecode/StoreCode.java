package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int value;
    private String id;
    private int offeset;
    private int topStack;

    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        this.id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        this.topStack = virtualMachine.getStack().peek();
        virtualMachine.getStack().store(this.value);
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("STORE " + this.value + " " + this.id + "    " + this.id + " = " + this.topStack);
        }
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return id;
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
