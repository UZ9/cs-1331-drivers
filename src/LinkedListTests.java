import java.util.Iterator;

import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.utils.StringUtils;
import com.cs1331.drivers.utils.TestUtils;

/**
 * Tests for LinkedLists.
 * @author Justin Hwang
 * @version 1.0.0
 */
public class LinkedListTests {
    
    @TestCase(name = "Constructor: No-args constructor")
    @Tip(description = "Make sure you have properly implemented isEmpty() on a new LinkedList!")
    public static void constructorNoArgs() throws TestFailedException {
        
        LinkedList<String> list = new LinkedList<>();

        TestFunction.assertEqual(list.isEmpty(), true);

    }

    @TestCase(name = "Constructor: Iterator returns no elements")
    @Tip(description = "Make sure that your iterator() method returns a new iterator() of the correct type, and that it returns no elements")
    public static void constructorNoArgs2() throws TestFailedException {
        
        LinkedList<String> list = new LinkedList<>();

        TestFunction.assertEqual(TestUtils.iterableToString(list), "");

    }

    @TestCase(name = "Constructor: Given array of String")
    @Tip(description = "This test uses your iterator to convert the LinkedList to String. Even if your constructor is functional, this test may fail because of your iterator implementation!")
    public static void constructorArray() throws TestFailedException {
        
        LinkedList<String> list = new LinkedList<>(new String[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");

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

    @TestCase(name = "toArray: Valid array of String")
    @Tip(description = "Make sure you're using the iterator's next() and hasNext() methods!")
    public static void toArrayValid() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});

        TestFunction.assertEqual(StringUtils.arrayToString(list.toArray()), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt,");

    }

    @TestCase(name = "toArray: Valid array of Object")
    @Tip(description = "Make sure you're using the iterator's next() and hasNext() methods!")
    public static void toArrayValidObject() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});

        TestFunction.assertEqual(StringUtils.arrayToString(list.toArray()), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt,");

    }

    @TestCase(name = "toArray: Empty array of String")
    @Tip(description = "Make sure you return an empty array, and not null!\nSee: https://edstem.org/us/courses/42939/discussion/3877975?comment=9010610")
    public static void toArrayEmpty() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>();

        TestFunction.assertEqual(StringUtils.arrayToString(list.toArray()), "");

    }

    @TestCase(name = "add: Add elements to an empty list")
    @Tip(description = "Make sure that your add() method works when you start with an empty List!, and that size() is properly updated!")
    public static void addToEmpty() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>();
        list.add("Lindsay");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay");
        TestFunction.assertEqual(list.size(), 1);

    }

    @TestCase(name = "add: Add element to the end of an existing list")
    @Tip(description = "Make sure that you can add to the end, and that size() is properly updated!")
    public static void addToEnd() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura"});
        list.add("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add: Add two elements to the end of an existing list")
    @Tip(description = "Make sure that you can add to the end, and that size() is properly updated!")
    public static void addTwoToEnd() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia"});
        list.add("Laura");
        list.add("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add: Add element to the beginning of an existing list")
    @Tip(description = "Make sure that you can add to the beginning, and that both head and size are properly updated! If you do not update the head, then the iterator will not start at the new first element!")
    public static void addToStart() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        list.add(0, "Lindsay");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add: Add two elements to the beginning of an existing list")
    @Tip(description = "Make sure that you can add to the beginning, and that both head and size are properly updated! If you do not update the head, then the iterator will not start at the new first element!")
    public static void addTwoToStart() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        list.add(0, "Elise");
        list.add(0, "Lindsay"); // This gets inserted before Elise in the list

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add: Add element to the middle of an existing list")
    @Tip(description = "Make sure that you can add to the middle, and that the size is properly updated!")
    public static void addToMiddle() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Katia", "Laura", "Kritt"});
        list.add(3, "Ethan");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add: Add two elements to the middle of an existing list")
    @Tip(description = "Make sure that you can add to the middle, and that the size is properly updated!")
    public static void addTwoToMiddle() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Laura", "Kritt"});
        list.add(3, "Katia");
        list.add(3, "Ethan");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

}
