class TxtTestData {
    
    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "retrieveGamesValidInputs.txt")
    public static String retrieveGamesValidInputs = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "retrieveGamesInvalidInputs.txt")
    public static String retrieveGamesInvalidInputs = "";

    @DeleteFileAfter
    @DeleteFileBefore
    @InjectData(name = "purchaseTicketsWritingToEmptyFile.txt")
    public static String purchaseTicketsWritingToEmptyFile = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "purchaseTicketsAppend.txt")
    public static String purchaseTicketsAppend = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "purchaseTicketsAppendOutput.txt")
    public static String purchaseTicketsAppendOutput = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "purchaseTicketsZeroSeats.txt")
    public static String purchaseTicketsZeroSeats = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "purchaseTicketsZeroSeatsOutput.txt")
    public static String purchaseTicketsZeroSeatsOutput = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "purchaseTicketsInvalidGame.txt")
    public static String purchaseTicketsInvalidGame = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "findTicketsOneOccurrence.txt")
    public static String findTicketsOneOccurrence = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "findTicketsSeveralOccurrences.txt")
    public static String findTicketsSeveralOccurrences = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "findTicketsAdjacentOccurrences.txt")
    public static String findTicketsAdjacentOccurrences = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "attendGameNoOccurrences.txt")
    public static String attendGameNoOccurrences = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "attendGameSeveralOccurrences.txt")
    public static String attendGameSeveralOccurrences = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "attendGameSeveralOccurrencesOutput.txt")
    public static String attendGameSeveralOccurrencesOutput = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "attendGameAdjacentOccurrences.txt")
    public static String attendGameAdjacentOccurrences = "";

    @DeleteFileAfter
    @BeforeTest
    @InjectData(name = "attendGameAdjacentOccurrencesOutput.txt")
    public static String attendGameAdjacentOccurrencesOutput = "";

}