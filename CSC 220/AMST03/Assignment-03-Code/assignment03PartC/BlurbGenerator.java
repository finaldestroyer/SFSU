/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Japheth Wun
 * **********************************************
 */

package assignment03PartC;
import java.util.Random;
import java.util.Stack;

public class BlurbGenerator {
    Stack<Integer> list;
    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        list = null;
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        /*for(int i=0;i<10;i++) {
            Random rd = new Random();
            int randInt = rd.nextInt();
            list.push(randInt);
            rd = null;
        }*/
        return null;
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString() {
        String string = null;
        Random rd = new Random();
        for(int i=0;i<rd.nextInt();i++) {
            string = string+"y";        
        }
        rd = null;
        return string;
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits() {
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit() {
    }
}