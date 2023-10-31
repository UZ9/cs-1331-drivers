public class GenreTests {
    @TestCase(name = "Testing that all 7 genres exist in the correct order...")
    @Tip(description = "\nHow many genres should there be? What order should they be in?")
    public void genresExistInCorrectOrder() throws TestFailedException {

        String[] correctGenres = new String[] {
            "ACTION",
            "COMEDY",
            "FANTASY",
            "HORROR",
            "MYSTERY",
            "ROMANCE",
            "SCI_FI"};
        Genre[] genres = Genre.values();

        for (int i = 0; i < 7; i++) {
            TestFunction.assertEqual(genres[i].toString(), correctGenres[i]);
        }
    }
}
