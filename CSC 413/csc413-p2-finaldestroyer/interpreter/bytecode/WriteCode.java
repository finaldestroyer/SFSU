package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    int value;
    String id;

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.getStack().peek());
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("WRITE");
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
