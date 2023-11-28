import java.util.Iterator;
import java.util.NoSuchElementException;

import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;

public class LinkedListIteratorTests {

    @TestCase(name = "Constructor: Valid array of String")
    @Tip(description = "Make sure you have a constructor! If your add method is incorrect, this test will likely fail.")
    public static void constructorValidInput() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Ansel", "Ethan"});

        Iterator<String> iterator = new LinkedListIterator<>(list);

        TestFunction.assertEqual(iterator.hasNext(), true);

    }

    @TestCase(name = "hasNext: calling hasNext() several times")
    @Tip(description = "Do not move the Iterator forwards with just a hasNext() call!")
    public static void hasNextValid() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Ansel", "Ethan"});

        Iterator<String> iterator = new LinkedListIterator<>(list);
        iterator.hasNext();
        iterator.hasNext();
        iterator.hasNext();

        TestFunction.assertEqual(iterator.hasNext(), true);

    }

    @TestCase(name = "hasNext: Empty List passed in")
    @Tip(description = "hasNext() should return false, since there are no elements in the list")
    public static void hasNextFalse() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {});

        Iterator<String> iterator = new LinkedListIterator<>(list);

        TestFunction.assertEqual(iterator.hasNext(), false);

    }

    @TestCase(name = "next: Valid inputs passed in")
    @Tip(description = "next() should return the first element in the list the first time it's called!")
    public static void nextValidInput() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Ansel", "Ethan"});

        Iterator<String> iterator = new LinkedListIterator<>(list);

        TestFunction.assertEqual(iterator.next(), "Ansel");

    }

    @TestCase(name = "next: Iterator gets advanced forwards")
    @Tip(description = "next() should move the Iterator forwards to the next Node")
    public static void nextAdvances() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Ansel", "Ethan"});

        Iterator<String> iterator = new LinkedListIterator<>(list);
        iterator.next();

        TestFunction.assertEqual(iterator.next(), "Ethan");

    }

    @TestCase(name = "next: Throws NoSuchElementException")
    @Tip(description = "What should happen if there are no more elements to return?")
    public static void nextThrowsException() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Ansel", "Ethan"});

        Iterator<String> iterator = new LinkedListIterator<>(list);
        iterator.next();
        iterator.next();

        TestFunction.testForException(NoSuchElementException.class, () -> iterator.next());

    }

    @TestCase(name = "Iterates through all elements in the list")
    @Tip(description = "Read the box on the bottom right of page 3 of the directions!")
    public static void iteratesThroughAll() throws TestFailedException {

        LinkedList<String> list = new LinkedList<>(new String[] {"Ansel", "Ethan", "Lindsay", "Elise", "Kritt", "Tarini", "Roopa", "Katia", "Laura", "Aarushi", "Clarence", "Skyla"});

        Iterator<String> iterator = new LinkedListIterator<>(list);
        
        StringBuilder builder = new StringBuilder();
        builder.append(iterator.next());
        
        while (iterator.hasNext()) {
            builder.append(",").append(iterator.next());
        }

        TestFunction.assertEqual(builder.toString(), "Ansel,Ethan,Lindsay,Elise,Kritt,Tarini,Roopa,Katia,Laura,Aarushi,Clarence,Skyla");

    }
    
}
