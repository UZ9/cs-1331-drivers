import com.cs1331.drivers.annotations.BeforeTest;
import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.utils.StringUtils;
import com.cs1331.drivers.utils.TestUtils;

/**
 * General Tests for LinkedLists.
 */
public class LinkedListGeneralTests {

    private static LinkedList<String> myList;
    private static LinkedList<String> emptyList;

    @BeforeTest
    public static void setupLinkedList() {
        myList = new LinkedList<>(new String[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        emptyList = new LinkedList<>();
    }
    
    @TestCase(name = "Constructor: No-args constructor")
    @Tip(description = "Make sure you have properly implemented isEmpty() on a new LinkedList!")
    public static void constructorNoArgs() throws TestFailedException {
        
        TestFunction.assertEqual(emptyList.isEmpty(), true);

    }

    @TestCase(name = "Constructor: Iterator returns no elements")
    @Tip(description = "Make sure that your iterator() method returns a new iterator() of the correct type, and that it returns no elements")
    public static void constructorNoArgs2() throws TestFailedException {

        TestFunction.assertEqual(TestUtils.iterableToString(emptyList), "");

    }

    @TestCase(name = "Constructor: Given array of String")
    @Tip(description = "This test uses your iterator to convert the LinkedList to String. Even if your constructor is functional, this test may fail because of your iterator implementation!")
    public static void constructorArray() throws TestFailedException {

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "Constructor: Given array of Object")
    @Tip(description = "This test uses your iterator to convert the LinkedList to String. Even if your constructor is functional, this test may fail because of your iterator implementation!")
    public static void constructorArrayObject() throws TestFailedException {
        
        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "Constructor: Given null array")
    @Tip(description = "What should occur when your constructor is given a null array?")
    public static void constructorArrayNull() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class, () -> new LinkedList<>(null));

    }

    @TestCase(name = "Constructor: Given array with one null element")
    @Tip(description = "What should occur when your constructor is given an array with a null element?")
    public static void constructorArrayNullElement() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class, () -> new LinkedList<String>(new String[] {"Tremor", "Skipper", null}));

    }

    @TestCase(name = "toArray(): Valid array of String")
    @Tip(description = "Make sure you're using the iterator's next() and hasNext() methods!")
    public static void toArrayValid() throws TestFailedException {

        TestFunction.assertEqual(StringUtils.arrayToString(myList.toArray()), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt,");

    }

    @TestCase(name = "toArray(): Valid array of Object")
    @Tip(description = "Make sure you're using the iterator's next() and hasNext() methods!")
    public static void toArrayValidObject() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});

        TestFunction.assertEqual(StringUtils.arrayToString(list.toArray()), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt,");

    }

    @TestCase(name = "toArray(): Empty array of String")
    @Tip(description = "Make sure you return an empty array, and not null!\nSee: https://edstem.org/us/courses/42939/discussion/3877975?comment=9010610")
    public static void toArrayEmpty() throws TestFailedException {

        TestFunction.assertEqual(StringUtils.arrayToString(emptyList.toArray()), "");

    }

    @TestCase(name = "contains(): Element at the start")
    @Tip(description =  "Remember to use an iterator, and NOT a loop!")
    public static void containsFirst() throws TestFailedException {
        
        TestFunction.assertEqual(myList.contains("Lindsay"), true);

    }

    @TestCase(name = "contains(): Element in the middle")
    @Tip(description =  "Remember to use an iterator, and NOT a loop!")
    public static void containsMiddle() throws TestFailedException {
        
        TestFunction.assertEqual(myList.contains("Tarini"), true);

    }

    @TestCase(name = "contains(): Element at the end")
    @Tip(description =  "Remember to use an iterator, and NOT a loop!")
    public static void containsLast() throws TestFailedException {
        
        TestFunction.assertEqual(myList.contains("Kritt"), true);

    }

    @TestCase(name = "contains(): Element that does not exist")
    @Tip(description =  "Remember to use an iterator, and NOT a loop!")
    public static void containsNone() throws TestFailedException {
        
        TestFunction.assertEqual(myList.contains("Armaan"), false);

    }

    @TestCase(name = "contains(): Element = null")
    @Tip(description =  "What should happen if the given element is null?")
    public static void containsNull() throws TestFailedException {
        
        TestFunction.testForException(IllegalArgumentException.class, () -> myList.contains(null));

    }

    @TestCase(name = "clear(): Clears the list (checks for elements)")
    @Tip(description =  "Make sure you remove ALL elements from this list!")
    public static void clearElements() throws TestFailedException {
        
        myList.clear();
        TestFunction.assertEqual(TestUtils.iterableToString(myList), "");

    }

    @TestCase(name = "clear(): Clears the list (checks for size)")
    @Tip(description =  "Make sure you update your size accordingly!")
    public static void clearElementsSize() throws TestFailedException {
        
        myList.clear();
        TestFunction.assertEqual(myList.size(), 0);

    }

    @TestCase(name = "isEmpty(): Checks a list that is not empty")
    @Tip(description =  "What criteria should you use to determine if your list is empty?")
    public static void isEmptyNotEmpty() throws TestFailedException {
        
        TestFunction.assertEqual(myList.isEmpty(), false);

    }

    @TestCase(name = "isEmpty(): Checks a list that is empty")
    @Tip(description =  "Make sure you update your size accordingly!")
    public static void isEmptyEmpty() throws TestFailedException {
        
        TestFunction.assertEqual(emptyList.isEmpty(), true);

    }

    @TestCase(name = "size(): Checks size of normal list")
    @Tip(description =  "Make sure you're updating your size throughout the whole program!")
    public static void sizeValidSize() throws TestFailedException {
        
        TestFunction.assertEqual(myList.size(), 7);

    }

    @TestCase(name = "size(): Checks size of empty list")
    @Tip(description =  "Make sure you're updating your size throughout the whole program!")
    public static void sizeEmpty() throws TestFailedException {
        
        TestFunction.assertEqual(emptyList.size(), 0);

    }

}
