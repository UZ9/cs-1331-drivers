class WitchTests {
    private static final String COMPARE_TO_METHOD_TIP = "What criteria should compareTo use to determine greater/less than? What order should these be compared?\n"
                                                        + "    Note: This test only checks the SIGN of compareTo, since the intended number is not specified.\n"
                                                        + "    1 means that compareTo() returned a positive number, -1 means a negative number, 0 means 0.";

    @TestCase(name = "Constructor: Valid inputs passed in (this test does not check cackle)")
    @Tip(description = "Make sure there isn't any field shadowing in your constructor!")
    public void constructorFourArgs() throws TestFailedException {

        Witch ghost = new Witch("Yoon", 6, 70, "Wahoo!");
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Yoon/6/70");
    }

    @TestCase(name = "Constructor: null name (this test does not check cackle)")
    @Tip(description = "What is a valid input for name? What should it default to?")
    public void constructorNullName() throws TestFailedException {

        Witch ghost = new Witch(null, 6, 70, "Wahoo!");
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Charlie Brown/6/70");
    }

    @TestCase(name = "Constructor: empty name (this test does not check cackle)")
    @Tip(description = "What is a valid input for name? What should it default to?")
    public void constructorEmptyName() throws TestFailedException {

        Witch ghost = new Witch("", 6, 70, "Wahoo!");
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Charlie Brown/6/70");
    }

    @TestCase(name = "Constructor: blank name (this test does not check cackle)")
    @Tip(description = "What is a valid input for name? What should it default to?")
    public void constructorBlankName() throws TestFailedException {

        Witch ghost = new Witch("", 6, 70, "Wahoo!");
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Charlie Brown/6/70");
    }

    @TestCase(name = "Constructor: no args (this test does not check cackle)")
    @Tip(description = "What is a valid input for name? What should it default to?")
    public void constructorNoArgs() throws TestFailedException {

        Witch ghost = new Witch("   ", 6, 70, "Wahoo!");
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Charlie Brown/6/70");
    }

    @TestCase(name = "Constructor: null signatureCackle")
    @Tip(description = "What qualifies as a valid input for signatureCackle?")
    public void constructorNullCackle() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Skipper", 6, 70,null);
        witch.trickOrTreat();

        String consoleOutput = hijacker.stopRecording();

        TestFunction.assertEqual(consoleOutput, "Bwahaha! I'll get you my pretty!\n");
    }

    @TestCase(name = "Constructor: empty signatureCackle")
    @Tip(description = "What qualifies as a valid input for signatureCackle?")
    public void constructorEmptyCackle() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Skipper", 6, 70,"");
        witch.trickOrTreat();

        String consoleOutput = hijacker.stopRecording();

        TestFunction.assertEqual(consoleOutput, "Bwahaha! I'll get you my pretty!\n");
    }


    @TestCase(name = "Constructor: blank signatureCackle")
    @Tip(description = "What qualifies as a valid input for signatureCackle?")
    public void constructorBlankCackle() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Skipper", 6, 70,"     ");
        witch.trickOrTreat();

        String consoleOutput = hijacker.stopRecording();

        TestFunction.assertEqual(consoleOutput, "Bwahaha! I'll get you my pretty!\n");
    }

    @TestCase(name = "trickOrTreat: run once (checking for console output)")
    @Tip(description = "Check for leading or trailing whitespace in your print statements.")
    public void trickOrTreatOutputOnce() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Grey", 9, 70, "Yippee");
        witch.trickOrTreat();

        String consoleOutput = hijacker.stopRecording();

        TestFunction.assertEqual(consoleOutput, "Yippee! I'll get you my pretty!\n");
    }

    @TestCase(name = "trickOrTreat: run twice (checking for console output)")
    @Tip(description = "Check for leading or trailing whitespace in your print statements.")
    public void trickOrTreatOutputTwice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Spartan", 9, 65, "Hooray");
        witch.trickOrTreat();
        witch.trickOrTreat();

        String consoleOutput = hijacker.stopRecording();

        TestFunction.assertEqual(consoleOutput, "Hooray! I'll get you my pretty!\nHooray! I'll get you my pretty!\n");
    }

    @TestCase(name = "trickOrTreat: run three times (checking for console output)")
    @Tip(description = "Check for leading or trailing whitespace in your print statements.")
    public void trickOrTreatOutputThrice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Poof", 2, 45, "Wahoo");
        witch.trickOrTreat();
        witch.trickOrTreat();
        witch.trickOrTreat();

        String consoleOutput = hijacker.stopRecording();

        TestFunction.assertEqual(consoleOutput, "Wahoo! I'll get you my pretty!\nWahoo! I'll get you my pretty!\nWahoo! I'll get you my pretty!\n");
    }

    @TestCase(name = "trickOrTreat: run once (checking for number of candy)")
    @Tip(description = "How much candy should a Witch gain when it trickOrTreats?")
    public void trickOrTreatCandyOnce() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Grey", 9, 70, "yippee");
        witch.trickOrTreat();
        String output = witch.toString();

        hijacker.stopRecording();
        
        TestFunction.assertEqual(output, "Grey/9/73");
    }

    @TestCase(name = "trickOrTreat: run twice (checking for number of candy)")
    @Tip(description = "How much candy should a Witch gain when it trickOrTreats?")
    public void trickOrTreatCandyTwice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Spartan", 9, 65, "yippee");
        witch.trickOrTreat();
        witch.trickOrTreat();
        String output = witch.toString();

        hijacker.stopRecording();

        TestFunction.assertEqual(output, "Spartan/9/71");
    }

    @TestCase(name = "trickOrTreat: run three times (checking for number of candy)")
    @Tip(description = "How much candy should a Witch gain when it trickOrTreats?")
    public void trickOrTreatCandyThrice() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Witch witch = new Witch("Poof", 2, 45, "yippee");
        witch.trickOrTreat();
        witch.trickOrTreat();
        witch.trickOrTreat();
        String output = witch.toString();

        hijacker.stopRecording();

        TestFunction.assertEqual(output, "Poof/2/54");
    }

    @TestCase(name = "compareTo: other has greater candy, smaller age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterSmaller() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 2, 9, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 10, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has greater candy, equal age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterEqual() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 9, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 10, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has greater candy, greater age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToGreaterGreater() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 9, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 2, 10, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has equal candy, smaller age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualSmaller() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 2, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 10, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqual() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 10, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, 0);
    }

    @TestCase(name = "compareTo: other has equal candy, greater age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualGreater() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 2, 10, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has fewer candy, smaller age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerSmaller() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 2, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 9, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has fewer candy, equal age, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerEqual() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 9, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has fewer candy, greater ag, equal cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToSmallerGreater() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 2, 9, "Haha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age, greater cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqualGreater() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 10, "Hahaha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, -1);
    }

    @TestCase(name = "compareTo: other has equal candy, equal age, smaller cackleLength")
    @Tip(description = COMPARE_TO_METHOD_TIP)
    public void compareToEqualEqualGreaterSmaller() throws TestFailedException {

        Witch witch1 = new Witch("Skipper", 1, 10, "Haha");
        Witch witch2 = new Witch("Sun Tzu", 1, 10, "Ha");
        int result = TestUtils.signOf(witch1.compareTo(witch2));

        TestFunction.assertEqual(result, 1);
    }

    @TestCase(name = "compareTo: Check for transitivity (not necessarily correctness)")
    @Tip(description = "Read the Java 11 compareTo() documentation for info on transitivity.\n"
               + "\t      If x.compareTo(y) > 0 and y.compareTo(z) > 0, then x.compareTo(z) MUST be > 0.\n"
               + "\t      This method checks MANY combinations of ages and numCandys for transitivity.\n")
    public void compareToTransitivity() throws TestFailedException {

        String witchX = "", witchY = "", witchZ = "";
        
        Witch[] possibleX = getAllWitchesOnInterval("Xander", 0,12, 0, 10, 0, 3);
        Witch[] possibleY = getAllWitchesOnInterval("Yang", 0, 12, 0, 10, 0, 3);
        Witch[] possibleZ = getAllWitchesOnInterval("Zan", 0, 12, 0, 10, 0, 3);

        for (int i = 0; i < possibleX.length; i++) {
            for (int j = 0; j < possibleY.length; j++) {
                for (int k = 0; k < possibleZ.length; k++) {
                    Witch x = possibleX[i];
                    Witch y = possibleY[j];
                    Witch z = possibleZ[k];
                    if (x.compareTo(y) > 0 && y.compareTo(z) > 0 && x.compareTo(z) <= 0) { // This comes directly from the compareTo docs
                        witchX = x.toString();
                        witchY = y.toString();
                        witchZ = z.toString();
                        System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " TRANSITIVITY TEST FAILED: \u00BB ") + "\nWhen "
                                + "x = \"" + witchX + "\", y = \"" + witchY + "\", z = \"" + witchZ + "\"");
                        TestFunction.assertEqual(TestUtils.signOf(x.compareTo(z)), 1);
                    }
                }
            }
        }
    }

    /**
     * Helper method to retrieve all possible Ghosts on the given intervals (inclusive).
     * @param name The name of all of the Ghosts
     * @param minAge Min age, inclusive.
     * @param maxAge Max age, inclusive.
     * @param minCandy Min candy, inclusive.
     * @param maxCandy Max candy, inclusive.
     * @param minCackleLength Min cackle length, inclusive.
     * @param maxCackleLength Max cackle length, inclusive.
     * @return An array containing all possible trick or treaters on the interval.
     */
    private Witch[] getAllWitchesOnInterval(String name, int minAge, int maxAge, int minCandy, int maxCandy, int minCackleLength, int maxCackleLength) {
        Witch[] combos = new Witch[(maxAge + 1 - minAge) * (maxCandy + 1 - minCandy) * (maxCackleLength + 1 - minCackleLength)];
        int index = 0;
        for (int i = minAge; i <= maxAge; i++) {
            for (int j = minCandy; j <= maxCandy; j++) {
                for (int k = minCackleLength; k <= maxCackleLength; k++) {
                    StringBuilder s = new StringBuilder();
                    for (int l = 0; l < k; l++) {
                        s.append("-");
                    }
                    combos[index] = new Witch(name, i, j, s.toString());
                    index++;
                }
            }
        }
        return combos;
    }
}