/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE01.java
 * Author: Duc Ta
 * Author: Japheth Wun
 * **********************************************
 */

package assignment03PartE;

public class Assignment03PartE01 {
    public static void main(String[] args) {
        int i, n = 5, sum = 5;
        for (i = 5; i < 3 * n; i++) {
            sum *= n + i * 7 + 37;
        }
        System.out.println(sum);
    }
}
