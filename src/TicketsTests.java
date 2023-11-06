import java.io.FileNotFoundException;
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
                    StringUtils.stringToFile("TEMP_" + field.getName() + ".txt", field.get(null).toString());
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
                    TestUtils.deleteFile("TEMP_" + field.getName() + ".txt");
                }

            }
        }

    }

    @AfterTest
    public void deleteTextFiles() throws FileNotFoundException, IllegalArgumentException, IllegalAccessException {

        for (Field field : TxtTestData.class.getFields()) {
            if (field.getType() == String.class) {
                DeleteFileAfter deleteAnnotation = field.getAnnotation(DeleteFileAfter.class);

                if (deleteAnnotation != null) {
                    TestUtils.deleteFile("TEMP_" + field.getName() + ".txt");
                }

            }
        }

    }
 
    @TestCase(name = "RetrieveGames: File contains valid FootballGames and BasketballGames")
    @Tip(description = "No tip. I think you can figure this one out.")
    public void retrieveGamesValidInputs() throws TestFailedException {
        
        try {
            ArrayList<SportsGame> games = Tickets.retrieveGames("TEMP_" + "retrieveGamesValidInputs.txt");
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
    @Tip(description = "Make sure that you create the file if it does not yet exist. Is there a particular constructor for an object that prints to a file that you can use to automatically create a file?")
    public void purchaseTicketsWritingToEmptyFile() throws IOException, TestFailedException {
        ArrayList<SportsGame> gamesToAdd = new ArrayList<>();
        gamesToAdd.add(new FootballGame("Bobby Dodd", "17:00", "03-01-2020", 9, 9, 2, "Drake"));
        gamesToAdd.add(new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
        gamesToAdd.add(new FootballGame("Levi's Stadium", "17:00", "03-01-2020", 9, 9, 2, "Drake"));

        Tickets.purchaseTickets("TEMP_" + "purchaseTicketsWritingToEmptyFile.txt", gamesToAdd);

        String output = StringUtils.fileToString("TEMP_" + "purchaseTicketsWritingToEmptyFile.txt");

        TestFunction.assertEqual(output, TxtTestData.purchaseTicketsWritingToEmptyFile);
    }

    @TestCase(name = "purchaseTickets: Inputs are valid, file already exists")
    @Tip(description = "Make sure that you're just appending the new SportsGames to the end of the file!\nYou must read the values at that file before creating your writer, if your writer deletes the existing contents.\nRemember to follow read/modify/write protocol!")
    public void purchaseTicketsWritingToExistingFile() throws IOException, TestFailedException {
        ArrayList<SportsGame> gamesToAdd = new ArrayList<>();
        gamesToAdd.add(new FootballGame("Bobby Dodd", "17:00", "03-01-2020", 9, 9, 2, "Drake"));
        gamesToAdd.add(new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
        gamesToAdd.add(new FootballGame("Levi's Stadium", "17:00", "03-01-2020", 9, 9, 2, "Drake"));

        Tickets.purchaseTickets("TEMP_" + "purchaseTicketsAppend.txt", gamesToAdd);

        String output = StringUtils.fileToString("TEMP_" + "purchaseTicketsAppend.txt");

        TestFunction.assertEqual(output, TxtTestData.purchaseTicketsAppendOutput);
    }

    @TestCase(name = "purchaseTickets: Do not add if seatsLeft are 0")
    @Tip(description = "What should you do if there are 0 seats left?")
    public void purchaseTicketsZeroSeatsLeft() throws IOException, TestFailedException {
        ArrayList<SportsGame> gamesToAdd = new ArrayList<>();
        gamesToAdd.add(new FootballGame("Bobby Dodd", "17:00", "03-01-2020", 9, 9, 2, "Drake"));
        gamesToAdd.add(new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 0, "NCAA"));
        gamesToAdd.add(new FootballGame("Levi's Stadium", "17:00", "03-01-2020", 9, 9, 2, "Drake"));

        Tickets.purchaseTickets("TEMP_" + "purchaseTicketsZeroSeats.txt", gamesToAdd);

        String output = StringUtils.fileToString("TEMP_" + "purchaseTicketsZeroSeats.txt");

        TestFunction.assertEqual(output, TxtTestData.purchaseTicketsZeroSeatsOutput);
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
 
    @TestCase(name = "findTickets: No file at the inputted path")
    @Tip(description = "What error should be thrown when the given path does not lead to a file?")
    public void findTicketsNotFoundInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.findTickets("willthisfileeverexist.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
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
    @Tip(description = "What format of Integers should be returned? What index is the first line of the file?\nNOTE: The directions do not specify that you must list the indices in ascending order, but this Driver assumes you do.")
    public void findTicketsOneOccurrence() throws IOException, TestFailedException, InvalidTicketException {
        ArrayList<Integer> output = Tickets.findTickets("findTicketsOneOccurrence.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));

        TestFunction.assertEqual(output.toString(), "[1]");
    }

    @TestCase(name = "findTickets: Multiple occurrences")
    @Tip(description = "What format of Integers should be returned? What index is the first line of the file?\nNOTE: The directions do not specify that you must list the indices in ascending order, but this Driver assumes you do.")
    public void findTicketsSeveralOccurrences() throws IOException, TestFailedException, InvalidTicketException {
        ArrayList<Integer> output = Tickets.findTickets("findTicketsSeveralOccurrences.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));

        TestFunction.assertEqual(output.toString(), "[1, 3, 5]");
    }

    @TestCase(name = "findTickets: Adjacent occurrences")
    @Tip(description = "Make sure that you're reading every single occurrence!\nNOTE: The directions do not specify that you must list the indices in ascending order, but this Driver assumes you do.")
    public void findTicketsAdjacentOccurrences() throws IOException, TestFailedException, InvalidTicketException {
        ArrayList<Integer> output = Tickets.findTickets("findTicketsAdjacentOccurrences.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));

        TestFunction.assertEqual(output.toString(), "[1, 3, 4, 6]");
    }

    @TestCase(name = "findTickets: No occurrences of the given SportsGame")
    @Tip(description = "What exception should be thrown if there are no occurrences of the gievn SportsGame?")
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

    @TestCase(name = "attendGame: File is null")
    @Tip(description = "What exception should findTickets() throw if the given file is null?")
    public void attendGameNull() throws TestFailedException {

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
    
    @TestCase(name = "attendGame: Inputted path name is blank")
    @Tip(description = "What error should be thrown when the given path is blank?")
    public void attendGameBlankInput() throws TestFailedException {

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
 
    @TestCase(name = "attendGame: Inputted path name is empty")
    @Tip(description = "What error should be thrown when the given path is empty?")
    public void attendGameEmptyInput() throws TestFailedException {

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
 
    @TestCase(name = "attendGame: Inputted path name is not found")
    @Tip(description = "What error should be thrown when the given path does not exist?")
    public void attendGameNotFoundInput() throws TestFailedException {

        Class<? extends Exception> exceptionType = FileNotFoundException.class;
        
        try {
            Tickets.findTickets("thisfileshouldneverexist.txt", new BasketballGame("McCamish", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
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

    @TestCase(name = "attendGame: No occurrences of the given SportsGame")
    @Tip(description = "What exception should be thrown if there are no occurrences of the gievn SportsGame?")
    public void attendGameNoOccurrences() throws IOException, TestFailedException, InvalidTicketException {

        Class<? extends Exception> exceptionType = InvalidTicketException.class;
        
        try {
            Tickets.findTickets("attendGameNoOccurrences.txt", new BasketballGame("Mercedes-Benz", "17:00", "03-01-2020", 9, 9, 2, "NCAA"));
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

    @TestCase(name = "attendGame: Several non-adjacent occurrences of the given SportsGame")
    @Tip(description = "Make sure you remove ALL occurrences of the given SportsGame!")
    public void attendGameSeveralOccurrences() throws IOException, TestFailedException, InvalidTicketException {

        Tickets.attendGame("TEMP_" + "attendGameSeveralOccurrences.txt", new BasketballGame("McCamish", "0:00", "01-01-2020", 1, 1, 1, "NCAA"));
        String output = StringUtils.fileToString("TEMP_" + "attendGameSeveralOccurrences.txt");

        TestFunction.assertEqual(output.toString(), TxtTestData.attendGameSeveralOccurrencesOutput);

    }

    @TestCase(name = "attendGame: Several non-adjacent occurrences of the given SportsGame")
    @Tip(description = "Make sure you don't skip over the second of two adjacent SportsGames. What happens if you remove an item at an index, shift all subsequent items leftward, then increment your current index?")
    public void attendGameAdjacentOccurrences() throws IOException, TestFailedException, InvalidTicketException {

        Tickets.attendGame("TEMP_" + "attendGameAdjacentOccurrences.txt", new BasketballGame("McCamish", "0:00", "01-01-2020", 1, 1, 1, "NCAA"));
        String output = StringUtils.fileToString("TEMP_" + "attendGameAdjacentOccurrences.txt");

        TestFunction.assertEqual(output.toString(), TxtTestData.attendGameAdjacentOccurrencesOutput);

    }

}

