import java.lang.reflect.Field;
import java.util.ArrayList;

public class BlockbusterTests {

    static final ArrayList<Media> MOVIE_LIST = new ArrayList<Media>() {
        {
            add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 5", 78, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 6", 71, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 7", 81, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 8", 67, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 9", 59, 6.70, 120));
            add(new Movie(Genre.ACTION, "Fast and Furious 10", 56, 6.70, 120));
        }
    };

    static final ArrayList<Media> GAME_LIST = new ArrayList<Media>() {
        {
            add(new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 5", 78, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 6", 71, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 7", 81, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 8", 67, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 9", 59, 6.70, 2, false));
            add(new VideoGame(Genre.ACTION, "Uncharted 10", 56, 6.70, 2, true));
        }
    };

    @TestCase(name = "Testing the addMedia() method")
    @Tip(description = "What order should media be added?")
    public void addMediaInOrder() throws TestFailedException {

        Blockbuster store = new Blockbuster();
        for (int i = 0; i < MOVIE_LIST.size(); i++) {
            store.addMedia(MOVIE_LIST.get(i));
        }

        String expectedString = ""
            + "Genre: ACTION, Name: Fast and Furious 1, Rating: 54, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 2, Rating: 37, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 3, Rating: 38, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 4, Rating: 28, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 5, Rating: 78, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 6, Rating: 71, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 7, Rating: 81, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 8, Rating: 67, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 9, Rating: 59, Rental Price: $6.70, Runtime: 120\n"
            + "Genre: ACTION, Name: Fast and Furious 10, Rating: 56, Rental Price: $6.70, Runtime: 120";

        TestFunction.assertEqual(arrayToString(getInventory(store)), expectedString);
    }

    @TestCase(name = ".removeMedia(): Media not found")
    @Tip(description = "If the Media isn't found, what should removeMedia() return?")
    public void removeMediaMediaNotFound() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(GAME_LIST);
        VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter", 0);

        Media removed = store.removeMedia(game);

        if (removed == null) {
            TestFunction.assertEqual("null", "null");
        } else {
            TestFunction.assertEqual(removed.toString(), "null");
        }
    }

