package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int value;
    private String id;
    private int counter;

    @Override
    public void init(ArrayList<String> args) {
        this.counter = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for (int i = 0; i < counter; i++) {
            virtualMachine.getStack().pop();
        }
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("POP " + this.counter);
        }
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return String.valueOf(counter);
    }

    @Override
    public String getCode() {
        return String.valueOf(this.counter);
    }

    @Override
    public String toString() {
        return "POP " + this.counter;
    }
}
