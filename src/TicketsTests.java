import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TicketsTests {

    @BeforeTest
    public void setupFiles() throws FileNotFoundException, IllegalArgumentException, IllegalAccessException {

        for (Field field : TxtTestData.class.getFields()) {
            if (field.getType() == String.class) {
                BeforeTest beforeAnnotation = field.getAnnotation(BeforeTest.class);

                if (beforeAnnotation != null) {
                    StringUtils.stringToFile(field.getName() + ".txt", field.get(null).toString());
                }

            }
        }

    }

    @BeforeTest
    public void deleteOldFiles() {

        for (Field field : TxtTestData.class.getFields()) {
            if (field.getType() == String.class) {
                DeleteFileBefore deleteAnnotation = field.getAnnotation(DeleteFileBefore.class);

                if (deleteAnnotation != null) {
                    TestUtils.deleteFile(field.getName() + ".txt");
                }

            }
        }

    }
 
    @TestCase(name = "RetrieveGames: File contains valid FootballGames and BasketballGames")
    @Tip(description = "No tip. I think you can figure this one out.")
    public void retrieveGamesValidInputs() throws TestFailedException {
        
        try {
            ArrayList<SportsGame> games = Tickets.retrieveGames("retrieveGamesValidInputs.txt");
            TestFunction.assertEqual(StringUtils.arrayListToString(games), TxtTestData.retrieveGamesValidInputs);
        } catch (FileNotFoundException fnfe) {
            throw new TestFailedException("Generated FileNotFoundException when no exception should occur!");
        } catch (InvalidTicketException ite) {
            throw new TestFailedException("Generated InvalidTicketException when no exception should occur!");
        }

    }
 
    @TestCase(name = "RetrieveGames: Inputted path name is null")
    @Tip(description = "What error should be thrown when the given path is null?")
    public void retrieveGamesNullInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.retrieveGames(null);
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }
 
    @TestCase(name = "RetrieveGames: Inputted path name is blank")
    @Tip(description = "What error should be thrown when the given path is blank?")
    public void retrieveGamesBlankInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.retrieveGames("   ");
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }
 
    @TestCase(name = "RetrieveGames: Inputted path name is empty")
    @Tip(description = "What error should be thrown when the given path is empty?")
    public void retrieveGamesEmptyInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.retrieveGames("");
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }
 
    @TestCase(name = "RetrieveGames: Inputted path name is not found")
    @Tip(description = "What error should be thrown when no file exists at the given path?")
    public void retrieveGamesNotFoundInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.retrieveGames("filethatdoesnotexist.txt");
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }
 
    @TestCase(name = "RetrieveGames: One line in file has invalid gameType token (SoccerGame)")
    @Tip(description = "See the example on page 4 of the directions. What exception should be thrown?")
    public void retrieveGamesInvalidTicket() throws TestFailedException {

        Class<? extends Exception> exceptionType = InvalidTicketException.class;
        
        try {
            Tickets.retrieveGames("retrieveGamesInvalidInputs.txt");
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }

    @TestCase(name = "purchaseTickets: Inputs are valid, file does not yet exist")
    @Tip(description = "Make sure that you create the file if it does not yet exist!")
    public void purchaseTicketsWritingToEmptyFile() throws IOException, TestFailedException {
        ArrayList<SportsGame> gamesToAdd = new ArrayList<>();
        gamesToAdd.add(new FootballGame("Bobby Dodd", "17:00", "03-01-2020", 9, 9, 2, "Drake"));
        gamesToAdd.add(new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
        gamesToAdd.add(new FootballGame("Levi's Stadium", "17:00", "03-01-2020", 9, 9, 2, "Drake"));

        Tickets.purchaseTickets("purchaseTicketsWritingToEmptyFile.txt", gamesToAdd);

        String output = StringUtils.fileToString("purchaseTicketsWritingToEmptyFile.txt");

        TestFunction.assertEqual(output, TxtTestData.purchaseTicketsWritingToEmptyFile);
    }

    @TestCase(name = "purchaseTickets: Inputs are valid, file does not yet exist")
    @Tip(description = "Make sure that you're just appending the new SportsGames to the end of the file!")
    public void purchaseTicketsWritingToExistingFile() throws IOException, TestFailedException {
        ArrayList<SportsGame> gamesToAdd = new ArrayList<>();
        gamesToAdd.add(new FootballGame("Bobby Dodd", "17:00", "03-01-2020", 9, 9, 2, "Drake"));
        gamesToAdd.add(new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
        gamesToAdd.add(new FootballGame("Levi's Stadium", "17:00", "03-01-2020", 9, 9, 2, "Drake"));

        Tickets.purchaseTickets("purchaseTicketsAppend.txt", gamesToAdd);

        String output = StringUtils.fileToString("purchaseTicketsAppend.txt");

        TestFunction.assertEqual(output, TxtTestData.purchaseTicketsAppendOutput);
    }

    @TestCase(name = "findTickets: File is null")
    @Tip(description = "What exception should findTickets() throw if the given file is null?")
    public void findTicketsNull() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.findTickets(null, new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }
    
    @TestCase(name = "findTickets: Inputted path name is blank")
    @Tip(description = "What error should be thrown when the given path is blank?")
    public void findTicketsBlankInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.findTickets("   ", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }
 
    @TestCase(name = "findTickets: Inputted path name is empty")
    @Tip(description = "What error should be thrown when the given path is empty?")
    public void findTicketsEmptyInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.findTickets("", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }

    }

    @TestCase(name = "findTickets: One occurrence")
    @Tip(description = "What format of Integers should be returned?")
    public void findTicketsOneOccurrence() throws IOException, TestFailedException, InvalidTicketException {
        ArrayList<Integer> output = Tickets.findTickets("findTicketsOneOccurrence.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));

        TestFunction.assertEqual(output.toString(), "[1]");
    }

    @TestCase(name = "findTickets: Multiple occurrences")
    @Tip(description = "What format of Integers should be returned?")
    public void findTicketsSeveralOccurrences() throws IOException, TestFailedException, InvalidTicketException {
        ArrayList<Integer> output = Tickets.findTickets("findTicketsSeveralOccurrences.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));

        TestFunction.assertEqual(output.toString(), "[1, 3, 5]");
    }

    @TestCase(name = "findTickets: Adjacent occurrences")
    @Tip(description = "Make sure that you're reading every single occurrence!")
    public void findTicketsAdjacentOccurrences() throws IOException, TestFailedException, InvalidTicketException {
        ArrayList<Integer> output = Tickets.findTickets("findTicketsAdjacentOccurrences.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));

        TestFunction.assertEqual(output.toString(), "[1, 3, 4, 6]");
    }

    @TestCase(name = "findTickets: No occurrences")
    @Tip(description = "What exception should be thrown if there are no occurrences?")
    public void findTicketsNoOccurrences() throws IOException, TestFailedException, InvalidTicketException {

        Class<? extends Exception> exceptionType = InvalidTicketException.class;
        
        try {
            Tickets.findTickets("findTicketsSeveralOccurrences.txt", new BasketballGame("Mercedes-Benz", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }
    }

}

