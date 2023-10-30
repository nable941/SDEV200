package M01.Programing_Assignments;
/*
 *Nathan Able
 *SDEV200
 *Assignment 6.31
 *Write a method that returns true if m1 and m2 are identical, using the following header:
 *public static boolean equals(int[][] m1, int[][] m2)
 *Write a test program that prompts the user to enter two 3x3
 *arrays of integers and displays whether the two are identical.
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCompare {
    public static void main(String[] args){
        /*
         * Source material used
         * https://www.youtube.com/watch?v=BT71mbx6qk8&ab_channel=CodingHost
         */
        Scanner keyboard = new Scanner(System.in);
        //Initialize 2 blank 3x3 arrays
        int [][]m1 = new int[3][3];
        int [][]m2 = new int[3][3];

        //populate m1
        //itterate rows
        System.out.println("Populate the first array:");
        for(int r=0; r<m1.length;r++){
            for (int c=0;c<m1[0].length;c++){
                System.out.println("Enter row "+r+" column "+c+ " data: ");
                m1[r][c] = keyboard.nextInt();
            }
        }
        //populate m2
        //itterate rows
        System.out.println("Populate the first array:");
        for(int r=0; r<m1.length;r++){
            for (int c=0;c<m1[0].length;c++){
                System.out.println("Enter row "+r+" column "+c+ " data: ");
                m2[r][c] = keyboard.nextInt();
            }
        }

        System.out.println("Arrays " + (equals(m1,m2) ? "match!" : "do not match!"));
        keyboard.close();
    }//End of MAIN

    public static boolean equals(int[][] m1, int[][] m2){
        // Split the arrays into 1D arrays since the equality is not strict
        int[] splitArray1 = splitArray(m1);
        int[] splitArray2 = splitArray(m2);

        // Sort the 1D arrays to check for strict equality
        Arrays.sort(splitArray1);
        Arrays.sort(splitArray2);

        // Compare the sorted arrays for strict equality 
        return Arrays.equals(splitArray1, splitArray2);
    }

    public static int[] splitArray(int[][] array) {

        //initialize a 9 element array
        int[] splitArray = new int[9];
        //Use independent index for 1d array
        int index = 0;
        //Create an individual array from the contents of the original 3x3 array using the same itteration used to build
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[0].length; c++) {
                splitArray[index] = array[r][c];
                index++;
            }
        }

        return splitArray;
    }
}

