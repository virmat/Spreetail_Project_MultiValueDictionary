package main.Interfaces;

/*
// Interface for each operations implementation,
// 1. Through this interface we can implement multiple implementations.
// 2. This breaks up the complex designs and clear the dependencies between objects.
// 3. We can use the same interface and add a different implementation at the backend.
 */
public interface DictionaryOperationInterface {

    String addDictionaryData(String key, String value);
    String getMembers(String key);
    String removeMember(String key, String value);
    String getKeys();
    String removeAllMembers(String key);
    String clearDictionary();
    String isKeyPresent(String key);
    String isMemberPresent(String key, String value);
    String getAllMembers();
    String getAllDictionaryItems();
}