    @TestCase(name = ".removeMedia(): Does NOT return the original media")
    @Tip(description = "Even though the two are .equals(), make sure you return the one that is removed, not the original!")
    public void removeMediaMediaFoundDifferentReturn() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(GAME_LIST);
        Movie game = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);

        Media removed = store.removeMedia(game);

        TestFunction.assertEqual(game == removed, false);
    }

    @TestCase(name = ".removeMedia(): Returns the found Media")
    @Tip(description = "Which fields should be compared? (all of them should be!)")
    public void removeMediaMediaFound() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(MOVIE_LIST);
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);

        Media removed = store.removeMedia(movie);

        if (removed == null) {
            TestFunction.assertEqual(null, "Genre: ACTION, Name: Fast and Furious 1, Rating: 54, Rental Price: $6.70, Runtime: 120");
        } else {
            TestFunction.assertEqual(removed.toString(), "Genre: ACTION, Name: Fast and Furious 1, Rating: 54, Rental Price: $6.70, Runtime: 120");
        }
    }

    @TestCase(name = ".removeMedia(): Runtime differs, should return null")
    @Tip(description = "Which fields should be compared? (all of them should be!)")
    public void removeMediaNotFound() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(MOVIE_LIST);
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 130);

        Media removed = store.removeMedia(movie);

        if (removed == null) {
            TestFunction.assertEqual(null, (String) null);
        } else {
            TestFunction.assertEqual(removed.toString(), null);
        }
    }

    @TestCase(name = ".sort(): Sorts by title")
    @Tip(description = "What order should Media be compared by? Which fields should be compared? Which fields shouldn't be compared?")
    public void sortMediaByTitle() throws TestFailedException {
        ArrayList<Media> GAME_LIST = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 5", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 8", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 1", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 6", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 9", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 7", 10, 6.70, 2, false));
            }
        };

        Blockbuster store = fakeConstructorBlockbuster(GAME_LIST);
        store.sortMedia();
        ArrayList<Media> inventory = getInventory(store);
        String expectedString = ""
            + "Genre: ACTION, Name: Uncharted 1, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 2, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 3, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 4, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 5, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 6, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 7, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 8, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted 9, Rating: 10, Rental Price: $6.70, Players: 2, does not need console";

        TestFunction.assertEqual(arrayToString(inventory), expectedString);
    }

    @TestCase(name = ".sort(): Sorts by genre")
    @Tip(description = "What order should Media be compared by? Which fields should be compared? Which fields shouldn't be compared?")
    public void sortMediaByGenre() throws TestFailedException {
        ArrayList<Media> GAME_LIST = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.SCI_FI, "Uncharted 5", 10, 6.70, 2, false));
                add(new VideoGame(Genre.HORROR, "Uncharted 2", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ROMANCE, "Uncharted 4", 10, 6.70, 2, false));
                add(new VideoGame(Genre.FANTASY, "Uncharted 1", 10, 6.70, 2, false));
                add(new VideoGame(Genre.COMEDY, "Uncharted 6", 10, 6.70, 2, false));
                add(new VideoGame(Genre.MYSTERY, "Uncharted 3", 10, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 7", 10, 6.70, 2, false));
            }
        };

        Blockbuster store = fakeConstructorBlockbuster(GAME_LIST);
        store.sortMedia();
        ArrayList<Media> inventory = getInventory(store);
        String expectedString = ""
            + "Genre: ACTION, Name: Uncharted 7, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: COMEDY, Name: Uncharted 6, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: FANTASY, Name: Uncharted 1, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: HORROR, Name: Uncharted 2, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: MYSTERY, Name: Uncharted 3, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ROMANCE, Name: Uncharted 4, Rating: 10, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: SCI_FI, Name: Uncharted 5, Rating: 10, Rental Price: $6.70, Players: 2, does not need console";

        TestFunction.assertEqual(arrayToString(inventory), expectedString);
    }

    @TestCase(name = ".sort(): Sorts by rating")
    @Tip(description = "What order should Media be compared by? Which fields should be compared? Which fields shouldn't be compared?")
    public void sortMediaByRating() throws TestFailedException {
        ArrayList<Media> GAME_LIST = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted", 5, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted", 2, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted", 6, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted", 3, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted", 4, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted", 7, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted", 1, 6.70, 2, false));
            }
        };

        Blockbuster store = fakeConstructorBlockbuster(GAME_LIST);
        store.sortMedia();
        ArrayList<Media> inventory = getInventory(store);
        String expectedString = ""
            + "Genre: ACTION, Name: Uncharted, Rating: 1, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted, Rating: 2, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted, Rating: 3, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted, Rating: 4, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted, Rating: 5, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted, Rating: 6, Rental Price: $6.70, Players: 2, does not need console\n"
            + "Genre: ACTION, Name: Uncharted, Rating: 7, Rental Price: $6.70, Players: 2, does not need console";

        TestFunction.assertEqual(arrayToString(inventory), expectedString);
    }

    @TestCase(name = ".findMedia(): Media to find is equal")
    @Tip(description = "What fields should be compared? What fields SHOULDN'T be compared?\nNOTE: This test only works if .sort() works correctly!")
    public void findMediaMediaEqual() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(MOVIE_LIST);
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);
        store.sortMedia();
        Media found = store.findMedia(movie);

        TestFunction.assertEqual(found == null ? null : found.toString(), "Genre: ACTION, Name: Fast and Furious 1, Rating: 54, Rental Price: $6.70, Runtime: 120");
    }

    @TestCase(name = ".findMedia(): Media should be found, but rentalPrice and runtime differ")
    @Tip(description = "What fields should be compared? What fields SHOULDN'T be compared?\nFor more rationale on why this test is included, see https://edstem.org/us/courses/42939/discussion/3721454?comment=8697564\nNOTE: This test only works if .sort() works correctly!")
    public void findMediaMediaCompareToIsZero() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(MOVIE_LIST);
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.79, 130);

        store.sortMedia();
        Media found = store.findMedia(movie);

        TestFunction.assertEqual(found == null ? null : found.toString(), "Genre: ACTION, Name: Fast and Furious 1, Rating: 54, Rental Price: $6.70, Runtime: 120");
    }

    @TestCase(name = ".findMedia(): Media should not be found")
    @Tip(description = "What fields should be compared? What fields SHOULDN'T be compared?\nNOTE: This test only works if .sort() works correctly!")
    public void findMediaNotFound() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(MOVIE_LIST);
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 11", 54, 6.79, 130);
        store.sortMedia();
        Media found = store.findMedia(movie);
        TestFunction.assertEqual(found == null ? null : found.toString(), null);
    }

    @TestCase(name = ".getMostPopularMovie(): No movie exists in the inventory")
    @Tip(description = "What should getMostPopularMovie() return when there are no movies?")
    public void getMostPopularMovieNotFound() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(GAME_LIST);
        Media found = store.getMostPopularMovie();
        TestFunction.assertEqual(found == null ? (String) null : found.toString(), (String) null);
    }

    @TestCase(name = ".getMostPopularMovie(): Highest rating")
    @Tip(description = "What criteria should getMostPopularMovie() use?")
    public void getMostPopularMovieRatingDiffers() throws TestFailedException {
        Blockbuster store = fakeConstructorBlockbuster(MOVIE_LIST);
        Media found = store.getMostPopularMovie();
        String highestMovie = "Genre: ACTION, Name: Fast and Furious 7, Rating: 81, Rental Price: $6.70, Runtime: 120";

        TestFunction.assertEqual(found == null ? (String) null : found.toString(), highestMovie);
    }

    @TestCase(name = ".getMostPopularMovie(): Name differs")
    @Tip(description = "What criteria should getMostPopularMovie() use?")
    public void getMostPopularMovieNameDiffers() throws TestFailedException {
        ArrayList<Media> modifiedMovieList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 81, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 5", 78, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 6", 71, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 7", 81, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 8", 67, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 9", 59, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 10", 56, 6.70, 120));
            }
        };
        Blockbuster store = fakeConstructorBlockbuster(modifiedMovieList);
        Media found = store.getMostPopularMovie();
        String highestMovie = "Genre: ACTION, Name: Fast and Furious 4, Rating: 81, Rental Price: $6.70, Runtime: 120";
        TestFunction.assertEqual(found == null ? (String) null : found.toString(), highestMovie);
    }



    static Blockbuster fakeConstructorBlockbuster(ArrayList<Media> media) throws TestFailedException {
        Blockbuster store = new Blockbuster();

        Field[] fields = Blockbuster.class.getDeclaredFields();
        Field inventory = null;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName() == "inventory") {
                inventory = fields[i];
                break;
            }
        }
        try {
            inventory.setAccessible(true);
            inventory.set(store, copyArray(media));
        } catch (Exception e) {
            TestFunction.failTest("An error occurred. " + e.getMessage());
        }
        return store;
    }

    private static ArrayList<Media> copyArray(ArrayList<Media> toCopy) {
        ArrayList<Media> newArray = new ArrayList<Media>();
        for (int i = 0; i < toCopy.size(); i++) {
            newArray.add(toCopy.get(i));
        }
        return newArray;
    }

    static String arrayToString(ArrayList<Media> inputs) {
        StringBuilder builder = new StringBuilder();
        if (inputs.size() == 0) {
            return "";
        } else {
            builder.append(inputs.get(0));
        }
        for (int i = 1; i < inputs.size(); i++) {
            builder.append("\n" + inputs.get(i));
        }
        return builder.toString();
    }

    static ArrayList<Media> getInventory(Blockbuster store) {
        Field[] fields = Blockbuster.class.getDeclaredFields();
        Field inventory = null;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName() == "inventory") {
                inventory = fields[i];
                break;
            }
        }
        if (inventory != null) {
            try {
                inventory.setAccessible(true);
                return (ArrayList<Media>) inventory.get(store);
            } catch (IllegalArgumentException e) {
                System.out.println("Test could not be run.");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("Test could not be run.");
                e.printStackTrace();
            }
        }
        return null;
    }
}
