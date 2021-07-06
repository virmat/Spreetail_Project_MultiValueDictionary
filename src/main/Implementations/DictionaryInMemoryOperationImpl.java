package main.Implementations;

import main.Interfaces.DictionaryOperationInterface;

import static main.Utils.Constants.ERROR_ADD_MESSAGE;
import static main.Utils.Constants.ADD_MESSAGE;
import static main.Utils.Constants.ERROR_GET_MEMBERS_MESSAGE;
import static main.Utils.Constants.MEMBER_REMOVED_MESSAGE;
import static main.Utils.Constants.MEMBER_ERROR_MESSAGE;
import static main.Utils.Constants.EMPTY_SET_MESSAGE;
import static main.Utils.Constants.CLEARED_MESSAGE;
import static main.Utils.Constants.TRUE_MESSAGE;
import static main.Utils.Constants.FALSE_MESSAGE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
// In memory implementation of all the operations which can be accessed by the user through the interface
 */
public class DictionaryInMemoryOperationImpl implements DictionaryOperationInterface {
    private static final Map<String, Set<String>> dataStore = new HashMap<>();

    /*
    // Adds a member to the collection for a given key.
    // Displays an error if the member already exists for the key.
    */
    public String addDictionaryData(String key, String value) {
        Set<String> tempSet;
        if(dataStore.get(key) != null) {
            tempSet= dataStore.get(key);
            if(tempSet.contains(value)) {
                return ERROR_ADD_MESSAGE;
            }
        } else {
            tempSet = new HashSet<>();
        }
        tempSet.add(value);
        dataStore.put(key, tempSet);
        return ADD_MESSAGE;
    }

    /*
    // Returns the collection of Members for the given key.
    // Return order is not guaranteed.
    // Returns an error if the key does not exists.
     */
    public String getMembers(String key) {
        if(dataStore.containsKey(key)) {
            Set<String> memberSet = dataStore.get(key);
            return formatMemberStrings(memberSet);
        } else {
            return ERROR_GET_MEMBERS_MESSAGE;
        }
    }

    /*
    // Removes a member from a key. If the last member is removed from the key, the key is removed from the dictionary.
    // If the key or member does not exist, displays an error.
     */
    public String removeMember(String key, String value) {
        if(dataStore.containsKey(key)) {
            Set<String> memberSet = dataStore.get(key);
            if(memberSet.contains(value)) {
                memberSet.remove(value);

                if(memberSet.size() == 0) {
                    dataStore.remove(key);
                } else {
                    dataStore.put(key, memberSet);
                }
                return MEMBER_REMOVED_MESSAGE;
            } else {
                return MEMBER_ERROR_MESSAGE;
            }
        } else {
            return ERROR_GET_MEMBERS_MESSAGE;
        }
    }

    /*
    // Returns all the keys in the dictionary. Order is not guaranteed.
     */
    public String getKeys() {
        if(dataStore.size() == 0) {
            return EMPTY_SET_MESSAGE;
        } else {
            return formatMemberStrings(dataStore.keySet());
        }
    }

    /*
    // Removes all members for a key and removes the key from the dictionary.
    // Returns an error if the key does not exist.
     */
    public String removeAllMembers(String key) {
        if(dataStore.containsKey(key)) {
            Set<String> memberSet = dataStore.get(key);
            memberSet.clear();
            dataStore.remove(key);
            return MEMBER_REMOVED_MESSAGE;
        } else {
            return ERROR_GET_MEMBERS_MESSAGE;
        }
    }

    /*
    // Removes all keys and all members from the dictionary.
     */
    public String clearDictionary() {
        for(String s: dataStore.keySet()) {
            dataStore.get(s).clear();
        }
        dataStore.clear();
        return CLEARED_MESSAGE;
    }

    /*
    // Returns whether a key exists or not.
     */
    public String isKeyPresent(String key) {
        return dataStore.containsKey(key)? TRUE_MESSAGE: FALSE_MESSAGE;
    }

    /*
    // Returns whether a member exists within a key.
    // Returns false if the key does not exist.
     */
    public String isMemberPresent(String key, String value) {
        if(dataStore.containsKey(key)) {
            Set<String> memberSet = dataStore.get(key);
            return memberSet.contains(value)? TRUE_MESSAGE: FALSE_MESSAGE;
        } else {
            return FALSE_MESSAGE;
        }
    }

    /*
    // Returns all the members in the dictionary.
    // Returns nothing if there are none. Order is not guaranteed.
    */
    public String getAllMembers() {
        if(dataStore.size() != 0) {
            StringBuilder appendedMembers = new StringBuilder();
            int index = 1;
            for(Map.Entry<String, Set<String>> entrySet: dataStore.entrySet()) {
                for(String s: entrySet.getValue()) {
                    appendedMembers.append(index++ + ") " + s);
                    appendedMembers.append(System.lineSeparator());
                }
            }
            return appendedMembers.toString();
        } else {
            return EMPTY_SET_MESSAGE;
        }
    }

    /*
    // Returns all keys in the dictionary and all of their members.
    // Returns nothing if there are none. Order is not guaranteed.
     */
    public String getAllDictionaryItems() {
        if(dataStore.size() != 0) {
            StringBuilder appendedMembers = new StringBuilder();
            int index = 1;
            for(Map.Entry<String, Set<String>> entrySet: dataStore.entrySet()) {
                for(String s: entrySet.getValue()) {
                    appendedMembers.append(index++ + ") " + entrySet.getKey() + ":" + s);
                    appendedMembers.append(System.lineSeparator());
                }
            }
            return appendedMembers.toString();
        } else {
            return EMPTY_SET_MESSAGE;
        }
    }

    // This helper method formats all the members in a key in the required String format which will be displayed to the user.
    private String formatMemberStrings(Set<String> set) {
        int index = 1;
        StringBuilder appendedStrings = new StringBuilder();
        for(String s: set) {
            appendedStrings.append(index++ + ") " + s);
            appendedStrings.append(System.lineSeparator());
        }
        return appendedStrings.toString();
    }
}
