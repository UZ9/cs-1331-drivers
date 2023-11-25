import com.cs1331.drivers.annotations.BeforeTest;
import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.utils.TestUtils;

public class LinkedListAddTests {

    private static LinkedList<String> myList;
    private static LinkedList<String> emptyList;

    @BeforeTest
    public static void setupLinkedList() {
        myList = new LinkedList<>(new String[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        emptyList = new LinkedList<>();
    }

    @TestCase(name = "add(T element): Add elements to an empty list")
    @Tip(description = "Make sure that your add() method works when you start with an empty List, and that size() is properly updated!")
    public static void addToEmpty() throws TestFailedException {

        emptyList.add("Lindsay");

        TestFunction.assertEqual(TestUtils.iterableToString(emptyList), "Lindsay");
        TestFunction.assertEqual(emptyList.size(), 1);

    }

    @TestCase(name = "add(T element): Add element to the end of an existing list")
    @Tip(description = "Make sure that you can add to the end, and that size() is properly updated!")
    public static void addToEnd() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura"});
        list.add("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(T element): Add two elements to the end of an existing list")
    @Tip(description = "Make sure that you can add to the end, and that size() is properly updated!")
    public static void addTwoToEnd() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia"});
        list.add("Laura");
        list.add("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(T element): Giving null to one-arg add(T)")
    @Tip(description = "What should happen if you try to add a null element?")
    public static void addOneNull() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class, () -> myList.add(null));

    }

    @TestCase(name = "add(int index): Add element to the beginning of an existing list")
    @Tip(description = "Make sure that you can add to the beginning, and that both head and size are properly updated! If you do not update the head, then the iterator will not start at the new first element!")
    public static void addToStart() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        list.add(0, "Lindsay");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(int index): Add two elements to the beginning of an existing list")
    @Tip(description = "Make sure that you can add to the beginning, and that both head and size are properly updated! If you do not update the head, then the iterator will not start at the new first element!")
    public static void addTwoToStart() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        list.add(0, "Elise");
        list.add(0, "Lindsay"); // This gets inserted before Elise in the list

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(int index): Add element to the middle of an existing list")
    @Tip(description = "Make sure that you can add to the middle, and that the size is properly updated!")
    public static void addToMiddle() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Katia", "Laura", "Kritt"});
        list.add(3, "Ethan");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(int index): Add two elements to the middle of an existing list")
    @Tip(description = "Make sure that you can add to the middle, and that the size is properly updated!")
    public static void addTwoToMiddle() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Laura", "Kritt"});
        list.add(3, "Katia");
        list.add(3, "Ethan");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(int index): Giving null to two-arg add()")
    @Tip(description = "What should happen if you try to add a null element?")
    public static void addTwoNull() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class, () -> myList.add(3, null));

    }

    @TestCase(name = "add(int index): Give index -1")
    @Tip(description = "Can you add an element at this index?")
    public static void addToIndexNegOne() throws TestFailedException {

        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.add(-1, "Hyeyoon"));

    }

    @TestCase(name = "add(int index): Give index 0")
    @Tip(description = "Can you add an element at this index?")
    public static void addToIndexZero() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        list.add(0, "Janhavi");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Janhavi,Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "add(int index): Give index \"size\"")
    @Tip(description = "Can you add an element at this index? Check the javadocs under the add method!")
    public static void addToIndexSize() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        list.add(7, "Janhavi");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt,Janhavi");

    }

    @TestCase(name = "add(int index): Give index size+1")
    @Tip(description = "Can you add an element at this index?")
    public static void addToIndexSizePlusOne() throws TestFailedException {

        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.add(8, "Janhavi"));

    }

    @TestCase(name = "add(int index): Give index -1, and give a null element")
    @Tip(description = "Which exception should be thrown if the index is invalid AND the element is null?")
    public static void addInvalidIndexAndNull() throws TestFailedException {

        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.add(-1, null));

    }
}
