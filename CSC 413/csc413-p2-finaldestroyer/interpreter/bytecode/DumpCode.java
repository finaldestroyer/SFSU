package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    int value;
    String id;
    private String dumpState;

    @Override
    public void init(ArrayList<String> args) {
        this.dumpState = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setDumpMode(this.dumpState);
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return "DUMP";
    }

    @Override
    public String getCode() {
        return String.valueOf(dumpState);
    }

    @Override
    public String toString() {
        String base = "DUMP " + dumpState;
        return base;
    }
}
