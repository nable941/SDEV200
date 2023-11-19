package M04.Programing_Assignments;
/*
 * Nathan Able
 * SDEV 200
 * Assignment 20.11
 * Write a program to check whether a Java source-code file has correct pairs of grouping symbols. Pass the source-code file name as a command-line argument.
 *
 */


import java.util.*;
import java.io.*;

public class TestGrouping {
    public static void main(String[] args)throws IOException{
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


        Stack<Character> groups = new Stack<>();
        Scanner checkFile = new Scanner(file);

        //Loop over entire file
        while (checkFile.hasNext()){
            //File loop line by line
            String line = checkFile.nextLine();
            //Itterate through each charcter of the line
            for (int i = 0; i <line.length(); i++){
                    char x = line.charAt(i);
                    //Look for first expected character
                    if (x == '(' || x == '[' || x == '{'){
                        //Put group starter at the top of the stack
                        groups.push(x);
                        //Use else if to get the ending character. Because there is no else all other characters are ignored by loop
                    }else if (x == ')' || x == ']' || x == '}'){
                        validateGroup(groups, x);
                    }
            }
        }
        //Validates that the last starter in the stack was popped out
        System.out.println("File " + filename + (groups.isEmpty() ? " has" : " does't have") + " the expected pair groupings.");
        checkFile.close();
        keyboard.close();
    }
    /*
     * Validate by ommition
     * If the if the top statck item and the found backend item match as expected pairs
     * then remove the top stack item from the stack
     * This accounts for nesting without overlap
     */
    private static void validateGroup(Stack<Character> stack, Character x){
        if((stack.peek() == '(' && x == ')') ||
            (stack.peek() == '[' && x == ']') ||
            (stack.peek() == '{' && x == '}')){
                stack.pop();
            }else{
                System.out.println("The validator encountered a mismatch of expected pair groupings");
                //Exit 1 for failed check
                System.exit(1);
            }
    }
}
