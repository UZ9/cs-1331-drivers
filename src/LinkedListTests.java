import java.util.NoSuchElementException;

import com.cs1331.drivers.annotations.BeforeTest;
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

    @TestCase(name = "add(): Add elements to an empty list")
    @Tip(description = "Make sure that your add() method works when you start with an empty List!, and that size() is properly updated!")
    public static void addToEmpty() throws TestFailedException {

        emptyList.add("Lindsay");

        TestFunction.assertEqual(TestUtils.iterableToString(emptyList), "Lindsay");
        TestFunction.assertEqual(emptyList.size(), 1);

    }

    @TestCase(name = "add(): Add element to the end of an existing list")
    @Tip(description = "Make sure that you can add to the end, and that size() is properly updated!")
    public static void addToEnd() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura"});
        list.add("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(): Add two elements to the end of an existing list")
    @Tip(description = "Make sure that you can add to the end, and that size() is properly updated!")
    public static void addTwoToEnd() throws TestFailedException {

        LinkedList<Object> list = new LinkedList<>(new Object[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia"});
        list.add("Laura");
        list.add("Kritt");

        TestFunction.assertEqual(TestUtils.iterableToString(list), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Kritt");
        TestFunction.assertEqual(list.size(), 7);

    }

    @TestCase(name = "add(): Giving null to one-arg add()")
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
    @Tip(description = "Can you add an element at this index?")
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

    @TestCase(name = "set(): Replace the first element")
    @Tip(description = "Make sure you update the head!")
    public static void setFirstElement() throws TestFailedException {
        
        myList.set(0, "Janhavi");

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Janhavi,Elise,Tarini,Ethan,Katia,Laura,Kritt");

    }

    @TestCase(name = "set(): Replace the first element (check for size)")
    @Tip(description = "Make sure you update the size!")
    public static void setFirstElementSize() throws TestFailedException {
        
        myList.set(0, "Janhavi");

        TestFunction.assertEqual(myList.size(), 7);

    }

    @TestCase(name = "set(): Replace the first element (check for return)")
    @Tip(description = "Make sure you return the replaced data!")
    public static void setFirstElementReturn() throws TestFailedException {
        
        String replaced = myList.set(0, "Janhavi");

        TestFunction.assertEqual(replaced, "Lindsay");

    }

    @TestCase(name = "set(): Replace a middle element")
    @Tip(description = "Make sure you update the head!")
    public static void setMiddleElement() throws TestFailedException {
        
        myList.set(3, "Edwar");

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Edwar,Katia,Laura,Kritt");

    }

    @TestCase(name = "set(): Replace a middle element (check for size)")
    @Tip(description = "Make sure you update the size!")
    public static void setMiddleElementSize() throws TestFailedException {
        
        myList.set(3, "Edwar");

        TestFunction.assertEqual(myList.size(), 7);

    }

    @TestCase(name = "set(): Replace a middle element (check for return)")
    @Tip(description = "Make sure you return the replaced data!")
    public static void setMiddleElementReturn() throws TestFailedException {
        
        String replaced = myList.set(3, "Edwar");

        TestFunction.assertEqual(replaced, "Ethan");

    }

    @TestCase(name = "set(): Replace the last element")
    @Tip(description = "Make sure you update the head!")
    public static void setLastElement() throws TestFailedException {
        
        myList.set(6, "Rachel");

        TestFunction.assertEqual(TestUtils.iterableToString(myList), "Lindsay,Elise,Tarini,Ethan,Katia,Laura,Rachel");

    }

    @TestCase(name = "set(): Replace the last element (check for size)")
    @Tip(description = "Make sure you update the size!")
    public static void setLastElementSize() throws TestFailedException {
        
        myList.set(6, "Rachel");

        TestFunction.assertEqual(myList.size(), 7);

    }

    @TestCase(name = "set(): Replace the last element (check for return)")
    @Tip(description = "Make sure you return the replaced data!")
    public static void setLastElementReturn() throws TestFailedException {
        
        String replaced = myList.set(6, "Rachel");

        TestFunction.assertEqual(replaced, "Kritt");

    }

    @TestCase(name = "set(): Index = -1")
    @Tip(description =  "Is this a valid index? What should happen when this index is passed in?")
    public static void setNegative() throws TestFailedException {
        
        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.set(-1, "Vi"));

    }

    @TestCase(name = "set(): Index = size")
    @Tip(description =  "Is this a valid index? What should happen when this index is passed in?")
    public static void setAtSize() throws TestFailedException {
        
        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.set(7, "Aditi"));

    }

    @TestCase(name = "set(): Element is null")
    @Tip(description =  "What should happen when the element is null?")
    public static void setElementNull() throws TestFailedException {
        
        TestFunction.testForException(IllegalArgumentException.class, () -> myList.set(6, null));

    }

    @TestCase(name = "set(): Element is null AND index is invalid")
    @Tip(description =  "What exception should be thrown when both issues occur?")
    public static void setElementNullAndInvalid() throws TestFailedException {
        
        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.set(-1, null));

    }

    @TestCase(name = "get(): Element at 0th index")
    @Tip(description =  "Make sure you're retrieving the correct element!")
    public static void getElementZero() throws TestFailedException {
        
        TestFunction.assertEqual(myList.get(0), "Lindsay");

    }

    @TestCase(name = "get(): Element at a middle index")
    @Tip(description =  "Make sure you're retrieving the correct element!")
    public static void getElementMiddle() throws TestFailedException {
        
        TestFunction.assertEqual(myList.get(3), "Ethan");

    }

    @TestCase(name = "get(): Element at last index")
    @Tip(description =  "Make sure you're retrieving the correct element!")
    public static void getElementLast() throws TestFailedException {
        
        TestFunction.assertEqual(myList.get(6), "Kritt");

    }

    @TestCase(name = "get(): Index = -1")
    @Tip(description =  "Is this a valid index? What should happen when this index is passed in?")
    public static void getElementNegative() throws TestFailedException {
        
        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.get(-1));

    }

    @TestCase(name = "get(): Index = size")
    @Tip(description =  "Is this a valid index? What should happen when this index is passed in?")
    public static void getElementSize() throws TestFailedException {
        
        TestFunction.testForException(IndexOutOfBoundsException.class, () -> myList.get(7));

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
