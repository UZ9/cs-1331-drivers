import com.cs1331.drivers.annotations.*;
import com.cs1331.drivers.exception.*;
import com.cs1331.drivers.testing.TestFunction;

/**
 * Class to test the Node file
 */
public class NodeTests {

    @TestCase(name = "Constructor: Null 'next' passed into two-arg constructor")
    @Tip(description = "Remember that null IS a valid input for the 'next' input. A Node may point to nothing!")
    public static void constructorNullNext() throws TestFailedException {

        Node<String> node = new Node<>("My Data", null);

        TestFunction.assertEqual(nodeToString(node), "My Data, null");

    }

    @TestCase(name = "Constructor: Valid data and next")
    @Tip(description = "Make sure that you have a constructor, as well as getters/setters for each variable!")
    public static void constructorValidInputs() throws TestFailedException {

        Node<String> next = new Node<>("Next Data");
        Node<String> node = new Node<>("My Data", next);

        TestFunction.assertEqual(nodeToString(node), "My Data, Next Data");

    }

    @TestCase(name = "Constructor: One-arg constructor")
    @Tip(description = "Make sure that you have a one-arg constructor. What should 'next' default to?")
    public static void constructorOneArg() throws TestFailedException {

        Node<String> node = new Node<>("My Data");

        TestFunction.assertEqual(nodeToString(node), "My Data, null");

    }

    @TestCase(name = "Constructor: Null data given to 2-arg constructor")
    @Tip(description = "What should happen if 'data' gets set to null?")
    public static void constructorNullData() throws TestFailedException {

        Node<String> next = new Node<>("NextData");

        TestFunction.testForException(IllegalArgumentException.class, () -> new Node<>(null, next));

    }

    @TestCase(name = "Constructor: Null data given to 1-arg constructor")
    @Tip(description = "What should happen if 'data' gets set to null?")
    public static void constructorOneNullData() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class, () -> new Node<>(null));

    }

    @TestCase(name = "getData: Returns the data")
    @Tip(description = "Make sure that your getter returns a reference to the SPECIFIC instance of the Object passed into the constructor, not a copy of it.")
    public static void getDataValid() throws TestFailedException {

        // This weird node-nesting is to test the == operator, not just a .equals(). This ensures
        // that the specific Object returned is the SPECIFIC object passed in, not just an identical one.
        Node<Integer> thisNode = new Node<>(6);
        Node<Integer> nextNode = new Node<>(70);
        Node<Node<?>> next = new Node<>(nextNode);
        Node<Node<?>> node = new Node<>(thisNode, next);

        TestFunction.assertEqual(node.getData() == thisNode, true);

    }

    @TestCase(name = "setData: Sets data to a valid value")
    @Tip(description = "Make sure that your setter properly sets `data` to the new data!")
    public static void setDataValid() throws TestFailedException {

        Integer thisInteger = 9;
        Integer nextInteger = 71;
        Node<Integer> next = new Node<>(nextInteger);
        Node<Integer> node = new Node<>(thisInteger, next);
        node.setData(73);

        TestFunction.assertEqual(node.getData(), 73);

    }

    @TestCase(name = "setData: Sets data to null")
    @Tip(description = "What should happen if null data gets passed into the setter?")
    public static void setDataNull() throws TestFailedException {

        Integer thisInteger = 9;
        Integer nextInteger = 71;
        Node<Integer> next = new Node<>(nextInteger);
        Node<Integer> node = new Node<>(thisInteger, next);
        TestFunction.testForException(IllegalArgumentException.class, () -> node.setData(null));

    }

    @TestCase(name = "getNext: Returns the correct Node")
    @Tip(description = "Make sure that your getter returns a reference to the SPECIFIC instance of Node passed into the constructor")
    public static void getNextValid() throws TestFailedException {

        // This weird node-nesting is to test the == operator, not just a .equals(). This ensures
        // that the specific Object returned is the SPECIFIC object passed in, not just an identical one.
        Node<Integer> thisNode = new Node<>(6);
        Node<Integer> nextNode = new Node<>(70);
        Node<Node<?>> next = new Node<>(nextNode);
        Node<Node<?>> node = new Node<>(thisNode, next);

        TestFunction.assertEqual(node.getNext() == next, true);

    }

    @TestCase(name = "setNext: Sets next to a valid value")
    @Tip(description = "Make sure that your setter properly sets `data` to the new data!")
    public static void setNextValid() throws TestFailedException {

        Integer thisInteger = 9;
        Integer nextInteger = 71;
        Node<Integer> next = new Node<>(nextInteger);
        Node<Integer> newNext = new Node<>(73);
        Node<Integer> node = new Node<>(thisInteger, next);
        node.setNext(newNext);

        TestFunction.assertEqual(node.getNext().getData(), 73);

    }

    @TestCase(name = "setNext: Sets next to null")
    @Tip(description = "Remember, null IS a valid 'next'!")
    public static void setNextNull() throws TestFailedException {

        Integer thisInteger = 9;
        Integer nextInteger = 71;
        Node<Integer> next = new Node<>(nextInteger);
        Node<Integer> node = new Node<>(thisInteger, next);
        node.setNext(null);

        TestFunction.assertEqual(node.getNext() == null, true);

    }

    

    /**
     * Returns a String in the following format:
     * {data}, {nextNode}
     * without curly braces. Data and nextData are replaced with the String representations of the objects contained
     * in the current and next nodes, as defined by the Object's toString() method.
     * @param node The Node to convert to String.
     * @return A String, formatted as specified above.
     */
    public static String nodeToString(Node<?> node) {
        return String.format("%s, %s", node.getData().toString(), node.getNext() == null ? "null" : node.getNext().getData().toString());
    }

}
