public class MovieTests {

    private static final String[] NAMES = new String[] {"Lord of the Rings 1", "Lord of the Rings 2", "Lord of the Rings 3"};
    private static final int[] RATINGS = new int[] {7, 8, 9};
    private static final double[] PRICES = new double[] {9.71, 9.72, 9.73};
    private static final int[] RUNTIMES = new int[] {119, 120, 121};


    @TestCase(name = "Testing the default 5-arg constructor")
    @Tip(description = "What args should the constructor receive?")
    public void fourArgConstructor() throws TestFailedException {

        Movie movie = new Movie(Genre.ACTION, "MyMovie", 18, 6.70, 120);

        TestFunction.assertEqual(movie.toString(), "Genre: ACTION, Name: MyMovie, Rating: 18, Rental Price: $6.70, Runtime: 120");
    }

    @TestCase(name = "Testing the default 3-arg constructor")
    @Tip(description = "What args should the constructor receive? What should rentalPrice and runtime default to?")
    public void threeArgConstructor() throws TestFailedException {

        Movie movie = new Movie(Genre.ACTION, "My Movie 2", 18);

        TestFunction.assertEqual(movie.toString(), "Genre: ACTION, Name: My Movie 2, Rating: 18, Rental Price: $5.00, Runtime: 111");
    }

    @TestCase(name = ".equals(): Parameters are equal")
    @Tip(description = "What fields must be equal for Movies to be equal?")
    public void equalsEquals() throws TestFailedException {

        Movie movie1 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);
        Movie movie2 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);

        TestFunction.assertEqual(movie1.equals(movie2), true);
    }

    @TestCase(name = ".equals(): Genres are not equal")
    @Tip(description = "What fields must be equal for Movies to be equal?")
    public void equalsGenreNotEqual() throws TestFailedException {

        Movie movie1 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);
        Movie movie2 = new Movie(Genre.COMEDY, "My Movie 2", 18, 6.70, 120);

        TestFunction.assertEqual(movie1.equals(movie2), false);
    }

    @TestCase(name = ".equals(): Titles are not equal")
    @Tip(description = "What fields must be equal for Movies to be equal?")
    public void equalsTitlesNotEqual() throws TestFailedException {

        Movie movie1 = new Movie(Genre.ACTION, "My Movie 1", 18, 6.70, 120);
        Movie movie2 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);

        TestFunction.assertEqual(movie1.equals(movie2), false);
    }

    @TestCase(name = ".equals(): Ratings are not equal")
    @Tip(description = "What fields must be equal for Movies to be equal?")
    public void equalsRatingsNotEqual() throws TestFailedException {

        Movie movie1 = new Movie(Genre.ACTION, "My Movie 2", 19, 6.70, 120);
        Movie movie2 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);

        TestFunction.assertEqual(movie1.equals(movie2), false);
    }

    @TestCase(name = ".equals(): RentalPrices are not equal")
    @Tip(description = "What fields must be equal for Movies to be equal?")
    public void equalsRentalPriceNotEqual() throws TestFailedException {

        Movie movie1 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.71, 120);
        Movie movie2 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);

        TestFunction.assertEqual(movie1.equals(movie2), false);
    }

    @TestCase(name = ".equals(): runtimes are not equal")
    @Tip(description = "What fields must be equal for Movies to be equal?")
    public void equalsRuntimesNotEqual() throws TestFailedException {

        Movie movie1 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.71, 121);
        Movie movie2 = new Movie(Genre.ACTION, "My Movie 2", 18, 6.70, 120);

        TestFunction.assertEqual(movie1.equals(movie2), false);
    }

    @TestCase(name = ".compareTo(): Tests many different possible Movies")
    @Tip(description = "What fields should compareTo() compare? Which fields should compareTo() NOT compare?")
    public void compareToTest() throws TestFailedException {

        Movie[] moviePossibilities = getPossibleMoviesForEquals();
        int[] correctAnswers = new int[] {
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };

        Movie media1 = new Movie(Genre.COMEDY, "Lord of the Rings 2", 8, 9.72, 120);
        for (int i = 0; i < moviePossibilities.length; i++) {
            Movie media2 = moviePossibilities[i];
            int comparison = media1.compareTo(media2);
            if (comparison != correctAnswers[i]) {
                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " COMPARETO() TEST FAILED: \u00BB ") + "\nWhen the implicit Media is \""
                        + media1.toString() + "\" and the other Media is \""
                        + media2.toString() + "\"");

                TestFunction.assertEqual(TestUtils.signOf(media1.compareTo(media2)), correctAnswers[i]);
            }
        }
    }

    /**
     * Returns 81 possible media. This is generalizeable, but it's only for the compareTo() check, so I'm OK with hard-coding some values,
     * in exchange for improved readability.
     * @return
     */
    private Movie[] getPossibleMoviesForEquals() {

        Movie[] possibilities = new Movie[81];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        possibilities[i * 27 + j * 9 + k * 3 + l] = new Movie(Genre.COMEDY, NAMES[i], RATINGS[j], PRICES[k], RUNTIMES[l]);
                    }
                }
            }
        }

        return possibilities;
    }



    /**
     * Media subclass, just for testing.
     */
    class MediaSubclass extends Media {
        public MediaSubclass(Genre genre, String name, int rating, double rentalPrice) {
            super(genre, name, rating, rentalPrice);
        }

        public MediaSubclass(Genre genre, String name, int rating) {
            super(genre, name, rating);
        }
    }
}