public class GenreTests {
    @TestCase(name = "Constructor: Valid inputs passed in.")
    @Tip(description = "\nMake sure there isn't any field shadowing in your constructor!\nWhat should numberOfRobberies default to?")
    public void constructorThreeArgs() throws TestFailedException {

        Ghost ghost = new Ghost("Yoon", 6, 7);
        String string = ghost.toString();

        TestFunction.assertEqual(string, "Yoon/6/7/0");
    }
}
