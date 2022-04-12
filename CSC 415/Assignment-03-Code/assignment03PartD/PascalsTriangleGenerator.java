/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Japheth Wun
 * **********************************************
 */

package assignment03PartD;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.util.Vector;

public class PascalsTriangleGenerator {
    //Caller Method
    public PascalsTriangleGenerator() {
        //Scanner rowInput = new Scanner(System.in);
        //computeRow(rowInput.nextInt());
    }
    //Computation Method
    public static int[] computeRow(int rowToCompute) {
        Vector<Integer> pascArray = new Vector<Integer>();
        for(int i=0; i<rowToCompute;i++){
            pascArray.add(ncr(rowToCompute,i));
        }
        pascArray.add(1);
        return VectorToArray(pascArray);
    }
    //Pasacals Triangle Computation
    private static int ncr(int n, int r){
        return factorial(n) / ( factorial(n-r) * factorial(r) );
    }
    //Factorial Computation
    private static int factorial(int i) {
        if (i == 0 || i == 1)
            return 1;
        return i * factorial(i - 1);
    }
    //Converted Vector To Array such that the array size can be adjusted
    private static int[] VectorToArray(Vector<Integer> pascArray){
        int intArray[] = new int[pascArray.size()];
        for(int i=0;i<pascArray.size();i++){
            intArray[i] = pascArray.get(i);
        }
        return intArray;
    }
}
