package M04.Programing_Assignments;
/*
 * Nathan Able
 * SDEV 200
 * Assignment 21.3
 *
 * Revise the program in Listing 21.7. If a keyword is in a comment or in a string, don’t count it.
 * Pass the Java file name from the command line.
 * Assume the Java source code is correct and line comments and paragraph comments do not overlap.
 */


import java.util.*;
import java.io.*;

public class CountKeywords {
    public static void main(String[] args)throws Exception{
        String filename;
        Scanner keyboard = new Scanner(System.in);
        //Validate Arg was passed and only one was passed
        if (args.length !=1){
            /*
            Blocked code commented out to allow for easier testing

            System.out.println("Requires a filename to run. Limit one file.");
            //Exit 1 as file was expected
            System.exit(1);
            */
            System.out.println("Enter a filename to check: ");
            filename = keyboard.nextLine();
        }else{
            filename = args[0];
        }

        //Get file from the main args array
        File file = new File(filename);
        if (!file.exists()){
            System.out.println("File " + filename + " was not found");
            //Exit 1 no file found
            System.exit(1);
        }
        //If file is valid call method
        System.out.println("This file contains " + countKeywords(file));
        keyboard.close();
    }
    //Pulled from Listing 21.7
    public static int countKeywords(File file) throws Exception {
		// Array of all Java Keywords + true, false and null
		String[] keywordString = {"abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else", "enum",
			"extends", "for", "final", "finally", "float", "goto",
			"if", "implements", "import", "instanceof", "int",
			"interface", "long", "native", "new", "package", "private",
			"protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this",
			"throw", "throws", "transient", "try", "void", "volatile",
			"while", "true", "false", "null"};

		Set<String> keywordSet =
			new HashSet<>(Arrays.asList(keywordString));
		int count = 0;

		Scanner checkFile = new Scanner(file);

        //Loop over entire file
		while (checkFile.hasNext()) {
            //Jump to next line when you hit a line comment
			String word = checkFile.next();
			if (word.equals("//")) {
				checkFile.nextLine();
			}
            //Jump to next word when you hit a String to look for the next double quote to determine the end of the string
			else if (word.contains("\"")) {
				String nextWord;
				do {
					nextWord = checkFile.next();
				} while (!nextWord.contains("\"")); //Finds end of string
			}
            //Use same method as above for block comments
			else if (word.contains("/*")) {
				String nextWord;
				do {
					nextWord = checkFile.next();
				} while (!nextWord.contains("*/"));
			}
            //Add to count if all else is excluded
			else if (keywordSet.contains(word))
				count++;
		}
        checkFile.close();
		return count;
	}
}
