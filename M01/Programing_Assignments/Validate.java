package M01.Programing_Assignments;
/*
 *Nathan Able
 *SDEV200
 *Assignment 6.31
 *Write a program that prompts the user to enter a credit card number as a long
 *integer. Display whether the number is valid or invalid. Design your program
 *to use the following methods:
 *public static boolean isValid(long number)
 *public static int sumOfDoubleEvenPlace(long number)
 *public static int getDigit(int number)
 *public static int sumOfOddPlace(long number)
 *public static boolean prefixMatched(long number, int d)
 *public static int getSize(long d)
 *public static long getPrefix(long number, int k)
 *
 */
import java.util.Scanner;

public class Validate {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Long ccNum;
        System.out.print("Enter a Credit card number: ");
        ccNum = keyboard.nextLong();

        System.out.println(ccNum+" is "+(isValid(ccNum) ? "valid!" : "not Valid!"));
        keyboard.close();
    }//End of MAIN

    /** Return true if the card number is valid */
    public static boolean isValid(long ccNum){
        //Validate correct length
        boolean rightLength = (getSize(ccNum)>= 13 && getSize(ccNum)<=16);
        //Validate correct starting digit(s)
        boolean rightPrefix = (prefixMatched(ccNum, 4)||
                                prefixMatched(ccNum, 5)||
                                prefixMatched(ccNum, 6)||
                                prefixMatched(ccNum, 37));
        //Validate Sum division
        int sumEven = sumOfDoubleEvenPlace(ccNum);
        int sumOdd = sumOfOddPlace(ccNum);
        int sumTotal = sumEven + sumOdd;
        boolean sumsDiv10 = ((sumTotal %10 == 0));
        return (rightLength && rightPrefix && sumsDiv10);
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number){
        /*
         * source material used
         * https://www.javatpoint.com/java-string-to-int
         */
        //Set base value at 0
        int sum = 0;
        String numberAsString = "" + number;
        ////itterate by -2 working backwatds starting at far right less 2 to start at even spot
        for(int i = getSize(number)-2; i>=0; i-=2){
            sum += getDigit(Integer.parseInt("" + numberAsString.charAt(i)) *2);
        }
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number){
        //If number is a sigle digit
        if (number < 9){
            return number;
        }
        //If it is a double digit spilt the number by div 10 ad add to the "remainder"
        return number / 10 + number % 10;
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number){
        /*
         * source material used
         * https://www.javatpoint.com/java-string-to-int
         */
        //Set base value at 0
        int sum = 0;
        String numberAsString = "" + number;
        //itterate by -2 working backwatds starting at far right less 1 to start at odd spot
        for (int i = getSize(number)-1; i>=0; i-=2){
            //Use parse int to get individual digit
            sum += Integer.parseInt("" + numberAsString.charAt(i));
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d){
        /*
         * Use Get Size to crete a length of 1 or 2 (4,5,6, or 37)
         * Use the returned size of 1 or 2 to get the digit(s) with Longparse
         */
        boolean matched = getPrefix(number, getSize(d)) == d;
        return matched;
    }

    /** Return the number of digits in d */
    public static int getSize(long number){
        /*
         * Source material used
         * https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/long-to-String-in-Java
         */
        String numberAsString = "" + number;
        int strLength = numberAsString.length();
        return strLength;
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k){
        /*
         * Source material used
         * https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/String-to-long-in-Java
         * https://beginnersbook.com/2013/12/java-string-substring-method-example/
         */

        if (getSize(number)>k){
            String numberAsString = "" + number;
            return Long.parseLong(numberAsString.substring(0,k));
        }
        return number;
    }
}
