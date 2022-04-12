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
import java.util.Vector;

public class BlurbGenerator {
    Stack<Integer> list;
    String Blurb;
    String Whoozits;
    String Whazits;
    String Ys;
    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        list = null;
        Blurb = null;
        Whoozits = null;
        Whazits = null;
        Ys=null;
    }
    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        list = null;
        Blurb = null;
        Whoozits = null;
        Whazits = null;
        Ys=null;
        return makeWhoozit() + makeMultiWhatzits();
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
        return Whoozits = "x" + makeYString();
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString() {
        Random rd = new Random();
        int randInt = rd.nextInt();
        if(randInt%3 != 0) {
            return "y" + makeYString();
        }
        return "";
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */

    private String makeMultiWhatzits() {
        Random rd = new Random();
        int randInt = rd.nextInt();
        Whazits = makeWhatsit();
        if(randInt%3 != 0) {
            return Whazits + makeWhatsit();
        }
        return "";
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatsit() {
        Random rd = new Random();
        int randInt = rd.nextInt();
        if(randInt%2 != 0) {
            return "z" + makeWhoozit();
        }
            return "d" + makeWhoozit();
    }

    private Vector<String> IntToString(Vector<Integer> listInt){
        Vector<String> listString = new Vector<String>();
        for(Integer s : listInt) {
            listString.add(String.valueOf(s));
        }
        return listString;
    }
    private String StringVectorToString(Vector<String> listString){
        String list=null;
        for (String i : listString){
            list=i+list;
        }
        return list;
    }
}