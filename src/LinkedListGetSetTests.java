import com.cs1331.drivers.annotations.BeforeTest;
import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.utils.TestUtils;

public class LinkedListGetSetTests {

    private static LinkedList<String> myList;

    @BeforeTest
    public static void setupLinkedList() {
        myList = new LinkedList<>(new String[] {"Lindsay", "Elise", "Tarini", "Ethan", "Katia", "Laura", "Kritt"});
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
}
