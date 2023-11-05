public class EqualsTests {
    
    private static final boolean[][] EQUALS_ANSWERS = new boolean[][] {
        {true, false, false},
        {false, true, false},
        {false, false, true}
    };

    @TestCase(name = "Check combinations of SportsGame, FootballGame, and BasketballGame for correctness")
    @Tip(description = "Make sure that you're checking all values!")
    public void correctnessTests() throws TestFailedException {
        SportsGame[] values = new SportsGame[] {
            new SportsGameTests.SportsGameSubclass("SAP Center", "19:00", "12-19-2004", 1, 2, 3),
            new FootballGame("SAP Center", "19:00", "12-19-2004", 1, 2, 3, "NFL"),
            new BasketballGame("SAP Center", "19:00", "12-19-2004", 1, 2, 3, "NFL"),
        };

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                TestFunction.assertEqual(values[i].equals(values[j]), EQUALS_ANSWERS[i][j]);
            }
        }
    }

    @TestCase(name = "Check combinations of SportsGame, FootballGame, and BasketballGame for symmetry (not correctness)")
    @Tip(description = "Make sure you check for symmetry in the way we learned in class!")
    public void symmetryTests() throws TestFailedException {
        SportsGame[] values = new SportsGame[] {
            new SportsGameTests.SportsGameSubclass("SAP Center", "19:00", "12-19-2004", 1, 2, 3),
            new FootballGame("SAP Center", "19:00", "12-19-2004", 1, 2, 3, "NFL"),
            new BasketballGame("SAP Center", "19:00", "12-19-2004", 1, 2, 3, "NFL"),
        };

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                try {
                    TestFunction.assertEqual(values[i].equals(values[j]), values[j].equals(values[i]));
                } catch (TestFailedException e) {
                    throw new TestFailedException(String.format("When a = \"%s\", b = \"%s\", testing a.equals(b): %s", values[i].toString(), values[j].toString(), e.getMessage()));
                }
            }
        }
    }

}
