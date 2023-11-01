public class MediaTests {

    private static final Genre[] GENRES = new Genre[] {Genre.ACTION, Genre.COMEDY, Genre.FANTASY};
    private static final String[] NAMES = new String[] {"Lord of the Rings 1", "Lord of the Rings 2", "Lord of the Rings 3"};
    private static final int[] RATINGS = new int[] {7, 8, 9};
    private static final double[] PRICES = new double[] {9.71, 9.72, 9.73};


    @TestCase(name = "Testing the default 4-arg constructor")
    @Tip(description = "What args should the constructor receive?")
    public void fourArgConstructor() throws TestFailedException {

        Media media = new MediaSubclass(Genre.ACTION, "MyMovie", 18, 6.70);

        TestFunction.assertEqual(media.toString(), "Genre: ACTION, Name: MyMovie, Rating: 18, Rental Price: $6.70");
    }

    @TestCase(name = "Testing the default 3-arg constructor")
    @Tip(description = "What args should the constructor receive? What should rentalPrice default to?")
    public void threeArgConstructor() throws TestFailedException {

        Media media = new MediaSubclass(Genre.ACTION, "My Movie 2", 18);

        TestFunction.assertEqual(media.toString(), "Genre: ACTION, Name: My Movie 2, Rating: 18, Rental Price: $7.00");
    }

    @TestCase(name = ".equals(): Parameters are equal")
    @Tip(description = "What fields must be equal for Media to be equal?")
    public void equalsEquals() throws TestFailedException {

        Media media1 = new MediaSubclass(Genre.ACTION, "My Movie 2", 18, 6.70);
        Media media2 = new MediaSubclass(Genre.ACTION, "My Movie 2", 18, 6.70);

        TestFunction.assertEqual(media1.equals(media2), true);
    }

    @TestCase(name = ".equals(): Genres are not equal")
    @Tip(description = "What fields must be equal for Media to be equal?")
    public void equalsGenreNotEqual() throws TestFailedException {

        Media media1 = new MediaSubclass(Genre.ACTION, "My Movie 2", 18, 6.70);
        Media media2 = new MediaSubclass(Genre.COMEDY, "My Movie 2", 18, 6.70);

        TestFunction.assertEqual(media1.equals(media2), false);
    }

    @TestCase(name = ".equals(): Titles are not equal")
    @Tip(description = "What fields must be equal for Media to be equal?")
    public void equalsTitlesNotEqual() throws TestFailedException {

        Media media1 = new MediaSubclass(Genre.ACTION, "My Movie 1", 18, 6.70);
        Media media2 = new MediaSubclass(Genre.ACTION, "My Movie 2", 18, 6.70);

        TestFunction.assertEqual(media1.equals(media2), false);
    }

    @TestCase(name = ".equals(): Ratings are not equal")
    @Tip(description = "What fields must be equal for Media to be equal?")
    public void equalsRatingsNotEqual() throws TestFailedException {

        Media media1 = new MediaSubclass(Genre.ACTION, "My Movie 1", 19, 6.70);
        Media media2 = new MediaSubclass(Genre.ACTION, "My Movie 2", 18, 6.70);

        TestFunction.assertEqual(media1.equals(media2), false);
    }

    @TestCase(name = ".equals(): RentalPrices are not equal")
    @Tip(description = "What fields must be equal for Media to be equal?")
    public void equalsRentalPriceNotEqual() throws TestFailedException {

        Media media1 = new MediaSubclass(Genre.ACTION, "My Movie 1", 19, 9.71);
        Media media2 = new MediaSubclass(Genre.ACTION, "My Movie 2", 18, 6.70);

        TestFunction.assertEqual(media1.equals(media2), false);
    }

    @TestCase(name = ".compareTo(): Tests many different possible Media")
    @Tip(description = "What fields should compareTo() compare? Which fields should compareTo() NOT compare?")
    public void compareToTest() throws TestFailedException {

        Media[] mediaPossibilities = getPossibleMediaForEquals();
        int[] correctAnswers = new int[] {
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 0, 0, 0, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };

        Media media1 = new MediaSubclass(Genre.COMEDY, "Lord of the Rings 2", 8, 9.72);
        for (int i = 0; i < mediaPossibilities.length; i++) {
            Media media2 = mediaPossibilities[i];
            int comparison = media1.compareTo(media2);
            if (comparison != correctAnswers[i]) {
                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " COMPARETO() TEST FAILED: \u00BB ") + "\nWhen the implicit Media is\n\""
                        + media1.toString() + "\" and the other Media is\n\""
                        + media2.toString() + "\"");

                TestFunction.assertEqual(TestUtils.signOf(media1.compareTo(media2)), correctAnswers[i]);
            }
        }
    }

    @TestCase(name = ".compareTo(): Tests for transitivity (not correctness)")
    @Tip(description = "Read the Java 11 compareTo() documentation for info on transitivity.\n"
               + "\t      If x.compareTo(y) > 0 and y.compareTo(z) > 0, then x.compareTo(z) MUST be > 0.\n"
               + "\t      This method checks MANY combinations of ages and numCandys for transitivity.\n")
    public void compareToTransitivityTest() throws TestFailedException {

        Media[] mediaPossibilities = getPossibleMediaForEquals();

        for (int i = 0; i < mediaPossibilities.length; i++) {
            for (int j = 0; j < mediaPossibilities.length; j++) {
                for (int k = 0; k < mediaPossibilities.length; k++) {
                    Media media1 = mediaPossibilities[i];
                    Media media2 = mediaPossibilities[j];
                    Media media3 = mediaPossibilities[k];
                    String string1 = media1.toString();
                    String string2 = media2.toString();
                    String string3 = media3.toString();

                    if (media1.compareTo(media2) > 0 && media2.compareTo(media3) > 0 && media1.compareTo(media3) <= 0) { // This comes directly from the compareTo docs
                        System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " TRANSITIVITY TEST FAILED: \u00BB ") + "\nWhen "
                                + "x = \"" + string1 + "\", y = \"" + string2 + "\", z = \"" + string3 + "\"");
                        TestFunction.assertEqual(TestUtils.signOf(media1.compareTo(media3)), 1);
                    }
                }
            }
        }
    }

    /**
     * Returns 81 possible media. This is generalizeable, but it's only for the compareTo() check, so I'm OK with hard-coding some values,
     * in exchange for improved readability.
     * @return
     */
    private Media[] getPossibleMediaForEquals() {

        Media[] possibilities = new Media[81];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        possibilities[i * 27 + j * 9 + k * 3 + l] = new MediaSubclass(GENRES[i], NAMES[j], RATINGS[k], PRICES[l]);
                    }
                }
            }
        }

        return possibilities;
    }



    /**
     * Media subclass, just for testing.
     */
    static class MediaSubclass extends Media {
        public MediaSubclass(Genre genre, String name, int rating, double rentalPrice) {
            super(genre, name, rating, rentalPrice);
        }

        public MediaSubclass(Genre genre, String name, int rating) {
            super(genre, name, rating);
        }
    }
}