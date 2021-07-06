package main;

import main.Implementations.DictionaryInMemoryOperationImpl;
import java.util.Scanner;

import static main.Utils.DictionaryHelper.scanString;
import static main.Utils.DictionaryHelper.exitOperations;
import static main.Utils.DictionaryHelper.displayMessage;
import static main.Utils.DictionaryHelper.validateInput;

/*
// 1. User is prompted to enter the operation and its arguments.
// 2. Operation and number of arguments required by it are checked, Operations are case in-sensitive.
// 3. If operation or number of arguments is not correct, user is prompted with Error message and is allowed to reenter.
// 4. If both are correct than respective implementation for each operation is called and result is displayed.
// 5. User can also exit the program.
 */
public class MultiValueDictionary {

    public void inputDictionaryCommands(Scanner sc, DictionaryInMemoryOperationImpl dictOperations) {
        boolean isUserOperating = true;

        while(isUserOperating) {
            boolean errorFlag = false;
            System.out.println("Please enter the command:");
            System.out.println("(Available Commands: ADD, MEMBERS, REMOVE, KEYS, REMOVEALL, " +
                    "CLEAR, KEYEXISTS, MEMBEREXISTS, ALLMEMBERS, ITEMS, EXIT)");

            String userInput = scanString(sc);
            String[] input = userInput.split(" ");
            String operation = input[0];

            switch (operation.toUpperCase()) {
                case "ADD":
                    if(validateInput(input, 3)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.addDictionaryData(input[1], input[2]);
                        displayMessage(message);
                    }
                    break;
                case "MEMBERS":
                    if(validateInput(input, 2)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.getMembers(input[1]);
                        displayMessage(message);
                    }
                    break;
                case "REMOVE":
                    if(validateInput(input, 3)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.removeMember(input[1], input[2]);
                        displayMessage(message);
                    }
                    break;
                case "KEYS":
                    if(validateInput(input, 1)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.getKeys();
                        displayMessage(message);
                    }
                    break;
                case "REMOVEALL":
                    if(validateInput(input, 2)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.removeAllMembers(input[1]);
                        displayMessage(message);
                    }
                    break;
                case "CLEAR":
                    if(validateInput(input, 1)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.clearDictionary();
                        displayMessage(message);
                    }
                    break;
                case "KEYEXISTS":
                    if(validateInput(input, 2)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.isKeyPresent(input[1]);
                        displayMessage(message);
                    }
                    break;
                case "MEMBEREXISTS":
                    if(validateInput(input, 3)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.isMemberPresent(input[1], input[2]);
                        displayMessage(message);
                    }
                    break;
                case "ALLMEMBERS":
                    if(validateInput(input, 1)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.getAllMembers();
                        displayMessage(message);
                    }
                    break;
                case "ITEMS":
                    if(validateInput(input, 1)) {
                        errorFlag = true;
                    } else {
                        String message = dictOperations.getAllDictionaryItems();
                        displayMessage(message);
                    }
                    break;
                case "EXIT": {
                    isUserOperating = exitOperations();
                    break;
                    }

                default: {
                    System.out.println("Invalid Operation Entered!");
                }
            }

            if(errorFlag) {
                System.out.println("Invalid Operation Entered!");
            }
            System.out.println("\n");
        }
        }
}
