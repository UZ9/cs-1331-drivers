import java.util.ArrayList;
import java.util.List;

class GhostTests {
    private static final String COMPARE_TO_METHOD_TIP = "What criteria should compareTo use to determine greater/less than? What order should these be compared?\n"
                                                        + "    Note: This test only checks the SIGN of compareTo, since the intended number is not specified.\n"
                                                        + "    1 means that compareTo() returned a positive number, -1 means a negative number, 0 means 0.";

    @TestCase(name = "Constructor: Valid inputs passed in.")
    @Tip(description = "\nMake sure there isn't any field shadowing in your constructor!\nWhat should numberOfRobberies default to?")
    public void constructorThreeArgs() throws TestFailedException {

        Ghost ghost = new Ghost("Yoon", 6, 7);
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Yoon/6/7/0");
    }

    @TestCase(name = "Constructor: No args")
    @Tip(description = "What should each of Ghost's fields default to?")
    public void constructorNoArgs() throws TestFailedException {

        Ghost ghost = new Ghost();
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Casper the Unfriendly Ghost/12/0/0");
    }

    @TestCase(name = "trickOrTreat() method: Printed message (when run once).")
    @Tip(description = "One thing should be printed each time trickOrTreat() gets called. What is it?")
    public void trickOrTreatPrintWhenRunOnce() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Katia", 9, 7);
        ghost.trickOrTreat();

        String output = hijacker.stopRecording();
        
