class TxtTestData {

    @InjectData(name = "TestData.txt")
    public static String DATA = "";

    @BeforeTest
    @InjectData(name = "retrieveGamesValidInputs.txt")
    public static String retrieveGamesValidInputs = "";

    @BeforeTest
    @InjectData(name = "retrieveGamesInvalidInputs.txt")
    public static String retrieveGamesInvalidInputs = "";

    @DeleteFileBefore
    @InjectData(name = "purchaseTicketsWritingToEmptyFile.txt")
    public static String purchaseTicketsWritingToEmptyFile = "";

    @BeforeTest
    @InjectData(name = "purchaseTicketsAppend.txt")
    public static String purchaseTicketsAppend = "";

    @BeforeTest
    @InjectData(name = "purchaseTicketsAppendOutput.txt")
    public static String purchaseTicketsAppendOutput = "";

    @BeforeTest
    @InjectData(name = "findTicketsOneOccurrence.txt")
    public static String findTicketsOneOccurrence = "";

    @BeforeTest
    @InjectData(name = "findTicketsSeveralOccurrences.txt")
    public static String findTicketsSeveralOccurrences = "";

    @BeforeTest
    @InjectData(name = "findTicketsAdjacentOccurrences.txt")
    public static String findTicketsAdjacentOccurrences = "";
}