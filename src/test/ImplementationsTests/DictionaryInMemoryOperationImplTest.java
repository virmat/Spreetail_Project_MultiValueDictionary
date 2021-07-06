package test.ImplementationsTests;

import static main.Utils.Constants.ERROR_ADD_MESSAGE;
import static main.Utils.Constants.ADD_MESSAGE;
import static main.Utils.Constants.ERROR_GET_MEMBERS_MESSAGE;
import static main.Utils.Constants.MEMBER_REMOVED_MESSAGE;
import static main.Utils.Constants.MEMBER_ERROR_MESSAGE;
import static main.Utils.Constants.EMPTY_SET_MESSAGE;
import static main.Utils.Constants.CLEARED_MESSAGE;
import static main.Utils.Constants.TRUE_MESSAGE;
import static main.Utils.Constants.FALSE_MESSAGE;

import main.Implementations.DictionaryInMemoryOperationImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DictionaryInMemoryOperationImplTest {

    StringBuilder MEMBERS_HAPPY_CASE = new StringBuilder();
    DictionaryInMemoryOperationImpl dictionaryInMemoryOperationImpl = new DictionaryInMemoryOperationImpl();

    @AfterEach
    void tearDown() {
        dictionaryInMemoryOperationImpl.clearDictionary();
    }

    /*
    -----------------------------------------------------------------------
    Add Data to Dictionary Unit tests
    -----------------------------------------------------------------------
   */
    @Test
    void addDictionaryDataTest() {
        String message = dictionaryInMemoryOperationImpl.addDictionaryData("foo", "bar");

        Assertions.assertEquals(ADD_MESSAGE, message);
    }

    @Test
    void addDictionaryDataAlreadyExist() {
        dictionaryInMemoryOperationImpl.addDictionaryData("foo", "bar");
        String message = dictionaryInMemoryOperationImpl.addDictionaryData("foo", "bar");

        Assertions.assertEquals(ERROR_ADD_MESSAGE, message);
    }

    @Test
    void addDictionaryDataKeyExist() {
        dictionaryInMemoryOperationImpl.addDictionaryData("foo", "bar");
        String message = dictionaryInMemoryOperationImpl.addDictionaryData("foo", "baz");

        Assertions.assertEquals(ADD_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Get Dictionary Members Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void getMembers() {
        createMemberList();
        addMembers();
        String message = dictionaryInMemoryOperationImpl.getMembers("foo");

        Assertions.assertEquals(MEMBERS_HAPPY_CASE.toString(), message);
    }

    @Test
    void getMembersKeyNotPresent() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.getMembers("bang");

        Assertions.assertEquals(ERROR_GET_MEMBERS_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Remove Members from Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void removeMember() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.removeMember("foo", "bar");

        Assertions.assertEquals(MEMBER_REMOVED_MESSAGE, message);
    }

    @Test
    void removeMemberNotPresent() {
        addMembers();
        dictionaryInMemoryOperationImpl.removeMember("foo", "bar");
        String message = dictionaryInMemoryOperationImpl.removeMember("foo", "bar");

        Assertions.assertEquals(MEMBER_ERROR_MESSAGE, message);
    }

    @Test
    void removeMemberKeyNotPresent() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.removeMember("boo", "pow");

        Assertions.assertEquals(ERROR_GET_MEMBERS_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Get Keys from Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void getKeys() {
        MEMBERS_HAPPY_CASE.append("1) foo");
        MEMBERS_HAPPY_CASE.append(System.lineSeparator());

        addMembers();
        String message = dictionaryInMemoryOperationImpl.getKeys();

        Assertions.assertEquals(MEMBERS_HAPPY_CASE.toString(), message);
    }

    @Test
    void getKeysNoKeysPresent() {
        String message = dictionaryInMemoryOperationImpl.getKeys();

        Assertions.assertEquals(EMPTY_SET_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Remove Members from Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void removeAllMembers() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.removeAllMembers("foo");

        Assertions.assertEquals(MEMBER_REMOVED_MESSAGE, message);
    }

    @Test
    void removeAllMembersKeyNotPresent() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.removeAllMembers("bang");

        Assertions.assertEquals(ERROR_GET_MEMBERS_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Clear Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void clearDictionary() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.clearDictionary();

        Assertions.assertEquals(CLEARED_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Clear Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void isKeyPresent() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.isKeyPresent("foo");

        Assertions.assertEquals(TRUE_MESSAGE, message);
    }

    @Test
    void isKeyNotPresent() {
        addMembers();
        String message = dictionaryInMemoryOperationImpl.isKeyPresent("bang");

        Assertions.assertEquals(FALSE_MESSAGE, message);
    }

    /*
    -----------------------------------------------------------------------
    Check Member Present in Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void isMemberPresent() {
        addMembers();
        String message1 = dictionaryInMemoryOperationImpl.isMemberPresent("foo", "bar");
        String message2 = dictionaryInMemoryOperationImpl.isMemberPresent("bang", "bar");

        Assertions.assertEquals(TRUE_MESSAGE, message1);
        Assertions.assertEquals(FALSE_MESSAGE, message2);
    }

    /*
    -----------------------------------------------------------------------
    Get all members from the Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void getAllMembers() {
        createMemberList();
        addMembers();
        String message1 = dictionaryInMemoryOperationImpl.getAllMembers();

        Assertions.assertEquals(MEMBERS_HAPPY_CASE.toString(), message1);
        dictionaryInMemoryOperationImpl.clearDictionary();
        String message2 = dictionaryInMemoryOperationImpl.getAllMembers();
        Assertions.assertEquals(EMPTY_SET_MESSAGE, message2);
    }

    /*
    -----------------------------------------------------------------------
    Get all members from the Dictionary Unit tests
    -----------------------------------------------------------------------
    */
    @Test
    void getAllDictionaryItems() {
        MEMBERS_HAPPY_CASE.append("1) foo:bar");
        MEMBERS_HAPPY_CASE.append(System.lineSeparator());
        MEMBERS_HAPPY_CASE.append("2) foo:baz");
        MEMBERS_HAPPY_CASE.append(System.lineSeparator());

        addMembers();
        String message1 = dictionaryInMemoryOperationImpl.getAllDictionaryItems();

        Assertions.assertEquals(MEMBERS_HAPPY_CASE.toString(), message1);
        dictionaryInMemoryOperationImpl.clearDictionary();
        String message2 = dictionaryInMemoryOperationImpl.getAllMembers();
        Assertions.assertEquals(EMPTY_SET_MESSAGE, message2);
    }

    private void addMembers() {
        dictionaryInMemoryOperationImpl.addDictionaryData("foo", "bar");
        dictionaryInMemoryOperationImpl.addDictionaryData("foo", "baz");
    }

    private void createMemberList() {
        MEMBERS_HAPPY_CASE.append("1) bar");
        MEMBERS_HAPPY_CASE.append(System.lineSeparator());
        MEMBERS_HAPPY_CASE.append("2) baz");
        MEMBERS_HAPPY_CASE.append(System.lineSeparator());
    }
}