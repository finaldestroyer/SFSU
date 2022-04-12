/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Color.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Color {

    public static final String defaultPreference = "ANSI"; // default
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    public final String encoding;

    public Color(){
        this.encoding = defaultPreference;
    }
    public Color(String encoding) {
        this.encoding = encoding;
    }

    public static String sfsuHighlight(String s) {
        return ANSI_PURPLE_BACKGROUND + ANSI_YELLOW + s + ANSI_RESET;
    }
    public Object getColorSequences() {
        return encoding;
    }

}