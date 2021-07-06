package main.Utils;

import java.util.Scanner;

public class DictionaryHelper {

    // Prints the all the messages and result to the user
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    // Helper to get input from the user
    public static String scanString(Scanner sc) {
        return sc.nextLine();
    }

    // Prints exit message and return false which indicates that user no longer wants to operate on the program
    public static boolean exitOperations() {
        System.out.println("Exiting the Dictionary");
        System.out.println("Thank you!");
        return false;
    }

    public static boolean validateInput(String[] input, int numberOfArguments) {
        if(input.length != numberOfArguments) {
            return true;
        } else {
            for(String s: input) {
                if(s.equals("null")) {
                    System.out.println("ERROR, Null argument entered");
                    return true;
                }
            }
        }
        return false;
    }
}
