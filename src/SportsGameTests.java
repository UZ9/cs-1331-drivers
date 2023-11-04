public class SportsGameTests {
    
    @TestCase(name = "Constructor: Valid inputs")
    @Tip(description = "What order should the constructor arguments be?")
    public void constructorValidInputs() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 0);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,0");

    }

    @TestCase(name = "Constructor: Invalid venue")
    @Tip(description = "What is a 'valid' venue? What should happen when an invalid input is passed in?")
    public void constructorInvalidVenue() throws TestFailedException {

        TestFunction.testStringInputsForException(IllegalArgumentException.class,
            (s) -> new SportsGameSubclass(s, "0:00", "01-01-2000", 1, 1, 0));

    }

    /**
     * Subclass of SportsGame, ONLY for testing purposes.
     */
    class SportsGameSubclass extends SportsGame {

        public SportsGameSubclass(String venue, String startTime, String startDate, int score1, int score2,
                int seatsLeft) {
            super(venue, startTime, startDate, score1, score2, seatsLeft);
        }

    }

}