        TestFunction.assertEqual(output, "Boo! Trick or treat!\n");
    }

    @TestCase(name = "trickOrTreat() method: Printed message (when run twice).")
    @Tip(description = "One thing should be printed each time trickOrTreat() gets called. What is it?")
    public void trickOrTreatPrintWhenRunTwice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Katia", 9, 7);
        ghost.trickOrTreat();
        ghost.trickOrTreat();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!\n");
    }

    @TestCase(name = "trickOrTreat() method: Printed message (when run three times).")
    @Tip(description = "One thing should be printed each time trickOrTreat() gets called. What is it?")
    public void trickOrTreatPrintWhenRunThrice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Katia", 9, 7);
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        ghost.trickOrTreat();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n");
    }

    @TestCase(name = "trickOrTreat() method: Ghost's candy is properly added after one trickOrTreat()")
    @Tip(description = "How many pieces of candy does a Ghost get every time it runs trickOrTreat()?")
    public void trickOrTreatOneRun() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Laura", 6, 5);
        ghost.trickOrTreat();
        String string = ghost.toString();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(string, "Laura/6/7/0");
    }

    @TestCase(name = "trickOrTreat() method: Ghost's candy is properly added after two trickOrTreat()'s")
    @Tip(description = "How many pieces of candy does a Ghost get every time it runs trickOrTreat()?")
    public void trickOrTreatTwoRuns() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Skyla", 6, 3);
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        String string = ghost.toString();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(string, "Skyla/6/7/0");
    }

    @TestCase(name = "trickOrTreat() method: Ghost's candy is properly added after three trickOrTreat()'s")
    @Tip(description = "How many pieces of candy does a Ghost get every time it runs trickOrTreat()?")
    public void trickOrTreatThreeRuns() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Radhika", 6, 1);
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        String string = ghost.toString();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(string, "Radhika/6/7/0");
    }

    @TestCase(name = "rob() method: Increments robberiesConducted when given a valid Robbale")
    @Tip(description = "Make sure you're incrementing robberiesConducted!")
    public void robValidInputs() throws TestFailedException {
        Ghost ghost = new Ghost("Spartan", 9, 6);
        RobbableSubclass victim = new RobbableSubclass("Clarence", 5, 1);

        ghost.rob(victim);

        String string = ghost.toString();

        TestFunction.assertEqual(string, "Spartan/9/7/1");
    }

    @TestCase(name = "rob() method: Does not increment robberiesConducted when given null")
    @Tip(description = "As written, the instructions do not forbid a null input to rob().")
    public void robNull() throws TestFailedException {
        Ghost ghost = new Ghost("Tremor", 6, 7);

        ghost.rob(null);

        String string = ghost.toString();

        TestFunction.assertEqual(string, "Tremor/6/7/0");
    }

    @TestCase(name = "rob() method: Increments robberiesConducted when stealing 0 candies.")
    @Tip(description = "As written, the instructions are unclear whether or not stealing 0 candies should increment the counter or not.")
    public void robZero() throws TestFailedException {
        Ghost ghost = new Ghost("Spartan", 9, 7);
        RobbableSubclass victim = new RobbableSubclass("Clarence", 5, 0);

        ghost.rob(victim);

        String string = ghost.toString();

        TestFunction.assertEqual(string, "Spartan/9/7/1");
    }

    @TestCase(name = "rob() method: Increments robberiesConducted when doing 2 robberies.")
    @Tip(description = "Make sure you're incrementing robberiesConducted!")
    public void robTwice() throws TestFailedException {
        Ghost ghost = new Ghost("Iron", 9, 5);
        RobbableSubclass victim = new RobbableSubclass("Clarence", 5, 1);

        ghost.rob(victim);
        ghost.rob(victim);

        String string = ghost.toString();

        TestFunction.assertEqual(string, "Iron/9/7/2");
    }

    @TestCase(name = "rob() method: Increments robberiesConducted when doing 3 robberies.")
    @Tip(description = "Make sure you're incrementing robberiesConducted!")
    public void robThrice() throws TestFailedException {
        Ghost ghost = new Ghost("Grey", 9, 4);
        RobbableSubclass victim = new RobbableSubclass("Clarence", 5, 1);

        ghost.rob(victim);
        ghost.rob(victim);
        ghost.rob(victim);

        String string = ghost.toString();

        TestFunction.assertEqual(string, "Grey/9/7/3");
    }

    @TestCase(name = "compareTo: other has greater candy, smaller age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterSmaller() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 2, 9);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has greater candy, equal age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterEqual() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 1, 9);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has greater candy, greater age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterGreater() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 1, 9);
        Ghost ghost2 = new Ghost("Sun Tzu", 2, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has equal candy, smaller age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualSmaller() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 2, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqual() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 1, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, 0);
    }

    @TestCase(name = "compareTo: other has equal candy, greater age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualGreater() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 1, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 2, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has fewer candy, smaller age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerSmaller() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 2, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 9);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has fewer candy, equal age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerEqual() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 1, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 9);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has fewer candy, greater age, equal robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerGreater() throws TestFailedException {

        Ghost ghost1 = new Ghost("Skipper", 1, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 2, 9);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age, greater robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqualGreater() throws TestFailedException {
        RobbableSubclass dummy = new RobbableSubclass("dummy", 0, 1);
        Ghost ghost1 = new Ghost("Skipper", 1, 10);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 10);
        ghost2.rob(dummy);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age, fewer robberies")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqualSmaller() throws TestFailedException {
        RobbableSubclass dummy = new RobbableSubclass("dummy", 0, 1);

        Ghost ghost1 = new Ghost("Skipper", 1, 10);
        ghost1.rob(dummy);
        Ghost ghost2 = new Ghost("Sun Tzu", 1, 10);
        int result = TestUtils.signOf(ghost1.compareTo(ghost2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: transitivity check...")
    @Tip(description = "Read the Java 11 compareTo() documentation for info on transitivity.\n"
               + "\t      If x.compareTo(y) > 0 and y.compareTo(z) > 0, then x.compareTo(z) MUST be > 0.\n"
               + "\t      This method checks MANY combinations of ages and numCandys for transitivity.\n")
    public void compareToTransitivity() throws TestFailedException {

        String ghostX = "", ghostY = "", ghostZ = "";
        
        Ghost[] possibleX = getAllGhostsOnInterval("Xander", 0,12, 0, 10, 0, 3);
        Ghost[] possibleY = getAllGhostsOnInterval("Yang", 0, 12, 0, 10, 0, 3);
        Ghost[] possibleZ = getAllGhostsOnInterval("Zan", 0, 12, 0, 10, 0, 3);

        for (int i = 0; i < possibleX.length; i++) {
            for (int j = 0; j < possibleY.length; j++) {
                for (int k = 0; k < possibleZ.length; k++) {
                    Ghost x = possibleX[i];
                    Ghost y = possibleY[j];
                    Ghost z = possibleZ[k];
                    if (x.compareTo(y) > 0 && y.compareTo(z) > 0 && x.compareTo(z) <= 0) { // This comes directly from the compareTo docs
                        ghostX = x.toString();
                        ghostY = y.toString();
                        ghostZ = z.toString();
                        System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " TRANSITIVITY TEST FAILED: \u00BB ") + "\nWhen "
                                + "x = \"" + ghostX + "\", y = \"" + ghostY + "\", z = \"" + ghostZ + "\"");
                        TestFunction.assertEqual(TestUtils.signOf(x.compareTo(z)), 1);
                    }
                }
            }
        }
    }

    /**
     * Private class to test Ghost's rob() function.
     */
    private class RobbableSubclass extends TrickOrTreater implements Robbable {

        public RobbableSubclass(String name, int age, int numCandy) {
            super(name, age, numCandy);
        }

        @Override
        public int beRobbed() {
            return this.getNumCandy();
        }

        @Override
        public void trickOrTreat() {
        }

    }

    /**
     * Helper method to retrieve all possible Ghosts on the given intervals (inclusive).
     * @param name The name of all of the Ghosts
     * @param minAge Min age, inclusive.
     * @param maxAge Max age, inclusive.
     * @param minCandy Min candy, inclusive.
     * @param maxCandy Max candy, inclusive.
     * @param minRobberies Min robberies, inclusive.
     * @param maxRobberies Max robberies, inclusive.
     * @return An array containing all possible trick or treaters on the interval.
     */
    private Ghost[] getAllGhostsOnInterval(String name, int minAge, int maxAge, int minCandy, int maxCandy, int minRobberies, int maxRobberies) {
        Ghost[] combos = new Ghost[(maxAge + 1 - minAge) * (maxCandy + 1 - minCandy) * (maxRobberies + 1 - minRobberies)];
        RobbableSubclass dummy = new RobbableSubclass("dummy", 0, 0);
        int index = 0;
        for (int i = minAge; i <= maxAge; i++) {
            for (int j = minCandy; j <= maxCandy; j++) {
                for (int k = minRobberies; k <= maxRobberies; k++) {
                    combos[index] = new Ghost(name, i, j);
                    for (int l = 0; l < k; l++) {
                        combos[index].rob(dummy);
                    }
                    index++;
                }
            }
        }
        return combos;
    }
}
