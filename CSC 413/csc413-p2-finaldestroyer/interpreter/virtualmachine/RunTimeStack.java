package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private final ArrayList<Integer> runTimeStack;
    private final Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public int lastIndex() {
        return this.runTimeStack.size() - 1;
    }

    public void dump() {
        Iterator iterator = framePointer.iterator();
        int framePointerCounter = (Integer) iterator.next();
        if (iterator.hasNext()) {
            framePointerCounter = (Integer) iterator.next();
        }
        System.out.printf("[");
        if (!runTimeStack.isEmpty()) {
            System.out.print(runTimeStack.get(0));
        }
        for (int i = 1; i < runTimeStack.size(); i++) {

            if (i == framePointerCounter) {
                System.out.print("] [" + runTimeStack.get(i));

                if (iterator.hasNext()) {
                    framePointerCounter = (Integer) iterator.next();
                }
            } else {
                System.out.print("," + runTimeStack.get(i));
            }
        }
        System.out.println("]");
    }

    public int peek() {
        return this.runTimeStack.get(lastIndex());
    }

    public int push(int valueToPush) {
        this.runTimeStack.add(valueToPush);
        return this.peek();
    }

    public int pop() {
        return this.runTimeStack.remove(lastIndex());
    }

    public int store(int offset) {
        int temp = this.runTimeStack.get(lastIndex() - offset);
        runTimeStack.remove(lastIndex() - offset);
        push(temp);
        return 0;
    }

    public int load(int offset) {
        runTimeStack.add(runTimeStack.get(lastIndex() - offset));
        runTimeStack.remove(lastIndex() - offset);
        return this.runTimeStack.get(lastIndex());
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame() {
        for (int i = 0; i < runTimeStack.size() - 1; i++) {
            runTimeStack.remove(i);
        }
        for (int i = 0; i < framePointer.size() - 1; i++) {
            framePointer.remove(i);
        }
    }

    public void clear() {
        runTimeStack.clear();
    }
}
