package assignment04PartB2;

import java.util.Arrays;

/**
 * Part B.2
 * <p>
 * Please do not change any code in the main method
 */
public class ArraySortByFirst {
    public static int[][] swapRows(int[][] data, int i, int j) {
        for (int k = 0; k < data[0].length; k++) {
            int temp = data[i][k];
            data[i][k] = data[j][k];
            data[j][k] = temp;
        }
        return data;
    }

    public static void sortByFirst(int data[][]) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                // Checking elements
                int temp = 0;
                if (data[j][0] < data[i][0]) {
                    // Swapping
                    swapRows(data, i, j);
                }
            }
        }
    }

    public static void display(int data[][]) {
        System.out.println(Arrays.deepToString(data));
    }

    //
    // Please do not change any code in the main method
    //
    public static void main(String args[]) {
        int array[][] = {{1, 2, 3, 4, 5},
                {3, 4, 5, 1, 2},
                {5, 2, 3, 4, 1},
                {2, 3, 1, 4, 5},
                {4, 2, 3, 1, 5}};

        System.out.println("The array is initially ");
        display(array);
        System.out.println();

        sortByFirst(array);
        System.out.println("The array after sorting is ");
        display(array);
        System.out.println();
    }
}