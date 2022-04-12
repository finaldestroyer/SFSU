/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Directory.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.io.File;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Directory {

    private String path = null;
    private File directory;

    public Directory() {
        this.path = path;
        this.directory = new File(path);
        directory.mkdirs();
    }

    public Object getPath() {
        return path;
    }
}
