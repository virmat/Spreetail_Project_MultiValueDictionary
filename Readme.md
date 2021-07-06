Goal:

To build a command line app that stores a multi-value string dictionary in memory. This should be an application that is run on the command line and can be used interactively as shown in the examples.

----------------------------

Functionalities Provided:

    Following command line operations are provided in this program:

    1. KEYS: Returns all the keys in the dictionary. Order is not guaranteed.
    2. MEMBERS: Returns the collection of strings for the given key. Return order is not guaranteed. Returns an error if the key does not exists.
    3. ADD: Adds a member to a collection for a given key. Displays an error if the member already exists for the key.
    4. REMOVE: Removes a member from a key. If the last member is removed from the key, the key is removed from the dictionary. If the key or member does not exist, displays an error.
    5. REMOVEALL: Removes all members for a key and removes the key from the dictionary. Returns an error if the key does not exist.
    6. CLEAR: Removes all keys and all members from the dictionary.
    7. KEYEXISTS: Returns whether a key exists or not.
    8. MEMBEREXISTS: Returns whether a member exists within a key. Returns false if the key does not exist.
    9. ALLMEMBERS: Returns all the members in the dictionary. Returns nothing if there are none. Order is not guaranteed.
    10. ITEMS: Returns all keys in the dictionary and all of their members. Returns nothing if there are none. Order is not guaranteed.

----------------------------

Testing Examples:
    
    1. Keys:
        ADD foo bar
        > Added
        ADD foo baz
        > Added
        ADD foo bar
        > ERROR, member already exists for key

    2. MEMBERS:
        ADD foo bar
        ADD foo baz
        MEMBERS foo
        > 1) bar
        > 2) baz
        MEMBERS bad
        > ERROR, key does not exist.

    3. ADD:
        ADD foo bar
        > Added
        ADD foo baz
        > Added
        ADD foo bar
        > ERROR, member already exists for key

    4. REMOVE:
        ADD foo bar
        > Added
        ADD foo baz
        > Added
        REMOVE foo bar
        > Removed
        REMOVE foo bar
        > ERROR, member does not exist
        REMOVE boom pow
        > ERROR, key does not exist

    5. REMOVEALL:
        ADD foo bar
        > Added
        ADD foo baz
        > Added
        REMOVEALL foo
        > Removed
        REMOVEALL foo
        > ERROR, key does not exist

    6. CLEAR:
        ADD foo bar
        > Added
        ADD foo baz
        > Added
        CLEAR
        > Cleared
        KEYS
        > (empty set)

    7. KEYEXISTS:
        KEYEXISTS foo
        > false
        ADD foo bar
        > Added
        KEYEXISTS foo
        > true

    8. MEMBEREXISTS:
        MEMBEREXISTS foo bar
        > false
        ADD foo bar
        > Added
        MEMBEREXISTS foo bar
        > true
        MEMBEREXISTS foo baz
        > false

    9. ALLMEMBERS:
        ALLMEMBERS
        > (empty set)
        ADD foo bar
        > Added
        ADD foo baz
        > Added
        ALLMEMBERS
        > 1) bar
        > 2) baz
        ADD bang bar
        > Added
        ALLMEMBERS
        > 1) bar
        > 2) baz
        > 3) bar
        > 4) baz

    10. ITEMS:
       ADD foo bar
       ADD foo baz
       ADD bang bar
       ADD bang baz
       ITEMS
       > 1) foo: bar
       > 2) foo: baz
       > 3) bang: bar
       > 4) bang: baz

----------------------------

Additional Features added:

    1. Developer is provided with the flexibility to implement the functionalities implementation in a different way in the future without affecting the other program. This is achieved by addition of an interface using which we can implement multiple implementations.
    2. User can choose to exit the program gracefully without affecting the existing program.
    3. Input commands are case in-sensitive therefore user is not bound to follow any specific case in input pattern.

----------------------------

Steps to Run the Program:

    1. Compile the code: 
        * Location: cd <project_folder>/src
        * Command: javac -d /Users/viratm/IdeaProjects/SpreetailProject/bin -cp . main/*.java
        * Add the path of your local workspace where classes after compilation needs to created.
          Example: javac -d <project folder>/bin . main/*.java

    2. Run the program: 
        * Location: cd <project_folder>/bin
        * Command: java main.Main
        * Run this command from the folder where compilation classes where created.

    3. Enter the command as prompted on the command line.



