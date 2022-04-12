package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Stack;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Stack<ByteCode> ListArgs = new Stack<ByteCode>();
        String line;
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName;    // ByteCode name from .x.cod filess
        String className;       // class name after its mapped from name in source code to class name.
        Class classBlueprint;
        Program program = new Program();
        ByteCode bc = null;
        try {
            while (this.byteSource.ready()) {
                // tokenize read line
                line = this.byteSource.readLine();
                while (!line.equals(null)) {
                    items = line.split("\\s+");
                    // gets the first token of line
                    byteCodeName = items[0];
                    // gets the class name from token
                    className = CodeTable.getClassName(byteCodeName);
                    // loads the class blueprint from classname
                    classBlueprint = Class.forName("interpreter.bytecode." + className);
                    // gets the declared constructor (should be no-arg constructor)
                    // create a new instance of bytecode using constructor
                    bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();
                }
                // ^gets the remaining arguments
                // pass args to bytecode init function
                bc.init(args);
                // add the bytecode to program
                ListArgs.add(bc);
                program.AddByteCode(bc);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(255);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        program.resolveAddress();
        return program;
    }
}
