import java.util.NoSuchElementException;

import com.cs1331.drivers.annotations.BeforeTest;
import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.utils.TestUtils;

public class LinkedListRemoveTests {

    private static LinkedList<String> myList;
    private static LinkedList<String> emptyList;

    @BeforeTest
    public static void setupLinkedList() {
        myList = new LinkedList<>(new String[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
        emptyList = new LinkedList<>();
    }

    @TestCase(name = "remove(): Removes element from start of array (Checks for removal)")
    @Tip(description = "Make sure you remove from the array and update your head!")
    public static void removeNoArgsRemoved() throws TestFailedException {

        myList.remove();

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "remove(): Removes element from start of array (Checks for size)")
    @Tip(description = "Make sure you update your size!")
    public static void removeNoArgsRemovedSize() throws TestFailedException {

        myList.remove();

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(): Removes element from start of array (Checks for return)")
    @Tip(description = "Make sure you return the element you removed!")
    public static void removeNoArgsRemovedReturned() throws TestFailedException {

        String removed = myList.remove();

        TestFunction.assertEqual(removed, "Lindsay");

    }

    @TestCase(name = "remove(): Remove from empty List")
    @Tip(description = "What should occur if you try to remove an element from an empty list?")
    public static void removeNoArgsEmpty() throws TestFailedException {

        TestFunction.testForException(NoSuchElementException.class, () -> emptyList.remove());

    }

    @TestCase(name = "remove(): Empty list (checking size)")
    @Tip(description = "Make sure that you do NOT update your size if you do not remove anything!")
    public static void removeNoArgsEmptySize() throws TestFailedException {

        try {
            emptyList.remove();
        } catch (Exception e) {
            // Do nothing
        };

        TestFunction.assertEqual(emptyList.size(), 0);

    }

    @TestCase(name = "remove(int index): Removes from index 0 (checking for removal)")
    @Tip(description = "Make sure you remove from the array and update your head!")
    public static void removeOneArg() throws TestFailedException {

        myList.remove(0);

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "remove(int index): Removes from index 0 (checking size)")
    @Tip(description = "Make sure you remove from the array and update your size!")
    public static void removeOneArgStartSize() throws TestFailedException {

        myList.remove(0);

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(int index): Removes from index 0 (checking return)")
    @Tip(description = "Make sure you return the element you removed!")
    public static void removeOneArgStartReturn() throws TestFailedException {

        String returned = myList.remove(0);

        TestFunction.assertEqual(returned, "Lindsay");

    }

    @TestCase(name = "remove(int index): Removes from middle (checking for removal)")
    @Tip(description = "Make sure you remove from the array and update your head!")
    public static void removeOneArgMiddle() throws TestFailedException {

        myList.remove(4);

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Ethan,Laura,Kritt");

    }

    @TestCase(name = "remove(int index): Removes from middle (checking size)")
    @Tip(description = "Make sure you remove from the array and update your size!")
    public static void removeOneArgMiddleSize() throws TestFailedException {

        myList.remove(4);

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(int index): Removes from middle (checking return)")
    @Tip(description = "Make sure you return the element you removed!")
    public static void removeOneArgMiddleReturn() throws TestFailedException {

        String returned = myList.remove(4);

        TestFunction.assertEqual(returned, "Katia");

    }

    @TestCase(name = "remove(int index): Removes from last index (checking for removal)")
    @Tip(description = "Make sure you remove from the array and update your head!")
    public static void removeOneArgLast() throws TestFailedException {

        myList.remove(6);

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Ethan,Katia,Laura");

    }

    @TestCase(name = "remove(int index): Removes from last index (checking size)")
    @Tip(description = "Make sure you remove from the array and update your size!")
    public static void removeOneArgLastSize() throws TestFailedException {

        myList.remove(6);

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(int index): Removes from last index (checking return)")
    @Tip(description = "Make sure you return the element you removed!")
    public static void removeOneArgLastReturn() throws TestFailedException {

        String returned = myList.remove(6);

        TestFunction.assertEqual(returned, "Kritt");

    }

    @TestCase(name = "remove(int index): Empty list")
    @Tip(description = "What should happen if you try to remove from an empty list?")
    public static void removeOneArgEmpty() throws TestFailedException {

        TestFunction.testForException(NoSuchElementException.class, () -> emptyList.remove(0));

    }

    @TestCase(name = "remove(int index): Empty list (checking size)")
    @Tip(description = "Make sure that you do NOT update your size if you do not remove anything!")
    public static void removeOneArgEmptySize() throws TestFailedException {

        try {
            emptyList.remove(0);
        } catch (Exception e) {
            // Do nothing
        };

        TestFunction.assertEqual(emptyList.size(), 0);

    }

    @TestCase(name = "remove(int index): Empty list AND index = -1")
    @Tip(description = "What should happen if you try to remove from an empty list AND the index is invalid?")
    public static void removeOneArgEmptyAndInvalid() throws TestFailedException {

        TestFunction.testForException(NoSuchElementException.class, () -> emptyList.remove(-1));

    }

    @TestCase(name = "remove(int index): Index = -1")
    @Tip(description = "Is this a valid index to remove from? What should happen if an invalid index is passed in?")
    public static void removeOneArgInvalid() throws TestFailedException {

        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.remove(-1));

    }

    @TestCase(name = "remove(int index): Index = -1 (checking size)")
    @Tip(description = "Make sure that you do NOT update your size if you do not remove anything!")
    public static void removeOneArgCheckSize() throws TestFailedException {

        try {
            myList.remove(-1);
        } catch (Exception e) {
            // Do nothing
        };

        TestFunction.assertEqual(myList.size(), 7);

    }

    @TestCase(name = "remove(int index): Index = size")
    @Tip(description = "Is this a valid index to remove from? What should happen if an invalid index is passed in?")
    public static void removeOneArgSize() throws TestFailedException {

        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.remove(7));

    }

    @TestCase(name = "remove(int index): Index = size (checking size)")
    @Tip(description = "Make sure that you do NOT update your size if you do not remove anything!")
    public static void removeOneArgCheckSizeSize() throws TestFailedException {

        try {
            myList.remove(7);
        } catch (Exception e) {
            // Do nothing
        };

        TestFunction.assertEqual(myList.size(), 7);

    }

    @TestCase(name = "remove(T element): Remove element at start (check for removal)")
    @Tip(description = "Make sure you remove the element and update the head!")
    public static void removeElementStart() throws TestFailedException {

        myList.remove("Lindsay");

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "remove(T element): Remove element at start (check for size)")
    @Tip(description = "Make sure you remove the element and update the size!")
    public static void removeElementStartSize() throws TestFailedException {

        myList.remove("Lindsay");

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(T element): Remove element at start (check for return)")
    @Tip(description = "Make sure you return the removed element!")
    public static void removeElementStartReturn() throws TestFailedException {

        String removed = myList.remove("Lindsay");

        TestFunction.assertEqual(removed, "Lindsay");

    }

    @TestCase(name = "remove(T element): Remove element in middle (check for removal)")
    @Tip(description = "Make sure you remove the element and update the head!")
    public static void removeElementMiddle() throws TestFailedException {

        myList.remove("Katia");

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Ethan,Laura,Kritt");

    }

    @TestCase(name = "remove(T element): Remove element in middle (check for size)")
    @Tip(description = "Make sure you remove the element and update the size!")
    public static void removeElementMiddleSize() throws TestFailedException {

        myList.remove("Katia");

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(T element): Remove element in middle (check for return)")
    @Tip(description = "Make sure you return the removed element!")
    public static void removeElementMiddleReturn() throws TestFailedException {

        String removed = myList.remove("Katia");

        TestFunction.assertEqual(removed, "Katia");

    }

    @TestCase(name = "remove(T element): Remove element at end (check for removal)")
    @Tip(description = "Make sure you remove the element and update the head!")
    public static void removeElementEnd() throws TestFailedException {

        myList.remove("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Ethan,Katia,Laura");

    }

    @TestCase(name = "remove(T element): Remove element at end (check for size)")
    @Tip(description = "Make sure you remove the element and update the size!")
    public static void removeElementEndSize() throws TestFailedException {

        myList.remove("Kritt");

        TestFunction.assertEqual(myList.size(), 6);

    }

    @TestCase(name = "remove(T element): Remove element at end (check for return)")
    @Tip(description = "Make sure you return the removed element!")
    public static void removeElementEndReturn() throws TestFailedException {

        String removed = myList.remove("Kritt");

        TestFunction.assertEqual(removed, "Kritt");

    }

    @TestCase(name = "remove(T element): Null element")
    @Tip(description = "What should happen if your method is given a null element?")
    public static void removeElementNull() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class, () -> myList.remove(null));

    }

    @TestCase(name = "remove(T element): Element not found")
    @Tip(description = "What should happen if your method is not found in the list?")
    public static void removeElementNotFound() throws TestFailedException {

        TestFunction.testForException(NoSuchElementException.class, () -> myList.remove("Janhavi"));

    }

    @TestCase(name = "remove(T element): Empty list")
    @Tip(description = "Can an element be found in an empty list? What should happen if the element is not found?")
    public static void removeElementFromEmpty() throws TestFailedException {

        TestFunction.testForException(NoSuchElementException.class, () -> emptyList.remove("Janhavi"));

    }
}
