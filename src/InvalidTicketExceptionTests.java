public class InvalidTicketExceptionTests {
    
    @TestCase(name = "Constructor: No arg constructor")
    @Tip(description = "What should the InvalidTicketException's message default to?")
    public void constructorNoArg() throws TestFailedException {
        
        InvalidTicketException ite = new InvalidTicketException();
        TestFunction.assertEqual(ite.getMessage(), "Invalid ticket");

    }

    @TestCase(name = "Constructor: One arg constructor")
    @Tip(description = "Make sure that you set the Exception's message. Does the superclass have a constructor you can chain?")
    public void constructorOneArg() throws TestFailedException {
        
        InvalidTicketException ite = new InvalidTicketException("Specific error message.");
        TestFunction.assertEqual(ite.getMessage(), "Specific error message.");

    }

    @TestCase(name = "Check for correct extension")
    @Tip(description = "What class should InvalidTicketException extend?")
    public void correctExtension() throws TestFailedException {
        
        Exception ite = new InvalidTicketException();
        TestFunction.assertEqual(ite instanceof RuntimeException, false);

    }

}
