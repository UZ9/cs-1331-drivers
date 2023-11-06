public class SportsGameTests {
    
    @TestCase(name = "Constructor: Valid inputs")
    @Tip(description = "What order should the constructor arguments be?")
    public void constructorValidInputs() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Invalid venue")
    @Tip(description = "What is a 'valid' venue? What should happen when an invalid input is passed in?")
    public void constructorInvalidVenue() throws TestFailedException {

        TestFunction.testStringInputsForException(IllegalArgumentException.class,
            (s) -> new SportsGameSubclass(s, "00:00", "01-01-2000", 1, 1, 1));

    }

    @TestCase(name = "Constructor: Invalid start time")
    @Tip(description = "What is a 'valid' start time? What should happen when an invalid input is passed in?")
    public void constructorInvalidStartTime() throws TestFailedException {

        TestFunction.testStringInputsForException(IllegalArgumentException.class,
            (s) -> new SportsGameSubclass("Bobby Dodd Stadium", s, "01-01-2000", 1, 1, 1));

    }

    @TestCase(name = "Constructor: Invalid start date")
    @Tip(description = "What is a 'valid' start date? What should happen when an invalid input is passed in?")
    public void constructorInvalidStartDate() throws TestFailedException {

        TestFunction.testStringInputsForException(IllegalArgumentException.class,
            (s) -> new SportsGameSubclass("Bobby Dodd Stadium", "00:00", s, 1, 1, 1));

    }

    @TestCase(name = "Constructor: Negative score1")
    @Tip(description = "What is a 'valid' score1? What should happen when an invalid input is passed in?")
    public void constructorInvalidScore1() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class,
            () -> new SportsGameSubclass("Bobby Dodd Stadium", "00:00", "01-01-2000", -1, 1, 1));

    }

    @TestCase(name = "Constructor: Negative score2")
    @Tip(description = "What is a 'valid' score2? What should happen when an invalid input is passed in?")
    public void constructorInvalidScore2() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class,
            () -> new SportsGameSubclass("Bobby Dodd Stadium", "00:00", "01-01-2000", 1, -1, 1));

    }

    @TestCase(name = "Constructor: Negative seatsLeft")
    @Tip(description = "What is a 'valid' value for seatsLeft? What should happen when an invalid input is passed in?")
    public void constructorInvalidSeatsLeft() throws TestFailedException {

        TestFunction.testForException(IllegalArgumentException.class,
            () -> new SportsGameSubclass("Bobby Dodd Stadium", "00:00", "01-01-2000", 1, 1, -1));

    }

    @TestCase(name = "Constructor: Zero score1")
    @Tip(description = "Is 0 a valid input to the constructor?")
    public void constructorZeroScore1() throws TestFailedException {

        SportsGame game = new SportsGameSubclass("Bobby Dodd Stadium", "00:00", "01-01-2000", 0, 1, 1);
        TestFunction.assertEqual(game.toString(), "Bobby Dodd Stadium,00:00,01-01-2000,0,1,1");

    }

    @TestCase(name = "Constructor: Zero score2")
    @Tip(description = "Is 0 a valid input to the constructor?")
    public void constructorZeroScore2() throws TestFailedException {
        SportsGame game = new SportsGameSubclass("Bobby Dodd Stadium", "00:00", "01-01-2000", 1, 0, 1);
        TestFunction.assertEqual(game.toString(), "Bobby Dodd Stadium,00:00,01-01-2000,1,0,1");

    }

    @TestCase(name = "Constructor: Zero seatsLeft")
    @Tip(description = "Is 0 a valid input to the constructor?")
    public void constructorZeroSeatsLeft() throws TestFailedException {
        SportsGame game = new SportsGameSubclass("Bobby Dodd Stadium", "00:00", "01-01-2000", 1, 1, 0);
        TestFunction.assertEqual(game.toString(), "Bobby Dodd Stadium,00:00,01-01-2000,1,1,0");

    }

    @TestCase(name = "Constructor: Leading/Trailing spaces around venue name")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorSpacesVenue() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass(" Mercedes-Benz ", "17:00", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing newline characters around start time")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorNewlinesVenue() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("\nMercedes-Benz\n", "17:00", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing tab characters around start time")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorTabsVenue() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("\tMercedes-Benz\t", "17:00", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing spaces around start time")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorSpacesTime() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", " 17:00 ", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing newline characters around start time")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorNewlinesTime() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "\n17:00\n", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing tab characters around start time")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorTabsTime() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "\t17:00\t", "08-21-2023", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing spaces around start date")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorSpacesDate() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "17:00", " 08-21-2023 ", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing newline characters around start date")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorNewlinesDate() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "17:00", "\n08-21-2023\n", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Leading/Trailing tab characters around start date")
    @Tip(description = "What method in the String class removes leading & trailing whitespace?")
    public void constructorTabsDate() throws TestFailedException {
        
        SportsGame game = new SportsGameSubclass("Mercedes-Benz", "17:00", "\t08-21-2023\t", 6, 70, 1);
        TestFunction.assertEqual(game.toString(), "Mercedes-Benz,17:00,08-21-2023,6,70,1");

    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (venue)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage1() throws TestFailedException {
        
        try {
            new SportsGameSubclass(null, "17:00", "08-21-2023", 6, 70, 1);
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal argument");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (start time)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage2() throws TestFailedException {
        
        try {
            new SportsGameSubclass("Bobby Dodd", null, "08-21-2023", 6, 70, 1);
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal argument");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (start date)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage3() throws TestFailedException {
        
        try {
            new SportsGameSubclass("Bobby Dodd", "17:00", null, 6, 70, 1);
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal argument");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (score1)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage4() throws TestFailedException {
        
        try {
            new SportsGameSubclass("Bobby Dodd", "17:00", "01-01-2020", -1, 70, 1);
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal argument");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (score2)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage5() throws TestFailedException {
        
        try {
            new SportsGameSubclass("Bobby Dodd", "17:00", "01-01-2020", 6, -1, 1);
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal argument");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (seatsLeft)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage6() throws TestFailedException {
        
        try {
            new SportsGameSubclass("Bobby Dodd", "17:00", "01-01-2020", 6, 70, -1);
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal argument");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "equals(): All values are equal")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsEquals() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);

        TestFunction.assertEqual(true, game1, game2);

    }

    @TestCase(name = "equals(): Venue is different")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsDifferentVenue() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Bench", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Start time is different")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsDifferentTime() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:01", "08-21-2023", 6, 70, 1);

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Start date is different")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsDifferentDate() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-1996", 6, 70, 1);

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Score1 is different")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsDifferentScore1() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-1996", 7, 70, 1);

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Score2 is different")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsDifferentScore2() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-1996", 6, 77, 1);

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): seatsLeft is different")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsDifferentSeats() throws TestFailedException {

        SportsGame game1 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1);
        SportsGame game2 = new SportsGameSubclass("Mercedes-Benz", "17:00", "08-21-1996", 6, 70, 3);

        TestFunction.assertEqual(false, game1, game2);

    }

    /**
     * Subclass of SportsGame, ONLY for testing purposes.
     */
    public static class SportsGameSubclass extends SportsGame {

        public SportsGameSubclass(String venue, String startTime, String startDate, int score1, int score2,
                int seatsLeft) {
            super(venue, startTime, startDate, score1, score2, seatsLeft);
        }

    }

}
