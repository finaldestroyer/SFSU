package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program extends Object {

    //                     Value , index
    private static HashMap<String, Integer> labelList;
    private final ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<ByteCode>();
        labelList = new HashMap<>();
    }

    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public int getSize() {
        return this.program.size();
    }

    public void AddByteCode(ByteCode byteCode) {
        if (byteCode instanceof LabelCode) {
            //rename newBranch
            LabelCode newBranch = (LabelCode) byteCode;
            addLabel(newBranch.getLabel(), program.size());
        }
        program.add(byteCode);
    }

    private void addLabel(Object label, int size) {
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */

    public void resolveAddress() {
        HashMap<String, Integer> label = new HashMap<>();
        for (int i = 0; i < program.size(); i++) {
            ByteCode byteCode = program.get(i);
            if (byteCode instanceof LabelCode) {
                label.put(byteCode.getLabel(), i);
            }
        }
        for (int i = 0; i < this.program.size(); i++) {
            ByteCode byteCode = program.get(i);
            if ((byteCode instanceof FalseBranchCode)) {                    //this holds the line value for the FalseBranchCode's destination address
                int val = label.get(byteCode.getLabel());
                byteCode.setResolvedAddress(val);
            } else if (byteCode instanceof GotoCode) {
                int val = label.get(byteCode.getLabel());        //this holds the line value for the GotoCode's destination address
                ((GotoCode) byteCode).setResolvedAddress(val);
            } else if (byteCode instanceof CallCode) {
                int val = label.get(byteCode.getLabel());        //this holds the line value for the CallCode's destination address
                byteCode.setResolvedAddress(val);
            }
        }

    }

}


