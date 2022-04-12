package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private int value;
    private String id;
    private int top;

    @Override
    public void init(ArrayList<String> args) {
        if (args.size() > 0) {
            this.id = args.get(0);
        } else {
            this.id = "";
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setProgramCounter((Integer) virtualMachine.getReturnAddress().pop());
        virtualMachine.getStack().popFrame();
        top = virtualMachine.getStack().peek();
        virtualMachine.getStack().clear();
        virtualMachine.getStack().push(top);
        if (virtualMachine.getDumpMode().equals("ON")) {
            int n = this.id.indexOf("<");
            String temp;
            if (n < 0) {
                temp = this.id;
            } else {
                temp = this.id.substring(0, n);
            }
            System.out.println("RETURN " + this.id + "    exit " + temp + ": " + this.top);
        }
    }

    @Override
    public void setResolvedAddress(Integer integer) {

    }

    @Override
    public String getLabel() {
        return id;
    }

    /**
     * @return
     */
    @Override
    public String getCode() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        String base = "RETURN" + top;
        return base;

    }

    //@Override
    //public int getCode() {
    //    return value;
    //}
}
