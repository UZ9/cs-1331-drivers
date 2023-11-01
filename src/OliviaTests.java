import java.lang.reflect.Field;
import java.util.ArrayList;

public class OliviaTests {
    @TestCase(name = ".addToCart(): Correct movie is found")
    @Tip(description = "What should be in the cart after the specified Media is found?")
    public void addToCartAddedToCart() throws TestFailedException {

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(BlockbusterTests.MOVIE_LIST);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);
        olivia.addToCart(movie, store);

        TestFunction.assertEqual(BlockbusterTests.arrayToString(getCart(olivia)), "Genre: ACTION, Name: Fast and Furious 1, Rating: 54, Rental Price: $6.70, Runtime: 120");
    }

    @TestCase(name = ".addToCart(): Correct movie is removed from the store")
    @Tip(description = "Make sure that the correct Media is removed from the store!")
    public void addToCartRemovedFromStore() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);
        olivia.addToCart(movie, store);

        TestFunction.assertEqual(BlockbusterTests.arrayToString(BlockbusterTests.getInventory(store)), "Genre: ACTION, Name: Fast and Furious 2, Rating: 37, Rental Price: $6.70, Runtime: 120\nGenre: ACTION, Name: Fast and Furious 3, Rating: 38, Rental Price: $6.70, Runtime: 120\nGenre: ACTION, Name: Fast and Furious 4, Rating: 28, Rental Price: $6.70, Runtime: 120");
    }

    @TestCase(name = ".addToCart(): Correct movie is added to the cart")
    @Tip(description = "If the test \".addToCart(): Correct movie is removed from the store\" is passing, make sure that you're adding the object from the store, not the one passed into addToCart()!")
    public void addToCartCopyIsAdded() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);
        olivia.addToCart(movie, store);

        TestFunction.assertEqual(movie == getCart(olivia).get(0) && getCart(olivia).get(0) != null, false);
    }

    @TestCase(name = ".addToCart(): Returns true when movie is added to the cart")
    @Tip(description = "What should addToCart() return?")
    public void addToCartReturnsTrue() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);
        boolean returned = olivia.addToCart(movie, store);

        TestFunction.assertEqual(returned, true);
    }

    @TestCase(name = ".addToCart(): Updates budget when movie is added to the cart")
    @Tip(description = "What should get deducted from Olivia's budget?")
    public void addToCartBudgetUpdates() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 6.70, 120);
        olivia.addToCart(movie, store);
        double budget = getBudget(olivia);

        TestFunction.assertEqual(budget, 13.30);
    }

    @TestCase(name = ".addToCart(): Returns false when Media is not found")
    @Tip(description = "What should addToCart() return?")
    public void addToCartReturnsFalse() throws TestFailedException {

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(BlockbusterTests.MOVIE_LIST);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 11", 54, 6.70, 120);
        boolean returned = olivia.addToCart(movie, store);

        TestFunction.assertEqual(returned, false);
    }

    @TestCase(name = ".addToCart(): Returns false when Olivia has an insufficient budget")
    @Tip(description = "What should addToCart() return when Olivia has insufficient budget?")
    public void addToCartReturnsFalseWhenBudget() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 21.0, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 21.0, 120);
        boolean returned = olivia.addToCart(movie, store);

        TestFunction.assertEqual(returned, false);
    }

    @TestCase(name = ".addToCart(): Cart is still empty if budget is insufficient")
    @Tip(description = "What should addToCart() return when Olivia has insufficient budget?")
    public void addToCartHasEmptyCartWhenBudget() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new Movie(Genre.ACTION, "Fast and Furious 1", 54, 21.0, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 2", 37, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 3", 38, 6.70, 120));
                add(new Movie(Genre.ACTION, "Fast and Furious 4", 28, 6.70, 120));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        Movie movie = new Movie(Genre.ACTION, "Fast and Furious 1", 54, 21.0, 120);
        olivia.addToCart(movie, store);
        ArrayList<Media> cart = getCart(olivia);

        TestFunction.assertEqual(BlockbusterTests.arrayToString(cart), "");
    }

    @TestCase(name = ".addToCart(): Cart is still empty if game requires console and Olivia cannot use console")
    @Tip(description = "What should Olivia's cart contain if she couldn't add the Media?")
    public void addToCartCartEmptyWhenConsoleRequired() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true));
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        store.sortMedia();
        Olivia olivia = fakeConstructorOlivia();
        VideoGame game = new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true);
        olivia.addToCart(game, store);
        ArrayList<Media> cart = getCart(olivia);

        TestFunction.assertEqual(BlockbusterTests.arrayToString(cart), "");
    }

    @TestCase(name = ".addToCart(): Returns false when Olivia cannot use console and the VideoGame requires one")
    @Tip(description = "What should addToCart() return when Olivia requires a console?")
    public void addToCartReturnsFalseWhenConsole() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true));
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        Olivia olivia = fakeConstructorOlivia();
        VideoGame game = new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true);
        boolean returned = olivia.addToCart(game, store);

        TestFunction.assertEqual(returned, false);
    }

    @TestCase(name = ".addToCart(): Returns true when Olivia can use console and the VideoGame requires one")
    @Tip(description = "What should addToCart() return when Olivia requires a console?")
    public void addToCartReturnsTrueWhenConsole() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true));
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        Olivia olivia = fakeConstructorOlivia(20.0, new ArrayList<Media>(), true);
        VideoGame game = new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true);
        boolean returned = olivia.addToCart(game, store);

        TestFunction.assertEqual(returned, true);
    }

    @TestCase(name = ".changeMind(): Removes the given media from the cart")
    @Tip(description = "What method should changeMind() use to determine if the Media is in the cart?")
    public void changeMindRemovesFromCart() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        VideoGame game = new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, true);
        Olivia olivia = fakeConstructorOlivia(20.0, new ArrayList<Media>() {{add(game);}}, true);
        olivia.changeMind(game, store);
        ArrayList<Media> cart = getCart(olivia);

        TestFunction.assertEqual(BlockbusterTests.arrayToString(cart), "");
    }

    @TestCase(name = ".changeMind(): Adds the removed media to the store")
    @Tip(description = "Make sure that you're adding the media back from the cart to the store!")
    public void changeMindAddsToStore() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        VideoGame game = new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, false);
        Olivia olivia = fakeConstructorOlivia(20.0, new ArrayList<Media>() {{add(game);}}, true);
        olivia.changeMind(game, store);
        store.sortMedia();
        ArrayList<Media> inventory = BlockbusterTests.getInventory(store);

        TestFunction.assertEqual(BlockbusterTests.arrayToString(inventory), "Genre: ACTION, Name: Uncharted 1, Rating: 54, Rental Price: $6.70, Players: 2, does not need console\nGenre: ACTION, Name: Uncharted 2, Rating: 37, Rental Price: $6.70, Players: 2, does not need console\nGenre: ACTION, Name: Uncharted 3, Rating: 38, Rental Price: $6.70, Players: 2, does not need console\nGenre: ACTION, Name: Uncharted 4, Rating: 28, Rental Price: $6.70, Players: 2, does not need console");
    }

    @TestCase(name = ".changeMind(): Updates budget accordingly")
    @Tip(description = "Make sure that the budget is updated properly!")
    public void changeMindUpdatesBudget() throws TestFailedException {
        ArrayList<Media> modifiedList = new ArrayList<Media>() {
            {
                add(new VideoGame(Genre.ACTION, "Uncharted 2", 37, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 3", 38, 6.70, 2, false));
                add(new VideoGame(Genre.ACTION, "Uncharted 4", 28, 6.70, 2, false));
            }
        };

        Blockbuster store = BlockbusterTests.fakeConstructorBlockbuster(modifiedList);
        VideoGame game = new VideoGame(Genre.ACTION, "Uncharted 1", 54, 6.70, 2, false);
        Olivia olivia = fakeConstructorOlivia(20.0, new ArrayList<Media>() {{add(game);}}, true);
        olivia.changeMind(game, store);
        double budget = getBudget(olivia);

        TestFunction.assertEqual(budget, 26.70);
    }



    private static Olivia fakeConstructorOlivia() throws TestFailedException {
        return fakeConstructorOlivia(20.0, new ArrayList<Media>(), false);
    }

    private static Olivia fakeConstructorOlivia(double budget, ArrayList<Media> cart, boolean canUseConsole) throws TestFailedException {
        Olivia olivia = new Olivia();

        Field[] fields = Olivia.class.getDeclaredFields();
        Field budgetField = null;
        Field cartField = null;
        Field canUseConsoleField = null;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName() == "budget") {
                budgetField = fields[i];
            }
            if (fields[i].getName() == "cart") {
                cartField = fields[i];
            }
            if (fields[i].getName() == "canUseConsole") {
                canUseConsoleField = fields[i];
            }
        }

        try {
            budgetField.setAccessible(true);
            budgetField.set(olivia, budget);
            cartField.setAccessible(true);
            cartField.set(olivia, cart);
            canUseConsoleField.setAccessible(true);
            canUseConsoleField.set(olivia, canUseConsole);
        } catch (Exception e) {
            TestFunction.failTest("An error occurred. " + e.getMessage());
        }

        return olivia;
    }

    private static ArrayList<Media> getCart(Olivia olivia) {
        Field[] fields = Olivia.class.getDeclaredFields();
        Field cart = null;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName() == "cart") {
                cart = fields[i];
                break;
            }
        }
        if (cart != null) {
            try {
                cart.setAccessible(true);
                return (ArrayList<Media>) cart.get(olivia);
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

    private static double getBudget(Olivia olivia) {
        Field[] fields = Olivia.class.getDeclaredFields();
        Field budget = null;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName() == "budget") {
                budget = fields[i];
                break;
            }
        }
        if (budget != null) {
            try {
                budget.setAccessible(true);
                return (double) budget.get(olivia);
            } catch (IllegalArgumentException e) {
                System.out.println("Test could not be run.");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("Test could not be run.");
                e.printStackTrace();
            }
        }
        return -1.0;
    }
}
