package M02.Programing_Assignments;

import java.util.Scanner;

/*
 * Nathan Able
 * SDEV 200
 * Assignment 12.9
 *
 * Define a custom exception called BinaryFormatException. (implied as an extention of NumberFormatException that was done in 12.7)
 *Implement the bin2Dec method (Convert a binary to decimal) to throw a BinaryFormatException if the string is not a binary string. (bin2Dec method comes from 12.7)
 *
 */
public class BinaryFormatException extends NumberFormatException {
    //Custom exception that allerts user and relays the cause
    public BinaryFormatException(String binaryString, String cause) {
		super(binaryString + " is not a binary string. This was caused by the "+ cause + " character in the string.");

	}

    //Itterate through string to check if value is either 1 or 0
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
		int decimal = 0;
        String cause = "";
		for (int i = 0, j = binaryString.length() - 1;
			i < binaryString.length(); i++, j--) {

			if (binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1'){
                cause = "" + binaryString.charAt(i);
				throw new BinaryFormatException(binaryString, cause);
            }
            //Convert to decimal
			decimal += (Integer.parseInt(String.valueOf(binaryString.charAt(i))))
				* Math.pow(2, j);
		}
		return decimal;
	}

    	public static void main(String[] args) {
		// Create a Scanner
		Scanner keyboard = new Scanner(System.in);

		// Prompt the user to enter a binary string
		System.out.print("Enter a binary: ");
        //Standard exception handling using the built-in exception
		try {
			System.out.println(bin2Dec(keyboard.nextLine()));
		}
		catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
        keyboard.close();
	}
}
