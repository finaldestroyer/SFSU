package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    int value;
    String id;


    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //The execution will be HALTED
        virtualMachine.setIsRunning(false);
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println("HALT");
        }


        return;
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return String.valueOf(id);
    }

    @Override
    public String getCode() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return "HALT";
    }
}
