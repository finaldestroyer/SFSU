package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private final String id = "READ";
    int userInt;
    Scanner scan;
    private int value;
    private ArrayList<String> args;

    @Override
    public String getLabel() {
        return String.valueOf(args);
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public void init(ArrayList<String> arguments) {
        args = arguments;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int userInt = 0;
        System.out.println("Please enter an integer: ");
        scan = new Scanner(System.in);
        try {
            userInt = Integer.parseInt(String.valueOf(scan));
            virtualMachine.getStack().push(userInt);
        } catch (NumberFormatException e) {
            System.out.println("input is not an int value");
            execute(virtualMachine);
        }
        if (virtualMachine.getDumpMode().equals("ON")) {
            System.out.println(getLabel());
        }

    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }
}
