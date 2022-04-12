package interpreter.bytecode;

import interpreter.virtualmachine.RunTimeStack;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {
    private RunTimeStack runTimeStack;

    public abstract String getLabel();

    public abstract String getCode();

    public abstract String toString();

    public abstract void init(ArrayList<String> args);

    public abstract void execute(VirtualMachine virtualMachine);


    public abstract void setResolvedAddress(Integer integer);
}