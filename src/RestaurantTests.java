import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.utils.StringUtils;

public class RestaurantTests {

    @TestCase(name = "mergeSortRolls: Valid inputs.")
    @Tip(description = "Does RecursionUtils have helper methods that you can use?")
    public void mergeSortRollsValidInputs() throws TestFailedException {

        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Kangaroo", Color.GREEN),
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeSortRolls(rolls)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeSortRolls: Odd number of inputs.")
    @Tip(description = "Check your bounds when you split your array!")
    public void mergeSortRollsOddNumberInputs() throws TestFailedException {

        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Minneapolis", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Kangaroo", Color.GREEN),
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeSortRolls(rolls)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeSortRolls: One input")
    @Tip(description = "What should happen when only one SushiRoll is given?")
    public void mergeSortRollsOneInput() throws TestFailedException {

        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED)
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED)
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeSortRolls(rolls)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeSortRolls: No inputs")
    @Tip(description = "What should happen when NO SushiRolls are given?")
    public void mergeSortRollsZeroInput() throws TestFailedException {

        SushiRoll[] rolls = new SushiRoll[] {
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeSortRolls(rolls)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeOrders: Many inputs")
    @Tip(description = "Make sure you're properly sorting all of the SushiRolls!")
    public void mergeOrdersManyInputs() throws TestFailedException {

        SushiRoll[][] orders = new SushiRoll[][] {
            {new SushiRoll("Apple", Color.RED), new SushiRoll("Banana", Color.RED), new SushiRoll("Door", Color.BLUE)},
            {new SushiRoll("Cantaloupe", Color.BLUE), new SushiRoll("Elephant", Color.GREEN), new SushiRoll("Help", Color.GREEN)},
            {new SushiRoll("Green", Color.RED), new SushiRoll("Indiana", Color.RED), new SushiRoll("Minneapolis", Color.GREEN)},
            {new SushiRoll("Fan", Color.BLUE), new SushiRoll("Jimothy", Color.BLUE), new SushiRoll("Loser", Color.GREEN)},
            {new SushiRoll("Kangaroo", Color.GREEN)}
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN)
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeOrders(orders)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeOrders: Many inputs (test 2)")
    @Tip(description = "Make sure you're properly sorting all of the SushiRolls!")
    public void mergeOrdersManyInputs2() throws TestFailedException {

        SushiRoll[][] orders = new SushiRoll[][] {
            {new SushiRoll("Fan", Color.BLUE), new SushiRoll("Jimothy", Color.BLUE), new SushiRoll("Loser", Color.GREEN)},
            {new SushiRoll("Apple", Color.RED), new SushiRoll("Banana", Color.RED), new SushiRoll("Door", Color.BLUE)},
            {new SushiRoll("Green", Color.RED), new SushiRoll("Indiana", Color.RED), new SushiRoll("Minneapolis", Color.GREEN)},
            {new SushiRoll("Cantaloupe", Color.BLUE), new SushiRoll("Elephant", Color.GREEN), new SushiRoll("Help", Color.GREEN)},
            {new SushiRoll("Kangaroo", Color.GREEN)}
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN)
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeOrders(orders)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeOrders: Many inputs (test 3)")
    @Tip(description = "Make sure you're properly sorting all of the SushiRolls!")
    public void mergeOrdersManyInputs3() throws TestFailedException {

        SushiRoll[][] orders = new SushiRoll[][] {
            {new SushiRoll("Green", Color.RED), new SushiRoll("Indiana", Color.RED), new SushiRoll("Minneapolis", Color.GREEN)},
            {new SushiRoll("Apple", Color.RED), new SushiRoll("Banana", Color.RED), new SushiRoll("Door", Color.BLUE)},
            {new SushiRoll("Kangaroo", Color.GREEN)},
            {new SushiRoll("Cantaloupe", Color.BLUE), new SushiRoll("Elephant", Color.GREEN), new SushiRoll("Help", Color.GREEN)},
            {new SushiRoll("Fan", Color.BLUE), new SushiRoll("Jimothy", Color.BLUE), new SushiRoll("Loser", Color.GREEN)},
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN)
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeOrders(orders)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeOrders: No inputs")
    @Tip(description = "What should mergeOrders() return if there are no orders?")
    public void mergeOrdersNone() throws TestFailedException {

        SushiRoll[][] orders = new SushiRoll[][] {};

        SushiRoll[] sortedRolls = new SushiRoll[] {};

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeOrders(orders)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeOrders: Contains only empty orders")
    @Tip(description = "What should mergeOrders() return if there are no orders?")
    public void mergeOrdersEmpty() throws TestFailedException {

        SushiRoll[][] orders = new SushiRoll[][] {{},{},{}};

        SushiRoll[] sortedRolls = new SushiRoll[] {};

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeOrders(orders)).trim(), StringUtils.arrayToString(sortedRolls).trim());

    }

    @TestCase(name = "platesOfColor: Red")
    @Tip(description = "Make sure that the output array has ONLY the correct color!")
    public void platesOfColorRed() throws TestFailedException {

        
        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN),
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Indiana", Color.RED),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.RED)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "platesOfColor: Blue")
    @Tip(description = "Make sure that the output array has ONLY the correct color!")
    public void platesOfColorBlue() throws TestFailedException {

        
        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN),
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Jimothy", Color.BLUE),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.BLUE)), StringUtils.arrayToString(sortedRolls));

    }


    @TestCase(name = "platesOfColor: Green")
    @Tip(description = "Make sure that the output array has ONLY the correct color!")
    public void platesOfColorGreen() throws TestFailedException {

        
        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Jimothy", Color.BLUE),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN),
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.GREEN)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "platesOfColor: None have specified color")
    @Tip(description = "If no plates match the specified color, what should platesOfColor() return?")
    public void platesOfColorNone() throws TestFailedException {

        
        SushiRoll[] rolls = new SushiRoll[] {
            new SushiRoll("Apple", Color.RED),
            new SushiRoll("Banana", Color.RED),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Green", Color.RED),
            new SushiRoll("Indiana", Color.RED),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Jimothy", Color.BLUE),
        };

        SushiRoll[] sortedRolls = new SushiRoll[] {};

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.GREEN)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "platesOfColor: Empty list of SushiRoll")
    @Tip(description = "Although you may assume the given array is not null or contain null elements, you may not assume that it is not empty. Make sure to handle this case!")
    public void platesOfColorEmpty() throws TestFailedException {

        
        SushiRoll[] rolls = new SushiRoll[] {};

        SushiRoll[] sortedRolls = new SushiRoll[] {};

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.GREEN)), StringUtils.arrayToString(sortedRolls));

    }

    @TestCase(name = "mergeSortRolls: duplicates")
    @Tip(description = "The dupicate elements in the original array should be in the same order in the sorted array. This is called a stable attribute of a sort")
    public void mergeSortDuplicates() throws TestFailedException {
        //stability is not specified in the HW pdf but if you implement mergeSort right, it should be stable
        SushiRoll[] orders = new SushiRoll[] {
                new SushiRoll("Zebra", Color.RED),
                new SushiRoll("Cantaloupe", Color.BLUE),
                new SushiRoll("Cantaloupe", Color.RED),
                new SushiRoll("Banana", Color.BLUE),
                new SushiRoll("Cantaloupe", Color.GREEN),
                new SushiRoll("Fan", Color.BLUE),};

        SushiRoll[] sortedRolls = new SushiRoll[] {
                new SushiRoll("Banana", Color.BLUE),
                new SushiRoll("Cantaloupe", Color.BLUE),
                new SushiRoll("Cantaloupe", Color.RED),
                new SushiRoll("Cantaloupe", Color.GREEN),
                new SushiRoll("Fan", Color.BLUE),
                new SushiRoll("Zebra", Color.RED),};

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.mergeSortRolls(orders)), StringUtils.arrayToString(sortedRolls));

    }



    @TestCase(name = "totalPrice: Generic Test 1")
    @Tip(description = "Check Color.java for each color's price value!")
    public void totalPriceGeneric() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {
                new SushiRoll("Apple", Color.RED),
                new SushiRoll("Banana", Color.RED),
                new SushiRoll("Door", Color.BLUE),
                new SushiRoll("Cantaloupe", Color.BLUE),
                new SushiRoll("Elephant", Color.GREEN),
        };

        TestFunction.assertEqual(Restaurant.totalPrice(rolls), 15.0);

    }

    @TestCase(name = "totalPrice: One item (on RED plate)")
    @Tip(description = "Is your price for RED correct?")
    public void totalPriceRed() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {
                new SushiRoll("Red", Color.RED)
        };

        TestFunction.assertEqual(Restaurant.totalPrice(rolls), 2.5);

    }

    @TestCase(name = "totalPrice: One item (on GREEN plate)")
    @Tip(description = "Is your price for GREEN correct?")
    public void totalPriceGreen() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {
                new SushiRoll("Green", Color.GREEN)
        };

        TestFunction.assertEqual(Restaurant.totalPrice(rolls), 3.0);

    }

    @TestCase(name = "totalPrice: One item (on BLUE plate)")
    @Tip(description = "Is your price for BLUE correct?")
    public void totalPriceBlue() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {
                new SushiRoll("BLUE", Color.BLUE)
        };

        TestFunction.assertEqual(Restaurant.totalPrice(rolls), 3.5);

    }

    @TestCase(name = "totalPrice: Empty SushiRoll[]")
    @Tip(description = "How much do 0 SushiRolls cost?")
    public void totalPriceEmpty() throws TestFailedException {
        SushiRoll[] rolls = new SushiRoll[] {};
        TestFunction.assertEqual(Restaurant.totalPrice(rolls), 0.0);

    }

    @TestCase(name = "totalPrice: Test single element")
    @Tip(description = "How should your recursive function work when there is only one element?")
    public void totalPriceSingle() throws TestFailedException {
        SushiRoll[] rolls = new SushiRoll[] {new SushiRoll("Meh", Color.RED)};
        TestFunction.assertEqual(Restaurant.totalPrice(rolls), 2.5);
    }

    @TestCase(name = "flip: Even number of inputs (6)")
    @Tip(description = "Make sure that all six inputs are reversed!")
    public void flipGeneric() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {
                new SushiRoll("Avocado", Color.RED),
                new SushiRoll("Banana", Color.RED),
                new SushiRoll("Dragon", Color.BLUE),
                new SushiRoll("Maki", Color.BLUE),
                new SushiRoll("Tobiko", Color.GREEN),
                new SushiRoll("Unagi", Color.GREEN),
        };

        SushiRoll[] flipped = new SushiRoll[] {
                new SushiRoll("Unagi", Color.GREEN),
                new SushiRoll("Tobiko", Color.GREEN),
                new SushiRoll("Maki", Color.BLUE),
                new SushiRoll("Dragon", Color.BLUE),
                new SushiRoll("Banana", Color.RED),
                new SushiRoll("Avocado", Color.RED),
        };

        Restaurant.flip(rolls);

        TestFunction.assertEqual(StringUtils.arrayToString(rolls), StringUtils.arrayToString(flipped));
    }

    @TestCase(name = "flip: Odd number of inputs (7)")
    @Tip(description = "Make sure that all six inputs are reversed!")
    public void flipOdd() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {
                new SushiRoll("Avocado", Color.RED),
                new SushiRoll("Banana", Color.RED),
                new SushiRoll("Dragon", Color.BLUE),
                new SushiRoll("Hokigai", Color.BLUE),
                new SushiRoll("Maki", Color.BLUE),
                new SushiRoll("Tobiko", Color.GREEN),
                new SushiRoll("Unagi", Color.GREEN),
        };

        SushiRoll[] flipped = new SushiRoll[] {
                new SushiRoll("Unagi", Color.GREEN),
                new SushiRoll("Tobiko", Color.GREEN),
                new SushiRoll("Maki", Color.BLUE),
                new SushiRoll("Hokigai", Color.BLUE),
                new SushiRoll("Dragon", Color.BLUE),
                new SushiRoll("Banana", Color.RED),
                new SushiRoll("Avocado", Color.RED),
        };

        Restaurant.flip(rolls);

        TestFunction.assertEqual(StringUtils.arrayToString(rolls), StringUtils.arrayToString(flipped));
    }

    @TestCase(name = "flip: Empty List")
    @Tip(description = "What should flip() do when given an empty array?")
    public void flipEmpty() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {};

        SushiRoll[] flipped = new SushiRoll[] {};

        Restaurant.flip(rolls);

        TestFunction.assertEqual(StringUtils.arrayToString(rolls), StringUtils.arrayToString(flipped));

    }

    @TestCase(name = "flip: 1 Element List")
    @Tip(description = "Should be the same as the original")
    public void flipTwo() throws TestFailedException {


        SushiRoll[] rolls = new SushiRoll[] {new SushiRoll("Maki", Color.BLUE)
        };

        SushiRoll[] flipped = new SushiRoll[] {new SushiRoll("Maki", Color.BLUE),
        };

        Restaurant.flip(rolls);

        TestFunction.assertEqual(StringUtils.arrayToString(rolls), StringUtils.arrayToString(flipped));

    }
    

}
