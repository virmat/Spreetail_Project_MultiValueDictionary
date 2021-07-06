package main;

import main.Implementations.DictionaryInMemoryOperationImpl;
import java.util.Scanner;

/*
// Main starts the program by initializing:
// 1. Scanner object which is used to take input from user.
// 2. MultiValueDictionary object which calls the respective implementation of each operations.
// 3. DictionaryInMemoryOperationImpl object which has all the operations in memory implementation,
// if in the future external memory implementation is added in that case we can initialize the new object and
// pass that to the MultiValueDictionary object.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MultiValueDictionary dict = new MultiValueDictionary();
        DictionaryInMemoryOperationImpl dictOperations = new DictionaryInMemoryOperationImpl();

        dict.inputDictionaryCommands(sc, dictOperations);
    }
}
