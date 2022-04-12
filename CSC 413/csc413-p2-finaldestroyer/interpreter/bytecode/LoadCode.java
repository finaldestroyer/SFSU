package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int value;
    private String id;
    private int offset;

    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        this.id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.getStack().load(this.value);
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("LOAD " + this.value + " " + this.id + "    <load " + this.id + ">");
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
        return "LOAD";
    }

    public int getOffset() {
        return offset;
    }
}
