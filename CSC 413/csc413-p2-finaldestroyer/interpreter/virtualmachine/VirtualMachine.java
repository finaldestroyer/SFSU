package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private final Program program;
    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private int programCounter;
    private boolean isRunning;
    private String dumpMode = "OFF";

    /*protected VirtualMachine(Program program) {
        this.program = program;
    }*/
    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            programCounter++;
        }
    }

    public void push(int num) {
        runTimeStack.push(num);
    }

    public int topStack() {
        return runTimeStack.peek();
    }

    public RunTimeStack getStack() {
        return this.runTimeStack;
    }

    public Stack getReturnAddress() {
        return this.returnAddress;
    }

    public void setReturnAddress(Stack<Integer> returnAddress) {
        this.returnAddress = returnAddress;
    }

    public int getProgramCounter() {
        return this.programCounter;
    }

    public void setProgramCounter(int num) {
        this.programCounter = num;
    }

    public String getDumpMode() {
        return this.dumpMode;
    }

    public void setDumpMode(String dumpState) {
        this.dumpMode = dumpState;
    }

    public boolean getIsRunning() {
        return this.isRunning;
    }

    public void setIsRunning(boolean running) {
        this.isRunning = running;
    }

}
