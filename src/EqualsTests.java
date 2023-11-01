public class EqualsTests {
    private static final Media[] MEDIA = new Media[] {
        new MediaTests.MediaSubclass(Genre.COMEDY, "Ghostbusters", 99, 6.70),
        new Movie(Genre.COMEDY, "Ghostbusters", 99, 6.70, 120),
        new VideoGame(Genre.ACTION, "Ghostbusters", 99, 6.70, 2, true)
    };

    @TestCase(name = "Testing .equals() method of Media and all subclasses to ensure symmetry (not necessarily correctness)")
    @Tip(description = "\nHow can you ensure symmetry in the .equals() method? What should be compared before each field?")
    public void equalsSymmetryTest() throws TestFailedException {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (MEDIA[i].equals(MEDIA[j]) != MEDIA[j].equals(MEDIA[i])) {
                    System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " SYMMETRY TEST FAILED: \u00BB ") + "\nWhen "
                                + "media1 = \"" + MEDIA[i].toString() + "\", media2 = \"" + MEDIA[j].toString() + "\"");
                    TestFunction.assertEqual(MEDIA[i].equals(MEDIA[j]), MEDIA[j].equals(MEDIA[i]));
                }
            }
        }
    }

    @TestCase(name = "Testing .equals() method of Media and all subclasses for correctness")
    @Tip(description = "\nWhat fields should be compared for the .equals() method? How should .equals() behave when comparing different classes?")
    public void equalsCorrectnessTest() throws TestFailedException {
        boolean[][] correctAnswers = new boolean[][] {{true, false, false}, {false, true, false}, {false, false, true}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (MEDIA[i].equals(MEDIA[j]) != correctAnswers[i][j]) {
                    System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " .EQUALS() TEST FAILED: \u00BB ") + "\nWhen "
                                + "media1 = \"" + MEDIA[i].toString() + "\", media2 = \"" + MEDIA[j].toString() + "\"");
                    TestFunction.assertEqual(MEDIA[i].equals(MEDIA[j]), MEDIA[j].equals(MEDIA[i]));
                }
            }
        }
    }
}