public class FootballGameTests {
    
    @TestCase(name = "Constructor: Valid inputs")
    @Tip(description = "What order should the constructor arguments be?")
    public void constructorValidInputs() throws TestFailedException {
        
        FootballGame game = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Snoop Dog");
        TestFunction.assertEqual(game.toString(), "FootballGame,Mercedes-Benz,17:00,08-21-2023,6,70,1,Snoop Dog");

    }

    @TestCase(name = "Constructor: Invalid performer")
    @Tip(description = "What is a 'valid' performer? What should happen when an invalid input is passed in?")
    public void constructorInvalidPerformer() throws TestFailedException {

        TestFunction.testStringInputsForException(IllegalArgumentException.class,
            (s) -> new FootballGame(s, "00:00", "01-01-2000", 1, 1, 1, s));

    }

    @TestCase(name = "Constructor: Performer has leading/trailing whitespace")
    @Tip(description = "What method does the String class have to remove leading/trailing whitespace?")
    public void constructorPerformerSpaces() throws TestFailedException {

        FootballGame game = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, " \n\tEminem \n\t");
        TestFunction.assertEqual(game.toString(), "FootballGame,Mercedes-Benz,17:00,08-21-2023,6,70,1,Eminem");

    }

    @TestCase(name = "Constructor: Non-default message in IllegalArgumentException (performer)")
    @Tip(description = "Remember to provide a \"descriptive and specific\" message with ALL Exceptions thrown. What alternate constructor does IllegalArgumentException have that sets an error message?")
    public void constructorDescriptiveMessage6() throws TestFailedException {
        
        try {
            new FootballGame("Bobby Dodd", "17:00", "01-01-2020", 6, 70, 1, "   ");
            throw new TestFailedException("Did not receive an IllegalArgumentException when giving an illegal value for performer");
        } catch (IllegalArgumentException iae) {
            if (iae.getMessage() == null) {
                throw new TestFailedException("Received error message \"" + iae.getMessage() + "\". Check Note 5 on Page 1 of the directions.");
            }
        }
        
    }

    @TestCase(name = "equals(): All values are equal")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsEquals() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Maroon 5");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Maroon 5");

        TestFunction.assertEqual(true, game1, game2);

    }

    @TestCase(name = "equals(): Different venue")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsVenue() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Bench", "17:00", "08-21-2023", 6, 70, 1, "Maroon 5");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Maroon 5");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different start time")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsTime() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:01", "08-21-2023", 6, 70, 1, "Maroon 5");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Maroon 5");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different start date")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsDate() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:00", "08-21-1938", 6, 70, 1, "J-Lo");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "J-Lo");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different score1")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsScore1() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 9, 70, 1, "Shakira");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Shakira");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different score2")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsScore2() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 56, 1, "Spongebob");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Spongebob");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different seatsLeft")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsSeats() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 2, "Pentatonix");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Pentatonix");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different league")
    @Tip(description =  "What values must be equal for two FootballGames to be considered equal?")
    public void equalsLeauge() throws TestFailedException {

        FootballGame game1 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 2, "Lyn Lapid");
        FootballGame game2 = new FootballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "Jacob Collier");

        TestFunction.assertEqual(false, game1, game2);

    }

}
