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
}