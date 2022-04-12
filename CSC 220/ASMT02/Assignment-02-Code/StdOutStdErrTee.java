/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StdOutStdErrTee.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.io.*;

public class StdOutStdErrTee extends OutputStream {
    
    private String Current_Out_Path = null;
    private String Current_Error_Path = null;
    private final String Default_Out_Path= "";
    private final String Default_Error_Path= "";
    private static OutputStream[] OUTPUT_STREAMS = null;

    public StdOutStdErrTee() {

    }
    public StdOutStdErrTee(String sOutPath, String sErrPath) {
        OUTPUT_STREAMS = createFileStreams(sOutPath, sErrPath);
    }
    private StdOutStdErrTee(PrintStream printStream, FileOutputStream fOutStream) {
        OUTPUT_STREAMS = new OutputStream[]{printStream, fOutStream};
    }
    private static FileOutputStream[] createFileStreams(String sOutPath, String sErrPath) {
        try {
            return new FileOutputStream[]{
                    new FileOutputStream(sOutPath), new FileOutputStream(sErrPath)
            };
        } catch (FileNotFoundException e) {
            System.err.printf(
                    "Could not create file output streams at '%s' and '%s'. Reason: %s\n"
                            + "Creating file output streams at default location instead...",
                    sOutPath, sErrPath, e.getMessage()
            );
            return defaultFileStreams();
        }
    }
    private static FileOutputStream[] defaultFileStreams() throws UncheckedIOException {
        try {
            return new FileOutputStream[]{
                    new FileOutputStream(Config.getDefaultStdOutFilePath()),
                    new FileOutputStream(Config.getDefaultStdErrFilePath())
            };
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }

    public Object getStdOutFilePath() {
        return Current_Out_Path;
    }
    public Object getStdErrFilePath() {
        return Current_Error_Path;
    }

    public void startLog() {
        StdOutStdErrTee sOutTee = new StdOutStdErrTee(System.out,
                (FileOutputStream) OUTPUT_STREAMS[0]);
        StdOutStdErrTee sErrTee = new StdOutStdErrTee(System.err,
                (FileOutputStream) OUTPUT_STREAMS[1]);
        PrintStream sOut = new PrintStream(sOutTee);
        PrintStream sErr = new PrintStream(sErrTee);

        System.setOut(sOut);
        System.setErr(sErr);
    }
    @Override
    public void write(int b) throws IOException {
        for (OutputStream out : OUTPUT_STREAMS) {
            out.write(b);
            out.flush();
        }
    }
    public void stopLog() {
    }
}