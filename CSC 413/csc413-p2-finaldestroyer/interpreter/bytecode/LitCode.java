package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    int value;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
        } else {
            this.id = "";
        }
    }


    public String toString() {
        String base = "LIT " + value;
        if (id != null) {
            base += "int " + id;
        }
        return base;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if ("".equals(this.id)) {
            virtualMachine.getStack().push(this.value);
        } else {
            virtualMachine.getStack().push(0);
        }

        if (virtualMachine.getDumpMode().equals("ON")) {
            String output = "LIT " + this.value + " " + this.id;
            if (!this.id.equals("")) {
                output = output + "    int " + this.id;
            }
            System.out.println(output);
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

}
