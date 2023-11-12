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
            new SushiRoll("Cantaloupe", Color.BLUE),
            new SushiRoll("Door", Color.BLUE),
            new SushiRoll("Fan", Color.BLUE),
            new SushiRoll("Jimothy", Color.BLUE),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.RED)), StringUtils.arrayToString(sortedRolls));

    }


    @TestCase(name = "platesOfColor: Green")
    @Tip(description = "Make sure that the output array has ONLY the correct color!")
    public void platesOfColorGreen() throws TestFailedException {

        
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
            new SushiRoll("Elephant", Color.GREEN),
            new SushiRoll("Help", Color.GREEN),
            new SushiRoll("Kangaroo", Color.GREEN),
            new SushiRoll("Loser", Color.GREEN),
            new SushiRoll("Minneapolis", Color.GREEN),
        };

        TestFunction.assertEqual(StringUtils.arrayToString(Restaurant.platesOfColor(rolls, Color.GREEN)), StringUtils.arrayToString(sortedRolls));

    }



}
