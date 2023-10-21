class GhostTests {

    @TestCase(name = "Constructor: Valid inputs passed in.")
    @Tip(tip = "What should numberOfRobberies default to?")
    public void constructorThreeArgs() throws TestFailedException {

        Ghost ghost = new Ghost("Yoon", 6, 7);
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Yoon/6/7/0");
    }

    @TestCase(name = "Constructor: No args")
    @Tip(tip = "What should each of Ghost's fields default to?")
    public void constructorNoArgs() throws TestFailedException {

        Ghost ghost = new Ghost();
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Casper the Unfriendly Ghost/12/0/0");
    }

    @TestCase(name = "trickOrTreat() method: Printed message (when run once).")
    @Tip(tip = "One thing should be printed each time trickOrTreat() gets called. What is it?")
    public void trickOrTreatPrintWhenRunOnce() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Katia", 9, 7);
        ghost.trickOrTreat();

        String output = TestUtils.combinePrintStatements(hijacker.stopRecording());
        
        TestFunction.assertEqual(output, "Boo! Trick or treat!");
    }

    @TestCase(name = "trickOrTreat() method: Printed message (when run twice).")
    @Tip(tip = "One thing should be printed each time trickOrTreat() gets called. What is it?")
    public void trickOrTreatPrintWhenRunTwice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Katia", 9, 7);
        ghost.trickOrTreat();
        ghost.trickOrTreat();

        String output = TestUtils.combinePrintStatements(hijacker.stopRecording());
        
        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!");
    }

    @TestCase(name = "trickOrTreat() method: Printed message (when run three times).")
    @Tip(tip = "One thing should be printed each time trickOrTreat() gets called. What is it?")
    public void trickOrTreatPrintWhenRunThrice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Katia", 9, 7);
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        ghost.trickOrTreat();

        String output = TestUtils.combinePrintStatements(hijacker.stopRecording());
        
        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!");
    }

    @TestCase(name = "trickOrTreat() method: Ghost's candy is properly added after one trickOrTreat()")
    @Tip(tip = "How many pieces of candy does a Ghost get every time it runs trickOrTreat()?")
    public void trickOrTreatOneRun() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Laura", 6, 5);
        ghost.trickOrTreat();
        String string = ghost.toString();

        String output = TestUtils.combinePrintStatements(hijacker.stopRecording());

        TestFunction.assertEqual(string, "Laura/6/7/0");
    }

    @TestCase(name = "trickOrTreat() method: Ghost's candy is properly added after two trickOrTreat()'s")
    @Tip(tip = "How many pieces of candy does a Ghost get every time it runs trickOrTreat()?")
    public void trickOrTreatTwoRuns() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Skyla", 6, 3);
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        String string = ghost.toString();

        String output = TestUtils.combinePrintStatements(hijacker.stopRecording());

        TestFunction.assertEqual(string, "Skyla/6/7/0");
    }

    @TestCase(name = "trickOrTreat() method: Ghost's candy is properly added after three trickOrTreat()'s")
    @Tip(tip = "How many pieces of candy does a Ghost get every time it runs trickOrTreat()?")
    public void trickOrTreatThreeRuns() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Ghost ghost = new Ghost("Radhika", 6, 1);
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        ghost.trickOrTreat();
        String string = ghost.toString();

        String output = TestUtils.combinePrintStatements(hijacker.stopRecording());

        TestFunction.assertEqual(string, "Radhika/6/7/0");
    }

    @TestCase(name = "rob() method: Increments robberiesConducted when given a valid Robbale")
    @Tip(tip = "Make sure you're incrementing robberiesConducted!")
    public void robValidInputs() throws TestFailedException {
        Ghost ghost = new Ghost();
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Casper the Unfriendly Ghost/12/0/0");
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
            return 0;
        }

        @Override
        public void trickOrTreat() {
        }

    }
}
