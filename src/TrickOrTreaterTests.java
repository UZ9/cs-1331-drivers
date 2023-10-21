import java.util.List;

class TrickOrTreaterTests {

    private static final String COMPARE_TO_METHOD_TIP = "What criteria should compareTo use to determine greater/less than? What order should these be compared?\n"
                                                        + "    Note: This test only checks the SIGN of compareTo, since the intended number is not specified.\n"
                                                        + "    1 means that compareTo() returned a positive number, -1 means a negative number, 0 means 0.";

    @TestCase(name = "Constructor: Valid inputs passed in.")
    @Tip(tip = "Make sure that your constructor takes the correct number (and type) of inputs!")
    public void threeArgConstructor() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Yoon", 6, 70);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Yoon/6/70");
    }

    @TestCase(name = "Age must be in the inclusive interval [0, 12]. What should an invalid age default to?")
    @Tip(tip = "A negative age should default to 8!")
    public void threeArgConstructorNegativeAge() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Mark", -1, 40);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Mark/8/40");
    }

    @TestCase(name = "Constructor: age = 0")
    @Tip(tip = "Age must be in the inclusive interval [0, 12]")
    public void threeArgConstructorZeroAge() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Rush", 0, 27);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Rush/0/27");
    }

    @TestCase(name = "Constructor: age = 12")
    @Tip(tip = "Age must be in the inclusive interval [0, 12]")
    public void threeArgConstructorTwelveAge() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("John", 12, 34);
        String string = treater.toString();

        TestFunction.assertEqual(string, "John/12/34");
    }

    @TestCase(name = "Constructor: age = 13")
    @Tip(tip = "Age must be in the inclusive interval [0, 12]. What should an invalid age default to?")
    public void threeArgConstructorThirteenAge() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Ara", 13, 40);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Ara/8/40");
    }

    @TestCase(name = "Constructor: numCandy = -1")
    @Tip(tip = "TrickOrTreaters cannot have negative candy. What should a negative default to?")
    public void threeArgConstructorNegativeCandy() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Dipper", 12, -1);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Dipper/12/0");
    }

    @TestCase(name = "Constructor: numCandy = 0")
    @Tip(tip = "numCandy may be equal to 0.")
    public void threeArgConstructorZeroCandy() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Mabel", 12, 0);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Mabel/12/0");
    }

    @TestCase(name = "gainCandy: add -1 candy")
    @Tip(tip = "gainCandy cannot subtract candy from TrickOrTreaters!")
    public void gainCandyNegative() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Lindsay", 6, 70);
        treater.gainCandy(-1);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Lindsay/6/70");
    }

    @TestCase(name = "gainCandy: add 0 candy")
    @Tip(tip = "Should the number of candy change?")
    public void gainCandyZero() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Elise", 6, 70);
        treater.gainCandy(0);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Elise/6/70");
    }

    @TestCase(name = "gainCandy: add 1 candy")
    @Tip(tip = "How much candy should this TrickOrTreater gain?")
    public void gainCandyOne() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Tarini", 9, 70);
        treater.gainCandy(1);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Tarini/9/71");
    }

    @TestCase(name = "gainCandy: add 117 candy")
    @Tip(tip = "How much candy should this TrickOrTreater gain?")
    public void gainCandyOneEighteen() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("NASA", 0, 1);
        treater.gainCandy(117);
        String string = treater.toString();

        TestFunction.assertEqual(string, "NASA/0/118");
    }

    @TestCase(name = "loseCandy: lose -1 candy")
    @Tip(tip = "Can a TrickOrTreater lose negative candy?")
    public void loseCandyNegative() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Krit", 6, 70);
        treater.loseCandy(-1);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Krit/6/70");
    }

    @TestCase(name = "loseCandy: lose 0 candy")
    @Tip(tip = "How much candy should this TrickOrTreater lose?")
    public void loseCandyZero() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Ansel", 6, 70);
        treater.loseCandy(0);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Ansel/6/70");
    }

    @TestCase(name = "loseCandy: lose 1 candy")
    @Tip(tip = "How much candy should this TrickOrTreater lose?")
    public void loseCandyOne() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Spartan", 9, 72);
        treater.loseCandy(1);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Spartan/9/71");
    }

    @TestCase(name = "loseCandy: lose all candy")
    @Tip(tip = "How much candy does this TrickOrTreater have to lose? Can a TrickOrTreater have zero candy?")
    public void loseCandyMaximumLoss() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Jim", 1, 10);
        treater.loseCandy(10);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Jim/1/0");
    }

    @TestCase(name = "loseCandy: lose more candy than available")
    @Tip(tip = "How much candy does this TrickOrTreater have to lose? Can a TrickOrTreater have negative candy?")
    public void loseCandyTooMany() throws TestFailedException {

        TrickOrTreater treater = new TrickOrTreaterSubclass("Bob", 1, 10);
        treater.loseCandy(11);
        String string = treater.toString();

        TestFunction.assertEqual(string, "Bob/1/0");
    }

    @TestCase(name = "compareTo: other has greater candy, smaller age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterSmaller() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 2, 9);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 1, 10);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has greater candy, equal age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterEqual() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 1, 9);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 1, 10);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has greater candy, greater age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterGreater() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 1, 9);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 2, 10);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has equal candy, smaller age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToEqualSmaller() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 2, 10);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 1, 10);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqual() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 1, 10);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 1, 10);
        int result = TestUtils.signOf(treater1.compareTo(treater2));

        TestFunction.assertEqual(result, 0);
    }

    @TestCase(name = "compareTo: other has equal candy, greater age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToEqualGreater() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 1, 10);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 2, 10);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has fewer candy, smaller age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerSmaller() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 2, 10);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 1, 9);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has fewer candy, equal age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerEqual() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 1, 10);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 1, 9);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has fewer candy, greater age")
    @Tip(tip = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerGreater() throws TestFailedException {

        TrickOrTreater treater1 = new TrickOrTreaterSubclass("Coke", 1, 10);
        TrickOrTreater treater2 = new TrickOrTreaterSubclass("Pepsi", 2, 9);
        int result = Math.abs(treater1.compareTo(treater2))/treater1.compareTo(treater2);

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: transitivity check...")
    @Tip(tip = "Read the Java 11 compareTo() documentation for info on transitivity.\n"
               + "\t      If x.compareTo(y) > 0 and y.compareTo(z) > 0, then x.compareTo(z) MUST be > 0.\n"
               + "\t      This method checks MANY combinations of ages and numCandys for transitivity.\n")
    public void compareToTransitivity() throws TestFailedException {

        boolean testFailed = false;
        String trickOrTreaterX = "", trickOrTreaterY = "", trickOrTreaterZ = "";
        
        TrickOrTreaterSubclass[] possibleX = getAllTrickOrTreatersOnInterval("Xander", 0, 12, 0, 50);
        TrickOrTreaterSubclass[] possibleY = getAllTrickOrTreatersOnInterval("Yang", 0, 12, 0, 50);
        TrickOrTreaterSubclass[] possibleZ = getAllTrickOrTreatersOnInterval("Zan", 0, 12, 0, 50);

        for (int i = 0; i < possibleX.length; i++) {
            for (int j = 0; j < possibleY.length; j++) {
                for (int k = 0; k < possibleZ.length; k++) {
                    if (testFailed == false) {
                        TrickOrTreaterSubclass x = possibleX[i];
                        TrickOrTreaterSubclass y = possibleY[j];
                        TrickOrTreaterSubclass z = possibleZ[k];
                        if (x.compareTo(y) > 0 && y.compareTo(z) > 0 && x.compareTo(z) <= 0) { // This comes directly from the compareTo docs
                            testFailed = true;
                            trickOrTreaterX = x.toString();
                            trickOrTreaterY = y.toString();
                            trickOrTreaterZ = z.toString();
                        }
                    }
                }
            }
        }

        if (testFailed) {
            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                               AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " TRANSITIVITY TEST FAILED: \u00BB ") + "\nWhen "
                               + "x = \"" + trickOrTreaterX + "\", y = \"" + trickOrTreaterY + "\", z = \"" + trickOrTreaterZ + "\"");
        }

        TestFunction.assertEqual(testFailed, false);
    }

    /**
     * Placeholder subclass to force-call TrickOrTreater's methods
     */
    private class TrickOrTreaterSubclass extends TrickOrTreater {

        public TrickOrTreaterSubclass(String name, int age, int numCandy) {
            super(name, age, numCandy);
        }

        @Override
        public void trickOrTreat() {
        }

    }

    /**
     * Helper method to retrieve all possible TrickOrTreaters on the given intervals (inclusive).
     * @param name The name of all of the TrickOrTreaters
     * @param minAge Min age, inclusive.
     * @param maxAge Max age, inclusive.
     * @param minCandy Min candy, inclusive.
     * @param maxCandy Max candy, inclusive.
     * @return An array containing all possible trick or treaters on the interval.
     */
    private TrickOrTreaterSubclass[] getAllTrickOrTreatersOnInterval(String name, int minAge, int maxAge, int minCandy, int maxCandy) {
        TrickOrTreaterSubclass[] combos = new TrickOrTreaterSubclass[(maxAge + 1 - minAge) * (maxCandy + 1 - minCandy)];
        int index = 0;
        for (int i = minAge; i <= maxAge; i++) {
            for (int j = minCandy; j <= maxCandy; j++) {
                combos[index] = new TrickOrTreaterSubclass(name, i, j);
                index++;
            }
        }
        return combos;
    }
}
