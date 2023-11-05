public class BasketballGameTests {
    
    @TestCase(name = "Constructor: Valid inputs")
    @Tip(description = "What order should the constructor arguments be?")
    public void constructorValidInputs() throws TestFailedException {
        
        BasketballGame game = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");
        TestFunction.assertEqual(game.toString(), "BasketballGame,Mercedes-Benz,17:00,08-21-2023,6,70,1,NCAA");

    }

    @TestCase(name = "Constructor: Invalid league")
    @Tip(description = "What is a 'valid' league? What should happen when an invalid input is passed in?")
    public void constructorInvalidPerformer() throws TestFailedException {

        TestFunction.testStringInputsForException(IllegalArgumentException.class,
            (s) -> new BasketballGame(s, "00:00", "01-01-2000", 1, 1, 1, s));

    }

    @TestCase(name = "Constructor: League has leading/trailing whitespace")
    @Tip(description = "What method does the String class have to remove leading/trailing whitespace?")
    public void constructorLeagueSpaces() throws TestFailedException {

        BasketballGame game = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, " \n\tNCAA \n\t");
        TestFunction.assertEqual(game.toString(), "BasketballGame,Mercedes-Benz,17:00,08-21-2023,6,70,1,NCAA");

    }

    @TestCase(name = "equals(): All values are equal")
    @Tip(description =  "What values must be equal for two SportsGames to be considered equal?")
    public void equalsEquals() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(true, game1, game2);

    }

    @TestCase(name = "equals(): Different venue")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsVenue() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Bench", "17:00", "08-21-2023", 6, 70, 1, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different start time")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsTime() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:01", "08-21-2023", 6, 70, 1, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different start date")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsDate() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-1938", 6, 70, 1, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different score1")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsScore1() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 9, 70, 1, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different score2")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsScore2() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 56, 1, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different seatsLeft")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsSeats() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 2, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NCAA");

        TestFunction.assertEqual(false, game1, game2);

    }

    @TestCase(name = "equals(): Different league")
    @Tip(description =  "What values must be equal for two BasketballGames to be considered equal?")
    public void equalsLeauge() throws TestFailedException {

        BasketballGame game1 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 2, "NCAA");
        BasketballGame game2 = new BasketballGame("Mercedes-Benz", "17:00", "08-21-2023", 6, 70, 1, "NBA");

        TestFunction.assertEqual(false, game1, game2);

    }

}
