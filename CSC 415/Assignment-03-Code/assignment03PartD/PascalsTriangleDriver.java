/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleDriver.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Japheth Wun
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment03PartD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalsTriangleDriver {

    private static String goodbye = "Adiós!";

    public static void main(String args[]) {
        int rowNum = getRowNum();

        while (rowNum >= 0) {
            PascalsTriangleGenerator p = new PascalsTriangleGenerator();
            int[] row = p.computeRow(rowNum + 1);
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
            rowNum = getRowNum();
        }
        System.out.println(goodbye);
    }

    private static int getRowNum() throws InputMismatchException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a row of Pascal's Triangle: ");
        int rowNum = -1;
        try {
            rowNum = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.err.println(goodbye);
            System.exit(1);
        } finally {
            // System.out.println("InputMismatchException handled.");
        }
        return rowNum;
    }
}